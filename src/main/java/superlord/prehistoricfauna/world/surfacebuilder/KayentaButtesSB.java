package superlord.prehistoricfauna.world.surfacebuilder;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class KayentaButtesSB extends SurfaceBuilder<SurfaceBuilderConfig> {

	public KayentaButtesSB(Codec<SurfaceBuilderConfig> p_i51312_1_) {
		super(p_i51312_1_);
	}
	
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		int height0 = random.nextInt(1) + 1;
		int height1 = random.nextInt(1) + 3;
		int height2 = random.nextInt(2) + 3 + height1;
		int height3 = random.nextInt(1) + 4 + height2;
		if (noise >= -0.25D && noise < 0.25) {
			for (int y = 0; y <= height0; y++) {
				BlockPos pos = new BlockPos(x, startHeight, z);
				BlockPos blockPos = pos.up(y);
				chunkIn.setBlockState(blockPos, Blocks.RED_SAND.getDefaultState(), false);
			}
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState()));
		}
		if (noise >= 0.25D && noise < 1D) {
			for (int y = 0; y <= height1; y++) {
				BlockPos pos = new BlockPos(x, startHeight, z);
				BlockPos blockPos = pos.up(y);
				chunkIn.setBlockState(blockPos, Blocks.ORANGE_TERRACOTTA.getDefaultState(), false);
			}
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState()));
		}
		if (noise >= 1D && noise < 1.5D) {
			for (int y = 0; y <= height2; y++) {
				BlockPos pos = new BlockPos(x, startHeight, z);
				BlockPos blockPos = pos.up(y);
				chunkIn.setBlockState(blockPos, Blocks.TERRACOTTA.getDefaultState(), false);
			}
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState()));
		}
		if (noise >= 1.5D && noise < 2.1D) {
			for (int y = 0; y <= height3; y++) {
				BlockPos pos = new BlockPos(x, startHeight, z);
				BlockPos blockPos = pos.up(y);
				chunkIn.setBlockState(blockPos, Blocks.WHITE_TERRACOTTA.getDefaultState(), false);
			}
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState()));
		} 
		if (noise >= 2D && noise < 2.5D) {
			for (int y = 0; y <= height2; y++) {
				BlockPos pos = new BlockPos(x, startHeight, z);
				BlockPos blockPos = pos.up(y);
				chunkIn.setBlockState(blockPos, Blocks.TERRACOTTA.getDefaultState(), false);
			}
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState()));
		}
		if (noise >= 2.5D && noise < 3.5D) {
			for (int y = 0; y <= height1; y++) {
				BlockPos pos = new BlockPos(x, startHeight, z);
				BlockPos blockPos = pos.up(y);
				chunkIn.setBlockState(blockPos, Blocks.ORANGE_TERRACOTTA.getDefaultState(), false);
			}
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState()));
		}
		if (noise >= 3.5D && noise < 4) {
			for (int y = 0; y <= height0; y++) {
				BlockPos pos = new BlockPos(x, startHeight, z);
				BlockPos blockPos = pos.up(y);
				chunkIn.setBlockState(blockPos, Blocks.RED_SAND.getDefaultState(), false);
			}
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState()));
		}
		if (noise < -1.5D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.SILT.getDefaultState()));
		}
		else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState()));
		}
	}
	
}
