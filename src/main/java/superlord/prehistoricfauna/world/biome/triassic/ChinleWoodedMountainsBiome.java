package superlord.prehistoricfauna.world.biome.triassic;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.Biome.Category;
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

public class ChinleWoodedMountainsBiome extends PFBiome {

	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("chinle_wooded_mountains_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.CHINLE_WOODED_MOUNTAINS, new SurfaceBuilderConfig(PFBlocks.LOAM.getDefaultState(), PFBlocks.PACKED_LOAM.getDefaultState(), PFBlocks.LOAM.getDefaultState())));
	static final Biome.RainType PRECIPITATION = Biome.RainType.RAIN;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 0.9F;
	static final float DOWNFALL = 0.9F;
	static final int WATER_COLOR = 0x707F35;
	static final int WATER_FOG_COLOR = 0x506043;
	static final int SKY_COLOR = 0xf2f5d6;
	static final int FOLIAGE_COLOR = 0x707F35;
	static final int FOG_COLOR = 0xcfdbb5;
	static final float DEPTH = 0.5F;
	static final float SCALE = 0.5F;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPITATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public ChinleWoodedMountainsBiome() {
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
        PFConfiguredFeatures.withChinleWoodedMountainsPlants(GENERATION_SETTINGS);
        if (PrehistoricFaunaConfig.caveSentinelChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelChinleWoodedMountainsSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.landSentinelChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelChinleWoodedMountainsSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.desmatosuchusChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DESMATOSUCHUS_ENTITY, PrehistoricFaunaConfig.desmatosuchusChinleWoodedMountainsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.trilophosaurusChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TRILOPHOSAURUS_ENTITY, PrehistoricFaunaConfig.trilophosaurusChinleWoodedMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.postosuchusChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.POSTOSUCHUS_ENTITY, PrehistoricFaunaConfig.postosuchusChinleWoodedMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.chinleaChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CHINLEA_ENTITY, PrehistoricFaunaConfig.chinleaChinleWoodedMountainsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.arganodusChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.ARGANODUS_ENTITY, PrehistoricFaunaConfig.arganodusChinleWoodedMountainsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.mooreodontusChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.MOOREODONTUS_ENTITY, PrehistoricFaunaConfig.mooreodontusChinleWoodedMountainsSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.saurichthysChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SAURICHTHYS_ENTITY, PrehistoricFaunaConfig.saurichthysChinleWoodedMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.placeriasChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.PLACERIAS_ENTITY, PrehistoricFaunaConfig.placeriasChinleWoodedMountainsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.coelophysisChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.COELOPHYSIS_ENTITY, PrehistoricFaunaConfig.coelophysisChinleWoodedMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.poposaurusChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.POPOSAURUS_ENTITY, PrehistoricFaunaConfig.poposaurusChinleWoodedMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.typothoraxChinleWoodedMountainsSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TYPOTHORAX_ENTITY, PrehistoricFaunaConfig.typothoraxChinleWoodedMountainsSpawnWeight, 1, 4));
	}

}
