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

public class MorrisonSavannahBiome extends PFBiome {

	static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("morrison_savannah_sb", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.MORRISON_SAVANNA, new SurfaceBuilderConfig(PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), Blocks.CLAY.getDefaultState())));
	static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
	static final Biome.Category CATEGORY = Category.NONE;
	static final float TEMPERATURE = 1F;
	static final float DOWNFALL = 0.2F;
	static final int WATER_COLOR = 4159204;
	static final int WATER_FOG_COLOR = 329011;
	static final int FOG_COLOR = 12638463;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public MorrisonSavannahBiome(float scale, float depth) {
		super(WEATHER, CATEGORY, depth, scale, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).withSkyColor(getSkyColorWithTemperatureModifier(TEMPERATURE)).setFogColor(FOG_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
	}
	
	@Override
	public Biome getHills() {
		return new MorrisonSavannahHillsBiome().getBeach();
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
        //PHFDefaultBiomeFeatures.addMorrisonHut(biome);
		PFConfiguredFeatures.addMorrisonSavannaVegetation(GENERATION_SETTINGS);
		SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.STEGOSAURUS_ENTITY, PrehistoricFaunaConfig.stegosaurusSpawnWeight, 1, 2));
		SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.DRYOSAURUS_ENTITY, PrehistoricFaunaConfig.dryosaurusSpawnWeight, 2, 4));
		SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CERATOSAURUS_ENTITY, PrehistoricFaunaConfig.ceratosaurusSpawnWeight, 1, 1));
		SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.ALLOSAURUS_ENTITY, PrehistoricFaunaConfig.allosaurusSpawnWeight, 1, 1));
		SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.HESPERORNITHOIDES_ENTITY, PrehistoricFaunaConfig.hesperornithoidesSpawnWeight, 2, 3));
		SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.EILENODON_ENTITY, PrehistoricFaunaConfig.eilenodonSpawnWeight, 1, 2));
		SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PFEntities.CAMARASAURUS_ENTITY, PrehistoricFaunaConfig.camarasaurusSpawnWeight, 2, 4));
		SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PFEntities.TRILOBITE_SENTINEL_ENTITY, PrehistoricFaunaConfig.trilobiteSentinelSpawnWeight, 1, 1));
		GENERATION_SETTINGS.withFeature(Decoration.UNDERGROUND_ORES, PFConfiguredFeatures.FOSSILIZED_SILTSTONE);
		DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
	}


}

