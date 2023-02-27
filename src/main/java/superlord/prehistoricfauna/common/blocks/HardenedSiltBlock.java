package superlord.prehistoricfauna.common.blocks;

import java.util.Queue;

import com.google.common.collect.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import superlord.prehistoricfauna.init.PFBlocks;

public class HardenedSiltBlock extends RotatedPillarBlock {

	public HardenedSiltBlock(Properties properties) {
		super(properties);
	}

	public void onBlockAdded(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (!oldState.is(state.getBlock())) {
			this.tryAbsorb(worldIn, pos);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		this.tryAbsorb(worldIn, pos);
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
	}

	protected void tryAbsorb(Level worldIn, BlockPos pos) {
		if (this.absorb(worldIn, pos)) {
			worldIn.setBlock(pos, PFBlocks.SILT.get().defaultBlockState(), 2);
		}
	}
	
	private boolean absorb(Level worldIn, BlockPos pos) {
		Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
		queue.add(new Tuple<>(pos, 0));
		int i = 0;

		while(!queue.isEmpty()) {
			Tuple<BlockPos, Integer> tuple = queue.poll();
			BlockPos blockpos = tuple.getA();

			for(Direction direction : Direction.values()) {
				BlockPos blockpos1 = blockpos.relative(direction);
				FluidState fluidstate = worldIn.getFluidState(blockpos1);
				if (fluidstate.is(FluidTags.WATER)) {
					i++;
				}
			}

			if (i > 64) {
				break;
			}
		}

		return i > 0;
	}

}
