package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public abstract class SurfaceDecorator {
    public abstract void buildSurface(BlockPos.MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings);
}