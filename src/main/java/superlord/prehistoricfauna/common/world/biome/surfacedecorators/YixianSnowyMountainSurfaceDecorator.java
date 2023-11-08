package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.init.PFBlocks;

public class YixianSnowyMountainSurfaceDecorator extends SurfaceDecorator {
	FastNoise noise;

	public YixianSnowyMountainSurfaceDecorator(FastNoise noise) {
		this.noise = noise;
		SurfaceDecorators.setFastNoise(this.noise);
	}
	
	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings, FastNoise noise) {
		boolean underwater = !chunk.getFluidState(pos.above()).isEmpty();
		if (pos.getY() > 85) {
			chunk.setBlockState(pos, underwater ? Blocks.GRAVEL.defaultBlockState() : Blocks.SNOW_BLOCK.defaultBlockState(), false);
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
				chunk.setBlockState(pos, underwater ? Blocks.CLAY.defaultBlockState() : Blocks.PODZOL.defaultBlockState(), false);
	            pos.move(Direction.DOWN);
	            for (int i = 0; i < 4; i++) {
	                if (chunk.getBlockState(pos) == settings.defaultBlock()) {
	                    chunk.setBlockState(pos, Blocks.DIRT.defaultBlockState(), false);
	                    pos.move(Direction.DOWN);
	                } else {
	                    return;
	                }
	            }
			} else {
				chunk.setBlockState(pos, underwater ? Blocks.SAND.defaultBlockState() : PFBlocks.MOSSY_DIRT.get().defaultBlockState(), false);
	            pos.move(Direction.DOWN);
	            for (int i = 0; i < 4; i++) {
	                if (chunk.getBlockState(pos) == settings.defaultBlock()) {
	                    chunk.setBlockState(pos, Blocks.DIRT.defaultBlockState(), false);
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
