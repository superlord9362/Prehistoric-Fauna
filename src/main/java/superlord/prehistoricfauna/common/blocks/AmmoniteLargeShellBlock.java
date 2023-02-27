package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AmmoniteLargeShellBlock extends Block implements LiquidBlockContainer {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final VoxelShape SHAPE_FRONT_LARGE = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_SIDE_LARGE = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D);

	public AmmoniteLargeShellBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch(getDirection(state)) {
		case NORTH:
		default:
			return SHAPE_FRONT_LARGE;
		case WEST:
			return SHAPE_SIDE_LARGE;
		case SOUTH:
			return SHAPE_FRONT_LARGE;
		case EAST:
			return SHAPE_SIDE_LARGE;
		}
	}

	public static Direction getDirection(BlockState state) {
		Direction direction = state.getValue(FACING);
		return direction;
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Direction direction = context.getHorizontalDirection().getOpposite();
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.is(Fluids.WATER)));

	}
	
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return !state.getValue(WATERLOGGED);
	}

	@Override
	public boolean canPlaceLiquid(BlockGetter p_54766_, BlockPos p_54767_, BlockState p_54768_, Fluid p_54769_) {
		return false;
	}

	@Override
	public boolean placeLiquid(LevelAccessor p_54770_, BlockPos p_54771_, BlockState p_54772_, FluidState p_54773_) {
		return false;
	}

}
