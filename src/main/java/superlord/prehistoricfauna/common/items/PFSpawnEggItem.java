package superlord.prehistoricfauna.common.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.init.PFItems;

public class PFSpawnEggItem extends SpawnEggItem {

	public static final List<PFSpawnEggItem> UNADDED_EGGS = new ArrayList<PFSpawnEggItem>();
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;

	@SuppressWarnings("deprecation")
	public PFSpawnEggItem(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int primaryColour, final int secondaryColour, final Item.Properties properties) {
		super(null, primaryColour, secondaryColour, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		UNADDED_EGGS.add(this);
	}

	@Override
	public Optional<Mob> spawnOffspringFromSpawnEgg(Player p_43216_, Mob p_43217_, EntityType<? extends Mob> p_43218_, ServerLevel p_43219_, Vec3 p_43220_, ItemStack p_43221_) {
		if (!this.spawnsEntity(p_43221_.getTag(), p_43218_)) {
			return Optional.empty();
		} else {
			Mob mob;
			if (p_43217_ instanceof AgeableMob ageable) {
				mob = ((AgeableMob)p_43217_).getBreedOffspring(p_43219_, (AgeableMob)p_43217_);
				//ageable.setAge(-48000);
			} else {
				mob = p_43218_.create(p_43219_);
			}

			if (mob == null) {
				return Optional.empty();
			} else {
				// mob.setBaby(true);
				if (mob instanceof Triceratops || mob instanceof Tyrannosaurus) {
					((AgeableMob)mob).setAge(-48000);
				} else if (mob instanceof Camarasaurus) {
					((AgeableMob)mob).setAge(-72000);
				} else {
					((AgeableMob)mob).setAge(-24000);
				}
				if (!mob.isBaby()) {
					return Optional.empty();
				} else {
					mob.moveTo(p_43220_.x(), p_43220_.y(), p_43220_.z(), 0.0F, 0.0F);
					p_43219_.addFreshEntityWithPassengers(mob);
					if (p_43221_.hasCustomHoverName()) {
						mob.setCustomName(p_43221_.getHoverName());
					}

					if (!p_43216_.getAbilities().instabuild) {
						p_43221_.shrink(1);
					}

					return Optional.of(mob);
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public PFSpawnEggItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int primaryColour, final int secondaryColour, final Item.Properties properties) {
		super(null, primaryColour, secondaryColour, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		UNADDED_EGGS.add(this);
	}

	public static void initSpawnEggs() {
		final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "f_43201_");
		DefaultDispenseItemBehavior dispenseBehaviour = new DefaultDispenseItemBehavior() {
			@Override
			protected ItemStack execute(BlockSource source, ItemStack stack) {
				Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
				EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
				type.spawn(source.getLevel(), stack, null, source.getPos().relative(direction), MobSpawnType.DISPENSER, direction != Direction.UP, false);
				stack.shrink(1);
				return stack;
			}
		};

		for (final SpawnEggItem spawnEgg : UNADDED_EGGS) {
			EGGS.put(spawnEgg.getType(null), spawnEgg);
			DispenserBlock.registerBehavior(spawnEgg, dispenseBehaviour);
		}
		UNADDED_EGGS.clear();
	}

	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if (stack.getItem() == PFItems.THESCELOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.THORACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ACIPENSER_SPAWN_EGG.get() || stack.getItem() == PFItems.LONCHIDION_SPAWN_EGG.get() || stack.getItem() == PFItems.MELVIUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ANKYLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRICERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYRANNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DIDELPHODON_SPAWN_EGG.get() || stack.getItem() == PFItems.BASILEMYS_SPAWN_EGG.get() || stack.getItem() == PFItems.DAKOTARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.MYLEDAPHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GAR_SPAWN_EGG.get() || stack.getItem() == PFItems.CYCLURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PALAEOSANIWA_SPAWN_EGG.get() || stack.getItem() == PFItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ORNITHOMIMUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslatableComponent("hell_creek").withStyle(ChatFormatting.GRAY));
			tooltip.add(new TranslatableComponent("cretaceous").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.DRYOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.EILENODON_SPAWN_EGG.get() || stack.getItem() == PFItems.STEGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMARASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HESPERORNITHOIDES_SPAWN_EGG.get() || stack.getItem() == PFItems.CERATOSAURUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslatableComponent("morrison").withStyle(ChatFormatting.GRAY));
			tooltip.add(new TranslatableComponent("jurassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.SAUROSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SILLOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.EXAERETODON_SPAWN_EGG.get() || stack.getItem() == PFItems.HYPERODAPEDON_SPAWN_EGG.get() || stack.getItem() == PFItems.ISCHIGUALASTIA_SPAWN_EGG.get() || stack.getItem() == PFItems.HERRERASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CHROMOGISAURUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslatableComponent("ischigualasto").withStyle(ChatFormatting.GRAY));
			tooltip.add(new TranslatableComponent("triassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.CERATODUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("mki").withStyle(ChatFormatting.GRAY));
				tooltip.add(new TranslatableComponent("jt").withStyle(ChatFormatting.DARK_GRAY));
			} else {
				tooltip.add(new TranslatableComponent("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		} else if (stack.getItem() == PFItems.PROTOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.VELOCIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.CITIPATI_SPAWN_EGG.get() || stack.getItem() == PFItems.AEPYORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TELMASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PINACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLESIOHADROS_SPAWN_EGG.get() || stack.getItem() == PFItems.OVIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.DERMESTID_BEETLE_SPAWN_EGG.get() || stack.getItem() == PFItems.GOBIULUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HARENAICHTHYS_SPAWN_EGG.get() || stack.getItem() == PFItems.UDANOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.HALSZKARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.GOYOCEPHALE_SPAWN_EGG.get() || stack.getItem() == PFItems.KOL_SPAWN_EGG.get()) {
			tooltip.add(new TranslatableComponent("djadochta").withStyle(ChatFormatting.GRAY));
			tooltip.add(new TranslatableComponent("cretaceous").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.DILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTATHERIUM_SPAWN_EGG.get() || stack.getItem() == PFItems.MEGAPNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SARAHSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCELIDOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCUTELLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CALSOYASUCHUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslatableComponent("kayenta").withStyle(ChatFormatting.GRAY));
			tooltip.add(new TranslatableComponent("jurassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.ARGANODUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CHINLEA_SPAWN_EGG.get() || stack.getItem() == PFItems.MOOREODONTUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SAURICHTHYS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DESMATOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POSTOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.COELOPHYSIS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLACERIAS_SPAWN_EGG.get() || stack.getItem() == PFItems.POPOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYPOTHORAX_SPAWN_EGG.get()) {
			tooltip.add(new TranslatableComponent("chinle").withStyle(ChatFormatting.GRAY));
			tooltip.add(new TranslatableComponent("triassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.POTAMOCERATODUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslatableComponent("mk").withStyle(ChatFormatting.GRAY));
			tooltip.add(new TranslatableComponent("jurassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.YUTYRANNUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PSITTACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SINOSAUROPTERYX_SPAWN_EGG.get() || stack.getItem() == PFItems.INCISIVOSAURUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslatableComponent("yixian").withStyle(ChatFormatting.GRAY));
			tooltip.add(new TranslatableComponent("cretaceous").withStyle(ChatFormatting.DARK_GRAY));
		}
		if (stack.getItem() == PFItems.TYRANNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SAUROSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POSTOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POPOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HESPERORNITHOIDES_SPAWN_EGG.get() || stack.getItem() == PFItems.HERRERASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DAKOTARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.CERATOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.VELOCIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.MEGAPNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.COELOPHYSIS_SPAWN_EGG.get() || stack.getItem() == PFItems.PALAEOSANIWA_SPAWN_EGG.get() || stack.getItem() == PFItems.YUTYRANNUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SINOSAUROPTERYX_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("carnivore").withStyle(ChatFormatting.RED));
			}
		}
		if (stack.getItem() == PFItems.TRICERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCUTELLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCELIDOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.STEGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.AEPYORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SARAHSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SILLOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ISCHIGUALASTIA_SPAWN_EGG.get() || stack.getItem() == PFItems.DESMATOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ANKYLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.THESCELOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BASILEMYS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMARASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DRYOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PINACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLESIOHADROS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTATHERIUM_SPAWN_EGG.get() || stack.getItem() == PFItems.HYPERODAPEDON_SPAWN_EGG.get() || stack.getItem() == PFItems.EILENODON_SPAWN_EGG.get() || stack.getItem() == PFItems.PROTOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYPOTHORAX_SPAWN_EGG.get() || stack.getItem() == PFItems.PLACERIAS_SPAWN_EGG.get() || stack.getItem() == PFItems.EXAERETODON_SPAWN_EGG.get() || stack.getItem() == PFItems.UDANOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GOYOCEPHALE_SPAWN_EGG.get() || stack.getItem() == PFItems.PSITTACOSAURUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("herbivore").withStyle(ChatFormatting.DARK_GREEN));
			}
		}
		if (stack.getItem() == PFItems.CITIPATI_SPAWN_EGG.get() || stack.getItem() == PFItems.CHROMOGISAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.OVIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.ORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.INCISIVOSAURUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("omnivore").withStyle(ChatFormatting.YELLOW));
			}
		}
		if (stack.getItem() == PFItems.TELMASAURUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("ovivore").withStyle(ChatFormatting.WHITE));
			}
		}
		if (stack.getItem() == PFItems.DIDELPHODON_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("molluscivore").withStyle(ChatFormatting.DARK_PURPLE));
			}
		}
		if (stack.getItem() == PFItems.KOL_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("insectivore").withStyle(ChatFormatting.GREEN));
			}
		}
		if (stack.getItem() == PFItems.CALSOYASUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.THORACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HALSZKARAPTOR_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("piscivore").withStyle(ChatFormatting.DARK_AQUA));
			}
		}
		if (stack.getItem() == PFItems.TYRANNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCELIDOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRICERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.STEGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.AEPYORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SARAHSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CALSOYASUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SAUROSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SILLOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ISCHIGUALASTIA_SPAWN_EGG.get() || stack.getItem() == PFItems.CHROMOGISAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POSTOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POPOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DESMATOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLACERIAS_SPAWN_EGG.get() || stack.getItem() == PFItems.UDANOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.ORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.YUTYRANNUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("cathemeral").withStyle(ChatFormatting.GREEN));
			} else {
				tooltip.add(new TranslatableComponent("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		}
		if (stack.getItem() == PFItems.ANKYLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.THESCELOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BASILEMYS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMARASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DRYOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HESPERORNITHOIDES_SPAWN_EGG.get() || stack.getItem() == PFItems.PINACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLESIOHADROS_SPAWN_EGG.get() || stack.getItem() == PFItems.CITIPATI_SPAWN_EGG.get() || stack.getItem() == PFItems.TELMASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HERRERASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.OVIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.HALSZKARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GOYOCEPHALE_SPAWN_EGG.get() || stack.getItem() == PFItems.PSITTACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.INCISIVOSAURUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("diurnal").withStyle(ChatFormatting.GOLD));
			} else {
				tooltip.add(new TranslatableComponent("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		}
		if (stack.getItem() == PFItems.DAKOTARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.DIDELPHODON_SPAWN_EGG.get() || stack.getItem() == PFItems.CERATOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.VELOCIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTATHERIUM_SPAWN_EGG.get() || stack.getItem() == PFItems.HYPERODAPEDON_SPAWN_EGG.get() || stack.getItem() == PFItems.PALAEOSANIWA_SPAWN_EGG.get() || stack.getItem() == PFItems.SINOSAUROPTERYX_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("crepuscular").withStyle(ChatFormatting.LIGHT_PURPLE));
			} else {
				tooltip.add(new TranslatableComponent("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		}
		if (stack.getItem() == PFItems.EILENODON_SPAWN_EGG.get() || stack.getItem() == PFItems.THORACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCUTELLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PROTOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.MEGAPNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.COELOPHYSIS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYPOTHORAX_SPAWN_EGG.get() || stack.getItem() == PFItems.EXAERETODON_SPAWN_EGG.get() || stack.getItem() == PFItems.KOL_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(new TranslatableComponent("nocturnal").withStyle(ChatFormatting.DARK_BLUE));
			} else {
				tooltip.add(new TranslatableComponent("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		}
	}

	@Override
	public EntityType<?> getType(CompoundTag nbt) {
		return this.entityTypeSupplier.get();
	}
}
