package superlord.prehistoricfauna.common.world.biome.biomesource;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager.NoiseBiomeSource;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate.Sampler;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.common.world.chunkgen.TriassicChunkGenerator;
import superlord.prehistoricfauna.init.PFBiomes;

public class TriassicBiomeSource extends BiomeSource implements NoiseBiomeSource {	

	public static final Codec<TriassicBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(TriassicBiomeSource::new));
	});

	private final Holder<Biome> chinleRiver, chinleFlats, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoForest, ischigualastoClearing, ischigualastoHills, prehistoricDripstoneCave;

	public TriassicBiomeSource(Registry<Biome> biome) {
		this(biome.getOrCreateHolder(PFBiomes.CHINLE_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.CHINLE_FLATS.getKey()), biome.getOrCreateHolder(PFBiomes.CHINLE_SWAMP.getKey()), biome.getOrCreateHolder(PFBiomes.CHINLE_WOODED_MOUNTAINS.getKey()), biome.getOrCreateHolder(PFBiomes.ISCHIGUALASTO_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.ISCHIGUALASTO_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.ISCHIGUALASTO_CLEARING.getKey()), biome.getOrCreateHolder(PFBiomes.ISCHIGUALASTO_HILLS.getKey()), biome.getOrCreateHolder(PFBiomes.TRIASSIC_DRIPSTONE_CAVE.getKey()));
	}

	public double noiseValue;

	public TriassicBiomeSource(Holder<Biome> chinleRiver, Holder<Biome> chinleFlats, Holder<Biome> chinleSwamp, Holder<Biome> chinleWoodedMountains, Holder<Biome> ischigualastoRiver, Holder<Biome> ischigualastoForest, Holder<Biome> ischigualastoClearing, Holder<Biome> ischigualastoHills, Holder<Biome> prehistoricDripstoneCave) {
		super(ImmutableList.of(chinleRiver, chinleFlats, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoForest, ischigualastoClearing, ischigualastoHills, prehistoricDripstoneCave));
		this.chinleRiver = chinleRiver;
		this.chinleFlats = chinleFlats;
		this.chinleSwamp = chinleSwamp;
		this.chinleWoodedMountains = chinleWoodedMountains;
		this.ischigualastoRiver = ischigualastoRiver;
		this.ischigualastoForest = ischigualastoForest;
		this.ischigualastoHills = ischigualastoHills;
		this.ischigualastoClearing = ischigualastoClearing;
		this.prehistoricDripstoneCave = prehistoricDripstoneCave;
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}

	@Override
	public BiomeSource withSeed(long p_47916_) {
		return this;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Sampler p_204241_) {
		return getNoiseBiome(x, y, z);
	}

	public double timeLineNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.6F, z * 0.6F);
	}

	public double tempNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.2F, z * 0.2F);
	}

	public double hillinessNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.4F, z * 0.4F);
	}

	public double humidityNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.7F, z * 0.7F);
	}

	public double getNoiseValue() {
		return noiseValue;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		double timelineNoise = timeLineNoise(x, y, z, TriassicChunkGenerator.noise);
		double tempNoise = tempNoise(x, y, z, TriassicChunkGenerator.noise);
		double humidityNoise = humidityNoise(x, y, z, TriassicChunkGenerator.noise);
		double hillinessNoise = hillinessNoise(x, y, z, TriassicChunkGenerator.noise);
		if (humidityNoise > 0.4D && y < 6) {
			return prehistoricDripstoneCave;
		}
		if (timelineNoise >= 0.0222F) {
			if (hillinessNoise > 0.5F) return chinleWoodedMountains;
			if (tempNoise > 0.3F) return chinleFlats;
			return chinleSwamp;
		} else if (timelineNoise < 0.0222F && timelineNoise >= 0) {
			return chinleRiver;
		} else if (timelineNoise <= -0.0222F) {
			if (hillinessNoise > 0.3F) return ischigualastoHills;
			if (hillinessNoise < -0.4F) return ischigualastoClearing;
			return ischigualastoForest;
		} else return ischigualastoRiver;
	}

}
