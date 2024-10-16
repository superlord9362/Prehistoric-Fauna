package superlord.prehistoricfauna.common.util.trees;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public abstract class HugeTreeSpawner extends TreeSpawner {
	
	public static boolean canBigTreeSpawnAt(BlockState blockUnder, LevelReader world, BlockPos pos, int xOffset, int zOffset) {
		Block block = blockUnder.getBlock();
		return block == world.getBlockState(pos.offset(xOffset, 0, zOffset)).getBlock() && block == world.getBlockState(pos.offset(xOffset + 1, 0, zOffset)).getBlock() && block == world.getBlockState(pos.offset(xOffset, 0, zOffset + 1)).getBlock() && block == world.getBlockState(pos.offset(xOffset + 1, 0, zOffset + 1)).getBlock();
	}
	
	public boolean spawn(WorldGenLevel world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, RandomSource random) {
		for (int i = 0; i >= -1; --i) {
			for (int j = 0; j >= -1; --j) {
				if (canBigTreeSpawnAt(blockUnder, world, pos, i, j)) {
					return this.bigTree(world, chunkGenerator, pos, blockUnder, random, i, j);
				}
			}
		}
		return super.spawn(world, chunkGenerator, pos, blockUnder, random);
	}
	
	@Nullable
	protected abstract ResourceKey<ConfiguredFeature<?, ?>> getBigTreeFeature(RandomSource random);
	
	public boolean bigTree(WorldGenLevel world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, RandomSource random, int xOffset, int zOffset) {
		ResourceKey<ConfiguredFeature<?, ?>> configuredTreeFeature = this.getBigTreeFeature(random);
		Holder<ConfiguredFeature<?, ?>> holder = world.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(configuredTreeFeature).orElse((Holder.Reference<ConfiguredFeature<?, ?>>)null);
        ConfiguredFeature<?, ?> configuredfeature = holder.value();
		if (configuredTreeFeature == null) {
			return false;
		} else {
			BlockState blockstate = Blocks.AIR.defaultBlockState();
			world.setBlock(pos.offset(xOffset, 0, zOffset), blockstate, 4);
			world.setBlock(pos.offset(xOffset + 1, 0, zOffset), blockstate, 4);
			world.setBlock(pos.offset(xOffset, 0, zOffset + 1), blockstate, 4);
			world.setBlock(pos.offset(xOffset + 1, 0, zOffset + 1), blockstate, 4);
			if (configuredfeature.place(world, chunkGenerator, random, pos.offset(xOffset, 0, zOffset))) {
				return true;
			} else {
				world.setBlock(pos.offset(xOffset, 0, zOffset), blockUnder, 4);
				world.setBlock(pos.offset(xOffset + 1, 0, zOffset), blockUnder, 4);
				world.setBlock(pos.offset(xOffset, 0, zOffset + 1), blockUnder, 4);
				world.setBlock(pos.offset(xOffset + 1, 0, zOffset + 1), blockUnder, 4);
				return false;
			}
		}
	}
}
