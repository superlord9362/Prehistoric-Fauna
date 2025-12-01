package superlord.prehistoricfauna.common.util.trees;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public abstract class TreeSpawner {

	@Nullable
	protected abstract ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random);

	public boolean spawn(WorldGenLevel world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, RandomSource random) {
		ResourceKey<ConfiguredFeature<?, ?>> treeFeature = this.getTreeFeature(random);
		Holder<ConfiguredFeature<?, ?>> holder = world.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(treeFeature).orElse((Holder.Reference<ConfiguredFeature<?, ?>>)null);
		ConfiguredFeature<?, ?> configuredfeature = holder.value();
		if (treeFeature == null) {
			return false;
		} else {
			world.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
			if (configuredfeature != null ) {
				if (configuredfeature.place(world, chunkGenerator, random, pos)) {
					return true;
				} else {
					world.setBlock(pos, blockUnder, 4);
					return false;
				}
			} else {
				world.setBlock(pos, blockUnder, 4);
				return false;
			}
		}
	}

}
