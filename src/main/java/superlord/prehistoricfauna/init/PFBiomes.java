package superlord.prehistoricfauna.init;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.biome.CretaceousBiomes;
import superlord.prehistoricfauna.common.world.biome.JurassicBiomes;
import superlord.prehistoricfauna.common.world.biome.TriassicBiomes;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class PFBiomes {

	public static final ResourceKey<Biome> CHINLE_FLATS = register("chinle_flats");
	public static final ResourceKey<Biome> CHINLE_RIVER = register("chinle_river");
	public static final ResourceKey<Biome> CHINLE_SWAMP = register("chinle_swamp");
	public static final ResourceKey<Biome> CHINLE_WOODED_MOUNTAINS = register("chinle_wooded_mountains");
	public static final ResourceKey<Biome> ISCHIGUALASTO_RIVER = register("ischigualasto_river");
	public static final ResourceKey<Biome> ISCHIGUALASTO_CLEARING = register("ischigualasto_clearing");
	public static final ResourceKey<Biome> ISCHIGUALASTO_FOREST = register("ischigualasto_forest");
	public static final ResourceKey<Biome> ISCHIGUALASTO_HILLS = register("ischigualasto_hills");

	public static final ResourceKey<Biome> KAYENTA_DRY_FOREST = register("kayenta_dry_forest");
	public static final ResourceKey<Biome> KAYENTA_BUTTES = register("kayenta_buttes");
	public static final ResourceKey<Biome> KAYENTA_DESERT = register("kayenta_desert");
	public static final ResourceKey<Biome> KAYENTA_RIVER = register("kayenta_river");
	public static final ResourceKey<Biome> MORRISON_SAVANNA = register("morrison_savanna");
	public static final ResourceKey<Biome> MORRISON_HILLS = register("morrison_hills");

	public static final ResourceKey<Biome> HELL_CREEK_HARDWOOD_FOREST = register("hell_creek_hardwood_forest");
	public static final ResourceKey<Biome> HELL_CREEK_CLEARING = register("hell_creek_clearing");
	public static final ResourceKey<Biome> HELL_CREEK_BLUFFS = register("hell_creek_bluffs");
	public static final ResourceKey<Biome> HELL_CREEK_REDWOODS = register("hell_creek_redwoods");
	public static final ResourceKey<Biome> HELL_CREEK_SWAMP = register("hell_creek_swamp");
	public static final ResourceKey<Biome> HELL_CREEK_RIVER = register("hell_creek_river");
	public static final ResourceKey<Biome> DJADOCHTA_DUNES = register("djadochta_dunes");
	public static final ResourceKey<Biome> DJADOCHTA_ARROYO = register("djadochta_arroyo");
	public static final ResourceKey<Biome> DJADOCHTA_ALLUVIAL_PLAINS = register("djadochta_alluvial_plains");
	public static final ResourceKey<Biome> YIXIAN_FOREST = register("yixian_forest");
	public static final ResourceKey<Biome> YIXIAN_LAKES = register("yixian_lakes");
	public static final ResourceKey<Biome> YIXIAN_SNOWY_FOREST = register("yixian_snowy_forest");
	public static final ResourceKey<Biome> YIXIAN_SNOWY_MOUNTAINS = register("yixian_snowy_mountains");
	public static final ResourceKey<Biome> YIXIAN_REGROWTH = register("yixian_regrowth");
	public static final ResourceKey<Biome> YIXIAN_VOLCANO = register("yixian_volcano");

	public static final ResourceKey<Biome> CRETACEOUS_DRIPSTONE_CAVE = register("cretaceous_dripstone_cave");
	public static final ResourceKey<Biome> JURASSIC_DRIPSTONE_CAVE = register("jurassic_dripstone_cave");
	public static final ResourceKey<Biome> TRIASSIC_DRIPSTONE_CAVE = register("triassic_dripstone_cave");
	public static final ResourceKey<Biome> CRETACEOUS_HENOSTONE_CAVE = register("cretaceous_henostone_cave");
	public static final ResourceKey<Biome> JURASSIC_HENOSTONE_CAVE = register("jurassic_henostone_cave");
	public static final ResourceKey<Biome> TRIASSIC_HENOSTONE_CAVE = register("triassic_henostone_cave");

	public static void bootstrap(BootstapContext<Biome> bootstapContext) {
		HolderGetter<PlacedFeature> holderGetter = bootstapContext.lookup(Registries.PLACED_FEATURE);
		HolderGetter<ConfiguredWorldCarver<?>> holderGetter1 = bootstapContext.lookup(Registries.CONFIGURED_CARVER);
		bootstapContext.register(CHINLE_FLATS, TriassicBiomes.chinleFlats(holderGetter, holderGetter1));
		bootstapContext.register(CHINLE_RIVER, TriassicBiomes.chinleRiver(holderGetter, holderGetter1));
		bootstapContext.register(CHINLE_SWAMP, TriassicBiomes.chinleSwamp(holderGetter, holderGetter1));
		bootstapContext.register(CHINLE_WOODED_MOUNTAINS, TriassicBiomes.chinleWoodedMountains(holderGetter, holderGetter1));
		bootstapContext.register(ISCHIGUALASTO_RIVER, TriassicBiomes.ischigualastoRiver(holderGetter, holderGetter1));
		bootstapContext.register(ISCHIGUALASTO_CLEARING, TriassicBiomes.ischigualastoClearing(holderGetter, holderGetter1));
		bootstapContext.register(ISCHIGUALASTO_FOREST, TriassicBiomes.ischigualastoForest(holderGetter, holderGetter1));
		bootstapContext.register(ISCHIGUALASTO_HILLS, TriassicBiomes.ischigualastoHills(holderGetter, holderGetter1));

		bootstapContext.register(KAYENTA_DRY_FOREST, JurassicBiomes.kayentaDryForest(holderGetter, holderGetter1));
		bootstapContext.register(KAYENTA_BUTTES, JurassicBiomes.kayentaButtes(holderGetter, holderGetter1));
		bootstapContext.register(KAYENTA_DESERT, JurassicBiomes.kayentaDesert(holderGetter, holderGetter1));
		bootstapContext.register(KAYENTA_RIVER, JurassicBiomes.kayentaRiver(holderGetter, holderGetter1));
		bootstapContext.register(MORRISON_SAVANNA, JurassicBiomes.morrisonSavanna(holderGetter, holderGetter1));
		bootstapContext.register(MORRISON_HILLS, JurassicBiomes.morrisonHills(holderGetter, holderGetter1));

		bootstapContext.register(HELL_CREEK_HARDWOOD_FOREST, CretaceousBiomes.hellCreekHardwoodForest(holderGetter, holderGetter1));
		bootstapContext.register(HELL_CREEK_CLEARING, CretaceousBiomes.hellCreekClearing(holderGetter, holderGetter1));
		bootstapContext.register(HELL_CREEK_BLUFFS, CretaceousBiomes.hellCreekBluffs(holderGetter, holderGetter1));
		bootstapContext.register(HELL_CREEK_REDWOODS, CretaceousBiomes.hellCreekRedwoods(holderGetter, holderGetter1));
		bootstapContext.register(HELL_CREEK_SWAMP, CretaceousBiomes.hellCreekSwamp(holderGetter, holderGetter1));
		bootstapContext.register(HELL_CREEK_RIVER, CretaceousBiomes.hellCreekRiver(holderGetter, holderGetter1));
		bootstapContext.register(DJADOCHTA_DUNES, CretaceousBiomes.djadochtaDunes(holderGetter, holderGetter1));
		bootstapContext.register(DJADOCHTA_ARROYO, CretaceousBiomes.djadochtaArroyo(holderGetter, holderGetter1));
		bootstapContext.register(DJADOCHTA_ALLUVIAL_PLAINS, CretaceousBiomes.djadochtaAlluvialPlains(holderGetter, holderGetter1));
		bootstapContext.register(YIXIAN_FOREST, CretaceousBiomes.yixianForest(holderGetter, holderGetter1));
		bootstapContext.register(YIXIAN_LAKES, CretaceousBiomes.yixianLakes(holderGetter, holderGetter1));
		bootstapContext.register(YIXIAN_SNOWY_FOREST, CretaceousBiomes.yixianSnowyForest(holderGetter, holderGetter1));
		bootstapContext.register(YIXIAN_SNOWY_MOUNTAINS, CretaceousBiomes.yixianSnowyMountains(holderGetter, holderGetter1));
		bootstapContext.register(YIXIAN_REGROWTH, CretaceousBiomes.yixianRegrowth(holderGetter, holderGetter1));
		bootstapContext.register(YIXIAN_VOLCANO, CretaceousBiomes.yixianVolcano(holderGetter, holderGetter1));

		bootstapContext.register(CRETACEOUS_DRIPSTONE_CAVE, prehistoricDripstoneCave(holderGetter, holderGetter1));
		bootstapContext.register(JURASSIC_DRIPSTONE_CAVE, prehistoricDripstoneCave(holderGetter, holderGetter1));
		bootstapContext.register(TRIASSIC_DRIPSTONE_CAVE, prehistoricDripstoneCave(holderGetter, holderGetter1));
		bootstapContext.register(CRETACEOUS_HENOSTONE_CAVE, prehistoricHenostoneCave(holderGetter, holderGetter1));
		bootstapContext.register(JURASSIC_HENOSTONE_CAVE, prehistoricHenostoneCave(holderGetter, holderGetter1));
		bootstapContext.register(TRIASSIC_HENOSTONE_CAVE, prehistoricHenostoneCave(holderGetter, holderGetter1));
	}

	private static ResourceKey<Biome> register(String name) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
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
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}

	public static Biome prehistoricDripstoneCave(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		BiomeDefaultFeatures.addDripstone(biomeFeatures);
		if (PrehistoricFaunaConfig.caveSentinelIschigualastoClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelIschigualastoClearingSpawnWeight, 1, 1));
		return biome(false, 7372597, 5267523, 15922646, 13622197, 0, 0, spawnSettings, biomeFeatures);
	}

	public static Biome prehistoricHenostoneCave(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		biomeFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, PFPlacedFeatures.HENOSTONE_ORE);
		if (PrehistoricFaunaConfig.caveSentinelHenostoneCaveSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHenostoneCaveSpawnWeight, 1, 1));
		return biome(false, 7372597, 5267523, 15922646, 13622197, 0, 0, spawnSettings, biomeFeatures);
	}

}
