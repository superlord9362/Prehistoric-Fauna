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
import superlord.prehistoricfauna.common.world.chunkgen.JurassicChunkGenerator;
import superlord.prehistoricfauna.init.PFBiomes;

public class JurassicBiomeSource extends BiomeSource implements NoiseBiomeSource {

	public static final Codec<JurassicBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(JurassicBiomeSource::new));
	});

	private final Holder<Biome> kayentaDryForest, kayentaButtes, kayentaDesert, kayentaRiver, morrisonSavanna, morrisonHills, prehistoricDripstoneCave;

	public JurassicBiomeSource(Registry<Biome> biome) {
		this(biome.getOrCreateHolder(PFBiomes.KAYENTA_DRY_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.KAYENTA_BUTTES.getKey()), biome.getOrCreateHolder(PFBiomes.KAYENTA_DESERT.getKey()), biome.getOrCreateHolder(PFBiomes.KAYENTA_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.MORRISON_SAVANNA.getKey()), biome.getOrCreateHolder(PFBiomes.MORRISON_HILLS.getKey()), biome.getOrCreateHolder(PFBiomes.PREHISTORIC_DRIPSTONE_CAVE.getKey()));
	}

	public JurassicBiomeSource(Holder<Biome> kayentaDryForest, Holder<Biome> kayentaButtes, Holder<Biome> kayentaDesert, Holder<Biome> kayentaRiver, Holder<Biome> morrisonSavanna, Holder<Biome> morrisonHills, Holder<Biome> prehistoricDripstoneCave) {
		super(ImmutableList.of(kayentaDryForest, kayentaButtes, kayentaDesert, kayentaRiver, morrisonSavanna, morrisonHills, prehistoricDripstoneCave));
		this.kayentaDryForest = kayentaDryForest;
		this.kayentaButtes = kayentaButtes;
		this.kayentaDesert = kayentaDesert;
		this.kayentaRiver = kayentaRiver;
		this.morrisonSavanna = morrisonSavanna;
		this.morrisonHills = morrisonHills;
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
		float frequency = 0.5F;
		float amplitude = 4.0F;
		double noiseX = noise.GetNoise(x * frequency, z * frequency);
		double noiseZ = noise.GetNoise(x * frequency, z * frequency);
		double combinedNoise = amplitude * (noiseX + noiseZ);
		return combinedNoise;
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

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		double noiseValue = calculateNoiseValue(x, z, JurassicChunkGenerator.noise);
		double caveNoiseValue = calculateCaveNoiseValue(y, JurassicChunkGenerator.noise);
		if (caveNoiseValue < 0.5 && caveNoiseValue > 0) {
			Random random = new Random();
			if (y < Mth.nextDouble(random, -64, 44)) return prehistoricDripstoneCave;
			else {
				if (noiseValue > 0.5 && noiseValue <= 1.5 || noiseValue > 2.5 && noiseValue <= 3.5 || noiseValue > 4.5 && noiseValue <= 5.5) {
					return morrisonSavanna;
				} else if (noiseValue > 1.5 && noiseValue <= 2.5 || noiseValue > 3.5 && noiseValue <= 4.5) {
					return morrisonHills;
				} else if (noiseValue > -1.5 && noiseValue <= -0.5 || noiseValue > -3.5 && noiseValue <= -2.5 || noiseValue > -5.5 && noiseValue <= -4.5) {
					return kayentaDryForest;
				} else if (noiseValue > -2.5 && noiseValue <= -1.5) {
					return kayentaButtes;
				} else if (noiseValue > -4.5 && noiseValue <= -3.5) {
					return kayentaDesert;
				} else {
					return kayentaRiver;
				}
			}
		}
		if (noiseValue > 0.5 && noiseValue <= 1.5 || noiseValue > 2.5 && noiseValue <= 3.5 || noiseValue > 4.5 && noiseValue <= 5.5) {
			return morrisonSavanna;
		} else if (noiseValue > 1.5 && noiseValue <= 2.5 || noiseValue > 3.5 && noiseValue <= 4.5) {
			return morrisonHills;
		} else if (noiseValue > -1.5 && noiseValue <= -0.5 || noiseValue > -3.5 && noiseValue <= -2.5 || noiseValue > -5.5 && noiseValue <= -4.5) {
			return kayentaDryForest;
		} else if (noiseValue > -2.5 && noiseValue <= -1.5) {
			return kayentaButtes;
		} else if (noiseValue > -4.5 && noiseValue <= -3.5) {
			return kayentaDesert;
		} else {
			return kayentaRiver;
		}
	}

}
