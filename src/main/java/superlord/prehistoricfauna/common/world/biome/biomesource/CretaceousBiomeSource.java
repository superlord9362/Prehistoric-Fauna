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
import superlord.prehistoricfauna.common.world.chunkgen.CretaceousChunkGenerator;
import superlord.prehistoricfauna.init.PFBiomes;

public class CretaceousBiomeSource extends BiomeSource implements NoiseBiomeSource {

	double noiseValue;

	public static final Codec<CretaceousBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(CretaceousBiomeSource::new));
	});

	private final Holder<Biome> hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, yixianLakes, dripstoneCaves;

	public CretaceousBiomeSource(Registry<Biome> biome) {
		this(biome.getOrCreateHolder(PFBiomes.HELL_CREEK_HARDWOOD_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_CLEARING.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_BLUFFS.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_REDWOODS.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_SWAMP.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_DUNES.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_ARROYO.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_ALLUVIAL_PLAINS.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_SNOWY_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_SNOWY_MOUNTAINS.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_REGROWTH.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_VOLCANO.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_LAKES.getKey()), biome.getOrCreateHolder(PFBiomes.CRETACEOUS_DRIPSTONE_CAVE.getKey()));
	}

	public CretaceousBiomeSource(Holder<Biome> hellCreekHardwoodForest, Holder<Biome> hellCreekClearing, Holder<Biome> hellCreekBluffs, Holder<Biome> hellCreekRedwoods, Holder<Biome> hellCreekSwamp, Holder<Biome> hellCreekRiver, Holder<Biome> djadochtaDunes, Holder<Biome> djadochtaArroyo, Holder<Biome> djadochtaAlluvialPlains, Holder<Biome> yixianForest, Holder<Biome> yixianSnowyForest, Holder<Biome> yixianSnowyMountains, Holder<Biome> yixianRegrowth, Holder<Biome> yixianVolcano, Holder<Biome> yixianLakes, Holder<Biome> dripstoneCaves) {
		super(ImmutableList.of(hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, yixianLakes, dripstoneCaves));
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
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}

	@Override
	public BiomeSource withSeed(long seed) {
		return this;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Sampler sampler) {
		return getNoiseBiome(x, y, z);
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

	public double getNoiseValue() {
		return noiseValue;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		double timelineNoise = timeLineNoise(x, y, z, CretaceousChunkGenerator.noise);
		double tempNoise = tempNoise(x, y, z, CretaceousChunkGenerator.noise);
		double humidityNoise = humidityNoise(x, y, z, CretaceousChunkGenerator.noise);
		double hillinessNoise = hillinessNoise(x, y, z, CretaceousChunkGenerator.noise);
		if (humidityNoise > 0.4D && y < 6) {
			if (tempNoise <= -0.5 && timelineNoise <= -0.3333F) {
				if (hillinessNoise > 0) return yixianSnowyMountains;
				else return yixianSnowyForest;
			}
			return dripstoneCaves;
		}
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
				if (humidityNoise >= 0.5F && hillinessNoise < 0) return yixianLakes;
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
	}

}
