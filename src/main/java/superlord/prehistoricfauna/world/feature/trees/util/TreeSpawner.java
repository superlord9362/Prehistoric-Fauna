package superlord.prehistoricfauna.world.feature.trees.util;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import superlord.prehistoricfauna.world.feature.config.PFTreeConfig;

public abstract class TreeSpawner {
	
	@Nullable
	protected abstract ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random);
	
	public boolean spawn(ISeedReader world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random rand) {
		ConfiguredFeature<PFTreeConfig, ?> configuredTreeFeature = this.getTreeFeature(rand);
		if (configuredTreeFeature == null) {
			return false;
		} else {
			world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
			configuredTreeFeature.config.forcePlacement();
			if (configuredTreeFeature.generate(world, chunkGenerator, rand, pos)) {
				return true;
			} else {
				world.setBlockState(pos, blockUnder, 4);
				return false;
			}
		}
	}

}
