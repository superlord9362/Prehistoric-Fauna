package superlord.prehistoricfauna.world.biome.cretaceous;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
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

public class HellCreekRiverBiome extends PFBiome {
	
	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("hell_creek_river_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.HELL_CREEK, new SurfaceBuilderConfig(PFBlocks.MOSSY_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState())));
	static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 0.7F;
	static final float DOWNFALL = 0.8F;
	static final int WATER_COLOR = 0x7C5D48;
	static final int WATER_FOG_COLOR = 0x6B4E3B;
	static final int SKY_COLOR = 0x7ebf9f;
	static final int FOLIAGE_COLOR = 0x53711f;
	static final int GRASS_COLOR = 0x53711f;
	static final float DEPTH = -0.5F;
	static final float SCALE = 0.0F;
	static final int FOG_COLOR = 12638463;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);


	public HellCreekRiverBiome() {
		super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(SKY_COLOR).setFogColor(FOG_COLOR).withFoliageColor(FOLIAGE_COLOR).withGrassColor(GRASS_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
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
		return new BiomeDictionary.Type[]{BiomeDictionary.Type.RIVER};
	}

	@Override
	public BiomeManager.BiomeType getBiomeType() {
		return BiomeManager.BiomeType.COOL;
	}

	static {
		PFConfiguredFeatures.withHellCreekVegetation(GENERATION_SETTINGS);
		if (PrehistoricFaunaConfig.didelphodonHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DIDELPHODON_ENTITY, PrehistoricFaunaConfig.didelphodonHellCreekRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.dakotaraptorHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DAKOTARAPTOR_ENTITY, PrehistoricFaunaConfig.dakotaraptorHellCreekRiverSpawnWeight, 1, 3));
        if (PrehistoricFaunaConfig.tyrannosaurusHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TYRANNOSAURUS_ENTITY, PrehistoricFaunaConfig.tyrannosaurusHellCreekRiverSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.thescelosaurusHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.THESCELOSAURUS_ENTITY, PrehistoricFaunaConfig.thescelosaurusHellCreekRiverSpawnWeight, 2, 4));
        if (PrehistoricFaunaConfig.triceratopsHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TRICERATOPS_ENTITY, PrehistoricFaunaConfig.triceratopsHellCreekRiverSpawnWeight, 2, 3));
        if (PrehistoricFaunaConfig.ankylosaurusHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.ANKYLOSAURUS_ENTITY, PrehistoricFaunaConfig.ankylosaurusHellCreekRiverSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.basilemysHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.BASILEMYS_ENTITY, PrehistoricFaunaConfig.basilemysHellCreekRiverSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.caveSentinelHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelHellCreekRiverSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.landSentinelHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelHellCreekRiverSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.myledaphusHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.MYLEDAPHUS, PrehistoricFaunaConfig.myledaphusHellCreekRiverSpawnWeight, 1, 7));
        if (PrehistoricFaunaConfig.garHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.GAR, PrehistoricFaunaConfig.garHellCreekRiverSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.cyclurusHellCreekRiverSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.CYCLURUS, PrehistoricFaunaConfig.cyclurusHellCreekRiverSpawnWeight, 1, 3));
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.CRASSOSTREA_OYSTERS);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.MOSS);
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.FOSSILIZED_SANDSTONE);
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.FOSSILIZED_SILTSTONE);
		GENERATION_SETTINGS.withFeature(Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.TROCHODENDROIDES_VEGETATION);
		GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.COBBANIA);
		PFConfiguredFeatures.addHellCreekVegetation(GENERATION_SETTINGS);
		DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
		PFConfiguredFeatures.withWaterLakesAndSprings(GENERATION_SETTINGS);
	}

}
