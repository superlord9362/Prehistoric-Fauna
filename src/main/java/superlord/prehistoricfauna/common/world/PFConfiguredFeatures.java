package superlord.prehistoricfauna.common.world;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFDecorators;
import superlord.prehistoricfauna.world.feature.config.CrassostreaOystersConfig;
import superlord.prehistoricfauna.world.feature.config.JohnstoniaConfig;
import superlord.prehistoricfauna.world.feature.config.PFTreeConfig;
import superlord.prehistoricfauna.world.feature.trees.zamites.ZamitesBush;

public class PFConfiguredFeatures {

	public static final ConfiguredFeature<PFTreeConfig, ?> METASEQUOIA_TREE_1 = createConfiguredFeature("metasequoia_tree_1", PFFeatures.METASEQUOIA_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES).setMaxHeight(53).setMinHeight(41).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> METASEQUOIA_TREE_2 = createConfiguredFeature("metasequoia_tree_2", PFFeatures.METASEQUOIA_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.METASEQUOIA_LOG).setLeavesBlock(PFBlocks.METASEQUOIA_LEAVES).setMaxHeight(56).setMinHeight(44).build()));

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

	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOJUNIPEROXYLON_TREE_1 = createConfiguredFeature("protojuniperoxylon_tree_1", PFFeatures.METASEQUOIA_TREE_1.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOJUNIPEROXYLON_LOG).setLeavesBlock(PFBlocks.PROTOJUNIPEROXYLON_LEAVES).setMaxHeight(56).setMinHeight(44).build()));
	public static final ConfiguredFeature<PFTreeConfig, ?> PROTOJUNIPEROXYLON_TREE_2 = createConfiguredFeature("protojuniperoxylon_tree_2", PFFeatures.METASEQUOIA_TREE_2.withConfiguration(new PFTreeConfig.Builder().setTrunkBlock(PFBlocks.PROTOJUNIPEROXYLON_LOG).setLeavesBlock(PFBlocks.PROTOJUNIPEROXYLON_LEAVES).setMaxHeight(53).setMinHeight(41).build()));

	public static final ConfiguredFeature<?, ?> DUMMY_TREE = createConfiguredFeature("dummy_trees", PFFeatures.DUMMY.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10000, 0.4F, 8))));

	public static final ConfiguredFeature<?, ?> PETRIFIED_TREE = createConfiguredFeature("petrified_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.PETRIFIED_WOOD.getDefaultState()), new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(5));


	//Hell Creek
	public static final ConfiguredFeature<?, ?> MARCHANTIA = createConfiguredFeature("marchantia", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.MARCHANTIA.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(5)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> HORSETAIL = createConfiguredFeature("horsetail", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.HORSETAIL.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(1)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> HORSETAIL_DOUBLE = createConfiguredFeature("double_horsetail", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.TALL_HORSETAIL.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(20)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> CLUBMOSS = createConfiguredFeature("clubmoss", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CLUBMOSS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> OSMUNDA = createConfiguredFeature("osmunda", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.OSMUNDA.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(2)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> OSMUNDA_DOUBLE = createConfiguredFeature("double_osmunda", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.TALL_OSMUNDA.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(20)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> MOSS = createConfiguredFeature("moss", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.MOSS_CARPET.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(5));
	
	   public static final ConfiguredFeature<?, ?> CRASSOSTREA_OYSTERS = createConfiguredFeature("crassostrea_oysters", PFFeatures.CRASSOSTREA_OYSTERS_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).func_242731_b(48).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));
	   public static final ConfiguredFeature<?, ?> ALGAE = createConfiguredFeature("algae", PFFeatures.ALGAE_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).func_242731_b(48).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));
	
	//Morrison
	public static final ConfiguredFeature<?, ?> PTILOPHYLLUM_TREE_BOOGALOO = createConfiguredFeature("ptilophylium_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PFFeatures.PTILOPHYLLUM_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(PFDecorators.PTILOPHYLLUM_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).withChance(0.05F)), PFFeatures.PTILOPHYLLUM_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(PFDecorators.PTILOPHYLLUM_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)))));
	public static final ConfiguredFeature<?, ?> ZAMITES_BUSH = createConfiguredFeature("zamites_bush", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PFFeatures.ZAMITES_BUSH.withConfiguration(ZamitesBush.ZAMITES_BUSH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT).withChance(1F)), PFFeatures.ZAMITES_BUSH.withConfiguration(ZamitesBush.ZAMITES_BUSH_CONFIG))).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> CONIOPTERIS = createConfiguredFeature("coniopteris", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CONIOPTERIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(1)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> MORRISON_HORSETAILS = createConfiguredFeature("morrison_horestails", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.HORSETAIL.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(50)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> MORRISON_DOUBLE_HORSETAILS = createConfiguredFeature("morrison_double_horestails", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.TALL_HORSETAIL.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(75)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> OSMUNDACAULIS = createConfiguredFeature("osmundacaulis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.OSMUNDACAULIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(25)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> TALL_OSMUNDACAULIS = createConfiguredFeature("tall_osmundacaulist", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.TALL_OSMUNDACAULIS.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(35)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> DEAD_OSMUNDACAULIS = createConfiguredFeature("dead_osmundacaulis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.DEAD_OSMUNDACAULIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(45)).func_242731_b(5));

	public static final ConfiguredFeature<?, ?> ORE_IRON_EXTRA = createConfiguredFeature("ore_iron_extra", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, Blocks.IRON_ORE.getDefaultState(), 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(32, 32, 80))).square().func_242731_b(20));

	//Ischigualasto
	public static final ConfiguredFeature<?, ?> MICHELILLOA = createConfiguredFeature("michelilloa", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.MICHELILLOA.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(10)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> CLADOPHLEBIS = createConfiguredFeature("cladophlebis", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.CLADOPHLEBIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(2)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> SCYTOPHYLLUM = createConfiguredFeature("scytophyllum", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.SCYTOPHYLLUM.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).build()).withPlacement(Features.Placements.PATCH_PLACEMENT.chance(60)).func_242731_b(5));
	public static final ConfiguredFeature<?, ?> JOHNSTONIA = createConfiguredFeature("johnstonia", PFFeatures.JOHNSTONIA_FEATURE.withConfiguration(new JohnstoniaConfig(3)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	public static final ConfiguredFeature<?, ?> DICROIDIUM = createConfiguredFeature("dicroidium", PFFeatures.DICROIDIUM_FEATURE.withConfiguration(new JohnstoniaConfig(6)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

	
	//public static final ConfiguredFeature<?, ?> ALGAE = createConfiguredFeature("algae", PFFeatures.ALGAE_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	//public static final ConfiguredFeature<?, ?> CRASSOSTREA_OYSTERS = createConfiguredFeature("crassostrea_oysters", PFFeatures.CRASSOSTREA_OYSTERS_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

	public static <FC extends IFeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
		ResourceLocation pfID = new ResourceLocation(PrehistoricFauna.MOD_ID, id);
		if (WorldGenRegistries.CONFIGURED_FEATURE.keySet().contains(pfID))
			throw new IllegalStateException("Configured Feature ID: \"" + pfID.toString() + "\" already exists in the Configured Features registry!");

		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, pfID, configuredFeature);
		return configuredFeature;
	}


	public static void withHCRocks(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Features.FOREST_ROCK);
	}

	public static void withWaterLakesAndSprings(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_WATER);
	}

	public static void withHellCreekVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MARCHANTIA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLUBMOSS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDA_DOUBLE);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CRASSOSTREA_OYSTERS);
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
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(8, 0.2F, 3))));

	public static final ConfiguredFeature<?, ?> SPARSE_HELL_CREEK_VEGETATION = createConfiguredFeature("sparse_hell_creek_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			METASEQUOIA_TREE_1.withChance(0.1F),
			METASEQUOIA_TREE_2.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.15F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.15F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.15F),
			ARAUCARIA_SMALL_TREE_4.withChance(0.15F),
			ARAUCARIA_TREE_1.withChance(0.1F)
			), ARAUCARIA_TREE_2))
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

	public static final ConfiguredFeature<?, ?> LIRIODENDRITES_FOREST_VEGETATION = createConfiguredFeature("liriodendrites_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			LIRIODENDRITES_TREE_1.withChance(0.2F),
			LIRIODENDRITES_TREE_2.withChance(0.2F),
			LIRIODENDRITES_TREE_3.withChance(0.2F),
			LIRIODENDRITES_TREE_4.withChance(0.2F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.05F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.05F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.05F)
			), ARAUCARIA_SMALL_TREE_4))
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(8, 0.2F, 3))));

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
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.25F, 1))));
	
	public static ConfiguredFeature<?, ?> ISCHIGUALASTO_VEGETATION = createConfiguredFeature("ischigualasto_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			HEIDIPHYLLUM_TREE_1.withChance(0.15F),
			HEIDIPHYLLUM_TREE_2.withChance(0.15F),
			HEIDIPHYLLUM_TREE_3.withChance(0.1F),
			HEIDIPHYLLUM_TREE_4.withChance(0.1F),
			HEIDIPHYLLUM_TREE_5.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.75F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.75F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.75F),
			ARAUCARIA_SMALL_TREE_4.withChance(0.75F),
			PROTOJUNIPEROXYLON_TREE_1.withChance(0.5F)
			), PROTOJUNIPEROXYLON_TREE_2))
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(8, 0.2F, 3))));
	
	public static ConfiguredFeature<?, ?> SPARSE_ISCHIGUALASTO_VEGETATION = createConfiguredFeature("sparse_ischigualasto_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
			HEIDIPHYLLUM_TREE_1.withChance(0.15F),
			HEIDIPHYLLUM_TREE_2.withChance(0.15F),
			HEIDIPHYLLUM_TREE_3.withChance(0.1F),
			HEIDIPHYLLUM_TREE_4.withChance(0.1F),
			HEIDIPHYLLUM_TREE_5.withChance(0.1F),
			ARAUCARIA_SMALL_TREE_1.withChance(0.75F),
			ARAUCARIA_SMALL_TREE_2.withChance(0.75F),
			ARAUCARIA_SMALL_TREE_3.withChance(0.75F),
			ARAUCARIA_SMALL_TREE_4.withChance(0.75F),
			PROTOJUNIPEROXYLON_TREE_1.withChance(0.5F)
			), PROTOJUNIPEROXYLON_TREE_2))
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

	public static void addHellCreekVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.HELL_CREEK_VEGETATION);
	}

	public static void addSparseHellCreekVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.SPARSE_HELL_CREEK_VEGETATION);
	}

	public static void addLiriodendritesForestVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PFConfiguredFeatures.LIRIODENDRITES_FOREST_VEGETATION);
	}

	public static void addSparseandPetrifiedTrees(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PLAIN_VEGETATION);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PETRIFIED_TREE);
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
	}
	
	public static void addSparseIschigualastoVegetation(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MICHELILLOA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DICROIDIUM);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, JOHNSTONIA);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SCYTOPHYLLUM);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SPARSE_ISCHIGUALASTO_VEGETATION);
	}

}
