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
import superlord.prehistoricfauna.common.world.chunkgen.JurassicChunkGenerator;
import superlord.prehistoricfauna.init.PFBiomes;

public class JurassicBiomeSource extends BiomeSource implements NoiseBiomeSource {
	double noiseValue;

	public static final Codec<JurassicBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistryLookup(Registries.BIOME).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(JurassicBiomeSource::new));
	});

	private final Holder<Biome> kayentaDryForest, kayentaButtes, kayentaDesert, kayentaRiver, morrisonSavanna, morrisonHills, prehistoricDripstoneCave, henostoneCave;

	public JurassicBiomeSource(HolderGetter<Biome> biome) {
		this(biome.getOrThrow(PFBiomes.KAYENTA_DRY_FOREST), biome.getOrThrow(PFBiomes.KAYENTA_BUTTES), biome.getOrThrow(PFBiomes.KAYENTA_DESERT), biome.getOrThrow(PFBiomes.KAYENTA_RIVER), biome.getOrThrow(PFBiomes.MORRISON_SAVANNA), biome.getOrThrow(PFBiomes.MORRISON_HILLS), biome.getOrThrow(PFBiomes.JURASSIC_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.JURASSIC_HENOSTONE_CAVE));
	}
	
	public static JurassicBiomeSource create(HolderGetter<Biome> biome) {
		return new JurassicBiomeSource(biome.getOrThrow(PFBiomes.KAYENTA_DRY_FOREST), biome.getOrThrow(PFBiomes.KAYENTA_BUTTES), biome.getOrThrow(PFBiomes.KAYENTA_DESERT), biome.getOrThrow(PFBiomes.KAYENTA_RIVER), biome.getOrThrow(PFBiomes.MORRISON_SAVANNA), biome.getOrThrow(PFBiomes.MORRISON_HILLS), biome.getOrThrow(PFBiomes.JURASSIC_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.JURASSIC_HENOSTONE_CAVE));
	}
	
	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(this.kayentaButtes, this.kayentaDesert, this.kayentaDryForest, this.kayentaRiver, this.morrisonHills, this.morrisonSavanna, this.prehistoricDripstoneCave, this.henostoneCave);
	}

	public JurassicBiomeSource(Holder<Biome> kayentaDryForest, Holder<Biome> kayentaButtes, Holder<Biome> kayentaDesert, Holder<Biome> kayentaRiver, Holder<Biome> morrisonSavanna, Holder<Biome> morrisonHills, Holder<Biome> prehistoricDripstoneCave, Holder<Biome> henostoneCave) {
		this.kayentaDryForest = kayentaDryForest;
		this.kayentaButtes = kayentaButtes;
		this.kayentaDesert = kayentaDesert;
		this.kayentaRiver = kayentaRiver;
		this.morrisonSavanna = morrisonSavanna;
		this.morrisonHills = morrisonHills;
		this.prehistoricDripstoneCave = prehistoricDripstoneCave;
		this.henostoneCave = henostoneCave;
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
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
	
	public double caveTimeLineNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.3F, y * 0.3F, z * 0.3F);
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
		double caveTimeLineNoise = caveTimeLineNoise(x, y, z, JurassicChunkGenerator.noise);
		if (y < 6) {
			if (humidityNoise > 0.4D) return prehistoricDripstoneCave;
			if (caveTimeLineNoise > 0.8D) return henostoneCave;
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
