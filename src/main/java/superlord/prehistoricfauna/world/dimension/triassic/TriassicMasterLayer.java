package superlord.prehistoricfauna.world.dimension.triassic;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;
import superlord.prehistoricfauna.util.fastnoise.FastNoise;

public class TriassicMasterLayer implements IAreaTransformer0 {
    private final Registry<Biome> biomeRegistry;
    @SuppressWarnings("unused")
	private final long seed;
    private final FastNoise fastNoise;

    public TriassicMasterLayer(Registry<Biome> biomeRegistry, long seed) {
        this.biomeRegistry = biomeRegistry;
        this.seed = seed;
        fastNoise = new FastNoise((int) seed);
        fastNoise.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
        fastNoise.SetFractalType(FastNoise.FractalType.RigidMulti);
        fastNoise.SetFrequency(0.012F);
    }

    @Override
    public int apply(INoiseRandom rand, int x, int z) {
        return getRandomBiomes(this.biomeRegistry, rand);
    }

    public static int getRandomBiomes(Registry<Biome> biomeRegistry, INoiseRandom rand) {
        return biomeRegistry.getId(biomeRegistry.getOrDefault(TriassicBiomeProvider.BIOMES.get(rand.random(TriassicBiomeProvider.BIOMES.size()))));
    }
}
