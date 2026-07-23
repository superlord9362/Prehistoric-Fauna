package superlord.prehistoricfauna.common.items;

import java.util.List;

import javax.annotation.Nullable;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import superlord.prehistoricfauna.init.PFItems;

public class CobbaniaBlockItem extends BlockItem {
	
	public CobbaniaBlockItem(Block p_43436_, Item.Properties p_43437_) {
		super(p_43436_, p_43437_);
	}

	public InteractionResult useOn(UseOnContext p_43439_) {
		return InteractionResult.PASS;
	}
	
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if(InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344)) {
			if (stack.getItem() == PFItems.AZOLLA.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.extant").withStyle(ChatFormatting.GREEN));
			}
			if (stack.getItem() == PFItems.COBBANIA.get() || stack.getItem() == PFItems.CALLIANTHUS.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.extinct").withStyle(ChatFormatting.RED));
			}
			tooltip.add(Component.translatable("tooltip.prehistoricfauna.cretaceous").withStyle(ChatFormatting.GRAY));
			if (stack.getItem() == PFItems.COBBANIA.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.djadochta").withStyle(ChatFormatting.DARK_GRAY));
			}
			if (stack.getItem() == PFItems.COBBANIA.get() || stack.getItem() == PFItems.AZOLLA.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.hell_creek").withStyle(ChatFormatting.DARK_GRAY));
			}
			if (stack.getItem() == PFItems.CALLIANTHUS.get()) {
				tooltip.add(Component.translatable("tooltip.prehistoricfauna.yixian").withStyle(ChatFormatting.DARK_GRAY));
			}
		} else {
			tooltip.add(Component.translatable("tooltip.prehistoricfauna.egg.hold_shift").withStyle(ChatFormatting.GRAY));
		}
	}

	public InteractionResultHolder<ItemStack> use(Level p_43441_, Player p_43442_, InteractionHand p_43443_) {
		BlockHitResult blockhitresult = getPlayerPOVHitResult(p_43441_, p_43442_, ClipContext.Fluid.SOURCE_ONLY);
		BlockHitResult blockhitresult1 = blockhitresult.withPosition(blockhitresult.getBlockPos().above());
		InteractionResult interactionresult = super.useOn(new UseOnContext(p_43442_, p_43443_, blockhitresult1));
		return new InteractionResultHolder<>(interactionresult, p_43442_.getItemInHand(p_43443_));
	}
}
