package superlord.prehistoricfauna.world.surfacebuilder;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;
import java.util.function.Function;

public class PetrifiedForestSB extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	public PetrifiedForestSB(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
		super(p_i51312_1_);
	}

	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		if (noise > 1.75D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(BlockInit.SILT.getDefaultState(), BlockInit.HARDENED_SILT.getDefaultState(), BlockInit.HARDENED_SILT.getDefaultState()));
		} else if (noise > 1.2D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState()));
		} else if (noise > 0.7D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState(), Blocks.TERRACOTTA.getDefaultState()));
		} else if (noise > 0.2D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.GRAVEL.getDefaultState(), Blocks.GRAVEL.getDefaultState(), Blocks.GRAVEL.getDefaultState()));
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(BlockInit.SILT.getDefaultState(), BlockInit.HARDENED_SILT.getDefaultState(), Blocks.CLAY.getDefaultState()));
		}
	}
}
