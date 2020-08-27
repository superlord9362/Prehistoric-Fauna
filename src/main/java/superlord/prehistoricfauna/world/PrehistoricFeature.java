package superlord.prehistoricfauna.world;

import com.google.common.collect.Lists;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.world.feature.JohnstoniaFeature;
import superlord.prehistoricfauna.world.feature.PtilophyllumFeature;
import superlord.prehistoricfauna.world.feature.ZamitesBushFeature;
import superlord.prehistoricfauna.world.feature.generator.AraucariaTreeGenerator;
import superlord.prehistoricfauna.world.feature.generator.HellCreekSurfaceBuilder;
import superlord.prehistoricfauna.world.feature.generator.IschigualastoSurfaceBuilder;
import superlord.prehistoricfauna.world.feature.generator.MetasequoiaTreeGenerator;
import superlord.prehistoricfauna.world.feature.generator.MorrisonSavannaSurfaceBuilder;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricGiantTreeFeatureConfig;
import superlord.prehistoricfauna.world.placement.DicroidiumBlockPlacer;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.FORGE)
public class PrehistoricFeature {
	
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
	public static final BlockClusterFeatureConfig DICROIDIUN_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DICROIDIUM), new DicroidiumBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig HORSETAIL_WATER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(HORSETAIL), new SimpleBlockPlacer())).tries(64).func_227317_b_().requiresWater().build();
	public static final BlockClusterFeatureConfig LARGE_HORSETAIL_WATER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_HORSETAIL), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().requiresWater().build();
	public static final SurfaceBuilderConfig PODZOL_COARSEDIRT_GRAVEL_CONFIG = new SurfaceBuilderConfig(PODZOL, COARSEDIRT, GRAVEL);
	public static final SurfaceBuilderConfig MOSSYDIRT_COARSEDIRT_COARSEDIRT_CONFIG = new SurfaceBuilderConfig(MOSSYDIRT, COARSEDIRT, COARSEDIRT);
	public static final SurfaceBuilderConfig COARSEDIRT_COARSEDIRT_CLAY_CONFIG = new SurfaceBuilderConfig(COARSEDIRT, COARSEDIRT, CLAY);
	public static final SurfaceBuilderConfig SAND_COARSEDIRT_COARSEDIRT_CONFG = new SurfaceBuilderConfig(SAND, COARSEDIRT, COARSEDIRT);
	public static final SurfaceBuilderConfig LOAM_LOAM_COARSEDIRT_CONFIG = new SurfaceBuilderConfig(LOAM, LOAM, COARSEDIRT);
	
	public static final Feature<PrehistoricGiantTreeFeatureConfig> METASEQUOIA_TREE = register("metasequoia_tree", new MetasequoiaTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeMetasequoia));
	public static final Feature<PrehistoricGiantTreeFeatureConfig> PROTOJUNIPER_TREE = register("protojuniper_tree", new MetasequoiaTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeProtojuniper));
	public static final Feature<PrehistoricGiantTreeFeatureConfig> ARAUCARIA_TREE = register("araucaria_tree", new AraucariaTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeAraucaria));
	public static final Feature<TreeFeatureConfig> YOUNG_ARAUCARIA_TREE = register("young_araucaria_tree", new TreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<TreeFeatureConfig> PROTOPICEOXYLON_TREE = register("protopiceoxylon_tree", new TreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<NoFeatureConfig> PTILOPHYLLUM_TREE = register("ptilophyllum_tree", new PtilophyllumFeature(NoFeatureConfig::deserialize));

	public static final Feature<TreeFeatureConfig> ZAMITES_BUSH = register("zamites_bush", new ZamitesBushFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<TreeFeatureConfig> ZAMITES_BUSH = register("zamites_bush", new TreeFeature(TreeFeatureConfig::func_227338_a_));
	public static final Feature<NoFeatureConfig> JOHNSTONIA_CONFIG = register("johnstonia_config", new JohnstoniaFeature(NoFeatureConfig::deserialize));

	//public static final Feature<PrehistoricGiantTreeFeatureConfig> CYPRESS_TREE = register("cypress_tree", new CypressTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeCypress));
	public static final SurfaceBuilder<SurfaceBuilderConfig> HELL_CREEK = register("hell_creek", new HellCreekSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> MORRISON_SAVANNA = register("morrison", new MorrisonSavannaSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	public static final SurfaceBuilder<SurfaceBuilderConfig> ISCHIGUALASTO = register("ischigualasto", new IschigualastoSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	
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
