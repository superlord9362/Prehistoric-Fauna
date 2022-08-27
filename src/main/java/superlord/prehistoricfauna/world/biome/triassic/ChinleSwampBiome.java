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
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.world.biome.PFBiome;

public class ChinleSwampBiome extends PFBiome {
	
	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("chinle_swamp_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.CHINLE_SWAMP, new SurfaceBuilderConfig(PFBlocks.MOSSY_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState())));
	static final Biome.RainType PRECIPITATION = Biome.RainType.RAIN;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 0.9F;
	static final float DOWNFALL = 0.9F;
	static final int WATER_COLOR = 0x707F35;
	static final int WATER_FOG_COLOR = 0x506043;
	static final int SKY_COLOR = 0xf2f5d6;
	static final int FOLIAGE_COLOR = 0x707F35;
	static final int FOG_COLOR = 0xcfdbb5;
	static final float DEPTH = -0.2F;
	static final float SCALE = 0F;
	
	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPITATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);
	
	public ChinleSwampBiome() {
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
	public Biome getClearing() {
		return new ChinleFlatsBiome().getBiome();
	}
	
	@Override
	public Biome getHills() {
		return new ChinleWoodedMountainsBiome().getBiome();
	}
	
	@Override
	public BiomeManager.BiomeType getBiomeType() {
		return BiomeManager.BiomeType.WARM;
	}
	
	static {
        DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
        PFConfiguredFeatures.withChinlePlants(GENERATION_SETTINGS);
        if (PrehistoricFaunaConfig.caveSentinelChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelChinleSwampSpawnWeight, 1, 1));
        if (PrehistoricFaunaConfig.landSentinelChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelChinleSwampSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.desmatosuchusChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DESMATOSUCHUS_ENTITY, PrehistoricFaunaConfig.desmatosuchusChinleSwampSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.trilophosaurusChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TRILOPHOSAURUS_ENTITY, PrehistoricFaunaConfig.trilophosaurusChinleSwampSpawnWeight, 1, 3));
        if (PrehistoricFaunaConfig.chinleaChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.CHINLEA_ENTITY, PrehistoricFaunaConfig.chinleaChinleSwampSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.arganodusChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.ARGANODUS_ENTITY, PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.mooreodontusChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.MOOREODONTUS_ENTITY, PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight, 1, 2));
        if (PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.SAURICHTHYS_ENTITY, PrehistoricFaunaConfig.saurichthysChinleSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.postosuchusChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.POSTOSUCHUS_ENTITY, PrehistoricFaunaConfig.postosuchusChinleSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.placeriasChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.PLACERIAS_ENTITY, PrehistoricFaunaConfig.placeriasChinleSwampSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.coelophysisChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.COELOPHYSIS_ENTITY, PrehistoricFaunaConfig.coelophysisChinleSwampSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.poposaurusChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.POPOSAURUS_ENTITY, PrehistoricFaunaConfig.poposaurusChinleSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.typothoraxChinleSwampSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.TYPOTHORAX_ENTITY, PrehistoricFaunaConfig.typothoraxChinleSwampSpawnWeight, 1, 4));
	}
	
}
