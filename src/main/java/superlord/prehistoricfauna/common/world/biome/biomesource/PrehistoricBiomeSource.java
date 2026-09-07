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

public class PrehistoricBiomeSource extends BiomeSource implements NoiseBiomeSource {

	public static final Codec<PrehistoricBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistryLookup(Registries.BIOME).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, PrehistoricBiomeSource::new);
	});
	private final FastNoise periodNoise, timelineNoise, temperatureNoise, hillinessNoise, humidityNoise, caveNoise;
	private long lastSeed = -1;

	public final Holder<Biome> chinleFlats, chinleRiver, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoClearing, ischigualastoForest, ischigualastoHills, kayentaDryForest, kayentaButtes, kayentaDesert, kayentaRiver, morrisonSavanna, hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianLakes, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, dripstoneCaves, henostoneCaves, kayentaDunes, kayentaCanyons, morrisonSaltFlats, morrisonGalleryForest, morrisonUplandForest, morrisonSparseForest, morrisonRiver, shaximiaoDeltaPlains, shaximiaoLakes, shaximiaoAridLakes, shaximiaoMountains, shaximiaoGalleryForest, shaximiaoDryForest;

	public PrehistoricBiomeSource(HolderGetter<Biome> biome) {
		this(biome.getOrThrow(PFBiomes.CHINLE_FLATS), biome.getOrThrow(PFBiomes.CHINLE_RIVER), biome.getOrThrow(PFBiomes.CHINLE_SWAMP), biome.getOrThrow(PFBiomes.CHINLE_WOODED_MOUNTAINS), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_RIVER), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_CLEARING), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_FOREST), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_HILLS), biome.getOrThrow(PFBiomes.KAYENTA_DRY_FOREST), biome.getOrThrow(PFBiomes.KAYENTA_BUTTES), biome.getOrThrow(PFBiomes.KAYENTA_DESERT), biome.getOrThrow(PFBiomes.KAYENTA_RIVER), biome.getOrThrow(PFBiomes.MORRISON_SAVANNA), biome.getOrThrow(PFBiomes.HELL_CREEK_HARDWOOD_FOREST), biome.getOrThrow(PFBiomes.HELL_CREEK_CLEARING), biome.getOrThrow(PFBiomes.HELL_CREEK_BLUFFS), biome.getOrThrow(PFBiomes.HELL_CREEK_REDWOODS), biome.getOrThrow(PFBiomes.HELL_CREEK_SWAMP), biome.getOrThrow(PFBiomes.HELL_CREEK_RIVER), biome.getOrThrow(PFBiomes.DJADOCHTA_DUNES), biome.getOrThrow(PFBiomes.DJADOCHTA_ARROYO), biome.getOrThrow(PFBiomes.DJADOCHTA_ALLUVIAL_PLAINS), biome.getOrThrow(PFBiomes.YIXIAN_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_LAKES), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_MOUNTAINS), biome.getOrThrow(PFBiomes.YIXIAN_REGROWTH), biome.getOrThrow(PFBiomes.YIXIAN_VOLCANO), biome.getOrThrow(PFBiomes.CRETACEOUS_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.CRETACEOUS_HENOSTONE_CAVE), biome.getOrThrow(PFBiomes.KAYENTA_DUNES), biome.getOrThrow(PFBiomes.KAYENTA_CANYONS), biome.getOrThrow(PFBiomes.MORRISON_SALT_FLATS), biome.getOrThrow(PFBiomes.MORRISON_GALLERY_FOREST), biome.getOrThrow(PFBiomes.MORRISON_UPLAND_FOREST), biome.getOrThrow(PFBiomes.MORRISON_SPARSE_FOREST), biome.getOrThrow(PFBiomes.MORRISON_RIVER), biome.getOrThrow(PFBiomes.SHAXIMIAO_DELTA_PLAINS), biome.getOrThrow(PFBiomes.SHAXIMIAO_LAKES), biome.getOrThrow(PFBiomes.SHAXIMIAO_ARID_LAKES), biome.getOrThrow(PFBiomes.SHAXIMIAO_MOUNTAINS), biome.getOrThrow(PFBiomes.SHAXIMIAO_GALLERY_FOREST), biome.getOrThrow(PFBiomes.SHAXIMIAO_DRY_FOREST));
	}
	
	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(chinleFlats, chinleRiver, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoClearing, ischigualastoForest, ischigualastoHills, kayentaDryForest, kayentaButtes, kayentaDesert, kayentaRiver, morrisonSavanna, hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianLakes, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, dripstoneCaves, henostoneCaves, kayentaDunes, kayentaCanyons, morrisonSaltFlats, morrisonGalleryForest, morrisonUplandForest, morrisonSparseForest, morrisonRiver, shaximiaoDeltaPlains, shaximiaoLakes, shaximiaoAridLakes, shaximiaoMountains, shaximiaoGalleryForest, shaximiaoDryForest);
	}

	public static PrehistoricBiomeSource create(HolderGetter<Biome> biome) {
		return new PrehistoricBiomeSource(biome.getOrThrow(PFBiomes.CHINLE_FLATS), biome.getOrThrow(PFBiomes.CHINLE_RIVER), biome.getOrThrow(PFBiomes.CHINLE_SWAMP), biome.getOrThrow(PFBiomes.CHINLE_WOODED_MOUNTAINS), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_RIVER), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_CLEARING), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_FOREST), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_HILLS), biome.getOrThrow(PFBiomes.KAYENTA_DRY_FOREST), biome.getOrThrow(PFBiomes.KAYENTA_BUTTES), biome.getOrThrow(PFBiomes.KAYENTA_DESERT), biome.getOrThrow(PFBiomes.KAYENTA_RIVER), biome.getOrThrow(PFBiomes.MORRISON_SAVANNA), biome.getOrThrow(PFBiomes.HELL_CREEK_HARDWOOD_FOREST), biome.getOrThrow(PFBiomes.HELL_CREEK_CLEARING), biome.getOrThrow(PFBiomes.HELL_CREEK_BLUFFS), biome.getOrThrow(PFBiomes.HELL_CREEK_REDWOODS), biome.getOrThrow(PFBiomes.HELL_CREEK_SWAMP), biome.getOrThrow(PFBiomes.HELL_CREEK_RIVER), biome.getOrThrow(PFBiomes.DJADOCHTA_DUNES), biome.getOrThrow(PFBiomes.DJADOCHTA_ARROYO), biome.getOrThrow(PFBiomes.DJADOCHTA_ALLUVIAL_PLAINS), biome.getOrThrow(PFBiomes.YIXIAN_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_LAKES), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_MOUNTAINS), biome.getOrThrow(PFBiomes.YIXIAN_REGROWTH), biome.getOrThrow(PFBiomes.YIXIAN_VOLCANO), biome.getOrThrow(PFBiomes.CRETACEOUS_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.CRETACEOUS_HENOSTONE_CAVE), biome.getOrThrow(PFBiomes.KAYENTA_DUNES), biome.getOrThrow(PFBiomes.KAYENTA_CANYONS), biome.getOrThrow(PFBiomes.MORRISON_SALT_FLATS), biome.getOrThrow(PFBiomes.MORRISON_GALLERY_FOREST), biome.getOrThrow(PFBiomes.MORRISON_UPLAND_FOREST), biome.getOrThrow(PFBiomes.MORRISON_SPARSE_FOREST), biome.getOrThrow(PFBiomes.MORRISON_RIVER), biome.getOrThrow(PFBiomes.SHAXIMIAO_DELTA_PLAINS), biome.getOrThrow(PFBiomes.SHAXIMIAO_LAKES), biome.getOrThrow(PFBiomes.SHAXIMIAO_ARID_LAKES), biome.getOrThrow(PFBiomes.SHAXIMIAO_MOUNTAINS), biome.getOrThrow(PFBiomes.SHAXIMIAO_GALLERY_FOREST), biome.getOrThrow(PFBiomes.SHAXIMIAO_DRY_FOREST));
	}

	public PrehistoricBiomeSource(Holder<Biome> chinleFlats, Holder<Biome> chinleRiver, Holder<Biome> chinleSwamp, Holder<Biome> chinleWoodedMountains, Holder<Biome> ischigualastoRiver, Holder<Biome> ischigualastoClearing, Holder<Biome> ischigualastoForest, Holder<Biome> ischigualastoHills, Holder<Biome> kayentaDryForest, Holder<Biome> kayentaButtes, Holder<Biome> kayentaDesert, Holder<Biome> kayentaRiver, Holder<Biome> morrisonSavanna, Holder<Biome> hellCreekHardwoodForest, Holder<Biome> hellCreekClearing, Holder<Biome> hellCreekBluffs, Holder<Biome> hellCreekRedwoods, Holder<Biome> hellCreekSwamp, Holder<Biome> hellCreekRiver, Holder<Biome> djadochtaDunes, Holder<Biome> djadochtaArroyo, Holder<Biome> djadochtaAlluvialPlains, Holder<Biome> yixianForest, Holder<Biome> yixianLakes, Holder<Biome> yixianSnowyForest, Holder<Biome> yixianSnowyMountains, Holder<Biome> yixianRegrowth, Holder<Biome> yixianVolcano, Holder<Biome> dripstoneCaves, Holder<Biome> henostoneCaves, Holder<Biome> kayentaDunes, Holder<Biome> kayentaCanyons, Holder<Biome> morrisonSaltFlats, Holder<Biome> morrisonGalleryForest, Holder<Biome> morrisonUplandForest, Holder<Biome> morrisonSparseForest, Holder<Biome> morrisonRiver, Holder<Biome> shaximiaoDeltaPlains, Holder<Biome> shaximiaoLakes, Holder<Biome> shaximiaoAridLakes, Holder<Biome> shaximiaoMountains, Holder<Biome> shaximiaoGalleryForest, Holder<Biome> shaximiaoDryForest) {
		this.chinleFlats = chinleFlats;
		this.chinleRiver = chinleRiver;
		this.chinleSwamp = chinleSwamp;
		this.chinleWoodedMountains = chinleWoodedMountains;
		this.ischigualastoRiver = ischigualastoRiver;
		this.ischigualastoClearing = ischigualastoClearing;
		this.ischigualastoForest = ischigualastoForest;
		this.ischigualastoHills = ischigualastoHills;
		this.kayentaDryForest = kayentaDryForest;
		this.kayentaButtes = kayentaButtes;
		this.kayentaDesert = kayentaDesert;
		this.kayentaRiver = kayentaRiver;
		this.morrisonSavanna = morrisonSavanna;
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
		this.yixianLakes = yixianLakes;
		this.yixianSnowyForest = yixianSnowyForest;
		this.yixianSnowyMountains = yixianSnowyMountains;
		this.yixianRegrowth = yixianRegrowth;
		this.yixianVolcano = yixianVolcano;
		this.dripstoneCaves = dripstoneCaves;
		this.henostoneCaves = henostoneCaves;
		this.kayentaDunes = kayentaDunes;
		this.kayentaCanyons = kayentaCanyons;
		this.morrisonSaltFlats = morrisonSaltFlats;
		this.morrisonGalleryForest = morrisonGalleryForest;
		this.morrisonUplandForest = morrisonUplandForest;
		this.morrisonSparseForest = morrisonSparseForest;
		this.morrisonRiver = morrisonRiver;
		this.shaximiaoDeltaPlains = shaximiaoDeltaPlains;
		this.shaximiaoLakes = shaximiaoLakes;
		this.shaximiaoAridLakes = shaximiaoAridLakes;
		this.shaximiaoMountains = shaximiaoMountains;
		this.shaximiaoGalleryForest = shaximiaoGalleryForest;
		this.shaximiaoDryForest = shaximiaoDryForest;
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
		this.periodNoise = new FastNoise(5);
		this.periodNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}
	
	public double periodNoise(int x, int y, int z) {
		return periodNoise.GetNoise(x * 0.05F, z * 0.05F);
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
	
	public void setSeed(long seed) {
	    if (lastSeed != seed) {
	        int s = (int)(seed & 0xFFFFFFFFL);
	        timelineNoise.SetSeed(s);
	        temperatureNoise.SetSeed(s + 1);
	        hillinessNoise.SetSeed(s + 2);
	        humidityNoise.SetSeed(s + 3);
	        caveNoise.SetSeed(s + 4);
	        periodNoise.SetSeed(s + 5);
	        lastSeed = seed;
	    }
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
		float period = (float) periodNoise(x, y, z);
		return selectBiome(period, climate.temperature(), climate.humidity(), climate.continentalness(), climate.erosion(), climate.depth(), climate.weirdness(), y);
	} 

	private Holder<Biome> selectBiome(float period, float tempNoise, float humidityNoise, float timelineNoise, float hillinessNoise, float depth, float caveTimeLineNoise, int y) {
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
		if (period >= 0.3333F) {
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
		} else if (period <= -0.3333F) {
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
		} else {
			if (timelineNoise / 10000 >= 0.34F) {
				if (tempNoise / 10000 > 0.2F) {
					if (hillinessNoise / 10000 < -0.5F) return kayentaButtes;
					if (hillinessNoise / 10000 > 0.5F) return kayentaDunes;
					else return kayentaDesert;
				} else {
					if (hillinessNoise / 10000 < -0.5F) {
						return kayentaCanyons;
					} else {
						if (tempNoise / 10000 > -0.41 && tempNoise / 10000 < -0.39) return kayentaRiver;
						else return kayentaDryForest;
					}
				}
			} else if (timelineNoise / 10000 <= -0.34F) {
				if (tempNoise / 10000 > 0) {
					if (hillinessNoise / 10000 > 0.5) return shaximiaoMountains;
					if (hillinessNoise / 10000 < -0.6) return shaximiaoAridLakes;
					else return shaximiaoDryForest;
				} else {
					if (hillinessNoise / 10000 < 0) {
						if (humidityNoise / 10000 > 0) return shaximiaoDeltaPlains;
						else return shaximiaoLakes;
					}
					else return shaximiaoGalleryForest;
				}			
			} else if (timelineNoise / 10000 >= 0.33 && timelineNoise / 10000 < 0.34) {
				return kayentaRiver;
			} else if (timelineNoise / 10000 >= -0.34 && timelineNoise / 10000 < -0.33 || timelineNoise / 10000 >= 0.32 && timelineNoise / 10000 < 0.33) {
				return morrisonRiver;
			} else {
				if (hillinessNoise / 10000 < 0F && tempNoise / 10000 > 0.25 && humidityNoise / 10000 < 0) return morrisonSaltFlats;
				else if (humidityNoise / 10000 > 0) {
					if (hillinessNoise / 10000 > 0.5) return morrisonUplandForest;
					else if (tempNoise / 10000 < 0.25) {
						if (tempNoise / 10000 < -0.36 && tempNoise / 10000 > -0.38) return morrisonRiver;
						else return morrisonGalleryForest;
					}
					else return morrisonSparseForest;
				} else return morrisonSavanna;
			}
		}
	}
	
	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		return getNoiseBiome(x, y, z, Climate.empty());
	} 

}