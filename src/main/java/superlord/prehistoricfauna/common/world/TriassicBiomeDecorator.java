package superlord.prehistoricfauna.common.world;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFPlacedFeatures;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class TriassicBiomeDecorator {
	
	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder builder = event.getGeneration();
		String name = event.getName().getPath();
		if (name.equals("chinle_flats")) {
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
			PFPlacedFeatures.withChinleFlatsPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelChinleFlatsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelChinleFlatsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.trilophosaurusChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRILOPHOSAURUS.get(), PrehistoricFaunaConfig.trilophosaurusChinleFlatsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.desmatosuchusChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DESMATOSUCHUS.get(), PrehistoricFaunaConfig.desmatosuchusChinleFlatsSpawnWeight, 2, 4));
	        if (PrehistoricFaunaConfig.chinleaChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHINLEA.get(), PrehistoricFaunaConfig.chinleaChinleFlatsSpawnWeight, 1, 2));
	        if (PrehistoricFaunaConfig.arganodusChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.ARGANODUS.get(), PrehistoricFaunaConfig.arganodusChinleFlatsSpawnWeight, 1, 2));
	        if (PrehistoricFaunaConfig.saurichthysChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.SAURICHTHYS.get(), PrehistoricFaunaConfig.saurichthysChinleFlatsSpawnWeight, 1, 2));
	        if (PrehistoricFaunaConfig.mooreodontusChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MOOREODONTUS.get(), PrehistoricFaunaConfig.mooreodontusChinleFlatsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.postosuchusChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POSTOSUCHUS.get(), PrehistoricFaunaConfig.postosuchusChinleFlatsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.placeriasChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLACERIAS.get(), PrehistoricFaunaConfig.placeriasChinleFlatsSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.coelophysisChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.COELOPHYSIS.get(), PrehistoricFaunaConfig.coelophysisChinleFlatsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.poposaurusChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POPOSAURUS.get(), PrehistoricFaunaConfig.poposaurusChinleFlatsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.typothoraxChinleFlatsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYPOTHORAX.get(), PrehistoricFaunaConfig.typothoraxChinleFlatsSpawnWeight, 1, 4));
		}
		if (name.equals("chinle_swamp")) {
			PFPlacedFeatures.withChinleSwampPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelChinleSwampSpawnWeight, 1, 1));
	        if (PrehistoricFaunaConfig.landSentinelChinleSwampSpawnWeight != 0)event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelChinleSwampSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.desmatosuchusChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DESMATOSUCHUS.get(), PrehistoricFaunaConfig.desmatosuchusChinleSwampSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.trilophosaurusChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRILOPHOSAURUS.get(), PrehistoricFaunaConfig.trilophosaurusChinleSwampSpawnWeight, 1, 3));
	        if (PrehistoricFaunaConfig.chinleaChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHINLEA.get(), PrehistoricFaunaConfig.chinleaChinleSwampSpawnWeight, 1, 2));
	        if (PrehistoricFaunaConfig.arganodusChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.ARGANODUS.get(), PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight, 1, 2));
	        if (PrehistoricFaunaConfig.mooreodontusChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MOOREODONTUS.get(), PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight, 1, 2));
	        if (PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.SAURICHTHYS.get(), PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.postosuchusChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POSTOSUCHUS.get(), PrehistoricFaunaConfig.postosuchusChinleSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.placeriasChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLACERIAS.get(), PrehistoricFaunaConfig.placeriasChinleSwampSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.coelophysisChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.COELOPHYSIS.get(), PrehistoricFaunaConfig.coelophysisChinleSwampSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.poposaurusChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POPOSAURUS.get(), PrehistoricFaunaConfig.poposaurusChinleSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.typothoraxChinleSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYPOTHORAX.get(), PrehistoricFaunaConfig.typothoraxChinleSwampSpawnWeight, 1, 4));
		}
		if (name.equals("chinle_wooded_mountains")) {
			PFPlacedFeatures.withChinleWoodedMountainsPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelChinleWoodedMountainsSpawnWeight, 1, 1));
	        if (PrehistoricFaunaConfig.landSentinelChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelChinleWoodedMountainsSpawnWeight, 1, 1));
	        if (PrehistoricFaunaConfig.desmatosuchusChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DESMATOSUCHUS.get(), PrehistoricFaunaConfig.desmatosuchusChinleWoodedMountainsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.trilophosaurusChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRILOPHOSAURUS.get(), PrehistoricFaunaConfig.trilophosaurusChinleWoodedMountainsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.postosuchusChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POSTOSUCHUS.get(), PrehistoricFaunaConfig.postosuchusChinleWoodedMountainsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.chinleaChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CHINLEA.get(), PrehistoricFaunaConfig.chinleaChinleWoodedMountainsSpawnWeight, 1, 2));
	        if (PrehistoricFaunaConfig.arganodusChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.ARGANODUS.get(), PrehistoricFaunaConfig.arganodusChinleWoodedMountainsSpawnWeight, 1, 2));
	        if (PrehistoricFaunaConfig.mooreodontusChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.MOOREODONTUS.get(), PrehistoricFaunaConfig.mooreodontusChinleWoodedMountainsSpawnWeight, 1, 2));
	        if (PrehistoricFaunaConfig.saurichthysChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.SAURICHTHYS.get(), PrehistoricFaunaConfig.saurichthysChinleWoodedMountainsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.placeriasChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLACERIAS.get(), PrehistoricFaunaConfig.placeriasChinleWoodedMountainsSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.coelophysisChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.COELOPHYSIS.get(), PrehistoricFaunaConfig.coelophysisChinleWoodedMountainsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.poposaurusChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.POPOSAURUS.get(), PrehistoricFaunaConfig.poposaurusChinleWoodedMountainsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.typothoraxChinleWoodedMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYPOTHORAX.get(), PrehistoricFaunaConfig.typothoraxChinleWoodedMountainsSpawnWeight, 1, 4));
		}
		if (name.equals("ischigualasto_forest")) {
			PFPlacedFeatures.withIschigualastoVegetation(builder);
			if (PrehistoricFaunaConfig.exaeretodonIschigualastoForestSpawnWeight != 0)event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EXAERETODON.get(), PrehistoricFaunaConfig.exaeretodonIschigualastoForestSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.chromogisaurusIschigualastoForestSpawnWeight != 0)event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHROMOGISAURUS.get(), PrehistoricFaunaConfig.chromogisaurusIschigualastoForestSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.herrerasaurusIschigualastoForestSpawnWeight != 0)event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HERRERASAURUS.get(), PrehistoricFaunaConfig.herrerasaurusIschigualastoForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.hyperodapedonIschigualastoForestSpawnWeight != 0)event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HYPERODAPEDON.get(), PrehistoricFaunaConfig.hyperodapedonIschigualastoForestSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.sillosuchusIschigualastoForestSpawnWeight != 0)event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SILLOSUCHUS.get(), PrehistoricFaunaConfig.sillosuchusIschigualastoForestSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.saurosuchusIschigualastoForestSpawnWeight != 0)event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SAUROSUCHUS.get(), PrehistoricFaunaConfig.saurosuchusIschigualastoForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ischigualastiaIschigualastoForestSpawnWeight != 0)event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ISCHIGUALASTIA.get(), PrehistoricFaunaConfig.ischigualastiaIschigualastoForestSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.caveSentinelIschigualastoForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelIschigualastoForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.ceratodusIschigualastoForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusIschigualastoForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.landSentinelIschigualastoForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelIschigualastoForestSpawnWeight, 1, 1));
		}
		if (name.equals("ischigualasto_hills")) {
			PFPlacedFeatures.withIschigualastoVegetation(builder);
			if (PrehistoricFaunaConfig.exaeretodonIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EXAERETODON.get(), PrehistoricFaunaConfig.exaeretodonIschigualastoHillsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.chromogisaurusIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHROMOGISAURUS.get(), PrehistoricFaunaConfig.chromogisaurusIschigualastoHillsSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.herrerasaurusIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HERRERASAURUS.get(), PrehistoricFaunaConfig.herrerasaurusIschigualastoHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.hyperodapedonIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HYPERODAPEDON.get(), PrehistoricFaunaConfig.hyperodapedonIschigualastoHillsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.sillosuchusIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SILLOSUCHUS.get(), PrehistoricFaunaConfig.sillosuchusIschigualastoHillsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.saurosuchusIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SAUROSUCHUS.get(), PrehistoricFaunaConfig.saurosuchusIschigualastoHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ischigualastiaIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ISCHIGUALASTIA.get(), PrehistoricFaunaConfig.ischigualastiaIschigualastoHillsSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.ceratodusIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusIschigualastoHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.caveSentinelIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelIschigualastoHillsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelIschigualastoHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelIschigualastoHillsSpawnWeight, 1, 1));
		}
		if (name.equals("ischigualasto_clearing")) {
			PFPlacedFeatures.withSparseIschigualastoVegetation(builder);
			if (PrehistoricFaunaConfig.exaeretodonIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EXAERETODON.get(), PrehistoricFaunaConfig.exaeretodonIschigualastoClearingSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.chromogisaurusIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHROMOGISAURUS.get(), PrehistoricFaunaConfig.chromogisaurusIschigualastoClearingSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.herrerasaurusIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HERRERASAURUS.get(), PrehistoricFaunaConfig.herrerasaurusIschigualastoClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.hyperodapedonIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HYPERODAPEDON.get(), PrehistoricFaunaConfig.hyperodapedonIschigualastoClearingSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.sillosuchusIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SILLOSUCHUS.get(), PrehistoricFaunaConfig.sillosuchusIschigualastoClearingSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.saurosuchusIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SAUROSUCHUS.get(), PrehistoricFaunaConfig.saurosuchusIschigualastoClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ischigualastiaIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ISCHIGUALASTIA.get(), PrehistoricFaunaConfig.ischigualastiaIschigualastoClearingSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.caveSentinelIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelIschigualastoClearingSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.ceratodusIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusIschigualastoClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.landSentinelIschigualastoClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelIschigualastoClearingSpawnWeight, 1, 1));
		}
	}

}
