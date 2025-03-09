package superlord.prehistoricfauna.init;

import java.util.Map;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterLists;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.biome.biomesource.PrehistoricBiomeSource;
import superlord.prehistoricfauna.common.world.chunkgen.PrehistoricChunkGenerator;

public class PFWorldPresets {

	public static final Map<ResourceKey<WorldPreset>, WorldPresetFactory> WORLD_PRESET_FACTORIES = new Reference2ObjectOpenHashMap<>();
	
	public static final ResourceKey<WorldPreset> PREHISTORIC = register("prehistoric", worldPresetBootstapContext -> {
		Map<ResourceKey<LevelStem>, LevelStem> stemMap = new Reference2ObjectOpenHashMap<>();
		
		HolderGetter<DimensionType> dimensionTypeLookup = worldPresetBootstapContext.lookup(Registries.DIMENSION_TYPE);
		
		HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettingsHolderGetter = worldPresetBootstapContext.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<Biome> biomesLookup = worldPresetBootstapContext.lookup(Registries.BIOME);

        LevelStem overworldStem = new LevelStem(
        		dimensionTypeLookup.getOrThrow(BuiltinDimensionTypes.OVERWORLD),
        		new PrehistoricChunkGenerator(PrehistoricBiomeSource.create(biomesLookup), noiseGeneratorSettingsHolderGetter.getOrThrow(PFDimensions.CRETACEOUS_NOISE_GEN))
        		);
        stemMap.put(LevelStem.OVERWORLD, overworldStem);
		
		LevelStem netherStem = new LevelStem(
                dimensionTypeLookup.getOrThrow(BuiltinDimensionTypes.NETHER),
                new NoiseBasedChunkGenerator(
                        MultiNoiseBiomeSource.createFromPreset(worldPresetBootstapContext.lookup(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST).getOrThrow(MultiNoiseBiomeSourceParameterLists.NETHER)),
                        noiseGeneratorSettingsHolderGetter.getOrThrow(NoiseGeneratorSettings.NETHER)
                )
        );
        stemMap.put(LevelStem.NETHER, netherStem);


        LevelStem endStem = new LevelStem(
                dimensionTypeLookup.getOrThrow(BuiltinDimensionTypes.END),
                new NoiseBasedChunkGenerator(TheEndBiomeSource.create(biomesLookup),
                        noiseGeneratorSettingsHolderGetter.getOrThrow(NoiseGeneratorSettings.END)
                )
        );
        stemMap.put(LevelStem.END, endStem);

        return new WorldPreset(stemMap);
	});
	
	private static ResourceKey<WorldPreset> register(String id, WorldPresetFactory factory) {
		ResourceKey<WorldPreset> worldPresetResourceKey = ResourceKey.create(Registries.WORLD_PRESET, new ResourceLocation(PrehistoricFauna.MOD_ID, id));
		WORLD_PRESET_FACTORIES.put(worldPresetResourceKey, factory);
		return worldPresetResourceKey;
	}
	
	public static void init() {
		
	}
	
	@FunctionalInterface
	public interface WorldPresetFactory {
		WorldPreset generate(BootstapContext<WorldPreset> worldPresetBootstapContext);
	}
	
}
