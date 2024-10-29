package superlord.prehistoricfauna.init;

import java.util.List;
import java.util.OptionalLong;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.biome.biomesource.CretaceousBiomeSource;
import superlord.prehistoricfauna.common.world.biome.biomesource.JurassicBiomeSource;
import superlord.prehistoricfauna.common.world.biome.biomesource.TriassicBiomeSource;
import superlord.prehistoricfauna.common.world.chunkgen.CretaceousChunkGenerator;
import superlord.prehistoricfauna.common.world.chunkgen.JurassicChunkGenerator;
import superlord.prehistoricfauna.common.world.chunkgen.TriassicChunkGenerator;

public class PFDimensions {
	
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, PrehistoricFauna.MOD_ID);
	
	public static final ResourceKey<DimensionType> TRIASSIC_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic"));
	public static final ResourceKey<DimensionType> JURASSIC_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic"));
	public static final ResourceKey<DimensionType> CRETACEOUS_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(PrehistoricFauna.MOD_ID, "cretaceous"));
	public static final ResourceKey<Level> TRIASSIC = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic"));
	public static final ResourceKey<Level> JURASSIC = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic"));
	public static final ResourceKey<Level> CRETACEOUS = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(PrehistoricFauna.MOD_ID, "cretaceous"));

	public static final ResourceKey<LevelStem> TRIASSIC_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic"));
	public static final ResourceKey<LevelStem> JURASSIC_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic"));
	public static final ResourceKey<LevelStem> CRETACEOUS_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(PrehistoricFauna.MOD_ID, "cretaceous"));
	public static final ResourceKey<NoiseGeneratorSettings> TRIASSIC_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic_noise_settings"));
	public static final ResourceKey<NoiseGeneratorSettings> JURASSIC_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic_noise_settings"));
	public static final ResourceKey<NoiseGeneratorSettings> CRETACEOUS_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(PrehistoricFauna.MOD_ID, "cretaceous_noise_settings"));
	
    public static final RegistryObject<PoiType> TRIASSIC_PORTAL = POI_TYPES.register("triassic_portal", () -> new PoiType(ImmutableSet.copyOf(PFBlocks.TRIASSIC_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> JURASSIC_PORTAL = POI_TYPES.register("jurassic_portal", () -> new PoiType(ImmutableSet.copyOf(PFBlocks.JURASSIC_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
    public static final RegistryObject<PoiType> CRETACEOUS_PORTAL = POI_TYPES.register("cretaceous_portal", () -> new PoiType(ImmutableSet.copyOf(PFBlocks.CRETACEOUS_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
   
    public static final RegistryObject<PoiType> BURROW = POI_TYPES.register("burrow", () -> new PoiType(ImmutableSet.copyOf(PFBlocks.BURROW.get().getStateDefinition().getPossibleStates()), 0, 1));

	public static void bootstrapType(BootstapContext<DimensionType> context) {
		context.register(CRETACEOUS_TYPE, new DimensionType(
				OptionalLong.empty(),
				true,
				false,
				false,
				true,
				1,
				true,
				false,
				-64,
				384,
				384,
				BlockTags.INFINIBURN_OVERWORLD,
				BuiltinDimensionTypes.OVERWORLD_EFFECTS,
				0F,
				new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 0), 0)));
		context.register(JURASSIC_TYPE, new DimensionType(
				OptionalLong.empty(),
				true,
				false,
				false,
				true,
				1,
				true,
				false,
				-64,
				384,
				384,
				BlockTags.INFINIBURN_OVERWORLD,
				BuiltinDimensionTypes.OVERWORLD_EFFECTS,
				0F,
				new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 0), 0)));
		context.register(TRIASSIC_TYPE, new DimensionType(
				OptionalLong.empty(),
				true,
				false,
				false,
				true,
				1,
				true,
				false,
				-64,
				384,
				384,
				BlockTags.INFINIBURN_OVERWORLD,
				BuiltinDimensionTypes.OVERWORLD_EFFECTS,
				0F,
				new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 0), 0)));
	}
	
	public static void bootstrapStem(BootstapContext<LevelStem> context) {
		HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
		HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
		HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
		context.register(CRETACEOUS_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(CRETACEOUS_TYPE), new CretaceousChunkGenerator(CretaceousBiomeSource.create(biomeRegistry), noiseGenSettings.getOrThrow(CRETACEOUS_NOISE_GEN))));
		context.register(JURASSIC_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(JURASSIC_TYPE), new JurassicChunkGenerator(JurassicBiomeSource.create(biomeRegistry), noiseGenSettings.getOrThrow(JURASSIC_NOISE_GEN))));
		context.register(TRIASSIC_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(TRIASSIC_TYPE), new TriassicChunkGenerator(TriassicBiomeSource.create(biomeRegistry), noiseGenSettings.getOrThrow(TRIASSIC_NOISE_GEN))));
	}
	
	public static void bootstrapNoise(BootstapContext<NoiseGeneratorSettings> context) {
		HolderGetter<DensityFunction> functions = context.lookup(Registries.DENSITY_FUNCTION);
		HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);
		DensityFunction densityfunction = NoiseRouterData.getFunction(functions, NoiseRouterData.SHIFT_X);
		DensityFunction densityfunction1 = NoiseRouterData.getFunction(functions, NoiseRouterData.SHIFT_Z);

		context.register(CRETACEOUS_NOISE_GEN, new NoiseGeneratorSettings(
				NoiseSettings.create(0, 128, 2, 2),
				Blocks.STONE.defaultBlockState(),
				Blocks.WATER.defaultBlockState(),
				new NoiseRouter(
						DensityFunctions.zero(), //barrier
						DensityFunctions.zero(), //fluid level floodedness
						DensityFunctions.zero(), //fluid level spread
						DensityFunctions.zero(), //lava
						DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.TEMPERATURE)), //temperature
						DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.VEGETATION)), //vegetation
						NoiseRouterData.getFunction(functions, NoiseRouterData.CONTINENTS), //continents
						NoiseRouterData.getFunction(functions, NoiseRouterData.EROSION), //erosion
						DensityFunctions.rangeChoice(
								NoiseRouterData.getFunction(functions, NoiseRouterData.Y),
								0.0D,
								32.0D,
								DensityFunctions.constant(2.0D),
								DensityFunctions.constant(-2.0D)), //depth
						NoiseRouterData.getFunction(functions, NoiseRouterData.RIDGES), //ridges
						DensityFunctions.zero(), //initial density
						DensityFunctions.zero(), //final density
						DensityFunctions.zero(), //vein toggle
						DensityFunctions.zero(), //vein ridged
						DensityFunctions.zero() //vein gap
				),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(SurfaceRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState()))
				),
				List.of(), //spawn targets
				64,
				false,
				false,
				false,
				false
		));
		context.register(JURASSIC_NOISE_GEN, new NoiseGeneratorSettings(
				NoiseSettings.create(0, 128, 2, 2),
				Blocks.STONE.defaultBlockState(),
				Blocks.WATER.defaultBlockState(),
				new NoiseRouter(
						DensityFunctions.zero(), //barrier
						DensityFunctions.zero(), //fluid level floodedness
						DensityFunctions.zero(), //fluid level spread
						DensityFunctions.zero(), //lava
						DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.TEMPERATURE)), //temperature
						DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.VEGETATION)), //vegetation
						NoiseRouterData.getFunction(functions, NoiseRouterData.CONTINENTS), //continents
						NoiseRouterData.getFunction(functions, NoiseRouterData.EROSION), //erosion
						DensityFunctions.rangeChoice(
								NoiseRouterData.getFunction(functions, NoiseRouterData.Y),
								0.0D,
								32.0D,
								DensityFunctions.constant(2.0D),
								DensityFunctions.constant(-2.0D)), //depth
						NoiseRouterData.getFunction(functions, NoiseRouterData.RIDGES), //ridges
						DensityFunctions.zero(), //initial density
						DensityFunctions.zero(), //final density
						DensityFunctions.zero(), //vein toggle
						DensityFunctions.zero(), //vein ridged
						DensityFunctions.zero() //vein gap
				),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(SurfaceRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState()))
				),
				List.of(), //spawn targets
				64,
				false,
				false,
				false,
				false
		));
		context.register(TRIASSIC_NOISE_GEN, new NoiseGeneratorSettings(
				NoiseSettings.create(0, 128, 2, 2),
				Blocks.STONE.defaultBlockState(),
				Blocks.WATER.defaultBlockState(),
				new NoiseRouter(
						DensityFunctions.zero(), //barrier
						DensityFunctions.zero(), //fluid level floodedness
						DensityFunctions.zero(), //fluid level spread
						DensityFunctions.zero(), //lava
						DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.TEMPERATURE)), //temperature
						DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.VEGETATION)), //vegetation
						NoiseRouterData.getFunction(functions, NoiseRouterData.CONTINENTS), //continents
						NoiseRouterData.getFunction(functions, NoiseRouterData.EROSION), //erosion
						DensityFunctions.rangeChoice(
								NoiseRouterData.getFunction(functions, NoiseRouterData.Y),
								0.0D,
								32.0D,
								DensityFunctions.constant(2.0D),
								DensityFunctions.constant(-2.0D)), //depth
						NoiseRouterData.getFunction(functions, NoiseRouterData.RIDGES), //ridges
						DensityFunctions.zero(), //initial density
						DensityFunctions.zero(), //final density
						DensityFunctions.zero(), //vein toggle
						DensityFunctions.zero(), //vein ridged
						DensityFunctions.zero() //vein gap
				),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(SurfaceRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState()))
				),
				List.of(), //spawn targets
				64,
				false,
				false,
				false,
				false
		));
	}
    
}
