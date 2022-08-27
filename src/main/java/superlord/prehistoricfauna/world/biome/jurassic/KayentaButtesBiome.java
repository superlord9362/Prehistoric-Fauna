package superlord.prehistoricfauna.world.biome.jurassic;

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
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.world.biome.PFBiome;

public class KayentaButtesBiome extends PFBiome {
	
	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("kayenta_buttes_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.KAYENTA_BUTTES, new SurfaceBuilderConfig(PFBlocks.SILT.getDefaultState(), PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState())));
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
	static final float DEPTH = 0.05F;
	static final float SCALE = 0F;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public KayentaButtesBiome() {
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
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.FOSSILIZED_SANDSTONE);
		PFConfiguredFeatures.addKayentaCanyonVegetation(GENERATION_SETTINGS);
		if (PrehistoricFaunaConfig.calsoyasuchusKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CALSOYASUCHUS_ENTITY, PrehistoricFaunaConfig.calsoyasuchusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dilophosaurusKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DILOPHOSAURUS_ENTITY, PrehistoricFaunaConfig.dilophosaurusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.sarahsaurusKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SARAHSAURUS_ENTITY, PrehistoricFaunaConfig.sarahsaurusKayentaButtesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.scelidosaurusKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SCELIDOSAURUS_ENTITY, PrehistoricFaunaConfig.scelidosaurusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ceratodusKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.CERATODUS, PrehistoricFaunaConfig.ceratodusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.POTAMOCERATODUS, PrehistoricFaunaConfig.potamoceratodusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelKayentaButtesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelKayentaButtesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.scutellosaurusKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.SCUTELLOSAURUS_ENTITY, PrehistoricFaunaConfig.scutellosaurusKayentaButtesSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.megapnosaurusKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.MEGAPNOSAURUS_ENTITY, PrehistoricFaunaConfig.megapnosaurusKayentaButtesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.kayentatheriumKayentaButtesSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.KAYENTATHERIUM_ENTITY, PrehistoricFaunaConfig.kayentatheriumKayentaButtesSpawnWeight, 1, 2));
	}
	
}
