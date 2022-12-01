package superlord.prehistoricfauna.world.biome.jurassic;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.Biome.Category;
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

public class KayentaDesertBiome extends PFBiome {
	
	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("kayenta_desert_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.KAYENTA_DESERT, new SurfaceBuilderConfig(PFBlocks.SILT.getDefaultState(), PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState())));
	static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 1.2F;
	static final float DOWNFALL = 0F;
	static final int WATER_COLOR = 0x215FA4;
	static final int WATER_FOG_COLOR = 0x376682;
	static final int SKY_COLOR = 0x94addf;
	static final int FOLIAGE_COLOR = 0x53711f;
	static final int GRASS_COLOR = 0x53711f;
	static final int FOG_COLOR = 0xde9757;
	static final float DEPTH = 0F;
	static final float SCALE = 0F;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public KayentaDesertBiome() {
		super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(SKY_COLOR).setFogColor(FOG_COLOR).withFoliageColor(FOLIAGE_COLOR).withGrassColor(GRASS_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
	}
	
	@Override
	public int getWeight() {
		return 5;
	}
	
	@Override
	public BiomeDictionary.Type[] getBiomeDictionary() {
		return new BiomeDictionary.Type[]{BiomeDictionary.Type.HOT, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DRY};
	}
	
	@Override
	public BiomeManager.BiomeType getBiomeType() {
		return BiomeManager.BiomeType.WARM;
	}
	
	static {
        DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.JURASSIC_FOSSILIZED_SANDSTONE);
		PFConfiguredFeatures.withDeadPlants(GENERATION_SETTINGS);
		PFConfiguredFeatures.addKayentaDesertRocks(GENERATION_SETTINGS);
		GENERATION_SETTINGS.withFeature(Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.ZAMITES_BUSH);
		if (PrehistoricFaunaConfig.calsoyasuchusKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CALSOYASUCHUS_ENTITY, PrehistoricFaunaConfig.calsoyasuchusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dilophosaurusKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DILOPHOSAURUS_ENTITY, PrehistoricFaunaConfig.dilophosaurusKayentaDesertSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.sarahsaurusKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SARAHSAURUS_ENTITY, PrehistoricFaunaConfig.sarahsaurusKayentaDesertSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.scelidosaurusKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SCELIDOSAURUS_ENTITY, PrehistoricFaunaConfig.scelidosaurusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.CERATODUS, PrehistoricFaunaConfig.ceratodusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.POTAMOCERATODUS, PrehistoricFaunaConfig.potamoceratodusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelKayentaDesertSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelKayentaDesertSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.scutellosaurusKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SCUTELLOSAURUS_ENTITY, PrehistoricFaunaConfig.scutellosaurusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.megapnosaurusKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.MEGAPNOSAURUS_ENTITY, PrehistoricFaunaConfig.megapnosaurusKayentaDesertSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentatheriumKayentaDesertSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.KAYENTATHERIUM_ENTITY, PrehistoricFaunaConfig.kayentatheriumKayentaDesertSpawnWeight, 1, 2));
	}
	
}
