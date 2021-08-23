package superlord.prehistoricfauna.world.dimension.triassic;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFBiomes;
import superlord.prehistoricfauna.world.dimension.PFChunkGenerator;

public class TriassicBiomeProvider extends BiomeProvider {
	
	public static final Codec<TriassicBiomeProvider> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
			Codec.LONG.fieldOf("seed").orElse(PFChunkGenerator.hackSeed).forGetter((obj) -> obj.seed),
			RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((obj) -> obj.registry)
			).apply(instance, instance.stable(TriassicBiomeProvider::new)));
	
	private final long seed;
	private final Registry<Biome> registry;
	private final Layer genBiomes;
	private static final List<RegistryKey<Biome>> biomes = ImmutableList.of(PFBiomes.ISCHIGUALASTO_FOREST_BIOME.getKey(), PFBiomes.ISCHIGUALASTO_CLEARING_BIOME.getKey(), PFBiomes.ISCHIGUALASTO_HILLS_BIOME.getKey(), PFBiomes.ISCHIGUALASTO_RIVER_BIOME.getKey());
	
	public TriassicBiomeProvider(long seed, Registry<Biome> registry) {
		super(biomes.stream().map(define -> () -> registry.getOrThrow(define)));
		this.seed = seed;
		this.registry = registry;
		this.genBiomes = TriassicLayerUtil.makeLayers(seed, registry);
	}
	
	@Override
	public BiomeProvider getBiomeProvider(long seed) {
		return new TriassicBiomeProvider(seed, registry);
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return this.getBiomeFromPos(registry, x, z);
	}

	@Override
	protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
		return CODEC;
	}
	
	public Biome getBiomeFromPos(Registry<Biome> registry, int x, int z) {
		int i = genBiomes.field_215742_b.getValue(x, z);
		Biome biome = registry.getByValue(i);
		if (biome == null) {
			if (SharedConstants.developmentMode) {
				throw Util.pauseDevMode(new IllegalStateException("Unkown biome id: " + i));
			} else {
				PrehistoricFauna.LOGGER.warn("Unknown biome id: ", i);
				return registry.getValueForKey(BiomeRegistry.getKeyFromID(0));
			}
		} else {
			return biome;
		}
	}

}

