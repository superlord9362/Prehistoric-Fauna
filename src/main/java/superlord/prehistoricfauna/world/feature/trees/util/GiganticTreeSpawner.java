package superlord.prehistoricfauna.world.feature.trees.util;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import superlord.prehistoricfauna.world.feature.config.PFTreeConfig;

public abstract class GiganticTreeSpawner extends HugeTreeSpawner {

	public static boolean canGiantTreeSpawnAt(BlockState blockUnder, IBlockReader world, BlockPos pos, int xOffset, int zOffset) {
		Block block = blockUnder.getBlock();
		return block == world.getBlockState(pos.add(xOffset, 0, zOffset)).getBlock() && block == world.getBlockState(pos.add(xOffset + 1, 0, zOffset)).getBlock() && block == world.getBlockState(pos.add(xOffset - 1, 0, zOffset)).getBlock() && block == world.getBlockState(pos.add(xOffset - 1, 0, zOffset + 1)).getBlock() && block == world.getBlockState(pos.add(xOffset - 1, 0, zOffset - 1)).getBlock() && block == world.getBlockState(pos.add(xOffset, 0, zOffset - 1)).getBlock() && block == world.getBlockState(pos.add(xOffset + 1, 0, zOffset - 1)).getBlock() && block == world.getBlockState(pos.add(xOffset, 0, zOffset + 1)).getBlock() && block == world.getBlockState(pos.add(xOffset + 1, 0, zOffset + 1)).getBlock();
	}
	
	public boolean spawn(ISeedReader world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
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
	protected abstract ConfiguredFeature<PFTreeConfig, ?> getGiantTreeFeature(Random random);
	
	public boolean giantTree(ISeedReader world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random, int xOffset, int zOffset) {
		ConfiguredFeature<PFTreeConfig, ?> configuredTreeFeature = this.getGiantTreeFeature(random);
		if (configuredTreeFeature == null) {
			return false;
		} else {
			BlockState blockstate = Blocks.AIR.getDefaultState();
			world.setBlockState(pos.add(xOffset, 0, zOffset), blockstate, 4);
			world.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockstate, 4);
			world.setBlockState(pos.add(xOffset - 1, 0, zOffset), blockstate, 4);
			world.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockstate, 4);
			world.setBlockState(pos.add(xOffset, 0, zOffset - 1), blockstate, 4);
			world.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockstate, 4);
			world.setBlockState(pos.add(xOffset - 1, 0, zOffset + 1), blockstate, 4);
			world.setBlockState(pos.add(xOffset + 1, 0, zOffset - 1), blockstate, 4);
			world.setBlockState(pos.add(xOffset - 1, 0, zOffset - 1), blockstate, 4);
			configuredTreeFeature.config.forcePlacement();
			if (configuredTreeFeature.generate(world, chunkGenerator, random, pos.add(xOffset, 0, zOffset))) {
				return true;
			} else {
				world.setBlockState(pos.add(xOffset, 0, zOffset), blockUnder, 4);
				world.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockUnder, 4);
				world.setBlockState(pos.add(xOffset - 1, 0, zOffset), blockUnder, 4);
				world.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockUnder, 4);
				world.setBlockState(pos.add(xOffset, 0, zOffset - 1), blockUnder, 4);
				world.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockUnder, 4);
				world.setBlockState(pos.add(xOffset - 1, 0, zOffset + 1), blockUnder, 4);
				world.setBlockState(pos.add(xOffset + 1, 0, zOffset - 1), blockUnder, 4);
				world.setBlockState(pos.add(xOffset - 1, 0, zOffset - 1), blockUnder, 4);
				return false;
			}
		}
	}

}
