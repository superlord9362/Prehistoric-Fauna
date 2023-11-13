package superlord.prehistoricfauna.common.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SabalitesLeafBlock extends LeavesBlock {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<LeafDirection> DIRECTION = EnumProperty.create("leaf_direction", LeafDirection.class);
	
	public SabalitesLeafBlock(Properties p_54422_) {
		super(p_54422_);
		this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(1)).setValue(PERSISTENT, Boolean.valueOf(false)).setValue(FACING, Direction.NORTH).setValue(DIRECTION, LeafDirection.STRAIGHT));
	}
	
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightValue(BlockState state, LevelReader worldIn, BlockPos pos) {
		return 1.0F;
	}

	public boolean propagatesSkylightDown(BlockState state, LevelReader reader, BlockPos pos) {
		return true;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54447_) {
		p_54447_.add(DISTANCE, PERSISTENT, FACING, DIRECTION);
	}
	
	public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos pos1) {
		return direction.getAxis().isHorizontal() ? state.setValue(DIRECTION, getLeafDirection(state, world, pos)) : super.updateShape(state, direction, newState, world, pos, pos1);
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_54424_) {
		BlockState blockstate = super.getStateForPlacement(p_54424_);
		LevelReader levelreader = p_54424_.getLevel();
		BlockPos blockpos = p_54424_.getClickedPos();
		Direction[] adirection = p_54424_.getNearestLookingDirections();

		for(Direction direction : adirection) {
			if (direction.getAxis().isHorizontal()) {
				blockstate = blockstate.setValue(FACING, direction.getOpposite());
				if (blockstate.canSurvive(levelreader, blockpos)) {
					return blockstate.setValue(DIRECTION, getLeafDirection(blockstate, p_54424_.getLevel(), blockpos));
				}
			}
		}
		return null;
	}
	
	private static LeafDirection getLeafDirection(BlockState state, BlockGetter reader, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		BlockState blockstate = reader.getBlockState(pos.relative(direction, -1));
		if (isSabalitesLeaves(blockstate)) {
			Direction direction1 = blockstate.getValue(FACING);
			if (direction1.getAxis() != state.getValue(FACING).getAxis() && canTakeShape(state, reader, pos, direction1)) {
				
				return LeafDirection.CORNER;
			}
		}
		return LeafDirection.STRAIGHT;
	}
	
	private static boolean canTakeShape(BlockState state, BlockGetter reader, BlockPos pos, Direction direction) {
		BlockState blockstate = reader.getBlockState(pos.relative(direction));
		return !isSabalitesLeaves(blockstate) || blockstate.getValue(FACING) != state.getValue(FACING);
	}
	
	public static boolean isSabalitesLeaves(BlockState state) {
		return state.getBlock() instanceof SabalitesLeafBlock;
	}
	
	public enum LeafDirection implements StringRepresentable {
		STRAIGHT("straight"),
		CORNER("corner");
		
		private final String name;
		
		private LeafDirection(String name) {
			this.name = name;
		}
		
		public String toString() {
			return this.name;
		}
		
		public String getSerializedName() {
			return this.name;
		}
	}

}
