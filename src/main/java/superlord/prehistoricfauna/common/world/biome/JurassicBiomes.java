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
		return biome(true, 0x215FA4, 0x376682, 0x94addf, 0xde9757, 0x53711f, 1.2F, 0.1F, spawnSettings, biomeFeatures);
	}
	
	public static Biome kayentaButtes(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.PACKED_MUD_DISK);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withKayentaButtesVegetation(biomeFeatures);
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
		return biome(false, 0x215FA4, 0x376682, 0x94addf, 0xde9757, 0x53711f, 1.2F, 0F, spawnSettings, biomeFeatures);
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
		if (PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dermestidBeetleMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleMorrisonSavannahSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight, 1, 1));
		return biome(false, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome morrisonHills(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withMorrisonHillsVegetation(biomeFeatures);
		if (PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dermestidBeetleMorrisonHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleMorrisonHillsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight, 1, 1));
		return biome(false, 0xab986d, 0x9c8c67, 0x7CACFF, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}

}
