package superlord.prehistoricfauna.world.worldtype;

import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraftforge.common.world.ForgeWorldType;

public class PFWorldType extends ForgeWorldType {
	
	public PFWorldType() {
		super(null);
	}
	
	@Override
	public ChunkGenerator createChunkGenerator(Registry<Biome> biomeRegistry, Registry<DimensionSettings> dimensionSettings, long seed, String generationSettings) {
		return new NoiseChunkGenerator(new PrehistoricWorldTypeBiomeProvider(seed, biomeRegistry), seed, () -> dimensionSettings.getOrThrow(DimensionSettings.field_242734_c));
	}
	
	@SuppressWarnings("static-access")
	@Override
	public DimensionGeneratorSettings createSettings(DynamicRegistries dynamicRegistries, long seed, boolean generateFeatures, boolean generateBonusChest, String generatorSettings) {
		Registry<Biome> biomeRegistry = dynamicRegistries.getRegistry(Registry.BIOME_KEY);
		Registry<DimensionSettings> dimensionSettingsRegistry = dynamicRegistries.getRegistry(Registry.NOISE_SETTINGS_KEY);
		Registry<DimensionType> dimensionTypeRegistry = dynamicRegistries.getRegistry(Registry.DIMENSION_TYPE_KEY);
		
		return new DimensionGeneratorSettings(seed, generateFeatures, generateBonusChest, DimensionGeneratorSettings.func_242749_a(dimensionTypeRegistry, DimensionType.OVERWORLD_TYPE.getDefaultSimpleRegistry(dimensionTypeRegistry, biomeRegistry, dimensionSettingsRegistry, seed), createChunkGenerator(biomeRegistry, dimensionSettingsRegistry, seed, null)));
	}

}
