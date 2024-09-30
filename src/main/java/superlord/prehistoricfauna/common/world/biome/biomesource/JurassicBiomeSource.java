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
import superlord.prehistoricfauna.common.world.chunkgen.JurassicChunkGenerator;
import superlord.prehistoricfauna.init.PFBiomes;

public class JurassicBiomeSource extends BiomeSource implements NoiseBiomeSource {
	double noiseValue;

	public static final Codec<JurassicBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(JurassicBiomeSource::new));
	});

	private final Holder<Biome> kayentaDryForest, kayentaButtes, kayentaDesert, kayentaRiver, morrisonSavanna, morrisonHills, prehistoricDripstoneCave;

	public JurassicBiomeSource(Registry<Biome> biome) {
		this(biome.getOrCreateHolder(PFBiomes.KAYENTA_DRY_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.KAYENTA_BUTTES.getKey()), biome.getOrCreateHolder(PFBiomes.KAYENTA_DESERT.getKey()), biome.getOrCreateHolder(PFBiomes.KAYENTA_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.MORRISON_SAVANNA.getKey()), biome.getOrCreateHolder(PFBiomes.MORRISON_HILLS.getKey()), biome.getOrCreateHolder(PFBiomes.JURASSIC_DRIPSTONE_CAVE.getKey()));
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
		double timelineNoise = timeLineNoise(x, y, z, JurassicChunkGenerator.noise);
		double tempNoise = tempNoise(x, y, z, JurassicChunkGenerator.noise);
		double humidityNoise = humidityNoise(x, y, z, JurassicChunkGenerator.noise);
		double hillinessNoise = hillinessNoise(x, y, z, JurassicChunkGenerator.noise);
		if (humidityNoise > 0.4D && y < 6) {
			return prehistoricDripstoneCave;
		}
		if (timelineNoise >= 0) {
			if (hillinessNoise > 0.3F) return morrisonHills;
			else return morrisonSavanna;
		} else if (timelineNoise <= -0.0111F) {
			if (tempNoise > 0.2F) {
				if (hillinessNoise > 0.4F) return kayentaButtes;
				else return kayentaDesert;
			} else return kayentaDryForest;
		} else return kayentaRiver;
	}

}
