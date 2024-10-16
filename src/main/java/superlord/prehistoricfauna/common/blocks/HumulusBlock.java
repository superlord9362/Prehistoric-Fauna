package superlord.prehistoricfauna.common.blocks;

import java.util.stream.Stream;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import superlord.prehistoricfauna.init.PFItems;

public class HumulusBlock extends MultifaceBlock implements BonemealableBlock {
	public static final int DEAD_AGE = 3;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	private final MultifaceSpreader spreader = new MultifaceSpreader(this);

	public HumulusBlock(BlockBehaviour.Properties p_153282_) {
		super(p_153282_);
		this.registerDefaultState(this.defaultBlockState().setValue(AGE, Integer.valueOf(0)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		for(Direction direction : DIRECTIONS) {
			if (this.isFaceSupported(direction)) {
				builder.add(getFaceProperty(direction));
			}
		}
		builder.add(AGE);
	}

	public boolean canBeReplaced(BlockState p_153299_, BlockPlaceContext p_153300_) {
		return !p_153300_.getItemInHand().is(PFItems.HUMULUS.get()) || super.canBeReplaced(p_153299_, p_153300_);
	}

	public boolean isRandomlyTicking(BlockState p_51696_) {
		return p_51696_.getValue(AGE) < 3;
	}

	public boolean isValidBonemealTarget(LevelReader p_153289_, BlockPos p_153290_, BlockState p_153291_, boolean p_153292_) {
		return Stream.of(DIRECTIONS).anyMatch((p_153316_) -> {
			return this.spreader.canSpreadInAnyDirection(p_153291_, p_153289_, p_153290_, p_153316_.getOpposite());
		});
	}

	public boolean isBonemealSuccess(Level p_153294_, RandomSource p_153295_, BlockPos p_153296_, BlockState p_153297_) {
		return true;
	}

	public void performBonemeal(ServerLevel p_153284_, RandomSource p_153285_, BlockPos p_153286_, BlockState p_153287_) {

		this.spreader.spreadFromRandomFaceTowardRandomDirection(p_153287_, p_153284_, p_153286_, p_153285_);
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

	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		int grow = random.nextInt(4);
		BlockState currentState = world.getBlockState(pos);
		int ageValue = currentState.getValue(AGE);
		world.setBlock(pos, currentState.setValue(AGE, ageValue + 1), 0);
		BlockState newState = world.getBlockState(pos);
		if (grow == 0) {
			this.spreader.spreadFromRandomFaceTowardRandomDirection(newState, world, pos, random);
		}
	}

	@Override
	public MultifaceSpreader getSpreader() {
		return spreader;
	}
}