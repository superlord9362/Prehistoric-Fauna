package superlord.prehistoricfauna.world.worldtype;

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
import superlord.prehistoricfauna.world.dimension.WorldSeedHolder;

public class PrehistoricWorldTypeBiomeProvider extends BiomeProvider {

	public static final Codec<PrehistoricWorldTypeBiomeProvider> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
			Codec.LONG.fieldOf("seed").orElseGet(WorldSeedHolder::getSeed).forGetter((chunkGenerator) -> {
	            return chunkGenerator.seed;}),
			RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((obj) -> obj.registry)
			).apply(instance, instance.stable(PrehistoricWorldTypeBiomeProvider::new)));

	private final long seed;
	private final Registry<Biome> registry;
	private final Layer genBiomes;
	private static final List<RegistryKey<Biome>> biomes = ImmutableList.of(PFBiomes.HELL_CREEK_BIOME.getKey(), PFBiomes.HELL_CREEK_CLEARING_BIOME.getKey(), PFBiomes.HELL_CREEK_HILLS_BIOME.getKey(), PFBiomes.HELL_CREEK_RIVER_BIOME.getKey(), PFBiomes.ISCHIGUALASTO_CLEARING_BIOME.getKey(), PFBiomes.ISCHIGUALASTO_FOREST_BIOME.getKey(), PFBiomes.ISCHIGUALASTO_HILLS_BIOME.getKey(), PFBiomes.ISCHIGUALASTO_RIVER_BIOME.getKey(), PFBiomes.MORRISON_HILLS_BIOME.getKey(), PFBiomes.MORRISON_SAVANNAH_BIOME.getKey(), PFBiomes.DJADOCHTA_DUNES_BIOME.getKey(), PFBiomes.DJADOCHTA_ARROYO_BIOME.getKey(), PFBiomes.KAYENTA_DRY_FOREST_BIOME.getKey(), PFBiomes.KAYENTA_BUTTES_BIOME.getKey(), PFBiomes.KAYENTA_DESERT_BIOME.getKey(), PFBiomes.CHINLE_SWAMP_BIOME.getKey(), PFBiomes.CHINLE_FLATS_BIOME.getKey(), PFBiomes.CHINLE_WOODED_MOUNTAINS_BIOME.getKey());

	public PrehistoricWorldTypeBiomeProvider(long seed, Registry<Biome> registry) {
		super(biomes.stream().map(define -> () -> registry.getOrThrow(define)));
		this.seed = seed;
		this.registry = registry;
		this.genBiomes = PFWorldTypeLayerUtil.makeLayers(seed, registry);
	}

	@Override
	public BiomeProvider getBiomeProvider(long seed) {
		return new PrehistoricWorldTypeBiomeProvider(seed, registry);
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

