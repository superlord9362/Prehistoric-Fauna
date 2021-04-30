package superlord.prehistoricfauna.core.world;


import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.DimensionTypeInit;
import superlord.prehistoricfauna.world.PrehistoricPlacement;
import superlord.prehistoricfauna.world.feature.AlgaeFeatureConfig;
import superlord.prehistoricfauna.world.feature.CrassostreaOystersConfig;
import superlord.prehistoricfauna.world.feature.PetrifiedTree;
import superlord.prehistoricfauna.world.feature.config.NoisySphereConfig;
import superlord.prehistoricfauna.world.feature.config.PHFTreeConfig;
import superlord.prehistoricfauna.world.feature.jurassic.ZamitesBush;
import superlord.prehistoricfauna.world.feature.triassic.HeidiphyllumTree;
import superlord.prehistoricfauna.world.placement.DicroidiumConfig;
import superlord.prehistoricfauna.world.placement.JohnstoniaConfig;

import static superlord.prehistoricfauna.core.world.util.WorldGenRegistrationHelper.createConfiguredFeature;


public class PHFConfiguredFeatures {


	private static final BlockState MOSSY_COBBLESTONE = Blocks.MOSSY_COBBLESTONE.getDefaultState();
	private static final BlockState IRON_ORE = Blocks.IRON_ORE.getDefaultState();
	private static final BlockState WATER = Blocks.WATER.getDefaultState();
	private static final BlockState LAVA = Blocks.LAVA.getDefaultState();

	public static final ConfiguredFeature<PHFTreeConfig, ?> ARAUCARIA_SMALL_TREE1 = createConfiguredFeature("araucaria_small_tree1", PHFFeatures.ARAUCARIA_SMALL_TREE1.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(13).setMaxHeight(18).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> ARAUCARIA_SMALL_TREE2 = createConfiguredFeature("araucaria_small_tree2", PHFFeatures.ARAUCARIA_SMALL_TREE2.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(6).setMaxHeight(11).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> ARAUCARIA_SMALL_TREE3 = createConfiguredFeature("araucaria_small_tree3", PHFFeatures.ARAUCARIA_SMALL_TREE3.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(10).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> ARAUCARIA_SMALL_TREE4 = createConfiguredFeature("araucaria_small_tree4", PHFFeatures.ARAUCARIA_SMALL_TREE4.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(14).setMaxHeight(19).build()));

	public static final ConfiguredFeature<PHFTreeConfig, ?> PROTOPICEOXYLON_TREE1 = createConfiguredFeature("protopiceoxylon_tree1", PHFFeatures.PROTOPICEOXYLON_TREE1.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.PROTOPICEOXYLON_LOG.getDefaultState()).setLeavesBlock(BlockInit.PROTOPICEOXYLON_LEAVES).setMinHeight(11).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> PROTOPICEOXYLON_TREE2 = createConfiguredFeature("protopiceoxylon_tree2", PHFFeatures.PROTOPICEOXYLON_TREE2.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.PROTOPICEOXYLON_LOG.getDefaultState()).setLeavesBlock(BlockInit.PROTOPICEOXYLON_LEAVES).setMinHeight(9).setMaxHeight(13).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> PROTOPICEOXYLON_TREE3 = createConfiguredFeature("protopiceoxylon_tree3", PHFFeatures.PROTOPICEOXYLON_TREE3.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.PROTOPICEOXYLON_LOG.getDefaultState()).setLeavesBlock(BlockInit.PROTOPICEOXYLON_LEAVES).setMinHeight(13).setMaxHeight(17).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> PROTOPICEOXYLON_TREE4 = createConfiguredFeature("protopiceoxylon_tree4", PHFFeatures.PROTOPICEOXYLON_TREE4.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.PROTOPICEOXYLON_LOG.getDefaultState()).setLeavesBlock(BlockInit.PROTOPICEOXYLON_LEAVES).setMinHeight(16).setMaxHeight(20).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> PROTOPICEOXYLON_TREE5 = createConfiguredFeature("protopiceoxylon_tree5", PHFFeatures.PROTOPICEOXYLON_TREE5.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.PROTOPICEOXYLON_LOG.getDefaultState()).setLeavesBlock(BlockInit.PROTOPICEOXYLON_LEAVES).setMinHeight(7).setMaxHeight(11).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> PROTOPICEOXYLON_TREE6 = createConfiguredFeature("protopiceoxylon_tree6", PHFFeatures.PROTOPICEOXYLON_TREE6.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.PROTOPICEOXYLON_LOG.getDefaultState()).setLeavesBlock(BlockInit.PROTOPICEOXYLON_LEAVES).setMinHeight(14).setMaxHeight(18).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> PROTOPICEOXYLON_TREE7 = createConfiguredFeature("protopiceoxylon_tree7", PHFFeatures.PROTOPICEOXYLON_TREE7.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.PROTOPICEOXYLON_LOG.getDefaultState()).setLeavesBlock(BlockInit.PROTOPICEOXYLON_LEAVES).setMinHeight(14).setMaxHeight(19).build()));

	public static final ConfiguredFeature<PHFTreeConfig, ?> LIRIODENDRITES_TREE1 = createConfiguredFeature("liriodendrites_tree1", PHFFeatures.LIRIODENDRITES_TREE1.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.LIRIODENDRITES_LOG.getDefaultState()).setLeavesBlock(BlockInit.LIRIODENDRITES_LEAVES).setMinHeight(16).setMaxHeight(20).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> LIRIODENDRITES_TREE2 = createConfiguredFeature("liriodendrites_tree2", PHFFeatures.LIRIODENDRITES_TREE2.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.LIRIODENDRITES_LOG.getDefaultState()).setLeavesBlock(BlockInit.LIRIODENDRITES_LEAVES).setMinHeight(7).setMaxHeight(10).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> LIRIODENDRITES_TREE3 = createConfiguredFeature("liriodendrites_tree3", PHFFeatures.LIRIODENDRITES_TREE3.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.LIRIODENDRITES_LOG.getDefaultState()).setLeavesBlock(BlockInit.LIRIODENDRITES_LEAVES).setMinHeight(12).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> LIRIODENDRITES_TREE4 = createConfiguredFeature("liriodendrites_tree4", PHFFeatures.LIRIODENDRITES_TREE4.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.LIRIODENDRITES_LOG.getDefaultState()).setLeavesBlock(BlockInit.LIRIODENDRITES_LEAVES).setMinHeight(21).setMaxHeight(24).build()));

	public static final ConfiguredFeature<PHFTreeConfig, ?> HEIDIPHYLLUM_TREE1 = createConfiguredFeature("heidiphyllum_tree1", PHFFeatures.HEIDIPHYLLUM_TREE1.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.HEIDIPHYLLUM_LOG.getDefaultState()).setLeavesBlock(BlockInit.HEIDIPHYLLUM_LEAVES).setMinHeight(9).setMaxHeight(12).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> HEIDIPHYLLUM_TREE2 = createConfiguredFeature("heidiphyllum_tree2", PHFFeatures.HEIDIPHYLLUM_TREE2.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.HEIDIPHYLLUM_LOG.getDefaultState()).setLeavesBlock(BlockInit.HEIDIPHYLLUM_LEAVES).setMinHeight(12).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> HEIDIPHYLLUM_TREE3 = createConfiguredFeature("heidiphyllum_tree3", PHFFeatures.HEIDIPHYLLUM_TREE3.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.HEIDIPHYLLUM_LOG.getDefaultState()).setLeavesBlock(BlockInit.HEIDIPHYLLUM_LEAVES).setMinHeight(12).setMaxHeight(15).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> HEIDIPHYLLUM_TREE4 = createConfiguredFeature("heidiphyllum_tree4", PHFFeatures.HEIDIPHYLLUM_TREE4.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.HEIDIPHYLLUM_LOG.getDefaultState()).setLeavesBlock(BlockInit.HEIDIPHYLLUM_LEAVES).setMinHeight(15).setMaxHeight(18).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> HEIDIPHYLLUM_TREE5 = createConfiguredFeature("heidiphyllum_tree5", PHFFeatures.HEIDIPHYLLUM_TREE5.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.HEIDIPHYLLUM_LOG.getDefaultState()).setLeavesBlock(BlockInit.HEIDIPHYLLUM_LEAVES).setMinHeight(7).setMaxHeight(10).build()));

	public static final ConfiguredFeature<PHFTreeConfig, ?> ARAUCARIA_TREE1 = createConfiguredFeature("araucaria_tree1", PHFFeatures.ARAUCARIA__TREE1.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(44).setMaxHeight(55).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> ARAUCARIA_TREE2 = createConfiguredFeature("araucaria_tree2", PHFFeatures.ARAUCARIA__TREE2.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(44).setMaxHeight(55).build()));

	public static final ConfiguredFeature<PHFTreeConfig, ?> METASEQUOIA_TREE1 = createConfiguredFeature("metasequioa_tree1", PHFFeatures.METASEQUOIA_TREE1.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.METASEQUOIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.METASEQUOIA_LEAVES).setMinHeight(41).setMaxHeight(53).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> METASEQUOIA_TREE2 = createConfiguredFeature("metasequioa_tree2", PHFFeatures.METASEQUOIA_TREE2.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.METASEQUOIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.METASEQUOIA_LEAVES).setMinHeight(44).setMaxHeight(56).build()));

	public static final ConfiguredFeature<PHFTreeConfig, ?> PROTOJUNIPEROXYLON_TREE1 = createConfiguredFeature("proto_juniper_tree1", PHFFeatures.METASEQUOIA_TREE1.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.PROTOJUNIPER_LOG.getDefaultState()).setLeavesBlock(BlockInit.PROTOJUNIPER_LEAVES).setMinHeight(44).setMaxHeight(56).build()));
	public static final ConfiguredFeature<PHFTreeConfig, ?> PROTOJUNIPEROXYLON_TREE2 = createConfiguredFeature("proto_juniper_tree2", PHFFeatures.METASEQUOIA_TREE2.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.PROTOJUNIPER_LOG.getDefaultState()).setLeavesBlock(BlockInit.PROTOJUNIPER_LEAVES).setMinHeight(41).setMaxHeight(53).build()));


	//Redo these features in between the TODOs
	//TODO Start
	public static final ConfiguredFeature<?, ?> HEIDIPHYLLUM_TREE = createConfiguredFeature("heidiphyllum_tree", Feature.NORMAL_TREE.withConfiguration(HeidiphyllumTree.HEIDIPHYLLUM_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
	public static final ConfiguredFeature<?, ?> PETRIFIED_TREE = createConfiguredFeature("petrified_tree", Feature.NORMAL_TREE.withConfiguration(PetrifiedTree.PETRIFIED_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
	//TODO END


	public static final ConfiguredFeature<?, ?> CONIOPTERIS = createConfiguredFeature("coniopteris", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.CONIOPTERIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(220))));
	public static final ConfiguredFeature<?, ?> CLADOPHLEBIS = createConfiguredFeature("cladophlebis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.CLADOPHLEBIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(220))));
	public static final ConfiguredFeature<?, ?> CLUBMOSS = createConfiguredFeature("clubmoss", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.CLUBMOSS.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
	public static final ConfiguredFeature<?, ?> CRASSOSTREA_OYSTERS = createConfiguredFeature("crassostrea_oysters", PHFFeatures.CRASSOSTREA_OYSTERS_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> ALGAE = createConfiguredFeature("algae", PHFFeatures.ALGAE_FEATURE.withConfiguration(new AlgaeFeatureConfig(24)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> DEAD_OSMUNDACAULIS = createConfiguredFeature("dead_osmundacaulis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.DEAD_OSMUNDACAULIS.getDefaultState()), new SimpleBlockPlacer())).tries(4).build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
	public static final ConfiguredFeature<?, ?> DICROIDIUM = createConfiguredFeature("dicroidium", PHFFeatures.DICROIDIUM_FEATURE.withConfiguration(new DicroidiumConfig(6)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	//public static final ConfiguredFeature<?, ?> DIDELPHODON_BURROW = createConfiguredFeature("didelphion_burrow", PHFFeatures.DIDELPHODON_BURROW_FEATURE.withConfiguration(new DidelphodonBurrowConfig(3)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> HORSETAIL = createConfiguredFeature("horsetail", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.HORSETAIL.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(60))));
	public static final ConfiguredFeature<?, ?> HORSETAIL_DOUBLE = createConfiguredFeature("double_horsetail", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.DOUBLE_HORSETAIL.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(20))));
	public static final ConfiguredFeature<?, ?> JOHNSTONIA = createConfiguredFeature("johnstonia", PHFFeatures.JOHNSTONIA_FEATURE.withConfiguration(new JohnstoniaConfig(3)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> MOSS = createConfiguredFeature("moss", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.MOSS.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(80))));
	public static final ConfiguredFeature<?, ?> MARCHANTIA = createConfiguredFeature("marchantia", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.MARCHANTIA.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(40))));
	public static final ConfiguredFeature<?, ?> MICHELILLOA = createConfiguredFeature("michelilloa", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.MICHELILLOA.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(100))));
	public static final ConfiguredFeature<?, ?> OSMUNDA = createConfiguredFeature("osmunda", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.OSMUNDA.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(40))));
	public static final ConfiguredFeature<?, ?> OSMUNDA_DOUBLE = createConfiguredFeature("double_osmuda", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.DOUBLE_OSMUNDA.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(20))));
	public static final ConfiguredFeature<?, ?> OSMUNDACAULIS = createConfiguredFeature("osmundacaulis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.OSMUNDACAULIS.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(15))));
	public static final ConfiguredFeature<?, ?> OSMUNDACAULIS_SHORT = createConfiguredFeature("osmundacaulis_short", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.SHORT_OSMUNDACAULIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
	public static final ConfiguredFeature<?, ?> PTILOPHYLLUM_TREE_BOOGALOO = createConfiguredFeature("ptilophylium_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PHFFeatures.PTILOPHYLLUM_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(PrehistoricPlacement.PTILOPHYLLUM_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).withChance(0.05F)), PHFFeatures.PTILOPHYLLUM_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(PrehistoricPlacement.PTILOPHYLLUM_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)))));
	public static final ConfiguredFeature<?, ?> SCYTOPHYLLUM = createConfiguredFeature("scytophllum", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.SCYTOPHYLLUM.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build()).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(30))));

	public static final ConfiguredFeature<?, ?> ZAMITES_BUSH = createConfiguredFeature("zamites_bush", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PHFFeatures.ZAMITES_BUSH.withConfiguration(ZamitesBush.ZAMITES_BUSH_CONFIG).withChance(1F)), PHFFeatures.ZAMITES_BUSH.withConfiguration(ZamitesBush.ZAMITES_BUSH_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.2F, 1))));
	public static final ConfiguredFeature<?, ?> FOSSILIZED_CRETACEOUS_CHALK = createConfiguredFeature("fossilized_cretaceous_chalk", PHFFeatures.NOISY_SPHERE.withConfiguration(new NoisySphereConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BlockInit.CRETACEOUS_CHALK.getDefaultState(), 9).addWeightedBlockstate(BlockInit.CRETACEOUS_CHALK_FOSSIL.getDefaultState(), 1)).setMinRadius(8).setMaxRadius(10).setMinYRadius(6).setMaxYRadius(8).build()).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 42, 0, 52))));
	public static final ConfiguredFeature<?, ?> FOSSILIZED_JURASSIC_SILTSTONE = createConfiguredFeature("fossilized_jurassic_siltstone", PHFFeatures.NOISY_SPHERE.withConfiguration(new NoisySphereConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BlockInit.JURASSIC_SILTSTONE.getDefaultState(), 8).addWeightedBlockstate(BlockInit.JURASSIC_SILTSTONE_FOSSIL.getDefaultState(), 1)).setMinRadius(8).setMaxRadius(10).setMinYRadius(6).setMaxYRadius(8).setWhitelistedDimensions(DimensionType.OVERWORLD, DimensionTypeInit.CRETACEOUS_DIMENSION_TYPE).build()).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 37, 0, 42))));
	public static final ConfiguredFeature<?, ?> FOSSILIZED_TRIASSIC_SANDSTONE = createConfiguredFeature("fossilized_triassic_sandstone", PHFFeatures.NOISY_SPHERE.withConfiguration(new NoisySphereConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BlockInit.TRIASSIC_SANDSTONE.getDefaultState(), 9).addWeightedBlockstate(BlockInit.TRIASSIC_SANDSTONE_FOSSIL.getDefaultState(), 1)).setMinRadius(8).setMaxRadius(10).setMinYRadius(6).setMaxYRadius(8).setWhitelistedDimensions(DimensionType.OVERWORLD, DimensionTypeInit.CRETACEOUS_DIMENSION_TYPE, DimensionTypeInit.JURASSIC_DIMENSION_TYPE).build()).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 32, 0, 42))));


	/************************************Random Selectors************************************/

	public static ConfiguredFeature<?, ?> HELL_CREEK_VEGETATION = createConfiguredFeature("hell_creek_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			METASEQUOIA_TREE1.withChance(0.1F),
			METASEQUOIA_TREE2.withChance(0.1F),
			LIRIODENDRITES_TREE1.withChance(0.05F),
			LIRIODENDRITES_TREE2.withChance(0.05F),
			LIRIODENDRITES_TREE3.withChance(0.05F),
			LIRIODENDRITES_TREE4.withChance(0.05F),
			ARAUCARIA_SMALL_TREE1.withChance(0.1F),
			ARAUCARIA_SMALL_TREE2.withChance(0.1F),
			ARAUCARIA_SMALL_TREE3.withChance(0.1F),
			ARAUCARIA_SMALL_TREE4.withChance(0.1F),
			ARAUCARIA_TREE1.withChance(0.1F)
			), ARAUCARIA_TREE2))
			).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(8, 0.2F, 3)));

	public static ConfiguredFeature<?, ?> SPARE_HELL_CREEK_VEGETATION = createConfiguredFeature("sparse_hell_creek_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			METASEQUOIA_TREE1.withChance(0.1F),
			METASEQUOIA_TREE2.withChance(0.1F),
			ARAUCARIA_SMALL_TREE1.withChance(0.15F),
			ARAUCARIA_SMALL_TREE2.withChance(0.15F),
			ARAUCARIA_SMALL_TREE3.withChance(0.15F),
			ARAUCARIA_SMALL_TREE4.withChance(0.15F),
			ARAUCARIA_TREE1.withChance(0.1F)
			), ARAUCARIA_TREE2))
			).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1)));

	public static ConfiguredFeature<?, ?> MORRISON_SAVANNA_VEGETATION = createConfiguredFeature("morrison_savanna_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			PROTOPICEOXYLON_TREE1.withChance(0.1F),
			PROTOPICEOXYLON_TREE2.withChance(0.1F),
			PROTOPICEOXYLON_TREE3.withChance(0.1F),
			PROTOPICEOXYLON_TREE4.withChance(0.1F),
			PROTOPICEOXYLON_TREE5.withChance(0.1F),
			PROTOPICEOXYLON_TREE6.withChance(0.1F),
			ARAUCARIA_SMALL_TREE1.withChance(0.1F),
			ARAUCARIA_SMALL_TREE2.withChance(0.1F),
			ARAUCARIA_SMALL_TREE3.withChance(0.1F),
			ARAUCARIA_SMALL_TREE4.withChance(0.05F)
			), PROTOPICEOXYLON_TREE7))
			).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.25F, 1)));

	public static ConfiguredFeature<?, ?> LIRIODENDRITES_FOREST_VEGETATION = createConfiguredFeature("liriodendrites_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			LIRIODENDRITES_TREE1.withChance(0.2F),
			LIRIODENDRITES_TREE2.withChance(0.2F),
			LIRIODENDRITES_TREE3.withChance(0.2F),
			LIRIODENDRITES_TREE4.withChance(0.2F),
			ARAUCARIA_SMALL_TREE1.withChance(0.05F),
			ARAUCARIA_SMALL_TREE2.withChance(0.05F),
			ARAUCARIA_SMALL_TREE3.withChance(0.05F)
			), ARAUCARIA_SMALL_TREE4))
			).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(8, 0.2F, 3)));

	public static ConfiguredFeature<?, ?> ISCHIGUALASTO_VEGETATION = createConfiguredFeature("ischigualasto_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			HEIDIPHYLLUM_TREE1.withChance(0.15F),
			HEIDIPHYLLUM_TREE2.withChance(0.15F),
			HEIDIPHYLLUM_TREE3.withChance(0.1F),
			HEIDIPHYLLUM_TREE4.withChance(0.1F),
			HEIDIPHYLLUM_TREE5.withChance(0.1F),
			ARAUCARIA_SMALL_TREE1.withChance(0.75F),
			ARAUCARIA_SMALL_TREE2.withChance(0.75F),
			ARAUCARIA_SMALL_TREE3.withChance(0.75F),
			ARAUCARIA_SMALL_TREE4.withChance(0.75F),
			PROTOJUNIPEROXYLON_TREE1.withChance(0.5F)
			), PROTOJUNIPEROXYLON_TREE2))
			).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(8, 0.2F, 3)));

	public static ConfiguredFeature<?, ?> SPARSE_ISCHIGUALASTO_VEGETATION = createConfiguredFeature("ischigualasto_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			HEIDIPHYLLUM_TREE1.withChance(0.15F),
			HEIDIPHYLLUM_TREE2.withChance(0.15F),
			HEIDIPHYLLUM_TREE3.withChance(0.1F),
			HEIDIPHYLLUM_TREE4.withChance(0.1F),
			HEIDIPHYLLUM_TREE5.withChance(0.1F),
			ARAUCARIA_SMALL_TREE1.withChance(0.75F),
			ARAUCARIA_SMALL_TREE2.withChance(0.75F),
			ARAUCARIA_SMALL_TREE3.withChance(0.75F),
			ARAUCARIA_SMALL_TREE4.withChance(0.75F),
			PROTOJUNIPEROXYLON_TREE1.withChance(0.5F)
			), PROTOJUNIPEROXYLON_TREE2))
			).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1)));

	public static void addHCRocks(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(MOSSY_COBBLESTONE, 0)).withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(2))));
	}

	public static void addExtraIronOre(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 32, 32, 80))));
	}

	public static void addWaterLakesandSprings(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(DefaultBiomeFeatures.WATER_SPRING_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(50, 8, 8, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, PHFFeatures.PREHISTORIC_LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
	}
	
	public static void addWaterSprings(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(DefaultBiomeFeatures.WATER_SPRING_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(50, 8, 8, 256))));
	}

	
	public static void addLavaLakesandSprings(Biome biomeIn) {
	      biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(LAVA)).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
	      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(DefaultBiomeFeatures.LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(20, 8, 16, 256))));
	}

}
