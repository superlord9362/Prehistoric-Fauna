package superlord.prehistoricfauna.item;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import superlord.prehistoricfauna.init.ItemInit;

public class PrehistoricSpawnEggItem extends SpawnEggItem {
	
	public PrehistoricSpawnEggItem(EntityType<?> typeIn, int primaryColorIn, int secondaryColorIn, Properties builder) {
		super(typeIn, primaryColorIn, secondaryColorIn, builder);
	}

	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (stack.getItem() == ItemInit.THESCELOSAURUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.ANKYLOSAURUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.TRICERATOPS_SPAWN_EGG.get() || stack.getItem() == ItemInit.TYRANNOSAURUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.DIDELPHODON_SPAWN_EGG.get() || stack.getItem() == ItemInit.BASILEMYS_SPAWN_EGG.get() || stack.getItem() == ItemInit.DAKOTARAPTOR_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("hell_creek").applyTextStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("cretaceous").applyTextStyle(TextFormatting.DARK_GRAY));
		} else if (stack.getItem() == ItemInit.DRYOSAURUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.ALLOSAURUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.EILENODON_SPAWN_EGG.get() || stack.getItem() == ItemInit.STEGOSAURUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.CAMARASAURUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.HESPERORNITHOIDES_SPAWN_EGG.get() || stack.getItem() == ItemInit.CERATOSAURUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("morrison").applyTextStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("jurassic").applyTextStyle(TextFormatting.DARK_GRAY));
		} else if (stack.getItem() == ItemInit.SAUROSUCHUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.SILLOSUCHUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.EXAERETODON_SPAWN_EGG.get() || stack.getItem() == ItemInit.HYPERODAPEDON_SPAWN_EGG.get() || stack.getItem() == ItemInit.ISCHIGUALASTIA_SPAWN_EGG.get() || stack.getItem() == ItemInit.HERRERASAURUS_SPAWN_EGG.get() || stack.getItem() == ItemInit.CHROMOGISAURUS_SPAWN_EGG.get()) {
			tooltip.add(new TranslationTextComponent("ischigualasto").applyTextStyle(TextFormatting.GRAY));
			tooltip.add(new TranslationTextComponent("triassic").applyTextStyle(TextFormatting.DARK_GRAY));
		}
    }
}
