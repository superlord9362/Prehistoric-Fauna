package superlord.prehistoricfauna.common.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.block.DispenserBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import superlord.prehistoricfauna.init.PFItems;

public class PrehistoricSpawnEggItem extends SpawnEggItem {
	
    public static final List<PrehistoricSpawnEggItem> UNADDED_EGGS = new ArrayList<PrehistoricSpawnEggItem>();
	
	public PrehistoricSpawnEggItem(EntityType<?> typeIn, int primaryColorIn, int secondaryColorIn, Properties builder) {
		super(typeIn, primaryColorIn, secondaryColorIn, builder);
        UNADDED_EGGS.add(this);
	}

	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (stack.getItem() == PFItems.THESCELOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ANKYLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRICERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYRANNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DIDELPHODON_SPAWN_EGG.get() || stack.getItem() == PFItems.BASILEMYS_SPAWN_EGG.get() || stack.getItem() == PFItems.DAKOTARAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.MYLEDAPHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.GAR_SPAWN_EGG.get() || stack.getItem() == PFItems.CYCLURUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("hell_creek").mergeStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("cretaceous").mergeStyle(TextFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.DRYOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.ALLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.EILENODON_SPAWN_EGG.get() || stack.getItem() == PFItems.STEGOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CAMARASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.HESPERORNITHOIDES_SPAWN_EGG.get() || stack.getItem() == PFItems.CERATOSAURUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("morrison").mergeStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("jurassic").mergeStyle(TextFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.SAUROSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SILLOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.EXAERETODON_SPAWN_EGG.get() || stack.getItem() == PFItems.HYPERODAPEDON_SPAWN_EGG.get() || stack.getItem() == PFItems.ISCHIGUALASTIA_SPAWN_EGG.get() || stack.getItem() == PFItems.HERRERASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CHROMOGISAURUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("ischigualasto").mergeStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("triassic").mergeStyle(TextFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.CERATODUS_SPAWN_EGG.get()) {
			if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), 340) || InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), 344)) {
				tooltip.add(new TranslationTextComponent("mki").mergeStyle(TextFormatting.GRAY));
				tooltip.add(new TranslationTextComponent("jt").mergeStyle(TextFormatting.DARK_GRAY));
			} else {
                tooltip.add(new TranslationTextComponent("egg.hold_shift").mergeStyle(TextFormatting.GRAY));
			}
		} else if (stack.getItem() == PFItems.PROTOCERATOPS_SPAWN_EGG.get() || stack.getItem() == PFItems.VELOCIRAPTOR_SPAWN_EGG.get() || stack.getItem() == PFItems.CITIPATI_SPAWN_EGG.get() || stack.getItem() == PFItems.AEPYORNITHOMIMUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TELMASAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PINACOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLESIOHADROS_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("djadochta").mergeStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("cretaceous").mergeStyle(TextFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.DILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.KAYENTATHERIUM_SPAWN_EGG.get() || stack.getItem() == PFItems.MEGAPNOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SARAHSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCELIDOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SCUTELLOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CALSOYASUCHUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("kayenta").mergeStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("jurassic").mergeStyle(TextFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.ARGANODUS_SPAWN_EGG.get() || stack.getItem() == PFItems.CHINLEA_SPAWN_EGG.get() || stack.getItem() == PFItems.MOOREODONTUS_SPAWN_EGG.get() || stack.getItem() == PFItems.SAURICHTHYS_SPAWN_EGG.get() || stack.getItem() == PFItems.TRILOPHOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.DESMATOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.POSTOSUCHUS_SPAWN_EGG.get() || stack.getItem() == PFItems.COELOPHYSIS_SPAWN_EGG.get() || stack.getItem() == PFItems.PLACERIAS_SPAWN_EGG.get() || stack.getItem() == PFItems.POPOSAURUS_SPAWN_EGG.get() || stack.getItem() == PFItems.TYPOTHORAX_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("chinle").mergeStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("triassic").mergeStyle(TextFormatting.DARK_GRAY));
		} else if (stack.getItem() == PFItems.POTAMOCERATODUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("mk").mergeStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("jurassic").mergeStyle(TextFormatting.DARK_GRAY));
		}
    }
	
	public static void initSpawnEggs() {
		final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
        DefaultDispenseItemBehavior dispenseBehaviour = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };

        for (final SpawnEggItem spawnEgg : UNADDED_EGGS) {
            EGGS.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerDispenseBehavior(spawnEgg, dispenseBehaviour);
        }
        UNADDED_EGGS.clear();
	}
}
