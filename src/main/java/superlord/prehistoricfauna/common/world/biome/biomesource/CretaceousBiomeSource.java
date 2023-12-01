package superlord.prehistoricfauna.common.world.biome.biomesource;

import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.util.Mth;
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

	private final Holder<Biome> hellCreekHardwoodForest, hellCreekClearing, hellCreekLiriodendritesHills, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, prehistoricDripstoneCave;

	public CretaceousBiomeSource(Registry<Biome> biome) {
		this(biome.getOrCreateHolder(PFBiomes.HELL_CREEK_HARDWOOD_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_CLEARING.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_LIRIODENDRITES_HILLS.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_REDWOODS.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_SWAMP.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_DUNES.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_ARROYO.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_ALLUVIAL_PLAINS.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_SNOWY_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_SNOWY_MOUNTAINS.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_REGROWTH.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_VOLCANO.getKey()), biome.getOrCreateHolder(PFBiomes.PREHISTORIC_DRIPSTONE_CAVE.getKey()));
	}

	public CretaceousBiomeSource(Holder<Biome> hellCreekHardwoodForest, Holder<Biome> hellCreekClearing, Holder<Biome> hellCreekLiriodendritesHills, Holder<Biome> hellCreekRedwoods, Holder<Biome> hellCreekSwamp, Holder<Biome> hellCreekRiver, Holder<Biome> djadochtaDunes, Holder<Biome> djadochtaArroyo, Holder<Biome> djadochtaAlluvialPlains, Holder<Biome> yixianForest, Holder<Biome> yixianSnowyForest, Holder<Biome> yixianSnowyMountains, Holder<Biome> yixianRegrowth, Holder<Biome> yixianVolcano, Holder<Biome> prehistoricDripstoneCave) {
		super(ImmutableList.of(hellCreekHardwoodForest, hellCreekClearing, hellCreekLiriodendritesHills, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, prehistoricDripstoneCave));
		this.hellCreekHardwoodForest = hellCreekHardwoodForest;
		this.hellCreekClearing = hellCreekClearing;
		this.hellCreekLiriodendritesHills = hellCreekLiriodendritesHills;
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
		this.prehistoricDripstoneCave = prehistoricDripstoneCave;
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

	public double calculateNoiseValue(int x, int z, FastNoise noise) {
		float frequency = 0.01F;
		float amplitude = 30F;
		double noiseX = noise.GetNoise(x * frequency, z * frequency);
		double noiseZ = noise.GetNoise(x * frequency, z * frequency);
		double combinedNoise = amplitude * (noiseX + noiseZ);
		return combinedNoise;
	}

	public double calculateFormationNoiseValue(int x, int z, FastNoise noise) {
		double randomValue = (noise.GetNoise(x, z) + 1) * 1.5D;
		return randomValue;
	}

	public double calculateCaveNoiseValue(int y, FastNoise noise) {
		float frequency = 0.5F;
		float amplitude = 4.0F;
		double noiseY = noise.GetNoise(y * frequency, y * frequency);
		double combinedNoise;
		if (y >= 44) {
			combinedNoise = 4;
		} else combinedNoise = amplitude * noiseY;
		return combinedNoise;
	}
	
	public double getNoiseValue() {
		return noiseValue;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		double caveNoiseValue = calculateCaveNoiseValue(y, CretaceousChunkGenerator.noise);
		noiseValue = calculateNoiseValue(x, z, CretaceousChunkGenerator.noise);
		if (caveNoiseValue < 0.5 && caveNoiseValue > 0) {
			Random random = new Random();
			if (y < Mth.nextDouble(random, -64, 44)) return prehistoricDripstoneCave;
		}
		if (noiseValue <= -13) {
			//Yixian
			if (noiseValue > -26 && noiseValue <= -21) {
				return yixianVolcano;
			} else if (noiseValue > -30 && noiseValue <= -26 || noiseValue > -21 && noiseValue <= -17) {
				return yixianRegrowth;
			} else if (noiseValue > -39 && noiseValue <= -33) {
				return yixianSnowyMountains;
			} else if (noiseValue > -41 && noiseValue <= -39 || noiseValue > -33 && noiseValue <= -30) {
				return yixianSnowyForest;
			} else {
				return yixianForest;
			}
		} else if (noiseValue > -12.8 && noiseValue <= 12.8) {
			//HellCreek
			if (noiseValue > -9 && noiseValue <= -8) {
				return hellCreekClearing;
			} else if (noiseValue > -3 && noiseValue <= 1) {
				return hellCreekLiriodendritesHills;
			} else if (noiseValue > 5 && noiseValue <= 7) {
				return hellCreekRedwoods;
			} else if (noiseValue > 7 && noiseValue <= 11) {
				return hellCreekSwamp;
			} else {
				return hellCreekHardwoodForest;
			}
		} else if (noiseValue > 13) {
			//Djadochta
			if (noiseValue > 20 && noiseValue <= 25 || noiseValue > 37) {
				return djadochtaArroyo;
			} else if (noiseValue > 17 && noiseValue <= 20 || noiseValue > 25 && noiseValue <= 28 || noiseValue > 32 && noiseValue <= 35) {
				return djadochtaAlluvialPlains;
			} else {
				return djadochtaDunes;
			}
		}
		if (noiseValue <= -12.8 && noiseValue > -13 || noiseValue > 12.8 && noiseValue <= 13) return hellCreekRiver;
		else return hellCreekRiver;
	}

}
