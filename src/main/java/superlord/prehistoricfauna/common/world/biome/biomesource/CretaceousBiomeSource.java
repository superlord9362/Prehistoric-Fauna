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

public class CretaceousBiomeSource extends BiomeSource implements NoiseBiomeSource {
	public static final Codec<CretaceousBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistryLookup(Registries.BIOME).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(CretaceousBiomeSource::new));
	});
	private final FastNoise climateNoise;
	private long lastSeed = -1;

	private final Holder<Biome> hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, yixianLakes, dripstoneCaves, henostoneCaves;

	public CretaceousBiomeSource(HolderGetter<Biome> biome) {
		this(biome.getOrThrow(PFBiomes.HELL_CREEK_HARDWOOD_FOREST), biome.getOrThrow(PFBiomes.HELL_CREEK_CLEARING), biome.getOrThrow(PFBiomes.HELL_CREEK_BLUFFS), biome.getOrThrow(PFBiomes.HELL_CREEK_REDWOODS), biome.getOrThrow(PFBiomes.HELL_CREEK_SWAMP), biome.getOrThrow(PFBiomes.HELL_CREEK_RIVER), biome.getOrThrow(PFBiomes.DJADOCHTA_DUNES), biome.getOrThrow(PFBiomes.DJADOCHTA_ARROYO), biome.getOrThrow(PFBiomes.DJADOCHTA_ALLUVIAL_PLAINS), biome.getOrThrow(PFBiomes.YIXIAN_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_MOUNTAINS), biome.getOrThrow(PFBiomes.YIXIAN_REGROWTH), biome.getOrThrow(PFBiomes.YIXIAN_VOLCANO), biome.getOrThrow(PFBiomes.YIXIAN_LAKES), biome.getOrThrow(PFBiomes.CRETACEOUS_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.CRETACEOUS_HENOSTONE_CAVE));
	}

	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(this.hellCreekBluffs, this.hellCreekClearing, this.hellCreekHardwoodForest, this.hellCreekRedwoods, this.hellCreekRiver, this.hellCreekSwamp, this.djadochtaAlluvialPlains, this.djadochtaArroyo, this.djadochtaDunes, this.yixianForest, this.yixianLakes, this.yixianRegrowth, this.yixianSnowyForest, this.yixianSnowyMountains, this.yixianVolcano, this.dripstoneCaves, this.henostoneCaves);
	}

	public CretaceousBiomeSource(Holder<Biome> hellCreekHardwoodForest, Holder<Biome> hellCreekClearing, Holder<Biome> hellCreekBluffs, Holder<Biome> hellCreekRedwoods, Holder<Biome> hellCreekSwamp, Holder<Biome> hellCreekRiver, Holder<Biome> djadochtaDunes, Holder<Biome> djadochtaArroyo, Holder<Biome> djadochtaAlluvialPlains, Holder<Biome> yixianForest, Holder<Biome> yixianSnowyForest, Holder<Biome> yixianSnowyMountains, Holder<Biome> yixianRegrowth, Holder<Biome> yixianVolcano, Holder<Biome> yixianLakes, Holder<Biome> dripstoneCaves, Holder<Biome> henostoneCaves) {
		this.hellCreekHardwoodForest = hellCreekHardwoodForest;
		this.hellCreekClearing = hellCreekClearing;
		this.hellCreekBluffs = hellCreekBluffs;
		this.hellCreekRedwoods = hellCreekRedwoods;
		this.hellCreekSwamp = hellCreekSwamp;
		this.hellCreekRiver = hellCreekRiver;
		this.djadochtaDunes = djadochtaDunes;
		this.djadochtaArroyo = djadochtaArroyo;
		this.djadochtaAlluvialPlains = djadochtaAlluvialPlains;
		this.yixianForest = yixianForest;
		this.yixianSnowyForest = yixianSnowyForest;
		this.yixianSnowyMountains = yixianSnowyMountains;
		this.yixianRegrowth = yixianRegrowth;
		this.yixianVolcano = yixianVolcano;
		this.yixianLakes = yixianLakes;
		this.dripstoneCaves = dripstoneCaves;
		this.henostoneCaves = henostoneCaves;
		this.climateNoise = new FastNoise(0); 
		this.climateNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}

	public double timeLineNoise(int x, int y, int z) { 
		return getNoise().GetNoise(x * 0.1F, z * 0.1F); 
	} 

	public double tempNoise(int x, int y, int z) {
		return getNoise().GetNoise(x * 0.2F, z * 0.2F); 
	} 

	public double hillinessNoise(int x, int y, int z) {
		return getNoise().GetNoise(x * 0.4F, z * 0.4F);
	} 

	public double humidityNoise(int x, int y, int z) { 
		return getNoise().GetNoise(x * 0.7F, z * 0.7F); 
	} 

	public double caveTimeLineNoise(int x, int y, int z) {
		return getNoise().GetNoise(x * 0.3F, y * 0.3F, z * 0.3F); 
	}

	public Climate.TargetPoint sampleCustomClimate(int x, int y, int z) {
		// Use your existing noise functions to generate climate-like parameters
		float temperature = (float) tempNoise(x, y, z);
		float humidity = (float) humidityNoise(x, y, z);
		float continentalness = (float) timeLineNoise(x, y, z);
		float erosion = (float) hillinessNoise(x, y, z);
		float depth = ((float) y / 256.0f) * 2.0f - 1.0f; // Map y level to depth
		float weirdness = (float) caveTimeLineNoise(x, y, z);
		return Climate.target(temperature, humidity, continentalness, erosion, depth, weirdness);
	}

	@Override 
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Sampler sampler) { 
		Climate.TargetPoint climate = sampleCustomClimate(x, y, z);
		return selectBiome(
				climate.temperature(), climate.humidity(), climate.continentalness(),
				climate.erosion(), climate.depth(), climate.weirdness(), y
				);
	} 

	public FastNoise getNoise() {
		return climateNoise;
	}

	public void updateNoise(long seed) {
		if (lastSeed != seed) {
			climateNoise.SetSeed((int) (seed & 0xFFFFFFFFL));
			lastSeed = seed;
		}
	}
	
	private Holder<Biome> selectBiome(float tempNoise, float humidityNoise, float timelineNoise, float hillinessNoise, float depth, float caveTimeLineNoise, int y) {
		if (y < 6) {
			if (humidityNoise / 10000 > 0.4D) {
				if (tempNoise / 10000 <= -0.5 && timelineNoise / 10000 <= -0.3333F) {
					if (hillinessNoise / 10000 > 0) return yixianSnowyMountains;
					else return yixianSnowyForest;
				}
				return dripstoneCaves;
			}
			if (caveTimeLineNoise / 10000 > 0.8D) {
				return henostoneCaves;
			}
		}
		if (timelineNoise / 10000 >= 0.3333F) {
			if (hillinessNoise / 10000 > 0.5F) return hellCreekBluffs;
			if (hillinessNoise / 10000 < 0) {
				if (humidityNoise / 10000 > 0) {
					return hellCreekSwamp;
				}
				else return hellCreekClearing;
			}
			if (tempNoise / 10000 <= 0) return hellCreekRedwoods;
			return hellCreekHardwoodForest;
		} else if (timelineNoise / 10000 <= -0.3333F) {
			if (tempNoise / 10000 <= -0.5) {
				if (hillinessNoise / 10000 > 0) return yixianSnowyMountains;
				else return yixianSnowyForest;
			}
			if (humidityNoise / 10000 >= 0.25F && hillinessNoise / 10000 < 0) return yixianLakes;
			if (tempNoise / 10000 >= 0.5F) {
				if (hillinessNoise / 10000 > 0) return yixianVolcano;
				else return yixianRegrowth;
			}
			return yixianForest;
		} else if (timelineNoise / 10000 > -0.3333F && timelineNoise / 10000 < 0.32F) {
			if (humidityNoise / 10000 > 0 && hillinessNoise / 10000 < 0.5F) return djadochtaArroyo;
			if (hillinessNoise / 10000 > 0 && humidityNoise / 10000 < 0) return djadochtaDunes;
			return djadochtaAlluvialPlains;
		}
		return hellCreekRiver;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		return getNoiseBiome(x, y, z, Climate.empty());
	} 

}
