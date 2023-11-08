package superlord.prehistoricfauna.common.world.biome;

import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Biome.BiomeCategory;

public class JurassicBiomes {

	private static Biome biome(Biome.BiomeCategory category, int waterColor, int waterFogColor, int skyColor, int fogColor, Biome.Precipitation precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.precipitation(precipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.biomeCategory(category)
				.build();
	}
	
	public static Biome kayentaDryForest() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x215FA4, 0x376682, 0x94addf, 0xde9757, Biome.Precipitation.RAIN, 1.2F, 0.1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome kayentaButtes() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x215FA4, 0x376682, 0x94addf, 0xde9757, Biome.Precipitation.RAIN, 1.2F, 0.1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome kayentaDesert() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x215FA4, 0x376682, 0x94addf, 0xde9757, Biome.Precipitation.NONE, 1.2F, 0F, spawnSettings, biomeFeatures);
	}
	
	public static Biome kayentaRiver() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x215FA4, 0x376682, 0x94addf, 0xde9757, Biome.Precipitation.RAIN, 1.2F, 0.1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome morrisonSavanna() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, Biome.Precipitation.NONE, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome morrisonHills() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, Biome.Precipitation.NONE, 1F, 0.2F, spawnSettings, biomeFeatures);
	}

}
