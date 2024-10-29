package superlord.prehistoricfauna.init;

import java.util.List;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.MultifaceGrowthConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.feature.util.CrassostreaOystersConfig;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.common.feature.util.NoisySphereConfig;
import superlord.prehistoricfauna.common.feature.util.PFTreeConfig;

public class PFConfiguredFeatures {

	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_ARAUCARIA_TREE_1 = registerConfiguredFeature("configured_small_araucaria_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_ARAUCARIA_TREE_2 = registerConfiguredFeature("configured_small_araucaria_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_ARAUCARIA_TREE_3 = registerConfiguredFeature("configured_small_araucaria_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_ARAUCARIA_TREE_4 = registerConfiguredFeature("configured_small_araucaria_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_ARAUCARIA = registerConfiguredFeature("configured_dead_araucaria");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ARAUCARIA_TREE_1 = registerConfiguredFeature("configured_araucaria_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ARAUCARIA_TREE_2 = registerConfiguredFeature("configured_araucaria_tree_2");

	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_AGATHOXYLON_TREE_1 = registerConfiguredFeature("configured_small_agathoxylon_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_AGATHOXYLON_TREE_2 = registerConfiguredFeature("configured_small_agathoxylon_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_AGATHOXYLON_TREE_1 = registerConfiguredFeature("configured_medium_agathoxylon_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_AGATHOXYLON_TREE_2 = registerConfiguredFeature("configured_medium_agathoxylon_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_AGATHOXYLON_TREE_1 = registerConfiguredFeature("configured_large_agathoxylon_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_AGATHOXYLON_TREE_2 = registerConfiguredFeature("configured_large_agathoxylon_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_AGATHOXYLON_TREE_3 = registerConfiguredFeature("configured_large_agathoxylon_tree_3");

	public static final ResourceKey<ConfiguredFeature<?, ?>> BRACHYPHYLLUM_TREE_1 = registerConfiguredFeature("configured_brachyphyllum_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRACHYPHYLLUM_TREE_2 = registerConfiguredFeature("configured_brachyphyllum_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRACHYPHYLLUM_TREE_3 = registerConfiguredFeature("configured_brachyphyllum_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRACHYPHYLLUM_TREE_4 = registerConfiguredFeature("configured_brachyphyllum_tree_4");

	public static final ResourceKey<ConfiguredFeature<?, ?>> GINKGO_TREE_1 = registerConfiguredFeature("configured_ginkgo_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GINKGO_TREE_2 = registerConfiguredFeature("configured_ginkgo_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GINKGO_TREE_3 = registerConfiguredFeature("configured_ginkgo_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GINKGO_TREE_4 = registerConfiguredFeature("configured_ginkgo_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GINKGO_TREE_1 = registerConfiguredFeature("configured_big_ginkgo_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GINKGO_TREE_2 = registerConfiguredFeature("configured_big_ginkgo_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GINKGO_TREE_3 = registerConfiguredFeature("configured_big_ginkgo_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GINKGO_TREE_4 = registerConfiguredFeature("configured_big_ginkgo_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_GINKGO_TREE_1 = registerConfiguredFeature("configured_yellow_ginkgo_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_GINKGO_TREE_2 = registerConfiguredFeature("configured_yellow_ginkgo_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_GINKGO_TREE_3 = registerConfiguredFeature("configured_yellow_ginkgo_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_GINKGO_TREE_4 = registerConfiguredFeature("configured_yellow_ginkgo_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_BIG_GINKGO_TREE_1 = registerConfiguredFeature("configured_yellow_big_ginkgo_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_BIG_GINKGO_TREE_2 = registerConfiguredFeature("configured_yellow_big_ginkgo_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_BIG_GINKGO_TREE_3 = registerConfiguredFeature("configured_yellow_big_ginkgo_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_BIG_GINKGO_TREE_4 = registerConfiguredFeature("configured_yellow_big_ginkgo_tree_4");

	public static final ResourceKey<ConfiguredFeature<?, ?>> HEIDIPHYLLUM_TREE_1 = registerConfiguredFeature("configured_heidiphyllum_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HEIDIPHYLLUM_TREE_2 = registerConfiguredFeature("configured_heidiphyllum_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HEIDIPHYLLUM_TREE_3 = registerConfiguredFeature("configured_heidiphyllum_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HEIDIPHYLLUM_TREE_4 = registerConfiguredFeature("configured_heidiphyllum_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HEIDIPHYLLUM_TREE_5 = registerConfiguredFeature("configured_heidiphyllum_tree_5");

	public static final ResourceKey<ConfiguredFeature<?, ?>> LIRIODENDRITES_TREE_1 = registerConfiguredFeature("configured_liriodendrites_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LIRIODENDRITES_TREE_2 = registerConfiguredFeature("configured_liriodendrites_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LIRIODENDRITES_TREE_3 = registerConfiguredFeature("configured_liriodendrites_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LIRIODENDRITES_TREE_4 = registerConfiguredFeature("configured_liriodendrites_tree_4");

	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_METASEQUOIA_TREE_1 = registerConfiguredFeature("configured_large_metasequoia_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_METASEQUOIA_TREE_2 = registerConfiguredFeature("configured_large_metasequoia_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_METASEQUOIA_TREE_1 = registerConfiguredFeature("configured_small_metasequoia_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_METASEQUOIA_TREE_2 = registerConfiguredFeature("configured_small_metasequoia_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_METASEQUOIA_TREE_3 = registerConfiguredFeature("configured_small_metasequoia_tree_3");

	public static final ResourceKey<ConfiguredFeature<?, ?>> PROTOPICEOXYLON_TREE_1 = registerConfiguredFeature("configured_protopiceoxylon_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PROTOPICEOXYLON_TREE_2 = registerConfiguredFeature("configured_protopiceoxylon_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PROTOPICEOXYLON_TREE_3 = registerConfiguredFeature("configured_protopiceoxylon_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PROTOPICEOXYLON_TREE_4 = registerConfiguredFeature("configured_protopiceoxylon_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PROTOPICEOXYLON_TREE_5 = registerConfiguredFeature("configured_protopiceoxylon_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PROTOPICEOXYLON_TREE_6 = registerConfiguredFeature("configured_protopiceoxylon_tree_6");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PROTOPICEOXYLON_TREE_7 = registerConfiguredFeature("configured_protopiceoxylon_tree_7");

	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHILDERIA_TREE_1 = registerConfiguredFeature("configured_schilderia_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHILDERIA_TREE_2 = registerConfiguredFeature("configured_schilderia_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHILDERIA_TREE_3 = registerConfiguredFeature("configured_schilderia_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHILDERIA_TREE_4 = registerConfiguredFeature("configured_schilderia_tree_4");

	public static final ResourceKey<ConfiguredFeature<?, ?>> TROCHODENDROIDES_TREE_1 = registerConfiguredFeature("configured_trochodendroides_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TROCHODENDROIDES_TREE_2 = registerConfiguredFeature("configured_trochodendroides_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TROCHODENDROIDES_TREE_3 = registerConfiguredFeature("configured_trochodendroides_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TROCHODENDROIDES_TREE_4 = registerConfiguredFeature("configured_trochodendroides_tree_4");

	public static final ResourceKey<ConfiguredFeature<?, ?>> WOODWORTHIA_TREE_1 = registerConfiguredFeature("configured_woodworthia_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WOODWORTHIA_TREE_2 = registerConfiguredFeature("configured_woodworthia_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WOODWORTHIA_TREE_3 = registerConfiguredFeature("configured_woodworthia_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WOODWORTHIA_TREE_4 = registerConfiguredFeature("configured_woodworthia_tree_4");

	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_PROTOJUNIPEROXYLON_TREE_1 = registerConfiguredFeature("configured_large_protojuniperoxylon_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_PROTOJUNIPEROXYLON_TREE_2 = registerConfiguredFeature("configured_large_protojuniperoxylon_tree_2");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_TREE_1 = registerConfiguredFeature("configured_dryophyllum_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_TREE_2 = registerConfiguredFeature("configured_dryophyllum_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_TREE_3 = registerConfiguredFeature("configured_dryophyllum_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_TREE_4 = registerConfiguredFeature("configured_dryophyllum_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_TREE_5 = registerConfiguredFeature("configured_dryophyllum_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_TREE_6 = registerConfiguredFeature("configured_dryophyllum_tree_6");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_TREE_7 = registerConfiguredFeature("configured_dryophyllum_tree_7");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_TREE_8 = registerConfiguredFeature("configured_dryophyllum_tree_8");

	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXODIUM_TREE_1 = registerConfiguredFeature("configured_taxodium_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXODIUM_TREE_2 = registerConfiguredFeature("configured_taxodium_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXODIUM_TREE_3 = registerConfiguredFeature("configured_taxodium_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXODIUM_TREE_4 = registerConfiguredFeature("configured_taxodium_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXODIUM_TREE_5 = registerConfiguredFeature("configured_taxodium_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXODIUM_TREE_6 = registerConfiguredFeature("configured_taxodium_tree_6");

	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_PLATANITES_TREE_1 = registerConfiguredFeature("configured_large_platanites_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_PLATANITES_TREE_2 = registerConfiguredFeature("configured_large_platanites_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_PLATANITES_TREE_3 = registerConfiguredFeature("configured_large_platanites_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PLATANITES_TREE_1 = registerConfiguredFeature("configured_small_platanites_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PLATANITES_TREE_2 = registerConfiguredFeature("configured_small_platanites_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PLATANITES_TREE_3 = registerConfiguredFeature("configured_small_platanites_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PLATANITES_TREE_4 = registerConfiguredFeature("configured_small_platanites_tree_4");

	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXUS_TREE_1 = registerConfiguredFeature("configured_taxus_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXUS_TREE_2 = registerConfiguredFeature("configured_taxus_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXUS_TREE_3 = registerConfiguredFeature("configured_taxus_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXUS_TREE_4 = registerConfiguredFeature("configured_taxus_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXUS_TREE_5 = registerConfiguredFeature("configured_taxus_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXUS_TREE_6 = registerConfiguredFeature("configured_taxus_tree_6");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXUS_TREE_7 = registerConfiguredFeature("configured_taxus_tree_7");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXUS_TREE_8 = registerConfiguredFeature("configured_taxus_tree_8");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CZEKANOWSKIA_TREE_1 = registerConfiguredFeature("configured_czekanowskia_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CZEKANOWSKIA_TREE_2 = registerConfiguredFeature("configured_czekanowskia_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CZEKANOWSKIA_TREE_3 = registerConfiguredFeature("configured_czekanowskia_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CZEKANOWSKIA_TREE_4 = registerConfiguredFeature("configured_czekanowskia_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CZEKANOWSKIA_TREE_5 = registerConfiguredFeature("configured_czekanowskia_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CZEKANOWSKIA_TREE_6 = registerConfiguredFeature("configured_czekanowskia_tree_6");

	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREE_1 = registerConfiguredFeature("configured_schizolepidopsis_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREE_2 = registerConfiguredFeature("configured_schizolepidopsis_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREE_3 = registerConfiguredFeature("configured_schizolepidopsis_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREE_4 = registerConfiguredFeature("configured_schizolepidopsis_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREE_5 = registerConfiguredFeature("configured_schizolepidopsis_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREE_6 = registerConfiguredFeature("configured_schizolepidopsis_tree_6");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREE_7 = registerConfiguredFeature("configured_schizolepidopsis_tree_7");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREE_8 = registerConfiguredFeature("configured_schizolepidopsis_tree_8");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREE_9 = registerConfiguredFeature("configured_schizolepidopsis_tree_9");

	public static final ResourceKey<ConfiguredFeature<?, ?>> PODOZAMITES_TREE_1 = registerConfiguredFeature("configured_podozamites_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PODOZAMITES_TREE_2 = registerConfiguredFeature("configured_podozamites_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PODOZAMITES_TREE_3 = registerConfiguredFeature("configured_podozamites_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PODOZAMITES_TREE_4 = registerConfiguredFeature("configured_podozamites_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PODOZAMITES_TREE_5 = registerConfiguredFeature("configured_podozamites_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PODOZAMITES_TREE_6 = registerConfiguredFeature("configured_podozamites_tree_6");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TAXUS_TREE_1 = registerConfiguredFeature("configured_dead_taxus_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TAXUS_TREE_2 = registerConfiguredFeature("configured_dead_taxus_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TAXUS_TREE_3 = registerConfiguredFeature("configured_dead_taxus_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TAXUS_TREE_4 = registerConfiguredFeature("configured_dead_taxus_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TAXUS_TREE_5 = registerConfiguredFeature("configured_dead_taxus_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TAXUS_TREE_6 = registerConfiguredFeature("configured_dead_taxus_tree_6");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TAXUS_TREE_7 = registerConfiguredFeature("configured_dead_taxus_tree_7");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TAXUS_TREE_8 = registerConfiguredFeature("configured_dead_taxus_tree_8");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_CZEKANOWSKIA_TREE_1 = registerConfiguredFeature("configured_dead_czekanowskia_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_CZEKANOWSKIA_TREE_2 = registerConfiguredFeature("configured_dead_czekanowskia_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_CZEKANOWSKIA_TREE_3 = registerConfiguredFeature("configured_dead_czekanowskia_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_CZEKANOWSKIA_TREE_4 = registerConfiguredFeature("configured_dead_czekanowskia_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_CZEKANOWSKIA_TREE_5 = registerConfiguredFeature("configured_dead_czekanowskia_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_CZEKANOWSKIA_TREE_6 = registerConfiguredFeature("configured_dead_czekanowskia_tree_6");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREE_1 = registerConfiguredFeature("configured_dead_schizolepidopsis_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREE_2 = registerConfiguredFeature("configured_dead_schizolepidopsis_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREE_3 = registerConfiguredFeature("configured_dead_schizolepidopsis_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREE_4 = registerConfiguredFeature("configured_dead_schizolepidopsis_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREE_5 = registerConfiguredFeature("configured_dead_schizolepidopsis_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREE_6 = registerConfiguredFeature("configured_dead_schizolepidopsis_tree_6");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREE_7 = registerConfiguredFeature("configured_dead_schizolepidopsis_tree_7");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREE_8 = registerConfiguredFeature("configured_dead_schizolepidopsis_tree_8");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREE_9 = registerConfiguredFeature("configured_dead_schizolepidopsis_tree_9");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PODOZAMITES_TREE_1 = registerConfiguredFeature("configured_dead_podozamites_tree_1");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PODOZAMITES_TREE_2 = registerConfiguredFeature("configured_dead_podozamites_tree_2");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PODOZAMITES_TREE_3 = registerConfiguredFeature("configured_dead_podozamites_tree_3");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PODOZAMITES_TREE_4 = registerConfiguredFeature("configured_dead_podozamites_tree_4");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PODOZAMITES_TREE_5 = registerConfiguredFeature("configured_dead_podozamites_tree_5");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PODOZAMITES_TREE_6 = registerConfiguredFeature("configured_dead_podozamites_tree_6");

	public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_DRYOPHYLLUM_LOG = registerConfiguredFeature("configured_fallen_dryophyllum_log");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_TAXODIUM_LOG = registerConfiguredFeature("configured_fallen_taxodium_log");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_METASEQUOIA_LOG = registerConfiguredFeature("configured_fallen_metasequoia_log");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_PLATANITES_LOG = registerConfiguredFeature("configured_fallen_platanites_log");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_GINKGO_LOG = registerConfiguredFeature("configured_fallen_ginkgo_log");

	public static final ResourceKey<ConfiguredFeature<?, ?>> ZAMITES_BUSH = registerConfiguredFeature("configured_zamites_bush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> COMMON_ZAMITES_BUSH = registerConfiguredFeature("configured_common_zamites_bush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> COMMON_SABALITES = registerConfiguredFeature("configured_common_sabalites");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RARE_SABALITES = registerConfiguredFeature("configured_rare_sabalites");

	public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSILIZED_CHALK = registerConfiguredFeature("configured_fossilized_chalk");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSILIZED_SILTSTONE = registerConfiguredFeature("configured_fossilized_siltstone");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSILIZED_SANDSTONE = registerConfiguredFeature("configured_fossilized_sandstone");

	public static final ResourceKey<ConfiguredFeature<?, ?>> MARCHANITA = registerConfiguredFeature("configured_marchantia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BISONIA = registerConfiguredFeature("configured_bisonia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HORSETAILS = registerConfiguredFeature("configured_horsetails");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WATERLOGGED_HORSETAILS = registerConfiguredFeature("configured_waterlogged_horsetails");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LOWERED_HORSETAILS = registerConfiguredFeature("configured_lowered_horsetails");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RARE_LOWERED_HORSETAILS = registerConfiguredFeature("configured_rare_lowered_horsetails");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DOUBLE_HORSETAILS = registerConfiguredFeature("configured_double_horsetails");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CLUBMOSS = registerConfiguredFeature("configured_clubmoss");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OSMUNDA = registerConfiguredFeature("configured_osmunda");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DOUBLE_OSMUNDA = registerConfiguredFeature("configured_double_osmunda");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MOSS = registerConfiguredFeature("configured_moss");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ASH = registerConfiguredFeature("configured_ash");
	public static final ResourceKey<ConfiguredFeature<?, ?>> HUMULUS = registerConfiguredFeature("configured_humulus");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OTOZAMITES = registerConfiguredFeature("configured_otozamites");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DOUBLE_OTOZAMITES = registerConfiguredFeature("configured_double_otozamites");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LAUROZAMITES = registerConfiguredFeature("configured_laurozamites");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CLATHOPTERIS = registerConfiguredFeature("configured_clathopteris");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CONIOPTERIS = registerConfiguredFeature("configured_coniopteris");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OSMUNDACAULIS = registerConfiguredFeature("configured_osmundacaulis");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DOUBLE_OSMUNDACAULIS = registerConfiguredFeature("configured_double_osmundacaulis");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_OSMUNDACAULIS = registerConfiguredFeature("configured_dead_osmundacaulis");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MICHELILLOA = registerConfiguredFeature("configured_michelilloa");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CLADOPHLEBIS = registerConfiguredFeature("configured_cladophlebis");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCYTOPHYLLUM = registerConfiguredFeature("configured_scytophyllum");
	public static final ResourceKey<ConfiguredFeature<?, ?>> NOTHODICHOCARPUM = registerConfiguredFeature("configured_nothodichocarpum");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PHLEBOPTERIS = registerConfiguredFeature("configured_phlebopteris");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MARMARTHIA = registerConfiguredFeature("configured_marmarthia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LEEFRUCTUS = registerConfiguredFeature("configured_leefructus");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RUFFORDIA = registerConfiguredFeature("configured_ruffordia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> EPHEDRA = registerConfiguredFeature("configured_ephedra");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ARCHAEFRUCTUS = registerConfiguredFeature("configured_archaefructus");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DOUBLE_ARCHAEFRUCTUS = registerConfiguredFeature("configured_double_archaefructus");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CRASSOSTREA_OYSTERS = registerConfiguredFeature("configured_crassostrea_oyster");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE = registerConfiguredFeature("configured_algae");
	public static final ResourceKey<ConfiguredFeature<?, ?>> NELUMBO = registerConfiguredFeature("configured_nelumbo");
	public static final ResourceKey<ConfiguredFeature<?, ?>> QUEREUXIA = registerConfiguredFeature("configured_quereuxia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> COBBANIA = registerConfiguredFeature("configured_cobbania");
	public static final ResourceKey<ConfiguredFeature<?, ?>> AZOLLA = registerConfiguredFeature("configured_azolla");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ZINGIBEROPSIS = registerConfiguredFeature("configured_zingiberopsis");

	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXODIUM_KNEES = registerConfiguredFeature("configured_taxodium_knees");

	public static final ResourceKey<ConfiguredFeature<?, ?>> SANDSTONE_ROCK = registerConfiguredFeature("configured_sandstone_rock");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_SANDSTONE_ROCK = registerConfiguredFeature("configured_large_sandstone_rock");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SANDSTONE_ROCK = registerConfiguredFeature("configured_red_sandstone_rock");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_RED_SANDSTONE_ROCK = registerConfiguredFeature("configured_large_red_sandstone_rock");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MOSSY_ROCK = registerConfiguredFeature("configured_mossy_rock");

	public static final ResourceKey<ConfiguredFeature<?, ?>> PTILOPHYLLUM_TREE = registerConfiguredFeature("configured_ptilophyllum_tree");

	public static final ResourceKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE = registerConfiguredFeature("configured_petrified_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> JOHNSTONIA = registerConfiguredFeature("congigured_johnstonia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DICROIDIUM = registerConfiguredFeature("congigured_dicroidium");

	public static final ResourceKey<ConfiguredFeature<?, ?>> NEOCALAMITES = registerConfiguredFeature("congigured_neocalamites");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CLAY_DISK = registerConfiguredFeature("congigured_clay_disk");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GRAVEL_DISK = registerConfiguredFeature("congigured_gravel_disk");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_DISK = registerConfiguredFeature("congigured_mud_disk");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PACKED_MUD_DISK = registerConfiguredFeature("congigured_packed_mud_disk");

	public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_SILT = registerConfiguredFeature("disk_silt");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CALLIANTHUS = registerConfiguredFeature("configured_callianthus");

	public static final RuleTest HENOSTONE = new TagMatchTest(PFTags.HENOSTONE);
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_HENOSTONE = registerConfiguredFeature("henostone_ore");

	public static final ResourceKey<ConfiguredFeature<?, ?>> CHINLE_SWAMP_TREES = registerConfiguredFeature("chinle_swamp_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHILDERIA_TREES = registerConfiguredFeature("schilderia_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHINLE_FLATS_TREES = registerConfiguredFeature("chinle_flats_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> AGATHOXYLON_TREES = registerConfiguredFeature("agathoxylon_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHINLE_WOODED_MOUNTAINS_TREES = registerConfiguredFeature("chinle_wooded_mountains_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ISCHIGUALASTO_TREES = registerConfiguredFeature("ischigualasto_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MORRISON_SAVANNA_TREES = registerConfiguredFeature("morrison_savanna_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_BRACHYPHYLLUM_TREES = registerConfiguredFeature("sparse_brachyphyllum_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRY_FOREST_TREES = registerConfiguredFeature("dry_forest_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SPARSE_ARAUCARIA_TREES = registerConfiguredFeature("sparse_araucaria_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TROCHODENDROIDES_TREES = registerConfiguredFeature("trochodendroides_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ARROYO_TREES = registerConfiguredFeature("arroyo_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXODIUM_TREES = registerConfiguredFeature("taxodium_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DRYOPHYLLUM_TREES = registerConfiguredFeature("dryophyllum_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_METASEQUOIA_TREES = registerConfiguredFeature("small_metasequoia_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_GINKGO_TREES = registerConfiguredFeature("small_ginkgo_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_YELLOW_GINKGO_TREES = registerConfiguredFeature("small_yellow_ginkgo_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_MIXED_GINKGO_TREES = registerConfiguredFeature("small_mixed_ginkgo_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LIRIODENDRITES_TREES = registerConfiguredFeature("liriodendrites_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_ARAUCARIA_TREES = registerConfiguredFeature("small_araucaria_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_METASEQUOIA_TREES = registerConfiguredFeature("large_metasequoia_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_ARAUCARIA_TREES = registerConfiguredFeature("large_araucaria_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_GINKGO_TREES = registerConfiguredFeature("large_ginkgo_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_YELLOW_GINKGO_TREES = registerConfiguredFeature("large_yellow_ginkgo_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_MIXED_GINKGO_TREES = registerConfiguredFeature("large_mixed_ginkgo_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PLATANITES_TREES = registerConfiguredFeature("small_platanites_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PLATANITES_TREES = registerConfiguredFeature("platanites_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TAXUS_TREES = registerConfiguredFeature("taxus_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CZEKANOWSKIA_TREES = registerConfiguredFeature("czekanowskia_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SCHIZOLEPIDOPSIS_TREES = registerConfiguredFeature("schizolepidopsis_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TAXUS_TREES = registerConfiguredFeature("dead_taxus_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_CZEKANOWSKIA_TREES = registerConfiguredFeature("dead_czekanowskia_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCHIZOLEPIDOPSIS_TREES = registerConfiguredFeature("dead_schizolepidopsis_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PODOZAMITES_TREES = registerConfiguredFeature("podozamites_trees");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PODOZAMITES_TREES = registerConfiguredFeature("dead_podozamites_trees");

	@SuppressWarnings("deprecation")
	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext) {
		FeatureUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_1, PFFeatures.SMALL_ARAUCARIA_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG.get()).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES.get()).setMinHeight(13).setMaxHeight(18).build());
		FeatureUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_2, PFFeatures.SMALL_ARAUCARIA_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG.get()).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES.get()).setMinHeight(6).setMaxHeight(11).build());
		FeatureUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_3, PFFeatures.SMALL_ARAUCARIA_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG.get()).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES.get()).setMinHeight(10).setMaxHeight(15).build());
		FeatureUtils.register(bootstapContext, SMALL_ARAUCARIA_TREE_4, PFFeatures.SMALL_ARAUCARIA_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG.get()).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES.get()).setMinHeight(14).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, DEAD_ARAUCARIA, PFFeatures.SMALL_ARAUCARIA_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_ARAUCARIA_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(6).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, ARAUCARIA_TREE_1, PFFeatures.ARAUCARIA_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG.get()).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES.get()).setMinHeight(44).setMaxHeight(55).build());
		FeatureUtils.register(bootstapContext, ARAUCARIA_TREE_2, PFFeatures.ARAUCARIA_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG.get()).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES.get()).setMinHeight(44).setMaxHeight(55).build());

		FeatureUtils.register(bootstapContext, SMALL_AGATHOXYLON_TREE_1, PFFeatures.SMALL_AGATHOXYLON_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG.get()).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES.get()).setMaxHeight(20).setMinHeight(20).build());
		FeatureUtils.register(bootstapContext, SMALL_AGATHOXYLON_TREE_2, PFFeatures.SMALL_AGATHOXYLON_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG.get()).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES.get()).setMaxHeight(25).setMinHeight(25).build());
		FeatureUtils.register(bootstapContext, MEDIUM_AGATHOXYLON_TREE_1, PFFeatures.MIDDLE_AGATHOXYLON_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG.get()).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES.get()).setMaxHeight(33).setMinHeight(33).build());
		FeatureUtils.register(bootstapContext, MEDIUM_AGATHOXYLON_TREE_2, PFFeatures.MIDDLE_AGATHOXYLON_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG.get()).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES.get()).setMaxHeight(41).setMinHeight(41).build());
		FeatureUtils.register(bootstapContext, LARGE_AGATHOXYLON_TREE_1, PFFeatures.BIG_AGATHOXYLON_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG.get()).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES.get()).setMaxHeight(44).setMinHeight(44).build());
		FeatureUtils.register(bootstapContext, LARGE_AGATHOXYLON_TREE_2, PFFeatures.BIG_AGATHOXYLON_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG.get()).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES.get()).setMaxHeight(55).setMinHeight(55).build());
		FeatureUtils.register(bootstapContext, LARGE_AGATHOXYLON_TREE_3, PFFeatures.BIG_AGATHOXYLON_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG.get()).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES.get()).setMaxHeight(60).setMinHeight(60).build());

		FeatureUtils.register(bootstapContext, BRACHYPHYLLUM_TREE_1, PFFeatures.BRACHYPHYLLUM_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.BRACHYPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.BRACHYPHYLLUM_LEAVES.get()).setMinHeight(4).setMaxHeight(6).build());
		FeatureUtils.register(bootstapContext, BRACHYPHYLLUM_TREE_2, PFFeatures.BRACHYPHYLLUM_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.BRACHYPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.BRACHYPHYLLUM_LEAVES.get()).setMinHeight(9).setMaxHeight(11).build());
		FeatureUtils.register(bootstapContext, BRACHYPHYLLUM_TREE_3, PFFeatures.BRACHYPHYLLUM_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.BRACHYPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.BRACHYPHYLLUM_LEAVES.get()).setMinHeight(22).setMaxHeight(24).build());
		FeatureUtils.register(bootstapContext, BRACHYPHYLLUM_TREE_4, PFFeatures.BRACHYPHYLLUM_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.BRACHYPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.BRACHYPHYLLUM_LEAVES.get()).setMinHeight(20).setMaxHeight(22).build());

		FeatureUtils.register(bootstapContext, GINKGO_TREE_1, PFFeatures.GINKGO_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.GINKGO_LEAVES.get()).setMinHeight(16).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, GINKGO_TREE_2, PFFeatures.GINKGO_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.GINKGO_LEAVES.get()).setMinHeight(9).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, GINKGO_TREE_3, PFFeatures.GINKGO_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.GINKGO_LEAVES.get()).setMinHeight(11).setMaxHeight(14).build());
		FeatureUtils.register(bootstapContext, GINKGO_TREE_4, PFFeatures.GINKGO_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.GINKGO_LEAVES.get()).setMinHeight(9).setMaxHeight(13).build());
		FeatureUtils.register(bootstapContext, BIG_GINKGO_TREE_1, PFFeatures.BIG_GINKGO_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.GINKGO_LEAVES.get()).setMinHeight(18).setMaxHeight(18).build());
		FeatureUtils.register(bootstapContext, BIG_GINKGO_TREE_2, PFFeatures.BIG_GINKGO_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.GINKGO_LEAVES.get()).setMinHeight(20).setMaxHeight(20).build());
		FeatureUtils.register(bootstapContext, BIG_GINKGO_TREE_3, PFFeatures.BIG_GINKGO_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.GINKGO_LEAVES.get()).setMinHeight(26).setMaxHeight(26).build());
		FeatureUtils.register(bootstapContext, BIG_GINKGO_TREE_4, PFFeatures.BIG_GINKGO_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.GINKGO_LEAVES.get()).setMinHeight(29).setMaxHeight(29).build());
		FeatureUtils.register(bootstapContext, YELLOW_GINKGO_TREE_1, PFFeatures.GINKGO_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.YELLOW_GINKGO_LEAVES.get()).setMinHeight(16).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, YELLOW_GINKGO_TREE_2, PFFeatures.GINKGO_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.YELLOW_GINKGO_LEAVES.get()).setMinHeight(9).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, YELLOW_GINKGO_TREE_3, PFFeatures.GINKGO_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.YELLOW_GINKGO_LEAVES.get()).setMinHeight(11).setMaxHeight(14).build());
		FeatureUtils.register(bootstapContext, YELLOW_GINKGO_TREE_4, PFFeatures.GINKGO_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.YELLOW_GINKGO_LEAVES.get()).setMinHeight(9).setMaxHeight(13).build());
		FeatureUtils.register(bootstapContext, YELLOW_BIG_GINKGO_TREE_1, PFFeatures.BIG_GINKGO_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.YELLOW_GINKGO_LEAVES.get()).setMinHeight(18).setMaxHeight(18).build());
		FeatureUtils.register(bootstapContext, YELLOW_BIG_GINKGO_TREE_2, PFFeatures.BIG_GINKGO_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.YELLOW_GINKGO_LEAVES.get()).setMinHeight(20).setMaxHeight(20).build());
		FeatureUtils.register(bootstapContext, YELLOW_BIG_GINKGO_TREE_3, PFFeatures.BIG_GINKGO_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.YELLOW_GINKGO_LEAVES.get()).setMinHeight(26).setMaxHeight(26).build());
		FeatureUtils.register(bootstapContext, YELLOW_BIG_GINKGO_TREE_4, PFFeatures.BIG_GINKGO_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG.get()).setLeavesBlock(PFBlocks.YELLOW_GINKGO_LEAVES.get()).setMinHeight(29).setMaxHeight(29).build());

		FeatureUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_1, PFFeatures.HEIDIPHYLLUM_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES.get()).setMinHeight(9).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_2, PFFeatures.HEIDIPHYLLUM_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES.get()).setMinHeight(12).setMaxHeight(15).build());
		FeatureUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_3, PFFeatures.HEIDIPHYLLUM_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES.get()).setMinHeight(12).setMaxHeight(15).build());
		FeatureUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_4, PFFeatures.HEIDIPHYLLUM_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES.get()).setMinHeight(15).setMaxHeight(18).build());
		FeatureUtils.register(bootstapContext, HEIDIPHYLLUM_TREE_5, PFFeatures.HEIDIPHYLLUM_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES.get()).setMinHeight(7).setMaxHeight(10).build());

		FeatureUtils.register(bootstapContext, LIRIODENDRITES_TREE_1, PFFeatures.LIRIODENDRITES_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.LIRIODENDRITES_LOG.get()).setLeavesBlock(PFBlocks.LIRIODENDRITES_LEAVES.get()).setMinHeight(16).setMaxHeight(20).build());
		FeatureUtils.register(bootstapContext, LIRIODENDRITES_TREE_2, PFFeatures.LIRIODENDRITES_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.LIRIODENDRITES_LOG.get()).setLeavesBlock(PFBlocks.LIRIODENDRITES_LEAVES.get()).setMinHeight(7).setMaxHeight(10).build());
		FeatureUtils.register(bootstapContext, LIRIODENDRITES_TREE_3, PFFeatures.LIRIODENDRITES_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.LIRIODENDRITES_LOG.get()).setLeavesBlock(PFBlocks.LIRIODENDRITES_LEAVES.get()).setMinHeight(12).setMaxHeight(15).build());
		FeatureUtils.register(bootstapContext, LIRIODENDRITES_TREE_4, PFFeatures.LIRIODENDRITES_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.LIRIODENDRITES_LOG.get()).setLeavesBlock(PFBlocks.LIRIODENDRITES_LEAVES.get()).setMinHeight(21).setMaxHeight(24).build());

		FeatureUtils.register(bootstapContext, LARGE_METASEQUOIA_TREE_1, PFFeatures.LARGE_METASEQUOIA_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG.get()).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES.get()).setMinHeight(41).setMaxHeight(53).build());
		FeatureUtils.register(bootstapContext, LARGE_METASEQUOIA_TREE_2, PFFeatures.LARGE_METASEQUOIA_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG.get()).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES.get()).setMinHeight(44).setMaxHeight(56).build());
		FeatureUtils.register(bootstapContext, SMALL_METASEQUOIA_TREE_1, PFFeatures.METASEQUOIA_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG.get()).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES.get()).setMinHeight(10).setMaxHeight(16).build());
		FeatureUtils.register(bootstapContext, SMALL_METASEQUOIA_TREE_2, PFFeatures.METASEQUOIA_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG.get()).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES.get()).setMinHeight(15).setMaxHeight(21).build());
		FeatureUtils.register(bootstapContext, SMALL_METASEQUOIA_TREE_3, PFFeatures.METASEQUOIA_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG.get()).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES.get()).setMinHeight(19).setMaxHeight(25).build());

		FeatureUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_1, PFFeatures.PROTOPICEOXYLON_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG.get()).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES.get()).setMinHeight(11).setMaxHeight(15).build());
		FeatureUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_2, PFFeatures.PROTOPICEOXYLON_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG.get()).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES.get()).setMinHeight(9).setMaxHeight(13).build());
		FeatureUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_3, PFFeatures.PROTOPICEOXYLON_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG.get()).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES.get()).setMinHeight(13).setMaxHeight(17).build());
		FeatureUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_4, PFFeatures.PROTOPICEOXYLON_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG.get()).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES.get()).setMinHeight(16).setMaxHeight(20).build());
		FeatureUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_5, PFFeatures.PROTOPICEOXYLON_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG.get()).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES.get()).setMinHeight(7).setMaxHeight(11).build());
		FeatureUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_6, PFFeatures.PROTOPICEOXYLON_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG.get()).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES.get()).setMinHeight(14).setMaxHeight(18).build());
		FeatureUtils.register(bootstapContext, PROTOPICEOXYLON_TREE_7, PFFeatures.PROTOPICEOXYLON_TREE_7.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG.get()).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES.get()).setMinHeight(14).setMaxHeight(19).build());

		FeatureUtils.register(bootstapContext, SCHILDERIA_TREE_1, PFFeatures.SCHILDERIA_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHILDERIA_LOG.get()).setLeavesBlock(PFBlocks.SCHILDERIA_LEAVES.get()).setMinHeight(13).setMaxHeight(13).build());
		FeatureUtils.register(bootstapContext, SCHILDERIA_TREE_2, PFFeatures.SCHILDERIA_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHILDERIA_LOG.get()).setLeavesBlock(PFBlocks.SCHILDERIA_LEAVES.get()).setMinHeight(17).setMaxHeight(17).build());
		FeatureUtils.register(bootstapContext, SCHILDERIA_TREE_3, PFFeatures.SCHILDERIA_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHILDERIA_LOG.get()).setLeavesBlock(PFBlocks.SCHILDERIA_LEAVES.get()).setMinHeight(25).setMaxHeight(25).build());
		FeatureUtils.register(bootstapContext, SCHILDERIA_TREE_4, PFFeatures.SCHILDERIA_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHILDERIA_LOG.get()).setLeavesBlock(PFBlocks.SCHILDERIA_LEAVES.get()).setMinHeight(35).setMaxHeight(35).build());

		FeatureUtils.register(bootstapContext, TROCHODENDROIDES_TREE_1, PFFeatures.TROCHODENDROIDES_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TROCHODENDROIDES_LOG.get()).setLeavesBlock(PFBlocks.TROCHODENDROIDES_LEAVES.get()).setMinHeight(4).setMaxHeight(4).build());
		FeatureUtils.register(bootstapContext, TROCHODENDROIDES_TREE_2, PFFeatures.TROCHODENDROIDES_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TROCHODENDROIDES_LOG.get()).setLeavesBlock(PFBlocks.TROCHODENDROIDES_LEAVES.get()).setMinHeight(5).setMaxHeight(5).build());
		FeatureUtils.register(bootstapContext, TROCHODENDROIDES_TREE_3, PFFeatures.TROCHODENDROIDES_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TROCHODENDROIDES_LOG.get()).setLeavesBlock(PFBlocks.TROCHODENDROIDES_LEAVES.get()).setMinHeight(6).setMaxHeight(6).build());
		FeatureUtils.register(bootstapContext, TROCHODENDROIDES_TREE_4, PFFeatures.TROCHODENDROIDES_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TROCHODENDROIDES_LOG.get()).setLeavesBlock(PFBlocks.TROCHODENDROIDES_LEAVES.get()).setMinHeight(4).setMaxHeight(4).build());

		FeatureUtils.register(bootstapContext, WOODWORTHIA_TREE_1, PFFeatures.WOODWORTHIA_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.WOODWORTHIA_LOG.get()).setLeavesBlock(PFBlocks.WOODWORTHIA_LEAVES.get()).setMinHeight(16).setMaxHeight(20).build());
		FeatureUtils.register(bootstapContext, WOODWORTHIA_TREE_2, PFFeatures.WOODWORTHIA_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.WOODWORTHIA_LOG.get()).setLeavesBlock(PFBlocks.WOODWORTHIA_LEAVES.get()).setMinHeight(20).setMaxHeight(24).build());
		FeatureUtils.register(bootstapContext, WOODWORTHIA_TREE_3, PFFeatures.WOODWORTHIA_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.WOODWORTHIA_LOG.get()).setLeavesBlock(PFBlocks.WOODWORTHIA_LEAVES.get()).setMinHeight(24).setMaxHeight(28).build());
		FeatureUtils.register(bootstapContext, WOODWORTHIA_TREE_4, PFFeatures.WOODWORTHIA_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.WOODWORTHIA_LOG.get()).setLeavesBlock(PFBlocks.WOODWORTHIA_LEAVES.get()).setMinHeight(28).setMaxHeight(32).build());

		FeatureUtils.register(bootstapContext, LARGE_PROTOJUNIPEROXYLON_TREE_1, PFFeatures.LARGE_METASEQUOIA_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOJUNIPEROXYLON_LOG.get()).setLeavesBlock(PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get()).setMinHeight(41).setMaxHeight(53).build());
		FeatureUtils.register(bootstapContext, LARGE_PROTOJUNIPEROXYLON_TREE_2, PFFeatures.LARGE_METASEQUOIA_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOJUNIPEROXYLON_LOG.get()).setLeavesBlock(PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get()).setMinHeight(44).setMaxHeight(56).build());

		FeatureUtils.register(bootstapContext, DRYOPHYLLUM_TREE_1, PFFeatures.DRYOPHYLLUM_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.DRYOPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.DRYOPHYLLUM_LEAVES.get()).setMinHeight(3).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, DRYOPHYLLUM_TREE_2, PFFeatures.DRYOPHYLLUM_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.DRYOPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.DRYOPHYLLUM_LEAVES.get()).setMinHeight(5).setMaxHeight(16).build());
		FeatureUtils.register(bootstapContext, DRYOPHYLLUM_TREE_3, PFFeatures.DRYOPHYLLUM_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.DRYOPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.DRYOPHYLLUM_LEAVES.get()).setMinHeight(13).setMaxHeight(20).build());
		FeatureUtils.register(bootstapContext, DRYOPHYLLUM_TREE_4, PFFeatures.DRYOPHYLLUM_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.DRYOPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.DRYOPHYLLUM_LEAVES.get()).setMinHeight(15).setMaxHeight(22).build());
		FeatureUtils.register(bootstapContext, DRYOPHYLLUM_TREE_5, PFFeatures.DRYOPHYLLUM_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.DRYOPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.DRYOPHYLLUM_LEAVES.get()).setMinHeight(17).setMaxHeight(26).build());
		FeatureUtils.register(bootstapContext, DRYOPHYLLUM_TREE_6, PFFeatures.DRYOPHYLLUM_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.DRYOPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.DRYOPHYLLUM_LEAVES.get()).setMinHeight(16).setMaxHeight(26).build());
		FeatureUtils.register(bootstapContext, DRYOPHYLLUM_TREE_7, PFFeatures.DRYOPHYLLUM_TREE_7.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.DRYOPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.DRYOPHYLLUM_LEAVES.get()).setMinHeight(18).setMaxHeight(22).build());
		FeatureUtils.register(bootstapContext, DRYOPHYLLUM_TREE_8, PFFeatures.DRYOPHYLLUM_TREE_8.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.DRYOPHYLLUM_LOG.get()).setLeavesBlock(PFBlocks.DRYOPHYLLUM_LEAVES.get()).setMinHeight(21).setMaxHeight(25).build());

		FeatureUtils.register(bootstapContext, TAXODIUM_TREE_1, PFFeatures.TAXODIUM_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXODIUM_LOG.get()).setLeavesBlock(PFBlocks.TAXODIUM_LEAVES.get()).setMinHeight(17).setMaxHeight(25).build());
		FeatureUtils.register(bootstapContext, TAXODIUM_TREE_2, PFFeatures.TAXODIUM_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXODIUM_LOG.get()).setLeavesBlock(PFBlocks.TAXODIUM_LEAVES.get()).setMinHeight(19).setMaxHeight(27).build());
		FeatureUtils.register(bootstapContext, TAXODIUM_TREE_3, PFFeatures.TAXODIUM_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXODIUM_LOG.get()).setLeavesBlock(PFBlocks.TAXODIUM_LEAVES.get()).setMinHeight(21).setMaxHeight(29).build());
		FeatureUtils.register(bootstapContext, TAXODIUM_TREE_4, PFFeatures.TAXODIUM_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXODIUM_LOG.get()).setLeavesBlock(PFBlocks.TAXODIUM_LEAVES.get()).setMinHeight(24).setMaxHeight(32).build());
		FeatureUtils.register(bootstapContext, TAXODIUM_TREE_5, PFFeatures.TAXODIUM_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXODIUM_LOG.get()).setLeavesBlock(PFBlocks.TAXODIUM_LEAVES.get()).setMinHeight(29).setMaxHeight(37).build());
		FeatureUtils.register(bootstapContext, TAXODIUM_TREE_6, PFFeatures.TAXODIUM_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXODIUM_LOG.get()).setLeavesBlock(PFBlocks.TAXODIUM_LEAVES.get()).setMinHeight(38).setMaxHeight(38).build());

		FeatureUtils.register(bootstapContext, LARGE_PLATANITES_TREE_1, PFFeatures.LARGE_PLATANITES_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PLATANITES_LOG.get()).setLeavesBlock(PFBlocks.PLATANITES_LEAVES.get()).setMinHeight(31).setMaxHeight(34).build());
		FeatureUtils.register(bootstapContext, LARGE_PLATANITES_TREE_2, PFFeatures.LARGE_PLATANITES_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PLATANITES_LOG.get()).setLeavesBlock(PFBlocks.PLATANITES_LEAVES.get()).setMinHeight(34).setMaxHeight(37).build());
		FeatureUtils.register(bootstapContext, LARGE_PLATANITES_TREE_3, PFFeatures.LARGE_PLATANITES_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PLATANITES_LOG.get()).setLeavesBlock(PFBlocks.PLATANITES_LEAVES.get()).setMinHeight(26).setMaxHeight(29).build());
		FeatureUtils.register(bootstapContext, SMALL_PLATANITES_TREE_1, PFFeatures.SMALL_PLATANITES_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PLATANITES_LOG.get()).setLeavesBlock(PFBlocks.PLATANITES_LEAVES.get()).setMinHeight(12).setMaxHeight(15).build());
		FeatureUtils.register(bootstapContext, SMALL_PLATANITES_TREE_2, PFFeatures.SMALL_PLATANITES_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PLATANITES_LOG.get()).setLeavesBlock(PFBlocks.PLATANITES_LEAVES.get()).setMinHeight(16).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, SMALL_PLATANITES_TREE_3, PFFeatures.SMALL_PLATANITES_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PLATANITES_LOG.get()).setLeavesBlock(PFBlocks.PLATANITES_LEAVES.get()).setMinHeight(18).setMaxHeight(21).build());
		FeatureUtils.register(bootstapContext, SMALL_PLATANITES_TREE_4, PFFeatures.SMALL_PLATANITES_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PLATANITES_LOG.get()).setLeavesBlock(PFBlocks.PLATANITES_LEAVES.get()).setMinHeight(14).setMaxHeight(17).build());

		FeatureUtils.register(bootstapContext, TAXUS_TREE_1, PFFeatures.TAXUS_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXUS_LOG.get()).setLeavesBlock(PFBlocks.TAXUS_LEAVES.get()).setMinHeight(5).setMaxHeight(8).build());
		FeatureUtils.register(bootstapContext, TAXUS_TREE_2, PFFeatures.TAXUS_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXUS_LOG.get()).setLeavesBlock(PFBlocks.TAXUS_LEAVES.get()).setMinHeight(4).setMaxHeight(7).build());
		FeatureUtils.register(bootstapContext, TAXUS_TREE_3, PFFeatures.TAXUS_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXUS_LOG.get()).setLeavesBlock(PFBlocks.TAXUS_LEAVES.get()).setMinHeight(8).setMaxHeight(11).build());
		FeatureUtils.register(bootstapContext, TAXUS_TREE_4, PFFeatures.TAXUS_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXUS_LOG.get()).setLeavesBlock(PFBlocks.TAXUS_LEAVES.get()).setMinHeight(10).setMaxHeight(13).build());
		FeatureUtils.register(bootstapContext, TAXUS_TREE_5, PFFeatures.TAXUS_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXUS_LOG.get()).setLeavesBlock(PFBlocks.TAXUS_LEAVES.get()).setMinHeight(11).setMaxHeight(14).build());
		FeatureUtils.register(bootstapContext, TAXUS_TREE_6, PFFeatures.TAXUS_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXUS_LOG.get()).setLeavesBlock(PFBlocks.TAXUS_LEAVES.get()).setMinHeight(16).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, TAXUS_TREE_7, PFFeatures.TAXUS_TREE_7.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXUS_LOG.get()).setLeavesBlock(PFBlocks.TAXUS_LEAVES.get()).setMinHeight(17).setMaxHeight(20).build());
		FeatureUtils.register(bootstapContext, TAXUS_TREE_8, PFFeatures.TAXUS_TREE_8.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TAXUS_LOG.get()).setLeavesBlock(PFBlocks.TAXUS_LEAVES.get()).setMinHeight(17).setMaxHeight(20).build());

		FeatureUtils.register(bootstapContext, CZEKANOWSKIA_TREE_1, PFFeatures.CZEKANOWSKIA_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.CZEKANOWSKIA_LOG.get()).setLeavesBlock(PFBlocks.CZEKANOWSKIA_LEAVES.get()).setMinHeight(5).setMaxHeight(8).build());
		FeatureUtils.register(bootstapContext, CZEKANOWSKIA_TREE_2, PFFeatures.CZEKANOWSKIA_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.CZEKANOWSKIA_LOG.get()).setLeavesBlock(PFBlocks.CZEKANOWSKIA_LEAVES.get()).setMinHeight(8).setMaxHeight(11).build());
		FeatureUtils.register(bootstapContext, CZEKANOWSKIA_TREE_3, PFFeatures.CZEKANOWSKIA_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.CZEKANOWSKIA_LOG.get()).setLeavesBlock(PFBlocks.CZEKANOWSKIA_LEAVES.get()).setMinHeight(9).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, CZEKANOWSKIA_TREE_4, PFFeatures.CZEKANOWSKIA_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.CZEKANOWSKIA_LOG.get()).setLeavesBlock(PFBlocks.CZEKANOWSKIA_LEAVES.get()).setMinHeight(13).setMaxHeight(16).build());
		FeatureUtils.register(bootstapContext, CZEKANOWSKIA_TREE_5, PFFeatures.CZEKANOWSKIA_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.CZEKANOWSKIA_LOG.get()).setLeavesBlock(PFBlocks.CZEKANOWSKIA_LEAVES.get()).setMinHeight(15).setMaxHeight(18).build());
		FeatureUtils.register(bootstapContext, CZEKANOWSKIA_TREE_6, PFFeatures.CZEKANOWSKIA_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.CZEKANOWSKIA_LOG.get()).setLeavesBlock(PFBlocks.CZEKANOWSKIA_LEAVES.get()).setMinHeight(13).setMaxHeight(16).build());

		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_1, PFFeatures.SCHIZOLEPIDOPSIS_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get()).setMinHeight(6).setMaxHeight(9).build());
		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_2, PFFeatures.SCHIZOLEPIDOPSIS_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get()).setMinHeight(9).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_3, PFFeatures.SCHIZOLEPIDOPSIS_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get()).setMinHeight(11).setMaxHeight(14).build());
		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_4, PFFeatures.SCHIZOLEPIDOPSIS_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get()).setMinHeight(14).setMaxHeight(17).build());
		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_5, PFFeatures.SCHIZOLEPIDOPSIS_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get()).setMinHeight(15).setMaxHeight(18).build());
		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_6, PFFeatures.SCHIZOLEPIDOPSIS_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get()).setMinHeight(16).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_7, PFFeatures.SCHIZOLEPIDOPSIS_TREE_7.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get()).setMinHeight(19).setMaxHeight(22).build());
		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_8, PFFeatures.SCHIZOLEPIDOPSIS_TREE_8.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get()).setMinHeight(20).setMaxHeight(23).build());
		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREE_9, PFFeatures.SCHIZOLEPIDOPSIS_TREE_9.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(PFBlocks.SCHIZOLEPIDOPSIS_LEAVES.get()).setMinHeight(21).setMaxHeight(24).build());

		FeatureUtils.register(bootstapContext, PODOZAMITES_TREE_1, PFFeatures.PODOZAMITES_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PODOZAMITES_LOG.get()).setLeavesBlock(PFBlocks.PODOZAMITES_LEAVES.get()).setMinHeight(9).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, PODOZAMITES_TREE_2, PFFeatures.PODOZAMITES_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PODOZAMITES_LOG.get()).setLeavesBlock(PFBlocks.PODOZAMITES_LEAVES.get()).setMinHeight(11).setMaxHeight(14).build());
		FeatureUtils.register(bootstapContext, PODOZAMITES_TREE_3, PFFeatures.PODOZAMITES_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PODOZAMITES_LOG.get()).setLeavesBlock(PFBlocks.PODOZAMITES_LEAVES.get()).setMinHeight(13).setMaxHeight(16).build());
		FeatureUtils.register(bootstapContext, PODOZAMITES_TREE_4, PFFeatures.PODOZAMITES_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PODOZAMITES_LOG.get()).setLeavesBlock(PFBlocks.PODOZAMITES_LEAVES.get()).setMinHeight(16).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, PODOZAMITES_TREE_5, PFFeatures.PODOZAMITES_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PODOZAMITES_LOG.get()).setLeavesBlock(PFBlocks.PODOZAMITES_LEAVES.get()).setMinHeight(19).setMaxHeight(22).build());
		FeatureUtils.register(bootstapContext, PODOZAMITES_TREE_6, PFFeatures.PODOZAMITES_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PODOZAMITES_LOG.get()).setLeavesBlock(PFBlocks.PODOZAMITES_LEAVES.get()).setMinHeight(22).setMaxHeight(25).build());

		FeatureUtils.register(bootstapContext, DEAD_TAXUS_TREE_1, PFFeatures.TAXUS_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_TAXUS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(5).setMaxHeight(8).build());
		FeatureUtils.register(bootstapContext, DEAD_TAXUS_TREE_2, PFFeatures.TAXUS_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_TAXUS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(4).setMaxHeight(7).build());
		FeatureUtils.register(bootstapContext, DEAD_TAXUS_TREE_3, PFFeatures.TAXUS_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_TAXUS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(8).setMaxHeight(11).build());
		FeatureUtils.register(bootstapContext, DEAD_TAXUS_TREE_4, PFFeatures.TAXUS_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_TAXUS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(10).setMaxHeight(13).build());
		FeatureUtils.register(bootstapContext, DEAD_TAXUS_TREE_5, PFFeatures.TAXUS_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_TAXUS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(11).setMaxHeight(14).build());
		FeatureUtils.register(bootstapContext, DEAD_TAXUS_TREE_6, PFFeatures.TAXUS_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_TAXUS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(16).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, DEAD_TAXUS_TREE_7, PFFeatures.TAXUS_TREE_7.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_TAXUS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(17).setMaxHeight(20).build());
		FeatureUtils.register(bootstapContext, DEAD_TAXUS_TREE_8, PFFeatures.TAXUS_TREE_8.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_TAXUS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(17).setMaxHeight(20).build());

		FeatureUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_1, PFFeatures.CZEKANOWSKIA_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_CZEKANOWSKIA_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(5).setMaxHeight(8).build());
		FeatureUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_2, PFFeatures.CZEKANOWSKIA_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_CZEKANOWSKIA_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(8).setMaxHeight(11).build());
		FeatureUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_3, PFFeatures.CZEKANOWSKIA_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_CZEKANOWSKIA_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(9).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_4, PFFeatures.CZEKANOWSKIA_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_CZEKANOWSKIA_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(13).setMaxHeight(16).build());
		FeatureUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_5, PFFeatures.CZEKANOWSKIA_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_CZEKANOWSKIA_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(15).setMaxHeight(18).build());
		FeatureUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREE_6, PFFeatures.CZEKANOWSKIA_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_CZEKANOWSKIA_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(13).setMaxHeight(16).build());

		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_1, PFFeatures.SCHIZOLEPIDOPSIS_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(6).setMaxHeight(9).build());
		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_2, PFFeatures.SCHIZOLEPIDOPSIS_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(9).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_3, PFFeatures.SCHIZOLEPIDOPSIS_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(11).setMaxHeight(14).build());
		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_4, PFFeatures.SCHIZOLEPIDOPSIS_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(14).setMaxHeight(17).build());
		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_5, PFFeatures.SCHIZOLEPIDOPSIS_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(15).setMaxHeight(18).build());
		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_6, PFFeatures.SCHIZOLEPIDOPSIS_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(16).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_7, PFFeatures.SCHIZOLEPIDOPSIS_TREE_7.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(19).setMaxHeight(22).build());
		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_8, PFFeatures.SCHIZOLEPIDOPSIS_TREE_8.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(20).setMaxHeight(23).build());
		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREE_9, PFFeatures.SCHIZOLEPIDOPSIS_TREE_9.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_SCHIZOLEPIDOPSIS_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(21).setMaxHeight(24).build());

		FeatureUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_1, PFFeatures.PODOZAMITES_TREE_1.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_PODOZAMITES_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(9).setMaxHeight(12).build());
		FeatureUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_2, PFFeatures.PODOZAMITES_TREE_2.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_PODOZAMITES_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(11).setMaxHeight(14).build());
		FeatureUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_3, PFFeatures.PODOZAMITES_TREE_3.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_PODOZAMITES_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(13).setMaxHeight(16).build());
		FeatureUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_4, PFFeatures.PODOZAMITES_TREE_4.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_PODOZAMITES_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(16).setMaxHeight(19).build());
		FeatureUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_5, PFFeatures.PODOZAMITES_TREE_5.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_PODOZAMITES_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(19).setMaxHeight(22).build());
		FeatureUtils.register(bootstapContext, DEAD_PODOZAMITES_TREE_6, PFFeatures.PODOZAMITES_TREE_6.get(), new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.STRIPPED_PODOZAMITES_LOG.get()).setLeavesBlock(Blocks.AIR).setMinHeight(22).setMaxHeight(25).build());

		FeatureUtils.register(bootstapContext, FALLEN_DRYOPHYLLUM_LOG, PFFeatures.DRYOPHYLLUM_FALLEN_LOG.get(), new JohnstoniaConfig(1));
		FeatureUtils.register(bootstapContext, FALLEN_TAXODIUM_LOG, PFFeatures.TAXODIUM_FALLEN_LOG.get(), new JohnstoniaConfig(1));
		FeatureUtils.register(bootstapContext, FALLEN_METASEQUOIA_LOG, PFFeatures.METASEQUOIA_FALLEN_LOG.get(), new JohnstoniaConfig(1));
		FeatureUtils.register(bootstapContext, FALLEN_PLATANITES_LOG, PFFeatures.PLATANITES_FALLEN_LOG.get(), new JohnstoniaConfig(1));
		FeatureUtils.register(bootstapContext, FALLEN_GINKGO_LOG, PFFeatures.GINKGO_FALLEN_LOG.get(), new JohnstoniaConfig(1));

		FeatureUtils.register(bootstapContext, ZAMITES_BUSH, PFFeatures.ZAMITES_BUSH.get(), new JohnstoniaConfig(1));
		FeatureUtils.register(bootstapContext, COMMON_ZAMITES_BUSH, PFFeatures.ZAMITES_BUSH.get(), new JohnstoniaConfig(30));
		FeatureUtils.register(bootstapContext, COMMON_SABALITES, PFFeatures.SABALITES.get(), new JohnstoniaConfig(17));
		FeatureUtils.register(bootstapContext, RARE_SABALITES, PFFeatures.SABALITES.get(), new JohnstoniaConfig(3));

		FeatureUtils.register(bootstapContext, FOSSILIZED_CHALK, PFFeatures.NOISY_SPHERE.get(), new NoisySphereConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(PFBlocks.CHALK.get().defaultBlockState(), 20).add(PFBlocks.CHALK_FOSSIL.get().defaultBlockState(), 5))).setMinRadius(10).setMinYRadius(3).setMaxYRadius(8).build());
		FeatureUtils.register(bootstapContext, FOSSILIZED_SILTSTONE, PFFeatures.NOISY_SPHERE.get(), new NoisySphereConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(PFBlocks.SILTSTONE.get().defaultBlockState(), 20).add(PFBlocks.SILTSTONE_FOSSIL.get().defaultBlockState(), 5))).setMinRadius(10).setMinYRadius(3).setMaxYRadius(8).build());
		FeatureUtils.register(bootstapContext, FOSSILIZED_SANDSTONE, PFFeatures.NOISY_SPHERE.get(), new NoisySphereConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(PFBlocks.SANDSTONE.get().defaultBlockState(), 20).add(PFBlocks.SANDSTONE_FOSSIL.get().defaultBlockState(), 5))).setMinRadius(10).setMinYRadius(3).setMaxYRadius(8).build());

		FeatureUtils.register(bootstapContext, MARCHANITA, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.LIVERWORT.get()), 32));
		FeatureUtils.register(bootstapContext, BISONIA, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.BISONIA.get()), 32));
		FeatureUtils.register(bootstapContext, HORSETAILS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.HORSETAIL.get()), 32));
		FeatureUtils.register(bootstapContext, WATERLOGGED_HORSETAILS, PFFeatures.WATERLOGGED_HORSETAILS.get(), new JohnstoniaConfig(15));
		FeatureUtils.register(bootstapContext, LOWERED_HORSETAILS, PFFeatures.LOWER_HORSETAILS.get(), new JohnstoniaConfig(15));
		FeatureUtils.register(bootstapContext, RARE_LOWERED_HORSETAILS, PFFeatures.LOWER_HORSETAILS.get(), new JohnstoniaConfig(6));
		FeatureUtils.register(bootstapContext, DOUBLE_HORSETAILS, Feature.RANDOM_PATCH,grassPatch(BlockStateProvider.simple(PFBlocks.TALL_HORSETAIL.get()), 32));
		FeatureUtils.register(bootstapContext, CLUBMOSS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.CLUBMOSS.get()), 32));
		FeatureUtils.register(bootstapContext, OSMUNDA, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.OSMUNDA.get()), 32));
		FeatureUtils.register(bootstapContext, DOUBLE_OSMUNDA, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.TALL_OSMUNDA.get()), 32));
		FeatureUtils.register(bootstapContext, MOSS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.MOSS_CARPET.get()), 32));
		FeatureUtils.register(bootstapContext, ASH, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.ASH.get()), 32));
		MultifaceBlock multifaceblock = (MultifaceBlock)PFBlocks.HUMULUS.get();
		FeatureUtils.register(bootstapContext, HUMULUS, Feature.MULTIFACE_GROWTH, new MultifaceGrowthConfiguration(multifaceblock, 50, true, true, true, 0.65F, HolderSet.direct(Block::builtInRegistryHolder, PFBlocks.MOSSY_DIRT.get(), PFBlocks.LOAM.get(), Blocks.PODZOL, PFBlocks.ARAUCARIA_LOG.get(), PFBlocks.METASEQUOIA_LOG.get(), PFBlocks.TAXODIUM_LOG.get(), PFBlocks.DRYOPHYLLUM_LOG.get(), PFBlocks.GINKGO_LOG.get(), PFBlocks.PLATANITES_LOG.get())));
		FeatureUtils.register(bootstapContext, OTOZAMITES, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.OTOZAMITES.get()), 32));
		FeatureUtils.register(bootstapContext, DOUBLE_OTOZAMITES, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.TALL_OTOZAMITES.get()), 32));
		FeatureUtils.register(bootstapContext, LAUROZAMITES, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.LAUROZAMITES.get()), 32));
		FeatureUtils.register(bootstapContext, CLATHOPTERIS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.CLATHROPTERIS.get()), 32));
		FeatureUtils.register(bootstapContext, CONIOPTERIS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.CONIOPTERIS.get()), 32));
		FeatureUtils.register(bootstapContext, OSMUNDACAULIS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.OSMUNDACAULIS.get()), 32));
		FeatureUtils.register(bootstapContext, DOUBLE_OSMUNDACAULIS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.TALL_OSMUNDACAULIS.get()), 32));
		FeatureUtils.register(bootstapContext, DEAD_OSMUNDACAULIS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.DEAD_OSMUNDACAULIS.get()), 32));
		FeatureUtils.register(bootstapContext, MICHELILLOA, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.MICHELILLOA.get()), 32));
		FeatureUtils.register(bootstapContext, CLADOPHLEBIS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.CLADOPHLEBIS.get()), 32));
		FeatureUtils.register(bootstapContext, SCYTOPHYLLUM, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.SCYTOPHYLLUM.get()), 32));
		FeatureUtils.register(bootstapContext, NOTHODICHOCARPUM, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.NOTHODICHOCARPUM.get()), 32));
		FeatureUtils.register(bootstapContext, PHLEBOPTERIS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.PHLEBOPTERIS.get()), 32));
		FeatureUtils.register(bootstapContext, MARMARTHIA, PFFeatures.MARMARTHIA.get(), new JohnstoniaConfig(1));
		FeatureUtils.register(bootstapContext, LEEFRUCTUS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.LEEFRUCTUS.get()), 32));
		FeatureUtils.register(bootstapContext, RUFFORDIA, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.RUFFORDIA.get()), 32));
		FeatureUtils.register(bootstapContext, EPHEDRA, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.EPHEDRA.get()), 16));
		FeatureUtils.register(bootstapContext, ARCHAEFRUCTUS, PFFeatures.ARCHAEFRUCTUS.get(), new JohnstoniaConfig(15));
		FeatureUtils.register(bootstapContext, DOUBLE_ARCHAEFRUCTUS, PFFeatures.TALL_ARCHAEFRUCTUS.get(), new JohnstoniaConfig(15));

		FeatureUtils.register(bootstapContext, CRASSOSTREA_OYSTERS, PFFeatures.CRASSOSTREA_OYSTERS.get(), new CrassostreaOystersConfig(24));
		FeatureUtils.register(bootstapContext, ALGAE, PFFeatures.ALGAE.get(), new CrassostreaOystersConfig(24));
		FeatureUtils.register(bootstapContext, NELUMBO, PFFeatures.NELUMBO.get(), new CrassostreaOystersConfig(24));
		FeatureUtils.register(bootstapContext, QUEREUXIA, PFFeatures.QUEREUXIA.get(), new CrassostreaOystersConfig(24));
		FeatureUtils.register(bootstapContext, COBBANIA, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(PFBlocks.COBBANIA.get()), 32));
		FeatureUtils.register(bootstapContext, AZOLLA, PFFeatures.AZOLLA.get(), new JohnstoniaConfig(25));
		FeatureUtils.register(bootstapContext, ZINGIBEROPSIS, PFFeatures.ZINGIBEROPSIS.get(), new JohnstoniaConfig(15));

		FeatureUtils.register(bootstapContext, TAXODIUM_KNEES, PFFeatures.TAXODIUM_KNEES.get(), new JohnstoniaConfig(12));

		FeatureUtils.register(bootstapContext, SANDSTONE_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.SANDSTONE.defaultBlockState()));
		FeatureUtils.register(bootstapContext, BIG_SANDSTONE_ROCK, PFFeatures.BIG_BLOCK_BLOB.get(), new BlockStateConfiguration(Blocks.SANDSTONE.defaultBlockState()));
		FeatureUtils.register(bootstapContext, RED_SANDSTONE_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.RED_SANDSTONE.defaultBlockState()));
		FeatureUtils.register(bootstapContext, BIG_RED_SANDSTONE_ROCK, PFFeatures.BIG_BLOCK_BLOB.get(), new BlockStateConfiguration(Blocks.RED_SANDSTONE.defaultBlockState()));
		FeatureUtils.register(bootstapContext, MOSSY_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.MOSSY_COBBLESTONE.defaultBlockState()));

		FeatureUtils.register(bootstapContext, PTILOPHYLLUM_TREE, PFFeatures.PTILOPHYLLUM_TREE.get(), new NoneFeatureConfiguration());

		FeatureUtils.register(bootstapContext, PETRIFIED_TREE, PFFeatures.PETRIFIED_TREE.get(), new JohnstoniaConfig(10));
		FeatureUtils.register(bootstapContext, JOHNSTONIA, PFFeatures.JOHNSTONIA.get(), new JohnstoniaConfig(3));
		FeatureUtils.register(bootstapContext, DICROIDIUM, PFFeatures.DICROIDIUM.get(), new JohnstoniaConfig(6));

		FeatureUtils.register(bootstapContext, NEOCALAMITES, PFFeatures.NEOCALAMITES.get(), new JohnstoniaConfig(12));

		FeatureUtils.register(bootstapContext, CLAY_DISK, PFFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.CLAY), BlockPredicate.matchesBlocks(List.of(PFBlocks.SILT.get(), PFBlocks.HARDENED_SILT.get(), Blocks.SAND)), UniformInt.of(1, 3), 1));
		FeatureUtils.register(bootstapContext, GRAVEL_DISK, PFFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL), BlockPredicate.matchesBlocks(List.of(PFBlocks.SILT.get(), PFBlocks.HARDENED_SILT.get(), Blocks.SAND)), UniformInt.of(1, 3), 1));
		FeatureUtils.register(bootstapContext, PACKED_MUD_DISK, PFFeatures.LAND_DISK.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.PACKED_MUD), BlockPredicate.matchesBlocks(List.of(PFBlocks.SILT.get(), PFBlocks.HARDENED_SILT.get(), Blocks.SAND, Blocks.RED_SAND, PFBlocks.MOSSY_DIRT.get(), Blocks.GRAVEL)), UniformInt.of(1, 3), 1));

		FeatureUtils.register(bootstapContext, DISK_SILT, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(PFBlocks.SILT.get()), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, PFBlocks.LOAM.get(), PFBlocks.PACKED_LOAM.get(), PFBlocks.MOSSY_DIRT.get(), PFBlocks.HARDENED_SILT.get(), Blocks.PODZOL, Blocks.SAND)), UniformInt.of(8, 8), 4));
		FeatureUtils.register(bootstapContext, MUD_DISK, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.MUD), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, PFBlocks.LOAM.get(), PFBlocks.PACKED_LOAM.get(), PFBlocks.MOSSY_DIRT.get(), PFBlocks.HARDENED_SILT.get(), Blocks.PODZOL, Blocks.SAND)), UniformInt.of(1, 3), 1));

		FeatureUtils.register(bootstapContext, CALLIANTHUS, PFFeatures.CALLIANTHUS.get(), new JohnstoniaConfig(3));

		FeatureUtils.register(bootstapContext, ORE_HENOSTONE, Feature.ORE, new OreConfiguration(HENOSTONE, PFBlocks.HENOSTONE_ORE.get().defaultBlockState(), 12));
		
		HolderGetter<PlacedFeature> holderGetter = bootstapContext.lookup(Registries.PLACED_FEATURE);

		FeatureUtils.register(bootstapContext, CHINLE_SWAMP_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_1_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_2_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_3_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_AGATHOXYLON_TREE_1_CHECKED), 0.3F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_AGATHOXYLON_TREE_2_CHECKED), 0.3F)), holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, SCHILDERIA_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHILDERIA_TREE_1_CHECKED), 0.3F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHILDERIA_TREE_2_CHECKED), 0.3F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHILDERIA_TREE_3_CHECKED), 0.3F)), holderGetter.getOrThrow(PFPlacedFeatures.SCHILDERIA_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, CHINLE_FLATS_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_AGATHOXYLON_TREE_1_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_AGATHOXYLON_TREE_2_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHILDERIA_TREE_1_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHILDERIA_TREE_2_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_1_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_2_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_3_CHECKED), 0.125F)), holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, AGATHOXYLON_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LARGE_AGATHOXYLON_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LARGE_AGATHOXYLON_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LARGE_AGATHOXYLON_TREE_3_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.MEDIUM_AGATHOXYLON_TREE_1_CHECKED), 0.125F)), holderGetter.getOrThrow(PFPlacedFeatures.MEDIUM_AGATHOXYLON_TREE_2_CHECKED)));
		FeatureUtils.register(bootstapContext, CHINLE_WOODED_MOUNTAINS_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_1_CHECKED), 0.2F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_2_CHECKED), 0.2F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_3_CHECKED), 0.2F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHILDERIA_TREE_1_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHILDERIA_TREE_2_CHECKED), 0.1F)), holderGetter.getOrThrow(PFPlacedFeatures.WOODWORTHIA_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, ISCHIGUALASTO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.HEIDIPHYLLUM_TREE_1_CHECKED), 0.075F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.HEIDIPHYLLUM_TREE_2_CHECKED), 0.075F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.HEIDIPHYLLUM_TREE_3_CHECKED), 0.075F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.HEIDIPHYLLUM_TREE_4_CHECKED), 0.075F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.HEIDIPHYLLUM_TREE_5_CHECKED), 0.075F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_1_CHECKED), 0.075F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_2_CHECKED), 0.075F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_3_CHECKED), 0.075F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_4_CHECKED), 0.075F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_AGATHOXYLON_TREE_1_CHECKED), 0.03F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_AGATHOXYLON_TREE_2_CHECKED), 0.03F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.MEDIUM_AGATHOXYLON_TREE_1_CHECKED), 0.004375F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.MEDIUM_AGATHOXYLON_TREE_2_CHECKED), 0.004375F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PROTOJUNIPEROXYLON_TREE_1_CHECKED), 0.025F)), holderGetter.getOrThrow(PFPlacedFeatures.PROTOJUNIPEROXYLON_TREE_2_CHECKED)));
		FeatureUtils.register(bootstapContext, MORRISON_SAVANNA_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PROTOPICEOXYLON_TREE_1_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PROTOPICEOXYLON_TREE_2_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PROTOPICEOXYLON_TREE_3_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PROTOPICEOXYLON_TREE_4_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PROTOPICEOXYLON_TREE_5_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PROTOPICEOXYLON_TREE_6_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_1_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_2_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_3_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_4_CHECKED), 0.05F)), holderGetter.getOrThrow(PFPlacedFeatures.PROTOPICEOXYLON_TREE_7_CHECKED)));
		FeatureUtils.register(bootstapContext, SPARSE_BRACHYPHYLLUM_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BRACHYPHYLLUM_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BRACHYPHYLLUM_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BRACHYPHYLLUM_TREE_3_CHECKED), 0.25F)), holderGetter.getOrThrow(PFPlacedFeatures.BRACHYPHYLLUM_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, DRY_FOREST_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BRACHYPHYLLUM_TREE_1_CHECKED), 0.15F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BRACHYPHYLLUM_TREE_2_CHECKED), 0.15F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BRACHYPHYLLUM_TREE_3_CHECKED), 0.15F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BRACHYPHYLLUM_TREE_4_CHECKED), 0.15F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_1_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_2_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_3_CHECKED), 0.1F)), holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, SPARSE_ARAUCARIA_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_1_CHECKED), 0.4F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_2_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_3_CHECKED), 0.1F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_ARAUCARIA_CHECKED), 0.2F)), holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, TROCHODENDROIDES_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TROCHODENDROIDES_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TROCHODENDROIDES_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TROCHODENDROIDES_TREE_3_CHECKED), 0.25F)), holderGetter.getOrThrow(PFPlacedFeatures.TROCHODENDROIDES_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, ARROYO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_METASEQUOIA_TREE_1_CHECKED), 0.15F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_METASEQUOIA_TREE_2_CHECKED), 0.15F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_1_CHECKED), 0.15F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_2_CHECKED), 0.15F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_3_CHECKED), 0.15F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_4_CHECKED), 0.15F)), holderGetter.getOrThrow(PFPlacedFeatures.SMALL_METASEQUOIA_TREE_3_CHECKED)));
		FeatureUtils.register(bootstapContext, TAXODIUM_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXODIUM_TREE_1_CHECKED), 0.16F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXODIUM_TREE_2_CHECKED), 0.16F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXODIUM_TREE_3_CHECKED), 0.16F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXODIUM_TREE_4_CHECKED), 0.16F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXODIUM_TREE_5_CHECKED), 0.16F)), holderGetter.getOrThrow(PFPlacedFeatures.TAXODIUM_TREE_6_CHECKED)));
		FeatureUtils.register(bootstapContext, DRYOPHYLLUM_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DRYOPHYLLUM_TREE_1_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DRYOPHYLLUM_TREE_2_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DRYOPHYLLUM_TREE_3_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DRYOPHYLLUM_TREE_4_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DRYOPHYLLUM_TREE_5_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DRYOPHYLLUM_TREE_6_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DRYOPHYLLUM_TREE_7_CHECKED), 0.125F)), holderGetter.getOrThrow(PFPlacedFeatures.DRYOPHYLLUM_TREE_8_CHECKED)));
		FeatureUtils.register(bootstapContext, SMALL_METASEQUOIA_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_METASEQUOIA_TREE_1_CHECKED), 0.33F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_METASEQUOIA_TREE_2_CHECKED), 0.33F)), holderGetter.getOrThrow(PFPlacedFeatures.SMALL_METASEQUOIA_TREE_3_CHECKED)));
		FeatureUtils.register(bootstapContext, SMALL_GINKGO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_3_CHECKED), 0.25F)), holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, SMALL_YELLOW_GINKGO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.YELLOW_GINKGO_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.YELLOW_GINKGO_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.YELLOW_GINKGO_TREE_3_CHECKED), 0.25F)), holderGetter.getOrThrow(PFPlacedFeatures.YELLOW_GINKGO_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, SMALL_MIXED_GINKGO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.YELLOW_GINKGO_TREE_1_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.YELLOW_GINKGO_TREE_2_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.YELLOW_GINKGO_TREE_3_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_1_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_2_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_3_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.GINKGO_TREE_4_CHECKED), 0.125F)), holderGetter.getOrThrow(PFPlacedFeatures.YELLOW_GINKGO_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, LIRIODENDRITES_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LIRIODENDRITES_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LIRIODENDRITES_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LIRIODENDRITES_TREE_3_CHECKED), 0.25F)), holderGetter.getOrThrow(PFPlacedFeatures.LIRIODENDRITES_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, SMALL_ARAUCARIA_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_3_CHECKED), 0.25F)), holderGetter.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, LARGE_METASEQUOIA_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LARGE_METASEQUOIA_TREE_1_CHECKED), 0.5F)), holderGetter.getOrThrow(PFPlacedFeatures.LARGE_METASEQUOIA_TREE_2_CHECKED)));
		FeatureUtils.register(bootstapContext, LARGE_ARAUCARIA_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LARGE_ARAUCARIA_TREE_1_CHECKED), 0.5F)), holderGetter.getOrThrow(PFPlacedFeatures.LARGE_ARAUCARIA_TREE_2_CHECKED)));
		FeatureUtils.register(bootstapContext, LARGE_GINKGO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_GINKGO_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_GINKGO_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_GINKGO_TREE_3_CHECKED), 0.25F)), holderGetter.getOrThrow(PFPlacedFeatures.BIG_GINKGO_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, LARGE_YELLOW_GINKGO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_YELLOW_GINKGO_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_YELLOW_GINKGO_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_YELLOW_GINKGO_TREE_3_CHECKED), 0.25F)), holderGetter.getOrThrow(PFPlacedFeatures.BIG_YELLOW_GINKGO_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, LARGE_MIXED_GINKGO_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_YELLOW_GINKGO_TREE_1_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_YELLOW_GINKGO_TREE_2_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_YELLOW_GINKGO_TREE_3_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_GINKGO_TREE_1_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_GINKGO_TREE_2_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_GINKGO_TREE_3_CHECKED), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.BIG_GINKGO_TREE_4_CHECKED), 0.125F)), holderGetter.getOrThrow(PFPlacedFeatures.BIG_YELLOW_GINKGO_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, SMALL_PLATANITES_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_PLATANITES_TREE_1_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_PLATANITES_TREE_2_CHECKED), 0.25F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_PLATANITES_TREE_3_CHECKED), 0.25F)), holderGetter.getOrThrow(PFPlacedFeatures.SMALL_PLATANITES_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, PLATANITES_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_PLATANITES_TREE_1_CHECKED), 0.142F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_PLATANITES_TREE_2_CHECKED), 0.142F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SMALL_PLATANITES_TREE_3_CHECKED), 0.142F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LARGE_PLATANITES_TREE_1_CHECKED), 0.142F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LARGE_PLATANITES_TREE_2_CHECKED), 0.142F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.LARGE_PLATANITES_TREE_3_CHECKED), 0.142F)), holderGetter.getOrThrow(PFPlacedFeatures.SMALL_PLATANITES_TREE_4_CHECKED)));
		FeatureUtils.register(bootstapContext, TAXUS_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXUS_TREE_1), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXUS_TREE_2), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXUS_TREE_3), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXUS_TREE_4), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXUS_TREE_5), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXUS_TREE_6), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.TAXUS_TREE_7), 0.125F)), holderGetter.getOrThrow(PFPlacedFeatures.TAXUS_TREE_8)));
		FeatureUtils.register(bootstapContext, CZEKANOWSKIA_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.CZEKANOWSKIA_TREE_1), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.CZEKANOWSKIA_TREE_2), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.CZEKANOWSKIA_TREE_3), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.CZEKANOWSKIA_TREE_4), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.CZEKANOWSKIA_TREE_5), 0.1667F)), holderGetter.getOrThrow(PFPlacedFeatures.CZEKANOWSKIA_TREE_6)));
		FeatureUtils.register(bootstapContext, SCHIZOLEPIDOPSIS_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHIZOLEPIDOPSIS_TREE_1), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHIZOLEPIDOPSIS_TREE_2), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHIZOLEPIDOPSIS_TREE_3), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHIZOLEPIDOPSIS_TREE_4), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHIZOLEPIDOPSIS_TREE_5), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHIZOLEPIDOPSIS_TREE_6), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHIZOLEPIDOPSIS_TREE_7), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.SCHIZOLEPIDOPSIS_TREE_8), 0.1112F)), holderGetter.getOrThrow(PFPlacedFeatures.SCHIZOLEPIDOPSIS_TREE_9)));
		FeatureUtils.register(bootstapContext, DEAD_TAXUS_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_TAXUS_TREE_1), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_TAXUS_TREE_2), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_TAXUS_TREE_3), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_TAXUS_TREE_4), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_TAXUS_TREE_5), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_TAXUS_TREE_6), 0.125F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_TAXUS_TREE_7), 0.125F)), holderGetter.getOrThrow(PFPlacedFeatures.DEAD_TAXUS_TREE_8)));
		FeatureUtils.register(bootstapContext, DEAD_CZEKANOWSKIA_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_CZEKANOWSKIA_TREE_1), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_CZEKANOWSKIA_TREE_2), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_CZEKANOWSKIA_TREE_3), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_CZEKANOWSKIA_TREE_4), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_CZEKANOWSKIA_TREE_5), 0.1667F)), holderGetter.getOrThrow(PFPlacedFeatures.DEAD_CZEKANOWSKIA_TREE_6)));
		FeatureUtils.register(bootstapContext, DEAD_SCHIZOLEPIDOPSIS_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_1), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_2), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_3), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_4), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_5), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_6), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_7), 0.1112F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_8), 0.1112F)), holderGetter.getOrThrow(PFPlacedFeatures.DEAD_SCHIZOLEPIDOPSIS_TREE_9)));
		FeatureUtils.register(bootstapContext, PODOZAMITES_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PODOZAMITES_TREE_1), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PODOZAMITES_TREE_2), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PODOZAMITES_TREE_3), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PODOZAMITES_TREE_4), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.PODOZAMITES_TREE_5), 0.1667F)), holderGetter.getOrThrow(PFPlacedFeatures.PODOZAMITES_TREE_6)));
		FeatureUtils.register(bootstapContext, DEAD_PODOZAMITES_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_PODOZAMITES_TREE_1), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_PODOZAMITES_TREE_2), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_PODOZAMITES_TREE_3), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_PODOZAMITES_TREE_4), 0.1667F), new WeightedPlacedFeature(holderGetter.getOrThrow(PFPlacedFeatures.DEAD_PODOZAMITES_TREE_5), 0.1667F)), holderGetter.getOrThrow(PFPlacedFeatures.DEAD_PODOZAMITES_TREE_6)));
	}

	public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, F feature, FC featureConfiguration) {
		bootstapContext.register(resourceKey, new ConfiguredFeature<>(feature, featureConfiguration));
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String id) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(PrehistoricFauna.MOD_ID, id));
	}

	private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
		return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
	}

}