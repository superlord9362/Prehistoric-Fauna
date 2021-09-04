package superlord.prehistoricfauna.common.blocks;

import java.util.Queue;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
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
			worldIn.setBlockState(pos, PFBlocks.HARDENED_SILT.getDefaultState(), 2);
			worldIn.playEvent(2001, pos, Block.getStateId(Blocks.WATER.getDefaultState()));
		}

	}

	private boolean absorb(World worldIn, BlockPos pos) {
		Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
		queue.add(new Tuple<>(pos, 0));
		int i = 0;

		while(!queue.isEmpty()) {
			Tuple<BlockPos, Integer> tuple = queue.poll();
			BlockPos blockpos = tuple.getA();
			int j = tuple.getB();

			for(Direction direction : Direction.values()) {
				BlockPos blockpos1 = blockpos.offset(direction);
				BlockState blockstate = worldIn.getBlockState(blockpos1);
				FluidState fluidstate = worldIn.getFluidState(blockpos1);
				Material material = blockstate.getMaterial();
				if (fluidstate.isTagged(FluidTags.WATER)) {
					if (blockstate.getBlock() instanceof IBucketPickupHandler && ((IBucketPickupHandler)blockstate.getBlock()).pickupFluid(worldIn, blockpos1, blockstate) != Fluids.EMPTY) {
						++i;
						if (j < 3) {
							queue.add(new Tuple<>(blockpos1, j + 1));
						}
					} else if (blockstate.getBlock() instanceof FlowingFluidBlock) {
						worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
						++i;
						if (j < 3) {
							queue.add(new Tuple<>(blockpos1, j + 1));
						}
					} else if (material == Material.OCEAN_PLANT || material == Material.SEA_GRASS) {
						TileEntity tileentity = blockstate.hasTileEntity() ? worldIn.getTileEntity(blockpos1) : null;
						spawnDrops(blockstate, worldIn, blockpos1, tileentity);
						worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
						++i;
						if (j < 3) {
							queue.add(new Tuple<>(blockpos1, j + 1));
						}
					}
				}
			}

			if (i > 64) {
				break;
			}
		}

		return i > 0;
	}

}
