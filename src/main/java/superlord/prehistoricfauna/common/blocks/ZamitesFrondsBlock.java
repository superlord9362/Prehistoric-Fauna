package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import superlord.prehistoricfauna.init.PFBlocks;

public class ZamitesFrondsBlock extends HorizontalBlock {

	public ZamitesFrondsBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(HORIZONTAL_FACING, Direction.NORTH));
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos.offset(state.get(HORIZONTAL_FACING))).getBlock();
		if (block == PFBlocks.ZAMITES_LOG || block == PFBlocks.ZAMITES_WOOD || block == PFBlocks.STRIPPED_ZAMITES_LOG || block == PFBlocks.STRIPPED_ZAMITES_WOOD) {
			return true;
		} else {
			return false;
		}
	}

	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockState blockstate = this.getDefaultState();
		IWorldReader iworldreader = context.getWorld();
		BlockPos blockpos = context.getPos();

		for(Direction direction : context.getNearestLookingDirections()) {
			if (direction.getAxis().isHorizontal()) {
				blockstate = blockstate.with(HORIZONTAL_FACING, direction);
				if (blockstate.isValidPosition(iworldreader, blockpos)) {
					return blockstate;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return facing == stateIn.get(HORIZONTAL_FACING) && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING);
	}

}
