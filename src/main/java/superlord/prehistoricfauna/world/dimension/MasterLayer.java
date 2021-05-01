package superlord.prehistoricfauna.world.dimension;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

import java.util.Comparator;
import java.util.List;

public class MasterLayer implements IAreaTransformer0 {
    private final Registry<Biome> biomeRegistry;
    private final List<ResourceLocation> biomes;

    public MasterLayer(Registry<Biome> biomeRegistry, long seed, List<ResourceLocation> biomes) {
        this.biomeRegistry = biomeRegistry;
        this.biomes = biomes;
        this.biomes.sort(Comparator.comparing(ResourceLocation::toString));
    }

    @Override
    public int apply(INoiseRandom rand, int x, int z) {
        return getRandomBiomes(this.biomeRegistry, rand);
    }

    private int getRandomBiomes(Registry<Biome> biomeRegistry, INoiseRandom rand) {
        return biomeRegistry.getId(biomeRegistry.getOrDefault(this.biomes.get(rand.random(this.biomes.size()))));
    }
}