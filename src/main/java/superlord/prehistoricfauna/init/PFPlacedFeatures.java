package superlord.prehistoricfauna.init;

import java.util.List;

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
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;

@SuppressWarnings("deprecation")
public class PFPlacedFeatures {

	public static final DeferredRegister<PlacedFeature> REGISTER = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, PrehistoricFauna.MOD_ID);

	public static final Holder<PlacedFeature> FOSSILIZED_CHALK = PlacementUtils.register("placed_fossilized_chalk", PFConfiguredFeatures.FOSSILIZED_CHALK.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
	public static final Holder<PlacedFeature> FOSSILIZED_SILTSTONE = PlacementUtils.register("placed_fossilized_siltstone", PFConfiguredFeatures.FOSSILIZED_SILTSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(39), VerticalAnchor.absolute(49))));
	public static final Holder<PlacedFeature> FOSSILIZED_SANDSTONE = PlacementUtils.register("placed_fossilized_sandstone", PFConfiguredFeatures.FOSSILIZED_SANDSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(29), VerticalAnchor.absolute(39))));

	public static final Holder<PlacedFeature> CRETACEOUS_FOSSILIZED_SILTSTONE = PlacementUtils.register("placed_cretaceous_fossilized_siltstone", PFConfiguredFeatures.FOSSILIZED_SILTSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
	public static final Holder<PlacedFeature> CRETACEOUS_FOSSILIZED_SANDSTONE = PlacementUtils.register("placed_cretaceous_fossilized_sandstone", PFConfiguredFeatures.FOSSILIZED_SANDSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(39), VerticalAnchor.absolute(49))));

	public static final Holder<PlacedFeature> JURASSIC_FOSSILIZED_SANDSTONE = PlacementUtils.register("placed_jurassic_fossilized_sandstone", PFConfiguredFeatures.FOSSILIZED_SANDSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
	
	public static final RegistryObject<PlacedFeature> RED_SANDSTONE_ROCK = REGISTER.register("placed_red_sandstone_rock", () -> new PlacedFeature(PFConfiguredFeatures.RED_SANDSTONE_ROCK.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> BIG_RED_SANDSTONE_ROCK = REGISTER.register("placed_big_red_sandstone_rock", () -> new PlacedFeature(PFConfiguredFeatures.BIG_RED_SANDSTONE_ROCK.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(3)));
	public static final RegistryObject<PlacedFeature> SANDSTONE_ROCK = REGISTER.register("placed_sandstone_rock", () -> new PlacedFeature(PFConfiguredFeatures.SANDSTONE_ROCK.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(1)));
	public static final RegistryObject<PlacedFeature> BIG_SANDSTONE_ROCK = REGISTER.register("placed_big_sandstone_rock", () -> new PlacedFeature(PFConfiguredFeatures.BIG_SANDSTONE_ROCK.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(1)));
	public static final RegistryObject<PlacedFeature> MOSSY_ROCK = REGISTER.register("placed_mossy_rock", () -> new PlacedFeature(PFConfiguredFeatures.MOSSY_ROCK.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	
	public static final RegistryObject<PlacedFeature> MARCHANTIA = REGISTER.register("placed_marchantia", () -> new PlacedFeature(PFConfiguredFeatures.MARCHANITA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> DEAD_OSMUNDACAULIS = REGISTER.register("placed_dead_osmundacaulis", () -> new PlacedFeature(PFConfiguredFeatures.DEAD_OSMUNDACAULIS.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> PLACED_PETRIFIED_TREE = REGISTER.register("placed_petrified_tree", () -> new PlacedFeature(PFConfiguredFeatures.PETRIFIED_TREE.getHolder().orElseThrow(), List.of(PlacementUtils.countExtra(1, 0.05F, 0), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> NEOCALAMITES = REGISTER.register("placed_neocalamites", () -> new PlacedFeature(PFConfiguredFeatures.NEOCALAMITES.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> ALGAE = REGISTER.register("placed_algae", () -> new PlacedFeature(PFConfiguredFeatures.ALGAE.getHolder().orElseThrow(),worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> NELUMBO = REGISTER.register("placed_nelumbo", () -> new PlacedFeature(PFConfiguredFeatures.NELUMBO.getHolder().orElseThrow(),worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> CRASSOSTREA_OYSTERS = REGISTER.register("placed_crassostrea_oysters", () -> new PlacedFeature(PFConfiguredFeatures.CRASSOSTREA_OYSTERS.getHolder().orElseThrow(),worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> MOSS = REGISTER.register("placed_moss", () -> new PlacedFeature(PFConfiguredFeatures.MOSS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(4)));
	public static final RegistryObject<PlacedFeature> HUMULUS = REGISTER.register("placed_humulus", () -> new PlacedFeature(PFConfiguredFeatures.HUMULUS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(1)));
	public static final RegistryObject<PlacedFeature> HORSETAILS = REGISTER.register("placed_horsetail", () -> new PlacedFeature(PFConfiguredFeatures.HORSETAILS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> DOUBLE_HORSETAILS = REGISTER.register("placed_double_horsetail", () -> new PlacedFeature(PFConfiguredFeatures.DOUBLE_HORSETAILS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> WATERLOGGED_HORSETAILS = REGISTER.register("placed_waterlogged_horsetail", () -> new PlacedFeature(PFConfiguredFeatures.WATERLOGGED_HORSETAILS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> CONIOPTERIS = REGISTER.register("placed_coniopteris", () -> new PlacedFeature(PFConfiguredFeatures.CONIOPTERIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> CLADOPHLEBIS = REGISTER.register("placed_cladophlebis", () -> new PlacedFeature(PFConfiguredFeatures.CLADOPHLEBIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> CLATHOPTERIS = REGISTER.register("placed_clathopteris", () -> new PlacedFeature(PFConfiguredFeatures.CLATHOPTERIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> PHLEBOPTERIS = REGISTER.register("placed_phlebopteris", () -> new PlacedFeature(PFConfiguredFeatures.PHLEBOPTERIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> OTOZAMITES = REGISTER.register("placed_otozamites", () -> new PlacedFeature(PFConfiguredFeatures.OTOZAMITES.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> TALL_OTOZAMITES = REGISTER.register("placed_tall_otozamites", () -> new PlacedFeature(PFConfiguredFeatures.DOUBLE_OTOZAMITES.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> MICHELILLOA = REGISTER.register("placed_michelilloa", () -> new PlacedFeature(PFConfiguredFeatures.MICHELILLOA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> JOHNSTONIA = REGISTER.register("placed_johnstonia", () -> new PlacedFeature(PFConfiguredFeatures.JOHNSTONIA.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> DICROIDIUM = REGISTER.register("placed_dicroidium", () -> new PlacedFeature(PFConfiguredFeatures.DICROIDIUM.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> SCYTOPHYLLUM = REGISTER.register("placed_scytophyllum", () -> new PlacedFeature(PFConfiguredFeatures.SCYTOPHYLLUM.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> LOWERED_HORSETAILS = REGISTER.register("placed_lowered_horsetails", () -> new PlacedFeature(PFConfiguredFeatures.LOWERED_HORSETAILS.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> OSMUNDACAULIS = REGISTER.register("placed_osmundacaulis", () -> new PlacedFeature(PFConfiguredFeatures.OSMUNDACAULIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> TALL_OSMUNDACAULIS = REGISTER.register("placed_tall_osmundacaulis", () -> new PlacedFeature(PFConfiguredFeatures.DOUBLE_OSMUNDACAULIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> LAUROZAMITES = REGISTER.register("placed_laurozamites", () -> new PlacedFeature(PFConfiguredFeatures.LAUROZAMITES.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> COBBANIA = REGISTER.register("placed_cobbania", () -> new PlacedFeature(PFConfiguredFeatures.COBBANIA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(2)));
	public static final RegistryObject<PlacedFeature> AZOLLA = REGISTER.register("placed_azolla", () -> new PlacedFeature(PFConfiguredFeatures.AZOLLA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(5)));
	public static final RegistryObject<PlacedFeature> OSMUNDA = REGISTER.register("placed_osmunda", () -> new PlacedFeature(PFConfiguredFeatures.OSMUNDA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(1)));
	public static final RegistryObject<PlacedFeature> ZINGIBEROPSIS = REGISTER.register("placed_zingiberopsis", () -> new PlacedFeature(PFConfiguredFeatures.ZINGIBEROPSIS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(1)));
	public static final RegistryObject<PlacedFeature> TALL_OSMUNDA = REGISTER.register("placed_tall_osmunda", () -> new PlacedFeature(PFConfiguredFeatures.DOUBLE_OSMUNDA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(1)));
	public static final RegistryObject<PlacedFeature> MARMARTHIA = REGISTER.register("placed_marmarthia", () -> new PlacedFeature(PFConfiguredFeatures.MARMARTHIA.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> COMMON_OSMUNDA = REGISTER.register("placed_common_osmunda", () -> new PlacedFeature(PFConfiguredFeatures.OSMUNDA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(6)));
	public static final RegistryObject<PlacedFeature> COMMON_TALL_OSMUNDA = REGISTER.register("placed_common_tall_osmunda", () -> new PlacedFeature(PFConfiguredFeatures.DOUBLE_OSMUNDA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(3)));
	public static final RegistryObject<PlacedFeature> RARE_LOWERED_HORSETAILS = REGISTER.register("placed_rare_lowered_horsetails", () -> new PlacedFeature(PFConfiguredFeatures.LOWERED_HORSETAILS.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> CLUBMOSS = REGISTER.register("placed_clubmoss", () -> new PlacedFeature(PFConfiguredFeatures.CLUBMOSS.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(1)));
	public static final RegistryObject<PlacedFeature> BISONIA = REGISTER.register("placed_bisonia", () -> new PlacedFeature(PFConfiguredFeatures.BISONIA.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(1)));

	public static final RegistryObject<PlacedFeature> TAXODIUM_KNEES = REGISTER.register("placed_taxodium_knees", () -> new PlacedFeature(PFConfiguredFeatures.TAXODIUM_KNEES.getHolder().orElseThrow(), worldSurfaceSquaredWithCount(4)));
	
	public static final RegistryObject<PlacedFeature> ZAMITES = REGISTER.register("placed_zamites", () -> new PlacedFeature(PFConfiguredFeatures.COMMON_ZAMITES_BUSH.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> SABALITES = REGISTER.register("placed_sabalites", () -> new PlacedFeature(PFConfiguredFeatures.COMMON_SABALITES.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> RARE_SABALITES = REGISTER.register("placed_rare_sabalites", () -> new PlacedFeature(PFConfiguredFeatures.RARE_SABALITES.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> FALLEN_DRYOPHYLLUM_LOG = REGISTER.register("placed_fallen_dryophyllum_log", () -> new PlacedFeature(PFConfiguredFeatures.FALLEN_DRYOPHYLLUM_LOG.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> FALLEN_TAXODIUM_LOG = REGISTER.register("placed_fallen_taxodium_log", () -> new PlacedFeature(PFConfiguredFeatures.FALLEN_TAXODIUM_LOG.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> FALLEN_METASEQUOIA_LOG = REGISTER.register("placed_fallen_metasequoia_log", () -> new PlacedFeature(PFConfiguredFeatures.FALLEN_METASEQUOIA_LOG.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> FALLEN_PLATANITES_LOG = REGISTER.register("placed_fallen_platanites_log", () -> new PlacedFeature(PFConfiguredFeatures.FALLEN_PLATANITES_LOG.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> FALLEN_GINKGO_LOG = REGISTER.register("placed_fallen_ginkgo_log", () -> new PlacedFeature(PFConfiguredFeatures.FALLEN_GINKGO_LOG.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));

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
	public static final RegistryObject<PlacedFeature> LARGE_ARAUCARIA_TREE_1_CHECKED = register("large_araucaria_tree_1", PFConfiguredFeatures.ARAUCARIA_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> LARGE_ARAUCARIA_TREE_2_CHECKED = register("large_araucaria_tree_2", PFConfiguredFeatures.ARAUCARIA_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> DEAD_ARAUCARIA_CHECKED = register("dead_araucaria", PFConfiguredFeatures.DEAD_ARAUCARIA, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	
	public static final RegistryObject<PlacedFeature> PROTOJUNIPEROXYLON_TREE_1_CHECKED = register("protojuniperoxylon_tree_1", PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> PROTOJUNIPEROXYLON_TREE_2_CHECKED = register("protojuniperoxylon_tree_2", PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> PROTOPICEOXYLON_TREE_1_CHECKED = register("protopiceoxylon_tree_1", PFConfiguredFeatures.PROTOPICEOXYLON_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> PROTOPICEOXYLON_TREE_2_CHECKED = register("protopiceoxylon_tree_2", PFConfiguredFeatures.PROTOPICEOXYLON_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> PROTOPICEOXYLON_TREE_3_CHECKED = register("protopiceoxylon_tree_3", PFConfiguredFeatures.PROTOPICEOXYLON_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> PROTOPICEOXYLON_TREE_4_CHECKED = register("protopiceoxylon_tree_4", PFConfiguredFeatures.PROTOPICEOXYLON_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> PROTOPICEOXYLON_TREE_5_CHECKED = register("protopiceoxylon_tree_5", PFConfiguredFeatures.PROTOPICEOXYLON_TREE_5, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> PROTOPICEOXYLON_TREE_6_CHECKED = register("protopiceoxylon_tree_6", PFConfiguredFeatures.PROTOPICEOXYLON_TREE_6, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> PROTOPICEOXYLON_TREE_7_CHECKED = register("protopiceoxylon_tree_7", PFConfiguredFeatures.PROTOPICEOXYLON_TREE_7, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	
	public static final RegistryObject<PlacedFeature> BRACHYPHYLLUM_TREE_1_CHECKED = register("brachyphyllum_tree_1", PFConfiguredFeatures.BRACHYPHYLLUM_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BRACHYPHYLLUM_TREE_2_CHECKED = register("brachyphyllum_tree_2", PFConfiguredFeatures.BRACHYPHYLLUM_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BRACHYPHYLLUM_TREE_3_CHECKED = register("brachyphyllum_tree_3", PFConfiguredFeatures.BRACHYPHYLLUM_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BRACHYPHYLLUM_TREE_4_CHECKED = register("brachyphyllum_tree_4", PFConfiguredFeatures.BRACHYPHYLLUM_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> TROCHODENDROIDES_TREE_1_CHECKED = register("trochodendroides_tree_1", PFConfiguredFeatures.TROCHODENDROIDES_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> TROCHODENDROIDES_TREE_2_CHECKED = register("trochodendroides_tree_2", PFConfiguredFeatures.TROCHODENDROIDES_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> TROCHODENDROIDES_TREE_3_CHECKED = register("trochodendroides_tree_3", PFConfiguredFeatures.TROCHODENDROIDES_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> TROCHODENDROIDES_TREE_4_CHECKED = register("trochodendroides_tree_4", PFConfiguredFeatures.TROCHODENDROIDES_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> GINKGO_TREE_1_CHECKED = register("ginkgo_tree_1", PFConfiguredFeatures.GINKGO_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> GINKGO_TREE_2_CHECKED = register("ginkgo_tree_2", PFConfiguredFeatures.GINKGO_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> GINKGO_TREE_3_CHECKED = register("ginkgo_tree_3", PFConfiguredFeatures.GINKGO_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> GINKGO_TREE_4_CHECKED = register("ginkgo_tree_4", PFConfiguredFeatures.GINKGO_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> YELLOW_GINKGO_TREE_1_CHECKED = register("yellow_ginkgo_tree_1", PFConfiguredFeatures.YELLOW_GINKGO_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> YELLOW_GINKGO_TREE_2_CHECKED = register("yellow_ginkgo_tree_2", PFConfiguredFeatures.YELLOW_GINKGO_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> YELLOW_GINKGO_TREE_3_CHECKED = register("yellow_ginkgo_tree_3", PFConfiguredFeatures.YELLOW_GINKGO_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> YELLOW_GINKGO_TREE_4_CHECKED = register("yellow_ginkgo_tree_4", PFConfiguredFeatures.YELLOW_GINKGO_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BIG_GINKGO_TREE_1_CHECKED = register("big_ginkgo_tree_1", PFConfiguredFeatures.BIG_GINKGO_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BIG_GINKGO_TREE_2_CHECKED = register("big_ginkgo_tree_2", PFConfiguredFeatures.BIG_GINKGO_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BIG_GINKGO_TREE_3_CHECKED = register("big_ginkgo_tree_3", PFConfiguredFeatures.BIG_GINKGO_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BIG_GINKGO_TREE_4_CHECKED = register("big_ginkgo_tree_4", PFConfiguredFeatures.BIG_GINKGO_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BIG_YELLOW_GINKGO_TREE_1_CHECKED = register("yellow_big_ginkgo_tree_1", PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BIG_YELLOW_GINKGO_TREE_2_CHECKED = register("yellow_big_ginkgo_tree_2", PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BIG_YELLOW_GINKGO_TREE_3_CHECKED = register("yellow_big_ginkgo_tree_3", PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> BIG_YELLOW_GINKGO_TREE_4_CHECKED = register("yellow_big_ginkgo_tree_4", PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> SMALL_METASEQUOIA_TREE_1_CHECKED = register("small_metasequoia_tree_1", PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SMALL_METASEQUOIA_TREE_2_CHECKED = register("small_metasequoia_tree_2", PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> SMALL_METASEQUOIA_TREE_3_CHECKED = register("small_metasequoia_tree_3", PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> LARGE_METASEQUOIA_TREE_1_CHECKED = register("large_metasequoia_tree_1", PFConfiguredFeatures.LARGE_METASEQUOIA_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> LARGE_METASEQUOIA_TREE_2_CHECKED = register("large_metasequoia_tree_2", PFConfiguredFeatures.LARGE_METASEQUOIA_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> TAXODIUM_TREE_1_CHECKED = register("taxodium_tree_1", PFConfiguredFeatures.TAXODIUM_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> TAXODIUM_TREE_2_CHECKED = register("taxodium_tree_2", PFConfiguredFeatures.TAXODIUM_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> TAXODIUM_TREE_3_CHECKED = register("taxodium_tree_3", PFConfiguredFeatures.TAXODIUM_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> TAXODIUM_TREE_4_CHECKED = register("taxodium_tree_4", PFConfiguredFeatures.TAXODIUM_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> TAXODIUM_TREE_5_CHECKED = register("taxodium_tree_5", PFConfiguredFeatures.TAXODIUM_TREE_5, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> TAXODIUM_TREE_6_CHECKED = register("taxodium_tree_6", PFConfiguredFeatures.TAXODIUM_TREE_6, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	
	public static final RegistryObject<PlacedFeature> DRYOPHYLLUM_TREE_1_CHECKED = register("dryophyllum_tree_1", PFConfiguredFeatures.DRYOPHYLLUM_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DRYOPHYLLUM_TREE_2_CHECKED = register("dryophyllum_tree_2", PFConfiguredFeatures.DRYOPHYLLUM_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DRYOPHYLLUM_TREE_3_CHECKED = register("dryophyllum_tree_3", PFConfiguredFeatures.DRYOPHYLLUM_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DRYOPHYLLUM_TREE_4_CHECKED = register("dryophyllum_tree_4", PFConfiguredFeatures.DRYOPHYLLUM_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DRYOPHYLLUM_TREE_5_CHECKED = register("dryophyllum_tree_5", PFConfiguredFeatures.DRYOPHYLLUM_TREE_5, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DRYOPHYLLUM_TREE_6_CHECKED = register("dryophyllum_tree_6", PFConfiguredFeatures.DRYOPHYLLUM_TREE_6, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DRYOPHYLLUM_TREE_7_CHECKED = register("dryophyllum_tree_7", PFConfiguredFeatures.DRYOPHYLLUM_TREE_7, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> DRYOPHYLLUM_TREE_8_CHECKED = register("dryophyllum_tree_8", PFConfiguredFeatures.DRYOPHYLLUM_TREE_8, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

	public static final RegistryObject<PlacedFeature> LIRIODENDRITES_TREE_1_CHECKED = register("liriodendrites_tree_1", PFConfiguredFeatures.LIRIODENDRITES_TREE_1, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> LIRIODENDRITES_TREE_2_CHECKED = register("liriodendrites_tree_2", PFConfiguredFeatures.LIRIODENDRITES_TREE_2, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> LIRIODENDRITES_TREE_3_CHECKED = register("liriodendrites_tree_3", PFConfiguredFeatures.LIRIODENDRITES_TREE_3, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	public static final RegistryObject<PlacedFeature> LIRIODENDRITES_TREE_4_CHECKED = register("liriodendrites_tree_4", PFConfiguredFeatures.LIRIODENDRITES_TREE_4, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
	
	public static final RegistryObject<PlacedFeature> CHINLE_SWAMP_TREES = register("placed_chinle_swamp_trees", PFConfiguredFeatures.CHINLE_SWAMP_TREES, PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(4), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
	public static final RegistryObject<PlacedFeature> SCHILDERIA_TREES = register("placed_schilderia_trees", PFConfiguredFeatures.SCHILDERIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> CHINLE_FLATS_TREES = register("placed_chinle_flats_trees", PFConfiguredFeatures.CHINLE_FLATS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> AGATHOXYLON_TREES = register("placed_agathoxylon_trees", PFConfiguredFeatures.AGATHOXYLON_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 2)));
	public static final RegistryObject<PlacedFeature> CHINLE_WOODED_MOUNTAINS_TREES = register("placed_chinle_wooded_mountinas_trees", PFConfiguredFeatures.CHINLE_WOODED_MOUNTAINS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 2)));
	public static final RegistryObject<PlacedFeature> ISCHIGUALASTO_TREES = register("placed_ischigualasto_trees", PFConfiguredFeatures.ISCHIGUALASTO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(8, 0.1F, 3)));
	public static final RegistryObject<PlacedFeature> SPARSE_ISCHIGUALASTO_TREES = register("placed_sparse_ischigualasto_trees", PFConfiguredFeatures.ISCHIGUALASTO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> MORRISON_TREES = register("placed_morrison_tress", PFConfiguredFeatures.MORRISON_SAVANNA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
	public static final RegistryObject<PlacedFeature> SPARSE_BRACHYPHYLLUM = register("placed_sparse_brachyphyllum", PFConfiguredFeatures.SPARSE_BRACHYPHYLLUM_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> DRY_FOREST_VEGETATION = register("placed_dry_forest_vegetation", PFConfiguredFeatures.DRY_FOREST_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.2F, 3)));
	public static final RegistryObject<PlacedFeature> SPARSE_SMALL_ARAUCARIAS = register("placed_sparse_small_araucaria", PFConfiguredFeatures.SPARSE_ARAUCARIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> TROCHODENDROIDES_TREES = register("placed_trochodendroides_trees", PFConfiguredFeatures.TROCHODENDROIDES_TREES, PlacementUtils.countExtra(0, 0.25F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
	public static final RegistryObject<PlacedFeature> ARROYO_TREES = register("placed_arroyo_trees", PFConfiguredFeatures.ARROYO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
	public static final RegistryObject<PlacedFeature> TAXODIUM_TREES = register("placed_taxodium_trees", PFConfiguredFeatures.TAXODIUM_TREES, PlacementUtils.countExtra(2, 0.25F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(4), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
	public static final RegistryObject<PlacedFeature> RARE_DRYOPHYLLUM_TREES = register("placed_rare_dryophyllum_trees", PFConfiguredFeatures.DRYOPHYLLUM_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
	public static final RegistryObject<PlacedFeature> COMMON_DRYOPHYLLUM_TREES = register("placed_common_dryophyllum_trees", PFConfiguredFeatures.DRYOPHYLLUM_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
	public static final RegistryObject<PlacedFeature> RARE_SMALL_METASEQUOIA_TREES = register("placed_rare_small_metasequoia_trees", PFConfiguredFeatures.SMALL_METASEQUOIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
	public static final RegistryObject<PlacedFeature> RARE_SMALL_GINKGO_TREES = register("placed_rare_small_ginkgo_trees", PFConfiguredFeatures.SMALL_GINKGO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
	public static final RegistryObject<PlacedFeature> RARE_TAXODIUM_TREES = register("placed_rare_taxodium_trees", PFConfiguredFeatures.TAXODIUM_TREES, PlacementUtils.countExtra(0, 0.25F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(4), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
	public static final RegistryObject<PlacedFeature> COMMON_LIRIODENDRITES_TREES = register("placed_common_liriodendrites_trees", PFConfiguredFeatures.LIRIODENDRITES_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.25F, 2)));
	public static final RegistryObject<PlacedFeature> VERY_RARE_SMALL_GINKGO_TREES = register("placed_very_rare_small_ginkgo_trees", PFConfiguredFeatures.SMALL_GINKGO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
	public static final RegistryObject<PlacedFeature> VERY_RARE_LARGE_GINKGO_TREES = register("placed_very_rare_large_ginkgo_trees", PFConfiguredFeatures.LARGE_GINKGO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
	public static final RegistryObject<PlacedFeature> RARE_SMALL_ARAUCARIA_TREES = register("placed_rare_small_araucaria_trees", PFConfiguredFeatures.SMALL_ARAUCARIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0625F, 1)));
	public static final RegistryObject<PlacedFeature> COMMON_SMALL_ARAUCARIA_TREES = register("placed_common_small_araucaria_trees", PFConfiguredFeatures.SMALL_ARAUCARIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.125F, 1)));
	public static final RegistryObject<PlacedFeature> COMMON_SMALL_METASEQUOIA_TREES = register("placed_common_small_metasequoia_trees", PFConfiguredFeatures.SMALL_METASEQUOIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.25F, 2)));
	public static final RegistryObject<PlacedFeature> LARGE_ARAUCARIA_TREES = register("placed_large_aracauria_trees", PFConfiguredFeatures.LARGE_ARAUCARIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
	public static final RegistryObject<PlacedFeature> LARGE_METASEQUOIA_TREES = register("placed_large_metasequoia_trees", PFConfiguredFeatures.LARGE_METASEQUOIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.5F, 2)));
	public static final RegistryObject<PlacedFeature> RARE_LIRIODENDRITES_TREES = register("placed_rare_liriodendrites_trees", PFConfiguredFeatures.LIRIODENDRITES_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
	public static final RegistryObject<PlacedFeature> SMALL_METASEQUOIA_TREES = register("placed_small_metasequoia_trees", PFConfiguredFeatures.SMALL_METASEQUOIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.125F, 1)));
	public static final RegistryObject<PlacedFeature> VERY_COMMON_DRYOPHYLLUM_TREES = register("placed_very_common_dryophyllum_trees", PFConfiguredFeatures.DRYOPHYLLUM_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.5F, 2)));
	public static final RegistryObject<PlacedFeature> SMALL_GINKGO_TREES = register("placed_small_ginkgo_trees", PFConfiguredFeatures.SMALL_GINKGO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
	public static final RegistryObject<PlacedFeature> RARE_LARGE_GINKGO_TREES = register("placed_rare_large_ginkgo_trees", PFConfiguredFeatures.LARGE_GINKGO_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
	public static final RegistryObject<PlacedFeature> SMALL_ARAUCARIA_TREES = register("placed_small_araucaria_trees", PFConfiguredFeatures.SMALL_ARAUCARIA_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));

	public static final RegistryObject<PlacedFeature> SILT_DISK = REGISTER.register("placed_silt_disk", () -> new PlacedFeature(PFConfiguredFeatures.DISK_SILT.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome())));

	public static final RegistryObject<PlacedFeature> PTILOPHYLLUM = REGISTER.register("placed_ptilophyllum", () -> new PlacedFeature(PFConfiguredFeatures.PTILOPHYLLUM_TREE.getHolder().orElseThrow(),  List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	
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
	
	public static void withChinleRiverPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS.getHolder().orElseThrow());
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
	
	public static void withMorrisonSavannaVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PTILOPHYLLUM.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CONIOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OSMUNDACAULIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OSMUNDACAULIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MORRISON_TREES.getHolder().orElseThrow());
	}
	
	public static void withMorrisonHillsVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_BRACHYPHYLLUM.getHolder().orElseThrow());
	}
	
	public static void withKayentaDryForestVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DRY_FOREST_VEGETATION.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OTOZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LAUROZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, RED_SANDSTONE_ROCK.getHolder().orElseThrow());
	}
	
	public static void withKayentaButtesVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_SMALL_ARAUCARIAS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OTOZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LAUROZAMITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_BRACHYPHYLLUM.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, RED_SANDSTONE_ROCK.getHolder().orElseThrow());
	}
	
	public static void withKayentaDesertRocks(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, RED_SANDSTONE_ROCK.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, BIG_RED_SANDSTONE_ROCK.getHolder().orElseThrow());
	}
	
	public static void withDjadochtaPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COBBANIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TROCHODENDROIDES_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ARROYO_TREES.getHolder().orElseThrow());
	}
	
	public static void withDjadochtaRocks(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, SANDSTONE_ROCK.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, BIG_SANDSTONE_ROCK.getHolder().orElseThrow());
	}
	
	public static void withHellCreekSwampPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLUBMOSS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARCHANTIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OSMUNDA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OSMUNDA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COBBANIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AZOLLA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TROCHODENDROIDES_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_DRYOPHYLLUM_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_GINKGO_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_METASEQUOIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TAXODIUM_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TAXODIUM_KNEES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CRASSOSTREA_OYSTERS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_TAXODIUM_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_DRYOPHYLLUM_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_PLATANITES_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NELUMBO.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZINGIBEROPSIS.getHolder().orElseThrow());
		//Platanites. Quereuxia
	}
	
	public static void withHellCreekLiriodendritesHillsPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HUMULUS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLUBMOSS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OSMUNDA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OSMUNDA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARMARTHIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AZOLLA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_DRYOPHYLLUM_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_GINKGO_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_METASEQUOIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_TAXODIUM_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_LIRIODENDRITES_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_TAXODIUM_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_DRYOPHYLLUM_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_PLATANITES_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BISONIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZINGIBEROPSIS.getHolder().orElseThrow());
		//Platanites, Nilssonia
	}
	
	public static void withHellCreekClearingPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HUMULUS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLUBMOSS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_ARAUCARIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_OSMUNDA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_TALL_OSMUNDA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SABALITES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VERY_RARE_SMALL_GINKGO_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_METASEQUOIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_PLATANITES_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG.getHolder().orElseThrow());
		//Platanites
	}
	
	public static void withHellCreekRedwoodsPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HUMULUS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_ARAUCARIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARCHANTIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_OSMUNDA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_TALL_OSMUNDA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARMARTHIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AZOLLA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TROCHODENDROIDES_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_DRYOPHYLLUM_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_SMALL_METASEQUOIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LARGE_METASEQUOIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LARGE_ARAUCARIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_GINKGO_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VERY_RARE_LARGE_GINKGO_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_TAXODIUM_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_LIRIODENDRITES_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_TAXODIUM_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_DRYOPHYLLUM_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_PLATANITES_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BISONIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZINGIBEROPSIS.getHolder().orElseThrow());
		//Platanites, Nilssonia(?), Quereuxia
	}
	
	public static void withHellCreekRiverPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARCHANTIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARMARTHIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TROCHODENDROIDES_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_DRYOPHYLLUM_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_METASEQUOIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_GINKGO_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK.getHolder().orElseThrow());
		//Quereuxia
	}
	
	public static void withHellCreekHardwoodForestPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HUMULUS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARCHANTIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARMARTHIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VERY_COMMON_DRYOPHYLLUM_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_GINKGO_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_LARGE_GINKGO_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_METASEQUOIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_ARAUCARIA_TREES.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_DRYOPHYLLUM_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_PLATANITES_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BISONIA.getHolder().orElseThrow());
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NELUMBO.getHolder().orElseThrow());
		//Platanites, Nilssonia, Quereuxia
	}
	
	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

}
