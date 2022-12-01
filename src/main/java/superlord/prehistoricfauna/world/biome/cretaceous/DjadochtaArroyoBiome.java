package superlord.prehistoricfauna.world.biome.cretaceous;

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

public class DjadochtaArroyoBiome extends PFBiome {

	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("djadochta_arroyo_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.DJADOCHTA_ARROYO, new SurfaceBuilderConfig(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState())));
	static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 1F;
	static final float DOWNFALL = 0.2F;
	static final int WATER_COLOR = 0x66866b ;
	static final int WATER_FOG_COLOR = 0x9c8c67;
	static final int FOG_COLOR = 12638463;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public DjadochtaArroyoBiome(float scale, float depth) {
		super(WEATHER, CATEGORY, depth, scale, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(0x528790).setFogColor(FOG_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
	}
	
	

	@Override
	public int getWeight() {
		return 5;
	}

	@Override
	public BiomeDictionary.Type[] getBiomeDictionary() {
		return new BiomeDictionary.Type[]{BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.HOT};
	}

	@Override
	public BiomeManager.BiomeType getBiomeType() {
		return BiomeManager.BiomeType.WARM;
	}

	static {
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.CRETACEOUS_FOSSILIZED_SANDSTONE);
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.CRETACEOUS_FOSSILIZED_SILTSTONE); 
		PFConfiguredFeatures.withRareDeadCycadeoid(GENERATION_SETTINGS);
		PFConfiguredFeatures.withDjadochtaPlants(GENERATION_SETTINGS);
		DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
		PFConfiguredFeatures.withDjadochtaRocks(GENERATION_SETTINGS);
		PFConfiguredFeatures.withArroyoPlants(GENERATION_SETTINGS);
		GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.DJADOCHTA_ARROYO_VEGETATION);
		if (PrehistoricFaunaConfig.caveSentinelDjadochtaArroyoSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelDjadochtaArroyoSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelDjadochtaArroyoSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelDjadochtaArroyoSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.protoceratopsDjadochtaArroyoSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.PROTOCERATOPS_ENTITY, PrehistoricFaunaConfig.protoceratopsDjadochtaArroyoSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.velociraptorDjadochtaArroyoSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.VELOCIRAPTOR_ENTITY, PrehistoricFaunaConfig.velociraptorDjadochtaArroyoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.citipatiDjadochtaArroyoSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CITIPATI_ENTITY, PrehistoricFaunaConfig.citipatiDjadochtaArroyoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaArroyoSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.AEPYORNITHOMIMUS_ENTITY, PrehistoricFaunaConfig.aepyornithomimusDjadochtaArroyoSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.telmasaurusDjadochtaArroyoSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TELMASAURUS_ENTITY, PrehistoricFaunaConfig.telmasaurusDjadochtaArroyoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.pinacosaurusDjadochtaArroyoSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.PINACOSAURUS_ENTITY, PrehistoricFaunaConfig.pinacosaurusDjadochtaArroyoSpawnWeight, 4, 5));
		if (PrehistoricFaunaConfig.plesiohadrosDjadochtaArroyoSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.PLESIOHADROS_ENTITY, PrehistoricFaunaConfig.plesiohadrosDjadochtaArroyoSpawnWeight, 3, 5));
	}


}

