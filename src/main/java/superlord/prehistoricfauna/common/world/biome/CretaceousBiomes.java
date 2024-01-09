package superlord.prehistoricfauna.common.world.biome;

import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class CretaceousBiomes {

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
	
	public static Biome hellCreekHardwoodForest() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, Biome.Precipitation.RAIN, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekClearing() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, Biome.Precipitation.RAIN, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekLiriodendritesHills() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, Biome.Precipitation.RAIN, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekRedwoods() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, Biome.Precipitation.RAIN, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekSwamp() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, Biome.Precipitation.RAIN, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekRiver() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, Biome.Precipitation.RAIN, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome djadochtaDunes() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x66866b, 0x9c8c67, 0x5F909D, 12638463, Biome.Precipitation.NONE, 0.2F, 1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome djadochtaArroyo() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x66866b, 0x9c8c67, 0x5F909D, 12638463, Biome.Precipitation.NONE, 0.2F, 1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome djadochtaAlluvialPlains() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x66866b, 0x9c8c67, 0x5F909D, 12638463, Biome.Precipitation.NONE, 0.2F, 1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianForest() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x318E6C, 0x1B684C, 0x99BEDB, 0xC1D0DC, Biome.Precipitation.RAIN, 0.8F, 0.4F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianSnowyForest() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x318E6C, 0x1B684C, 0x99BEDB, 0xC1D0DC, Biome.Precipitation.SNOW, 0.8F, 0.4F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianSnowyMountains() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x318E6C, 0x1B684C, 0x99BEDB, 0xC1D0DC, Biome.Precipitation.SNOW, 0.8F, 0.4F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianRegrowth() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x318E6C, 0x1B684C, 0x99BEDB, 0xC1D0DC, Biome.Precipitation.RAIN, 0.8F, 0.4F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianVolcano() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 0x395148, 0x414C47, 0x4F5A63, 0x5D5F60, Biome.Precipitation.NONE, 0.2F, 1.3F, spawnSettings, biomeFeatures);
	}
	
}
