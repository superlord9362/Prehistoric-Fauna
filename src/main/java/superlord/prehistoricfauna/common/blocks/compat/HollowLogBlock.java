package superlord.prehistoricfauna.common.blocks.compat;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HollowLogBlock extends Block implements SimpleWaterloggedBlock {
	private final boolean flammable;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

	private static final VoxelShape SHAPE_BOTTOM = Block.box(0F, 0F, 0F, 16F, 2F, 16F);
	private static final VoxelShape SHAPE_TOP = Block.box(0F, 14F, 0F, 16F, 16F, 16F);
	private static final VoxelShape SHAPE_NORTH = Block.box(0F, 0F, 0F, 2F, 16F, 16F);
	private static final VoxelShape SHAPE_SOUTH = Block.box(14F, 0F, 0F, 16F, 16F, 16F);
	private static final VoxelShape SHAPE_EAST = Block.box(0F, 0F, 0F, 16F, 16F, 2F);
	private static final VoxelShape SHAPE_WEST = Block.box(0F, 0F, 14F, 16F, 16F, 16F);

	private static final VoxelShape SHAPE_X = Shapes.or(SHAPE_BOTTOM, SHAPE_TOP, SHAPE_EAST, SHAPE_WEST);
	private static final VoxelShape SHAPE_Y = Shapes.or(SHAPE_NORTH, SHAPE_SOUTH, SHAPE_EAST, SHAPE_WEST);
	private static final VoxelShape SHAPE_Z = Shapes.or(SHAPE_BOTTOM, SHAPE_TOP, SHAPE_NORTH, SHAPE_SOUTH);

	public HollowLogBlock(Properties p_49795_, boolean flammable) {
		super(p_49795_);
		this.flammable = flammable;
		registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false).setValue(AXIS, Direction.Axis.Y));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
		return switch(state.getValue(AXIS)) {
		case X -> SHAPE_X;
		case Y -> SHAPE_Y;
		case Z -> SHAPE_Z;
		};
	}

	@Override
	public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return flammable;
	}
	
	public boolean canCrawl(Level level, BlockState state, BlockPos pos, Direction direction) {
		return state.getValue(HollowLogBlock.AXIS) == direction.getAxis();
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos) {
		return !state.getValue(WATERLOGGED) && state.getValue(AXIS) == Axis.Y;
	}

	@SuppressWarnings("deprecation")
	@NotNull
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@SuppressWarnings("deprecation")
	@NotNull
	@Override
	public BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos facingPos) {
		if(state.getValue(WATERLOGGED)) {
			level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}

		return super.updateShape(state, facing, facingState, level, pos, facingPos);
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState p_56967_) {
		return true;
	}


	public BlockState rotate(BlockState p_55930_, Rotation p_55931_) {
		return rotatePillar(p_55930_, p_55931_);
	}

	public static BlockState rotatePillar(BlockState p_154377_, Rotation p_154378_) {
		switch (p_154378_) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			switch ((Direction.Axis)p_154377_.getValue(AXIS)) {
			case X:
				return p_154377_.setValue(AXIS, Direction.Axis.Z);
			case Z:
				return p_154377_.setValue(AXIS, Direction.Axis.X);
			default:
				return p_154377_;
			}
		default:
			return p_154377_;
		}
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55933_) {
		p_55933_.add(AXIS, WATERLOGGED);
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_55928_) {
		return this.defaultBlockState().setValue(AXIS, p_55928_.getClickedFace().getAxis()).setValue(WATERLOGGED, p_55928_.getLevel().getFluidState(p_55928_.getClickedPos()).getType() == Fluids.WATER);
	}

}
