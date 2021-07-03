package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class AmmoniteMediumShellBlock extends Block implements IWaterLoggable {
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final VoxelShape SHAPE_FRONT_MEDIUM = Block.makeCuboidShape(5.0D, 0.0D, 2.0D, 11.0D, 12.0D, 14.0D);
	protected static final VoxelShape SHAPE_SIDE_MEDIUM = Block.makeCuboidShape(2.0D, 0.0D, 5.0D, 14.0D, 12.0D, 11.0D);
		
	public AmmoniteMediumShellBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
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
		FluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(FACING, direction).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return !state.get(WATERLOGGED);
	}

}
