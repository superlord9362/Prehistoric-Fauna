package superlord.prehistoricfauna.world.surfacebuilder;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class ChinleSwampSB extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	public ChinleSwampSB(Codec<SurfaceBuilderConfig> config) {
		super(config);
	}
	
	public void buildSurface(Random random, IChunk chunk, Biome biome, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		if (noise > 1.75D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.PODZOL.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState()));
		} else if (noise > -0.95D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(PFBlocks.LOAM.getDefaultState(), PFBlocks.PACKED_LOAM.getDefaultState(), Blocks.CLAY.getDefaultState()));
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(PFBlocks.MOSSY_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState()));
		}
	}

}
