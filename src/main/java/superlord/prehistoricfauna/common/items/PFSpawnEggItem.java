package superlord.prehistoricfauna.common.items;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Edmontosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Dongbeititan;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.init.PFItems;

public class PFSpawnEggItem extends SpawnEggItem {

	private static final List<PFSpawnEggItem> MOD_EGGS = new ArrayList<>();
	private static final Map<EntityType<? extends Mob>, PFSpawnEggItem> TYPE_MAP = new IdentityHashMap<>();
	private final Supplier<? extends EntityType<? extends Mob>> typeSupplier;

	@SuppressWarnings("deprecation")
	public PFSpawnEggItem(Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor, Properties props) {
		super((EntityType<? extends Mob>) null, backgroundColor, highlightColor, props);
		this.typeSupplier = type;

		MOD_EGGS.add(this);
	}

	@Override
	public EntityType<?> getType(@Nullable CompoundTag tag) {
		EntityType<?> type = super.getType(tag);
		return type != null ? type : typeSupplier.get();
	}

	@Nullable
	protected DispenseItemBehavior createDispenseBehavior() {
		return DEFAULT_DISPENSE_BEHAVIOR;
	}

	@SuppressWarnings("deprecation")
	@Nullable
	public static SpawnEggItem fromEntityType(@Nullable EntityType<?> type) {
		SpawnEggItem ret = TYPE_MAP.get(type);
		return ret != null ? ret : SpawnEggItem.byId(type);
	}

	@Override
	protected EntityType<?> getDefaultType() {
		return this.typeSupplier.get();
	}

	private static final DispenseItemBehavior DEFAULT_DISPENSE_BEHAVIOR = (source, stack) -> {
		Direction face = source.getBlockState().getValue(DispenserBlock.FACING);
		EntityType<?> type = ((SpawnEggItem)stack.getItem()).getType(stack.getTag());

		try {
			type.spawn(source.getLevel(), stack, null, source.getPos().relative(face), MobSpawnType.DISPENSER, face != Direction.UP, false);
		}
		catch (Exception exception) {
			DispenseItemBehavior.LOGGER.error("Error while dispensing spawn egg from dispenser at {}", source.getPos(), exception);
			return ItemStack.EMPTY;
		}

		stack.shrink(1);
		source.getLevel().gameEvent(GameEvent.ENTITY_PLACE, source.getPos(), GameEvent.Context.of(source.getBlockState()));
		return stack;
	};

	@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class CommonHandler {
		@SubscribeEvent
		public static void onCommonSetup(FMLCommonSetupEvent event) {
			MOD_EGGS.forEach(egg -> {
				DispenseItemBehavior dispenseBehavior = egg.createDispenseBehavior();
				if (dispenseBehavior != null) {
					DispenserBlock.registerBehavior(egg, dispenseBehavior);
				}

				TYPE_MAP.put(egg.typeSupplier.get(), egg);
			});
		}
	}

	@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class ColorRegisterHandler {
		@SuppressWarnings("deprecation")
		@SubscribeEvent(priority = EventPriority.HIGHEST)
		public static void registerSpawnEggColors(RegisterColorHandlersEvent.Item event) {
			MOD_EGGS.forEach(egg ->
			event.getItemColors().register((stack, layer) -> egg.getColor(layer), egg)
					);
		}
	}


	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if (stack.getItem() == PFItems.THESCELOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BRACHYCHAMPSA_SPAWN_EGG.get() || stack.getItem() == PFItems.ACIPENSER_SPAWN_EGG.get() || stack.getItem() == PFItems.LONCHIDION_SPAWN_EGG.get() || stack.getItem() == PFItems.MELVIUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ANKYLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRICERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYRANNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DIDELPHODON_SPAWN_EGG.get() || stack.getItem() == PFItems.BASILEMYS_SPAWN_EGG.get() || stack.getItem() == PFItems.DAKOTARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.MYLEDAPHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GAR_SPAWN_EGG.get() || stack.getItem() == PFItems.CYCLURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PALAEOSANIWA_SPAWN_EGG.get() || stack.getItem() == PFItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CEPHALOLEICHNITES_SPAWN_EGG.get() || stack.getItem() == PFItems.EDMONTOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ANZU_SPAWN_EGG.get() || stack.getItem() == PFItems.PARAPSEPHURUS_SPAWN_EGG.get()) {
			tooltip.add(Component.translatable("hell_creek").withStyle(ChatFormatting.GRAY));
			tooltip.add(Component.translatable("cretaceous").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.DRYOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.EILENODON_SPAWN_EGG.get() || stack.getItem() == PFItems.STEGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMARASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HESPERORNITHOIDES_SPAWN_EGG.get() || stack.getItem() == PFItems.CERATOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DIABLOPHIS_SPAWN_EGG.get() || stack.getItem() == PFItems.TANYCOLAGREUS_SPAWN_EGG.get() || stack.getItem() == PFItems.MACELOGNATHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.MORROLEPIS_SPAWN_EGG.get() || stack.getItem() == PFItems.CYLINDRICUM_SPAWN_EGG.get() || stack.getItem() == PFItems.OPHIOPSIS_SPAWN_EGG.get() || stack.getItem() == PFItems.EOPOLIS_SPAWN_EGG.get() || stack.getItem() == PFItems.PARAPLEURITES_SPAWN_EGG.get() || stack.getItem() == PFItems.GARGOYLEOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMPTOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALCOVASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TORVOSAURUS_SPAWN_EGG.get()) {
			tooltip.add(Component.translatable("morrison").withStyle(ChatFormatting.GRAY));
			tooltip.add(Component.translatable("jurassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.SAUROSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SILLOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.EXAERETODON_SPAWN_EGG.get() || stack.getItem() == PFItems.HYPERODAPEDON_SPAWN_EGG.get() || stack.getItem() == PFItems.ISCHIGUALASTIA_SPAWN_EGG.get() || stack.getItem() == PFItems.HERRERASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CHROMOGISAURUS_SPAWN_EGG.get()) {
			tooltip.add(Component.translatable("ischigualasto").withStyle(ChatFormatting.GRAY));
			tooltip.add(Component.translatable("triassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.CERATODUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("mki").withStyle(ChatFormatting.GRAY));
				tooltip.add(Component.translatable("jt").withStyle(ChatFormatting.DARK_GRAY));
			} else {
				tooltip.add(Component.translatable("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		} else if (stack.getItem() == PFItems.PROTOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.VELOCIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.CITIPATI_SPAWN_EGG.get() || stack.getItem() == PFItems.AEPYORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TELMASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PINACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLESIOHADROS_SPAWN_EGG.get() || stack.getItem() == PFItems.OVIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.DERMESTID_BEETLE_SPAWN_EGG.get() || stack.getItem() == PFItems.GOBIULUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HARENAICHTHYS_SPAWN_EGG.get() || stack.getItem() == PFItems.UDANOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.HALSZKARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.GOYOCEPHALE_SPAWN_EGG.get() || stack.getItem() == PFItems.KOL_SPAWN_EGG.get() || stack.getItem() == PFItems.BYRONOSAURUS_SPAWN_EGG.get()) {
			tooltip.add(Component.translatable("djadochta").withStyle(ChatFormatting.GRAY));
			tooltip.add(Component.translatable("cretaceous").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.DILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTATHERIUM_SPAWN_EGG.get() || stack.getItem() == PFItems.MEGAPNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SARAHSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCELIDOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCUTELLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CALSOYASUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTACHELYS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTASUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTAVENATOR_SPAWN_EGG.get() || stack.getItem() == PFItems.DIPLICHNITES_SPAWN_EGG.get() || stack.getItem() == PFItems.OCTOPODICHNUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PALEOHELCURA_SPAWN_EGG.get()) {
			tooltip.add(Component.translatable("kayenta").withStyle(ChatFormatting.GRAY));
			tooltip.add(Component.translatable("jurassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.ARGANODUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CHINLEA_SPAWN_EGG.get() || stack.getItem() == PFItems.MOOREODONTUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SAURICHTHYS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DESMATOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POSTOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.COELOPHYSIS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLACERIAS_SPAWN_EGG.get() || stack.getItem() == PFItems.POPOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYPOTHORAX_SPAWN_EGG.get()) {
			tooltip.add(Component.translatable("chinle").withStyle(ChatFormatting.GRAY));
			tooltip.add(Component.translatable("triassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.POTAMOCERATODUS_SPAWN_EGG.get()) {
			tooltip.add(Component.translatable("mk").withStyle(ChatFormatting.GRAY));
			tooltip.add(Component.translatable("jurassic").withStyle(ChatFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.YUTYRANNUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PSITTACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SINOSAUROPTERYX_SPAWN_EGG.get() || stack.getItem() == PFItems.INCISIVOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.APOCLION_SPAWN_EGG.get() || stack.getItem() == PFItems.CRETARANEUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PROTOPSEPHURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SINAMIA_SPAWN_EGG.get() || stack.getItem() == PFItems.YANOSTEUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BEIPIAOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CHANGYURAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.LIAONINGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.REPENOMAMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.RUIXINIA_SPAWN_EGG.get() || stack.getItem() == PFItems.DONGBEITITAN_SPAWN_EGG.get() || stack.getItem() == PFItems.DILONG_SPAWN_EGG.get() || stack.getItem() == PFItems.LIAONEMOBIUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ZHENYUANLONG_SPAWN_EGG.get() || stack.getItem() == PFItems.JINZHOUSAURUS_SPAWN_EGG.get()) {
			tooltip.add(Component.translatable("yixian").withStyle(ChatFormatting.GRAY));
			tooltip.add(Component.translatable("cretaceous").withStyle(ChatFormatting.DARK_GRAY));
		}
		if (stack.getItem() == PFItems.CHUNGKINGICHTHYS_SPAWN_EGG.get() || stack.getItem() == PFItems.LEPIDOTES_SPAWN_EGG.get() || stack.getItem() == PFItems.BASHANOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CHUANDONGOCOELURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.AGILISAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GIGANTSPINOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.YANDUSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.YANGCHUANOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ABOILUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CICADOCORIS_SPAWN_EGG.get() || stack.getItem() == PFItems.MESOFORFICULA_SPAWN_EGG.get() || stack.getItem() == PFItems.RHIPIDOBLATTINA_SPAWN_EGG.get() || stack.getItem() == PFItems.HUAYANGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TUOJIANGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SHUNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ABROSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SINRAPTOR_SPAWN_EGG.get()) {
			tooltip.add(Component.translatable("shaximiao").withStyle(ChatFormatting.GRAY));
			tooltip.add(Component.translatable("jurassic").withStyle(ChatFormatting.DARK_GRAY));
		}
		if (stack.getItem() == PFItems.TYRANNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SAUROSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POSTOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POPOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HESPERORNITHOIDES_SPAWN_EGG.get() || stack.getItem() == PFItems.HERRERASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DAKOTARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.CERATOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.VELOCIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.MEGAPNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.COELOPHYSIS_SPAWN_EGG.get() || stack.getItem() == PFItems.PALAEOSANIWA_SPAWN_EGG.get() || stack.getItem() == PFItems.YUTYRANNUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SINOSAUROPTERYX_SPAWN_EGG.get() || stack.getItem() == PFItems.BYRONOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.REPENOMAMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DILONG_SPAWN_EGG.get() || stack.getItem() == PFItems.ZHENYUANLONG_SPAWN_EGG.get() || stack.getItem() == PFItems.CHUANDONGOCOELURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.YANGCHUANOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DIABLOPHIS_SPAWN_EGG.get() || stack.getItem() == PFItems.TANYCOLAGREUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTASUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTAVENATOR_SPAWN_EGG.get() || stack.getItem() == PFItems.TORVOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SINRAPTOR_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("carnivore").withStyle(ChatFormatting.RED));
			}
		}
		if (stack.getItem() == PFItems.TRICERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCUTELLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCELIDOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.STEGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.AEPYORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SARAHSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SILLOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ISCHIGUALASTIA_SPAWN_EGG.get() || stack.getItem() == PFItems.DESMATOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ANKYLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.THESCELOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BASILEMYS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMARASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DRYOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PINACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLESIOHADROS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTATHERIUM_SPAWN_EGG.get() || stack.getItem() == PFItems.HYPERODAPEDON_SPAWN_EGG.get() || stack.getItem() == PFItems.EILENODON_SPAWN_EGG.get() || stack.getItem() == PFItems.PROTOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYPOTHORAX_SPAWN_EGG.get() || stack.getItem() == PFItems.PLACERIAS_SPAWN_EGG.get() || stack.getItem() == PFItems.EXAERETODON_SPAWN_EGG.get() || stack.getItem() == PFItems.UDANOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GOYOCEPHALE_SPAWN_EGG.get() || stack.getItem() == PFItems.PSITTACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.EDMONTOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.LIAONINGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.RUIXINIA_SPAWN_EGG.get() || stack.getItem() == PFItems.DONGBEITITAN_SPAWN_EGG.get() || stack.getItem() == PFItems.JINZHOUSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BASHANOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.AGILISAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GIGANTSPINOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.YANDUSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.MACELOGNATHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTACHELYS_SPAWN_EGG.get() || stack.getItem() == PFItems.GARGOYLEOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMPTOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALCOVASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HUAYANGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TUOJIANGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SHUNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ABROSAURUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("herbivore").withStyle(ChatFormatting.DARK_GREEN));
			}
		}
		if (stack.getItem() == PFItems.CITIPATI_SPAWN_EGG.get() || stack.getItem() == PFItems.CHROMOGISAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.OVIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.ORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.INCISIVOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BEIPIAOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ANZU_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("omnivore").withStyle(ChatFormatting.YELLOW));
			}
		}
		if (stack.getItem() == PFItems.TELMASAURUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("ovivore").withStyle(ChatFormatting.WHITE));
			}
		}
		if (stack.getItem() == PFItems.DIDELPHODON_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("molluscivore").withStyle(ChatFormatting.DARK_PURPLE));
			}
		}
		if (stack.getItem() == PFItems.KOL_SPAWN_EGG.get() || stack.getItem() == PFItems.CHANGYURAPTOR_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("insectivore").withStyle(ChatFormatting.GREEN));
			}
		}
		if (stack.getItem() == PFItems.CALSOYASUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BRACHYCHAMPSA_SPAWN_EGG.get() || stack.getItem() == PFItems.HALSZKARAPTOR_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("piscivore").withStyle(ChatFormatting.DARK_AQUA));
			}
		}
		if (stack.getItem() == PFItems.TYRANNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCELIDOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRICERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.STEGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.AEPYORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SARAHSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CALSOYASUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SAUROSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SILLOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ISCHIGUALASTIA_SPAWN_EGG.get() || stack.getItem() == PFItems.CHROMOGISAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POSTOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POPOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DESMATOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLACERIAS_SPAWN_EGG.get() || stack.getItem() == PFItems.UDANOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.ORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.YUTYRANNUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ANZU_SPAWN_EGG.get() || stack.getItem() == PFItems.BRACHYCHAMPSA_SPAWN_EGG.get() || stack.getItem() == PFItems.GIGANTSPINOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.YANGCHUANOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.MACELOGNATHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTASUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TORVOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HUAYANGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TUOJIANGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SINRAPTOR_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("cathemeral").withStyle(ChatFormatting.GREEN));
			} else {
				tooltip.add(Component.translatable("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		}
		if (stack.getItem() == PFItems.ANKYLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.THESCELOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BASILEMYS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMARASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DRYOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HESPERORNITHOIDES_SPAWN_EGG.get() || stack.getItem() == PFItems.PINACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLESIOHADROS_SPAWN_EGG.get() || stack.getItem() == PFItems.CITIPATI_SPAWN_EGG.get() || stack.getItem() == PFItems.TELMASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HERRERASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.OVIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.HALSZKARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GOYOCEPHALE_SPAWN_EGG.get() || stack.getItem() == PFItems.PSITTACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.INCISIVOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.EDMONTOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.BEIPIAOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.LIAONINGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.RUIXINIA_SPAWN_EGG.get() || stack.getItem() == PFItems.DONGBEITITAN_SPAWN_EGG.get() || stack.getItem() == PFItems.JINZHOUSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.YANDUSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTACHELYS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMPTOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GARGOYLEOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ABROSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALCOVASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SHUNOSAURUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("diurnal").withStyle(ChatFormatting.GOLD));
			} else {
				tooltip.add(Component.translatable("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		}
		if (stack.getItem() == PFItems.DAKOTARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.DIDELPHODON_SPAWN_EGG.get() || stack.getItem() == PFItems.CERATOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.VELOCIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTATHERIUM_SPAWN_EGG.get() || stack.getItem() == PFItems.HYPERODAPEDON_SPAWN_EGG.get() || stack.getItem() == PFItems.PALAEOSANIWA_SPAWN_EGG.get() || stack.getItem() == PFItems.SINOSAUROPTERYX_SPAWN_EGG.get() || stack.getItem() == PFItems.CHANGYURAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.DILONG_SPAWN_EGG.get() || stack.getItem() == PFItems.ZHENYUANLONG_SPAWN_EGG.get() || stack.getItem() == PFItems.BASHANOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CHUANDONGOCOELURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.AGILISAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DIABLOPHIS_SPAWN_EGG.get() || stack.getItem() == PFItems.TANYCOLAGREUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTAVENATOR_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("crepuscular").withStyle(ChatFormatting.LIGHT_PURPLE));
			} else {
				tooltip.add(Component.translatable("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		}
		if (stack.getItem() == PFItems.EILENODON_SPAWN_EGG.get() || stack.getItem() == PFItems.SCUTELLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PROTOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.MEGAPNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.COELOPHYSIS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYPOTHORAX_SPAWN_EGG.get() || stack.getItem() == PFItems.EXAERETODON_SPAWN_EGG.get() || stack.getItem() == PFItems.KOL_SPAWN_EGG.get() || stack.getItem() == PFItems.BYRONOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.REPENOMAMUS_SPAWN_EGG.get()) {
			if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
				tooltip.add(Component.translatable("nocturnal").withStyle(ChatFormatting.DARK_BLUE));
			} else {
				tooltip.add(Component.translatable("egg.hold_shift").withStyle(ChatFormatting.GRAY));
			}
		}
	}

	@Override
	public Optional<Mob> spawnOffspringFromSpawnEgg(Player p_43216_, Mob p_43217_, EntityType<? extends Mob> p_43218_, ServerLevel p_43219_, Vec3 p_43220_, ItemStack p_43221_) {
		if (!this.spawnsEntity(p_43221_.getTag(), p_43218_)) {
			return Optional.empty();
		} else {
			Mob mob;
			if (p_43217_ instanceof AgeableMob) {
				if (p_43217_ instanceof Edmontosaurus) {
					mob = ((Edmontosaurus)p_43217_).getBreedOffspring(p_43219_, (Edmontosaurus)p_43217_);
					
				} else mob = ((AgeableMob)p_43217_).getBreedOffspring(p_43219_, (AgeableMob)p_43217_);
			} else {
				mob = p_43218_.create(p_43219_);
			}

			if (mob == null) {
				return Optional.empty();
			} else {
				mob.setBaby(true);
				if (mob instanceof Edmontosaurus) {
					((Edmontosaurus)mob).setJuvenile(false);
					((Edmontosaurus)mob).setAge(-48000);
				}
				if (mob instanceof Dongbeititan) {
					((Dongbeititan)mob).setJuvenile(false);
					((Dongbeititan)mob).setAge(-48000);
				}
				if (mob instanceof Triceratops) {
					((Triceratops)mob).setJuvenile(false);
					((Triceratops)mob).setAge(-48000);
				}
				if (mob instanceof Tyrannosaurus) {
					((Tyrannosaurus)mob).setJuvenile(false);
					((Tyrannosaurus)mob).setAge(-48000);
				}
				if (mob instanceof Camarasaurus) {
					((Camarasaurus)mob).setJuvenile(false);
					((Camarasaurus)mob).setHatchling(true);
					((Camarasaurus)mob).setAge(-72000);
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

}
