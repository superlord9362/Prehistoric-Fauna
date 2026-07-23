package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaieraLogBlock extends RotatedPillarBlock {
	public static final BooleanProperty LEAVES = BooleanProperty.create("leaves");
	private static final VoxelShape BASE_SHAPE = Block.box(5D, 0D, 5D, 11D, 16D, 11D);
	private static final VoxelShape X_SHAPE = Block.box(0D, 5D, 5D, 16D, 11D, 11D);
	private static final VoxelShape Z_SHAPE = Block.box(5D, 5D, 0D, 11D, 11D, 16D);

	public BaieraLogBlock(Properties p_55926_) {
		super(p_55926_);
		this.registerDefaultState(this.stateDefinition.any().setValue(LEAVES, false).setValue(AXIS, Direction.Axis.Y));
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_55928_) {
		Level level = p_55928_.getLevel();
		BlockPos pos = p_55928_.getClickedPos();
		boolean hasLeaves = (level.getBlockState(pos.north()).is(BlockTags.LEAVES) || level.getBlockState(pos.east()).is(BlockTags.LEAVES) || level.getBlockState(pos.south()).is(BlockTags.LEAVES) || level.getBlockState(pos.west()).is(BlockTags.LEAVES));
		return super.getStateForPlacement(p_55928_).setValue(LEAVES, hasLeaves);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55933_) {
		p_55933_.add(LEAVES, AXIS);
	}

	public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor level, BlockPos pos, BlockPos newPos) {
		if (state.getValue(AXIS) == Axis.X) {
			if (level.getBlockState(pos.above()).is(BlockTags.LEAVES) || level.getBlockState(pos.north()).is(BlockTags.LEAVES) || level.getBlockState(pos.south()).is(BlockTags.LEAVES) || level.getBlockState(pos.below()).is(BlockTags.LEAVES)) {
				level.scheduleTick(pos, this, 1);
			} else {
				level.scheduleTick(pos, this, 1);
			}
		} else if (state.getValue(AXIS) == Axis.Z) {
			if (level.getBlockState(pos.east()).is(BlockTags.LEAVES) || level.getBlockState(pos.above()).is(BlockTags.LEAVES) || level.getBlockState(pos.below()).is(BlockTags.LEAVES) || level.getBlockState(pos.west()).is(BlockTags.LEAVES)) {
				level.scheduleTick(pos, this, 1);
			} else {
				level.scheduleTick(pos, this, 1);
			}
		} else {
			if (level.getBlockState(pos.east()).is(BlockTags.LEAVES) || level.getBlockState(pos.north()).is(BlockTags.LEAVES) || level.getBlockState(pos.south()).is(BlockTags.LEAVES) || level.getBlockState(pos.west()).is(BlockTags.LEAVES)) {
				level.scheduleTick(pos, this, 1);
			} else {
				level.scheduleTick(pos, this, 1);
			}
		}
		return state;
	}

	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (state.getValue(AXIS) == Axis.X) {
			if (level.getBlockState(pos.above()).is(BlockTags.LEAVES) || level.getBlockState(pos.north()).is(BlockTags.LEAVES) || level.getBlockState(pos.south()).is(BlockTags.LEAVES) || level.getBlockState(pos.below()).is(BlockTags.LEAVES)) {
				level.setBlock(pos, state.setValue(LEAVES, true), 3);
			} else {
				level.setBlock(pos, state.setValue(LEAVES, false), 3);
			}
		} else if (state.getValue(AXIS) == Axis.Z) {
			if (level.getBlockState(pos.east()).is(BlockTags.LEAVES) || level.getBlockState(pos.above()).is(BlockTags.LEAVES) || level.getBlockState(pos.below()).is(BlockTags.LEAVES) || level.getBlockState(pos.west()).is(BlockTags.LEAVES)) {
				level.setBlock(pos, state.setValue(LEAVES, true), 3);
			} else {
				level.setBlock(pos, state.setValue(LEAVES, false), 3);
			}
		} else {
			if (level.getBlockState(pos.east()).is(BlockTags.LEAVES) || level.getBlockState(pos.north()).is(BlockTags.LEAVES) || level.getBlockState(pos.south()).is(BlockTags.LEAVES) || level.getBlockState(pos.west()).is(BlockTags.LEAVES)) {
				level.setBlock(pos, state.setValue(LEAVES, true), 3);
			} else {
				level.setBlock(pos, state.setValue(LEAVES, false), 3);
			}
		}
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		if (state.getValue(AXIS) == Axis.X) {
			return X_SHAPE;
		} else if (state.getValue(AXIS) == Axis.Z) {
			return Z_SHAPE;
		} else {			
			return BASE_SHAPE;
		}
	}

}
