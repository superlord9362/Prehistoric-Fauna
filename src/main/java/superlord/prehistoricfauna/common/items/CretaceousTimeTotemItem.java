package superlord.prehistoricfauna.common.items;

import java.util.Random;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.blocks.CretaceousTimeBlock;
import superlord.prehistoricfauna.init.PFBlocks;

public class CretaceousTimeTotemItem extends Item {

	public CretaceousTimeTotemItem(Properties properties) {
		super(properties);
	}
	
	public InteractionResult useOn(UseOnContext context) {
		Player playerentity = context.getPlayer();
		Random random = new Random();
		Level iworld = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
        if (canOpenPortal(iworld.getBlockState(blockpos1), iworld, blockpos1)) {
           iworld.playSound(playerentity, blockpos1, SoundEvents.TOTEM_USE, SoundSource.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
           BlockState blockstate1 = ((CretaceousTimeBlock)PFBlocks.CRETACEOUS_TIME_BLOCK.get()).defaultBlockState();
           iworld.setBlock(blockpos1, blockstate1, 11);
           ItemStack itemstack = context.getItemInHand();
           if (playerentity instanceof ServerPlayer) {
              CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)playerentity, blockpos1, itemstack);
              itemstack.hurtAndBreak(1, playerentity, (p_219998_1_) -> {
                 p_219998_1_.broadcastBreakEvent(context.getHand());
              });
           }
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;
		}
	}

	public static boolean canOpenPortal(BlockState existingState, LevelReader worldIn, BlockPos posIn) {
		BlockState blockstate = ((CretaceousTimeBlock)PFBlocks.CRETACEOUS_TIME_BLOCK.get()).defaultBlockState();
		boolean flag = false;
		if (worldIn.getBlockState(posIn.below()).getBlock() == PFBlocks.PORTAL_FRAME.get() && worldIn.getBlockState(posIn).getBlock() == Blocks.AIR || worldIn.getBlockState(posIn.below()).getBlock() == PFBlocks.PORTAL_FRAME.get() && worldIn.getBlockState(posIn).getBlock() == Blocks.AIR || worldIn.getBlockState(posIn.below()).getBlock() == PFBlocks.PORTAL_FRAME.get() && worldIn.getBlockState(posIn).getBlock() == Blocks.CAVE_AIR || worldIn.getBlockState(posIn.below()).getBlock() == PFBlocks.PORTAL_FRAME.get() && worldIn.getBlockState(posIn).getBlock() == Blocks.CAVE_AIR || worldIn.getBlockState(posIn.below()).getBlock() == PFBlocks.PORTAL_FRAME.get() && worldIn.getBlockState(posIn).getBlock() == Blocks.VOID_AIR || worldIn.getBlockState(posIn.below()).getBlock() == PFBlocks.PORTAL_FRAME.get() && worldIn.getBlockState(posIn).getBlock() == Blocks.VOID_AIR) {
			flag = true;
		}
		return existingState.isAir() && (blockstate.canSurvive(worldIn, posIn) || flag);
	}

}
