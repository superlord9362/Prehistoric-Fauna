package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import superlord.prehistoricfauna.common.util.FastNoise;

public class FourNoiseBasedSurfaceDecorator extends SurfaceDecorator {
	private final BlockState topState_1, soilState_1, underwaterState_1, topState_2, soilState_2, underwaterState_2, topState_3, soilState_3, underwaterState_3, topState_4, soilState_4, underwaterState_4;
    private final int soilDepth;
    private final double noiseRange_1, noiseRange_2, noiseRange_3;
    FastNoise noise;
    
    public FourNoiseBasedSurfaceDecorator(BlockState topState_1, BlockState soilState_1, BlockState underwaterState_1, BlockState topState_2, BlockState soilState_2, BlockState underwaterState_2, BlockState topState_3, BlockState soilState_3, BlockState underwaterState_3, BlockState topState_4, BlockState soilState_4, BlockState underwaterState_4, double noiseRange_1, double noiseRange_2, double noiseRange_3, int soilDepth, FastNoise noise) {
        this.topState_1 = topState_1;
        this.soilState_1 = soilState_1;
        this.underwaterState_1 = underwaterState_1;
        this.topState_2 = topState_2;
        this.soilState_2 = soilState_2;
        this.underwaterState_2 = underwaterState_2;
        this.topState_3 = topState_3;
        this.soilState_3 = soilState_3;
        this.underwaterState_3 = underwaterState_3;
        this.topState_4 = topState_4;
        this.soilState_4 = soilState_4;
        this.underwaterState_4 = underwaterState_4;
        this.soilDepth = soilDepth;
        this.noiseRange_1 = noiseRange_1;
        this.noiseRange_2 = noiseRange_2;
        this.noiseRange_3 = noiseRange_3;
        this.noise = noise;
        SurfaceDecorators.setFastNoise(this.noise);
    }
    
	public void buildSurface(MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings, FastNoise noise) {
		SurfaceDecorators.setFastNoise(noise);
		boolean underwater = !chunk.getFluidState(pos.above()).isEmpty();
        if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < this.noiseRange_1) {
        	chunk.setBlockState(pos, underwater ? underwaterState_1 : topState_1, false);
            pos.move(Direction.DOWN);
            for (int i = 0; i < this.soilDepth; i++) {
                if (chunk.getBlockState(pos) == settings.defaultBlock()) {
                    chunk.setBlockState(pos, soilState_1, false);
                    pos.move(Direction.DOWN);
                } else {
                    return;
                }
            }
        } else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= this.noiseRange_1 && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) < this.noiseRange_2) {
        	chunk.setBlockState(pos, underwater ? underwaterState_2 : topState_2, false);
            pos.move(Direction.DOWN);
            for (int i = 0; i < this.soilDepth; i++) {
                if (chunk.getBlockState(pos) == settings.defaultBlock()) {
                    chunk.setBlockState(pos, soilState_2, false);
                    pos.move(Direction.DOWN);
                } else {
                    return;
                }
            }
        } else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) >= this.noiseRange_2 && noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) <= this.noiseRange_3) {
        	chunk.setBlockState(pos, underwater ? underwaterState_3 : topState_3, false);
            pos.move(Direction.DOWN);
            for (int i = 0; i < this.soilDepth; i++) {
                if (chunk.getBlockState(pos) == settings.defaultBlock()) {
                    chunk.setBlockState(pos, soilState_3, false);
                    pos.move(Direction.DOWN);
                } else {
                    return;
                }
            }
        } else if (noise.GetNoise(pos.getX(), pos.getY(), pos.getZ()) > this.noiseRange_3) {
        	chunk.setBlockState(pos, underwater? underwaterState_4 : topState_4, false);
        	pos.move(Direction.DOWN);
        	for (int i = 0; i < this.soilDepth; i++) {
        		if (chunk.getBlockState(pos) == settings.defaultBlock()) {
        			chunk.setBlockState(pos, soilState_4, false);
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
