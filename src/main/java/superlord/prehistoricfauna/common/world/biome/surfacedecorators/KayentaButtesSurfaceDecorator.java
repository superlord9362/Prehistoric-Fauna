package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import java.util.Random;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.init.PFBlocks;

public class KayentaButtesSurfaceDecorator extends SurfaceDecorator {
	FastNoise noise;

	public KayentaButtesSurfaceDecorator(FastNoise noise) {
		this.noise = noise;
		SurfaceDecorators.setFastNoise(this.noise);
	}

	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings, FastNoise noise) {
		Random random = new Random();
		int height0 = random.nextInt(1) + 1 + pos.getY();
		int height1 = random.nextInt(1) + 3 + pos.getY();
		int height2 = random.nextInt(2) + 3 + height1;
		int height3 = random.nextInt(1) + 4 + height2;
		boolean underwater = !chunk.getFluidState(pos.above()).isEmpty();

		if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.1D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.2) {
			for (int y = pos.getY(); y <= height0; y++) {
				chunk.setBlockState(pos, Blocks.ORANGE_TERRACOTTA.defaultBlockState(), false);
				pos.move(Direction.UP);
			}
		}
		if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.2D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.3) {
			for (int y = pos.getY(); y <= height2; y++) {
				chunk.setBlockState(pos, Blocks.TERRACOTTA.defaultBlockState(), false);
				pos.move(Direction.UP);
			}
		}
		if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.3D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.4) {
			for (int y = pos.getY(); y <= height3; y++) {
				chunk.setBlockState(pos, Blocks.WHITE_TERRACOTTA.defaultBlockState(), false);
				pos.move(Direction.UP);
			}
		}
		if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.4D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.5) {
			for (int y = pos.getY(); y <= height2; y++) {
				chunk.setBlockState(pos, Blocks.TERRACOTTA.defaultBlockState(), false);
				pos.move(Direction.UP);
			}
		}
		if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= 0.5D && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.6) {
			for (int y = pos.getY(); y <= height0; y++) {
				chunk.setBlockState(pos, Blocks.ORANGE_TERRACOTTA.defaultBlockState(), false);
				pos.move(Direction.UP);
			}
		}
		if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.5) {
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
