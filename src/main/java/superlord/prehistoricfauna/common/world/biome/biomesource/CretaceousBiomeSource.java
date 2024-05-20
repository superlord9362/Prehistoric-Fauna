package superlord.prehistoricfauna.common.world.biome.biomesource;

import java.util.Random;

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
	int worldNumber;

	public static final Codec<CretaceousBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((biomeGetter) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(CretaceousBiomeSource::new));
	});

	@SuppressWarnings("unused")
	private final Holder<Biome> hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, prehistoricDripstoneCave, yixianLakes;

	public CretaceousBiomeSource(Registry<Biome> biome) {
		this(biome.getOrCreateHolder(PFBiomes.HELL_CREEK_HARDWOOD_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_CLEARING.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_BLUFFS.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_REDWOODS.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_SWAMP.getKey()), biome.getOrCreateHolder(PFBiomes.HELL_CREEK_RIVER.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_DUNES.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_ARROYO.getKey()), biome.getOrCreateHolder(PFBiomes.DJADOCHTA_ALLUVIAL_PLAINS.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_SNOWY_FOREST.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_SNOWY_MOUNTAINS.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_REGROWTH.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_VOLCANO.getKey()), biome.getOrCreateHolder(PFBiomes.PREHISTORIC_DRIPSTONE_CAVE.getKey()), biome.getOrCreateHolder(PFBiomes.YIXIAN_LAKES.getKey()));
		Random random = new Random();
		this.worldNumber = random.nextInt(6);
	}

	public CretaceousBiomeSource(Holder<Biome> hellCreekHardwoodForest, Holder<Biome> hellCreekClearing, Holder<Biome> hellCreekBluffs, Holder<Biome> hellCreekRedwoods, Holder<Biome> hellCreekSwamp, Holder<Biome> hellCreekRiver, Holder<Biome> djadochtaDunes, Holder<Biome> djadochtaArroyo, Holder<Biome> djadochtaAlluvialPlains, Holder<Biome> yixianForest, Holder<Biome> yixianSnowyForest, Holder<Biome> yixianSnowyMountains, Holder<Biome> yixianRegrowth, Holder<Biome> yixianVolcano, Holder<Biome> prehistoricDripstoneCave, Holder<Biome> yixianLakes) {
		super(ImmutableList.of(hellCreekHardwoodForest, hellCreekClearing, hellCreekBluffs, hellCreekRedwoods, hellCreekSwamp, hellCreekRiver, djadochtaDunes, djadochtaArroyo, djadochtaAlluvialPlains, yixianForest, yixianSnowyForest, yixianSnowyMountains, yixianRegrowth, yixianVolcano, prehistoricDripstoneCave, yixianLakes));
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
		this.yixianLakes = yixianLakes;
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
	
	public double timeLineNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.5F, y * 0.5F, z * 0.5F);
	}
	
	public double tempNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.2F, y * 0.2F, z * 0.2F);
	}
	
	public double hillinessNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.4F, y * 0.4F, z * 0.4F);
	}
	
	public double humidityNoise(int x, int y, int z, FastNoise noise) {
		return noise.GetNoise(x * 0.7F, y * 0.7F, z * 0.7F);
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
		if (timelineNoise > 0.333F) {
			if ((tempNoise >= -0.5 && tempNoise <= 0) && (humidityNoise >= -0.5F && humidityNoise <= 0.5F) && (hillinessNoise >= -0.5F && hillinessNoise <= 0.5F)) return hellCreekHardwoodForest;
			if ((tempNoise >= 0.5F) && (humidityNoise >= -1 && humidityNoise <= 0) && (hillinessNoise < -0.5F)) return hellCreekClearing;
			if ((tempNoise <= -0.5F) && (humidityNoise <= -0.5F) && (hillinessNoise >= 0.5F)) return hellCreekBluffs;
			if ((tempNoise >= -1 && tempNoise <= 0) && (humidityNoise >= -0.5F && humidityNoise <= 0.5F) && (hillinessNoise >= -0.5F && hillinessNoise <= 0.5F)) return hellCreekRedwoods;
			if ((tempNoise >= 0.5F) && (humidityNoise >= 0.5F) && (hillinessNoise <= -0.5F)) return hellCreekSwamp;
			if ((tempNoise >= -0.5F && tempNoise <= 0.5F) && (humidityNoise >= 0.5F) && (hillinessNoise <= -0.85F)) return hellCreekRiver;
		} else if (timelineNoise < -0.333F) {
			if ((tempNoise >= -0.5F && tempNoise <= 0.5F) && (humidityNoise >= -0.5F && humidityNoise <= 0.5F) && (hillinessNoise >= -0.5F && hillinessNoise <= 0)) return yixianForest;
			if ((tempNoise >= -1F && tempNoise <= -0.5F) && (humidityNoise >= 0.5F && humidityNoise <= 1F) && (hillinessNoise >= 0F && hillinessNoise <= 0.5F)) return yixianSnowyForest;
			if ((tempNoise >= -1F && tempNoise <= -0.5F) && (humidityNoise >= 0F && humidityNoise <= 1F) && (hillinessNoise >= 0.5F && hillinessNoise <= 1)) return yixianSnowyMountains;
			if ((tempNoise >= 0F && tempNoise <= 0.75F) && (humidityNoise >= -1F && humidityNoise <= 0F) && (hillinessNoise >= -0.25F && hillinessNoise <= 0.75F)) return yixianRegrowth;
			if ((tempNoise >= 0.75F && tempNoise <= 1F) && (humidityNoise >= -1F && humidityNoise <= -0.5F) && (hillinessNoise >= 0.75F && hillinessNoise <= 1)) return yixianVolcano;
			if ((tempNoise >= -0.5F && tempNoise <= 0.5F) && (humidityNoise >= 0.5F && humidityNoise <= 1F) && (hillinessNoise >= -1F && hillinessNoise <= 0.75F)) return yixianLakes;
		} else {
			if ((tempNoise >= -1F && tempNoise <= 1F) && (humidityNoise >= -1F && humidityNoise <= -0.5F) && (hillinessNoise >= 0.5F && hillinessNoise <= 1)) return djadochtaDunes;
			if ((tempNoise >= -1F && tempNoise <= 1F) && (humidityNoise >= 0.5F && humidityNoise <= 1F) && (hillinessNoise >= 0 && hillinessNoise <= 0.5F)) return djadochtaArroyo;
			if ((tempNoise >= -0.5F && tempNoise <= 0.5F) && (humidityNoise >= -0.5F && humidityNoise <= 0.5F) && (hillinessNoise >= -1F && hillinessNoise <= -0.5F)) return djadochtaAlluvialPlains;
		}
		return hellCreekRiver;
	}

}
