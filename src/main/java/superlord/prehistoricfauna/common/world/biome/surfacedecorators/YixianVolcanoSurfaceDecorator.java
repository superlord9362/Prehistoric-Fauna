package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import java.util.Random;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import superlord.prehistoricfauna.common.util.FastNoise;

public class YixianVolcanoSurfaceDecorator extends SurfaceDecorator {
	FastNoise noise;

	public YixianVolcanoSurfaceDecorator(FastNoise noise) {
		this.noise = noise;
		SurfaceDecorators.setFastNoise(this.noise);
	}

	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings, FastNoise noise) {
		boolean underwater = !chunk.getFluidState(pos.above()).isEmpty();
		Random random = new Random();
		if (pos.getY() > 100) {
			if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.6D || noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.2 && noise.GetValue(pos.getX(), pos.getY(), pos.getZ()) > -0.4) {
				chunk.setBlockState(pos, underwater ? Blocks.GRAVEL.defaultBlockState() : Blocks.GRAVEL.defaultBlockState(), false);
				pos.move(Direction.DOWN);
				for (int i = 0; i < 4; i++) {
					if (chunk.getBlockState(pos) == settings.defaultBlock()) {
						chunk.setBlockState(pos, Blocks.GRAVEL.defaultBlockState(), false);
						pos.move(Direction.DOWN);
					} else {
						return;
					}
				}
			} else {
				int number = random.nextInt(100);
				if (number <= 5) {
					chunk.setBlockState(pos, underwater ? Blocks.ANDESITE.defaultBlockState() : Blocks.LAVA.defaultBlockState(), false);
					pos.move(Direction.DOWN);
					for (int i = 0; i < 4; i++) {
						if (chunk.getBlockState(pos) == settings.defaultBlock()) {
							chunk.setBlockState(pos, Blocks.LAVA.defaultBlockState(), false);
							pos.move(Direction.DOWN);
						} else {
							return;
						}
					}
				} else {
					chunk.setBlockState(pos, underwater ? Blocks.ANDESITE.defaultBlockState() : Blocks.BASALT.defaultBlockState(), false);
					pos.move(Direction.DOWN);
					for (int i = 0; i < 4; i++) {
						if (chunk.getBlockState(pos) == settings.defaultBlock()) {
							chunk.setBlockState(pos, Blocks.BASALT.defaultBlockState(), false);
							pos.move(Direction.DOWN);
						} else {
							return;
						}
					}
				}
			}
		}
		if (pos.getY() > 85) {
			if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.6D || noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < 0.2 && noise.GetValue(pos.getX(), pos.getY(), pos.getZ()) > -0.4) {
				chunk.setBlockState(pos, underwater ? Blocks.GRAVEL.defaultBlockState() : Blocks.GRAVEL.defaultBlockState(), false);
				pos.move(Direction.DOWN);
				for (int i = 0; i < 4; i++) {
					if (chunk.getBlockState(pos) == settings.defaultBlock()) {
						chunk.setBlockState(pos, Blocks.GRAVEL.defaultBlockState(), false);
						pos.move(Direction.DOWN);
					} else {
						return;
					}
				}
			} else {
				chunk.setBlockState(pos, underwater ? Blocks.ANDESITE.defaultBlockState() : Blocks.BASALT.defaultBlockState(), false);
				pos.move(Direction.DOWN);
				for (int i = 0; i < 4; i++) {
					if (chunk.getBlockState(pos) == settings.defaultBlock()) {
						chunk.setBlockState(pos, Blocks.BASALT.defaultBlockState(), false);
						pos.move(Direction.DOWN);
					} else {
						return;
					}
				}
			}
		} else {
			if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.6D) {
				chunk.setBlockState(pos, underwater ? Blocks.GRAVEL.defaultBlockState() : Blocks.GRAVEL.defaultBlockState(), false);
				pos.move(Direction.DOWN);
				for (int i = 0; i < 4; i++) {
					if (chunk.getBlockState(pos) == settings.defaultBlock()) {
						chunk.setBlockState(pos, Blocks.GRAVEL.defaultBlockState(), false);
						pos.move(Direction.DOWN);
					} else {
						return;
					}
				}
			} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < -0.3D) {
				chunk.setBlockState(pos, underwater ? Blocks.ANDESITE.defaultBlockState() : Blocks.BASALT.defaultBlockState(), false);
				pos.move(Direction.DOWN);
				for (int i = 0; i < 4; i++) {
					if (chunk.getBlockState(pos) == settings.defaultBlock()) {
						chunk.setBlockState(pos, Blocks.BASALT.defaultBlockState(), false);
						pos.move(Direction.DOWN);
					} else {
						return;
					}
				}
			} else {
				chunk.setBlockState(pos, underwater ? Blocks.BASALT.defaultBlockState() : Blocks.ANDESITE.defaultBlockState(), false);
				pos.move(Direction.DOWN);
				for (int i = 0; i < 4; i++) {
					if (chunk.getBlockState(pos) == settings.defaultBlock()) {
						chunk.setBlockState(pos, Blocks.ANDESITE.defaultBlockState(), false);
						pos.move(Direction.DOWN);
					} else {
						return;
					}
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
