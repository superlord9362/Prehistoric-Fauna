package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.init.PFBlocks;

public class KayentaCanyonsSurfaceDecorator extends SurfaceDecorator {
	FastNoise noise;

	public KayentaCanyonsSurfaceDecorator(FastNoise noise) {
		this.noise = noise;
		SurfaceDecorators.setFastNoise(this.noise);
	}

	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings, FastNoise noise) {
		int height0 = pos.getY() - 3;
		int height1 = pos.getY() - 5;
		int height2 = height1 - 5;
		int height3 = height2 - 6;
		boolean underwater = !chunk.getFluidState(pos.above()).isEmpty();

		if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.1D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.2) {
			for (int y = pos.getY(); y >= height2; y--) {
				if (y > height0) chunk.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
				else chunk.setBlockState(pos, Blocks.ORANGE_TERRACOTTA.defaultBlockState(), false);
				pos.move(Direction.DOWN);
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.2D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.3) {
			for (int y = pos.getY(); y >= height3; y--) {
				if (y > height2) chunk.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
				else chunk.setBlockState(pos, Blocks.TERRACOTTA.defaultBlockState(), false);
				pos.move(Direction.DOWN);
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.3D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.4) {
			for (int y = pos.getY(); y >= height3; y--) {
				if (y == height3) chunk.setBlockState(pos, Blocks.WHITE_TERRACOTTA.defaultBlockState(), false);
				else chunk.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
				pos.move(Direction.DOWN);
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.4D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.5) {
			for (int y = pos.getY(); y >= height3; y--) {
				if (y > height2) chunk.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
				else chunk.setBlockState(pos, Blocks.TERRACOTTA.defaultBlockState(), false);
				pos.move(Direction.DOWN);
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.5D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.6) {
			for (int y = pos.getY(); y >= height2; y--) {
				if (y > height0) chunk.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
				else chunk.setBlockState(pos, Blocks.ORANGE_TERRACOTTA.defaultBlockState(), false);
				pos.move(Direction.DOWN);
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.6) {
			chunk.setBlockState(pos, underwater ? Blocks.RED_SAND.defaultBlockState() : Blocks.RED_SAND.defaultBlockState(), false);
			pos.move(Direction.DOWN);
			for (int i = 0; i < 4; i++) {
				if (chunk.getBlockState(pos) == settings.defaultBlock()) {
					chunk.setBlockState(pos, Blocks.RED_SANDSTONE.defaultBlockState(), false);
					pos.move(Direction.DOWN);
				} else {
					return;
				}
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < -0.35) {
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
		} else {
			chunk.setBlockState(pos, underwater ? Blocks.RED_SAND.defaultBlockState() : Blocks.RED_SAND.defaultBlockState(), false);
			pos.move(Direction.DOWN);
			for (int i = 0; i < 4; i++) {
				if (chunk.getBlockState(pos) == settings.defaultBlock()) {
					chunk.setBlockState(pos, Blocks.RED_SANDSTONE.defaultBlockState(), false);
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
