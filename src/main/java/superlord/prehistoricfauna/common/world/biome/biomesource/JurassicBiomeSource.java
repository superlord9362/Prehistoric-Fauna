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

	private final Holder<Biome> kayentaDryForest, kayentaButtes, kayentaDesert, kayentaDunes, kayentaCanyons, kayentaRiver, morrisonSavanna, morrisonSaltFlats, morrisonSparseForest, morrisonGalleryForest, morrisonUplandForest, morrisonRiver, shaximiaoDeltaPlains, shaximiaoLakes, shaximiaoGalleryForest, shaximiaoDryForest, shaximiaoMountains, shaximiaoAridLakes, dripstoneCaves, henostoneCaves;

	public JurassicBiomeSource(HolderGetter<Biome> biome) {
		this(biome.getOrThrow(PFBiomes.KAYENTA_DRY_FOREST), biome.getOrThrow(PFBiomes.KAYENTA_BUTTES), biome.getOrThrow(PFBiomes.KAYENTA_DESERT), biome.getOrThrow(PFBiomes.KAYENTA_DUNES), biome.getOrThrow(PFBiomes.KAYENTA_CANYONS), biome.getOrThrow(PFBiomes.KAYENTA_RIVER), biome.getOrThrow(PFBiomes.MORRISON_SAVANNA), biome.getOrThrow(PFBiomes.MORRISON_SALT_FLATS), biome.getOrThrow(PFBiomes.MORRISON_SPARSE_FOREST), biome.getOrThrow(PFBiomes.MORRISON_GALLERY_FOREST), biome.getOrThrow(PFBiomes.MORRISON_UPLAND_FOREST), biome.getOrThrow(PFBiomes.MORRISON_RIVER), biome.getOrThrow(PFBiomes.SHAXIMIAO_DELTA_PLAINS), biome.getOrThrow(PFBiomes.SHAXIMIAO_LAKES), biome.getOrThrow(PFBiomes.SHAXIMIAO_GALLERY_FOREST), biome.getOrThrow(PFBiomes.SHAXIMIAO_DRY_FOREST), biome.getOrThrow(PFBiomes.SHAXIMIAO_MOUNTAINS), biome.getOrThrow(PFBiomes.SHAXIMIAO_ARID_LAKES), biome.getOrThrow(PFBiomes.JURASSIC_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.JURASSIC_HENOSTONE_CAVE));
	}

	public static JurassicBiomeSource create(HolderGetter<Biome> biome) {
		return new JurassicBiomeSource(biome.getOrThrow(PFBiomes.KAYENTA_DRY_FOREST), biome.getOrThrow(PFBiomes.KAYENTA_BUTTES), biome.getOrThrow(PFBiomes.KAYENTA_DESERT), biome.getOrThrow(PFBiomes.KAYENTA_DUNES), biome.getOrThrow(PFBiomes.KAYENTA_CANYONS), biome.getOrThrow(PFBiomes.KAYENTA_RIVER), biome.getOrThrow(PFBiomes.MORRISON_SAVANNA), biome.getOrThrow(PFBiomes.MORRISON_SALT_FLATS), biome.getOrThrow(PFBiomes.MORRISON_SPARSE_FOREST), biome.getOrThrow(PFBiomes.MORRISON_GALLERY_FOREST), biome.getOrThrow(PFBiomes.MORRISON_UPLAND_FOREST), biome.getOrThrow(PFBiomes.MORRISON_RIVER), biome.getOrThrow(PFBiomes.SHAXIMIAO_DELTA_PLAINS), biome.getOrThrow(PFBiomes.SHAXIMIAO_LAKES), biome.getOrThrow(PFBiomes.SHAXIMIAO_GALLERY_FOREST), biome.getOrThrow(PFBiomes.SHAXIMIAO_DRY_FOREST), biome.getOrThrow(PFBiomes.SHAXIMIAO_MOUNTAINS), biome.getOrThrow(PFBiomes.SHAXIMIAO_ARID_LAKES), biome.getOrThrow(PFBiomes.JURASSIC_DRIPSTONE_CAVE), biome.getOrThrow(PFBiomes.JURASSIC_HENOSTONE_CAVE));
	}

	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(kayentaDryForest, kayentaButtes, kayentaDesert, kayentaDunes, kayentaCanyons, kayentaRiver, morrisonSavanna, morrisonSaltFlats, morrisonSparseForest, morrisonGalleryForest, morrisonUplandForest, morrisonRiver, shaximiaoDeltaPlains, shaximiaoLakes, shaximiaoGalleryForest, shaximiaoDryForest, shaximiaoMountains, shaximiaoAridLakes, dripstoneCaves, henostoneCaves);
	}

	public JurassicBiomeSource(Holder<Biome> kayentaDryForest, Holder<Biome> kayentaButtes, Holder<Biome> kayentaDesert, Holder<Biome> kayentaDunes, Holder<Biome> kayentaCanyons, Holder<Biome> kayentaRiver, Holder<Biome> morrisonSavanna, Holder<Biome> morrisonSaltFlats, Holder<Biome> morrisonSparseForest, Holder<Biome> morrisonGalleryForest, Holder<Biome> morrisonUplandForest, Holder<Biome> morrisonRiver, Holder<Biome> shaximiaoDeltaPlains, Holder<Biome> shaximiaoLakes, Holder<Biome> shaximiaoGalleryForest, Holder<Biome> shaximiaoDryForest, Holder<Biome> shaximiaoMountains, Holder<Biome> shaximiaoAridLakes, Holder<Biome> dripstoneCaves, Holder<Biome> henostoneCaves) {
		this.kayentaDryForest = kayentaDryForest;
		this.kayentaButtes = kayentaButtes;
		this.kayentaDesert = kayentaDesert;
		this.kayentaDunes = kayentaDunes;
		this.kayentaCanyons = kayentaCanyons;
		this.kayentaRiver = kayentaRiver;
		this.morrisonSavanna = morrisonSavanna;
		this.morrisonSaltFlats = morrisonSaltFlats;
		this.morrisonSparseForest = morrisonSparseForest;
		this.morrisonGalleryForest = morrisonGalleryForest;
		this.morrisonUplandForest = morrisonUplandForest;
		this.morrisonRiver = morrisonRiver;
		this.shaximiaoDeltaPlains = shaximiaoDeltaPlains;
		this.shaximiaoLakes = shaximiaoLakes;
		this.shaximiaoGalleryForest = shaximiaoGalleryForest;
		this.shaximiaoDryForest = shaximiaoDryForest;
		this.shaximiaoMountains = shaximiaoMountains;
		this.shaximiaoAridLakes = shaximiaoAridLakes;
		this.dripstoneCaves = dripstoneCaves;
		this.henostoneCaves = henostoneCaves;
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
			if (humidityNoise > 0.4D) return dripstoneCaves;
			if (caveTimeLineNoise > 0.8D) return henostoneCaves;
		}
		if (timelineNoise >= 0.34F) {
			if (tempNoise > 0.2F) {
				if (hillinessNoise < -0.5F) return kayentaButtes;
				if (hillinessNoise > 0.5F) return kayentaDunes;
				else return kayentaDesert;
			} else {
				if (hillinessNoise < -0.5F) {
					return kayentaCanyons;
				} else {
					if (tempNoise > -0.41 && tempNoise < -0.39) return kayentaRiver;
					else return kayentaDryForest;
				}
			}
		} else if (timelineNoise <= -0.34F) {
			if (tempNoise > 0) {
				if (hillinessNoise > 0.5) return shaximiaoMountains;
				if (hillinessNoise < -0.6) return shaximiaoAridLakes;
				else return shaximiaoDryForest;
			} else {
				if (hillinessNoise < 0) {
					if (humidityNoise > 0) return shaximiaoDeltaPlains;
					else return shaximiaoLakes;
				}
				else return shaximiaoGalleryForest;
			}			
		} else if (timelineNoise >= 0.33 && timelineNoise < 0.34) {
			return kayentaRiver;
		} else if (timelineNoise >= -0.34 && timelineNoise < -0.33 || timelineNoise >= 0.32 && timelineNoise < 0.33) {
			return morrisonRiver;
		} else {
			if (hillinessNoise < 0F && tempNoise > 0.25 && humidityNoise < 0) return morrisonSaltFlats;
			else if (humidityNoise > 0) {
				if (hillinessNoise > 0.5) return morrisonUplandForest;
				else if (tempNoise < 0.25) {
					if (tempNoise < -0.36 && tempNoise > -0.38) return morrisonRiver;
					else return morrisonGalleryForest;
				}
				else return morrisonSparseForest;
			} else return morrisonSavanna;
		}


		//		else return morrisonSavanna;
		//		if (timelineNoise >= 0) {
		//			if (hillinessNoise > 0.3F) return morrisonHills;
		//			else return morrisonSavanna;
		//		} else if (timelineNoise <= -0.0111F) {
		//			if (tempNoise > 0.2F) {
		//				if (hillinessNoise > 0.4F) return kayentaButtes;
		//				else return kayentaDesert;
		//			} else return kayentaDryForest;
		//		} else return kayentaRiver;
	}

}
