package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.init.PFBlocks;

public class DeadCycadBlock extends DeadBushBlock {

	public DeadCycadBlock(Properties builder) {
		super(builder);
	}
	
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
	      Block block = state.getBlock();
	      return super.canSurvive(state, worldIn, pos) || block == PFBlocks.HARDENED_SILT.get() || block == PFBlocks.SILT.get();
	}

}
