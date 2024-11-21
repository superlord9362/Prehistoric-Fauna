package superlord.prehistoricfauna.common.world.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFPlacedFeatures;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class TriassicBiomes {
	
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
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}
	
	public static Biome chinleFlats(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS);
		PFPlacedFeatures.withChinleFlatsPlants(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.SILT_DISK);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.PACKED_MUD_DISK);
		if (PrehistoricFaunaConfig.caveSentinelChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelChinleFlatsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelChinleFlatsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.trilophosaurusChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRILOPHOSAURUS.get(), PrehistoricFaunaConfig.trilophosaurusChinleFlatsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.desmatosuchusChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DESMATOSUCHUS.get(), PrehistoricFaunaConfig.desmatosuchusChinleFlatsSpawnWeight, 2, 4));
        if (PrehistoricFaunaConfig.chinleaChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHINLEA.get(), PrehistoricFaunaConfig.chinleaChinleFlatsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.arganodusChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.ARGANODUS.get(), PrehistoricFaunaConfig.arganodusChinleFlatsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.saurichthysChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.SAURICHTHYS.get(), PrehistoricFaunaConfig.saurichthysChinleFlatsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.mooreodontusChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MOOREODONTUS.get(), PrehistoricFaunaConfig.mooreodontusChinleFlatsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.lonchidionChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionChinleFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.postosuchusChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POSTOSUCHUS.get(), PrehistoricFaunaConfig.postosuchusChinleFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.placeriasChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLACERIAS.get(), PrehistoricFaunaConfig.placeriasChinleFlatsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.coelophysisChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.COELOPHYSIS.get(), PrehistoricFaunaConfig.coelophysisChinleFlatsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.poposaurusChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POPOSAURUS.get(), PrehistoricFaunaConfig.poposaurusChinleFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.typothoraxChinleFlatsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYPOTHORAX.get(), PrehistoricFaunaConfig.typothoraxChinleFlatsSpawnWeight, 1, 4));
		return biome(true, 7372597, 5267523, 15922646, 13622197, 7372597, 0.9F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome chinleRiver(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS);
		PFPlacedFeatures.withChinleFlatsPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.caveSentinelChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelChinleRiverSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.landSentinelChinleRiverSpawnWeight != 0)spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelChinleRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.desmatosuchusChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DESMATOSUCHUS.get(), PrehistoricFaunaConfig.desmatosuchusChinleRiverSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.trilophosaurusChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRILOPHOSAURUS.get(), PrehistoricFaunaConfig.trilophosaurusChinleRiverSpawnWeight, 1, 3));
        if (PrehistoricFaunaConfig.chinleaChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHINLEA.get(), PrehistoricFaunaConfig.chinleaChinleRiverSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.arganodusChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.ARGANODUS.get(), PrehistoricFaunaConfig.saurichthysChinleRiverSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.mooreodontusChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MOOREODONTUS.get(), PrehistoricFaunaConfig.saurichthysChinleRiverSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.saurichthysChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.SAURICHTHYS.get(), PrehistoricFaunaConfig.saurichthysChinleRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.postosuchusChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POSTOSUCHUS.get(), PrehistoricFaunaConfig.postosuchusChinleRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.placeriasChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLACERIAS.get(), PrehistoricFaunaConfig.placeriasChinleRiverSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.coelophysisChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.COELOPHYSIS.get(), PrehistoricFaunaConfig.coelophysisChinleRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.poposaurusChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POPOSAURUS.get(), PrehistoricFaunaConfig.poposaurusChinleRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.typothoraxChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYPOTHORAX.get(), PrehistoricFaunaConfig.typothoraxChinleRiverSpawnWeight, 1, 4));
        if (PrehistoricFaunaConfig.lonchidionChinleRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionChinleRiverSpawnWeight, 1, 2));
        return biome(true, 7372597, 5267523, 15922646, 13622197, 7372597, 0.9F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome chinleSwamp(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withChinleSwampPlants(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.SILT_DISK);
		if (PrehistoricFaunaConfig.caveSentinelChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelChinleSwampSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.landSentinelChinleSwampSpawnWeight != 0)spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelChinleSwampSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.desmatosuchusChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DESMATOSUCHUS.get(), PrehistoricFaunaConfig.desmatosuchusChinleSwampSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.trilophosaurusChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRILOPHOSAURUS.get(), PrehistoricFaunaConfig.trilophosaurusChinleSwampSpawnWeight, 1, 3));
        if (PrehistoricFaunaConfig.chinleaChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHINLEA.get(), PrehistoricFaunaConfig.chinleaChinleSwampSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.arganodusChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.ARGANODUS.get(), PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.mooreodontusChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MOOREODONTUS.get(), PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.SAURICHTHYS.get(), PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.postosuchusChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POSTOSUCHUS.get(), PrehistoricFaunaConfig.postosuchusChinleSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.placeriasChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLACERIAS.get(), PrehistoricFaunaConfig.placeriasChinleSwampSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.coelophysisChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.COELOPHYSIS.get(), PrehistoricFaunaConfig.coelophysisChinleSwampSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.poposaurusChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POPOSAURUS.get(), PrehistoricFaunaConfig.poposaurusChinleSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.typothoraxChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYPOTHORAX.get(), PrehistoricFaunaConfig.typothoraxChinleSwampSpawnWeight, 1, 4));
        if (PrehistoricFaunaConfig.lonchidionChinleSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionChinleSwampSpawnWeight, 1, 2));
		return biome(true, 7372597, 5267523, 15922646, 13622197, 7372597, 0.9F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome chinleWoodedMountains(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withChinleWoodedMountainsPlants(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.SILT_DISK);
		if (PrehistoricFaunaConfig.caveSentinelChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelChinleWoodedMountainsSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.landSentinelChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelChinleWoodedMountainsSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.desmatosuchusChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DESMATOSUCHUS.get(), PrehistoricFaunaConfig.desmatosuchusChinleWoodedMountainsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.trilophosaurusChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRILOPHOSAURUS.get(), PrehistoricFaunaConfig.trilophosaurusChinleWoodedMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.postosuchusChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POSTOSUCHUS.get(), PrehistoricFaunaConfig.postosuchusChinleWoodedMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.chinleaChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHINLEA.get(), PrehistoricFaunaConfig.chinleaChinleWoodedMountainsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.arganodusChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.ARGANODUS.get(), PrehistoricFaunaConfig.arganodusChinleWoodedMountainsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.mooreodontusChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MOOREODONTUS.get(), PrehistoricFaunaConfig.mooreodontusChinleWoodedMountainsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.saurichthysChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.SAURICHTHYS.get(), PrehistoricFaunaConfig.saurichthysChinleWoodedMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.placeriasChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLACERIAS.get(), PrehistoricFaunaConfig.placeriasChinleWoodedMountainsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.coelophysisChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.COELOPHYSIS.get(), PrehistoricFaunaConfig.coelophysisChinleWoodedMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.poposaurusChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POPOSAURUS.get(), PrehistoricFaunaConfig.poposaurusChinleWoodedMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.typothoraxChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYPOTHORAX.get(), PrehistoricFaunaConfig.typothoraxChinleWoodedMountainsSpawnWeight, 1, 4));
        if (PrehistoricFaunaConfig.lonchidionChinleWoodedMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionChinleWoodedMountainsSpawnWeight, 1, 2));
		return biome(true, 7372597, 5267523, 15922646, 13622197, 7372597, 0.9F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome ischigualastoClearing(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withSparseIschigualastoVegetation(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.SILT_DISK);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.PACKED_MUD_DISK);
		if (PrehistoricFaunaConfig.exaeretodonIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EXAERETODON.get(), PrehistoricFaunaConfig.exaeretodonIschigualastoClearingSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chromogisaurusIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHROMOGISAURUS.get(), PrehistoricFaunaConfig.chromogisaurusIschigualastoClearingSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.herrerasaurusIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HERRERASAURUS.get(), PrehistoricFaunaConfig.herrerasaurusIschigualastoClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.hyperodapedonIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HYPERODAPEDON.get(), PrehistoricFaunaConfig.hyperodapedonIschigualastoClearingSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sillosuchusIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SILLOSUCHUS.get(), PrehistoricFaunaConfig.sillosuchusIschigualastoClearingSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.saurosuchusIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SAUROSUCHUS.get(), PrehistoricFaunaConfig.saurosuchusIschigualastoClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ischigualastiaIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ISCHIGUALASTIA.get(), PrehistoricFaunaConfig.ischigualastiaIschigualastoClearingSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.caveSentinelIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelIschigualastoClearingSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.ceratodusIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusIschigualastoClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.landSentinelIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelIschigualastoClearingSpawnWeight, 1, 1));
		return biome(true, 4417619, 4219470, 10464974, 12638463, 5468447, 0.75F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome ischigualastoForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withIschigualastoVegetation(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.SILT_DISK);
		if (PrehistoricFaunaConfig.exaeretodonIschigualastoForestSpawnWeight != 0)spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EXAERETODON.get(), PrehistoricFaunaConfig.exaeretodonIschigualastoForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chromogisaurusIschigualastoForestSpawnWeight != 0)spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHROMOGISAURUS.get(), PrehistoricFaunaConfig.chromogisaurusIschigualastoForestSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.herrerasaurusIschigualastoForestSpawnWeight != 0)spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HERRERASAURUS.get(), PrehistoricFaunaConfig.herrerasaurusIschigualastoForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.hyperodapedonIschigualastoForestSpawnWeight != 0)spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HYPERODAPEDON.get(), PrehistoricFaunaConfig.hyperodapedonIschigualastoForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sillosuchusIschigualastoForestSpawnWeight != 0)spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SILLOSUCHUS.get(), PrehistoricFaunaConfig.sillosuchusIschigualastoForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.saurosuchusIschigualastoForestSpawnWeight != 0)spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SAUROSUCHUS.get(), PrehistoricFaunaConfig.saurosuchusIschigualastoForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ischigualastiaIschigualastoForestSpawnWeight != 0)spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ISCHIGUALASTIA.get(), PrehistoricFaunaConfig.ischigualastiaIschigualastoForestSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.caveSentinelIschigualastoForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelIschigualastoForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.ceratodusIschigualastoForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusIschigualastoForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.landSentinelIschigualastoForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelIschigualastoForestSpawnWeight, 1, 1));
		return biome(true, 4417619, 4219470, 10464974, 12638463, 5468447, 0.75F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome ischigualastoHills(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withIschigualastoVegetation(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.SILT_DISK);
		if (PrehistoricFaunaConfig.exaeretodonIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EXAERETODON.get(), PrehistoricFaunaConfig.exaeretodonIschigualastoHillsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chromogisaurusIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHROMOGISAURUS.get(), PrehistoricFaunaConfig.chromogisaurusIschigualastoHillsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.herrerasaurusIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HERRERASAURUS.get(), PrehistoricFaunaConfig.herrerasaurusIschigualastoHillsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.hyperodapedonIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HYPERODAPEDON.get(), PrehistoricFaunaConfig.hyperodapedonIschigualastoHillsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sillosuchusIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SILLOSUCHUS.get(), PrehistoricFaunaConfig.sillosuchusIschigualastoHillsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.saurosuchusIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SAUROSUCHUS.get(), PrehistoricFaunaConfig.saurosuchusIschigualastoHillsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ischigualastiaIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ISCHIGUALASTIA.get(), PrehistoricFaunaConfig.ischigualastiaIschigualastoHillsSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.ceratodusIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusIschigualastoHillsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelIschigualastoHillsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelIschigualastoHillsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelIschigualastoHillsSpawnWeight, 1, 1));
		return biome(true, 4417619, 4219470, 10464974, 12638463, 5468447, 0.75F, 0.9F, spawnSettings, biomeFeatures);
	}
	
	public static Biome ischigualastoRiver(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withIschigualastoVegetation(biomeFeatures);
		if (PrehistoricFaunaConfig.exaeretodonIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EXAERETODON.get(), PrehistoricFaunaConfig.exaeretodonIschigualastoRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chromogisaurusIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHROMOGISAURUS.get(), PrehistoricFaunaConfig.chromogisaurusIschigualastoRiverSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.herrerasaurusIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HERRERASAURUS.get(), PrehistoricFaunaConfig.herrerasaurusIschigualastoRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.hyperodapedonIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HYPERODAPEDON.get(), PrehistoricFaunaConfig.hyperodapedonIschigualastoRiverSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sillosuchusIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SILLOSUCHUS.get(), PrehistoricFaunaConfig.sillosuchusIschigualastoRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.saurosuchusIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SAUROSUCHUS.get(), PrehistoricFaunaConfig.saurosuchusIschigualastoRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ischigualastiaIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ISCHIGUALASTIA.get(), PrehistoricFaunaConfig.ischigualastiaIschigualastoRiverSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.caveSentinelIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelIschigualastoRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.ceratodusIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusIschigualastoRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.landSentinelIschigualastoRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelIschigualastoRiverSpawnWeight, 1, 1));
		return biome(true, 4417619, 4219470, 10464974, 12638463, 5468447, 0.75F, 0.9F, spawnSettings, biomeFeatures);
	}

}
