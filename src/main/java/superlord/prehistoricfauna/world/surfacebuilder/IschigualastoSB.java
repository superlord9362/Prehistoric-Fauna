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

public class IschigualastoSB extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	public IschigualastoSB(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
		super(p_i51312_1_);
	}

	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		if (noise > 1.75D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.PODZOL.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.GRAVEL.getDefaultState()));
		} else if (noise > -0.95D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(BlockInit.LOAM.getDefaultState(), BlockInit.LOAM.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState()));
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.CLAY.getDefaultState()));
		}
	}
}
