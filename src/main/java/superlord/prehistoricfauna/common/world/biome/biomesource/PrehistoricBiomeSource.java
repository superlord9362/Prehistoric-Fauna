package superlord.prehistoricfauna.common.world.biome.biomesource;

import java.util.Random;
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
import superlord.prehistoricfauna.common.util.FastNoise.NoiseType;
import superlord.prehistoricfauna.init.PFBiomes;

public class PrehistoricBiomeSource extends BiomeSource implements NoiseBiomeSource {

	public static final Codec<PrehistoricBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistryLookup(Registries.BIOME).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(PrehistoricBiomeSource::new));
	});

	public final Holder<Biome> chinleFlats, chinleRiver, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoClearing, ischigualastoForest, ischigualastoHills, kayentaDryForest, kayentaButtes, kayentaDesert, kayentaRiver, morrisonSavanna, hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianLakes, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, dripstoneCaves, henostoneCaves;

	public PrehistoricBiomeSource(HolderGetter<Biome> biome) {
		this(biome.getOrThrow(PFBiomes.CHINLE_FLATS), biome.getOrThrow(PFBiomes.CHINLE_RIVER), biome.getOrThrow(PFBiomes.CHINLE_SWAMP), biome.getOrThrow(PFBiomes.CHINLE_WOODED_MOUNTAINS), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_RIVER), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_CLEARING), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_FOREST), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_HILLS), biome.getOrThrow(PFBiomes.KAYENTA_DRY_FOREST), biome.getOrThrow(PFBiomes.KAYENTA_BUTTES), biome.getOrThrow(PFBiomes.KAYENTA_DESERT), biome.getOrThrow(PFBiomes.KAYENTA_RIVER), biome.getOrThrow(PFBiomes.MORRISON_SAVANNA), biome.getOrThrow(PFBiomes.HELL_CREEK_HARDWOOD_FOREST), biome.getOrThrow(PFBiomes.HELL_CREEK_CLEARING), biome.getOrThrow(PFBiomes.HELL_CREEK_BLUFFS), biome.getOrThrow(PFBiomes.HELL_CREEK_REDWOODS), biome.getOrThrow(PFBiomes.HELL_CREEK_SWAMP), biome.getOrThrow(PFBiomes.HELL_CREEK_RIVER), biome.getOrThrow(PFBiomes.DJADOCHTA_DUNES), biome.getOrThrow(PFBiomes.DJADOCHTA_ARROYO), biome.getOrThrow(PFBiomes.DJADOCHTA_ALLUVIAL_PLAINS), biome.getOrThrow(PFBiomes.YIXIAN_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_LAKES), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_MOUNTAINS), biome.getOrThrow(PFBiomes.YIXIAN_REGROWTH), biome.getOrThrow(PFBiomes.YIXIAN_VOLCANO), biome.getOrThrow(PFBiomes.CRETACEOUS_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.CRETACEOUS_HENOSTONE_CAVE));
	}
	
	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(chinleFlats, chinleRiver, chinleSwamp, chinleWoodedMountains, ischigualastoRiver, ischigualastoClearing, ischigualastoForest, ischigualastoHills, kayentaDryForest, kayentaButtes, kayentaDesert, kayentaRiver, morrisonSavanna, hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianLakes, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, dripstoneCaves, henostoneCaves);
	}

	public static PrehistoricBiomeSource create(HolderGetter<Biome> biome) {
		return new PrehistoricBiomeSource(biome.getOrThrow(PFBiomes.CHINLE_FLATS), biome.getOrThrow(PFBiomes.CHINLE_RIVER), biome.getOrThrow(PFBiomes.CHINLE_SWAMP), biome.getOrThrow(PFBiomes.CHINLE_WOODED_MOUNTAINS), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_RIVER), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_CLEARING), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_FOREST), biome.getOrThrow(PFBiomes.ISCHIGUALASTO_HILLS), biome.getOrThrow(PFBiomes.KAYENTA_DRY_FOREST), biome.getOrThrow(PFBiomes.KAYENTA_BUTTES), biome.getOrThrow(PFBiomes.KAYENTA_DESERT), biome.getOrThrow(PFBiomes.KAYENTA_RIVER), biome.getOrThrow(PFBiomes.MORRISON_SAVANNA), biome.getOrThrow(PFBiomes.HELL_CREEK_HARDWOOD_FOREST), biome.getOrThrow(PFBiomes.HELL_CREEK_CLEARING), biome.getOrThrow(PFBiomes.HELL_CREEK_BLUFFS), biome.getOrThrow(PFBiomes.HELL_CREEK_REDWOODS), biome.getOrThrow(PFBiomes.HELL_CREEK_SWAMP), biome.getOrThrow(PFBiomes.HELL_CREEK_RIVER), biome.getOrThrow(PFBiomes.DJADOCHTA_DUNES), biome.getOrThrow(PFBiomes.DJADOCHTA_ARROYO), biome.getOrThrow(PFBiomes.DJADOCHTA_ALLUVIAL_PLAINS), biome.getOrThrow(PFBiomes.YIXIAN_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_LAKES), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_FOREST), biome.getOrThrow(PFBiomes.YIXIAN_SNOWY_MOUNTAINS), biome.getOrThrow(PFBiomes.YIXIAN_REGROWTH), biome.getOrThrow(PFBiomes.YIXIAN_VOLCANO), biome.getOrThrow(PFBiomes.CRETACEOUS_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.CRETACEOUS_HENOSTONE_CAVE));
	}
	
	private long seed;
	FastNoise noise;

	public PrehistoricBiomeSource(Holder<Biome> chinleFlats, Holder<Biome> chinleRiver, Holder<Biome> chinleSwamp, Holder<Biome> chinleWoodedMountains, Holder<Biome> ischigualastoRiver, Holder<Biome> ischigualastoClearing, Holder<Biome> ischigualastoForest, Holder<Biome> ischigualastoHills, Holder<Biome> kayentaDryForest, Holder<Biome> kayentaButtes, Holder<Biome> kayentaDesert, Holder<Biome> kayentaRiver, Holder<Biome> morrisonSavanna, Holder<Biome> hellCreekHardwoodForest, Holder<Biome> hellCreekClearing, Holder<Biome> hellCreekBluffs, Holder<Biome> hellCreekRedwoods, Holder<Biome> hellCreekSwamp, Holder<Biome> hellCreekRiver, Holder<Biome> djadochtaDunes, Holder<Biome> djadochtaArroyo, Holder<Biome> djadochtaAlluvialPlains, Holder<Biome> yixianForest, Holder<Biome> yixianLakes, Holder<Biome> yixianSnowyForest, Holder<Biome> yixianSnowyMountains, Holder<Biome> yixianRegrowth, Holder<Biome> yixianVolcano, Holder<Biome> dripstoneCaves, Holder<Biome> henostoneCaves) {
		Random random = new Random();
		seed = random.nextInt();
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
		noise = new FastNoise((int) seed);
		noise.SetNoiseType(NoiseType.Simplex);
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}
	
	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Sampler sampler) {
		return getNoiseBiome(x, y, z);
	}
	
	public double periodNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.05F, z * 0.05F);
	}

	public double timeLineNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.1F, z * 0.1F);
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

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		double timelineNoise = timeLineNoise(x , y, z, noise);
		double periodNoise = periodNoise(x, y, z, noise);
		double tempNoise = tempNoise(x, y, z, noise);
		double humidityNoise = humidityNoise(x, y, z, noise);
		double hillinessNoise = hillinessNoise(x, y, z, noise);
		double caveTimeLineNoise = caveTimeLineNoise(x, y, z, noise);
		if (y < 6) {
			if (humidityNoise > 0.4D) {
				if (tempNoise <= -0.5 && timelineNoise <= -0.3333F && periodNoise >= 0.3333F) {
					if (hillinessNoise > 0) return yixianSnowyMountains;
					else return yixianSnowyForest;
				}
				return dripstoneCaves;
			}
			if (caveTimeLineNoise > 0.8D) {
				return henostoneCaves;
			}
		}
		if (periodNoise >= 0.3333F) {
		if (timelineNoise >= 0.3333F) {
			if (hillinessNoise > 0.5F) return hellCreekBluffs;
			if (hillinessNoise < 0) {
				if (humidityNoise > 0) {
					return hellCreekSwamp;
				}
				else return hellCreekClearing;
			}
			if (tempNoise <= 0) return hellCreekRedwoods;
			return hellCreekHardwoodForest;
		} else if (timelineNoise <= -0.3333F) {
			if (tempNoise <= -0.5) {
				if (hillinessNoise > 0) return yixianSnowyMountains;
				else return yixianSnowyForest;
			}
			if (humidityNoise >= 0.25F && hillinessNoise < 0) return yixianLakes;
			if (tempNoise >= 0.5F) {
				if (hillinessNoise > 0) return yixianVolcano;
				else return yixianRegrowth;
			}
			return yixianForest;
		} else if (timelineNoise > -0.3333F && timelineNoise < 0.32F) {
			if (humidityNoise > 0 && hillinessNoise < 0.5F) return djadochtaArroyo;
			if (hillinessNoise > 0 && humidityNoise < 0) return djadochtaDunes;
			return djadochtaAlluvialPlains;
		}
		return hellCreekRiver;
		} else if (periodNoise <= -0.3333F) {
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
		} else {
			if (timelineNoise >= 0) {
//				if (hillinessNoise > 0.3F) return morrisonHills;
				return morrisonSavanna;
			} else if (timelineNoise <= -0.0111F) {
				if (tempNoise > 0.2F) {
					if (hillinessNoise > 0.4F) return kayentaButtes;
					else return kayentaDesert;
				} else return kayentaDryForest;
			} else return kayentaRiver;
		}
	}

}