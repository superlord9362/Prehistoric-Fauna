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

public class KayentaDryForestSB extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	public KayentaDryForestSB(Codec<SurfaceBuilderConfig> p_i51312_1_) {
		super(p_i51312_1_);
	}
	
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		if (noise > 1.95D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState()));
		} else if (noise < -1.9D && noise >= -2.3D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.SILT.getDefaultState()));
		} else if (noise < -2.3D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(PFBlocks.MOSSY_DIRT.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState()));
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.SILT.getDefaultState()));
		}
	}

}
