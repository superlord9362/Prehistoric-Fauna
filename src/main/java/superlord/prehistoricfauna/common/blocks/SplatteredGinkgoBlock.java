package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class SplatteredGinkgoBlock extends MultifaceBlock {

	public SplatteredGinkgoBlock(Properties p_153822_) {
		super(p_153822_);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		for(Direction direction : DIRECTIONS) {
			if (this.isFaceSupported(direction)) {
				builder.add(getFaceProperty(direction));
			}
		}
	}
	
	public boolean canBeReplaced(BlockState p_153299_, BlockPlaceContext p_153300_) {
		return true;
	}

	public boolean isRandomlyTicking(BlockState p_51696_) {
		return true;
	}
	
	public boolean canSurvive(BlockState p_51683_, LevelReader p_51684_, BlockPos p_51685_) {
		BlockState blockstate = p_51684_.getBlockState(p_51685_);
		if (!blockstate.is(this)) {
			if (!blockstate.isAir()) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		int grow = random.nextInt(4);
		if (grow == 0) {
			world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
		}
	}
	
}
