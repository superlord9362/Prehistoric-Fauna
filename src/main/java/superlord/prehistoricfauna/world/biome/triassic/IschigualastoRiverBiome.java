package superlord.prehistoricfauna.world.biome.triassic;

import net.minecraft.block.Blocks;
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
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.world.biome.PFBiome;

public class IschigualastoRiverBiome extends PFBiome {

	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("ischigualasto_river_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.ISCHIGUALASTO, new SurfaceBuilderConfig(Blocks.PODZOL.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState())));
	static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 0.75F;
	static final float DOWNFALL = 0.9F;
	static final int WATER_COLOR = 0x436853;
	static final int WATER_FOG_COLOR = 0x40624e;
	static final int FOLIAGE_COLOR = 0x53711f;
	static final int GRASS_COLOR = 0x53711f;
	static final int FOG_COLOR = 12638463;
	static final float SCALE = 0.05F;
	static final float DEPTH = -0.6F;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public IschigualastoRiverBiome() {
		super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(getSkyColorWithTemperatureModifier(TEMPERATURE)).setFogColor(FOG_COLOR).withFoliageColor(FOLIAGE_COLOR).withGrassColor(GRASS_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
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
		return new BiomeDictionary.Type[]{BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.LUSH};
	}

	@Override
	public BiomeManager.BiomeType getBiomeType() {
		return BiomeManager.BiomeType.COOL;
	}

	static {
		PFConfiguredFeatures.addIschigualastoVegetation(GENERATION_SETTINGS);
		if (PrehistoricFaunaConfig.exaeretodonIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.EXAERETODON_ENTITY, PrehistoricFaunaConfig.exaeretodonIschigualastoRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.chromogisaurusIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CHROMOGISAURUS_ENTITY, PrehistoricFaunaConfig.chromogisaurusIschigualastoRiverSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.herrerasaurusIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.HERRERASAURUS_ENTITY, PrehistoricFaunaConfig.herrerasaurusIschigualastoRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.hyperodapedonIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.HYPERODAPEDON_ENTITY, PrehistoricFaunaConfig.hyperodapedonIschigualastoRiverSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sillosuchusIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SILLOSUCHUS_ENTITY, PrehistoricFaunaConfig.sillosuchusIschigualastoRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.saurosuchusIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SAUROSUCHUS_ENTITY, PrehistoricFaunaConfig.saurosuchusIschigualastoRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ischigualastiaIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.ISCHIGUALASTIA_ENTITY, PrehistoricFaunaConfig.ischigualastiaIschigualastoRiverSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.caveSentinelIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelIschigualastoRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelIschigualastoRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.ceratodusIschigualastoRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.CERATODUS, PrehistoricFaunaConfig.ceratodusIschigualastoRiverSpawnWeight, 1, 2));
		DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
	}


}

