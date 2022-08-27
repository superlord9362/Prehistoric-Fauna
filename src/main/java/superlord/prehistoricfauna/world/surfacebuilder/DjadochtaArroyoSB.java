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

public class DjadochtaArroyoSB extends SurfaceBuilder<SurfaceBuilderConfig> {

	public DjadochtaArroyoSB(Codec<SurfaceBuilderConfig> p_i51312_1_) {
		super(p_i51312_1_);
	}

	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		if (noise > 1.75D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(PFBlocks.SILT.getDefaultState(), Blocks.TERRACOTTA.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState()));
		} else if (noise > 1.2D) {
			for (int i = 63; i < 80; i++) {
				BlockPos pos = new BlockPos(x, i, z);
				chunkIn.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
			}
			if (startHeight > 62 || startHeight < 62) {
				startHeight = 62;
				SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(PFBlocks.LOAM.getDefaultState(), PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState()));
			}
		} else if (noise > 0.2D) {
			for (int i = 63; i < 80; i++) {
				BlockPos pos = new BlockPos(x, i, z);
				chunkIn.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
			}
			if (startHeight > 62 || startHeight < 62) {
				startHeight = 62;
				SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.WATER.getDefaultState(), PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState()));
			}
		} else if (noise > -0.3D) {
			for (int i = 63; i < 80; i++) {
				BlockPos pos = new BlockPos(x, i, z);
				chunkIn.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
			}
			if (startHeight > 62 || startHeight < 62) {
				startHeight = 62;
				SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(PFBlocks.LOAM.getDefaultState(), PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState()));
			}
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), Blocks.TERRACOTTA.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState()));
		}
	}
}