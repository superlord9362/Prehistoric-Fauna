package superlord.prehistoricfauna.common.feature.trees.baiera;

import java.util.Set;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import superlord.prehistoricfauna.common.blocks.BaieraLogBlock;
import superlord.prehistoricfauna.common.feature.trees.PFAbstractTreeFeature;
import superlord.prehistoricfauna.common.feature.util.PFTreeConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class BaieraTree4 extends PFAbstractTreeFeature<PFTreeConfig> {

	public BaieraTree4(Codec<PFTreeConfig> configIn) {
		super(configIn);
	}
	
	protected boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel world, RandomSource rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, PFTreeConfig config) {
		int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
		BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

		if (pos.getY() + randTreeHeight + 1 < world.getHeight()) {
			if (!this.isAnotherTreeNearby(world, pos, randTreeHeight, 0, isSapling) ) {
				return false;
			} else if (!this.doesSaplingHaveSpaceToGrow(world, pos, randTreeHeight, 7, 5, 5, isSapling)) {
				return false;
			} else {
				for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
					placeTrunk(pos, config, rand, changedBlocks, world, mainmutable, boundsIn);
					mainmutable.move(Direction.UP);
				}
				mainmutable.set(pos);
				
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 1, 0), PFBlocks.BAIERA_LOG.get().defaultBlockState().setValue(BaieraLogBlock.LEAVES, true), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 1, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 1, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 1, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 1, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 2, 0), PFBlocks.BAIERA_LOG.get().defaultBlockState().setValue(BaieraLogBlock.LEAVES, true), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 2, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 2, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 2, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 2, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 3, 0), PFBlocks.BAIERA_LOG.get().defaultBlockState().setValue(BaieraLogBlock.LEAVES, true), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 3, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 3, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 3, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 3, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 3, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 3, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 3, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 3, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 4, 0), PFBlocks.BAIERA_LOG.get().defaultBlockState().setValue(BaieraLogBlock.LEAVES, true), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 4, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 4, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 4, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 4, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 4, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 4, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 4, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 4, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 5, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 5, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 5, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 5, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 5, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 6, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 2), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 7, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 3), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 7, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 4), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 7, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 4), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 7, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 4), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 7, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 4), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 8, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 4), 3);
				world.setBlock(mainmutable.set(pos).move(1, randTreeHeight + 8, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 5), 3);
				world.setBlock(mainmutable.set(pos).move(-1, randTreeHeight + 8, 0), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 5), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 8, -1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 5), 3);
				world.setBlock(mainmutable.set(pos).move(0, randTreeHeight + 8, 1), PFBlocks.BAIERA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 5), 3);
			}
		}
		return true;
	}
	
}
