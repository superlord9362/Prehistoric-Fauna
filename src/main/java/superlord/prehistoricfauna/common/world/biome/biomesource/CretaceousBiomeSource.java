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
import superlord.prehistoricfauna.common.util.FastNoise.NoiseType;
import superlord.prehistoricfauna.common.world.chunkgen.CretaceousChunkGenerator;
import superlord.prehistoricfauna.init.PFBiomes;

public class CretaceousBiomeSource extends BiomeSource implements NoiseBiomeSource {

	double noiseValue;
	int worldNumber;

	public static final Codec<CretaceousBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(CretaceousBiomeSource::new));
	});

	private final Holder<Biome> hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, prehistoricDripstoneCave;

	public CretaceousBiomeSource(Registry<Biome> biome) {
		this(biome.getOrCreateHolder(PFBiomes.HELL_CREEK_HARDWOOD_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_CLEARING.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_BLUFFS.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_REDWOODS.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_SWAMP.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_DUNES.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_ARROYO.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_ALLUVIAL_PLAINS.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_SNOWY_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_SNOWY_MOUNTAINS.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_REGROWTH.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_VOLCANO.getKey()), biome.getOrCreateHolder(PFBiomes.PREHISTORIC_DRIPSTONE_CAVE.getKey()));
		Random random = new Random();
		this.worldNumber = random.nextInt(6);
	}

	public CretaceousBiomeSource(Holder<Biome> hellCreekHardwoodForest, Holder<Biome> hellCreekClearing, Holder<Biome> hellCreekBluffs, Holder<Biome> hellCreekRedwoods, Holder<Biome> hellCreekSwamp, Holder<Biome> hellCreekRiver, Holder<Biome> djadochtaDunes, Holder<Biome> djadochtaArroyo, Holder<Biome> djadochtaAlluvialPlains, Holder<Biome> yixianForest, Holder<Biome> yixianSnowyForest, Holder<Biome> yixianSnowyMountains, Holder<Biome> yixianRegrowth, Holder<Biome> yixianVolcano, Holder<Biome> prehistoricDripstoneCave) {
		super(ImmutableList.of(hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, prehistoricDripstoneCave));
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
		this.prehistoricDripstoneCave = prehistoricDripstoneCave;
		Random random = new Random();
		this.worldNumber = random.nextInt(5);
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

	public double calculateNoiseValue(int x, int y, int z, FastNoise noise) {
		float frequency = 0.045F;
		float amplitude = 30.7F;
		
		double noiseX = noise.GetNoise(x * frequency, x * frequency);
		double noiseZ = noise.GetNoise(z * frequency, z * frequency);

		double combinedNoise = amplitude * (noiseX + noiseZ);

		return combinedNoise;
		//System.out.println(randomValue * amplitude);
		//System.out.println(this.worldNumber);
//		float frequency = 0.05F;
//		float amplitude = 30F;
//		noise.SetNoiseType(NoiseType.Simplex);
//		double noiseX = noise.GetNoise(x * frequency, z * frequency);
//		double noiseZ = noise.GetNoise(z * frequency, z * frequency);
//		double combinedNoise = amplitude * (noiseX + noiseZ);
//		return combinedNoise;
	}

	public double calculateFormationNoiseValue(int x, int z, FastNoise noise) {
		double randomValue = (noise.GetNoise(x, z) + 1) * 1.5D;
		return randomValue;
	}

	public double calculateCaveNoiseValue(int y, FastNoise noise) {
		float frequency = 0.5F;
		float amplitude = 4.0F;
		noise.SetNoiseType(NoiseType.Simplex);
		double noiseY = noise.GetNoise(y * frequency, y * frequency);
		double combinedNoise;
		if (y >= 55) {
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
		noiseValue = calculateNoiseValue(x, y, z, CretaceousChunkGenerator.noise);
		Random random = new Random();
		if (caveNoiseValue < 0.5 && caveNoiseValue > 0) {
			if (y < Mth.nextDouble(random, -64, 55)) return prehistoricDripstoneCave;
		}
		//Hell Creek
		if (worldNumber == 0 || worldNumber == 1) {
			if (noiseValue <= -42) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > -42 && noiseValue <= -39) {
				return hellCreekBluffs;
			} else if (noiseValue > -39 && noiseValue <= -34) {
				return hellCreekRedwoods;
			} else if (noiseValue > -34 && noiseValue <= -32) {
				return hellCreekBluffs;
			} else if (noiseValue > -32 && noiseValue <= -29) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > -29 && noiseValue <= -26) {
				return hellCreekClearing;
			} else if (noiseValue > -26 && noiseValue <= -22) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > -22 && noiseValue <= -18) {
				return hellCreekSwamp;
			} else if (noiseValue > -18 && noiseValue <= -15.5) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > -15.5 && noiseValue <= -15) {
				return hellCreekRiver;
			}
		}
		if (worldNumber == 2 || worldNumber == 5) {
			if (noiseValue > -15 && noiseValue <= -14.6) {
				return hellCreekRiver;
			} else if (noiseValue > -14.6 && noiseValue <= -12) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > -12 && noiseValue <= -9) {
				return hellCreekBluffs;
			} else if (noiseValue > -9 && noiseValue <= -4) {
				return hellCreekRedwoods;
			} else if (noiseValue > -4 && noiseValue <= -2) {
				return hellCreekBluffs;
			} else if (noiseValue > -2 && noiseValue <= 1) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > 1 && noiseValue <= 4) {
				return hellCreekClearing;
			} else if (noiseValue > 4 && noiseValue <= 8) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > 8 && noiseValue <= 12) {
				return hellCreekSwamp;
			} else if (noiseValue > 12 && noiseValue <= 15) {
				return hellCreekHardwoodForest;
			}
		}
		if (worldNumber == 3 || worldNumber == 4) {
			if (noiseValue > 15 && noiseValue <= 15.5) {
				return hellCreekRiver;
			} else if (noiseValue > 15.5 && noiseValue <= 17) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > 17 && noiseValue <= 21) {
				return hellCreekBluffs;
			} else if (noiseValue > 21 && noiseValue <= 26) {
				return hellCreekRedwoods;
			} else if (noiseValue > 26 && noiseValue <= 28) {
				return hellCreekBluffs;
			} else if (noiseValue > 28 && noiseValue <= 31) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > 31 && noiseValue <= 34) {
				return hellCreekClearing;
			} else if (noiseValue > 34 && noiseValue <= 38) {
				return hellCreekHardwoodForest;
			} else if (noiseValue > 38 && noiseValue <= 42) {
				return hellCreekSwamp;
			} else if (noiseValue > 42 && noiseValue <= 45) {
				return hellCreekHardwoodForest;
			}
		}
		//Yixian
		if (worldNumber == 0 || worldNumber == 4) {
			if (noiseValue > -15 && noiseValue <= -12) {
				return yixianForest;
			} else if (noiseValue > -12 && noiseValue <= -8) {
				return yixianSnowyForest;
			} else if (noiseValue > -8 && noiseValue <= -2) {
				return yixianSnowyMountains;
			} else if (noiseValue > -2 && noiseValue <= 1) {
				return yixianForest;
			} else if (noiseValue > 1 && noiseValue <= 4) {
				return yixianRegrowth;
			} else if (noiseValue > 4 && noiseValue <= 10) {
				return yixianVolcano;
			} else if (noiseValue > 10 && noiseValue <= 15) {
				return yixianForest;
			}
		}
		if (worldNumber == 2 || worldNumber == 3) {
			if (noiseValue > -45 && noiseValue <= -42) {
				return yixianForest;
			} else if (noiseValue > -42 && noiseValue <= -38) {
				return yixianSnowyForest;
			} else if (noiseValue > -38 && noiseValue <= -32) {
				return yixianSnowyMountains;
			} else if (noiseValue > -32 && noiseValue <= -29) {
				return yixianForest;
			} else if (noiseValue > -29 && noiseValue <= -26) {
				return yixianRegrowth;
			} else if (noiseValue > -26 && noiseValue <= -20) {
				return yixianVolcano;
			} else if (noiseValue > -20 && noiseValue <= -15) {
				return yixianForest;
			}
		}
		if (worldNumber == 1 || worldNumber == 5) {
			if (noiseValue > 15 && noiseValue <= 18) {
				return yixianForest;
			} else if (noiseValue > 18 && noiseValue <= 22) {
				return yixianSnowyForest;
			} else if (noiseValue > 22 && noiseValue <= 28) {
				return yixianSnowyMountains;
			} else if (noiseValue > 28 && noiseValue <= 31) {
				return yixianForest;
			} else if (noiseValue > 31 && noiseValue <= 34) {
				return yixianRegrowth;
			} else if (noiseValue > 34 && noiseValue <= 40) {
				return yixianVolcano;
			} else if (noiseValue > 40 && noiseValue <= 45) {
				return yixianForest;
			}
		}
		
		if (worldNumber == 1 || worldNumber == 3) {
			if (noiseValue > -15 && noiseValue <= -9) {
				return djadochtaDunes;
			} else if (noiseValue > -9 && noiseValue <= -4) {
				return djadochtaAlluvialPlains;
			} else if (noiseValue > -4 && noiseValue <= 3) {
				return djadochtaDunes;
			} else if (noiseValue > 3 && noiseValue <= 10) {
				return djadochtaArroyo;
			} else if (noiseValue > 10 && noiseValue <= 15) {
				return djadochtaDunes;
			}
		}
		if (worldNumber == 4 || worldNumber == 5) {
			if (noiseValue > -45 && noiseValue <= -39) {
				return djadochtaDunes;
			} else if (noiseValue > -39 && noiseValue <= -34) {
				return djadochtaAlluvialPlains;
			} else if (noiseValue > -34 && noiseValue <= -27) {
				return djadochtaDunes;
			} else if (noiseValue > -27 && noiseValue <= -20) {
				return djadochtaArroyo;
			} else if (noiseValue > -20 && noiseValue <= -15) {
				return djadochtaDunes;
			}
		}
		if (worldNumber == 0 || worldNumber == 2) {
			if (noiseValue > 15 && noiseValue <= 21) {
				return djadochtaDunes;
			} else if (noiseValue > 21 && noiseValue <= 26) {
				return djadochtaAlluvialPlains;
			} else if (noiseValue > 26 && noiseValue <= 33) {
				return djadochtaDunes;
			} else if (noiseValue > 33 && noiseValue <= 40) {
				return djadochtaArroyo;
			} else if (noiseValue > 40 && noiseValue <= 45) {
				return djadochtaDunes;
			}
		}
		return hellCreekRiver;
	}

}
