package superlord.prehistoricfauna.common.util.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public abstract class GiganticTreeSpawner extends HugeTreeSpawner {

	public static boolean canGiantTreeSpawnAt(BlockState blockUnder, LevelReader world, BlockPos pos, int xOffset, int zOffset) {
		Block block = blockUnder.getBlock();
		return block == world.getBlockState(pos.offset(xOffset, 0, zOffset)).getBlock() && block == world.getBlockState(pos.offset(xOffset + 1, 0, zOffset)).getBlock() && block == world.getBlockState(pos.offset(xOffset - 1, 0, zOffset)).getBlock() && block == world.getBlockState(pos.offset(xOffset - 1, 0, zOffset + 1)).getBlock() && block == world.getBlockState(pos.offset(xOffset - 1, 0, zOffset - 1)).getBlock() && block == world.getBlockState(pos.offset(xOffset, 0, zOffset - 1)).getBlock() && block == world.getBlockState(pos.offset(xOffset + 1, 0, zOffset - 1)).getBlock() && block == world.getBlockState(pos.offset(xOffset, 0, zOffset + 1)).getBlock() && block == world.getBlockState(pos.offset(xOffset + 1, 0, zOffset + 1)).getBlock();
	}
	
	public boolean spawn(WorldGenLevel world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
		for (int i = 1; i >= -1; --i) {
			for (int j = 1; j >= -1; --j) {
				if (canGiantTreeSpawnAt(blockUnder, world, pos, i, j)) {
					return this.giantTree(world, chunkGenerator, pos, blockUnder, random, i, j);
				}
			}
		}
		return super.spawn(world, chunkGenerator, pos, blockUnder, random);
	}
	
	@Nullable
	protected abstract ConfiguredFeature<?, ?> getGiantTreeFeature(Random random);
	
	public boolean giantTree(WorldGenLevel world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random, int xOffset, int zOffset) {
		ConfiguredFeature<?, ?> configuredTreeFeature = this.getGiantTreeFeature(random);
		if (configuredTreeFeature == null) {
			return false;
		} else {
			BlockState blockstate = Blocks.AIR.defaultBlockState();
			world.setBlock(pos.offset(xOffset, 0, zOffset), blockstate, 4);
			world.setBlock(pos.offset(xOffset + 1, 0, zOffset), blockstate, 4);
			world.setBlock(pos.offset(xOffset - 1, 0, zOffset), blockstate, 4);
			world.setBlock(pos.offset(xOffset, 0, zOffset + 1), blockstate, 4);
			world.setBlock(pos.offset(xOffset, 0, zOffset - 1), blockstate, 4);
			world.setBlock(pos.offset(xOffset + 1, 0, zOffset + 1), blockstate, 4);
			world.setBlock(pos.offset(xOffset - 1, 0, zOffset + 1), blockstate, 4);
			world.setBlock(pos.offset(xOffset + 1, 0, zOffset - 1), blockstate, 4);
			world.setBlock(pos.offset(xOffset - 1, 0, zOffset - 1), blockstate, 4);
			if (configuredTreeFeature.place(world, chunkGenerator, random, pos.offset(xOffset, 0, zOffset))) {
				return true;
			} else {
				world.setBlock(pos.offset(xOffset, 0, zOffset), blockUnder, 4);
				world.setBlock(pos.offset(xOffset + 1, 0, zOffset), blockUnder, 4);
				world.setBlock(pos.offset(xOffset - 1, 0, zOffset), blockUnder, 4);
				world.setBlock(pos.offset(xOffset, 0, zOffset + 1), blockUnder, 4);
				world.setBlock(pos.offset(xOffset, 0, zOffset - 1), blockUnder, 4);
				world.setBlock(pos.offset(xOffset + 1, 0, zOffset + 1), blockUnder, 4);
				world.setBlock(pos.offset(xOffset - 1, 0, zOffset + 1), blockUnder, 4);
				world.setBlock(pos.offset(xOffset + 1, 0, zOffset - 1), blockUnder, 4);
				world.setBlock(pos.offset(xOffset - 1, 0, zOffset - 1), blockUnder, 4);
				return false;
			}
		}
	}

}
