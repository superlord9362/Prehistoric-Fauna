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

public class JurassicBiomeSource extends BiomeSource implements NoiseBiomeSource { 
	public static final Codec<JurassicBiomeSource> CODEC = RecordCodecBuilder.create(instance -> instance.group( 
			RegistryOps.retrieveRegistryLookup(Registries.BIOME).forGetter(src -> null) 
			).apply(instance, JurassicBiomeSource::new)); 
	private final FastNoise climateNoise;
	private long lastSeed = -1;

	private final Holder<Biome> kayentaDryForest, kayentaButtes, kayentaDesert, kayentaDunes, kayentaCanyons, kayentaRiver, morrisonSavanna, morrisonSaltFlats, morrisonSparseForest, morrisonGalleryForest, morrisonUplandForest, morrisonRiver, shaximiaoDeltaPlains, shaximiaoLakes, shaximiaoGalleryForest, shaximiaoDryForest, shaximiaoMountains, shaximiaoAridLakes, dripstoneCaves, henostoneCaves; 

	public JurassicBiomeSource(HolderGetter<Biome> biome) { 
		this( 
				biome.getOrThrow(PFBiomes.KAYENTA_DRY_FOREST), 
				biome.getOrThrow(PFBiomes.KAYENTA_BUTTES), 
				biome.getOrThrow(PFBiomes.KAYENTA_DESERT), 
				biome.getOrThrow(PFBiomes.KAYENTA_DUNES), 
				biome.getOrThrow(PFBiomes.KAYENTA_CANYONS), 
				biome.getOrThrow(PFBiomes.KAYENTA_RIVER), 
				biome.getOrThrow(PFBiomes.MORRISON_SAVANNA), 
				biome.getOrThrow(PFBiomes.MORRISON_SALT_FLATS), 
				biome.getOrThrow(PFBiomes.MORRISON_SPARSE_FOREST), 
				biome.getOrThrow(PFBiomes.MORRISON_GALLERY_FOREST), 
				biome.getOrThrow(PFBiomes.MORRISON_UPLAND_FOREST), 
				biome.getOrThrow(PFBiomes.MORRISON_RIVER), 
				biome.getOrThrow(PFBiomes.SHAXIMIAO_DELTA_PLAINS), 
				biome.getOrThrow(PFBiomes.SHAXIMIAO_LAKES), 
				biome.getOrThrow(PFBiomes.SHAXIMIAO_GALLERY_FOREST), 
				biome.getOrThrow(PFBiomes.SHAXIMIAO_DRY_FOREST), 
				biome.getOrThrow(PFBiomes.SHAXIMIAO_MOUNTAINS), 
				biome.getOrThrow(PFBiomes.SHAXIMIAO_ARID_LAKES), 
				biome.getOrThrow(PFBiomes.JURASSIC_DRIPSTONE_CAVE), 
				biome.getOrThrow(PFBiomes.JURASSIC_HENOSTONE_CAVE) 
				); 
	} 

	public JurassicBiomeSource(Holder<Biome> kayentaDryForest, Holder<Biome> kayentaButtes, 
			Holder<Biome> kayentaDesert, Holder<Biome> kayentaDunes, Holder<Biome> kayentaCanyons, 
			Holder<Biome> kayentaRiver, Holder<Biome> morrisonSavanna, Holder<Biome> morrisonSaltFlats, 
			Holder<Biome> morrisonSparseForest, Holder<Biome> morrisonGalleryForest, Holder<Biome> morrisonUplandForest, 
			Holder<Biome> morrisonRiver, Holder<Biome> shaximiaoDeltaPlains, Holder<Biome> shaximiaoLakes, 
			Holder<Biome> shaximiaoGalleryForest, Holder<Biome> shaximiaoDryForest, Holder<Biome> shaximiaoMountains, 
			Holder<Biome> shaximiaoAridLakes, Holder<Biome> dripstoneCaves, Holder<Biome> henostoneCaves) { 
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
		this.climateNoise = new FastNoise(0); 
		this.climateNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
	} 

	@Override 
	protected Codec<? extends BiomeSource> codec() { 
		return CODEC; 
	} 

	@Override 
	protected Stream<Holder<Biome>> collectPossibleBiomes() { 
		return Stream.of(kayentaDryForest, kayentaButtes, kayentaDesert, kayentaDunes, kayentaCanyons, kayentaRiver, morrisonSavanna, morrisonSaltFlats, morrisonSparseForest, morrisonGalleryForest, morrisonUplandForest, morrisonRiver, shaximiaoDeltaPlains, shaximiaoLakes, shaximiaoGalleryForest, shaximiaoDryForest, shaximiaoMountains, shaximiaoAridLakes, dripstoneCaves, henostoneCaves);
	} 

	public double timeLineNoise(int x, int y, int z) { 
		return getNoise().GetNoise(x * 0.1F, z * 0.1F); 
	} 

	public double tempNoise(int x, int y, int z) {
		return getNoise().GetNoise(x * 0.2F, z * 0.2F); 
	} 

	public double hillinessNoise(int x, int y, int z) {
		return getNoise().GetNoise(x * 0.4F, z * 0.4F);
	} 

	public double humidityNoise(int x, int y, int z) { 
		return getNoise().GetNoise(x * 0.7F, z * 0.7F); 
	} 

	public double caveTimeLineNoise(int x, int y, int z) {
		return getNoise().GetNoise(x * 0.3F, y * 0.3F, z * 0.3F); 
	}

	public Climate.TargetPoint sampleCustomClimate(int x, int y, int z) {
		// Use your existing noise functions to generate climate-like parameters
		float temperature = (float) tempNoise(x, y, z);
		float humidity = (float) humidityNoise(x, y, z);
		float continentalness = (float) timeLineNoise(x, y, z);
		float erosion = (float) hillinessNoise(x, y, z);
		float depth = ((float) y / 256.0f) * 2.0f - 1.0f; // Map y level to depth
		float weirdness = (float) caveTimeLineNoise(x, y, z);
		return Climate.target(temperature, humidity, continentalness, erosion, depth, weirdness);
	}

	@Override 
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Sampler sampler) { 
		Climate.TargetPoint climate = sampleCustomClimate(x, y, z);
		return selectBiome(
				climate.temperature(), climate.humidity(), climate.continentalness(),
				climate.erosion(), climate.depth(), climate.weirdness(), y
				);
	} 

	public void updateNoise(long seed) {
		if (lastSeed != seed) {
			climateNoise.SetSeed((int) (seed & 0xFFFFFFFFL));
			lastSeed = seed;
		}
	}

	public FastNoise getNoise() {
		return climateNoise;
	}

	private Holder<Biome> selectBiome(float temperature, float humidity, float continentalness, float erosion, float depth, float weirdness, int y) {
		if (y < 6) {
			if (humidity / 10000 > 0.4D) return dripstoneCaves;
			if (weirdness / 10000 > 0.8D) return henostoneCaves;
		}
		if (continentalness / 10000 >= 0.34F) {
			if (temperature / 10000 > 0.2F) {
				if (erosion / 10000 < -0.5F) return kayentaButtes;
				if (erosion / 10000 > 0.5F) return kayentaDunes;
				else return kayentaDesert;
			} else {
				if (erosion / 10000 < -0.5F) {
					return kayentaCanyons;
				} else {
					if (temperature / 10000 > -0.41 && temperature / 10000 < -0.39) return kayentaRiver;
					else return kayentaDryForest;
				}
			}
		} else if (continentalness / 10000 <= -0.34F) {
			if (temperature / 10000 > 0) {
				if (erosion / 10000 > 0.5) return shaximiaoMountains;
				if (erosion / 10000 < -0.6) return shaximiaoAridLakes;
				else return shaximiaoDryForest;
			} else {
				if (erosion / 10000 < 0) {
					if (humidity / 10000 > 0) return shaximiaoDeltaPlains;
					else return shaximiaoLakes;
				}
				else return shaximiaoGalleryForest;
			}			
		} else if (continentalness / 10000 >= 0.33 && continentalness / 10000 < 0.34) {
			return kayentaRiver;
		} else if (continentalness / 10000 >= -0.34 && continentalness / 10000 < -0.33 || continentalness / 10000 >= 0.32 && continentalness / 10000 < 0.33) {
			return morrisonRiver;
		} else {
			if (erosion / 10000 < 0F && temperature / 10000 > 0.25 && humidity / 10000 < 0) return morrisonSaltFlats;
			else if (humidity / 10000 > 0) {
				if (erosion / 10000 > 0.5) return morrisonUplandForest;
				else if (temperature / 10000 < 0.25) {
					if (temperature / 10000 < -0.36 && temperature / 10000 > -0.38) return morrisonRiver;
					else return morrisonGalleryForest;
				}
				else return morrisonSparseForest;
			} else return morrisonSavanna;
		}
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z) {
		return getNoiseBiome(x, y, z, Climate.empty());
	} 

}