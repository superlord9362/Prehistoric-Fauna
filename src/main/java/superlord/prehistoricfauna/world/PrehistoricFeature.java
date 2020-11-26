package superlord.prehistoricfauna.world;

import java.util.Locale;

import com.google.common.collect.Lists;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.world.feature.CrassostreaOystersConfig;
import superlord.prehistoricfauna.world.feature.CrassostreaOystersFeature;
import superlord.prehistoricfauna.world.feature.DicroidiumFeature;
import superlord.prehistoricfauna.world.feature.cretaceous.DidelphodonBurrowFeature;
import superlord.prehistoricfauna.world.feature.JohnstoniaFeature;
import superlord.prehistoricfauna.world.feature.jurassic.PtilophyllumFeature;
import superlord.prehistoricfauna.world.feature.jurassic.ZamitesBushFeature;
import superlord.prehistoricfauna.world.feature.cretaceous.AraucariaSmallTreeGenerator;
import superlord.prehistoricfauna.world.feature.cretaceous.AraucariaTreeGenerator;
import superlord.prehistoricfauna.world.feature.cretaceous.HellCreekSurfaceBuilder;
import superlord.prehistoricfauna.world.surfacebuilder.IschigualastoSB;
import superlord.prehistoricfauna.world.feature.cretaceous.MetasequoiaTreeGenerator;
import superlord.prehistoricfauna.world.surfacebuilder.MorrisonSavannaSB;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricGiantTreeFeatureConfig;
import superlord.prehistoricfauna.world.placement.AraucariaConfig;
import superlord.prehistoricfauna.world.placement.AraucariaSmallConfig;
import superlord.prehistoricfauna.world.placement.DicroidiumConfig;
import superlord.prehistoricfauna.world.placement.DidelphodonBurrowConfig;
import superlord.prehistoricfauna.world.placement.HellCreekHutPieces;
import superlord.prehistoricfauna.world.placement.IschigualastoHutPieces;
import superlord.prehistoricfauna.world.placement.JohnstoniaConfig;
import superlord.prehistoricfauna.world.placement.MorrisonHutPieces;
import superlord.prehistoricfauna.world.placement.TimeTemplePieces;
import superlord.prehistoricfauna.world.structures.HCHutStructure;
import superlord.prehistoricfauna.world.structures.IschigualastoStructure;
import superlord.prehistoricfauna.world.structures.MorrisonHutStructure;
import superlord.prehistoricfauna.world.structures.TimeTempleStructure;

public class PrehistoricFeature {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES, PrehistoricFauna.MODID);

	public static final BlockState HORSETAIL = BlockInit.HORSETAIL.getDefaultState();
	public static final BlockState OSMUNDA = BlockInit.OSMUNDA.getDefaultState();
	public static final BlockState CLUBMOSS = BlockInit.CLUBMOSS.getDefaultState();
	public static final BlockState MARCHANTIA = BlockInit.MARCHANTIA.getDefaultState();
	public static final BlockState TALL_HORSETAIL = BlockInit.DOUBLE_HORSETAIL.getDefaultState();
	public static final BlockState TALL_OSMUNDA = BlockInit.DOUBLE_OSMUNDA.getDefaultState();
	public static final BlockState MOSS = BlockInit.MOSS.getDefaultState();
	public static final BlockState PODZOL = Blocks.PODZOL.getDefaultState();
	public static final BlockState COARSEDIRT = Blocks.COARSE_DIRT.getDefaultState();
	public static final BlockState MOSSYDIRT = BlockInit.MOSSY_DIRT.getDefaultState();
	public static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
	public static final BlockState CLAY = Blocks.CLAY.getDefaultState();
	public static final BlockState SAND = Blocks.SAND.getDefaultState();
	public static final BlockState CONIOPTERIS = BlockInit.CONIOPTERIS.getDefaultState();
	public static final BlockState OSMUNDACAULIS = BlockInit.OSMUNDACAULIS.getDefaultState();
	public static final BlockState LOAM = BlockInit.LOAM.getDefaultState();
	public static final BlockState DICROIDIUM = BlockInit.DICROIDIUM.getDefaultState();
	public static final BlockState JOHNSTONIA = BlockInit.JOHNSTONIA.getDefaultState();
	public static final BlockState SCYTOPHYLLUM = BlockInit.SCYTOPHYLLUM.getDefaultState();
	public static final BlockState MICHELILLOA = BlockInit.MICHELILLOA.getDefaultState();
	public static final BlockState CLADOPHLEBIS = BlockInit.CLADOPHLEBIS.getDefaultState();
	public static final BlockState SHORT_OSMUNDACAULIS = BlockInit.SHORT_OSMUNDACAULIS.getDefaultState();
	public static final BlockState DEAD_OSMUNDACAULIS = BlockInit.DEAD_OSMUNDACAULIS.getDefaultState();
	public static final BlockState CRASSOSTREA_OYSTERS = BlockInit.CRASSOSTREA_BLOCK.getDefaultState();
	public static final BlockState SANDSTONE = BlockInit.TRIASSIC_SANDSTONE.getDefaultState();
	public static final BlockState STONE = Blocks.STONE.getDefaultState();
	public static final BlockState PETRIFIED_WOOD = BlockInit.PETRIFIED_WOOD.getDefaultState();

	public static final BlockClusterFeatureConfig HORSETAIL_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(HORSETAIL), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig OSMUNDA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(OSMUNDA), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig CLUBMOSS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CLUBMOSS), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig MARCHANTIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MARCHANTIA), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig LARGE_HORSETAIL_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_HORSETAIL), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig LARGE_OSMUNDA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_OSMUNDA), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig OSMUNDACAULIS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(OSMUNDACAULIS), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig MOSS_PILE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MOSS), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig CONIOPTERIS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CONIOPTERIS), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig CLADOPHLEBIS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CLADOPHLEBIS), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig MICHELILLOA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MICHELILLOA), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig SCYTOPHYLLUM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SCYTOPHYLLUM), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig HORSETAIL_WATER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(HORSETAIL), new SimpleBlockPlacer())).tries(64).func_227317_b_().requiresWater().build();
	public static final BlockClusterFeatureConfig LARGE_HORSETAIL_WATER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_HORSETAIL), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().requiresWater().build();
	public static final BlockClusterFeatureConfig DEAD_OSMUNDACAULIS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DEAD_OSMUNDACAULIS), new SimpleBlockPlacer())).tries(4).build();
	public static final BlockClusterFeatureConfig SHORT_OSMUNDACAULIS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SHORT_OSMUNDACAULIS), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig PETRIFIED_TREE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PETRIFIED_WOOD), new ColumnBlockPlacer(1, 2))).tries(20).xSpread(4).ySpread(0).zSpread(4).func_227317_b_().build();
	public static final SurfaceBuilderConfig PODZOL_COARSEDIRT_GRAVEL_CONFIG = new SurfaceBuilderConfig(PODZOL, COARSEDIRT, GRAVEL);
	public static final SurfaceBuilderConfig MOSSYDIRT_COARSEDIRT_COARSEDIRT_CONFIG = new SurfaceBuilderConfig(MOSSYDIRT, COARSEDIRT, COARSEDIRT);
	public static final SurfaceBuilderConfig COARSEDIRT_COARSEDIRT_CLAY_CONFIG = new SurfaceBuilderConfig(COARSEDIRT, COARSEDIRT, CLAY);
	public static final SurfaceBuilderConfig SAND_COARSEDIRT_COARSEDIRT_CONFG = new SurfaceBuilderConfig(SAND, COARSEDIRT, COARSEDIRT);
	public static final SurfaceBuilderConfig LOAM_LOAM_COARSEDIRT_CONFIG = new SurfaceBuilderConfig(LOAM, LOAM, COARSEDIRT);
	public static final SurfaceBuilderConfig SANDSTONE_SANDSTONE_STONE_CONFIG = new SurfaceBuilderConfig(COARSEDIRT, SANDSTONE, STONE);

	public static final Feature<PrehistoricGiantTreeFeatureConfig> METASEQUOIA_TREE = register("metasequoia_tree", new MetasequoiaTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeMetasequoia));
	public static final Feature<PrehistoricGiantTreeFeatureConfig> PROTOJUNIPER_TREE = register("protojuniper_tree", new MetasequoiaTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeProtojuniper));
	public static final Feature<TreeFeatureConfig> PROTOPICEOXYLON_TREE = register("protopiceoxylon_tree", new TreeFeature(TreeFeatureConfig::deserializeFoliage));
	public static final Feature<TreeFeatureConfig> HEIDIPHYLLUM_TREE = register("heidiphyllum_tree", new TreeFeature(TreeFeatureConfig::deserializeFoliage));
	public static final Feature<NoFeatureConfig> PTILOPHYLLUM_TREE = register("ptilophyllum_tree", new PtilophyllumFeature(NoFeatureConfig::deserialize));
	public static final Feature<TreeFeatureConfig> PETRIFIED_TREE = register("petrified_tree", new TreeFeature(TreeFeatureConfig::deserializeFoliage));

	public static final Feature<CrassostreaOystersConfig> CRASSOSTREA_OYSTERS_FEATURE = register("crassostrea_oysters", new CrassostreaOystersFeature(CrassostreaOystersConfig::deserialize));
	public static final Feature<DidelphodonBurrowConfig> DIDELPHODON_BURROW_FEATURE = register("didelphodon_burrow", new DidelphodonBurrowFeature(DidelphodonBurrowConfig::deserialize));
	public static final Feature<JohnstoniaConfig> JOHNSTONIA_FEATURE = register("johnstonia_feature", new JohnstoniaFeature(JohnstoniaConfig::deserialize));
	public static final Feature<DicroidiumConfig> DICROIDIUM_FEATURE = register("dicroidium_feature", new DicroidiumFeature(DicroidiumConfig::deserialize));
	public static final Feature<AraucariaConfig> ARAUCARIA_FEATURE = register("araucaria_feature", new AraucariaTreeGenerator(AraucariaConfig::deserialize));
	public static final Feature<AraucariaSmallConfig> ARAUCARIA_SMALL_TREE_FEATURE = register("araucaria_small_tree_feature", new AraucariaSmallTreeGenerator(AraucariaSmallConfig::deserialize));

	public static final Feature<TreeFeatureConfig> ZAMITES_BUSH = register("zamites_bush", new ZamitesBushFeature(TreeFeatureConfig::deserializeFoliage));
	
	public static Structure<NoFeatureConfig> HELL_CREEK_HUT = new HCHutStructure(NoFeatureConfig::deserialize);
	public static Structure<NoFeatureConfig> MORRISON_HUT = new MorrisonHutStructure(NoFeatureConfig::deserialize);
	public static Structure<NoFeatureConfig> ISCHIGUALASTO_HUT = new IschigualastoStructure(NoFeatureConfig::deserialize);
	public static Structure<NoFeatureConfig> TIME_TEMPLE = new TimeTempleStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType HCHUT_PIECE = HellCreekHutPieces.Piece::new;
	public static IStructurePieceType MORRISON_HUT_PIECE = MorrisonHutPieces.Piece::new;
	public static IStructurePieceType ISCHIGUALASTO_HUT_PIECE = IschigualastoHutPieces.Piece::new;
	public static IStructurePieceType TIME_TEMPLE_PIECE = TimeTemplePieces.Piece::new;
	
	public static void registerFeatures(Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		PrehistoricFauna.register(registry, HELL_CREEK_HUT, "hell_creek_hut");
		PrehistoricFauna.register(registry, MORRISON_HUT, "morrison_hut");
		PrehistoricFauna.register(registry, ISCHIGUALASTO_HUT, "ischigualasto_hut");
		PrehistoricFauna.register(registry, TIME_TEMPLE, "time_temple");
		register(HCHUT_PIECE, "HCHUT_PIECE");
		register(MORRISON_HUT_PIECE, "MORRISON_HUT_PIECE");
		register(ISCHIGUALASTO_HUT_PIECE, "ISCHIGUALASTO_HUT_PIECE");
		register(TIME_TEMPLE_PIECE, "TIME_TEMPLE_PIECE");
	}

	static IStructurePieceType register(IStructurePieceType structurePiece, String key) {
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
	}

	//public static final Feature<PrehistoricGiantTreeFeatureConfig> CYPRESS_TREE = register("cypress_tree", new CypressTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeCypress));
	public static final SurfaceBuilder<SurfaceBuilderConfig> HELL_CREEK = register("hell_creek", new HellCreekSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> MORRISON_SAVANNA = register("morrison", new MorrisonSavannaSB(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> ISCHIGUALASTO = register("ischigualasto", new IschigualastoSB(SurfaceBuilderConfig::deserialize));

	public static void addSedimentDisks(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(SAND, 7, 2, Lists.newArrayList(COARSEDIRT, MOSSYDIRT, PODZOL))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(3))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(CLAY, 4, 1, Lists.newArrayList(COARSEDIRT, CLAY))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(GRAVEL, 6, 2, Lists.newArrayList(COARSEDIRT))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
		return (F)(Registry.<Feature<?>>register(Registry.FEATURE, key, value));
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F)(Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}

}
