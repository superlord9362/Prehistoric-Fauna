package superlord.prehistoricfauna.common.world.chunkgen;

import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.DensityFunction;
import superlord.prehistoricfauna.common.util.FastNoise;

public class FastNoiseDensityFunction implements DensityFunction.SimpleFunction {
    final FastNoise noise;
    final Function<NoiseContext, Double> transformer;

    protected FastNoiseDensityFunction(FastNoise noise, Function<NoiseContext, Double> transformer) {
        this.noise = noise;
        this.transformer = transformer;
    }

    protected FastNoiseDensityFunction(FastNoise noise) {
        this.noise = noise;
        this.transformer = (noiseContext -> (double) noiseContext.noise.GetSimplex((float) noiseContext.x, (float) noiseContext.y, (float) noiseContext.z));
    }

    protected FastNoiseDensityFunction(FastNoise noise, float offset) {
        this.noise = noise;
        this.transformer = (noiseContext -> (double) noiseContext.noise.GetSimplex((float) noiseContext.x, (float) noiseContext.y + offset, (float) noiseContext.z));
    }

    @Override
    public double compute(FunctionContext context) {
        return transformer.apply(new NoiseContext(this.noise, context.blockX(), context.blockY(), context.blockZ()));
    }

    @Override
    public double minValue() {
        return -1;
    }

    @Override
    public double maxValue() {
        return 1;
    }

    @Override
    public Codec<? extends DensityFunction> codec() {
        return null;
    }

    protected record NoiseContext(FastNoise noise, double x, double y, double z) {}
}