package superlord.prehistoricfauna.common.blocks;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import com.mojang.datafixers.util.Pair;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import superlord.prehistoricfauna.init.PFItems;

public class HumulusBlock extends MultifaceBlock implements BonemealableBlock {
	public static final int DEAD_AGE = 3;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

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

	public boolean isValidBonemealTarget(BlockGetter p_153289_, BlockPos p_153290_, BlockState p_153291_, boolean p_153292_) {
		return Stream.of(DIRECTIONS).anyMatch((p_153316_) -> {
			return this.canSpread(p_153291_, p_153289_, p_153290_, p_153316_.getOpposite());
		});
	}

	public Optional<Pair<BlockPos, Direction>> getSpreadFromFaceTowardDirection(BlockState p_153856_, BlockGetter p_153857_, BlockPos p_153858_, Direction p_153859_, Direction p_153860_) {
		BlockPos blockpos = p_153858_.relative(p_153860_);
		BlockPos blockpos1 = blockpos.relative(p_153859_);
		if (p_153860_.getAxis() != p_153859_.getAxis() && hasFace(p_153856_, p_153859_) && !hasFace(p_153856_, p_153860_)) {
			if (this.canSpreadToFace(p_153857_, p_153858_, p_153860_)) {
				return Optional.of(Pair.of(p_153858_, p_153860_));
			} else {
				if (this.canSpreadToFace(p_153857_, blockpos, p_153859_)) {
					return Optional.of(Pair.of(blockpos, p_153859_));
				} else {
					Direction direction = p_153860_.getOpposite();
					if (p_153857_.getBlockState(blockpos1).getBlock() != Blocks.WATER) {
						return this.canSpreadToFace(p_153857_, blockpos1, direction) ? Optional.of(Pair.of(blockpos1, direction)) : Optional.empty();
					}
					return Optional.empty();
				}
			} 
		} else {
			return Optional.empty();
		}
	}

	public boolean isBonemealSuccess(Level p_153294_, Random p_153295_, BlockPos p_153296_, BlockState p_153297_) {
		return true;
	}

	public void performBonemeal(ServerLevel p_153284_, Random p_153285_, BlockPos p_153286_, BlockState p_153287_) {

		this.spreadFromRandomFaceTowardRandomDirection(p_153287_, p_153284_, p_153286_, p_153285_);
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
		BlockState currentState = world.getBlockState(pos);
		int ageValue = currentState.getValue(AGE);
		world.setBlock(pos, currentState.setValue(AGE, ageValue + 1), 0);
		BlockState newState = world.getBlockState(pos);
		if (grow == 0) {
			this.spreadFromRandomFaceTowardRandomDirection(newState, world, pos, random);
		}
	}
}