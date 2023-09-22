package superlord.prehistoricfauna.common.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SabalitesLeafBlock extends LeavesBlock {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public SabalitesLeafBlock(Properties p_54422_) {
		super(p_54422_);
		this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)).setValue(FACING, Direction.NORTH));
	}
	
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightValue(BlockState state, LevelReader worldIn, BlockPos pos) {
		return 1.0F;
	}

	public boolean propagatesSkylightDown(BlockState state, LevelReader reader, BlockPos pos) {
		return true;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54447_) {
		p_54447_.add(DISTANCE, PERSISTENT, FACING);
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
					return blockstate;
				}
			}
		}
		return null;
	}

}
