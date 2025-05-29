package superlord.prehistoricfauna.common.world.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFPlacedFeatures;
import superlord.prehistoricfauna.init.PFSounds;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class JurassicBiomes {

	private static Biome biome(boolean hasPrecipitation, int waterColor, int waterFogColor, int skyColor, int fogColor, int foliageColor, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.hasPrecipitation(hasPrecipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.foliageColorOverride(foliageColor)
						.grassColorOverride(foliageColor)
						.ambientMoodSound(new AmbientMoodSettings(PFSounds.CAVE_1.getHolder().get(), 6000, 8, 2.0D))
						.backgroundMusic(Musics.createGameMusic(PFSounds.AMBIENCE_1.getHolder().get()))
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}
	
	private static Biome biome(boolean hasPrecipitation, int waterColor, int waterFogColor, int skyColor, int fogColor, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.hasPrecipitation(hasPrecipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.ambientMoodSound(new AmbientMoodSettings(PFSounds.CAVE_1.getHolder().get(), 6000, 8, 2.0D))
						.backgroundMusic(Musics.createGameMusic(PFSounds.AMBIENCE_1.getHolder().get()))
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}
	
	public static Biome kayentaDryForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withKayentaDryForestVegetation(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.PACKED_MUD_DISK);
		if (PrehistoricFaunaConfig.calsoyasuchusKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CALSOYASUCHUS.get(), PrehistoricFaunaConfig.calsoyasuchusKayentaDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dilophosaurusKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILOPHOSAURUS.get(), PrehistoricFaunaConfig.dilophosaurusKayentaDryForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.sarahsaurusKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SARAHSAURUS.get(), PrehistoricFaunaConfig.sarahsaurusKayentaDryForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.scelidosaurusKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCELIDOSAURUS.get(), PrehistoricFaunaConfig.scelidosaurusKayentaDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaDryForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaDryForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.scutellosaurusKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCUTELLOSAURUS.get(), PrehistoricFaunaConfig.scutellosaurusKayentaDryForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.megapnosaurusKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MEGAPNOSAURUS.get(), PrehistoricFaunaConfig.megapnosaurusKayentaDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentatheriumKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTATHERIUM.get(), PrehistoricFaunaConfig.kayentatheriumKayentaDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentachelysKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTACHELYS.get(), PrehistoricFaunaConfig.kayentachelysKayentaDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentasuchusKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTASUCHUS.get(), PrehistoricFaunaConfig.kayentasuchusKayentaDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentavenatorKayentaDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTAVENATOR.get(), PrehistoricFaunaConfig.kayentavenatorKayentaDryForestSpawnWeight, 1, 2));
		return biome(true, 0x215FA4, 0x376682, 0x94addf, 0xde9757, 0x53711f, 1.2F, 0.1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome kayentaButtes(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withKayentaButtesVegetation(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.PACKED_MUD_DISK);
		if (PrehistoricFaunaConfig.calsoyasuchusKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CALSOYASUCHUS.get(), PrehistoricFaunaConfig.calsoyasuchusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dilophosaurusKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILOPHOSAURUS.get(), PrehistoricFaunaConfig.dilophosaurusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.sarahsaurusKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SARAHSAURUS.get(), PrehistoricFaunaConfig.sarahsaurusKayentaButtesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.scelidosaurusKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCELIDOSAURUS.get(), PrehistoricFaunaConfig.scelidosaurusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaButtesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaButtesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.scutellosaurusKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCUTELLOSAURUS.get(), PrehistoricFaunaConfig.scutellosaurusKayentaButtesSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.megapnosaurusKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MEGAPNOSAURUS.get(), PrehistoricFaunaConfig.megapnosaurusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentatheriumKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTATHERIUM.get(), PrehistoricFaunaConfig.kayentatheriumKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentachelysKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTACHELYS.get(), PrehistoricFaunaConfig.kayentachelysKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentasuchusKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTASUCHUS.get(), PrehistoricFaunaConfig.kayentasuchusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentavenatorKayentaButtesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTAVENATOR.get(), PrehistoricFaunaConfig.kayentavenatorKayentaButtesSpawnWeight, 1, 2));
		return biome(true, 0x215FA4, 0x376682, 0x94addf, 0xde9757, 0x53711f, 1.2F, 0.1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome kayentaDesert(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS);
		biomeFeatures.addFeature(Decoration.VEGETAL_DECORATION, PFPlacedFeatures.ZAMITES);
		PFPlacedFeatures.withKayentaDesertRocks(biomeFeatures);
		if (PrehistoricFaunaConfig.calsoyasuchusKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CALSOYASUCHUS.get(), PrehistoricFaunaConfig.calsoyasuchusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dilophosaurusKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILOPHOSAURUS.get(), PrehistoricFaunaConfig.dilophosaurusKayentaDesertSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.sarahsaurusKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SARAHSAURUS.get(), PrehistoricFaunaConfig.sarahsaurusKayentaDesertSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.scelidosaurusKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCELIDOSAURUS.get(), PrehistoricFaunaConfig.scelidosaurusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaDesertSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaDesertSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.scutellosaurusKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCUTELLOSAURUS.get(), PrehistoricFaunaConfig.scutellosaurusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.megapnosaurusKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MEGAPNOSAURUS.get(), PrehistoricFaunaConfig.megapnosaurusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentatheriumKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTATHERIUM.get(), PrehistoricFaunaConfig.kayentatheriumKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentachelysKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTACHELYS.get(), PrehistoricFaunaConfig.kayentachelysKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentasuchusKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTASUCHUS.get(), PrehistoricFaunaConfig.kayentasuchusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentavenatorKayentaDesertSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTAVENATOR.get(), PrehistoricFaunaConfig.kayentavenatorKayentaDesertSpawnWeight, 1, 2));
		return biome(false, 0x215FA4, 0x376682, 0x94addf, 0xde9757, 0x53711f, 1.2F, 0F, spawnSettings, biomeFeatures);
	}
	
	public static Biome kayentaDunes(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS);
		biomeFeatures.addFeature(Decoration.VEGETAL_DECORATION, PFPlacedFeatures.ZAMITES);
		PFPlacedFeatures.withKayentaDesertRocks(biomeFeatures);
		if (PrehistoricFaunaConfig.calsoyasuchusKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CALSOYASUCHUS.get(), PrehistoricFaunaConfig.calsoyasuchusKayentaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dilophosaurusKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILOPHOSAURUS.get(), PrehistoricFaunaConfig.dilophosaurusKayentaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.sarahsaurusKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SARAHSAURUS.get(), PrehistoricFaunaConfig.sarahsaurusKayentaDunesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.scelidosaurusKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCELIDOSAURUS.get(), PrehistoricFaunaConfig.scelidosaurusKayentaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaDunesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaDunesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.scutellosaurusKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCUTELLOSAURUS.get(), PrehistoricFaunaConfig.scutellosaurusKayentaDunesSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.megapnosaurusKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MEGAPNOSAURUS.get(), PrehistoricFaunaConfig.megapnosaurusKayentaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentatheriumKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTATHERIUM.get(), PrehistoricFaunaConfig.kayentatheriumKayentaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentachelysKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTACHELYS.get(), PrehistoricFaunaConfig.kayentachelysKayentaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentasuchusKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTASUCHUS.get(), PrehistoricFaunaConfig.kayentasuchusKayentaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentavenatorKayentaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTAVENATOR.get(), PrehistoricFaunaConfig.kayentavenatorKayentaDunesSpawnWeight, 1, 2));
		return biome(false, 0x215FA4, 0x376682, 0x94addf, 0xde9757, 0x53711f, 1.2F, 0F, spawnSettings, biomeFeatures);
	}
	
	public static Biome kayentaCanyons(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withKayentaButtesVegetation(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.PACKED_MUD_DISK);
		if (PrehistoricFaunaConfig.calsoyasuchusKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CALSOYASUCHUS.get(), PrehistoricFaunaConfig.calsoyasuchusKayentaCanyonsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dilophosaurusKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILOPHOSAURUS.get(), PrehistoricFaunaConfig.dilophosaurusKayentaCanyonsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.sarahsaurusKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SARAHSAURUS.get(), PrehistoricFaunaConfig.sarahsaurusKayentaCanyonsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.scelidosaurusKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCELIDOSAURUS.get(), PrehistoricFaunaConfig.scelidosaurusKayentaCanyonsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaCanyonsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaCanyonsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaCanyonsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaCanyonsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.scutellosaurusKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCUTELLOSAURUS.get(), PrehistoricFaunaConfig.scutellosaurusKayentaCanyonsSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.megapnosaurusKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MEGAPNOSAURUS.get(), PrehistoricFaunaConfig.megapnosaurusKayentaCanyonsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentatheriumKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTATHERIUM.get(), PrehistoricFaunaConfig.kayentatheriumKayentaCanyonsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentachelysKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTACHELYS.get(), PrehistoricFaunaConfig.kayentachelysKayentaCanyonsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentasuchusKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTASUCHUS.get(), PrehistoricFaunaConfig.kayentasuchusKayentaCanyonsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentavenatorKayentaCanyonsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTAVENATOR.get(), PrehistoricFaunaConfig.kayentavenatorKayentaCanyonsSpawnWeight, 1, 2));
		return biome(true, 0x215FA4, 0x376682, 0x94addf, 0xde9757, 0x53711f, 1.2F, 0.1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome kayentaRiver(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		biomeFeatures.addFeature(Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.MUD_DISK);
		if (PrehistoricFaunaConfig.calsoyasuchusKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CALSOYASUCHUS.get(), PrehistoricFaunaConfig.calsoyasuchusKayentaRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dilophosaurusKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILOPHOSAURUS.get(), PrehistoricFaunaConfig.dilophosaurusKayentaRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.sarahsaurusKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SARAHSAURUS.get(), PrehistoricFaunaConfig.sarahsaurusKayentaRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.scelidosaurusKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCELIDOSAURUS.get(), PrehistoricFaunaConfig.scelidosaurusKayentaRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.scutellosaurusKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCUTELLOSAURUS.get(), PrehistoricFaunaConfig.scutellosaurusKayentaRiverSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.megapnosaurusKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MEGAPNOSAURUS.get(), PrehistoricFaunaConfig.megapnosaurusKayentaRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentatheriumKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTATHERIUM.get(), PrehistoricFaunaConfig.kayentatheriumKayentaRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentachelysKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTACHELYS.get(), PrehistoricFaunaConfig.kayentachelysKayentaRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentasuchusKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTASUCHUS.get(), PrehistoricFaunaConfig.kayentasuchusKayentaRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentavenatorKayentaRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTAVENATOR.get(), PrehistoricFaunaConfig.kayentavenatorKayentaRiverSpawnWeight, 1, 2));
		return biome(true, 0x215FA4, 0x376682, 0x94addf, 0xde9757, 0x53711f, 1.2F, 0.1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome morrisonSavanna(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withMorrisonSavannaVegetation(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.PACKED_MUD_DISK);
		if (PrehistoricFaunaConfig.stegosaurusMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonSavannaSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dryosaurusMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonSavannaSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratosaurusMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonSavannaSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.allosaurusMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonSavannaSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannaSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.eilenodonMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonSavannaSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.camarasaurusMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonSavannaSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratodusMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonSavannaSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonSavannaSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dermestidBeetleMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleMorrisonSavannaSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonSavannaSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonSavannaSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.diablophisMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIABLOPHIS.get(), PrehistoricFaunaConfig.diablophisMorrisonSavannaSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.macelognathusMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MACELOGNATHUS.get(), PrehistoricFaunaConfig.macelognathusMorrisonSavannaSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.tanycolagreusMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TANYCOLAGREUS.get(), PrehistoricFaunaConfig.tanycolagreusMorrisonSavannaSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.morrolepisMorrisonSavannaSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MORROLEPIS.get(), PrehistoricFaunaConfig.morrolepisMorrisonSavannaSpawnWeight, 1, 2));
		return biome(false, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome morrisonRiver(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		if (PrehistoricFaunaConfig.stegosaurusMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dryosaurusMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonRiverSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratosaurusMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.allosaurusMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.hesperornithoidesMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonRiverSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.eilenodonMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.camarasaurusMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonRiverSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratodusMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dermestidBeetleMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleMorrisonRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.diablophisMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIABLOPHIS.get(), PrehistoricFaunaConfig.diablophisMorrisonRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.macelognathusMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MACELOGNATHUS.get(), PrehistoricFaunaConfig.macelognathusMorrisonRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.tanycolagreusMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TANYCOLAGREUS.get(), PrehistoricFaunaConfig.tanycolagreusMorrisonRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.morrolepisMorrisonRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MORROLEPIS.get(), PrehistoricFaunaConfig.morrolepisMorrisonRiverSpawnWeight, 1, 2));
		return biome(false, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome morrisonSaltFlats(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		if (PrehistoricFaunaConfig.stegosaurusMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonSaltFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dryosaurusMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonSaltFlatsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratosaurusMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonSaltFlatsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.allosaurusMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonSaltFlatsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.hesperornithoidesMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonSaltFlatsSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.eilenodonMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonSaltFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.camarasaurusMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonSaltFlatsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratodusMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonSaltFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonSaltFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dermestidBeetleMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleMorrisonSaltFlatsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonSaltFlatsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonSaltFlatsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.diablophisMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIABLOPHIS.get(), PrehistoricFaunaConfig.diablophisMorrisonSaltFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.macelognathusMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MACELOGNATHUS.get(), PrehistoricFaunaConfig.macelognathusMorrisonSaltFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.tanycolagreusMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TANYCOLAGREUS.get(), PrehistoricFaunaConfig.tanycolagreusMorrisonSaltFlatsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.morrolepisMorrisonSaltFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MORROLEPIS.get(), PrehistoricFaunaConfig.morrolepisMorrisonSaltFlatsSpawnWeight, 1, 2));
		return biome(false, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome morrisonSparseForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withMorrisonSparseForestPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.stegosaurusMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonSparseForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dryosaurusMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonSparseForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratosaurusMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonSparseForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.allosaurusMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonSparseForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.hesperornithoidesMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonSparseForestSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.eilenodonMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonSparseForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.camarasaurusMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonSparseForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratodusMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonSparseForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonSparseForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dermestidBeetleMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleMorrisonSparseForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonSparseForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonSparseForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.diablophisMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIABLOPHIS.get(), PrehistoricFaunaConfig.diablophisMorrisonSparseForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.macelognathusMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MACELOGNATHUS.get(), PrehistoricFaunaConfig.macelognathusMorrisonSparseForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.tanycolagreusMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TANYCOLAGREUS.get(), PrehistoricFaunaConfig.tanycolagreusMorrisonSparseForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.morrolepisMorrisonSparseForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MORROLEPIS.get(), PrehistoricFaunaConfig.morrolepisMorrisonSparseForestSpawnWeight, 1, 2));
		return biome(false, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome morrisonGalleryForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withMorrisonGalleryForestPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.stegosaurusMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dryosaurusMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonGalleryForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratosaurusMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonGalleryForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.allosaurusMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonGalleryForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.hesperornithoidesMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonGalleryForestSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.eilenodonMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.camarasaurusMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonGalleryForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratodusMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dermestidBeetleMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleMorrisonGalleryForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonGalleryForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonGalleryForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.diablophisMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIABLOPHIS.get(), PrehistoricFaunaConfig.diablophisMorrisonGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.macelognathusMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MACELOGNATHUS.get(), PrehistoricFaunaConfig.macelognathusMorrisonGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.tanycolagreusMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TANYCOLAGREUS.get(), PrehistoricFaunaConfig.tanycolagreusMorrisonGalleryForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.morrolepisMorrisonGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MORROLEPIS.get(), PrehistoricFaunaConfig.morrolepisMorrisonGalleryForestSpawnWeight, 1, 2));
		return biome(true, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome morrisonUplandForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withMorrisonUplandForestPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.stegosaurusMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonUplandForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dryosaurusMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonUplandForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratosaurusMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonUplandForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.allosaurusMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonUplandForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.hesperornithoidesMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonUplandForestSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.eilenodonMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonUplandForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.camarasaurusMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonUplandForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratodusMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonUplandForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.morrolepisMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MORROLEPIS.get(), PrehistoricFaunaConfig.morrolepisMorrisonUplandForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonUplandForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dermestidBeetleMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleMorrisonUplandForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonUplandForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonUplandForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.diablophisMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIABLOPHIS.get(), PrehistoricFaunaConfig.diablophisMorrisonUplandForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.macelognathusMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MACELOGNATHUS.get(), PrehistoricFaunaConfig.macelognathusMorrisonUplandForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.tanycolagreusMorrisonUplandForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TANYCOLAGREUS.get(), PrehistoricFaunaConfig.tanycolagreusMorrisonUplandForestSpawnWeight, 1, 3));
		return biome(true, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome shaximiaoDeltaPlains(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withShaximiaoDeltaPlainsPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.agilisaurusShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AGILISAURUS.get(), PrehistoricFaunaConfig.agilisaurusShaximiaoDeltaPlainsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.bashanosaurusShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASHANOSAURUS.get(), PrehistoricFaunaConfig.bashanosaurusShaximiaoDeltaPlainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chuandongocoelurusShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHUANDONGOCOELURUS.get(), PrehistoricFaunaConfig.chuandongocoelurusShaximiaoDeltaPlainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.gigantspinosaurusShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GIGANTSPINOSAURUS.get(), PrehistoricFaunaConfig.gigantspinosaurusShaximiaoDeltaPlainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.yandusaurusShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANDUSAURUS.get(), PrehistoricFaunaConfig.yandusaurusShaximiaoDeltaPlainsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.yangchuanosaurusShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANGCHUANOSAURUS.get(), PrehistoricFaunaConfig.yangchuanosaurusShaximiaoDeltaPlainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.lepidotesShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LEPIDOTES.get(), PrehistoricFaunaConfig.lepidotesShaximiaoDeltaPlainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusShaximiaoDeltaPlainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.chungkingichthysShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHUNGKINGICHTHYS.get(), PrehistoricFaunaConfig.chungkingichthysShaximiaoDeltaPlainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelShaximiaoDeltaPlainsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelShaximiaoDeltaPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelShaximiaoDeltaPlainsSpawnWeight, 1, 1));
		return biome(true, 0x20847A, 0x126363, 0x67C8FF, 0x8EE8FF, 0.7F, 0.8F, spawnSettings, biomeFeatures);
	}
	
	public static Biome shaximiaoLakes(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withShaximiaoLakesPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.agilisaurusShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AGILISAURUS.get(), PrehistoricFaunaConfig.agilisaurusShaximiaoLakesSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.bashanosaurusShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASHANOSAURUS.get(), PrehistoricFaunaConfig.bashanosaurusShaximiaoLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chuandongocoelurusShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHUANDONGOCOELURUS.get(), PrehistoricFaunaConfig.chuandongocoelurusShaximiaoLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.gigantspinosaurusShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GIGANTSPINOSAURUS.get(), PrehistoricFaunaConfig.gigantspinosaurusShaximiaoLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.yandusaurusShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANDUSAURUS.get(), PrehistoricFaunaConfig.yandusaurusShaximiaoLakesSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.yangchuanosaurusShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANGCHUANOSAURUS.get(), PrehistoricFaunaConfig.yangchuanosaurusShaximiaoLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.lepidotesShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LEPIDOTES.get(), PrehistoricFaunaConfig.lepidotesShaximiaoLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusShaximiaoLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.chungkingichthysShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHUNGKINGICHTHYS.get(), PrehistoricFaunaConfig.chungkingichthysShaximiaoLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelShaximiaoLakesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelShaximiaoLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelShaximiaoLakesSpawnWeight, 1, 1));
		return biome(true, 0x20847A, 0x126363, 0x67C8FF, 0x8EE8FF, 0.7F, 0.8F, spawnSettings, biomeFeatures);
	}
	
	public static Biome shaximiaoGalleryForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withShaximiaoGalleryForestPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.agilisaurusShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AGILISAURUS.get(), PrehistoricFaunaConfig.agilisaurusShaximiaoGalleryForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.bashanosaurusShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASHANOSAURUS.get(), PrehistoricFaunaConfig.bashanosaurusShaximiaoGalleryForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chuandongocoelurusShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHUANDONGOCOELURUS.get(), PrehistoricFaunaConfig.chuandongocoelurusShaximiaoGalleryForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.gigantspinosaurusShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GIGANTSPINOSAURUS.get(), PrehistoricFaunaConfig.gigantspinosaurusShaximiaoGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.yandusaurusShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANDUSAURUS.get(), PrehistoricFaunaConfig.yandusaurusShaximiaoGalleryForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.yangchuanosaurusShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANGCHUANOSAURUS.get(), PrehistoricFaunaConfig.yangchuanosaurusShaximiaoGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.lepidotesShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LEPIDOTES.get(), PrehistoricFaunaConfig.lepidotesShaximiaoGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusShaximiaoGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.chungkingichthysShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHUNGKINGICHTHYS.get(), PrehistoricFaunaConfig.chungkingichthysShaximiaoGalleryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelShaximiaoGalleryForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelShaximiaoGalleryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelShaximiaoGalleryForestSpawnWeight, 1, 1));
		return biome(true, 0x20847A, 0x126363, 0x67C8FF, 0x8EE8FF, 0.7F, 0.8F, spawnSettings, biomeFeatures);
	}
	
	public static Biome shaximiaoDryForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withShaximiaoDryForestPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.agilisaurusShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AGILISAURUS.get(), PrehistoricFaunaConfig.agilisaurusShaximiaoDryForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.bashanosaurusShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASHANOSAURUS.get(), PrehistoricFaunaConfig.bashanosaurusShaximiaoDryForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chuandongocoelurusShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHUANDONGOCOELURUS.get(), PrehistoricFaunaConfig.chuandongocoelurusShaximiaoDryForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.gigantspinosaurusShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GIGANTSPINOSAURUS.get(), PrehistoricFaunaConfig.gigantspinosaurusShaximiaoDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.yandusaurusShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANDUSAURUS.get(), PrehistoricFaunaConfig.yandusaurusShaximiaoDryForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.yangchuanosaurusShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANGCHUANOSAURUS.get(), PrehistoricFaunaConfig.yangchuanosaurusShaximiaoDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.lepidotesShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LEPIDOTES.get(), PrehistoricFaunaConfig.lepidotesShaximiaoDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusShaximiaoDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.chungkingichthysShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHUNGKINGICHTHYS.get(), PrehistoricFaunaConfig.chungkingichthysShaximiaoDryForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelShaximiaoDryForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelShaximiaoDryForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelShaximiaoDryForestSpawnWeight, 1, 1));
		return biome(true, 0xA06436, 0x874625, 0x67C8FF, 0x8EE8FF, 1F, 0.3F, spawnSettings, biomeFeatures);
	}
	
	public static Biome shaximiaoMountains(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withShaximiaoMountainsPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.agilisaurusShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AGILISAURUS.get(), PrehistoricFaunaConfig.agilisaurusShaximiaoMountainsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.bashanosaurusShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASHANOSAURUS.get(), PrehistoricFaunaConfig.bashanosaurusShaximiaoMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chuandongocoelurusShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHUANDONGOCOELURUS.get(), PrehistoricFaunaConfig.chuandongocoelurusShaximiaoMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.gigantspinosaurusShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GIGANTSPINOSAURUS.get(), PrehistoricFaunaConfig.gigantspinosaurusShaximiaoMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.yandusaurusShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANDUSAURUS.get(), PrehistoricFaunaConfig.yandusaurusShaximiaoMountainsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.yangchuanosaurusShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANGCHUANOSAURUS.get(), PrehistoricFaunaConfig.yangchuanosaurusShaximiaoMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.lepidotesShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LEPIDOTES.get(), PrehistoricFaunaConfig.lepidotesShaximiaoMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusShaximiaoMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.chungkingichthysShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHUNGKINGICHTHYS.get(), PrehistoricFaunaConfig.chungkingichthysShaximiaoMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelShaximiaoMountainsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelShaximiaoMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelShaximiaoMountainsSpawnWeight, 1, 1));
		return biome(true, 0xA06436, 0x874625, 0x67C8FF, 0x8EE8FF, 1F, 0.3F, spawnSettings, biomeFeatures);
	}
	
	public static Biome shaximiaoDriedLakes(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withShaximiaoAridLakesPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.agilisaurusShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AGILISAURUS.get(), PrehistoricFaunaConfig.agilisaurusShaximiaoAridLakesSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.bashanosaurusShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASHANOSAURUS.get(), PrehistoricFaunaConfig.bashanosaurusShaximiaoAridLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chuandongocoelurusShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHUANDONGOCOELURUS.get(), PrehistoricFaunaConfig.chuandongocoelurusShaximiaoAridLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.gigantspinosaurusShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GIGANTSPINOSAURUS.get(), PrehistoricFaunaConfig.gigantspinosaurusShaximiaoAridLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.yandusaurusShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANDUSAURUS.get(), PrehistoricFaunaConfig.yandusaurusShaximiaoAridLakesSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.yangchuanosaurusShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANGCHUANOSAURUS.get(), PrehistoricFaunaConfig.yangchuanosaurusShaximiaoAridLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.lepidotesShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LEPIDOTES.get(), PrehistoricFaunaConfig.lepidotesShaximiaoAridLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusShaximiaoAridLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.chungkingichthysShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHUNGKINGICHTHYS.get(), PrehistoricFaunaConfig.chungkingichthysShaximiaoAridLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelShaximiaoAridLakesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelShaximiaoAridLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelShaximiaoAridLakesSpawnWeight, 1, 1));
		return biome(true, 0xA06436, 0x874625, 0x67C8FF, 0x8EE8FF, 1F, 0.3F, spawnSettings, biomeFeatures);
	}

}
