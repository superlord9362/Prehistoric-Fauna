package superlord.prehistoricfauna.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import superlord.prehistoricfauna.init.BlockInit;

import net.minecraft.block.Block.Properties;

public class PrehistoricLog extends LogBlock {
		
	public PrehistoricLog(MaterialColor color, Properties properties) {
		super(color, properties);
	}
		
	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		if(player.getHeldItem(hand) != null) {
			Item item = player.getHeldItem(hand).getItem();	
			if(item instanceof AxeItem) {
				world.setBlockState(pos, BlockInit.METASEQUOIA_LOG_STRIPPED.getDefaultState().with(RotatedPillarBlock.AXIS, state.get(RotatedPillarBlock.AXIS)), 11);
				world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
		return super.onBlockActivated(state, world, pos, player, hand, hit);
	}

}