package superlord.prehistoricfauna.world.biome.triassic;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import superlord.prehistoricfauna.common.world.PFConfiguredFeatures;
import superlord.prehistoricfauna.common.world.PFSurfaceBuilders;
import superlord.prehistoricfauna.common.world.WorldGenRegistrationHelper;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.world.biome.PFBiome;

public class ChinleFlatsBiome extends PFBiome {

	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("chinle_flats_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.CHINLE_FLATS, new SurfaceBuilderConfig(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.SILT.getDefaultState())));
	static final Biome.RainType PRECIPITATION = Biome.RainType.RAIN;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 0.9F;
	static final float DOWNFALL = 0.9F;
	static final int WATER_COLOR = 0x707F35;
	static final int WATER_FOG_COLOR = 0x506043;
	static final int SKY_COLOR = 0xf2f5d6;
	static final int FOLIAGE_COLOR = 0x707F35;
	static final int FOG_COLOR = 0xcfdbb5;
	static final float DEPTH = -0.1F;
	static final float SCALE = 0F;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPITATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public ChinleFlatsBiome() {
		super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(SKY_COLOR).setFogColor(FOG_COLOR).withFoliageColor(FOLIAGE_COLOR).withGrassColor(FOLIAGE_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
	}

	@Override
	public int getWeight() {
		return 5;
	}

	@Override
	public BiomeDictionary.Type[] getBiomeDictionary() {
		return new BiomeDictionary.Type[] {BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.HOT};
	}

	@Override
	public BiomeManager.BiomeType getBiomeType() {
		return BiomeManager.BiomeType.WARM;
	}

	static {
		DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
		PFConfiguredFeatures.withClayDisks(GENERATION_SETTINGS);
		PFConfiguredFeatures.withChinleFlatsPlants(GENERATION_SETTINGS);
		PFConfiguredFeatures.withDeadPlants(GENERATION_SETTINGS);
		if (PrehistoricFaunaConfig.caveSentinelChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelChinleFlatsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelChinleFlatsSpawnWeight != 0) {
		SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelChinleFlatsSpawnWeight, 1, 1));
		}
		if (PrehistoricFaunaConfig.trilophosaurusChinleFlatsSpawnWeight != 0) {
			SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TRILOPHOSAURUS_ENTITY, PrehistoricFaunaConfig.trilophosaurusChinleFlatsSpawnWeight, 1, 3));
		}
		if (PrehistoricFaunaConfig.desmatosuchusChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DESMATOSUCHUS_ENTITY, PrehistoricFaunaConfig.desmatosuchusChinleFlatsSpawnWeight, 2, 4));
        if (PrehistoricFaunaConfig.chinleaChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CHINLEA_ENTITY, PrehistoricFaunaConfig.chinleaChinleFlatsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.chinleaChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CHINLEA_ENTITY, PrehistoricFaunaConfig.chinleaChinleFlatsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.arganodusChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.ARGANODUS_ENTITY, PrehistoricFaunaConfig.arganodusChinleFlatsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.saurichthysChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SAURICHTHYS_ENTITY, PrehistoricFaunaConfig.saurichthysChinleFlatsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.mooreodontusChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.MOOREODONTUS_ENTITY, PrehistoricFaunaConfig.mooreodontusChinleFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.postosuchusChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.POSTOSUCHUS_ENTITY, PrehistoricFaunaConfig.postosuchusChinleFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.placeriasChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.PLACERIAS_ENTITY, PrehistoricFaunaConfig.placeriasChinleFlatsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.coelophysisChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.COELOPHYSIS_ENTITY, PrehistoricFaunaConfig.coelophysisChinleFlatsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.poposaurusChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.POPOSAURUS_ENTITY, PrehistoricFaunaConfig.poposaurusChinleFlatsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.typothoraxChinleFlatsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TYPOTHORAX_ENTITY, PrehistoricFaunaConfig.typothoraxChinleFlatsSpawnWeight, 1, 4));
	}

}
