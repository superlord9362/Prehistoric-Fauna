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

public class ChinleRiverBiome extends PFBiome {

	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("chinle_river_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.CHINLE_FLATS, new SurfaceBuilderConfig(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.SILT.getDefaultState())));
	static final Biome.RainType PRECIPITATION = Biome.RainType.RAIN;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 0.9F;
	static final float DOWNFALL = 0.9F;
	static final int WATER_COLOR = 0x707F35;
	static final int WATER_FOG_COLOR = 0x506043;
	static final int SKY_COLOR = 0xf2f5d6;
	static final int FOLIAGE_COLOR = 0x707F35;
	static final int FOG_COLOR = 0xcfdbb5;
	static final float SCALE = 0.05F;
	static final float DEPTH = -0.6F;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPITATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public ChinleRiverBiome() {
		super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(getSkyColorWithTemperatureModifier(TEMPERATURE)).setFogColor(FOG_COLOR).withFoliageColor(FOLIAGE_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
	}
	
	@Override
	public Biome getRiver() {
		return this.getBiome();
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
		PFConfiguredFeatures.withChinleRiverPlants(GENERATION_SETTINGS);
		PFConfiguredFeatures.withDeadPlants(GENERATION_SETTINGS);
		if (PrehistoricFaunaConfig.caveSentinelChinleRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelChinleRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelChinleRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelChinleRiverSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.chinleaChinleRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CHINLEA_ENTITY, PrehistoricFaunaConfig.chinleaChinleRiverSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.arganodusChinleRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.ARGANODUS_ENTITY, PrehistoricFaunaConfig.arganodusChinleRiverSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.saurichthysChinleRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SAURICHTHYS_ENTITY, PrehistoricFaunaConfig.saurichthysChinleRiverSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.mooreodontusChinleRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.MOOREODONTUS_ENTITY, PrehistoricFaunaConfig.mooreodontusChinleRiverSpawnWeight, 1, 2));
	}


}

