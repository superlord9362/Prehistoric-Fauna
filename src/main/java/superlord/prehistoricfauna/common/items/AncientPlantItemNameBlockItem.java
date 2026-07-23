package superlord.prehistoricfauna.common.items;

import java.util.List;

import javax.annotation.Nullable;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import superlord.prehistoricfauna.init.PFItems;

public class AncientPlantItemNameBlockItem extends ItemNameBlockItem {

	public AncientPlantItemNameBlockItem(Block p_41579_, Properties p_41580_) {
		super(p_41579_, p_41580_);
	}

	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
			if (stack.getItem() == PFItems.NELUMBO.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.extant").withStyle(ChatFormatting.GREEN));
			}
			if (stack.getItem() == PFItems.QUEREUXIA.get() || stack.getItem() == PFItems.MARMARTHIA_BERRIES.get() || stack.getItem() == PFItems.BASSITHECA_BERRIES.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.extinct").withStyle(ChatFormatting.RED));
			}
			if (stack.getItem() == PFItems.QUEREUXIA.get() || stack.getItem() == PFItems.NELUMBO.get() || stack.getItem() == PFItems.MARMARTHIA_BERRIES.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.cretaceous").withStyle(ChatFormatting.GRAY));
			}
			if (stack.getItem() == PFItems.QUEREUXIA.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.djadochta").withStyle(ChatFormatting.DARK_GRAY));
			}
			if (stack.getItem() == PFItems.NELUMBO.get() || stack.getItem() == PFItems.QUEREUXIA.get() || stack.getItem() == PFItems.MARMARTHIA_BERRIES.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.hell_creek").withStyle(ChatFormatting.DARK_GRAY));				
			}
			if (stack.getItem() == PFItems.BASSITHECA_BERRIES.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.jurassic").withStyle(ChatFormatting.GRAY));
			}
			if (stack.getItem() == PFItems.BASSITHECA_BERRIES.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.morrison").withStyle(ChatFormatting.DARK_GRAY));
			}
		} else {
			tooltip.add(Component.translatable("tooltip.prehistoricfauna.egg.hold_shift").withStyle(ChatFormatting.GRAY));
		}
	}

}
