package superlord.prehistoricfauna.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import superlord.prehistoricfauna.block.CretaceousTimeBlock;
import superlord.prehistoricfauna.init.BlockInit;

public class CretaceousTimeTotemItem extends Item {

	public CretaceousTimeTotemItem(Properties properties) {
		super(properties);
	}
	
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerentity = context.getPlayer();
		IWorld iworld = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockPos blockpos1 = blockpos.offset(context.getFace());
        if (canOpenPortal(iworld.getBlockState(blockpos1), iworld, blockpos1)) {
           iworld.playSound(playerentity, blockpos1, SoundEvents.ITEM_TOTEM_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
           BlockState blockstate1 = ((CretaceousTimeBlock)BlockInit.CRETACEOUS_TIME_BLOCK).getDefaultState();
           iworld.setBlockState(blockpos1, blockstate1, 11);
           ItemStack itemstack = context.getItem();
           if (playerentity instanceof ServerPlayerEntity) {
              CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerentity, blockpos1, itemstack);
              itemstack.damageItem(1, playerentity, (p_219998_1_) -> {
                 p_219998_1_.sendBreakAnimation(context.getHand());
              });
           }
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.FAIL;
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean canOpenPortal(BlockState existingState, IWorld worldIn, BlockPos posIn) {
	      BlockState blockstate = ((CretaceousTimeBlock)BlockInit.CRETACEOUS_TIME_BLOCK).getDefaultState();
	      boolean flag = false;
	      if (worldIn.getBlockState(posIn.down()).getBlock() == BlockInit.PORTAL_FRAME && worldIn.getBlockState(posIn).getBlock() == Blocks.AIR || worldIn.getBlockState(posIn.down()).getBlock() == BlockInit.PORTAL_PROJECTOR && worldIn.getBlockState(posIn).getBlock() == Blocks.AIR) {
	    	  flag = true;
	      }
	      return existingState.isAir() && (blockstate.isValidPosition(worldIn, posIn) || flag);
	   }

}
