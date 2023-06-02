package superlord.prehistoricfauna.common.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.feature.trees.util.JohnstoniaConfig;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.common.util.NoisySphereConfig;

@SuppressWarnings("unused")
public class NoisySphereFeature extends Feature<NoisySphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public NoisySphereFeature(Codec<NoisySphereConfig> configFactoryIn) {
        super(configFactoryIn);
    }


	@Override
	public boolean place(FeaturePlaceContext<NoisySphereConfig> context) {
		BlockPos position = context.origin();
		Random random = new Random();
		WorldGenLevel world = context.level();
		NoisySphereConfig config = context.config();
        setSeed(world.getSeed());

        if (world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, position.getX(), position.getZ()) <= position.getY())
            return false;

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(position.below(random.nextInt(3)));
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(mutable);
        int stackHeight = random.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int xRadius = config.getRandomXRadius(random);
        int yRadius = config.getRandomYRadius(random);
        int zRadius = config.getRandomZRadius(random);

        for (int stackIDX = 0; stackIDX < stackHeight; stackIDX++) {
            for (int x = -xRadius; x <= xRadius; x++) {
                for (int z = -zRadius; z <= zRadius; z++) {
                    for (int y = -yRadius; y <= yRadius; y++) {
                        mutable2.set(mutable).move(x, y, z);
                        ChunkAccess chunk = world.getChunk(mutable2);

                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(x, 2) / Math.pow(xRadius, 2) + Math.pow(y, 2) / Math.pow(yRadius, 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                        double threshold = 1 + 0.7 * fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                        if (equationResult >= threshold)
                            continue;

                        if (world.getBlockState(mutable2).is(Tags.Blocks.STONE))
                            world.setBlock(mutable2, config.getBlockProvider().getState(random, mutable2), 2);
                    }
                    xRadius = (int) (xRadius / config.getRadiusDivisorPerStack());
                    yRadius = (int) (yRadius / config.getRadiusDivisorPerStack());
                    zRadius = (int) (zRadius / config.getRadiusDivisorPerStack());
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            fastNoise.SetFrequency(0.09f);
            this.seed = seed;
        }
    }
}
