package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.init.PFBlocks;

public class DjadochtaAlluvialPlainsSurfaceDecorator extends SurfaceDecorator {
	FastNoise noise;

	public DjadochtaAlluvialPlainsSurfaceDecorator(FastNoise noise) {
		this.noise = noise;
		SurfaceDecorators.setFastNoise(this.noise);
	}
	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings, FastNoise noise) {
		SurfaceDecorators.setFastNoise(noise);
		boolean underwater = !chunk.getFluidState(pos.above()).isEmpty();
		if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.5D) {
			chunk.setBlockState(pos, underwater ? PFBlocks.SILT.get().defaultBlockState() : Blocks.GRAVEL.defaultBlockState(), false);
			pos.move(Direction.DOWN);
			for (int i = 0; i < 4; i++) {
				if (chunk.getBlockState(pos) == settings.defaultBlock()) {
					chunk.setBlockState(pos, Blocks.TERRACOTTA.defaultBlockState(), false);
					pos.move(Direction.DOWN);
				} else {
					return;
				}
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.4D) {
			chunk.setBlockState(pos, underwater ? PFBlocks.SILT.get().defaultBlockState() : PFBlocks.HARDENED_SILT.get().defaultBlockState(), false);
			pos.move(Direction.DOWN);
			for (int i = 0; i < 4; i++) {
				if (chunk.getBlockState(pos) == settings.defaultBlock()) {
					chunk.setBlockState(pos, PFBlocks.HARDENED_SILT.get().defaultBlockState(), false);
					pos.move(Direction.DOWN);
				} else {
					return;
				}
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.2D) {
			chunk.setBlockState(pos, underwater ? PFBlocks.SILT.get().defaultBlockState() : PFBlocks.SILT.get().defaultBlockState(), false);
			pos.move(Direction.DOWN);
			for (int i = 0; i < 4; i++) {
				if (chunk.getBlockState(pos) == settings.defaultBlock()) {
					chunk.setBlockState(pos, PFBlocks.HARDENED_SILT.get().defaultBlockState(), false);
					pos.move(Direction.DOWN);
				} else {
					return;
				}
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0D) {
			chunk.setBlockState(pos, underwater ? PFBlocks.SILT.get().defaultBlockState() : PFBlocks.HARDENED_SILT.get().defaultBlockState(), false);
			pos.move(Direction.DOWN);
			for (int i = 0; i < 4; i++) {
				if (chunk.getBlockState(pos) == settings.defaultBlock()) {
					chunk.setBlockState(pos, PFBlocks.HARDENED_SILT.get().defaultBlockState(), false);
					pos.move(Direction.DOWN);
				} else {
					return;
				}
			}
		} else {
			chunk.setBlockState(pos, underwater ? PFBlocks.SILT.get().defaultBlockState() : Blocks.SAND.defaultBlockState(), false);
			pos.move(Direction.DOWN);
			for (int i = 0; i < 4; i++) {
				if (chunk.getBlockState(pos) == settings.defaultBlock()) {
					chunk.setBlockState(pos, Blocks.TERRACOTTA.defaultBlockState(), false);
					pos.move(Direction.DOWN);
				} else {
					return;
				}
			}
		}
	}

	@Override
	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings) {
		FastNoise noise = new FastNoise();
		this.buildSurface(pos, seaLevel, canSeeSun, chunk, settings, noise);
	}
}
