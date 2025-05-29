package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class LayeredSurfaceDecorator extends SurfaceDecorator {
    private final BlockState topState, soilState, underwaterState;
    private final int soilDepth;

    public LayeredSurfaceDecorator(BlockState topState, BlockState soilState, BlockState underwaterState, int soilDepth) {
        this.topState = topState;
        this.soilState = soilState;
        this.underwaterState = underwaterState;
        this.soilDepth = soilDepth;
    }

    @Override
    public void buildSurface(BlockPos.MutableBlockPos pos, int seaLevel, boolean canSeeSun, ChunkAccess chunk, NoiseGeneratorSettings settings) {
        boolean underwater = !chunk.getFluidState(pos.above()).isEmpty();
        chunk.setBlockState(pos, underwater ? underwaterState : topState, false);
        pos.move(Direction.DOWN);
        for (int i = 0; i < this.soilDepth; i++) {
            if (chunk.getBlockState(pos) == settings.defaultBlock()) {
                if (i == 0 || i == 2) chunk.setBlockState(pos, soilState, false);
                else chunk.setBlockState(pos, topState, false);
                pos.move(Direction.DOWN);
            } else {
                return;
            }
        }
    }
}