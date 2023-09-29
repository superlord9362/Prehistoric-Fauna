package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class SabalitesCrownLogBlock extends RotatedPillarBlock {
	public static final BooleanProperty END_LOG = BooleanProperty.create("end_log");

	public SabalitesCrownLogBlock(Properties p_55926_) {
		super(p_55926_);
		this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y).setValue(END_LOG, true));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55933_) {
		p_55933_.add(AXIS, END_LOG);
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_55928_) {
		BlockPos pos = p_55928_.getClickedPos();
		Level level = p_55928_.getLevel();
		if (p_55928_.getClickedFace().getAxis() == Axis.Y) {
			boolean solidTop = level.getBlockState(pos.above()).isSolidRender(level, pos.above());
			return this.defaultBlockState().setValue(AXIS, p_55928_.getClickedFace().getAxis()).setValue(END_LOG, !solidTop);
		} else  if (p_55928_.getClickedFace().getAxis() == Axis.Z) {
			boolean solidTop = (level.getBlockState(pos.north()).isSolidRender(level, pos.north()) || level.getBlockState(pos.south()).isSolidRender(level, pos.south()));
			return this.defaultBlockState().setValue(AXIS, p_55928_.getClickedFace().getAxis()).setValue(END_LOG, !solidTop);
		} else {
			boolean solidTop = (level.getBlockState(pos.east()).isSolidRender(level, pos.east()) || level.getBlockState(pos.west()).isSolidRender(level, pos.west()));
			return this.defaultBlockState().setValue(AXIS, p_55928_.getClickedFace().getAxis()).setValue(END_LOG, !solidTop);
		}
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos pos1) {
		if (world.getBlockState(pos.below()).getBlock() instanceof SabalitesCrownLogBlock && (world.getBlockState(pos.below()).getValue(AXIS) == Axis.Y)) {
			BlockState belowState = world.getBlockState(pos.below());
			if (world.getBlockState(pos.above()).getBlock() instanceof SabalitesCrownLogBlock && (world.getBlockState(pos.above()).getValue(AXIS) == Axis.Y)) {
				BlockState aboveState = world.getBlockState(pos.above());
				if (aboveState.getValue(END_LOG) == true) {
					return aboveState.setValue(END_LOG, false);
				} else return super.updateShape(state, direction, newState, world, pos, pos1);
			} else if (belowState.getValue(END_LOG) == true) {
				return belowState.setValue(END_LOG, false);
			} else return super.updateShape(state, direction, newState, world, pos, pos1);
		} else if (world.getBlockState(pos.above()).getBlock() instanceof SabalitesCrownLogBlock && (world.getBlockState(pos.above()).getValue(AXIS) == Axis.Y)) {
			BlockState aboveState = world.getBlockState(pos);
			if (aboveState.getValue(END_LOG) == true) {
				return aboveState.setValue(END_LOG, false);
			} else return super.updateShape(state, direction, newState, world, pos, pos1);
		} else if (world.getBlockState(pos.north()).getBlock() instanceof SabalitesCrownLogBlock && (world.getBlockState(pos.north()).getValue(AXIS) == Axis.Z)) {
			BlockState northState = world.getBlockState(pos.north());
			if (northState.getValue(END_LOG) == true) {
				return northState.setValue(END_LOG, false);
			} else return super.updateShape(state, direction, newState, world, pos, pos1);
		} else if(world.getBlockState(pos.south()).getBlock() instanceof SabalitesCrownLogBlock && (world.getBlockState(pos.south()).getValue(AXIS) == Axis.Z)) {
			BlockState southState = world.getBlockState(pos.south());
			if (southState.getValue(END_LOG) == true) {
				return southState.setValue(END_LOG, false);
			} else return super.updateShape(state, direction, newState, world, pos, pos1);
		} else if (world.getBlockState(pos.east()).getBlock() instanceof SabalitesCrownLogBlock && (world.getBlockState(pos.east()).getValue(AXIS) == Axis.X)) {
			BlockState eastState = world.getBlockState(pos.east());
			if (eastState.getValue(END_LOG) == true) {
				return eastState.setValue(END_LOG, false);
			} else return super.updateShape(state, direction, newState, world, pos, pos1);
		} else if (world.getBlockState(pos.west()).getBlock() instanceof SabalitesCrownLogBlock && (world.getBlockState(pos.west()).getValue(AXIS) == Axis.X)) {
			BlockState westState = world.getBlockState(pos.west());
			if (westState.getValue(END_LOG) == true) {
				return westState.setValue(END_LOG, false);
			} else return super.updateShape(state, direction, newState, world, pos, pos1);
		} else return super.updateShape(state, direction, newState, world, pos, pos1);
	}

}
