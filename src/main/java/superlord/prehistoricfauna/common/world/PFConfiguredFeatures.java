package superlord.prehistoricfauna.common.world;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFDecorators;
import superlord.prehistoricfauna.init.PFStructures;
import superlord.prehistoricfauna.world.feature.config.CrassostreaOystersConfig;
import superlord.prehistoricfauna.world.feature.config.JohnstoniaConfig;
import superlord.prehistoricfauna.world.feature.config.NoisySphereConfig;
import superlord.prehistoricfauna.world.feature.config.PFTreeConfig;

public class PFConfiguredFeatures {

	public static Map<String, Object> configuredFeatureRegistry = new HashMap<>();

	public static final ConfiguredFeature<PFTreeConfig, ?> METASEQUOIA_TREE_1 = createConfiguredFeature("metasequoia_tree_1", PFFeatures.METASEQUOIA_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES).setMaxHeight(53).setMinHeight(41).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> METASEQUOIA_TREE_2 = createConfiguredFeature("metasequoia_tree_2", PFFeatures.METASEQUOIA_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES).setMaxHeight(56).setMinHeight(44).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> METASEQUOIA_SMALL_TREE_1 = createConfiguredFeature("metasequoia_small_tree_1", PFFeatures.METASEQUOIA_SMALL_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES).setMinHeight(10).setMaxHeight(16).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> METASEQUOIA_SMALL_TREE_2 = createConfiguredFeature("metasequoia_small_tree_2", PFFeatures.METASEQUOIA_SMALL_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES).setMinHeight(15).setMaxHeight(21).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> METASEQUOIA_SMALL_TREE_3 = createConfiguredFeature("metasequoia_small_tree_3", PFFeatures.METASEQUOIA_SMALL_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES).setMinHeight(19).setMaxHeight(25).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> ARAUCARIA_TREE_1 = createConfiguredFeature("araucaria_tree_1", PFFeatures.ARAUCARIA_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES).setMinHeight(44).setMaxHeight(55).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> ARAUCARIA_TREE_2 = createConfiguredFeature("araucaria_tree_2", PFFeatures.ARAUCARIA_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES).setMinHeight(44).setMaxHeight(55).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> ARAUCARIA_SMALL_TREE_1 = createConfiguredFeature("araucaria_small_tree_1", PFFeatures.ARAUCARIA_SMALL_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES).setMinHeight(13).setMaxHeight(18).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> ARAUCARIA_SMALL_TREE_2 = createConfiguredFeature("araucaria_small_tree_2", PFFeatures.ARAUCARIA_SMALL_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES).setMinHeight(6).setMaxHeight(11).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> ARAUCARIA_SMALL_TREE_3 = createConfiguredFeature("araucaria_small_tree_3", PFFeatures.ARAUCARIA_SMALL_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES).setMinHeight(10).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> ARAUCARIA_SMALL_TREE_4 = createConfiguredFeature("araucaria_small_tree_4", PFFeatures.ARAUCARIA_SMALL_TREE_4.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.ARAUCARIA_LOG).setLeavesBlock(PFBlocks.ARAUCARIA_LEAVES).setMinHeight(14).setMaxHeight(19).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> LIRIODENDRITES_TREE_1 = createConfiguredFeature("liriodendrites_tree_1", PFFeatures.LIRIODENDRITES_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.LIRIODENDRITES_LOG).setLeavesBlock(PFBlocks.LIRIODENDRITES_LEAVES).setMinHeight(16).setMaxHeight(20).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> LIRIODENDRITES_TREE_2 = createConfiguredFeature("liriodendrites_tree_2", PFFeatures.LIRIODENDRITES_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.LIRIODENDRITES_LOG).setLeavesBlock(PFBlocks.LIRIODENDRITES_LEAVES).setMinHeight(7).setMaxHeight(10).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> LIRIODENDRITES_TREE_3 = createConfiguredFeature("liriodendrites_tree_3", PFFeatures.LIRIODENDRITES_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.LIRIODENDRITES_LOG).setLeavesBlock(PFBlocks.LIRIODENDRITES_LEAVES).setMinHeight(12).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> LIRIODENDRITES_TREE_4 = createConfiguredFeature("liriodendrites_tree_4", PFFeatures.LIRIODENDRITES_TREE_4.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.LIRIODENDRITES_LOG).setLeavesBlock(PFBlocks.LIRIODENDRITES_LEAVES).setMinHeight(21).setMaxHeight(24).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOPICEOXYLON_TREE_1 = createConfiguredFeature("protopiceoxylon_tree_1", PFFeatures.PROTOPICEOXYLON_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES).setMinHeight(11).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOPICEOXYLON_TREE_2 = createConfiguredFeature("protopiceoxylon_tree_2", PFFeatures.PROTOPICEOXYLON_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES).setMinHeight(9).setMaxHeight(13).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOPICEOXYLON_TREE_3 = createConfiguredFeature("protopiceoxylon_tree_3", PFFeatures.PROTOPICEOXYLON_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES).setMinHeight(13).setMaxHeight(17).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOPICEOXYLON_TREE_4 = createConfiguredFeature("protopiceoxylon_tree_4", PFFeatures.PROTOPICEOXYLON_TREE_4.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES).setMinHeight(16).setMaxHeight(20).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOPICEOXYLON_TREE_5 = createConfiguredFeature("protopiceoxylon_tree_5", PFFeatures.PROTOPICEOXYLON_TREE_5.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES).setMinHeight(7).setMaxHeight(11).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOPICEOXYLON_TREE_6 = createConfiguredFeature("protopiceoxylon_tree_6", PFFeatures.PROTOPICEOXYLON_TREE_6.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES).setMinHeight(14).setMaxHeight(18).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOPICEOXYLON_TREE_7 = createConfiguredFeature("protopiceoxylon_tree_7", PFFeatures.PROTOPICEOXYLON_TREE_7.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOPICEOXYLON_LOG).setLeavesBlock(PFBlocks.PROTOPICEOXYLON_LEAVES).setMinHeight(14).setMaxHeight(19).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> HEIDIPHYLLUM_TREE_1 = createConfiguredFeature("heidiphyllum_tree_1", PFFeatures.HEIDIPHYLLUM_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES).setMinHeight(9).setMaxHeight(12).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> HEIDIPHYLLUM_TREE_2 = createConfiguredFeature("heidiphyllum_tree_2", PFFeatures.HEIDIPHYLLUM_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES).setMinHeight(12).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> HEIDIPHYLLUM_TREE_3 = createConfiguredFeature("heidiphyllum_tree_3", PFFeatures.HEIDIPHYLLUM_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES).setMinHeight(12).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> HEIDIPHYLLUM_TREE_4 = createConfiguredFeature("heidiphyllum_tree_4", PFFeatures.HEIDIPHYLLUM_TREE_4.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES).setMinHeight(15).setMaxHeight(18).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> HEIDIPHYLLUM_TREE_5 = createConfiguredFeature("heidiphyllum_tree_5", PFFeatures.HEIDIPHYLLUM_TREE_5.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.HEIDIPHYLLUM_LOG).setLeavesBlock(PFBlocks.HEIDIPHYLLUM_LEAVES).setMinHeight(7).setMaxHeight(10).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> GINKGO_TREE_1 = createConfiguredFeature("ginkgo_tree_1", PFFeatures.GINKGO_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG).setLeavesBlock(PFBlocks.GINKGO_LEAVES).setMinHeight(16).setMaxHeight(19).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> GINKGO_TREE_2 = createConfiguredFeature("ginkgo_tree_2", PFFeatures.GINKGO_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG).setLeavesBlock(PFBlocks.GINKGO_LEAVES).setMinHeight(9).setMaxHeight(12).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> GINKGO_TREE_3 = createConfiguredFeature("ginkgo_tree_3", PFFeatures.GINKGO_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG).setLeavesBlock(PFBlocks.GINKGO_LEAVES).setMinHeight(11).setMaxHeight(14).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> GINKGO_TREE_4 = createConfiguredFeature("ginkgo_tree_4", PFFeatures.GINKGO_TREE_4.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.GINKGO_LOG).setLeavesBlock(PFBlocks.GINKGO_LEAVES).setMinHeight(9).setMaxHeight(13).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> TROCHODENDROIDES_TREE_1 = createConfiguredFeature("trochodendroides_tree_1", PFFeatures.TROCHODENDROIDES_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TROCHODENDROIDES_LOG).setLeavesBlock(PFBlocks.TROCHODENDROIDES_LEAVES).setMinHeight(4).setMaxHeight(4).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> TROCHODENDROIDES_TREE_2 = createConfiguredFeature("trochodendroides_tree_2", PFFeatures.TROCHODENDROIDES_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TROCHODENDROIDES_LOG).setLeavesBlock(PFBlocks.TROCHODENDROIDES_LEAVES).setMinHeight(5).setMaxHeight(5).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> TROCHODENDROIDES_TREE_3 = createConfiguredFeature("trochodendroides_tree_3", PFFeatures.TROCHODENDROIDES_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TROCHODENDROIDES_LOG).setLeavesBlock(PFBlocks.TROCHODENDROIDES_LEAVES).setMinHeight(6).setMaxHeight(6).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> TROCHODENDROIDES_TREE_4 = createConfiguredFeature("trochodendroides_tree_4", PFFeatures.TROCHODENDROIDES_TREE_4.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.TROCHODENDROIDES_LOG).setLeavesBlock(PFBlocks.TROCHODENDROIDES_LEAVES).setMinHeight(7).setMaxHeight(7).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> BRACHYPHYLLUM_TREE_1 = createConfiguredFeature("brachyphyllum_tree_1", PFFeatures.BRACHYPHYLLUM_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.BRACHYPHYLLUM_LOG).setLeavesBlock(PFBlocks.BRACHYPHYLLUM_LEAVES).setMinHeight(4).setMaxHeight(6).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> BRACHYPHYLLUM_TREE_2 = createConfiguredFeature("brachyphyllum_tree_2", PFFeatures.BRACHYPHYLLUM_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.BRACHYPHYLLUM_LOG).setLeavesBlock(PFBlocks.BRACHYPHYLLUM_LEAVES).setMinHeight(9).setMaxHeight(11).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> BRACHYPHYLLUM_TREE_3 = createConfiguredFeature("brachyphyllum_tree_3", PFFeatures.BRACHYPHYLLUM_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.BRACHYPHYLLUM_LOG).setLeavesBlock(PFBlocks.BRACHYPHYLLUM_LEAVES).setMinHeight(22).setMaxHeight(24).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> BRACHYPHYLLUM_TREE_4 = createConfiguredFeature("brachyphyllum_tree_4", PFFeatures.BRACHYPHYLLUM_TREE_4.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.BRACHYPHYLLUM_LOG).setLeavesBlock(PFBlocks.BRACHYPHYLLUM_LEAVES).setMinHeight(20).setMaxHeight(22).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> WOODWORTHIA_TREE_1 = createConfiguredFeature("woodworthia_tree_1", PFFeatures.WOODWORTHIA_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.WOODWORTHIA_LOG).setLeavesBlock(PFBlocks.WOODWORTHIA_LEAVES).setMinHeight(16).setMaxHeight(20).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> WOODWORTHIA_TREE_2 = createConfiguredFeature("woodworthia_tree_2", PFFeatures.WOODWORTHIA_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.WOODWORTHIA_LOG).setLeavesBlock(PFBlocks.WOODWORTHIA_LEAVES).setMinHeight(20).setMaxHeight(24).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> WOODWORTHIA_TREE_3 = createConfiguredFeature("woodworthia_tree_3", PFFeatures.WOODWORTHIA_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.WOODWORTHIA_LOG).setLeavesBlock(PFBlocks.WOODWORTHIA_LEAVES).setMinHeight(24).setMaxHeight(28).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> WOODWORTHIA_TREE_4 = createConfiguredFeature("woodworthia_tree_4", PFFeatures.WOODWORTHIA_TREE_4.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.WOODWORTHIA_LOG).setLeavesBlock(PFBlocks.WOODWORTHIA_LEAVES).setMinHeight(28).setMaxHeight(32).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> SCHILDERIA_TREE_1 = createConfiguredFeature("schilderia_tree_1", PFFeatures.SCHILDERIA_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHILDERIA_LOG).setLeavesBlock(PFBlocks.SCHILDERIA_LEAVES).setMinHeight(13).setMaxHeight(13).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> SCHILDERIA_TREE_2 = createConfiguredFeature("schilderia_tree_2", PFFeatures.SCHILDERIA_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHILDERIA_LOG).setLeavesBlock(PFBlocks.SCHILDERIA_LEAVES).setMinHeight(17).setMaxHeight(17).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> SCHILDERIA_TREE_3 = createConfiguredFeature("schilderia_tree_3", PFFeatures.SCHILDERIA_TREE_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHILDERIA_LOG).setLeavesBlock(PFBlocks.SCHILDERIA_LEAVES).setMinHeight(25).setMaxHeight(25).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> SCHILDERIA_TREE_4 = createConfiguredFeature("schilderia_tree_4", PFFeatures.SCHILDERIA_TREE_4.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.SCHILDERIA_LOG).setLeavesBlock(PFBlocks.SCHILDERIA_LEAVES).setMinHeight(35).setMaxHeight(35).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOJUNIPEROXYLON_TREE_1 = createConfiguredFeature("protojuniperoxylon_tree_1", PFFeatures.METASEQUOIA_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOJUNIPEROXYLON_LOG).setLeavesBlock(PFBlocks.PROTOJUNIPEROXYLON_LEAVES).setMaxHeight(56).setMinHeight(44).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOJUNIPEROXYLON_TREE_2 = createConfiguredFeature("protojuniperoxylon_tree_2", PFFeatures.METASEQUOIA_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOJUNIPEROXYLON_LOG).setLeavesBlock(PFBlocks.PROTOJUNIPEROXYLON_LEAVES).setMaxHeight(53).setMinHeight(41).build()));

	public static final ConfiguredFeature<PFTreeConfig, ?> SMALL_AGATHOXYLON_TREE_1 = createConfiguredFeature("small_agathoxylon_tree_1", PFFeatures.SMALL_AGATHOXYLON_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES).setMaxHeight(20).setMinHeight(20).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> SMALL_AGATHOXYLON_TREE_2 = createConfiguredFeature("small_agathoxylon_tree_2", PFFeatures.SMALL_AGATHOXYLON_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES).setMaxHeight(25).setMinHeight(25).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> MEDIUM_AGATHOXYLON_TREE_1 = createConfiguredFeature("medium_agathoxylon_tree_1", PFFeatures.MEDIUM_AGATHOXYLON_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES).setMaxHeight(33).setMinHeight(33).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> MEDIUM_AGATHOXYLON_TREE_2 = createConfiguredFeature("medium_agathoxylon_tree_2", PFFeatures.MEDIUM_AGATHOXYLON_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES).setMaxHeight(41).setMinHeight(41).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> LARGE_AGATHOXYLON_TREE_1 = createConfiguredFeature("large_agathoxylon_tree_1", PFFeatures.LARGE_AGATHOXYLON_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES).setMaxHeight(44).setMinHeight(44).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> LARGE_AGATHOXYLON_TREE_2 = createConfiguredFeature("large_agathoxylon_tree_2", PFFeatures.LARGE_AGATHOXYLON_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES).setMaxHeight(55).setMinHeight(55).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> LARGE_AGATHOXYLON_TREE_3 = createConfiguredFeature("large_agathoxylon_tree_3", PFFeatures.LARGE_AGATHOXYLON_3.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.AGATHOXYLON_LOG).setLeavesBlock(PFBlocks.AGATHOXYLON_LEAVES).setMaxHeight(60).setMinHeight(60).build()));

	public static final ConfiguredFeature<?, ?> DUMMY_TREE = createConfiguredFeature("dummy_trees", PFFeatures.DUMMY.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10000, 0.4F, 8))));

	public static final ConfiguredFeature<?, ?> FOSSILIZED_CHALK = createConfiguredFeature("fossilized_chalk", PFFeatures.NOISY_SPHERE.withConfiguration(new NoisySphereConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(PFBlocks.CHALK.getDefaultState(), PrehistoricFaunaConfig.baseStoneWeight).addWeightedBlockstate(PFBlocks.CHALK_FOSSIL.getDefaultState(), PrehistoricFaunaConfig.fossilWeight)).setMinRadius(4).setMaxRadius(10).setMinYRadius(3).setMaxYRadius(8).build()).withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(54, 5))).square().func_242731_b(1));
	public static final ConfiguredFeature<?, ?> FOSSILIZED_SILTSTONE = createConfiguredFeature("fossilized_siltstone", PFFeatures.NOISY_SPHERE.withConfiguration(new NoisySphereConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(PFBlocks.SILTSTONE.getDefaultState(), PrehistoricFaunaConfig.baseStoneWeight).addWeightedBlockstate(PFBlocks.SILTSTONE_FOSSIL.getDefaultState(), PrehistoricFaunaConfig.fossilWeight)).setMinRadius(4).setMaxRadius(10).setMinYRadius(3).setMaxYRadius(8).build()).withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(46, 7))).square().func_242731_b(1));
	public static final ConfiguredFeature<?, ?> FOSSILIZED_SANDSTONE = createConfiguredFeature("fossilized_sandstone", PFFeatures.NOISY_SPHERE.withConfiguration(new NoisySphereConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(PFBlocks.SANDSTONE.getDefaultState(), PrehistoricFaunaConfig.baseStoneWeight).addWeightedBlockstate(PFBlocks.SANDSTONE_FOSSIL.getDefaultState(), PrehistoricFaunaConfig.fossilWeight)).setMinRadius(4).setMaxRadius(10).setMinYRadius(3).setMaxYRadius(8).build()).withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(38, 5))).square().func_242731_b(1));
	
	public static final ConfiguredFeature<?, ?> JURASSIC_FOSSILIZED_SANDSTONE = createConfiguredFeature("fossilized_sandstone", PFFeatures.NOISY_SPHERE.withConfiguration(new NoisySphereConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(PFBlocks.SANDSTONE.getDefaultState(), PrehistoricFaunaConfig.baseStoneWeight).addWeightedBlockstate(PFBlocks.SANDSTONE_FOSSIL.getDefaultState(), PrehistoricFaunaConfig.fossilWeight)).setMinRadius(4).setMaxRadius(10).setMinYRadius(3).setMaxYRadius(8).build()).withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(54, 5))).square().func_242731_b(1));

	public static final ConfiguredFeature<?, ?> CRETACEOUS_FOSSILIZED_SILTSTONE = createConfiguredFeature("fossilized_siltstone", PFFeatures.NOISY_SPHERE.withConfiguration(new NoisySphereConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(PFBlocks.SILTSTONE.getDefaultState(), PrehistoricFaunaConfig.baseStoneWeight).addWeightedBlockstate(PFBlocks.SILTSTONE_FOSSIL.getDefaultState(), PrehistoricFaunaConfig.fossilWeight)).setMinRadius(4).setMaxRadius(10).setMinYRadius(3).setMaxYRadius(8).build()).withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(54, 5))).square().func_242731_b(1));
	public static final ConfiguredFeature<?, ?> CRETACEOUS_FOSSILIZED_SANDSTONE = createConfiguredFeature("fossilized_sandstone", PFFeatures.NOISY_SPHERE.withConfiguration(new NoisySphereConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(PFBlocks.SANDSTONE.getDefaultState(), PrehistoricFaunaConfig.baseStoneWeight).addWeightedBlockstate(PFBlocks.SANDSTONE_FOSSIL.getDefaultState(), PrehistoricFaunaConfig.fossilWeight)).setMinRadius(4).setMaxRadius(10).setMinYRadius(3).setMaxYRadius(8).build()).withPlacement(Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(46, 7))).square().func_242731_b(1));
	
	public static final ConfiguredFeature<?, ?> DEAD_ARAUCARIA = createConfiguredFeature("dead_araucaria", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.STRIPPED_ARAUCARIA_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(6, 6, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
	
	//Hell Creek
	public static final ConfiguredFeature<?, ?> MARCHANTIA = createConfiguredFeature("marchantia", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.MARCHANTIA.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(5)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> HORSETAIL = createConfiguredFeature("horsetail", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.HORSETAIL.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(1)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> DJADOCHTA_HORSETAILS = createConfiguredFeature("djadochta_horsetails", PFFeatures.DJADOCHTA_HORSETAILS_FEATURE.withConfiguration(new JohnstoniaConfig(15)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> HORSETAIL_DOUBLE = createConfiguredFeature("double_horsetail", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.TALL_HORSETAIL.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(20)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> CLUBMOSS = createConfiguredFeature("clubmoss", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CLUBMOSS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> OSMUNDA = createConfiguredFeature("osmunda", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.OSMUNDA.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(2)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> OSMUNDA_DOUBLE = createConfiguredFeature("double_osmunda", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.TALL_OSMUNDA.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(20)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> MOSS = createConfiguredFeature("moss", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.MOSS_CARPET.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> OTOZAMITES = createConfiguredFeature("otozamites", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.OTOZAMITES.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(5)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> TALL_OTOZAMITES = createConfiguredFeature("tall_otozamites", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.TALL_OTOZAMITES.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(15)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> LAUROZAMITES = createConfiguredFeature("laurozamites", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.LAUROZAMITES.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(1)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> CLATHOPTERIS = createConfiguredFeature("clathopteris", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CLATHOPTERIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(1)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> SPARSE_CLATHOPTERIS = createConfiguredFeature("sparse_clathopteris", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CLATHOPTERIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(50)).func_242731_b(5));

	public static final ConfiguredFeature<?, ?> CRASSOSTREA_OYSTERS = createConfiguredFeature("crassostrea_oysters", PFFeatures.CRASSOSTREA_OYSTERS_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).func_242731_b(48).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));
	public static final ConfiguredFeature<?, ?> ALGAE = createConfiguredFeature("algae", PFFeatures.ALGAE_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).func_242731_b(48).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));

	//Djadochta
	public static final ConfiguredFeature<?, ?> SANDSTONE_ROCK = createConfiguredFeature("sandstone_rock", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.SANDSTONE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));
	public static final ConfiguredFeature<?, ?> BIG_SANDSTONE_ROCK = createConfiguredFeature("big_sandstone_rock", PFFeatures.BIG_BLOB.withConfiguration(new BlockStateFeatureConfig(Blocks.SANDSTONE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(1));
	public static final ConfiguredFeature<?, ?> COBBANIA = createConfiguredFeature("cobbania", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.COBBANIA.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(10).build()).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(4));
	public static final ConfiguredFeature<?, ?> RED_SANDSTONE_ROCK = createConfiguredFeature("red_sandstone_rock", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.RED_SANDSTONE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));
	public static final ConfiguredFeature<?, ?> BIG_RED_SANDSTONE_ROCK = createConfiguredFeature("big_red_sandstone_rock", PFFeatures.BIG_BLOB.withConfiguration(new BlockStateFeatureConfig(Blocks.RED_SANDSTONE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(1));

	//Morrison
	public static final ConfiguredFeature<?, ?> PTILOPHYLLUM_TREE_BOOGALOO = createConfiguredFeature("ptilophylium_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PFFeatures.PTILOPHYLLUM_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(PFDecorators.PTILOPHYLLUM_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).withChance(0.05F)), PFFeatures.PTILOPHYLLUM_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(PFDecorators.PTILOPHYLLUM_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)))));

	public static final ConfiguredFeature<?, ?> CONIOPTERIS = createConfiguredFeature("coniopteris", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CONIOPTERIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(1)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> MORRISON_HORSETAILS = createConfiguredFeature("morrison_horestails", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.HORSETAIL.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(50)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> MORRISON_DOUBLE_HORSETAILS = createConfiguredFeature("morrison_double_horestails", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.TALL_HORSETAIL.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(75)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> OSMUNDACAULIS = createConfiguredFeature("osmundacaulis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.OSMUNDACAULIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(25)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> TALL_OSMUNDACAULIS = createConfiguredFeature("tall_osmundacaulist", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.TALL_OSMUNDACAULIS.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(35)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> DEAD_OSMUNDACAULIS = createConfiguredFeature("dead_osmundacaulis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.DEAD_OSMUNDACAULIS.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(4).build()).withPlacement(Features.Placements.PATCH_PLACEMENT));
	public static final ConfiguredFeature<?, ?> RARE_CLADOPHLEBIS = createConfiguredFeature("rare_cladophlebis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CLADOPHLEBIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(70)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> RARE_DEAD_OSMUNDACAULIS = createConfiguredFeature("dead_osmundacaulis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.DEAD_OSMUNDACAULIS.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(4).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(70)));

	public static final ConfiguredFeature<?, ?> PETRIFIED_TREE = createConfiguredFeature("petrified_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.PETRIFIED_WOOD.getDefaultState()), new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(15)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> ZAMITES_BUSH = createConfiguredFeature("zamites_bush", PFFeatures.ZAMITES_BUSH.withConfiguration(new JohnstoniaConfig(1)).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(15)));

	public static final ConfiguredFeature<?, ?> COMMON_ZAMITES_BUSH = createConfiguredFeature("zamites_bush", PFFeatures.ZAMITES_BUSH.withConfiguration(new JohnstoniaConfig(30)).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)));

	public static final ConfiguredFeature<?, ?> ORE_IRON_EXTRA = createConfiguredFeature("ore_iron_extra", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, Blocks.IRON_ORE.getDefaultState(), 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(32, 32, 80))).square().func_242731_b(20));

	//Ischigualasto
	public static final ConfiguredFeature<?, ?> MICHELILLOA = createConfiguredFeature("michelilloa", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.MICHELILLOA.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(5)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> CLADOPHLEBIS = createConfiguredFeature("cladophlebis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CLADOPHLEBIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(1)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> SCYTOPHYLLUM = createConfiguredFeature("scytophyllum", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.SCYTOPHYLLUM.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(60)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> JOHNSTONIA = createConfiguredFeature("johnstonia", PFFeatures.JOHNSTONIA_FEATURE.withConfiguration(new JohnstoniaConfig(3)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> DICROIDIUM = createConfiguredFeature("dicroidium", PFFeatures.DICROIDIUM_FEATURE.withConfiguration(new JohnstoniaConfig(6)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	
	public static final ConfiguredFeature<?, ?> SPARSE_JOHNSTONIA = createConfiguredFeature("sparse_johnstonia", PFFeatures.JOHNSTONIA_FEATURE.withConfiguration(new JohnstoniaConfig(1)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> SPARSE_DICROIDIUM = createConfiguredFeature("sparse_dicroidium", PFFeatures.DICROIDIUM_FEATURE.withConfiguration(new JohnstoniaConfig(1)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));	

	//Chinle
	public static final ConfiguredFeature<?, ?> NEOCALAMITES = createConfiguredFeature("neocalamites", PFFeatures.NEOCALAMITES_FEATURE.withConfiguration(new JohnstoniaConfig(12)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> PHLEBOPTERIS = createConfiguredFeature("phlebopteris", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.PHLEBOPTERIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(1)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> CLAY_DISKS = createConfiguredFeature("clay_disks", PFFeatures.LAND_DISK_FEATURE.withConfiguration(new SphereReplaceConfig(Blocks.CLAY.getDefaultState(), FeatureSpread.func_242253_a(3, 1), 1, ImmutableList.of(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), Blocks.SAND.getDefaultState()))).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> GRAVEL_DISKS = createConfiguredFeature("gravel_disks", PFFeatures.LAND_DISK_FEATURE.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(2, 1), 1, ImmutableList.of(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), Blocks.SAND.getDefaultState()))).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> SPARSE_NEOCALAMITES = createConfiguredFeature("sparse_neocalamites", PFFeatures.NEOCALAMITES_FEATURE.withConfiguration(new JohnstoniaConfig(3)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> SPARSE_CLADOPHLEBIS = createConfiguredFeature("sparse_cladophlebis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CLADOPHLEBIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> SPARSE_PHLEBOPTERIS = createConfiguredFeature("sparse_phlebopteris", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.PHLEBOPTERIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(25)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> SPARSE_HORSETAILS = createConfiguredFeature("sparse_horsetails", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.HORSETAIL.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(25)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> SPARSE_OTOZAMITES = createConfiguredFeature("sparse_otozamites", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.OTOZAMITES.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(25)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> FREQUENT_NEOCALAMITES = createConfiguredFeature("frequent_neocalamites", PFFeatures.NEOCALAMITES_FEATURE.withConfiguration(new JohnstoniaConfig(15)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> WATERLOGGED_TALL_HORSETAILS = createConfiguredFeature("waterlogged_tall_horsetails", PFFeatures.TALL_HORSETAILS_FEATURE.withConfiguration(new JohnstoniaConfig(12)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> FREQUENT_PHLEBOPTERIS = createConfiguredFeature("frequent_phlebopteris", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.PHLEBOPTERIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(1)).func_242731_b(5));

	//Disks
	public static final ConfiguredFeature<?, ?> PREHISTORIC_CLAY_DISKS = createConfiguredFeature("prehistoric_clay_disks", Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.CLAY.getDefaultState(), FeatureSpread.func_242253_a(3, 1), 1, ImmutableList.of(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), Blocks.SAND.getDefaultState()))).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> PREHISTORIC_GRAVEL_DISKS = createConfiguredFeature("prehistoric_gravel_disks", Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(3, 1), 1, ImmutableList.of(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), Blocks.SAND.getDefaultState()))).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> PREHISTORIC_SAND_DISKS = createConfiguredFeature("prehistoric_sand_disks", Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), FeatureSpread.func_242253_a(3, 1), 1, ImmutableList.of(PFBlocks.SILT.getDefaultState(), PFBlocks.HARDENED_SILT.getDefaultState(), Blocks.SAND.getDefaultState()))).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)).func_242731_b(5));
	
	public static StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> HELL_CREEK_HUT;// = register("hell_creek_hut", PFStructures.HELL_CREEK_HUT.withConfiguration(NoFeatureConfig.field_236559_b_));
	public static StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> MORRISON_HUT;// = register("morrison_hut", PFStructures.MORRISON_HUT.withConfiguration(NoFeatureConfig.field_236559_b_));
	public static StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> ISCHIGUALASTO_HUT;// = register("ischigualasto_hut", PFStructures.ISCHIGUALASTO_HUT.withConfiguration(NoFeatureConfig.field_236559_b_));
	public static StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> PORTAL_CHAMBER;// = register("portal_chamber", PFStructures.PORTAL_CHAMBER.withConfiguration(NoFeatureConfig.field_236559_b_));

	@SuppressWarnings("unused")
	private static <FC extends IFeatureConfig, F extends Structure<FC>> StructureFeature<FC, F> register(String name, StructureFeature<FC, F> structure) {
		ResourceLocation pfID = new ResourceLocation(PrehistoricFauna.MOD_ID, name);
		if (WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE.keySet().contains(pfID))
			throw new IllegalStateException("Configured Feature ID: \"" + pfID.toString() + "\" already exists in the Configured Features registry!");
		return structure;
	}

	//public static final ConfiguredFeature<?, ?> ALGAE = createConfiguredFeature("algae", PFFeatures.ALGAE_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	//public static final ConfiguredFeature<?, ?> CRASSOSTREA_OYSTERS = createConfiguredFeature("crassostrea_oysters", PFFeatures.CRASSOSTREA_OYSTERS_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

	public static <FC extends IFeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
		ResourceLocation pfID = new ResourceLocation(PrehistoricFauna.MOD_ID, id);
		if (WorldGenRegistries.CONFIGURED_FEATURE.keySet().contains(pfID))
			throw new IllegalStateException("Configured Feature ID: \"" + pfID.toString() + "\" already exists in the Configured Features registry!");
		configuredFeatureRegistry.put(pfID.toString(), configuredFeature);
		return configuredFeature;
	}


	public static void withHCRocks(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Features.FOREST_ROCK);
	}

	public static void withDjadochtaRocks(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, SANDSTONE_ROCK);
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BIG_SANDSTONE_ROCK);
	}
	
	public static void withClayDisks(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, CLAY_DISKS);
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, GRAVEL_DISKS);
	}

	public static void withHellCreekVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MARCHANTIA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLUBMOSS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDA_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HELL_CREEK_GINKGOS);
	}
	
	public static void withHellCreekRiverVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MARCHANTIA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLUBMOSS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDA_DOUBLE);
	}

	public static void withDeadPlants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS);
	}
	
	public static void withRareDeadCycadeoid(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, RARE_DEAD_OSMUNDACAULIS);
	}

	public static void withDjadochtaPlants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DJADOCHTA_HORSETAILS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
	}

	public static void withArroyoPlants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, COBBANIA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TROCHODENDROIDES_VEGETATION);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, WATERLOGGED_TALL_HORSETAILS);
	}
	
	public static void withChinlePlants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS);;
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, NEOCALAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CHINLE_SWAMP_TREES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SCHILDERIA_TREES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AGATHOXYLON_TREES);
	}
	
	public static void withChinleFlatsPlants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FREQUENT_NEOCALAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CHINLE_FLATS_TREES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_CLADOPHLEBIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_CLATHOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_PHLEBOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_OTOZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, COMMON_ZAMITES_BUSH);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, WATERLOGGED_TALL_HORSETAILS);
	}
	
	public static void withChinleRiverPlants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FREQUENT_NEOCALAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_CLADOPHLEBIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_CLATHOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_PHLEBOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_OTOZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, COMMON_ZAMITES_BUSH);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, WATERLOGGED_TALL_HORSETAILS);
	}

	public static void withChinleWoodedMountainsPlants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CHINLE_WOODED_MOUNTAIN_TREES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SCHILDERIA_TREES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PHLEBOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FREQUENT_PHLEBOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MOSS);
		DefaultBiomeFeatures.withForestRocks(builder);
	}
	
	public static final ConfiguredFeature<?, ?> HELL_CREEK_VEGETATION = createConfiguredFeature("hell_creek_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			METASEQUOIA_TREE_1.withChance(0.1F),
			METASEQUOIA_TREE_2.withChance(0.1F),
			LIRIODENDRITES_TREE_1.withChance(0.05F),
			LIRIODENDRITES_TREE_2.withChance(0.05F),
			LIRIODENDRITES_TREE_3.withChance(0.05F),
			LIRIODENDRITES_TREE_4.withChance(0.05F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_4.withChance(0.1F),
			ARAUCARIA_TREE_1.withChance(0.1F)),
			ARAUCARIA_TREE_2))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(8, 0.2F, 3))));
	
	public static final ConfiguredFeature<?, ?> HELL_CREEK_GINKGOS = createConfiguredFeature("hell_creek_ginkgos", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			GINKGO_TREE_1.withChance(0.25F),
			GINKGO_TREE_2.withChance(0.25F),
			GINKGO_TREE_3.withChance(0.24F)),
			GINKGO_TREE_4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.25F, 2))));

	public static final ConfiguredFeature<?, ?> CHINLE_SWAMP_TREES = createConfiguredFeature("chinle_swamp_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			WOODWORTHIA_TREE_1.withChance(0.1F),
			WOODWORTHIA_TREE_2.withChance(0.1F),
			WOODWORTHIA_TREE_3.withChance(0.1F),
			SMALL_AGATHOXYLON_TREE_1.withChance(0.3F),
			SMALL_AGATHOXYLON_TREE_2.withChance(0.3F)),
			WOODWORTHIA_TREE_4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.25F, 2))));

	public static final ConfiguredFeature<?, ?> SCHILDERIA_TREES = createConfiguredFeature("schilderia_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			SCHILDERIA_TREE_1.withChance(0.3F),
			SCHILDERIA_TREE_2.withChance(0.3F),
			SCHILDERIA_TREE_3.withChance(0.3F)),
			SCHILDERIA_TREE_4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.15F, 1))));
	
	public static final ConfiguredFeature<?, ?> AGATHOXYLON_TREES = createConfiguredFeature("agathoxylon_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			LARGE_AGATHOXYLON_TREE_1.withChance(0.25F),
			LARGE_AGATHOXYLON_TREE_2.withChance(0.25F),
			LARGE_AGATHOXYLON_TREE_3.withChance(0.25F),
			MEDIUM_AGATHOXYLON_TREE_1.withChance(0.125F)),
			MEDIUM_AGATHOXYLON_TREE_2)).withPlacement(PFDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.15F, 2))));
	
	public static final ConfiguredFeature<?, ?> SPARSE_HELL_CREEK_VEGETATION = createConfiguredFeature("sparse_hell_creek_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			METASEQUOIA_TREE_1.withChance(0.1F),
			METASEQUOIA_TREE_2.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.15F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.15F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.15F),
			ARAUCARIA_SMALL_TREE_4.withChance(0.15F),
			ARAUCARIA_TREE_1.withChance(0.1F)
			), ARAUCARIA_TREE_2))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

	public static final ConfiguredFeature<?, ?> LIRIODENDRITES_FOREST_VEGETATION = createConfiguredFeature("liriodendrites_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			LIRIODENDRITES_TREE_1.withChance(0.2F),
			LIRIODENDRITES_TREE_2.withChance(0.2F),
			LIRIODENDRITES_TREE_3.withChance(0.2F),
			LIRIODENDRITES_TREE_4.withChance(0.2F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.05F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.05F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.05F)
			), ARAUCARIA_SMALL_TREE_4))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(8, 0.2F, 3))));

	public static ConfiguredFeature<?, ?> DJADOCHTA_ARROYO_VEGETATION = createConfiguredFeature("djadochta_arroyo_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			METASEQUOIA_SMALL_TREE_1.withChance(0.15F),
			METASEQUOIA_SMALL_TREE_2.withChance(0.15F),
			GINKGO_TREE_1.withChance(0.15F),
			GINKGO_TREE_2.withChance(0.15F),
			GINKGO_TREE_3.withChance(0.15F),
			GINKGO_TREE_4.withChance(0.15F)
			), METASEQUOIA_SMALL_TREE_3))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.25F, 1))));

	public static ConfiguredFeature<?, ?> TROCHODENDROIDES_VEGETATION = createConfiguredFeature("trochodendroides_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			TROCHODENDROIDES_TREE_1.withChance(0.25F),
			TROCHODENDROIDES_TREE_2.withChance(0.25F),
			TROCHODENDROIDES_TREE_3.withChance(0.25F)
			), TROCHODENDROIDES_TREE_4))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.25F, 1))));


	public static ConfiguredFeature<?, ?> MORRISON_SAVANNA_VEGETATION = createConfiguredFeature("morrison_savanna_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			PROTOPICEOXYLON_TREE_1.withChance(0.1F),
			PROTOPICEOXYLON_TREE_2.withChance(0.1F),
			PROTOPICEOXYLON_TREE_3.withChance(0.1F),
			PROTOPICEOXYLON_TREE_4.withChance(0.1F),
			PROTOPICEOXYLON_TREE_5.withChance(0.1F),
			PROTOPICEOXYLON_TREE_6.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_4.withChance(0.05F)
			), PROTOPICEOXYLON_TREE_7))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.25F, 1))));

	public static ConfiguredFeature<?, ?> ISCHIGUALASTO_VEGETATION = createConfiguredFeature("ischigualasto_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			HEIDIPHYLLUM_TREE_1.withChance(0.075F),
			HEIDIPHYLLUM_TREE_2.withChance(0.075F),
			HEIDIPHYLLUM_TREE_3.withChance(0.075F),
			HEIDIPHYLLUM_TREE_4.withChance(0.075F),
			HEIDIPHYLLUM_TREE_5.withChance(0.075F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.075F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.075F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.075F),
			ARAUCARIA_SMALL_TREE_4.withChance(0.075F),
			SMALL_AGATHOXYLON_TREE_1.withChance(0.03F),
			SMALL_AGATHOXYLON_TREE_2.withChance(0.03F),
			MEDIUM_AGATHOXYLON_TREE_1.withChance(0.004375F),
			MEDIUM_AGATHOXYLON_TREE_2.withChance(0.004375F),
			PROTOJUNIPEROXYLON_TREE_1.withChance(0.025F)
			), PROTOJUNIPEROXYLON_TREE_2))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(8, 0.2F, 3))));

	public static ConfiguredFeature<?, ?> SPARSE_ISCHIGUALASTO_VEGETATION = createConfiguredFeature("sparse_ischigualasto_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			HEIDIPHYLLUM_TREE_1.withChance(0.075F),
			HEIDIPHYLLUM_TREE_2.withChance(0.075F),
			HEIDIPHYLLUM_TREE_3.withChance(0.075F),
			HEIDIPHYLLUM_TREE_4.withChance(0.075F),
			HEIDIPHYLLUM_TREE_5.withChance(0.075F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.075F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.075F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.075F),
			ARAUCARIA_SMALL_TREE_4.withChance(0.075F),
			SMALL_AGATHOXYLON_TREE_1.withChance(0.03F),
			SMALL_AGATHOXYLON_TREE_2.withChance(0.03F),
			MEDIUM_AGATHOXYLON_TREE_1.withChance(0.004375F),
			MEDIUM_AGATHOXYLON_TREE_2.withChance(0.004375F),
			PROTOJUNIPEROXYLON_TREE_1.withChance(0.025F)
			), PROTOJUNIPEROXYLON_TREE_2))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

	public static ConfiguredFeature<?, ?> DRY_FOREST = createConfiguredFeature("small_araucarias", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			BRACHYPHYLLUM_TREE_1.withChance(0.15F),
			BRACHYPHYLLUM_TREE_2.withChance(0.15F),
			BRACHYPHYLLUM_TREE_3.withChance(0.15F),
			BRACHYPHYLLUM_TREE_4.withChance(0.15F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.1F)
			), ARAUCARIA_SMALL_TREE_4))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.2F, 3))));

	public static ConfiguredFeature<?, ?> SPARSE_SMALL_ARAUCARIAS = createConfiguredFeature("sparse_small_araucarias", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			ARAUCARIA_SMALL_TREE_1.withChance(0.4F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.1F),
			DEAD_ARAUCARIA.withChance(0.2F)
			), ARAUCARIA_SMALL_TREE_4))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

	public static ConfiguredFeature<?, ?> SPARSE_BRACHYPHYLLUM = createConfiguredFeature("sparse_brachyphyllum", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			BRACHYPHYLLUM_TREE_1.withChance(0.25F),
			BRACHYPHYLLUM_TREE_2.withChance(0.25F),
			BRACHYPHYLLUM_TREE_3.withChance(0.25F)
			), BRACHYPHYLLUM_TREE_4))
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
	
	public static ConfiguredFeature<?, ?> CHINLE_FLATS_TREES = createConfiguredFeature("chinle_flats_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			SMALL_AGATHOXYLON_TREE_1.withChance(0.125F),
			SMALL_AGATHOXYLON_TREE_2.withChance(0.125F),
			SCHILDERIA_TREE_1.withChance(0.125F),
			SCHILDERIA_TREE_2.withChance(0.125F),
			WOODWORTHIA_TREE_1.withChance(0.125F),
			WOODWORTHIA_TREE_2.withChance(0.125F),
			WOODWORTHIA_TREE_3.withChance(0.125F)),
			WOODWORTHIA_TREE_4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	
	public static final ConfiguredFeature<?, ?> CHINLE_WOODED_MOUNTAIN_TREES = createConfiguredFeature("chinle_wooded_mountains_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			WOODWORTHIA_TREE_1.withChance(0.2F),
			WOODWORTHIA_TREE_2.withChance(0.2F),
			WOODWORTHIA_TREE_3.withChance(0.2F),
			SCHILDERIA_TREE_1.withChance(0.1F),
			SCHILDERIA_TREE_2.withChance(0.1F)),
			WOODWORTHIA_TREE_4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.25F, 2))));
	
	public static void addHellCreekVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.HELL_CREEK_VEGETATION);
	}

	public static void addSparseHellCreekVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.SPARSE_HELL_CREEK_VEGETATION);
	}
	
	public static void addKayentaDryForestVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.DRY_FOREST);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, COMMON_ZAMITES_BUSH);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TALL_OTOZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, LAUROZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLATHOPTERIS);
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, RED_SANDSTONE_ROCK);
	}
	
	public static void addKayentaCanyonVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.SPARSE_SMALL_ARAUCARIAS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.SPARSE_BRACHYPHYLLUM);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ZAMITES_BUSH);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MORRISON_HORSETAILS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MORRISON_DOUBLE_HORSETAILS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OTOZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TALL_OTOZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, LAUROZAMITES);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_CLATHOPTERIS);
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, RED_SANDSTONE_ROCK);
	}
	
	public static void addKayentaDesertRocks(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, RED_SANDSTONE_ROCK);
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BIG_RED_SANDSTONE_ROCK);
	}

	public static void addLiriodendritesForestVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.LIRIODENDRITES_FOREST_VEGETATION);
	}

	public static void addSparseTrees(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PLAIN_VEGETATION);
	}

	public static void addMorrisonSavannaVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.MORRISON_SAVANNA_VEGETATION);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PTILOPHYLLUM_TREE_BOOGALOO);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ZAMITES_BUSH);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MORRISON_HORSETAILS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MORRISON_DOUBLE_HORSETAILS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CONIOPTERIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDACAULIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TALL_OSMUNDACAULIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, RARE_CLADOPHLEBIS);
	}
	
	public static void addMorrisonHillsVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.SPARSE_BRACHYPHYLLUM);
	}

	public static void addExtraIronOre(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_IRON_EXTRA);
	}

	public static void addIschigualastoVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MICHELILLOA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DICROIDIUM);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, JOHNSTONIA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SCYTOPHYLLUM);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ISCHIGUALASTO_VEGETATION);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_NEOCALAMITES);
	}

	public static void addSparseIschigualastoVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MICHELILLOA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_DICROIDIUM);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_JOHNSTONIA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SCYTOPHYLLUM);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_ISCHIGUALASTO_VEGETATION);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_NEOCALAMITES);
	}

	public static void registerConfiguredFeatures() {
		HELL_CREEK_HUT = Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, "prehistoricfauna:hell_creek_hut", PFStructures.HELL_CREEK_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		MORRISON_HUT = Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, "prehistoricfauna:morrison_hut", PFStructures.MORRISON_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		ISCHIGUALASTO_HUT = Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, "prehistoricfauna:ischigualasto_hut", PFStructures.ISCHIGUALASTO_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		PORTAL_CHAMBER = Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, "prehistoricfauna:portal_chamber", PFStructures.PORTAL_CHAMBER.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	}

	public static <F extends Structure<?>> void addStructureToBimap(String nameForList, F structure) {
		Structure.NAME_STRUCTURE_BIMAP.put(nameForList.toLowerCase(Locale.ROOT), structure);
	}

	@SuppressWarnings("rawtypes")
	public static void addStructureSeperation(RegistryKey<DimensionSettings> preset, Structure structure, StructureSeparationSettings settings) {
		WorldGenRegistries.NOISE_SETTINGS.getValueForKey(preset).getStructures().func_236195_a_().put(structure, settings);
	}
}
