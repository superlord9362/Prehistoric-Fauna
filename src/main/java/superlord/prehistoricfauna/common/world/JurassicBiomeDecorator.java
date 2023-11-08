package superlord.prehistoricfauna.common.world;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFPlacedFeatures;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class JurassicBiomeDecorator {

	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder builder = event.getGeneration();
		String name = event.getName().getPath();
		if (name.equals("morrison_savanna")) {
			PFPlacedFeatures.withMorrisonSavannaVegetation(builder);
			if (PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight, 1, 1));
		}
		if (name.equals("morrison_hills")) {
			PFPlacedFeatures.withMorrisonSavannaVegetation(builder);
			PFPlacedFeatures.withMorrisonHillsVegetation(builder);
			if (PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.STEGOSAURUS.get(), PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DRYOSAURUS.get(), PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CERATOSAURUS.get(), PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ALLOSAURUS.get(), PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HESPERORNITHOIDES.get(), PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EILENODON.get(), PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CAMARASAURUS.get(), PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight, 1, 1));
		}
		if (name.equals("kayenta_dry_forest")) {
			PFPlacedFeatures.withKayentaDryForestVegetation(builder);
			if (PrehistoricFaunaConfig.calsoyasuchusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CALSOYASUCHUS.get(), PrehistoricFaunaConfig.calsoyasuchusKayentaDryForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.dilophosaurusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILOPHOSAURUS.get(), PrehistoricFaunaConfig.dilophosaurusKayentaDryForestSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.sarahsaurusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SARAHSAURUS.get(), PrehistoricFaunaConfig.sarahsaurusKayentaDryForestSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.scelidosaurusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCELIDOSAURUS.get(), PrehistoricFaunaConfig.scelidosaurusKayentaDryForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ceratodusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaDryForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.potamoceratodusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaDryForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.caveSentinelKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaDryForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaDryForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.scutellosaurusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCUTELLOSAURUS.get(), PrehistoricFaunaConfig.scutellosaurusKayentaDryForestSpawnWeight, 2, 4));
			if (PrehistoricFaunaConfig.megapnosaurusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MEGAPNOSAURUS.get(), PrehistoricFaunaConfig.megapnosaurusKayentaDryForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.kayentatheriumKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTATHERIUM.get(), PrehistoricFaunaConfig.kayentatheriumKayentaDryForestSpawnWeight, 1, 2));
		}
		if (name.equals("kayenta_buttes")) {
			PFPlacedFeatures.withKayentaButtesVegetation(builder);
			if (PrehistoricFaunaConfig.calsoyasuchusKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CALSOYASUCHUS.get(), PrehistoricFaunaConfig.calsoyasuchusKayentaButtesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.dilophosaurusKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILOPHOSAURUS.get(), PrehistoricFaunaConfig.dilophosaurusKayentaButtesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.sarahsaurusKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SARAHSAURUS.get(), PrehistoricFaunaConfig.sarahsaurusKayentaButtesSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.scelidosaurusKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCELIDOSAURUS.get(), PrehistoricFaunaConfig.scelidosaurusKayentaButtesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ceratodusKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaButtesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.potamoceratodusKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaButtesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.caveSentinelKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaButtesSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaButtesSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.scutellosaurusKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCUTELLOSAURUS.get(), PrehistoricFaunaConfig.scutellosaurusKayentaButtesSpawnWeight, 2, 3));
			if (PrehistoricFaunaConfig.megapnosaurusKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MEGAPNOSAURUS.get(), PrehistoricFaunaConfig.megapnosaurusKayentaButtesSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.kayentatheriumKayentaButtesSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTATHERIUM.get(), PrehistoricFaunaConfig.kayentatheriumKayentaButtesSpawnWeight, 1, 2));
		}
		if (name.equals("kayenta_desert")) {
			builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
			PFPlacedFeatures.withKayentaDesertRocks(builder);
			builder.addFeature(Decoration.VEGETAL_DECORATION, PFPlacedFeatures.ZAMITES.getHolder().orElseThrow());
			if (PrehistoricFaunaConfig.calsoyasuchusKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CALSOYASUCHUS.get(), PrehistoricFaunaConfig.calsoyasuchusKayentaDesertSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.dilophosaurusKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILOPHOSAURUS.get(), PrehistoricFaunaConfig.dilophosaurusKayentaDesertSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.sarahsaurusKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SARAHSAURUS.get(), PrehistoricFaunaConfig.sarahsaurusKayentaDesertSpawnWeight, 1, 3));
			if (PrehistoricFaunaConfig.scelidosaurusKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCELIDOSAURUS.get(), PrehistoricFaunaConfig.scelidosaurusKayentaDesertSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.ceratodusKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaDesertSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.potamoceratodusKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaDesertSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.caveSentinelKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaDesertSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaDesertSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.scutellosaurusKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SCUTELLOSAURUS.get(), PrehistoricFaunaConfig.scutellosaurusKayentaDesertSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.megapnosaurusKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MEGAPNOSAURUS.get(), PrehistoricFaunaConfig.megapnosaurusKayentaDesertSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.kayentatheriumKayentaDesertSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KAYENTATHERIUM.get(), PrehistoricFaunaConfig.kayentatheriumKayentaDesertSpawnWeight, 1, 2));
		}
		if (name.equals("kayenta_river")) {
			builder.addFeature(Decoration.VEGETAL_DECORATION, PFPlacedFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
			if (PrehistoricFaunaConfig.ceratodusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CERATODUS.get(), PrehistoricFaunaConfig.ceratodusKayentaDryForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.potamoceratodusKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.POTAMOCERATODUS.get(), PrehistoricFaunaConfig.potamoceratodusKayentaDryForestSpawnWeight, 1, 2));
			if (PrehistoricFaunaConfig.caveSentinelKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelKayentaDryForestSpawnWeight, 1, 1));
			if (PrehistoricFaunaConfig.landSentinelKayentaDryForestSpawnWeight != 0) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelKayentaDryForestSpawnWeight, 1, 1));	
		}
	}

}
