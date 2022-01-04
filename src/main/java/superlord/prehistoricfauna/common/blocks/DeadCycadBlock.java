package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import superlord.prehistoricfauna.init.PFBlocks;

public class DeadCycadBlock extends DeadBushBlock {

	public DeadCycadBlock(Properties builder) {
		super(builder);
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      Block block = state.getBlock();
	      return super.isValidGround(state, worldIn, pos) || block == PFBlocks.HARDENED_SILT || block == PFBlocks.SILT;
	}

}
