package superlord.prehistoricfauna.common.blocks;

import java.util.Queue;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import superlord.prehistoricfauna.init.PFBlocks;

public class HardenedSiltBlock extends RotatedPillarBlock {

	public HardenedSiltBlock(Properties properties) {
		super(properties);
	}

	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (!oldState.isIn(state.getBlock())) {
			this.tryAbsorb(worldIn, pos);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		this.tryAbsorb(worldIn, pos);
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
	}

	protected void tryAbsorb(World worldIn, BlockPos pos) {
		if (this.absorb(worldIn, pos)) {
			worldIn.setBlockState(pos, PFBlocks.SILT.getDefaultState(), 2);
		}
	}
	
	private boolean absorb(World worldIn, BlockPos pos) {
		Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
		queue.add(new Tuple<>(pos, 0));
		int i = 0;

		while(!queue.isEmpty()) {
			Tuple<BlockPos, Integer> tuple = queue.poll();
			BlockPos blockpos = tuple.getA();

			for(Direction direction : Direction.values()) {
				BlockPos blockpos1 = blockpos.offset(direction);
				FluidState fluidstate = worldIn.getFluidState(blockpos1);
				if (fluidstate.isTagged(FluidTags.WATER)) {
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
