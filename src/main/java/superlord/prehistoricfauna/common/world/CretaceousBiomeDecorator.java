package superlord.prehistoricfauna.common.world;

import net.minecraft.data.worldgen.placement.VegetationPlacements;
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
public class CretaceousBiomeDecorator {
	
	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder builder = event.getGeneration();
		String name = event.getName().getPath();
		if (name.equals("djadochta_dunes")) {
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
			if (PrehistoricFaunaConfig.caveSentinelDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelDjadochtaDunesSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelDjadochtaDunesSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.protoceratopsDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOCERATOPS.get(), PrehistoricFaunaConfig.protoceratopsDjadochtaDunesSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.velociraptorDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.VELOCIRAPTOR.get(), PrehistoricFaunaConfig.velociraptorDjadochtaDunesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.citipatiDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CITIPATI.get(), PrehistoricFaunaConfig.citipatiDjadochtaDunesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.oviraptorDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.OVIRAPTOR.get(), PrehistoricFaunaConfig.oviraptorDjadochtaDunesSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AEPYORNITHOMIMUS.get(), PrehistoricFaunaConfig.aepyornithomimusDjadochtaDunesSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.telmasaurusDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TELMASAURUS.get(), PrehistoricFaunaConfig.telmasaurusDjadochtaDunesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.pinacosaurusDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PINACOSAURUS.get(), PrehistoricFaunaConfig.pinacosaurusDjadochtaDunesSpawnWeight, 3, 4));
			if (PrehistoricFaunaConfig.plesiohadrosDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLESIOHADROS.get(), PrehistoricFaunaConfig.plesiohadrosDjadochtaDunesSpawnWeight, 3, 5));
			if (PrehistoricFaunaConfig.harenaichthysDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HARENAICHTHYS.get(), PrehistoricFaunaConfig.harenaichthysDjadochtaDunesSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.halszkaraptorDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HALSZKARAPTOR.get(), PrehistoricFaunaConfig.halszkaraptorDjadochtaDunesSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.udanoceratopsDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.UDANOCERATOPS.get(), PrehistoricFaunaConfig.udanoceratopsDjadochtaDunesSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.kolDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KOL.get(), PrehistoricFaunaConfig.kolDjadochtaDunesSpawnWeight, 1, 3));
		}
		if (name.equals("djadochta_alluvial_plains")) {	
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
			PFPlacedFeatures.withDjadochtaRocks(builder);
			PFPlacedFeatures.withDjadochtaFallenLogs(builder);
			if (PrehistoricFaunaConfig.caveSentinelDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelDjadochtaAlluvialPlainsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelDjadochtaAlluvialPlainsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.protoceratopsDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOCERATOPS.get(), PrehistoricFaunaConfig.protoceratopsDjadochtaAlluvialPlainsSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.velociraptorDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.VELOCIRAPTOR.get(), PrehistoricFaunaConfig.velociraptorDjadochtaAlluvialPlainsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.citipatiDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CITIPATI.get(), PrehistoricFaunaConfig.citipatiDjadochtaAlluvialPlainsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AEPYORNITHOMIMUS.get(), PrehistoricFaunaConfig.aepyornithomimusDjadochtaAlluvialPlainsSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.telmasaurusDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TELMASAURUS.get(), PrehistoricFaunaConfig.telmasaurusDjadochtaAlluvialPlainsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.pinacosaurusDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PINACOSAURUS.get(), PrehistoricFaunaConfig.pinacosaurusDjadochtaAlluvialPlainsSpawnWeight, 3, 4));
			if (PrehistoricFaunaConfig.plesiohadrosDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLESIOHADROS.get(), PrehistoricFaunaConfig.plesiohadrosDjadochtaAlluvialPlainsSpawnWeight, 3, 5));
			if (PrehistoricFaunaConfig.oviraptorDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.OVIRAPTOR.get(), PrehistoricFaunaConfig.oviraptorDjadochtaAlluvialPlainsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.harenaichthysDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HARENAICHTHYS.get(), PrehistoricFaunaConfig.harenaichthysDjadochtaAlluvialPlainsSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.halszkaraptorDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HALSZKARAPTOR.get(), PrehistoricFaunaConfig.halszkaraptorDjadochtaAlluvialPlainsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.udanoceratopsDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.UDANOCERATOPS.get(), PrehistoricFaunaConfig.udanoceratopsDjadochtaAlluvialPlainsSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.kolDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KOL.get(), PrehistoricFaunaConfig.kolDjadochtaAlluvialPlainsSpawnWeight, 1, 3));
		}
		if (name.equals("djadochta_arroyo")) {
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
			PFPlacedFeatures.withDjadochtaPlants(builder);
			PFPlacedFeatures.withDjadochtaRocks(builder);
			PFPlacedFeatures.withDjadochtaFallenLogs(builder);
			if (PrehistoricFaunaConfig.caveSentinelDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelDjadochtaArroyoSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelDjadochtaArroyoSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.protoceratopsDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOCERATOPS.get(), PrehistoricFaunaConfig.protoceratopsDjadochtaArroyoSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.velociraptorDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.VELOCIRAPTOR.get(), PrehistoricFaunaConfig.velociraptorDjadochtaArroyoSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.citipatiDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CITIPATI.get(), PrehistoricFaunaConfig.citipatiDjadochtaArroyoSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AEPYORNITHOMIMUS.get(), PrehistoricFaunaConfig.aepyornithomimusDjadochtaArroyoSpawnWeight, 3, 5));
			if (PrehistoricFaunaConfig.telmasaurusDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TELMASAURUS.get(), PrehistoricFaunaConfig.telmasaurusDjadochtaArroyoSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.pinacosaurusDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PINACOSAURUS.get(), PrehistoricFaunaConfig.pinacosaurusDjadochtaArroyoSpawnWeight, 4, 5));
			if (PrehistoricFaunaConfig.plesiohadrosDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLESIOHADROS.get(), PrehistoricFaunaConfig.plesiohadrosDjadochtaArroyoSpawnWeight, 3, 5));
			if (PrehistoricFaunaConfig.oviraptorDjadochtaAlluvialPlainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.OVIRAPTOR.get(), PrehistoricFaunaConfig.oviraptorDjadochtaArroyoSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.harenaichthysDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HARENAICHTHYS.get(), PrehistoricFaunaConfig.harenaichthysDjadochtaArroyoSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.halszkaraptorDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HALSZKARAPTOR.get(), PrehistoricFaunaConfig.halszkaraptorDjadochtaArroyoSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.udanoceratopsDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.UDANOCERATOPS.get(), PrehistoricFaunaConfig.udanoceratopsDjadochtaArroyoSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.kolDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KOL.get(), PrehistoricFaunaConfig.kolDjadochtaArroyoSpawnWeight, 1, 3));
		}
		if (name.equals("hell_creek_swamp")) {
			PFPlacedFeatures.withHellCreekSwampPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekSwampSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekSwampSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.acipenserHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ankylosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.basilemysHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.cyclurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekSwampSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.dakotaraptorHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.didelphodonHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekSwampSpawnWeight, 1, 3));
			//if (PrehistoricFaunaConfig.edmontosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekSwampSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.lepisosteusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekSwampSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.lonchidionHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.melviusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.myledaphusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekSwampSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ornithomimusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekSwampSpawnWeight, 3, 6));
			if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekSwampSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.palaeosaniwaHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekSwampSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.thescelosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekSwampSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.thoracosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THORACOSAURUS.get(), PrehistoricFaunaConfig.thoracosaurusHellCreekSwampSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.triceratopsHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekSwampSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.tyrannosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekSwampSpawnWeight, 1, 2));
		}
		if (name.equals("hell_creek_bluffs")) {
			PFPlacedFeatures.withHellCreekLiriodendritesHillsPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekBluffsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekBluffsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.acipenserHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekBluffsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ankylosaurusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekBluffsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.basilemysHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekBluffsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.cyclurusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekBluffsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.dakotaraptorHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekBluffsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.didelphodonHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekBluffsSpawnWeight, 1, 3));
			//if (PrehistoricFaunaConfig.edmontosaurusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekBluffsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.lepisosteusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekBluffsSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.lonchidionHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekBluffsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.melviusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekBluffsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.myledaphusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekBluffsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ornithomimusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekBluffsSpawnWeight, 3, 6));
			if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekBluffsSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.palaeosaniwaHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekBluffsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.thescelosaurusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekBluffsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.thoracosaurusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THORACOSAURUS.get(), PrehistoricFaunaConfig.thoracosaurusHellCreekBluffsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.triceratopsHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekBluffsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.tyrannosaurusHellCreekBluffsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekBluffsSpawnWeight, 1, 2));
		}
		if (name.equals("hell_creek_clearing")) {
			PFPlacedFeatures.withHellCreekClearingPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekClearingSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekClearingSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.acipenserHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ankylosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekClearingSpawnWeight, 1, 2));
//			if (PrehistoricFaunaConfig.anzuHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekClearingSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.basilemysHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.cyclurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekClearingSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.dakotaraptorHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.didelphodonHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekClearingSpawnWeight, 1, 3));
			//if (PrehistoricFaunaConfig.edmontosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekClearingSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.lepisosteusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekClearingSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.lonchidionHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.melviusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.myledaphusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ornithomimusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekClearingSpawnWeight, 3, 6));
			if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekClearingSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.palaeosaniwaHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.thescelosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekClearingSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.thoracosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THORACOSAURUS.get(), PrehistoricFaunaConfig.thoracosaurusHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.triceratopsHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekClearingSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.tyrannosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekClearingSpawnWeight, 1, 2));
		}
		if (name.equals("hell_creek_redwoods")) {
			PFPlacedFeatures.withHellCreekRedwoodsPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekRedwoodsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekRedwoodsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.acipenserHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekRedwoodsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ankylosaurusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekRedwoodsSpawnWeight, 1, 2));
//			if (PrehistoricFaunaConfig.anzuHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekRedwoodsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.basilemysHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekRedwoodsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.cyclurusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekRedwoodsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.dakotaraptorHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekRedwoodsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.didelphodonHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekRedwoodsSpawnWeight, 1, 3));
			//if (PrehistoricFaunaConfig.edmontosaurusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekRedwoodsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.lepisosteusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekRedwoodsSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.lonchidionHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekRedwoodsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.melviusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekRedwoodsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.myledaphusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekRedwoodsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ornithomimusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekRedwoodsSpawnWeight, 3, 6));
			if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekRedwoodsSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.palaeosaniwaHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekRedwoodsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.thescelosaurusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekRedwoodsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.thoracosaurusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THORACOSAURUS.get(), PrehistoricFaunaConfig.thoracosaurusHellCreekRedwoodsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.triceratopsHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekRedwoodsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.tyrannosaurusHellCreekRedwoodsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekRedwoodsSpawnWeight, 1, 2));
		}
		if (name.equals("hell_creek_river")) {
			PFPlacedFeatures.withHellCreekRiverPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekRiverSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekRiverSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.acipenserHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekRiverSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ankylosaurusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekRiverSpawnWeight, 1, 2));
//			if (PrehistoricFaunaConfig.anzuHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekRiverSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.basilemysHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekRiverSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.cyclurusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekRiverSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.dakotaraptorHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekRiverSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.didelphodonHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekRiverSpawnWeight, 1, 3));
			//if (PrehistoricFaunaConfig.edmontosaurusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekRiverSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.lepisosteusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekRiverSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.lonchidionHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekRiverSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.melviusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekRiverSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.myledaphusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekRiverSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ornithomimusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekRiverSpawnWeight, 3, 6));
			if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekRiverSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.palaeosaniwaHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekRiverSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.thescelosaurusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekRiverSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.thoracosaurusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THORACOSAURUS.get(), PrehistoricFaunaConfig.thoracosaurusHellCreekRiverSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.triceratopsHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekRiverSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.tyrannosaurusHellCreekRiverSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekRiverSpawnWeight, 1, 2));
		}
		if (name.equals("hell_creek_hardwood_forest")) {
			PFPlacedFeatures.withHellCreekHardwoodForestPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekHardwoodForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekHardwoodForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.acipenserHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekHardwoodForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ankylosaurusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekHardwoodForestSpawnWeight, 1, 2));
//			if (PrehistoricFaunaConfig.anzuHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekHardwoodForestSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.basilemysHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekHardwoodForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.cyclurusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekHardwoodForestSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.dakotaraptorHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekHardwoodForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.didelphodonHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekHardwoodForestSpawnWeight, 1, 3));
			//if (PrehistoricFaunaConfig.edmontosaurusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekHardwoodForestSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.lepisosteusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekHardwoodForestSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.lonchidionHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekHardwoodForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.melviusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekHardwoodForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.myledaphusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekHardwoodForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ornithomimusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekHardwoodForestSpawnWeight, 3, 6));
			if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekHardwoodForestSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.palaeosaniwaHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekHardwoodForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.thescelosaurusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekHardwoodForestSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.thoracosaurusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THORACOSAURUS.get(), PrehistoricFaunaConfig.thoracosaurusHellCreekHardwoodForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.triceratopsHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekHardwoodForestSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.tyrannosaurusHellCreekHardwoodForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekHardwoodForestSpawnWeight, 1, 2));
		}
		if (name.equals("yixian_forest")) {
			PFPlacedFeatures.withYixianForestPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelYixianForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelYixianForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.yutyrannusYixianForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.psittacosaurusYixianForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianForestSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.sinosauropteryxYixianForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianForestSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.incisivosaurusYixianForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianForestSpawnWeight, 1, 4));
		}
		if (name.equals("yixian_snowy_forest")) {
			PFPlacedFeatures.withYixianSnowyForestPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelYixianSnowyForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianSnowyForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelYixianSnowyForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianSnowyForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.yutyrannusYixianSnowyForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianSnowyForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.psittacosaurusYixianSnowyForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianSnowyForestSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.sinosauropteryxYixianSnowyForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianSnowyForestSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.incisivosaurusYixianSnowyForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianSnowyForestSpawnWeight, 1, 4));

		}
		if (name.equals("yixian_regrowth")) {
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
			PFPlacedFeatures.withYixianRegrowthPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelYixianRegrowthSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianRegrowthSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelYixianRegrowthSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianRegrowthSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.yutyrannusYixianRegrowthSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianRegrowthSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.psittacosaurusYixianRegrowthSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianRegrowthSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.sinosauropteryxYixianRegrowthSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianRegrowthSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.incisivosaurusYixianRegrowthSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianRegrowthSpawnWeight, 1, 4));

		}
		if (name.equals("yixian_snowy_mountains")) {
			if (PrehistoricFaunaConfig.caveSentinelYixianSnowyMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianSnowyMountainsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelYixianSnowyMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianSnowyMountainsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.yutyrannusYixianSnowyMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianSnowyMountainsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.psittacosaurusYixianSnowyMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianSnowyMountainsSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.sinosauropteryxYixianSnowyMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianSnowyMountainsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.incisivosaurusYixianSnowyMountainsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianSnowyMountainsSpawnWeight, 1, 4));

		}
		if (name.equals("yixian_volcano")) {
			PFPlacedFeatures.withYixianRegrowthPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelYixianVolcanoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianVolcanoSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelYixianVolcanoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianVolcanoSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.yutyrannusYixianVolcanoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianVolcanoSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.psittacosaurusYixianVolcanoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianVolcanoSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.sinosauropteryxYixianVolcanoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianVolcanoSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.incisivosaurusYixianVolcanoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianVolcanoSpawnWeight, 1, 4));

		}
	}

}
