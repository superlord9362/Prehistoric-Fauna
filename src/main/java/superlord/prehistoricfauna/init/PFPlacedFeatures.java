package superlord.prehistoricfauna.init;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import java.util.List;

@SuppressWarnings("deprecation")
public class PFPlacedFeatures {

	public static final DeferredRegister<PlacedFeature> REGISTER = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, PrehistoricFauna.MOD_ID);

	public static final Holder<PlacedFeature> FOSSILIZED_CHALK = PlacementUtils.register("placed_fossilized_chalk", PFConfiguredFeatures.FOSSILIZED_CHALK.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
	public static final Holder<PlacedFeature> FOSSILIZED_SILTSTONE = PlacementUtils.register("placed_fossilized_siltstone", PFConfiguredFeatures.FOSSILIZED_SILTSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(39), VerticalAnchor.absolute(49))));
	public static final Holder<PlacedFeature> FOSSILIZED_SANDSTONE = PlacementUtils.register("placed_fossilized_sandstone", PFConfiguredFeatures.FOSSILIZED_SANDSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(29), VerticalAnchor.absolute(39))));

	public static final Holder<PlacedFeature> CRETACEOUS_FOSSILIZED_SILTSTONE = PlacementUtils.register("placed_cretaceous_fossilized_siltstone", PFConfiguredFeatures.FOSSILIZED_SILTSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
	public static final Holder<PlacedFeature> CRETACEOUS_FOSSILIZED_SANDSTONE = PlacementUtils.register("placed_cretaceous_fossilized_sandstone", PFConfiguredFeatures.FOSSILIZED_SANDSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(39), VerticalAnchor.absolute(49))));

	public static final Holder<PlacedFeature> JURASSIC_FOSSILIZED_SANDSTONE = PlacementUtils.register("placed_jurassic_fossilized_sandstone", PFConfiguredFeatures.FOSSILIZED_SANDSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
	
	public static final RegistryObject<PlacedFeature> MARCHANTIA = REGISTER.register("placed_marchantia", () -> new PlacedFeature(PFConfiguredFeatures.MARCHANITA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> DEAD_OSMUNDACAULIS = REGISTER.register("placed_dead_osmundacaulis", () -> new PlacedFeature(PFConfiguredFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> PLACED_PETRIFIED_TREE = REGISTER.register("placed_petrified_tree", () -> new PlacedFeature(PFConfiguredFeatures.PETRIFIED_TREE.getHolder().orElseThrow(), List.of(PlacementUtils.countExtra(1, 0.05F, 0), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> NEOCALAMITES = REGISTER.register("placed_neocalamites", () -> new PlacedFeature(PFConfiguredFeatures.NEOCALAMITES.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> ALGAE = REGISTER.register("placed_algae", () -> new PlacedFeature(PFConfiguredFeatures.ALGAE.getHolder().orElseThrow(),worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> MOSS = REGISTER.register("placed_moss", () -> new PlacedFeature(PFConfiguredFeatures.MOSS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> HORSETAILS = REGISTER.register("placed_horsetail", () -> new PlacedFeature(PFConfiguredFeatures.HORSETAILS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> DOUBLE_HORSETAILS = REGISTER.register("placed_double_horsetail", () -> new PlacedFeature(PFConfiguredFeatures.DOUBLE_HORSETAILS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> WATERLOGGED_HORSETAILS = REGISTER.register("placed_waterlogged_horsetail", () -> new PlacedFeature(PFConfiguredFeatures.WATERLOGGED_HORSETAILS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> CLADOPHLEBIS = REGISTER.register("placed_cladophlebis", () -> new PlacedFeature(PFConfiguredFeatures.CLADOPHLEBIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> CLATHOPTERIS = REGISTER.register("placed_clathopteris", () -> new PlacedFeature(PFConfiguredFeatures.CLATHOPTERIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> PHLEBOPTERIS = REGISTER.register("placed_phlebopteris", () -> new PlacedFeature(PFConfiguredFeatures.PHLEBOPTERIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> OTOZAMITES = REGISTER.register("placed_otozamites", () -> new PlacedFeature(PFConfiguredFeatures.OTOZAMITES.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> MICHELILLOA = REGISTER.register("placed_michelilloa", () -> new PlacedFeature(PFConfiguredFeatures.MICHELILLOA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> JOHNSTONIA = REGISTER.register("placed_johnstonia", () -> new PlacedFeature(PFConfiguredFeatures.JOHNSTONIA.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> DICROIDIUM = REGISTER.register("placed_dicroidium", () -> new PlacedFeature(PFConfiguredFeatures.DICROIDIUM.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> SCYTOPHYLLUM = REGISTER.register("placed_scytophyllum", () -> new PlacedFeature(PFConfiguredFeatures.SCYTOPHYLLUM.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> LOWERED_HORSETAILS = REGISTER.register("placed_lowered_horsetails", () -> new PlacedFeature(PFConfiguredFeatures.LOWERED_HORSETAILS.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> ZAMITES = REGISTER.register("placed_zamites", () -> new PlacedFeature(PFConfiguredFeatures.COMMON_ZAMITES_BUSH.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	
	public static final RegistryObject<PlacedFeature> SMALL_ARAUCARIA_TREE_1 = REGISTER.register("placed_small_araucaria_tree_1", () -> new PlacedFeature(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_1.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> SMALL_ARAUCARIA_TREE_2 = REGISTER.register("placed_small_araucaria_tree_2", () -> new PlacedFeature(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_2.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> SMALL_ARAUCARIA_TREE_3 = REGISTER.register("placed_small_araucaria_tree_3", () -> new PlacedFeature(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_3.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> SMALL_ARAUCARIA_TREE_4 = REGISTER.register("placed_small_araucaria_tree_4", () -> new PlacedFeature(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_4.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> ARAUCARIA_TREE_1 = REGISTER.register("placed_araucaria_tree_1", () -> new PlacedFeature(PFConfiguredFeatures.ARAUCARIA_TREE_1.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> ARAUCARIA_TREE_2 = REGISTER.register("placed_araucaria_tree_2", () -> new PlacedFeature(PFConfiguredFeatures.ARAUCARIA_TREE_2.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> SMALL_AGATHOXYLON_TREE_1_CHECKED = register("small_agathoxylon_tree_1", PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SMALL_AGATHOXYLON_TREE_2_CHECKED = register("small_agathoxylon_tree_2", PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> MEDIUM_AGATHOXYLON_TREE_1_CHECKED = register("medium_agathoxylon_tree_1", PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> MEDIUM_AGATHOXYLON_TREE_2_CHECKED = register("medium_agathoxylon_tree_2", PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> LARGE_AGATHOXYLON_TREE_1_CHECKED = register("large_agathoxylon_tree_1", PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> LARGE_AGATHOXYLON_TREE_2_CHECKED = register("large_agathoxylon_tree_2", PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> LARGE_AGATHOXYLON_TREE_3_CHECKED = register("large_agathoxylon_tree_3", PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> SCHILDERIA_TREE_1_CHECKED = register("schilderia_tree_1", PFConfiguredFeatures.SCHILDERIA_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SCHILDERIA_TREE_2_CHECKED = register("schilderia_tree_2", PFConfiguredFeatures.SCHILDERIA_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SCHILDERIA_TREE_3_CHECKED = register("schilderia_tree_3", PFConfiguredFeatures.SCHILDERIA_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SCHILDERIA_TREE_4_CHECKED = register("schilderia_tree_4", PFConfiguredFeatures.SCHILDERIA_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	
	public static final RegistryObject<PlacedFeature> WOODWORTHIA_TREE_1_CHECKED = register("woodworthia_tree_1", PFConfiguredFeatures.WOODWORTHIA_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> WOODWORTHIA_TREE_2_CHECKED = register("woodworthia_tree_2", PFConfiguredFeatures.WOODWORTHIA_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> WOODWORTHIA_TREE_3_CHECKED = register("woodworthia_tree_3", PFConfiguredFeatures.WOODWORTHIA_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> WOODWORTHIA_TREE_4_CHECKED = register("woodworthia_tree_4", PFConfiguredFeatures.WOODWORTHIA_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		
	public static final RegistryObject<PlacedFeature> HEIDIPHYLLUM_TREE_1_CHECKED = register("heidiphyllum_tree_1", PFConfiguredFeatures.HEIDIPHYLLUM_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> HEIDIPHYLLUM_TREE_2_CHECKED = register("heidiphyllum_tree_2", PFConfiguredFeatures.HEIDIPHYLLUM_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> HEIDIPHYLLUM_TREE_3_CHECKED = register("heidiphyllum_tree_3", PFConfiguredFeatures.HEIDIPHYLLUM_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> HEIDIPHYLLUM_TREE_4_CHECKED = register("heidiphyllum_tree_4", PFConfiguredFeatures.HEIDIPHYLLUM_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> HEIDIPHYLLUM_TREE_5_CHECKED = register("heidiphyllum_tree_5", PFConfiguredFeatures.HEIDIPHYLLUM_TREE_5, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SMALL_ARAUCARIA_TREE_1_CHECKED = register("small_araucaria_tree_1", PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SMALL_ARAUCARIA_TREE_2_CHECKED = register("small_araucaria_tree_2", PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SMALL_ARAUCARIA_TREE_3_CHECKED = register("small_araucaria_tree_3", PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SMALL_ARAUCARIA_TREE_4_CHECKED = register("small_araucaria_tree_4", PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> PROTOJUNIPEROXYLON_TREE_1_CHECKED = register("protojuniperoxylon_tree_1", PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> PROTOJUNIPEROXYLON_TREE_2_CHECKED = register("protojuniperoxylon_tree_2", PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> CHINLE_SWAMP_TREES = register("placed_chinle_swamp_trees", PFConfiguredFeatures.CHINLE_SWAMP_TREES, PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(4), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
	public static final RegistryObject<PlacedFeature> SCHILDERIA_TREES = register("placed_schilderia_trees", PFConfiguredFeatures.SCHILDERIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> CHINLE_FLATS_TREES = register("placed_chinle_flats_trees", PFConfiguredFeatures.CHINLE_FLATS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> AGATHOXYLON_TREES = register("placed_agathoxylon_trees", PFConfiguredFeatures.AGATHOXYLON_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 2)));
	public static final RegistryObject<PlacedFeature> CHINLE_WOODED_MOUNTAINS_TREES = register("placed_chinle_wooded_mountinas_trees", PFConfiguredFeatures.CHINLE_WOODED_MOUNTAINS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 2)));
	public static final RegistryObject<PlacedFeature> ISCHIGUALASTO_TREES = register("placed_ischigualasto_trees", PFConfiguredFeatures.ISCHIGUALASTO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(8, 0.1F, 3)));
	public static final RegistryObject<PlacedFeature> SPARSE_ISCHIGUALASTO_TREES = register("placed_sparse_ischigualasto_trees", PFConfiguredFeatures.ISCHIGUALASTO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));

	public static final RegistryObject<PlacedFeature> SILT_DISK = REGISTER.register("placed_silt_disk", () -> new PlacedFeature(PFConfiguredFeatures.DISK_SILT.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome())));
	
	public static RegistryObject<PlacedFeature> register(String name, RegistryObject<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
		return REGISTER.register(name, () -> new PlacedFeature(feature.getHolder().orElseThrow(), modifiers));
	}
	
	public static RegistryObject<PlacedFeature> register(String name, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
		return REGISTER.register(name, () -> new PlacedFeature(feature, modifiers));
	}

	public static RegistryObject<PlacedFeature> register(String name, RegistryObject<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
		return register(name, feature, List.of(modifiers));
	}
	
	public static List<PlacementModifier> worldSurfaceSquaredWithCount(int p_195475_) {
	      return List.of(CountPlacement.of(p_195475_), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	   }
	
	public static void withChinleFlatsPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CHINLE_FLATS_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES.getHolder().orElseThrow());
	}
	
	public static void withChinleSwampPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CHINLE_SWAMP_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCHILDERIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AGATHOXYLON_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS.getHolder().orElseThrow());
	}
	
	public static void withChinleWoodedMountainsPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCHILDERIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CHINLE_WOODED_MOUNTAINS_TREES.getHolder().orElseThrow());
	}
	
	public static void withIschigualastoVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MICHELILLOA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, JOHNSTONIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DICROIDIUM.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCYTOPHYLLUM.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ISCHIGUALASTO_TREES.getHolder().orElseThrow());
	}
	
	public static void withSparseIschigualastoVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MICHELILLOA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, JOHNSTONIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DICROIDIUM.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCYTOPHYLLUM.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_ISCHIGUALASTO_TREES.getHolder().orElseThrow());
	}
	
	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

}
