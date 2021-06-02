package superlord.prehistoricfauna.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SixWayBlock;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;

public class ZamitesTopBlock extends SixWayBlock {

	public ZamitesTopBlock(Properties properties) {
		super(0.3125F, properties);
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (!stateIn.isValidPosition(worldIn, currentPos)) {
			worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
			return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		} else {
			Block block = facingState.getBlock();
			boolean flag = block == BlockInit.ZAMITES_LOG.get();
			return stateIn.with(FACING_TO_PROPERTY_MAP.get(facing), Boolean.valueOf(flag));
		}
	}
	
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!state.isValidPosition(worldIn, pos)) {
			worldIn.destroyBlock(pos, true);
		}
	}

	@SuppressWarnings("deprecation")
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState blockstate = worldIn.getBlockState(pos.down());
		boolean flag = !worldIn.getBlockState(pos.up()).isAir() && !blockstate.isAir();
		for(Direction direction : Direction.Plane.HORIZONTAL) {
			BlockPos blockpos = pos.offset(direction);
			Block block = worldIn.getBlockState(blockpos).getBlock();
			if (block == BlockInit.ZAMITES_LOG.get()) {
				if (flag) {
					return false;
				}
				Block block1 = worldIn.getBlockState(blockpos.down()).getBlock();
				if (block1 == BlockInit.ZAMITES_LOG.get()) {
					return true;
				}
			}
		}
		Block block2 = blockstate.getBlock();
		return block2 == BlockInit.ZAMITES_LOG.get();
	}
	   
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
	}

}
