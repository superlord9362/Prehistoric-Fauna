package superlord.prehistoricfauna.common.world.biome.biomesource;

import java.util.stream.Stream;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
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
		return p_48644_.group(RegistryOps.retrieveRegistryLookup(Registries.BIOME).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(TriassicBiomeSource::new));
	});

	private final Holder<Biome> chinleRiver, chinleFlats, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoForest, ischigualastoClearing, ischigualastoHills, prehistoricDripstoneCave, henostoneCave;

	public TriassicBiomeSource(HolderGetter<Biome> biome) {
		this(biome.getOrThrow(PFBiomes.CHINLE_RIVER), biome.getOrThrow(PFBiomes.CHINLE_FLATS), biome.getOrThrow(PFBiomes.CHINLE_SWAMP), biome.getOrThrow(PFBiomes.CHINLE_WOODED_MOUNTAINS), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_RIVER), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_FOREST), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_CLEARING), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_HILLS), biome.getOrThrow(PFBiomes.TRIASSIC_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.TRIASSIC_HENOSTONE_CAVE));
	}
	
	public static TriassicBiomeSource create(HolderGetter<Biome> biome) {
		return new TriassicBiomeSource(biome.getOrThrow(PFBiomes.CHINLE_RIVER), biome.getOrThrow(PFBiomes.CHINLE_FLATS), biome.getOrThrow(PFBiomes.CHINLE_SWAMP), biome.getOrThrow(PFBiomes.CHINLE_WOODED_MOUNTAINS), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_RIVER), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_FOREST), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_CLEARING), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_HILLS), biome.getOrThrow(PFBiomes.TRIASSIC_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.TRIASSIC_HENOSTONE_CAVE));
	}
	
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(this.chinleFlats, this.chinleRiver, this.chinleSwamp, this.chinleWoodedMountains, this.ischigualastoClearing, this.ischigualastoForest, this.ischigualastoHills, this.ischigualastoRiver, this.prehistoricDripstoneCave, this.henostoneCave);
	}

	public double noiseValue;

	public TriassicBiomeSource(Holder<Biome> chinleRiver, Holder<Biome> chinleFlats, Holder<Biome> chinleSwamp, Holder<Biome> chinleWoodedMountains, Holder<Biome> ischigualastoRiver, Holder<Biome> ischigualastoForest, Holder<Biome> ischigualastoClearing, Holder<Biome> ischigualastoHills, Holder<Biome> prehistoricDripstoneCave, Holder<Biome> henostoneCave) {
		this.chinleRiver = chinleRiver;
		this.chinleFlats = chinleFlats;
		this.chinleSwamp = chinleSwamp;
		this.chinleWoodedMountains = chinleWoodedMountains;
		this.ischigualastoRiver = ischigualastoRiver;
		this.ischigualastoForest = ischigualastoForest;
		this.ischigualastoHills = ischigualastoHills;
		this.ischigualastoClearing = ischigualastoClearing;
		this.prehistoricDripstoneCave = prehistoricDripstoneCave;
		this.henostoneCave = henostoneCave;
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
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
	
	public double caveTimeLineNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.3F, y * 0.3F, z * 0.3F);
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
		double caveTimeLineNoise = caveTimeLineNoise(x, y, z, TriassicChunkGenerator.noise);
		if (y < 6) {
			if (humidityNoise > 0.4D) return prehistoricDripstoneCave;
			if (caveTimeLineNoise > 0.8D) return henostoneCave;
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
