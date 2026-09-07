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
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Climate.Sampler;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.init.PFBiomes;

public class TriassicBiomeSource extends BiomeSource implements NoiseBiomeSource {	

	public static final Codec<TriassicBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistryLookup(Registries.BIOME).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(TriassicBiomeSource::new));
	});
	private final FastNoise timelineNoise, temperatureNoise, hillinessNoise, humidityNoise, caveNoise;
	private long lastSeed = -1;

	private final Holder<Biome> chinleRiver, chinleFlats, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoForest, ischigualastoClearing, ischigualastoHills, prehistoricDripstoneCave, henostoneCave;

	public TriassicBiomeSource(HolderGetter<Biome> biome) {
		this(biome.getOrThrow(PFBiomes.CHINLE_RIVER), biome.getOrThrow(PFBiomes.CHINLE_FLATS), biome.getOrThrow(PFBiomes.CHINLE_SWAMP), biome.getOrThrow(PFBiomes.CHINLE_WOODED_MOUNTAINS), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_RIVER), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_FOREST), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_CLEARING), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_HILLS), biome.getOrThrow(PFBiomes.TRIASSIC_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.TRIASSIC_HENOSTONE_CAVE));
	}
	
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(this.chinleFlats, this.chinleRiver, this.chinleSwamp, this.chinleWoodedMountains, this.ischigualastoClearing, this.ischigualastoForest, this.ischigualastoHills, this.ischigualastoRiver, this.prehistoricDripstoneCave, this.henostoneCave);
	}
	
	public void setSeed(long seed) {
	    if (lastSeed != seed) {
	        int s = (int)(seed & 0xFFFFFFFFL);
	        timelineNoise.SetSeed(s);
	        temperatureNoise.SetSeed(s + 1);
	        hillinessNoise.SetSeed(s + 2);
	        humidityNoise.SetSeed(s + 3);
	        caveNoise.SetSeed(s + 4);
	        lastSeed = seed;
	    }
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
		this.timelineNoise = new FastNoise(0);
		this.timelineNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
		this.temperatureNoise = new FastNoise(1);
		this.temperatureNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
		this.hillinessNoise = new FastNoise(2);
		this.hillinessNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
		this.humidityNoise = new FastNoise(3);
		this.humidityNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
		this.caveNoise = new FastNoise(4);
		this.caveNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}
	
	public Climate.TargetPoint sampleCustomClimate(int x, int y, int z) {
		float temperature = (float) tempNoise(x, y, z);
		float humidity = (float) humidityNoise(x, y, z);
		float continentalness = (float) timeLineNoise(x, y, z);
		float erosion = (float) hillinessNoise(x, y, z);
		float depth = ((float) y / 256.0f) * 2.0f - 1.0f;
		float weirdness = (float) caveTimeLineNoise(x, y, z);
		return Climate.target(temperature, humidity, continentalness, erosion, depth, weirdness);
	}
	
	@Override 
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Sampler sampler) { 
		Climate.TargetPoint climate = sampleCustomClimate(x, y, z);
		return selectBiome(climate.temperature(), climate.humidity(), climate.continentalness(), climate.erosion(), climate.depth(), climate.weirdness(), y);
	} 
	
	public double timeLineNoise(int x, int y, int z) {
	    return timelineNoise.GetNoise(x * 0.1F, z * 0.1F);
	}

	public double tempNoise(int x, int y, int z) {
	    return temperatureNoise.GetNoise(x * 0.2F, z * 0.2F);
	}

	public double hillinessNoise(int x, int y, int z) {
	    return hillinessNoise.GetNoise(x * 0.4F, z * 0.4F);
	}

	public double humidityNoise(int x, int y, int z) {
	    return humidityNoise.GetNoise(x * 0.7F, z * 0.7F);
	}

	public double caveTimeLineNoise(int x, int y, int z) {
	    return caveNoise.GetNoise(x * 0.3F, y * 0.3F, z * 0.3F);
	}
	
	public double getNoiseValue() {
		return noiseValue;
	}
	
	private Holder<Biome> selectBiome(float tempNoise, float humidityNoise, float timelineNoise, float hillinessNoise, float depth, float caveTimeLineNoise, int y) {
		if (y < 6) {
			if (humidityNoise / 10000 > 0.4D) return prehistoricDripstoneCave;
			if (caveTimeLineNoise / 10000 > 0.8D) return henostoneCave;
		}
		if (timelineNoise / 10000 >= 0.0222F) {
			if (hillinessNoise / 10000 > 0.5F) return chinleWoodedMountains;
			if (tempNoise / 10000 > 0.3F) return chinleFlats;
			return chinleSwamp;
		} else if (timelineNoise / 10000 < 0.0222F && timelineNoise >= 0) {
			return chinleRiver;
		} else if (timelineNoise / 10000 <= -0.0222F) {
			if (hillinessNoise / 10000 > 0.3F) return ischigualastoHills;
			if (hillinessNoise / 10000 < -0.4F) return ischigualastoClearing;
			return ischigualastoForest;
		} else return ischigualastoRiver;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		return getNoiseBiome(x, y, z, Climate.empty());
	} 

}