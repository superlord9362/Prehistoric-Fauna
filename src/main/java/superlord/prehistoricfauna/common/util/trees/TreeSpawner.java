package superlord.prehistoricfauna.common.util.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public abstract class TreeSpawner {

	@Nullable
	protected abstract ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random);

	public boolean spawn(WorldGenLevel world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
		ConfiguredFeature<PFTreeConfig, ?> treeFeature = this.getTreeFeature(random);
		if (treeFeature == null) {
			return false;
		} else {
			world.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
			if (treeFeature.place(world, chunkGenerator, random, pos)) {
				return true;
			} else {
				world.setBlock(pos, blockUnder, 4);
				return false;
			}
		}
	}

}
