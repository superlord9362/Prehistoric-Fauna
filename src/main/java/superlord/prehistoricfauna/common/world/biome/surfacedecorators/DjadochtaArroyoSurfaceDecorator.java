package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.init.PFBlocks;

public class DjadochtaArroyoSurfaceDecorator extends SurfaceDecorator {
	FastNoise noise;

	public DjadochtaArroyoSurfaceDecorator(FastNoise noise) {
		this.noise = noise;
		SurfaceDecorators.setFastNoise(this.noise);
	}
	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings, FastNoise noise) {
		SurfaceDecorators.setFastNoise(noise);
		boolean underwater = !chunk.getFluidState(pos.above()).isEmpty();
        if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.5D) {
        	chunk.setBlockState(pos, underwater ? PFBlocks.SILT.get().defaultBlockState() : PFBlocks.SILT.get().defaultBlockState(), false);
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
			for (int i = 64; i < 100; i++) {
				BlockPos pos1 = new BlockPos(pos.getX(), i, pos.getZ());
				chunk.setBlockState(pos1, Blocks.AIR.defaultBlockState(), false);
			}
			if (pos.getY() != 63) {
				pos.setY(63);
				chunk.setBlockState(pos, underwater ? PFBlocks.SILT.get().defaultBlockState() : PFBlocks.LOAM.get().defaultBlockState(), false);
	            pos.move(Direction.DOWN);
	            for (int i = 0; i < 4; i++) {
	                if (chunk.getBlockState(pos) == settings.defaultBlock()) {
	                    chunk.setBlockState(pos, PFBlocks.HARDENED_SILT.get().defaultBlockState(), false);
	                    pos.move(Direction.DOWN);
	                } else {
	                    return;
	                }
	            }
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0.2D) {
			for (int i = 64; i < 100; i++) {
				BlockPos pos1 = new BlockPos(pos.getX(), i, pos.getZ());
				chunk.setBlockState(pos1, Blocks.AIR.defaultBlockState(), false);
			}
			if (pos.getY() != 63) {
				pos.setY(63);
				chunk.setBlockState(pos, underwater ? PFBlocks.SILT.get().defaultBlockState() : Blocks.WATER.defaultBlockState(), false);
				pos.move(Direction.DOWN);
	            for (int i = 0; i < 4; i++) {
	                if (chunk.getBlockState(pos) == settings.defaultBlock()) {
	                    chunk.setBlockState(pos, PFBlocks.SILT.get().defaultBlockState(), false);
	                    pos.move(Direction.DOWN);
	                } else {
	                    return;
	                }
	            }
			}
		} else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > 0D) {
			for (int i = 64; i < 100; i++) {
				BlockPos pos1 = new BlockPos(pos.getX(), i, pos.getZ());
				chunk.setBlockState(pos1, Blocks.AIR.defaultBlockState(), false);
			}
			if (pos.getY() != 63) {
				pos.setY(63);
				chunk.setBlockState(pos, underwater ? PFBlocks.SILT.get().defaultBlockState() : PFBlocks.LOAM.get().defaultBlockState(), false);
	            pos.move(Direction.DOWN);
	            for (int i = 0; i < 4; i++) {
	                if (chunk.getBlockState(pos) == settings.defaultBlock()) {
	                    chunk.setBlockState(pos, PFBlocks.SILT.get().defaultBlockState(), false);
	                    pos.move(Direction.DOWN);
	                } else {
	                    return;
	                }
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
