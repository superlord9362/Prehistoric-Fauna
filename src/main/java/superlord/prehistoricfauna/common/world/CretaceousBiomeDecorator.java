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
public class CretaceousBiomeDecorator {
	
	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder builder = event.getGeneration();
		String name = event.getName().getPath();
		if (name.equals("djadochta_dunes")) {
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
			PFPlacedFeatures.withDjadochtaRocks(builder);
			if (PrehistoricFaunaConfig.caveSentinelDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelDjadochtaDunesSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelDjadochtaDunesSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.protoceratopsDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOCERATOPS.get(), PrehistoricFaunaConfig.protoceratopsDjadochtaDunesSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.velociraptorDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.VELOCIRAPTOR.get(), PrehistoricFaunaConfig.velociraptorDjadochtaDunesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.citipatiDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CITIPATI.get(), PrehistoricFaunaConfig.citipatiDjadochtaDunesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AEPYORNITHOMIMUS.get(), PrehistoricFaunaConfig.aepyornithomimusDjadochtaDunesSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.telmasaurusDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TELMASAURUS.get(), PrehistoricFaunaConfig.telmasaurusDjadochtaDunesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.pinacosaurusDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PINACOSAURUS.get(), PrehistoricFaunaConfig.pinacosaurusDjadochtaDunesSpawnWeight, 3, 4));
			if (PrehistoricFaunaConfig.plesiohadrosDjadochtaDunesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLESIOHADROS.get(), PrehistoricFaunaConfig.plesiohadrosDjadochtaDunesSpawnWeight, 3, 5));
		}
		if (name.equals("djadochta_arroyo")) {
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
			PFPlacedFeatures.withDjadochtaPlants(builder);
			PFPlacedFeatures.withDjadochtaRocks(builder);
			if (PrehistoricFaunaConfig.caveSentinelDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelDjadochtaArroyoSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelDjadochtaArroyoSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.protoceratopsDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOCERATOPS.get(), PrehistoricFaunaConfig.protoceratopsDjadochtaArroyoSpawnWeight, 2, 5));
			if (PrehistoricFaunaConfig.velociraptorDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.VELOCIRAPTOR.get(), PrehistoricFaunaConfig.velociraptorDjadochtaArroyoSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.citipatiDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CITIPATI.get(), PrehistoricFaunaConfig.citipatiDjadochtaArroyoSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AEPYORNITHOMIMUS.get(), PrehistoricFaunaConfig.aepyornithomimusDjadochtaArroyoSpawnWeight, 3, 5));
			if (PrehistoricFaunaConfig.telmasaurusDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TELMASAURUS.get(), PrehistoricFaunaConfig.telmasaurusDjadochtaArroyoSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.pinacosaurusDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PINACOSAURUS.get(), PrehistoricFaunaConfig.pinacosaurusDjadochtaArroyoSpawnWeight, 4, 5));
			if (PrehistoricFaunaConfig.plesiohadrosDjadochtaArroyoSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLESIOHADROS.get(), PrehistoricFaunaConfig.plesiohadrosDjadochtaArroyoSpawnWeight, 3, 5));
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
			//if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekSwampSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.thescelosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekSwampSpawnWeight, 2, 4));
			//if (PrehistoricFaunaConfig.thoracosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THORACOSAURUS.get(), PrehistoricFaunaConfig.thoracosaurusHellCreekSwampSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.triceratopsHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekSwampSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.tyrannosaurusHellCreekSwampSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekSwampSpawnWeight, 1, 2));
		}
		if (name.equals("hell_creek_liriodendrites_hills")) {
			PFPlacedFeatures.withHellCreekLiriodendritesHillsPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekLiriodendritesHillsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekLiriodendritesHillsSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.acipenserHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekLiriodendritesHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ankylosaurusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekLiriodendritesHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.basilemysHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekLiriodendritesHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.cyclurusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekLiriodendritesHillsSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.dakotaraptorHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekLiriodendritesHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.didelphodonHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekLiriodendritesHillsSpawnWeight, 1, 3));
			//if (PrehistoricFaunaConfig.edmontosaurusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekLiriodendritesHillsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.lepisosteusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekLiriodendritesHillsSpawnWeight, 1, 4));
			if (PrehistoricFaunaConfig.lonchidionHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekLiriodendritesHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.melviusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekLiriodendritesHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.myledaphusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekLiriodendritesHillsSpawnWeight, 1, 2));
			//if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekLiriodendritesHillsSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.thescelosaurusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekLiriodendritesHillsSpawnWeight, 2, 4));
			//if (PrehistoricFaunaConfig.thoracosaurusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THORACOSAURSU.get(), PrehistoricFaunaConfig.thoracosaurusHellCreekLiriodendritesHillsSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.triceratopsHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekLiriodendritesHillsSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.tyrannosaurusHellCreekLiriodendritesHillsSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekLiriodendritesHillsSpawnWeight, 1, 2));
		}
		if (name.equals("hell_creek_clearing")) {
			PFPlacedFeatures.withHellCreekClearingPlants(builder);
			if (PrehistoricFaunaConfig.caveSentinelHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekLiriodendritesHillsSpawnWeight, 1, 1));
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
			//if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekClearingSpawnWeight, 2, 3));
			//if (PrehistoricFaunaConfig.palaeosaniwaHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.thescelosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekClearingSpawnWeight, 2, 4));
			//if (PrehistoricFaunaConfig.thoracosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THORACOSAURUS.get(), PrehistoricFaunaConfig.thoracosaurusHellCreekClearingSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.triceratopsHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekClearingSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.tyrannosaurusHellCreekClearingSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekClearingSpawnWeight, 1, 2));
		}
		if (name.equals("hell_creek_redwoods")) {
			PFPlacedFeatures.withHellCreekRedwoodsPlants(builder);
		}
	}

}
