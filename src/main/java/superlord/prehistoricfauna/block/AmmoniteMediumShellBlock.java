package superlord.prehistoricfauna.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import net.minecraft.block.Block.Properties;

public class AmmoniteMediumShellBlock extends Block {
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	protected static final VoxelShape SHAPE_FRONT_MEDIUM = Block.makeCuboidShape(5.0D, 0.0D, 2.0D, 11.0D, 12.0D, 14.0D);
	protected static final VoxelShape SHAPE_SIDE_MEDIUM = Block.makeCuboidShape(2.0D, 0.0D, 5.0D, 14.0D, 12.0D, 11.0D);
		
	public AmmoniteMediumShellBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(getDirection(state)) {
			case NORTH:
			default:
				return SHAPE_FRONT_MEDIUM;
			case WEST:
				return SHAPE_SIDE_MEDIUM;
			case SOUTH:
				return SHAPE_FRONT_MEDIUM;
			case EAST:
				return SHAPE_SIDE_MEDIUM;
		}
	}
	
	public static Direction getDirection(BlockState state) {
		Direction direction = state.get(FACING);
		return direction;
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		Direction direction = context.getPlacementHorizontalFacing().getOpposite();
		return this.getDefaultState().with(FACING, direction);
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

}
