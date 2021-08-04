package superlord.prehistoricfauna.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import superlord.prehistoricfauna.common.world.PFConfiguredFeatures;
import superlord.prehistoricfauna.common.world.PFSurfaceBuilders;
import superlord.prehistoricfauna.common.world.WorldGenRegistrationHelper;
import superlord.prehistoricfauna.init.PFBlocks;

public class Dummy extends PFBiome {
	@SuppressWarnings("rawtypes")
	static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("petrified_forest", new ConfiguredSurfaceBuilder<>(PFSurfaceBuilders.PETRIFIED_FOREST, new SurfaceBuilderConfig(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState())));
	static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
	static final Biome.Category CATEGORY = Biome.Category.DESERT;
	static final float DEPTH = 0.1F;
	static final float SCALE = 0.07F;
	static final float TEMPERATURE = 0.9F;
	static final float DOWNFALL = 0.0F;
	static final int WATER_COLOR = 4159204;
	static final int WATER_FOG_COLOR = 329011;

	static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
	static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
	static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

	public Dummy() {
		super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withSkyColor(WATER_COLOR).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
	}

	@Override
	public Biome getRiver() {
		return this.getBiome();
	}


	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public BiomeDictionary.Type[] getBiomeDictionary() {
		return new BiomeDictionary.Type[]{BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.PLATEAU};
	}

	@Override
	public BiomeManager.BiomeType getBiomeType() {
		return BiomeManager.BiomeType.WARM;
	}

	static {
		GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.RAW_GENERATION, PFConfiguredFeatures.DUMMY_TREE);
	}
}


