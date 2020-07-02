package superlord.prehistoricfauna.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.world.feature.generator.AraucariaTreeGenerator;
import superlord.prehistoricfauna.world.feature.generator.CypressTreeGenerator;
import superlord.prehistoricfauna.world.feature.generator.HellCreekSurfaceBuilder;
import superlord.prehistoricfauna.world.feature.generator.MetasequoiaTreeGenerator;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricGiantTreeFeatureConfig;

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
	
	public static final BlockClusterFeatureConfig HORSETAIL_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(HORSETAIL), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig OSMUNDA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(OSMUNDA), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig CLUBMOSS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CLUBMOSS), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig MARCHANTIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MARCHANTIA), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig LARGE_HORSETAIL_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_HORSETAIL), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig LARGE_OSMUNDA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_OSMUNDA), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig MOSS_PILE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MOSS), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public static final SurfaceBuilderConfig PODZOL_COARSEDIRT_GRAVEL_CONFIG = new SurfaceBuilderConfig(PODZOL, COARSEDIRT, GRAVEL);
	public static final SurfaceBuilderConfig MOSSYDIRT_COARSEDIRT_COARSEDIRT_CONFIG = new SurfaceBuilderConfig(MOSSYDIRT, COARSEDIRT, COARSEDIRT);
	public static final SurfaceBuilderConfig COARSEDIRT_COARSEDIRT_CLAY_CONFIG = new SurfaceBuilderConfig(COARSEDIRT, COARSEDIRT, CLAY);
	
	public static final Feature<PrehistoricGiantTreeFeatureConfig> METASEQUOIA_TREE = register("metasequoia_tree", new MetasequoiaTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeMetasequoia));
	public static final Feature<PrehistoricGiantTreeFeatureConfig> ARAUCARIA_TREE = register("araucaria_tree", new AraucariaTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeAraucaria));
	public static final Feature<PrehistoricGiantTreeFeatureConfig> CYPRESS_TREE = register("cypress_tree", new CypressTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeCypress));
 	public static final SurfaceBuilder<SurfaceBuilderConfig> HELL_CREEK = register("hell_creek", new HellCreekSurfaceBuilder(SurfaceBuilderConfig::deserialize));
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
	      return (F)(Registry.<Feature<?>>register(Registry.FEATURE, key, value));
	   }
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
	      return (F)(Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	   }
	
}
