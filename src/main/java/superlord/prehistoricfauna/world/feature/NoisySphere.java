package superlord.prehistoricfauna.world.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.util.fastnoise.FastNoise;
import superlord.prehistoricfauna.world.feature.config.NoisySphereConfig;

import java.util.Random;
import java.util.function.Function;

public class NoisySphere extends Feature<NoisySphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public NoisySphere(Function<Dynamic<?>, ? extends NoisySphereConfig> configFactoryIn) {
        super(configFactoryIn);
    }


    @Override
    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random, BlockPos position, NoisySphereConfig config) {
        setSeed(world.getSeed());

        if (!config.getWhitelistedDimensions().contains(Registry.DIMENSION_TYPE.getKey(world.getDimension().getDimension().getType()))) {
            return false;
        }

        if (world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, position.getX(), position.getZ()) <= position.getY())
            return false;

        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(position.down(random.nextInt(3)));
        BlockPos.Mutable mutable2 = new BlockPos.Mutable().setPos(mutable);
        int stackHeight = random.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int xRadius = config.getRandomXRadius(random);
        int yRadius = config.getRandomYRadius(random);
        int zRadius = config.getRandomZRadius(random);

        for (int stackIDX = 0; stackIDX < stackHeight; stackIDX++) {
            for (int x = -xRadius; x <= xRadius; x++) {
                for (int z = -zRadius; z <= zRadius; z++) {
                    for (int y = -yRadius; y <= yRadius; y++) {
                        mutable2.setPos(mutable).move(x, y, z);
                        IChunk chunk = world.getChunk(mutable2);

                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(x, 2) / Math.pow(xRadius, 2) + Math.pow(y, 2) / Math.pow(yRadius, 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                        double threshold = 1 + 0.7 * fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                        if (equationResult >= threshold)
                            continue;

                        if (world.getBlockState(mutable2).isIn(Tags.Blocks.STONE))
                            world.setBlockState(mutable2, config.getBlockProvider().getBlockState(random, mutable2), 2);
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