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

public class HellCreekBiome extends PFBiome {

	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("hell_creek_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.HELL_CREEK, new SurfaceBuilderConfig(PFBlocks.MOSSY_DIRT.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
	static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 0.7F;
	static final float DOWNFALL = 0.8F;
	static final int WATER_COLOR = 0x7C5D48;
	static final int WATER_FOG_COLOR = 0x6B4E3B;
	static final int SKY_COLOR = 0x7ebf9f;
	static final int FOLIAGE_COLOR = 0x53711f;
	static final int GRASS_COLOR = 0x53711f;
	static final int FOG_COLOR = 12638463;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public HellCreekBiome(float scale, float depth) {
		super(WEATHER, CATEGORY, depth, scale, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(SKY_COLOR).setFogColor(FOG_COLOR).withFoliageColor(FOLIAGE_COLOR).withGrassColor(GRASS_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
	}

	@Override
	public Biome getRiver() {
		return new HellCreekRiverBiome().getBiome();
	}
	
	@Override
	public Biome getHills() {
		return new HellCreekHillsBiome().getBiome();
	}
	
	@Override
	public Biome getClearing() {
		return new HellCreekClearingBiome().getBiome();
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
		PFConfiguredFeatures.withHellCreekVegetation(GENERATION_SETTINGS);
		if (PrehistoricFaunaConfig.didelphodonHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DIDELPHODON_ENTITY, PrehistoricFaunaConfig.didelphodonHellCreekForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.dakotaraptorHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DAKOTARAPTOR_ENTITY, PrehistoricFaunaConfig.dakotaraptorHellCreekForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.tyrannosaurusHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TYRANNOSAURUS_ENTITY, PrehistoricFaunaConfig.tyrannosaurusHellCreekForestSpawnWeight, 1, 1));
		PFConfiguredFeatures.addHellCreekVegetation(GENERATION_SETTINGS);
		GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.MOSS);
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.CRETACEOUS_FOSSILIZED_SANDSTONE);
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.CRETACEOUS_FOSSILIZED_SILTSTONE);
		if (PrehistoricFaunaConfig.thescelosaurusHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.THESCELOSAURUS_ENTITY, PrehistoricFaunaConfig.thescelosaurusHellCreekForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.triceratopsHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TRICERATOPS_ENTITY, PrehistoricFaunaConfig.triceratopsHellCreekForestSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.ankylosaurusHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.ANKYLOSAURUS_ENTITY, PrehistoricFaunaConfig.ankylosaurusHellCreekForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.basilemysHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.BASILEMYS_ENTITY, PrehistoricFaunaConfig.basilemysHellCreekForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelHellCreekForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelHellCreekForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.garHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.GAR, PrehistoricFaunaConfig.garHellCreekForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.cyclurusHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.CYCLURUS, PrehistoricFaunaConfig.cyclurusHellCreekForestSpawnWeight, 1, 3));
        if (PrehistoricFaunaConfig.myledaphusHellCreekForestSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.MYLEDAPHUS, PrehistoricFaunaConfig.myledaphusHellCreekForestSpawnWeight, 1, 7));
        DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
	}


}
