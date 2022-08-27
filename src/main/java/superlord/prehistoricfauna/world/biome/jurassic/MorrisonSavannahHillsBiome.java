package superlord.prehistoricfauna.world.biome.jurassic;

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
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.world.biome.PFBiome;

public class MorrisonSavannahHillsBiome extends PFBiome {

	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("morrison_savannah_hills_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.MORRISON_SAVANNA, new SurfaceBuilderConfig(PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), Blocks.CLAY.getDefaultState())));
	static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 1F;
	static final float DOWNFALL = 0.2F;
	static final int WATER_COLOR = 0xab986d;
	static final int WATER_FOG_COLOR = 0x9c8c67;
	static final int FOG_COLOR = 12638463;
	static final float SCALE = 0.1F;
	static final float DEPTH = 0.2F;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public MorrisonSavannahHillsBiome() {
		super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(getSkyColorWithTemperatureModifier(TEMPERATURE)).setFogColor(FOG_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
	}
	
	@Override
	public Biome getHills() {
		return this.getBiome();
	}

	@Override
	public int getWeight() {
		return 5;
	}

	@Override
	public BiomeDictionary.Type[] getBiomeDictionary() {
		return new BiomeDictionary.Type[]{BiomeDictionary.Type.DRY, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.HOT};
	}

	@Override
	public BiomeManager.BiomeType getBiomeType() {
		return BiomeManager.BiomeType.WARM;
	}

	static {
		PFConfiguredFeatures.addMorrisonSavannaVegetation(GENERATION_SETTINGS);
		if (PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.STEGOSAURUS_ENTITY, PrehistoricFaunaConfig.stegosaurusMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DRYOSAURUS_ENTITY, PrehistoricFaunaConfig.dryosaurusMorrisonSavannahSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CERATOSAURUS_ENTITY, PrehistoricFaunaConfig.ceratosaurusMorrisonSavannahSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.ALLOSAURUS_ENTITY, PrehistoricFaunaConfig.allosaurusMorrisonSavannahSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.HESPERORNITHOIDES_ENTITY, PrehistoricFaunaConfig.hesperornithoidesMorrisonSavannahSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.EILENODON_ENTITY, PrehistoricFaunaConfig.eilenodonMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CAMARASAURUS_ENTITY, PrehistoricFaunaConfig.camarasaurusMorrisonSavannahSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.CERATODUS, PrehistoricFaunaConfig.ceratodusMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(PFEntities.POTAMOCERATODUS, PrehistoricFaunaConfig.potamoceratodusMorrisonSavannahSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.caveSentinelMorrisonSavannahSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight != 0) SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.LAND_SENTINEL_ENTITY, PrehistoricFaunaConfig.landSentinelMorrisonSavannahSpawnWeight, 1, 1));
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.FOSSILIZED_SANDSTONE);
		DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
		PFConfiguredFeatures.addExtraIronOre(GENERATION_SETTINGS);
	}


}

