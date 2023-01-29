package superlord.prehistoricfauna.world.biome.cretaceous;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage.Decoration;
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

public class DjadochtaDunesBiome extends PFBiome {

	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("djadochta_dunes_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.DJADOCHTA_DUNES, new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SANDSTONE.getDefaultState())));
	static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 1F;
	static final float DOWNFALL = 0.2F;
	static final int WATER_COLOR = 0x66866b;
	static final int WATER_FOG_COLOR = 0x9c8c67;
	static final int FOG_COLOR = 12638463;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public DjadochtaDunesBiome(float scale, float depth) {
		super(WEATHER, CATEGORY, depth, scale, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(0x7fc0ff).setFogColor(FOG_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
	}
	
	@Override
	public Biome getClearing() {
		return new DjadochtaArroyoBiome(0.05F, 0.2F).getBiome();
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
		DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
		if (PrehistoricFaunaConfig.caveSentinelDjadochtaDunesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelDjadochtaDunesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelDjadochtaDunesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelDjadochtaDunesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.protoceratopsDjadochtaDunesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.PROTOCERATOPS_ENTITY, PrehistoricFaunaConfig.protoceratopsDjadochtaDunesSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.velociraptorDjadochtaDunesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.VELOCIRAPTOR_ENTITY, PrehistoricFaunaConfig.velociraptorDjadochtaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.citipatiDjadochtaDunesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CITIPATI_ENTITY, PrehistoricFaunaConfig.citipatiDjadochtaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaDunesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.AEPYORNITHOMIMUS_ENTITY, PrehistoricFaunaConfig.aepyornithomimusDjadochtaDunesSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.telmasaurusDjadochtaDunesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TELMASAURUS_ENTITY, PrehistoricFaunaConfig.telmasaurusDjadochtaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.pinacosaurusDjadochtaDunesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.PINACOSAURUS_ENTITY, PrehistoricFaunaConfig.pinacosaurusDjadochtaDunesSpawnWeight, 3, 4));
		if (PrehistoricFaunaConfig.plesiohadrosDjadochtaDunesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.PLESIOHADROS_ENTITY, PrehistoricFaunaConfig.plesiohadrosDjadochtaDunesSpawnWeight, 3, 5));
	}


}

