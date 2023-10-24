package superlord.prehistoricfauna.common.world.biome;

import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class TriassicBiomes {
	
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
	
	public static Biome chinleFlats() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 7372597, 5267523, 15922646, 13622197, Biome.Precipitation.RAIN, 0.9F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome chinleRiver() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 7372597, 5267523, 15922646, 13622197, Biome.Precipitation.RAIN, 0.9F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome chinleSwamp() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 7372597, 5267523, 15922646, 13622197, Biome.Precipitation.RAIN, 0.9F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome chinleWoodedMountains() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 7372597, 5267523, 15922646, 13622197, Biome.Precipitation.RAIN, 0.9F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome ischigualastoClearing() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 4417619, 4219470, 10464974, 12638463, Biome.Precipitation.RAIN, 0.75F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome ischigualastoForest() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 4417619, 4219470, 10464974, 12638463, Biome.Precipitation.RAIN, 0.75F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome ischigualastoHills() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 4417619, 4219470, 10464974, 12638463, Biome.Precipitation.RAIN, 0.75F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome ischigualastoRiver() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 4417619, 4219470, 10464974, 12638463, Biome.Precipitation.RAIN, 0.75F, 0.9F, spawnSettings, biomeFeatures);
	}

}
