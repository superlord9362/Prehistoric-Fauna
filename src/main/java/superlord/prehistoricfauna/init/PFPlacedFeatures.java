package superlord.prehistoricfauna.init;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
import superlord.prehistoricfauna.PrehistoricFauna;

@SuppressWarnings("deprecation")
public class PFPlacedFeatures {

	public static void init() { }

	public static final ResourceKey<PlacedFeature> FOSSILIZED_CHALK = registerPlacedFeature("placed_fossilized_chalk");
	public static final ResourceKey<PlacedFeature> FOSSILIZED_SILTSTONE = registerPlacedFeature("placed_fossilized_siltstone");
	public static final ResourceKey<PlacedFeature> FOSSILIZED_SANDSTONE = registerPlacedFeature("placed_fossilized_sandstone");

	public static final ResourceKey<PlacedFeature> CRETACEOUS_FOSSILIZED_SILTSTONE = registerPlacedFeature("placed_cretaceous_fossilized_siltstone");
	public static final ResourceKey<PlacedFeature> CRETACEOUS_FOSSILIZED_SANDSTONE = registerPlacedFeature("placed_cretaceous_fossilized_sandstone");

	public static final ResourceKey<PlacedFeature> JURASSIC_FOSSILIZED_SANDSTONE = registerPlacedFeature("placed_jurassic_fossilized_sandstone");

	public static final ResourceKey<PlacedFeature> HENOSTONE_ORE = registerPlacedFeature("placed_henostone_ore");

	public static final ResourceKey<PlacedFeature> RED_SANDSTONE_ROCK = registerPlacedFeature("placed_red_sandstone_rock");
	public static final ResourceKey<PlacedFeature> BIG_RED_SANDSTONE_ROCK = registerPlacedFeature("placed_big_red_sandstone_rock");
	public static final ResourceKey<PlacedFeature> SANDSTONE_ROCK = registerPlacedFeature("placed_sandstone_rock");
	public static final ResourceKey<PlacedFeature> BIG_SANDSTONE_ROCK = registerPlacedFeature("placed_big_sandstone_rock");
	public static final ResourceKey<PlacedFeature> MOSSY_ROCK = registerPlacedFeature("placed_mossy_rock");

	public static final ResourceKey<PlacedFeature> MARCHANTIA = registerPlacedFeature("placed_marchantia");
	public static final ResourceKey<PlacedFeature> DEAD_OSMUNDACAULIS = registerPlacedFeature("placed_dead_osmundacaulis");
	public static final ResourceKey<PlacedFeature> PLACED_PETRIFIED_TREE = registerPlacedFeature("placed_petrified_tree");

	public static final ResourceKey<PlacedFeature> NEOCALAMITES = registerPlacedFeature("placed_neocalamites");
	public static final ResourceKey<PlacedFeature> ALGAE = registerPlacedFeature("placed_algae");
	public static final ResourceKey<PlacedFeature> NELUMBO = registerPlacedFeature("placed_nelumbo");
	public static final ResourceKey<PlacedFeature> QUEREUXIA = registerPlacedFeature("placed_quereuxia");
	public static final ResourceKey<PlacedFeature> D_QUEREUXIA = registerPlacedFeature("placed_d_quereuxia");
	public static final ResourceKey<PlacedFeature> CRASSOSTREA_OYSTERS = registerPlacedFeature("placed_crassostrea_oysters");
	public static final ResourceKey<PlacedFeature> MOSS = registerPlacedFeature("placed_moss");
	public static final ResourceKey<PlacedFeature> ASH = registerPlacedFeature("placed_ash");
	public static final ResourceKey<PlacedFeature> HUMULUS = registerPlacedFeature("placed_humulus");
	public static final ResourceKey<PlacedFeature> HORSETAILS = registerPlacedFeature("placed_horsetail");
	public static final ResourceKey<PlacedFeature> DOUBLE_HORSETAILS = registerPlacedFeature("placed_double_horsetail");
	public static final ResourceKey<PlacedFeature> WATERLOGGED_HORSETAILS = registerPlacedFeature("placed_waterlogged_horsetail");
	public static final ResourceKey<PlacedFeature> CONIOPTERIS = registerPlacedFeature("placed_coniopteris");
	public static final ResourceKey<PlacedFeature> CLADOPHLEBIS = registerPlacedFeature("placed_cladophlebis");
	public static final ResourceKey<PlacedFeature> CLATHOPTERIS = registerPlacedFeature("placed_clathopteris");
	public static final ResourceKey<PlacedFeature> PHLEBOPTERIS = registerPlacedFeature("placed_phlebopteris");
	public static final ResourceKey<PlacedFeature> OTOZAMITES = registerPlacedFeature("placed_otozamites");
	public static final ResourceKey<PlacedFeature> TALL_OTOZAMITES = registerPlacedFeature("placed_tall_otozamites");
	public static final ResourceKey<PlacedFeature> MICHELILLOA = registerPlacedFeature("placed_michelilloa");
	public static final ResourceKey<PlacedFeature> JOHNSTONIA = registerPlacedFeature("placed_johnstonia");
	public static final ResourceKey<PlacedFeature> DICROIDIUM = registerPlacedFeature("placed_dicroidium");
	public static final ResourceKey<PlacedFeature> SCYTOPHYLLUM = registerPlacedFeature("placed_scytophyllum");
	public static final ResourceKey<PlacedFeature> LOWERED_HORSETAILS = registerPlacedFeature("placed_lowered_horsetails");
	public static final ResourceKey<PlacedFeature> OSMUNDACAULIS = registerPlacedFeature("placed_osmundacaulis");
	public static final ResourceKey<PlacedFeature> TALL_OSMUNDACAULIS = registerPlacedFeature("placed_tall_osmundacaulis");
	public static final ResourceKey<PlacedFeature> LAUROZAMITES = registerPlacedFeature("placed_laurozamites");
	public static final ResourceKey<PlacedFeature> COBBANIA = registerPlacedFeature("placed_cobbania");
	public static final ResourceKey<PlacedFeature> AZOLLA = registerPlacedFeature("placed_azolla");
	public static final ResourceKey<PlacedFeature> OSMUNDA = registerPlacedFeature("placed_osmunda");
	public static final ResourceKey<PlacedFeature> ZINGIBEROPSIS = registerPlacedFeature("placed_zingiberopsis");
	public static final ResourceKey<PlacedFeature> TALL_OSMUNDA = registerPlacedFeature("placed_tall_osmunda");
	public static final ResourceKey<PlacedFeature> MARMARTHIA = registerPlacedFeature("placed_marmarthia");
	public static final ResourceKey<PlacedFeature> COMMON_OSMUNDA = registerPlacedFeature("placed_common_osmunda");
	public static final ResourceKey<PlacedFeature> COMMON_TALL_OSMUNDA = registerPlacedFeature("placed_common_tall_osmunda");
	public static final ResourceKey<PlacedFeature> VERY_COMMON_OSMUNDA = registerPlacedFeature("placed_very_common_osmunda");
	public static final ResourceKey<PlacedFeature> VERY_COMMON_TALL_OSMUNDA = registerPlacedFeature("placed_very_common_tall_osmunda");
	public static final ResourceKey<PlacedFeature> RARE_LOWERED_HORSETAILS = registerPlacedFeature("placed_rare_lowered_horsetails");
	public static final ResourceKey<PlacedFeature> VERY_RARE_LOWERED_HORSETAILS = registerPlacedFeature("placed_very_rare_lowered_horsetails");
	public static final ResourceKey<PlacedFeature> CLUBMOSS = registerPlacedFeature("placed_clubmoss");
	public static final ResourceKey<PlacedFeature> BISONIA = registerPlacedFeature("placed_bisonia");
	public static final ResourceKey<PlacedFeature> ARCHAEFRUCTUS = registerPlacedFeature("placed_archaefructus");
	public static final ResourceKey<PlacedFeature> TALL_ARCHAEFRUCTUS = registerPlacedFeature("placed_tall_archaefructus");
	public static final ResourceKey<PlacedFeature> EPHEDRA = registerPlacedFeature("placed_ephedra");
	public static final ResourceKey<PlacedFeature> LEEFRUCTUS = registerPlacedFeature("placed_leefructus");
	public static final ResourceKey<PlacedFeature> RUFFORDIA = registerPlacedFeature("placed_ruffordia");

	public static final ResourceKey<PlacedFeature> CALLIANTHUS = registerPlacedFeature("placed_callianthus");
	public static final ResourceKey<PlacedFeature> NOTHODICHOCARPUM = registerPlacedFeature("placed_nothodichocarpum");

	public static final ResourceKey<PlacedFeature> TAXODIUM_KNEES = registerPlacedFeature("placed_taxodium_knees");

	public static final ResourceKey<PlacedFeature> ZAMITES = registerPlacedFeature("placed_zamites");
	public static final ResourceKey<PlacedFeature> SABALITES = registerPlacedFeature("placed_sabalites");
	public static final ResourceKey<PlacedFeature> RARE_SABALITES = registerPlacedFeature("placed_rare_sabalites");

	public static final ResourceKey<PlacedFeature> FALLEN_DRYOPHYLLUM_LOG = registerPlacedFeature("placed_fallen_dryophyllum_log");
	public static final ResourceKey<PlacedFeature> FALLEN_TAXODIUM_LOG = registerPlacedFeature("placed_fallen_taxodium_log");
	public static final ResourceKey<PlacedFeature> FALLEN_METASEQUOIA_LOG = registerPlacedFeature("placed_fallen_metasequoia_log");
	public static final ResourceKey<PlacedFeature> FALLEN_PLATANITES_LOG = registerPlacedFeature("placed_fallen_platanites_log");
	public static final ResourceKey<PlacedFeature> FALLEN_GINKGO_LOG = registerPlacedFeature("placed_fallen_ginkgo_log");

	public static final ResourceKey<PlacedFeature> SMALL_ARAUCARIA_TREE_1 = registerPlacedFeature("placed_small_araucaria_tree_1");
	public static final ResourceKey<PlacedFeature> SMALL_ARAUCARIA_TREE_2 = registerPlacedFeature("placed_small_araucaria_tree_2");
	public static final ResourceKey<PlacedFeature> SMALL_ARAUCARIA_TREE_3 = registerPlacedFeature("placed_small_araucaria_tree_3");
	public static final ResourceKey<PlacedFeature> SMALL_ARAUCARIA_TREE_4 = registerPlacedFeature("placed_small_araucaria_tree_4");
	public static final ResourceKey<PlacedFeature> ARAUCARIA_TREE_1 = registerPlacedFeature("placed_araucaria_tree_1");
	public static final ResourceKey<PlacedFeature> ARAUCARIA_TREE_2 = registerPlacedFeature("placed_araucaria_tree_2");

	public static final ResourceKey<PlacedFeature> SMALL_AGATHOXYLON_TREE_1_CHECKED = registerPlacedFeature("small_agathoxylon_tree_1");
	public static final ResourceKey<PlacedFeature> SMALL_AGATHOXYLON_TREE_2_CHECKED = registerPlacedFeature("small_agathoxylon_tree_2");
	public static final ResourceKey<PlacedFeature> MEDIUM_AGATHOXYLON_TREE_1_CHECKED = registerPlacedFeature("medium_agathoxylon_tree_1");
	public static final ResourceKey<PlacedFeature> MEDIUM_AGATHOXYLON_TREE_2_CHECKED = registerPlacedFeature("medium_agathoxylon_tree_2");
	public static final ResourceKey<PlacedFeature> LARGE_AGATHOXYLON_TREE_1_CHECKED = registerPlacedFeature("large_agathoxylon_tree_1");
	public static final ResourceKey<PlacedFeature> LARGE_AGATHOXYLON_TREE_2_CHECKED = registerPlacedFeature("large_agathoxylon_tree_2");
	public static final ResourceKey<PlacedFeature> LARGE_AGATHOXYLON_TREE_3_CHECKED = registerPlacedFeature("large_agathoxylon_tree_3");

	public static final ResourceKey<PlacedFeature> SCHILDERIA_TREE_1_CHECKED = registerPlacedFeature("schilderia_tree_1");
	public static final ResourceKey<PlacedFeature> SCHILDERIA_TREE_2_CHECKED = registerPlacedFeature("schilderia_tree_2");
	public static final ResourceKey<PlacedFeature> SCHILDERIA_TREE_3_CHECKED = registerPlacedFeature("schilderia_tree_3");
	public static final ResourceKey<PlacedFeature> SCHILDERIA_TREE_4_CHECKED = registerPlacedFeature("schilderia_tree_4");

	public static final ResourceKey<PlacedFeature> WOODWORTHIA_TREE_1_CHECKED = registerPlacedFeature("woodworthia_tree_1");
	public static final ResourceKey<PlacedFeature> WOODWORTHIA_TREE_2_CHECKED = registerPlacedFeature("woodworthia_tree_2");
	public static final ResourceKey<PlacedFeature> WOODWORTHIA_TREE_3_CHECKED = registerPlacedFeature("woodworthia_tree_3");
	public static final ResourceKey<PlacedFeature> WOODWORTHIA_TREE_4_CHECKED = registerPlacedFeature("woodworthia_tree_4");

	public static final ResourceKey<PlacedFeature> HEIDIPHYLLUM_TREE_1_CHECKED = registerPlacedFeature("heidiphyllum_tree_1");
	public static final ResourceKey<PlacedFeature> HEIDIPHYLLUM_TREE_2_CHECKED = registerPlacedFeature("heidiphyllum_tree_2");
	public static final ResourceKey<PlacedFeature> HEIDIPHYLLUM_TREE_3_CHECKED = registerPlacedFeature("heidiphyllum_tree_3");
	public static final ResourceKey<PlacedFeature> HEIDIPHYLLUM_TREE_4_CHECKED = registerPlacedFeature("heidiphyllum_tree_4");
	public static final ResourceKey<PlacedFeature> HEIDIPHYLLUM_TREE_5_CHECKED = registerPlacedFeature("heidiphyllum_tree_5");

	public static final ResourceKey<PlacedFeature> SMALL_ARAUCARIA_TREE_1_CHECKED = registerPlacedFeature("small_araucaria_tree_1");
	public static final ResourceKey<PlacedFeature> SMALL_ARAUCARIA_TREE_2_CHECKED = registerPlacedFeature("small_araucaria_tree_2");
	public static final ResourceKey<PlacedFeature> SMALL_ARAUCARIA_TREE_3_CHECKED = registerPlacedFeature("small_araucaria_tree_3");
	public static final ResourceKey<PlacedFeature> SMALL_ARAUCARIA_TREE_4_CHECKED = registerPlacedFeature("small_araucaria_tree_4");
	public static final ResourceKey<PlacedFeature> LARGE_ARAUCARIA_TREE_1_CHECKED = registerPlacedFeature("large_araucaria_tree_1");
	public static final ResourceKey<PlacedFeature> LARGE_ARAUCARIA_TREE_2_CHECKED = registerPlacedFeature("large_araucaria_tree_2");

	public static final ResourceKey<PlacedFeature> DEAD_ARAUCARIA_CHECKED = registerPlacedFeature("dead_araucaria");

	public static final ResourceKey<PlacedFeature> PROTOJUNIPEROXYLON_TREE_1_CHECKED = registerPlacedFeature("protojuniperoxylon_tree_1");
	public static final ResourceKey<PlacedFeature> PROTOJUNIPEROXYLON_TREE_2_CHECKED = registerPlacedFeature("protojuniperoxylon_tree_2");

	public static final ResourceKey<PlacedFeature> PROTOPICEOXYLON_TREE_1_CHECKED = registerPlacedFeature("protopiceoxylon_tree_1");
	public static final ResourceKey<PlacedFeature> PROTOPICEOXYLON_TREE_2_CHECKED = registerPlacedFeature("protopiceoxylon_tree_2");
	public static final ResourceKey<PlacedFeature> PROTOPICEOXYLON_TREE_3_CHECKED = registerPlacedFeature("protopiceoxylon_tree_3");
	public static final ResourceKey<PlacedFeature> PROTOPICEOXYLON_TREE_4_CHECKED = registerPlacedFeature("protopiceoxylon_tree_4");
	public static final ResourceKey<PlacedFeature> PROTOPICEOXYLON_TREE_5_CHECKED = registerPlacedFeature("protopiceoxylon_tree_5");
	public static final ResourceKey<PlacedFeature> PROTOPICEOXYLON_TREE_6_CHECKED = registerPlacedFeature("protopiceoxylon_tree_6");
	public static final ResourceKey<PlacedFeature> PROTOPICEOXYLON_TREE_7_CHECKED = registerPlacedFeature("protopiceoxylon_tree_7");

	public static final ResourceKey<PlacedFeature> BRACHYPHYLLUM_TREE_1_CHECKED = registerPlacedFeature("brachyphyllum_tree_1");
	public static final ResourceKey<PlacedFeature> BRACHYPHYLLUM_TREE_2_CHECKED = registerPlacedFeature("brachyphyllum_tree_2");
	public static final ResourceKey<PlacedFeature> BRACHYPHYLLUM_TREE_3_CHECKED = registerPlacedFeature("brachyphyllum_tree_3");
	public static final ResourceKey<PlacedFeature> BRACHYPHYLLUM_TREE_4_CHECKED = registerPlacedFeature("brachyphyllum_tree_4");

	public static final ResourceKey<PlacedFeature> TROCHODENDROIDES_TREE_1_CHECKED = registerPlacedFeature("trochodendroides_tree_1");
	public static final ResourceKey<PlacedFeature> TROCHODENDROIDES_TREE_2_CHECKED = registerPlacedFeature("trochodendroides_tree_2");
	public static final ResourceKey<PlacedFeature> TROCHODENDROIDES_TREE_3_CHECKED = registerPlacedFeature("trochodendroides_tree_3");
	public static final ResourceKey<PlacedFeature> TROCHODENDROIDES_TREE_4_CHECKED = registerPlacedFeature("trochodendroides_tree_4");

	public static final ResourceKey<PlacedFeature> GINKGO_TREE_1_CHECKED = registerPlacedFeature("ginkgo_tree_1");
	public static final ResourceKey<PlacedFeature> GINKGO_TREE_2_CHECKED = registerPlacedFeature("ginkgo_tree_2");
	public static final ResourceKey<PlacedFeature> GINKGO_TREE_3_CHECKED = registerPlacedFeature("ginkgo_tree_3");
	public static final ResourceKey<PlacedFeature> GINKGO_TREE_4_CHECKED = registerPlacedFeature("ginkgo_tree_4");
	public static final ResourceKey<PlacedFeature> YELLOW_GINKGO_TREE_1_CHECKED = registerPlacedFeature("yellow_ginkgo_tree_1");
	public static final ResourceKey<PlacedFeature> YELLOW_GINKGO_TREE_2_CHECKED = registerPlacedFeature("yellow_ginkgo_tree_2");
	public static final ResourceKey<PlacedFeature> YELLOW_GINKGO_TREE_3_CHECKED = registerPlacedFeature("yellow_ginkgo_tree_3");
	public static final ResourceKey<PlacedFeature> YELLOW_GINKGO_TREE_4_CHECKED = registerPlacedFeature("yellow_ginkgo_tree_4");
	public static final ResourceKey<PlacedFeature> BIG_GINKGO_TREE_1_CHECKED = registerPlacedFeature("big_ginkgo_tree_1");
	public static final ResourceKey<PlacedFeature> BIG_GINKGO_TREE_2_CHECKED = registerPlacedFeature("big_ginkgo_tree_2");
	public static final ResourceKey<PlacedFeature> BIG_GINKGO_TREE_3_CHECKED = registerPlacedFeature("big_ginkgo_tree_3");
	public static final ResourceKey<PlacedFeature> BIG_GINKGO_TREE_4_CHECKED = registerPlacedFeature("big_ginkgo_tree_4");
	public static final ResourceKey<PlacedFeature> BIG_YELLOW_GINKGO_TREE_1_CHECKED = registerPlacedFeature("yellow_big_ginkgo_tree_1");
	public static final ResourceKey<PlacedFeature> BIG_YELLOW_GINKGO_TREE_2_CHECKED = registerPlacedFeature("yellow_big_ginkgo_tree_2");
	public static final ResourceKey<PlacedFeature> BIG_YELLOW_GINKGO_TREE_3_CHECKED = registerPlacedFeature("yellow_big_ginkgo_tree_3");
	public static final ResourceKey<PlacedFeature> BIG_YELLOW_GINKGO_TREE_4_CHECKED = registerPlacedFeature("yellow_big_ginkgo_tree_4");

	public static final ResourceKey<PlacedFeature> SMALL_METASEQUOIA_TREE_1_CHECKED = registerPlacedFeature("small_metasequoia_tree_1");
	public static final ResourceKey<PlacedFeature> SMALL_METASEQUOIA_TREE_2_CHECKED = registerPlacedFeature("small_metasequoia_tree_2");
	public static final ResourceKey<PlacedFeature> SMALL_METASEQUOIA_TREE_3_CHECKED = registerPlacedFeature("small_metasequoia_tree_3");
	public static final ResourceKey<PlacedFeature> LARGE_METASEQUOIA_TREE_1_CHECKED = registerPlacedFeature("large_metasequoia_tree_1");
	public static final ResourceKey<PlacedFeature> LARGE_METASEQUOIA_TREE_2_CHECKED = registerPlacedFeature("large_metasequoia_tree_2");

	public static final ResourceKey<PlacedFeature> TAXODIUM_TREE_1_CHECKED = registerPlacedFeature("taxodium_tree_1");
	public static final ResourceKey<PlacedFeature> TAXODIUM_TREE_2_CHECKED = registerPlacedFeature("taxodium_tree_2");
	public static final ResourceKey<PlacedFeature> TAXODIUM_TREE_3_CHECKED = registerPlacedFeature("taxodium_tree_3");
	public static final ResourceKey<PlacedFeature> TAXODIUM_TREE_4_CHECKED = registerPlacedFeature("taxodium_tree_4");
	public static final ResourceKey<PlacedFeature> TAXODIUM_TREE_5_CHECKED = registerPlacedFeature("taxodium_tree_5");
	public static final ResourceKey<PlacedFeature> TAXODIUM_TREE_6_CHECKED = registerPlacedFeature("taxodium_tree_6");

	public static final ResourceKey<PlacedFeature> DRYOPHYLLUM_TREE_1_CHECKED = registerPlacedFeature("dryophyllum_tree_1");
	public static final ResourceKey<PlacedFeature> DRYOPHYLLUM_TREE_2_CHECKED = registerPlacedFeature("dryophyllum_tree_2");
	public static final ResourceKey<PlacedFeature> DRYOPHYLLUM_TREE_3_CHECKED = registerPlacedFeature("dryophyllum_tree_3");
	public static final ResourceKey<PlacedFeature> DRYOPHYLLUM_TREE_4_CHECKED = registerPlacedFeature("dryophyllum_tree_4");
	public static final ResourceKey<PlacedFeature> DRYOPHYLLUM_TREE_5_CHECKED = registerPlacedFeature("dryophyllum_tree_5");
	public static final ResourceKey<PlacedFeature> DRYOPHYLLUM_TREE_6_CHECKED = registerPlacedFeature("dryophyllum_tree_6");
	public static final ResourceKey<PlacedFeature> DRYOPHYLLUM_TREE_7_CHECKED = registerPlacedFeature("dryophyllum_tree_7");
	public static final ResourceKey<PlacedFeature> DRYOPHYLLUM_TREE_8_CHECKED = registerPlacedFeature("dryophyllum_tree_8");

	public static final ResourceKey<PlacedFeature> LIRIODENDRITES_TREE_1_CHECKED = registerPlacedFeature("liriodendrites_tree_1");
	public static final ResourceKey<PlacedFeature> LIRIODENDRITES_TREE_2_CHECKED = registerPlacedFeature("liriodendrites_tree_2");
	public static final ResourceKey<PlacedFeature> LIRIODENDRITES_TREE_3_CHECKED = registerPlacedFeature("liriodendrites_tree_3");
	public static final ResourceKey<PlacedFeature> LIRIODENDRITES_TREE_4_CHECKED = registerPlacedFeature("liriodendrites_tree_4");

	public static final ResourceKey<PlacedFeature> LARGE_PLATANITES_TREE_1_CHECKED = registerPlacedFeature("large_platanites_tree_1");
	public static final ResourceKey<PlacedFeature> LARGE_PLATANITES_TREE_2_CHECKED = registerPlacedFeature("large_platanites_tree_2");
	public static final ResourceKey<PlacedFeature> LARGE_PLATANITES_TREE_3_CHECKED = registerPlacedFeature("large_platanites_tree_3");
	public static final ResourceKey<PlacedFeature> SMALL_PLATANITES_TREE_1_CHECKED = registerPlacedFeature("small_platanites_tree_1");
	public static final ResourceKey<PlacedFeature> SMALL_PLATANITES_TREE_2_CHECKED = registerPlacedFeature("small_platanites_tree_2");
	public static final ResourceKey<PlacedFeature> SMALL_PLATANITES_TREE_3_CHECKED = registerPlacedFeature("small_platanites_tree_3");
	public static final ResourceKey<PlacedFeature> SMALL_PLATANITES_TREE_4_CHECKED = registerPlacedFeature("small_platanites_tree_4");

	public static final ResourceKey<PlacedFeature> TAXUS_TREE_1 = registerPlacedFeature("taxus_tree_1");
	public static final ResourceKey<PlacedFeature> TAXUS_TREE_2 = registerPlacedFeature("taxus_tree_2");
	public static final ResourceKey<PlacedFeature> TAXUS_TREE_3 = registerPlacedFeature("taxus_tree_3");
	public static final ResourceKey<PlacedFeature> TAXUS_TREE_4 = registerPlacedFeature("taxus_tree_4");
	public static final ResourceKey<PlacedFeature> TAXUS_TREE_5 = registerPlacedFeature("taxus_tree_5");
	public static final ResourceKey<PlacedFeature> TAXUS_TREE_6 = registerPlacedFeature("taxus_tree_6");
	public static final ResourceKey<PlacedFeature> TAXUS_TREE_7 = registerPlacedFeature("taxus_tree_7");
	public static final ResourceKey<PlacedFeature> TAXUS_TREE_8 = registerPlacedFeature("taxus_tree_8");

	public static final ResourceKey<PlacedFeature> CZEKANOWSKIA_TREE_1 = registerPlacedFeature("czekanowskia_tree_1");
	public static final ResourceKey<PlacedFeature> CZEKANOWSKIA_TREE_2 = registerPlacedFeature("czekanowskia_tree_2");
	public static final ResourceKey<PlacedFeature> CZEKANOWSKIA_TREE_3 = registerPlacedFeature("czekanowskia_tree_3");
	public static final ResourceKey<PlacedFeature> CZEKANOWSKIA_TREE_4 = registerPlacedFeature("czekanowskia_tree_4");
	public static final ResourceKey<PlacedFeature> CZEKANOWSKIA_TREE_5 = registerPlacedFeature("czekanowskia_tree_5");
	public static final ResourceKey<PlacedFeature> CZEKANOWSKIA_TREE_6 = registerPlacedFeature("czekanowskia_tree_6");

	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREE_1 = registerPlacedFeature("schizolepidopsis_tree_1");
	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREE_2 = registerPlacedFeature("schizolepidopsis_tree_2");
	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREE_3 = registerPlacedFeature("schizolepidopsis_tree_3");
	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREE_4 = registerPlacedFeature("schizolepidopsis_tree_4");
	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREE_5 = registerPlacedFeature("schizolepidopsis_tree_5");
	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREE_6 = registerPlacedFeature("schizolepidopsis_tree_6");
	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREE_7 = registerPlacedFeature("schizolepidopsis_tree_7");
	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREE_8 = registerPlacedFeature("schizolepidopsis_tree_8");
	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREE_9 = registerPlacedFeature("schizolepidopsis_tree_9");

	public static final ResourceKey<PlacedFeature> DEAD_TAXUS_TREE_1 = registerPlacedFeature("dead_taxus_tree_1");
	public static final ResourceKey<PlacedFeature> DEAD_TAXUS_TREE_2 = registerPlacedFeature("dead_taxus_tree_2");
	public static final ResourceKey<PlacedFeature> DEAD_TAXUS_TREE_3 = registerPlacedFeature("dead_taxus_tree_3");
	public static final ResourceKey<PlacedFeature> DEAD_TAXUS_TREE_4 = registerPlacedFeature("dead_taxus_tree_4");
	public static final ResourceKey<PlacedFeature> DEAD_TAXUS_TREE_5 = registerPlacedFeature("dead_taxus_tree_5");
	public static final ResourceKey<PlacedFeature> DEAD_TAXUS_TREE_6 = registerPlacedFeature("dead_taxus_tree_6");
	public static final ResourceKey<PlacedFeature> DEAD_TAXUS_TREE_7 = registerPlacedFeature("dead_taxus_tree_7");
	public static final ResourceKey<PlacedFeature> DEAD_TAXUS_TREE_8 = registerPlacedFeature("dead_taxus_tree_8");

	public static final ResourceKey<PlacedFeature> DEAD_CZEKANOWSKIA_TREE_1 = registerPlacedFeature("cdead_zekanowskia_tree_1");
	public static final ResourceKey<PlacedFeature> DEAD_CZEKANOWSKIA_TREE_2 = registerPlacedFeature("dead_czekanowskia_tree_2");
	public static final ResourceKey<PlacedFeature> DEAD_CZEKANOWSKIA_TREE_3 = registerPlacedFeature("dead_czekanowskia_tree_3");
	public static final ResourceKey<PlacedFeature> DEAD_CZEKANOWSKIA_TREE_4 = registerPlacedFeature("dead_czekanowskia_tree_4");
	public static final ResourceKey<PlacedFeature> DEAD_CZEKANOWSKIA_TREE_5 = registerPlacedFeature("dead_czekanowskia_tree_5");
	public static final ResourceKey<PlacedFeature> DEAD_CZEKANOWSKIA_TREE_6 = registerPlacedFeature("dead_czekanowskia_tree_6");

	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREE_1 = registerPlacedFeature("dead_schizolepidopsis_tree_1");
	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREE_2 = registerPlacedFeature("dead_schizolepidopsis_tree_2");
	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREE_3 = registerPlacedFeature("dead_schizolepidopsis_tree_3");
	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREE_4 = registerPlacedFeature("dead_schizolepidopsis_tree_4");
	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREE_5 = registerPlacedFeature("dead_schizolepidopsis_tree_5");
	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREE_6 = registerPlacedFeature("dead_schizolepidopsis_tree_6");
	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREE_7 = registerPlacedFeature("dead_schizolepidopsis_tree_7");
	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREE_8 = registerPlacedFeature("dead_schizolepidopsis_tree_8");
	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREE_9 = registerPlacedFeature("dead_schizolepidopsis_tree_9");

	public static final ResourceKey<PlacedFeature> PODOZAMITES_TREE_1 = registerPlacedFeature("podozamties_tree_1");
	public static final ResourceKey<PlacedFeature> PODOZAMITES_TREE_2 = registerPlacedFeature("podozamties_tree_2");
	public static final ResourceKey<PlacedFeature> PODOZAMITES_TREE_3 = registerPlacedFeature("podozamties_tree_3");
	public static final ResourceKey<PlacedFeature> PODOZAMITES_TREE_4 = registerPlacedFeature("podozamties_tree_4");
	public static final ResourceKey<PlacedFeature> PODOZAMITES_TREE_5 = registerPlacedFeature("podozamties_tree_5");
	public static final ResourceKey<PlacedFeature> PODOZAMITES_TREE_6 = registerPlacedFeature("podozamties_tree_6");

	public static final ResourceKey<PlacedFeature> DEAD_PODOZAMITES_TREE_1 = registerPlacedFeature("dead_podozamties_tree_1");
	public static final ResourceKey<PlacedFeature> DEAD_PODOZAMITES_TREE_2 = registerPlacedFeature("dead_podozamties_tree_2");
	public static final ResourceKey<PlacedFeature> DEAD_PODOZAMITES_TREE_3 = registerPlacedFeature("dead_podozamties_tree_3");
	public static final ResourceKey<PlacedFeature> DEAD_PODOZAMITES_TREE_4 = registerPlacedFeature("dead_podozamties_tree_4");
	public static final ResourceKey<PlacedFeature> DEAD_PODOZAMITES_TREE_5 = registerPlacedFeature("dead_podozamties_tree_5");
	public static final ResourceKey<PlacedFeature> DEAD_PODOZAMITES_TREE_6 = registerPlacedFeature("dead_podozamties_tree_6");

	public static final ResourceKey<PlacedFeature> CHINLE_SWAMP_TREES = registerPlacedFeature("placed_chinle_swamp_trees");
	public static final ResourceKey<PlacedFeature> SCHILDERIA_TREES = registerPlacedFeature("placed_schilderia_trees");
	public static final ResourceKey<PlacedFeature> CHINLE_FLATS_TREES = registerPlacedFeature("placed_chinle_flats_trees");
	public static final ResourceKey<PlacedFeature> AGATHOXYLON_TREES = registerPlacedFeature("placed_agathoxylon_trees");
	public static final ResourceKey<PlacedFeature> CHINLE_WOODED_MOUNTAINS_TREES = registerPlacedFeature("placed_chinle_wooded_mountinas_trees");
	public static final ResourceKey<PlacedFeature> ISCHIGUALASTO_TREES = registerPlacedFeature("placed_ischigualasto_trees");
	public static final ResourceKey<PlacedFeature> SPARSE_ISCHIGUALASTO_TREES = registerPlacedFeature("placed_sparse_ischigualasto_trees");
	public static final ResourceKey<PlacedFeature> MORRISON_TREES = registerPlacedFeature("placed_morrison_tress");
	public static final ResourceKey<PlacedFeature> SPARSE_BRACHYPHYLLUM = registerPlacedFeature("placed_sparse_brachyphyllum");
	public static final ResourceKey<PlacedFeature> DRY_FOREST_VEGETATION = registerPlacedFeature("placed_dry_forest_vegetation");
	public static final ResourceKey<PlacedFeature> SPARSE_SMALL_ARAUCARIAS = registerPlacedFeature("placed_sparse_small_araucaria");
	public static final ResourceKey<PlacedFeature> TROCHODENDROIDES_TREES = registerPlacedFeature("placed_trochodendroides_trees");
	public static final ResourceKey<PlacedFeature> ARROYO_TREES = registerPlacedFeature("placed_arroyo_trees");
	public static final ResourceKey<PlacedFeature> TAXODIUM_TREES = registerPlacedFeature("placed_taxodium_trees");
	public static final ResourceKey<PlacedFeature> RARE_DRYOPHYLLUM_TREES = registerPlacedFeature("placed_rare_dryophyllum_trees");
	public static final ResourceKey<PlacedFeature> COMMON_DRYOPHYLLUM_TREES = registerPlacedFeature("placed_common_dryophyllum_trees");
	public static final ResourceKey<PlacedFeature> RARE_SMALL_METASEQUOIA_TREES = registerPlacedFeature("placed_rare_small_metasequoia_trees");
	public static final ResourceKey<PlacedFeature> RARE_SMALL_GINKGO_TREES = registerPlacedFeature("placed_rare_small_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> RARE_TAXODIUM_TREES = registerPlacedFeature("placed_rare_taxodium_trees");
	public static final ResourceKey<PlacedFeature> COMMON_LIRIODENDRITES_TREES = registerPlacedFeature("placed_common_liriodendrites_trees");
	public static final ResourceKey<PlacedFeature> VERY_RARE_SMALL_GINKGO_TREES = registerPlacedFeature("placed_very_rare_small_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> VERY_RARE_LARGE_GINKGO_TREES = registerPlacedFeature("placed_very_rare_large_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> RARE_SMALL_ARAUCARIA_TREES = registerPlacedFeature("placed_rare_small_araucaria_trees");
	public static final ResourceKey<PlacedFeature> COMMON_SMALL_ARAUCARIA_TREES = registerPlacedFeature("placed_common_small_araucaria_trees");
	public static final ResourceKey<PlacedFeature> COMMON_SMALL_METASEQUOIA_TREES = registerPlacedFeature("placed_common_small_metasequoia_trees");
	public static final ResourceKey<PlacedFeature> LARGE_ARAUCARIA_TREES = registerPlacedFeature("placed_large_aracauria_trees");
	public static final ResourceKey<PlacedFeature> LARGE_METASEQUOIA_TREES = registerPlacedFeature("placed_large_metasequoia_trees");
	public static final ResourceKey<PlacedFeature> RARE_LIRIODENDRITES_TREES = registerPlacedFeature("placed_rare_liriodendrites_trees");
	public static final ResourceKey<PlacedFeature> SMALL_METASEQUOIA_TREES = registerPlacedFeature("placed_small_metasequoia_trees");
	public static final ResourceKey<PlacedFeature> VERY_COMMON_DRYOPHYLLUM_TREES = registerPlacedFeature("placed_very_common_dryophyllum_trees");
	public static final ResourceKey<PlacedFeature> SMALL_GINKGO_TREES = registerPlacedFeature("placed_small_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> RARE_LARGE_GINKGO_TREES = registerPlacedFeature("placed_rare_large_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> SMALL_MIXED_GINKGO_TREES = registerPlacedFeature("placed_small_mixed_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> RARE_MIXED_LARGE_GINKGO_TREES = registerPlacedFeature("placed_rare_large_mixed_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> SMALL_YELLOW_GINKGO_TREES = registerPlacedFeature("placed_small_yellow_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> RARE_SMALL_YELLOW_GINKGO_TREES = registerPlacedFeature("placed_rare_small_yellow_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> RARE_YELLOW_LARGE_GINKGO_TREES = registerPlacedFeature("placed_rare_large_yellow_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> SMALL_ARAUCARIA_TREES = registerPlacedFeature("placed_small_araucaria_trees");
	public static final ResourceKey<PlacedFeature> SMALL_PLATANITES_TREES = registerPlacedFeature("placed_small_platanites_trees");
	public static final ResourceKey<PlacedFeature> PLATANITES_TREES = registerPlacedFeature("placed_platanites_trees");
	public static final ResourceKey<PlacedFeature> RARE_PLATANITES_TREES = registerPlacedFeature("placed_rare_platanites_trees");
	public static final ResourceKey<PlacedFeature> TAXUS_TREES = registerPlacedFeature("placed_taxus_trees");
	public static final ResourceKey<PlacedFeature> PODOZAMITES_TREES = registerPlacedFeature("placed_podozamites_trees");
	public static final ResourceKey<PlacedFeature> RARE_TAXUS_TREES = registerPlacedFeature("placed_rare_taxus_trees");
	public static final ResourceKey<PlacedFeature> RARE_PODOZAMITES_TREES = registerPlacedFeature("placed_rare_podozamites_trees");
	public static final ResourceKey<PlacedFeature> RARE_SCHIZOLEPIDOPSIS_TREES = registerPlacedFeature("placed_rare_schizolepidopsis_trees");
	public static final ResourceKey<PlacedFeature> RARE_CZEKANOWSKIA_TREES = registerPlacedFeature("placed_rare_czekanowskia_trees");
	public static final ResourceKey<PlacedFeature> SCHIZOLEPIDOPSIS_TREES = registerPlacedFeature("placed_schizolepidopsis_trees");
	public static final ResourceKey<PlacedFeature> CZEKANOWSKIA_TREES = registerPlacedFeature("placed_czekanowskia_trees");
	public static final ResourceKey<PlacedFeature> DEAD_TAXUS_TREES = registerPlacedFeature("placed_dead_taxus_trees");
	public static final ResourceKey<PlacedFeature> DEAD_SCHIZOLEPIDOPSIS_TREES = registerPlacedFeature("placed_dead_schizolepidopsis_trees");
	public static final ResourceKey<PlacedFeature> DEAD_PODOZAMITES_TREES = registerPlacedFeature("placed_dead_podozamites_trees");
	public static final ResourceKey<PlacedFeature> DEAD_CZEKANOWSKIA_TREES = registerPlacedFeature("placed_dead_czekanowskia_trees");

	public static final ResourceKey<PlacedFeature> CLEARING_HUMULUS = registerPlacedFeature("placed_clearing_humulus");
	public static final ResourceKey<PlacedFeature> CLEARING_CLUBMOSS = registerPlacedFeature("placed_clearing_clubmoss");
	public static final ResourceKey<PlacedFeature> CLEARING_RARE_SMALL_ARAUCARIA_TREES = registerPlacedFeature("placed_clearing_rare_small_araucaria_trees");
	public static final ResourceKey<PlacedFeature> CLEARING_VERY_COMMON_OSMUNDA = registerPlacedFeature("placed_clearing_very_common_osmunda");
	public static final ResourceKey<PlacedFeature> CLEARING_VERY_COMMON_TALL_OSMUNDA = registerPlacedFeature("placed_clearing_very_common_tall_osmunda");
	public static final ResourceKey<PlacedFeature> CLEARING_VERY_RARE_LOWERED_HORSETAILS = registerPlacedFeature("placed_clearing_very_rare_lowered_horsetails");
	public static final ResourceKey<PlacedFeature> CLEARING_SABALITES = registerPlacedFeature("placed_clearing_sabalites");
	public static final ResourceKey<PlacedFeature> CLEARING_VERY_RARE_SMALL_GINKGO_TREES = registerPlacedFeature("placed_clearing_very_rare_small_ginkgo_trees");
	public static final ResourceKey<PlacedFeature> CLEARING_RARE_SMALL_METASEQUOIA_TREES = registerPlacedFeature("placed_clearing_rare_small_metasequoia_trees");
	public static final ResourceKey<PlacedFeature> CLEARING_FALLEN_METASEQUOIA_LOG = registerPlacedFeature("placed_clearing_fallen_metasequoia_log");
	public static final ResourceKey<PlacedFeature> CLEARING_FALLEN_PLATANITES_LOG = registerPlacedFeature("placed_clearing_fallen_platanites_log");
	public static final ResourceKey<PlacedFeature> CLEARING_FALLEN_GINKGO_LOG = registerPlacedFeature("placed_clearing_fallen_ginkgo_log");
	public static final ResourceKey<PlacedFeature> CLEARING_RARE_PLATANITES_TREES = registerPlacedFeature("placed_clearing_rare_platanites_trees");

	public static final ResourceKey<PlacedFeature> SILT_DISK = registerPlacedFeature("placed_silt_disk");
	public static final ResourceKey<PlacedFeature> MUD_DISK = registerPlacedFeature("placed_mud_disk");
	public static final ResourceKey<PlacedFeature> PACKED_MUD_DISK = registerPlacedFeature("placed_packed_mud_disk");

	public static final ResourceKey<PlacedFeature> PTILOPHYLLUM = registerPlacedFeature("placed_ptilophyllum");


	public static void bootstrap(BootstapContext<PlacedFeature> bootstapContext) {
		HolderGetter<ConfiguredFeature<?, ?>> holderGetter = bootstapContext.lookup(Registries.CONFIGURED_FEATURE);
		PlacementUtils.register(bootstapContext, FOSSILIZED_CHALK, holderGetter.getOrThrow(PFConfiguredFeatures.FOSSILIZED_CHALK), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
		PlacementUtils.register(bootstapContext, FOSSILIZED_SILTSTONE, holderGetter.getOrThrow(PFConfiguredFeatures.FOSSILIZED_SILTSTONE), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(39), VerticalAnchor.absolute(49))));
		PlacementUtils.register(bootstapContext, FOSSILIZED_SANDSTONE, holderGetter.getOrThrow(PFConfiguredFeatures.FOSSILIZED_SANDSTONE), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(29), VerticalAnchor.absolute(39))));

		PlacementUtils.register(bootstapContext, CRETACEOUS_FOSSILIZED_SILTSTONE, holderGetter.getOrThrow(PFConfiguredFeatures.FOSSILIZED_SILTSTONE), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
		PlacementUtils.register(bootstapContext, CRETACEOUS_FOSSILIZED_SANDSTONE, holderGetter.getOrThrow(PFConfiguredFeatures.FOSSILIZED_SANDSTONE), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(39), VerticalAnchor.absolute(49))));

		PlacementUtils.register(bootstapContext, JURASSIC_FOSSILIZED_SANDSTONE, holderGetter.getOrThrow(PFConfiguredFeatures.FOSSILIZED_SANDSTONE), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));

		PlacementUtils.register(bootstapContext, HENOSTONE_ORE, holderGetter.getOrThrow(PFConfiguredFeatures.ORE_HENOSTONE), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(60))));

		PlacementUtils.register(bootstapContext, RED_SANDSTONE_ROCK, holderGetter.getOrThrow(PFConfiguredFeatures.RED_SANDSTONE_ROCK), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, BIG_RED_SANDSTONE_ROCK, holderGetter.getOrThrow(PFConfiguredFeatures.BIG_RED_SANDSTONE_ROCK), worldSurfaceSquaredWithCount(3));
		PlacementUtils.register(bootstapContext, SANDSTONE_ROCK, holderGetter.getOrThrow(PFConfiguredFeatures.SANDSTONE_ROCK), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, BIG_SANDSTONE_ROCK, holderGetter.getOrThrow(PFConfiguredFeatures.BIG_SANDSTONE_ROCK), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, MOSSY_ROCK, holderGetter.getOrThrow(PFConfiguredFeatures.MOSSY_ROCK), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

		PlacementUtils.register(bootstapContext, MARCHANTIA, holderGetter.getOrThrow(PFConfiguredFeatures.MARCHANITA), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, DEAD_OSMUNDACAULIS, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_OSMUNDACAULIS), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, PLACED_PETRIFIED_TREE, holderGetter.getOrThrow(PFConfiguredFeatures.PETRIFIED_TREE), List.of(PlacementUtils.countExtra(1, 0.05F, 0), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

		PlacementUtils.register(bootstapContext, NEOCALAMITES, holderGetter.getOrThrow(PFConfiguredFeatures.NEOCALAMITES), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, ALGAE, holderGetter.getOrThrow(PFConfiguredFeatures.ALGAE), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, NELUMBO, holderGetter.getOrThrow(PFConfiguredFeatures.NELUMBO), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, QUEREUXIA, holderGetter.getOrThrow(PFConfiguredFeatures.QUEREUXIA), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, D_QUEREUXIA, holderGetter.getOrThrow(PFConfiguredFeatures.QUEREUXIA), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, CRASSOSTREA_OYSTERS, holderGetter.getOrThrow(PFConfiguredFeatures.CRASSOSTREA_OYSTERS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, MOSS, holderGetter.getOrThrow(PFConfiguredFeatures.MOSS), worldSurfaceSquaredWithCount(4));
		PlacementUtils.register(bootstapContext, ASH, holderGetter.getOrThrow(PFConfiguredFeatures.ASH), worldSurfaceSquaredWithCount(4));
		PlacementUtils.register(bootstapContext, HUMULUS, holderGetter.getOrThrow(PFConfiguredFeatures.HUMULUS), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, HORSETAILS, holderGetter.getOrThrow(PFConfiguredFeatures.HORSETAILS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, DOUBLE_HORSETAILS, holderGetter.getOrThrow(PFConfiguredFeatures.DOUBLE_HORSETAILS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, WATERLOGGED_HORSETAILS, holderGetter.getOrThrow(PFConfiguredFeatures.WATERLOGGED_HORSETAILS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, CONIOPTERIS, holderGetter.getOrThrow(PFConfiguredFeatures.CONIOPTERIS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, CLADOPHLEBIS, holderGetter.getOrThrow(PFConfiguredFeatures.CLADOPHLEBIS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, CLATHOPTERIS, holderGetter.getOrThrow(PFConfiguredFeatures.CLATHOPTERIS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, PHLEBOPTERIS, holderGetter.getOrThrow(PFConfiguredFeatures.PHLEBOPTERIS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, OTOZAMITES, holderGetter.getOrThrow(PFConfiguredFeatures.OTOZAMITES), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, TALL_OTOZAMITES, holderGetter.getOrThrow(PFConfiguredFeatures.DOUBLE_OTOZAMITES), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, MICHELILLOA, holderGetter.getOrThrow(PFConfiguredFeatures.MICHELILLOA), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, JOHNSTONIA, holderGetter.getOrThrow(PFConfiguredFeatures.JOHNSTONIA), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, DICROIDIUM, holderGetter.getOrThrow(PFConfiguredFeatures.DICROIDIUM), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, SCYTOPHYLLUM, holderGetter.getOrThrow(PFConfiguredFeatures.SCYTOPHYLLUM), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, LOWERED_HORSETAILS, holderGetter.getOrThrow(PFConfiguredFeatures.LOWERED_HORSETAILS), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, OSMUNDACAULIS, holderGetter.getOrThrow(PFConfiguredFeatures.OSMUNDACAULIS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, TALL_OSMUNDACAULIS, holderGetter.getOrThrow(PFConfiguredFeatures.DOUBLE_OSMUNDACAULIS), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, LAUROZAMITES, holderGetter.getOrThrow(PFConfiguredFeatures.LAUROZAMITES), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, COBBANIA, holderGetter.getOrThrow(PFConfiguredFeatures.COBBANIA), worldSurfaceSquaredWithCount(2));
		PlacementUtils.register(bootstapContext, AZOLLA, holderGetter.getOrThrow(PFConfiguredFeatures.AZOLLA), worldSurfaceSquaredWithCount(5));
		PlacementUtils.register(bootstapContext, OSMUNDA, holderGetter.getOrThrow(PFConfiguredFeatures.OSMUNDA), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, ZINGIBEROPSIS, holderGetter.getOrThrow(PFConfiguredFeatures.ZINGIBEROPSIS), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, TALL_OSMUNDA, holderGetter.getOrThrow(PFConfiguredFeatures.DOUBLE_OSMUNDA), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, MARMARTHIA, holderGetter.getOrThrow(PFConfiguredFeatures.MARMARTHIA), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, COMMON_OSMUNDA, holderGetter.getOrThrow(PFConfiguredFeatures.OSMUNDA), worldSurfaceSquaredWithCount(6));
		PlacementUtils.register(bootstapContext, COMMON_TALL_OSMUNDA, holderGetter.getOrThrow(PFConfiguredFeatures.DOUBLE_OSMUNDA), worldSurfaceSquaredWithCount(3));
		PlacementUtils.register(bootstapContext, VERY_COMMON_OSMUNDA, holderGetter.getOrThrow(PFConfiguredFeatures.OSMUNDA), worldSurfaceSquaredWithCount(12));
		PlacementUtils.register(bootstapContext, VERY_COMMON_TALL_OSMUNDA, holderGetter.getOrThrow(PFConfiguredFeatures.DOUBLE_OSMUNDA), worldSurfaceSquaredWithCount(6));
		PlacementUtils.register(bootstapContext, RARE_LOWERED_HORSETAILS, holderGetter.getOrThrow(PFConfiguredFeatures.LOWERED_HORSETAILS), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, VERY_RARE_LOWERED_HORSETAILS, holderGetter.getOrThrow(PFConfiguredFeatures.RARE_LOWERED_HORSETAILS), List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, CLUBMOSS, holderGetter.getOrThrow(PFConfiguredFeatures.CLUBMOSS), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, BISONIA, holderGetter.getOrThrow(PFConfiguredFeatures.BISONIA), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, ARCHAEFRUCTUS, holderGetter.getOrThrow(PFConfiguredFeatures.ARCHAEFRUCTUS), worldSurfaceSquaredWithCount(4));
		PlacementUtils.register(bootstapContext, TALL_ARCHAEFRUCTUS, holderGetter.getOrThrow(PFConfiguredFeatures.DOUBLE_ARCHAEFRUCTUS), worldSurfaceSquaredWithCount(3));
		PlacementUtils.register(bootstapContext, EPHEDRA, holderGetter.getOrThrow(PFConfiguredFeatures.EPHEDRA), worldSurfaceSquaredWithCount(3));
		PlacementUtils.register(bootstapContext, LEEFRUCTUS, holderGetter.getOrThrow(PFConfiguredFeatures.LEEFRUCTUS), worldSurfaceSquaredWithCount(3));
		PlacementUtils.register(bootstapContext, RUFFORDIA, holderGetter.getOrThrow(PFConfiguredFeatures.RUFFORDIA), worldSurfaceSquaredWithCount(3));

		PlacementUtils.register(bootstapContext, CALLIANTHUS, holderGetter.getOrThrow(PFConfiguredFeatures.CALLIANTHUS), worldSurfaceSquaredWithCount(5));
		PlacementUtils.register(bootstapContext, NOTHODICHOCARPUM, holderGetter.getOrThrow(PFConfiguredFeatures.NOTHODICHOCARPUM), worldSurfaceSquaredWithCount(2));

		PlacementUtils.register(bootstapContext, TAXODIUM_KNEES, holderGetter.getOrThrow(PFConfiguredFeatures.TAXODIUM_KNEES), worldSurfaceSquaredWithCount(4));

		PlacementUtils.register(bootstapContext, ZAMITES, holderGetter.getOrThrow(PFConfiguredFeatures.COMMON_ZAMITES_BUSH), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, SABALITES, holderGetter.getOrThrow(PFConfiguredFeatures.COMMON_SABALITES), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, RARE_SABALITES, holderGetter.getOrThrow(PFConfiguredFeatures.RARE_SABALITES), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

		PlacementUtils.register(bootstapContext, FALLEN_DRYOPHYLLUM_LOG, holderGetter.getOrThrow(PFConfiguredFeatures.FALLEN_DRYOPHYLLUM_LOG), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, FALLEN_TAXODIUM_LOG, holderGetter.getOrThrow(PFConfiguredFeatures.FALLEN_TAXODIUM_LOG), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, FALLEN_METASEQUOIA_LOG, holderGetter.getOrThrow(PFConfiguredFeatures.FALLEN_METASEQUOIA_LOG), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, FALLEN_PLATANITES_LOG, holderGetter.getOrThrow(PFConfiguredFeatures.FALLEN_PLATANITES_LOG), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, FALLEN_GINKGO_LOG, holderGetter.getOrThrow(PFConfiguredFeatures.FALLEN_GINKGO_LOG), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

		PlacementUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_1), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_2), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_3, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_3), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_4, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_4), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, ARAUCARIA_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.ARAUCARIA_TREE_1), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, ARAUCARIA_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.ARAUCARIA_TREE_2), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

		PlacementUtils.register(bootstapContext, SMALL_AGATHOXYLON_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_AGATHOXYLON_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, MEDIUM_AGATHOXYLON_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, MEDIUM_AGATHOXYLON_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LARGE_AGATHOXYLON_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LARGE_AGATHOXYLON_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LARGE_AGATHOXYLON_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, SCHILDERIA_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SCHILDERIA_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHILDERIA_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SCHILDERIA_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHILDERIA_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SCHILDERIA_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHILDERIA_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SCHILDERIA_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, WOODWORTHIA_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.WOODWORTHIA_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, WOODWORTHIA_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.WOODWORTHIA_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, WOODWORTHIA_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.WOODWORTHIA_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, WOODWORTHIA_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.WOODWORTHIA_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.HEIDIPHYLLUM_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.HEIDIPHYLLUM_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.HEIDIPHYLLUM_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.HEIDIPHYLLUM_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_5_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.HEIDIPHYLLUM_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LARGE_ARAUCARIA_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.ARAUCARIA_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LARGE_ARAUCARIA_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.ARAUCARIA_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, DEAD_ARAUCARIA_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_ARAUCARIA), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, PROTOJUNIPEROXYLON_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PROTOJUNIPEROXYLON_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.PROTOPICEOXYLON_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.PROTOPICEOXYLON_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.PROTOPICEOXYLON_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.PROTOPICEOXYLON_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_5_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.PROTOPICEOXYLON_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_6_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.PROTOPICEOXYLON_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_7_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.PROTOPICEOXYLON_TREE_7), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, BRACHYPHYLLUM_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.BRACHYPHYLLUM_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BRACHYPHYLLUM_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.BRACHYPHYLLUM_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BRACHYPHYLLUM_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.BRACHYPHYLLUM_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BRACHYPHYLLUM_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.BRACHYPHYLLUM_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, TROCHODENDROIDES_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TROCHODENDROIDES_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TROCHODENDROIDES_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TROCHODENDROIDES_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TROCHODENDROIDES_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TROCHODENDROIDES_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TROCHODENDROIDES_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TROCHODENDROIDES_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, GINKGO_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.GINKGO_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, GINKGO_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.GINKGO_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, GINKGO_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.GINKGO_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, GINKGO_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.GINKGO_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, YELLOW_GINKGO_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.YELLOW_GINKGO_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, YELLOW_GINKGO_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.YELLOW_GINKGO_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, YELLOW_GINKGO_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.YELLOW_GINKGO_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, YELLOW_GINKGO_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.YELLOW_GINKGO_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BIG_GINKGO_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.BIG_GINKGO_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BIG_GINKGO_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.BIG_GINKGO_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BIG_GINKGO_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.BIG_GINKGO_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BIG_GINKGO_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.BIG_GINKGO_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BIG_YELLOW_GINKGO_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BIG_YELLOW_GINKGO_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BIG_YELLOW_GINKGO_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, BIG_YELLOW_GINKGO_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, SMALL_METASEQUOIA_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_METASEQUOIA_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_METASEQUOIA_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LARGE_METASEQUOIA_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_METASEQUOIA_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LARGE_METASEQUOIA_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_METASEQUOIA_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, TAXODIUM_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TAXODIUM_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXODIUM_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TAXODIUM_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXODIUM_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TAXODIUM_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXODIUM_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TAXODIUM_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXODIUM_TREE_5_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TAXODIUM_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXODIUM_TREE_6_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.TAXODIUM_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, DRYOPHYLLUM_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DRYOPHYLLUM_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DRYOPHYLLUM_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DRYOPHYLLUM_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DRYOPHYLLUM_TREE_5_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DRYOPHYLLUM_TREE_6_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DRYOPHYLLUM_TREE_7_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREE_7), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DRYOPHYLLUM_TREE_8_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREE_8), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, LIRIODENDRITES_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LIRIODENDRITES_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LIRIODENDRITES_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LIRIODENDRITES_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LIRIODENDRITES_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LIRIODENDRITES_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LIRIODENDRITES_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LIRIODENDRITES_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, LARGE_PLATANITES_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_PLATANITES_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LARGE_PLATANITES_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_PLATANITES_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, LARGE_PLATANITES_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_PLATANITES_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_PLATANITES_TREE_1_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_PLATANITES_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_PLATANITES_TREE_2_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_PLATANITES_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_PLATANITES_TREE_3_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_PLATANITES_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SMALL_PLATANITES_TREE_4_CHECKED, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_PLATANITES_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, TAXUS_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXUS_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXUS_TREE_3, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXUS_TREE_4, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXUS_TREE_5, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXUS_TREE_6, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXUS_TREE_7, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREE_7), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, TAXUS_TREE_8, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREE_8), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, CZEKANOWSKIA_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.CZEKANOWSKIA_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, CZEKANOWSKIA_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.CZEKANOWSKIA_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, CZEKANOWSKIA_TREE_3, holderGetter.getOrThrow(PFConfiguredFeatures.CZEKANOWSKIA_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, CZEKANOWSKIA_TREE_4, holderGetter.getOrThrow(PFConfiguredFeatures.CZEKANOWSKIA_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, CZEKANOWSKIA_TREE_5, holderGetter.getOrThrow(PFConfiguredFeatures.CZEKANOWSKIA_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, CZEKANOWSKIA_TREE_6, holderGetter.getOrThrow(PFConfiguredFeatures.CZEKANOWSKIA_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_3, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_4, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_5, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_6, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_7, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_7), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_8, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_8), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_9, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_9), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, DEAD_TAXUS_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_TAXUS_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_TAXUS_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_TAXUS_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_TAXUS_TREE_3, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_TAXUS_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_TAXUS_TREE_4, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_TAXUS_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_TAXUS_TREE_5, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_TAXUS_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_TAXUS_TREE_6, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_TAXUS_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_TAXUS_TREE_7, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_TAXUS_TREE_7), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_TAXUS_TREE_8, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_TAXUS_TREE_8), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_CZEKANOWSKIA_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_CZEKANOWSKIA_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_3, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_CZEKANOWSKIA_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_4, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_CZEKANOWSKIA_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_5, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_CZEKANOWSKIA_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_6, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_CZEKANOWSKIA_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_3, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_4, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_5, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_6, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_7, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_7), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_8, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_8), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_9, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_9), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, PODOZAMITES_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.PODOZAMITES_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PODOZAMITES_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.PODOZAMITES_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PODOZAMITES_TREE_3, holderGetter.getOrThrow(PFConfiguredFeatures.PODOZAMITES_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PODOZAMITES_TREE_4, holderGetter.getOrThrow(PFConfiguredFeatures.PODOZAMITES_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PODOZAMITES_TREE_5, holderGetter.getOrThrow(PFConfiguredFeatures.PODOZAMITES_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, PODOZAMITES_TREE_6, holderGetter.getOrThrow(PFConfiguredFeatures.PODOZAMITES_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_1, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_PODOZAMITES_TREE_1), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_2, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_PODOZAMITES_TREE_2), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_3, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_PODOZAMITES_TREE_3), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_4, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_PODOZAMITES_TREE_4), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_5, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_PODOZAMITES_TREE_5), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_6, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_PODOZAMITES_TREE_6), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

		PlacementUtils.register(bootstapContext, CHINLE_SWAMP_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.CHINLE_SWAMP_TREES), PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(4), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
		PlacementUtils.register(bootstapContext, SCHILDERIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SCHILDERIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
		PlacementUtils.register(bootstapContext, CHINLE_FLATS_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.CHINLE_FLATS_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(bootstapContext, AGATHOXYLON_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.AGATHOXYLON_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 2)));
		PlacementUtils.register(bootstapContext, CHINLE_WOODED_MOUNTAINS_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.CHINLE_WOODED_MOUNTAINS_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 2)));
		PlacementUtils.register(bootstapContext, ISCHIGUALASTO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.ISCHIGUALASTO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(8, 0.1F, 3)));
		PlacementUtils.register(bootstapContext, SPARSE_ISCHIGUALASTO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.ISCHIGUALASTO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
		PlacementUtils.register(bootstapContext, MORRISON_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.MORRISON_SAVANNA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, SPARSE_BRACHYPHYLLUM, holderGetter.getOrThrow(PFConfiguredFeatures.SPARSE_BRACHYPHYLLUM_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
		PlacementUtils.register(bootstapContext, DRY_FOREST_VEGETATION, holderGetter.getOrThrow(PFConfiguredFeatures.DRY_FOREST_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.2F, 3)));
		PlacementUtils.register(bootstapContext, SPARSE_SMALL_ARAUCARIAS, holderGetter.getOrThrow(PFConfiguredFeatures.SPARSE_ARAUCARIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
		PlacementUtils.register(bootstapContext, TROCHODENDROIDES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.TROCHODENDROIDES_TREES), PlacementUtils.countExtra(0, 0.25F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
		PlacementUtils.register(bootstapContext, ARROYO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.ARROYO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, TAXODIUM_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.TAXODIUM_TREES), PlacementUtils.countExtra(2, 0.25F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(4), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
		PlacementUtils.register(bootstapContext, RARE_DRYOPHYLLUM_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, COMMON_DRYOPHYLLUM_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
		PlacementUtils.register(bootstapContext, RARE_SMALL_METASEQUOIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_METASEQUOIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, RARE_SMALL_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, RARE_TAXODIUM_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.TAXODIUM_TREES), PlacementUtils.countExtra(0, 0.25F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(4), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
		PlacementUtils.register(bootstapContext, COMMON_LIRIODENDRITES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.LIRIODENDRITES_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.25F, 2)));
		PlacementUtils.register(bootstapContext, VERY_RARE_SMALL_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, VERY_RARE_LARGE_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, RARE_SMALL_ARAUCARIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0625F, 1)));
		PlacementUtils.register(bootstapContext, COMMON_SMALL_ARAUCARIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, COMMON_SMALL_METASEQUOIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_METASEQUOIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.25F, 2)));
		PlacementUtils.register(bootstapContext, LARGE_ARAUCARIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_ARAUCARIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
		PlacementUtils.register(bootstapContext, LARGE_METASEQUOIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_METASEQUOIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.5F, 2)));
		PlacementUtils.register(bootstapContext, RARE_LIRIODENDRITES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.LIRIODENDRITES_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, SMALL_METASEQUOIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_METASEQUOIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, VERY_COMMON_DRYOPHYLLUM_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.DRYOPHYLLUM_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.5F, 2)));
		PlacementUtils.register(bootstapContext, SMALL_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, RARE_LARGE_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, SMALL_MIXED_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_MIXED_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, RARE_MIXED_LARGE_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_MIXED_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, SMALL_YELLOW_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_YELLOW_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, RARE_SMALL_YELLOW_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_YELLOW_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0625F, 1)));
		PlacementUtils.register(bootstapContext, RARE_YELLOW_LARGE_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.LARGE_YELLOW_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, SMALL_ARAUCARIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, SMALL_PLATANITES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_PLATANITES_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, PLATANITES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.PLATANITES_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.25F, 2)));
		PlacementUtils.register(bootstapContext, RARE_PLATANITES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_PLATANITES_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, TAXUS_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
		PlacementUtils.register(bootstapContext, PODOZAMITES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.PODOZAMITES_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
		PlacementUtils.register(bootstapContext, RARE_TAXUS_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.TAXUS_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0625F, 1)));
		PlacementUtils.register(bootstapContext, RARE_PODOZAMITES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.PODOZAMITES_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, RARE_SCHIZOLEPIDOPSIS_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, RARE_CZEKANOWSKIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.CZEKANOWSKIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0625F, 1)));
		PlacementUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.125F, 3)));
		PlacementUtils.register(bootstapContext, CZEKANOWSKIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.CZEKANOWSKIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
		PlacementUtils.register(bootstapContext, DEAD_TAXUS_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_TAXUS_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0625F, 1)));
		PlacementUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_SCHIZOLEPIDOPSIS_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, DEAD_PODOZAMITES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_PODOZAMITES_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
		PlacementUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.DEAD_CZEKANOWSKIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));

		PlacementUtils.register(bootstapContext, CLEARING_HUMULUS, holderGetter.getOrThrow(PFConfiguredFeatures.HUMULUS), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, CLEARING_CLUBMOSS, holderGetter.getOrThrow(PFConfiguredFeatures.CLUBMOSS), worldSurfaceSquaredWithCount(1));
		PlacementUtils.register(bootstapContext, CLEARING_RARE_SMALL_ARAUCARIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_ARAUCARIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.0625F, 1)));
		PlacementUtils.register(bootstapContext, CLEARING_VERY_COMMON_OSMUNDA, holderGetter.getOrThrow(PFConfiguredFeatures.OSMUNDA), worldSurfaceSquaredWithCount(12));
		PlacementUtils.register(bootstapContext, CLEARING_VERY_COMMON_TALL_OSMUNDA, holderGetter.getOrThrow(PFConfiguredFeatures.DOUBLE_OSMUNDA), worldSurfaceSquaredWithCount(6));
		PlacementUtils.register(bootstapContext, CLEARING_VERY_RARE_LOWERED_HORSETAILS, holderGetter.getOrThrow(PFConfiguredFeatures.RARE_LOWERED_HORSETAILS), List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, CLEARING_SABALITES, holderGetter.getOrThrow(PFConfiguredFeatures.COMMON_SABALITES), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, CLEARING_VERY_RARE_SMALL_GINKGO_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_GINKGO_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, CLEARING_RARE_SMALL_METASEQUOIA_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_METASEQUOIA_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));
		PlacementUtils.register(bootstapContext, CLEARING_FALLEN_METASEQUOIA_LOG, holderGetter.getOrThrow(PFConfiguredFeatures.FALLEN_METASEQUOIA_LOG), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, CLEARING_FALLEN_PLATANITES_LOG, holderGetter.getOrThrow(PFConfiguredFeatures.FALLEN_PLATANITES_LOG), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, CLEARING_FALLEN_GINKGO_LOG, holderGetter.getOrThrow(PFConfiguredFeatures.FALLEN_GINKGO_LOG), List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, CLEARING_RARE_PLATANITES_TREES, holderGetter.getOrThrow(PFConfiguredFeatures.SMALL_PLATANITES_TREES), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.125F, 1)));

		PlacementUtils.register(bootstapContext, SILT_DISK, holderGetter.getOrThrow(PFConfiguredFeatures.DISK_SILT), List.of(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, MUD_DISK, holderGetter.getOrThrow(PFConfiguredFeatures.MUD_DISK), List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));
		PlacementUtils.register(bootstapContext, PACKED_MUD_DISK, holderGetter.getOrThrow(PFConfiguredFeatures.PACKED_MUD_DISK), List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome()));

		PlacementUtils.register(bootstapContext, PTILOPHYLLUM, holderGetter.getOrThrow(PFConfiguredFeatures.PTILOPHYLLUM_TREE),  List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
	}

	public static ResourceKey<PlacedFeature> registerPlacedFeature(String id) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(PrehistoricFauna.MOD_ID, id));
	}

	public static final DeferredRegister<PlacedFeature> REGISTER = DeferredRegister.create(Registries.PLACED_FEATURE, PrehistoricFauna.MOD_ID);


	public static List<PlacementModifier> worldSurfaceSquaredWithCount(int p_195475_) {
		return List.of(CountPlacement.of(p_195475_), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	}

	public static void withChinleFlatsPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CHINLE_FLATS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES);
	}

	public static void withChinleSwampPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CHINLE_SWAMP_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCHILDERIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AGATHOXYLON_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS);
	}

	public static void withChinleWoodedMountainsPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCHILDERIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CHINLE_WOODED_MOUNTAINS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PODOZAMITES_TREES);
	}

	public static void withChinleRiverPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS);
	}

	public static void withIschigualastoVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MICHELILLOA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, JOHNSTONIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DICROIDIUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCYTOPHYLLUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ISCHIGUALASTO_TREES);
	}

	public static void withSparseIschigualastoVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MICHELILLOA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NEOCALAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		//builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DOUBLE_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WATERLOGGED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, JOHNSTONIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DICROIDIUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCYTOPHYLLUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_ISCHIGUALASTO_TREES);
	}

	public static void withMorrisonSavannaVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PTILOPHYLLUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CONIOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OSMUNDACAULIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OSMUNDACAULIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MORRISON_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_PODOZAMITES_TREES);
	}

	public static void withMorrisonHillsVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_BRACHYPHYLLUM);
	}

	public static void withKayentaDryForestVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DRY_FOREST_VEGETATION);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OTOZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LAUROZAMITES);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, RED_SANDSTONE_ROCK);
	}

	public static void withKayentaButtesVegetation(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_SMALL_ARAUCARIAS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OTOZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LAUROZAMITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_BRACHYPHYLLUM);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, RED_SANDSTONE_ROCK);
	}

	public static void withKayentaDesertRocks(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, RED_SANDSTONE_ROCK);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, BIG_RED_SANDSTONE_ROCK);
	}

	public static void withDjadochtaPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COBBANIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TROCHODENDROIDES_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ARROYO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, D_QUEREUXIA);
	}

	public static void withDjadochtaRocks(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, SANDSTONE_ROCK);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, BIG_SANDSTONE_ROCK);
	}

	public static void withDjadochtaAlluvialPlainsPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_YELLOW_GINKGO_TREES);
	}

	public static void withDjadochtaFallenLogs(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG);
	}


	public static void withHellCreekSwampPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLUBMOSS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARCHANTIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OSMUNDA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OSMUNDA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COBBANIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AZOLLA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TROCHODENDROIDES_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_DRYOPHYLLUM_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_METASEQUOIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TAXODIUM_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TAXODIUM_KNEES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CRASSOSTREA_OYSTERS);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_TAXODIUM_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_DRYOPHYLLUM_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_PLATANITES_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NELUMBO);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZINGIBEROPSIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, QUEREUXIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_PLATANITES_TREES);
	}

	public static void withHellCreekLiriodendritesHillsPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HUMULUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLUBMOSS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OSMUNDA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_OSMUNDA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARMARTHIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AZOLLA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_DRYOPHYLLUM_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_METASEQUOIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_LIRIODENDRITES_TREES);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_DRYOPHYLLUM_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_PLATANITES_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BISONIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZINGIBEROPSIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PLATANITES_TREES);
		//Nilssonia
	}

	public static void withHellCreekClearingPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_HUMULUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_CLUBMOSS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_RARE_SMALL_ARAUCARIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_VERY_COMMON_OSMUNDA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_VERY_COMMON_TALL_OSMUNDA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_VERY_RARE_LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_SABALITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_VERY_RARE_SMALL_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_RARE_SMALL_METASEQUOIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_FALLEN_METASEQUOIA_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_FALLEN_PLATANITES_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_FALLEN_GINKGO_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLEARING_RARE_PLATANITES_TREES);
	}

	public static void withHellCreekRedwoodsPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HUMULUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_ARAUCARIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARCHANTIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_OSMUNDA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_TALL_OSMUNDA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARMARTHIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AZOLLA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TROCHODENDROIDES_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_DRYOPHYLLUM_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_SMALL_METASEQUOIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LARGE_METASEQUOIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LARGE_ARAUCARIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VERY_RARE_LARGE_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_TAXODIUM_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_LIRIODENDRITES_TREES);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_TAXODIUM_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_DRYOPHYLLUM_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_PLATANITES_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BISONIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZINGIBEROPSIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, QUEREUXIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PLATANITES_TREES);
		//Nilssonia(?)
	}

	public static void withHellCreekRiverPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARCHANTIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARMARTHIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TROCHODENDROIDES_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, COMMON_DRYOPHYLLUM_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_METASEQUOIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, QUEREUXIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SABALITES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PLATANITES_TREES);
	}

	public static void withHellCreekHardwoodForestPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HUMULUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARCHANTIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MOSS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MARMARTHIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VERY_COMMON_DRYOPHYLLUM_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_LARGE_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_METASEQUOIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_ARAUCARIA_TREES);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MOSSY_ROCK);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_DRYOPHYLLUM_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_METASEQUOIA_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_PLATANITES_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FALLEN_GINKGO_LOG);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BISONIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NELUMBO);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZINGIBEROPSIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, QUEREUXIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PLATANITES_TREES);
		//Nilssonia
	}

	public static void withYixianForestPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_ARAUCARIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CONIOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_MIXED_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_MIXED_LARGE_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TAXUS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CZEKANOWSKIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCHIZOLEPIDOPSIS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPHEDRA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LEEFRUCTUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RUFFORDIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ARCHAEFRUCTUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_ARCHAEFRUCTUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PODOZAMITES_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_BRACHYPHYLLUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NOTHODICHOCARPUM);
	}

	public static void withYixianSnowyForestPlants(BiomeGenerationSettings.Builder builder) {
		//		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_ARAUCARIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CONIOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_YELLOW_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_YELLOW_LARGE_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TAXUS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CZEKANOWSKIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SCHIZOLEPIDOPSIS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPHEDRA);
		//		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LEEFRUCTUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RUFFORDIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ARCHAEFRUCTUS);
		//		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_ARCHAEFRUCTUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PODOZAMITES_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_BRACHYPHYLLUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NOTHODICHOCARPUM);
	}

	public static void withYixianLakesPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SMALL_ARAUCARIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LOWERED_HORSETAILS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CONIOPTERIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SMALL_MIXED_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_MIXED_LARGE_GINKGO_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPHEDRA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, LEEFRUCTUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RUFFORDIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ARCHAEFRUCTUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_CZEKANOWSKIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_TAXUS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SCHIZOLEPIDOPSIS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TALL_ARCHAEFRUCTUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_PODOZAMITES_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_BRACHYPHYLLUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CALLIANTHUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NOTHODICHOCARPUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MiscOverworldPlacements.FREEZE_TOP_LAYER);
	}

	public static void withYixianRegrowthPlants(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RUFFORDIA);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ARCHAEFRUCTUS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_CZEKANOWSKIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_TAXUS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_SCHIZOLEPIDOPSIS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_CZEKANOWSKIA_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_TAXUS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_SCHIZOLEPIDOPSIS_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ASH);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RARE_PODOZAMITES_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEAD_PODOZAMITES_TREES);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SPARSE_BRACHYPHYLLUM);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NOTHODICHOCARPUM);
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

}
