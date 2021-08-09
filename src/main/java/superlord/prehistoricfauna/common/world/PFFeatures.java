package superlord.prehistoricfauna.common.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.world.feature.AlgaeFeature;
import superlord.prehistoricfauna.world.feature.CrassostreaOystersFeature;
import superlord.prehistoricfauna.world.feature.DicroidiumFeature;
import superlord.prehistoricfauna.world.feature.JohnstoniaFeature;
import superlord.prehistoricfauna.world.feature.PtilophyllumFeature;
import superlord.prehistoricfauna.world.feature.config.CrassostreaOystersConfig;
import superlord.prehistoricfauna.world.feature.config.JohnstoniaConfig;
import superlord.prehistoricfauna.world.feature.config.PFTreeConfig;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaSmallTree1;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaSmallTree2;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaSmallTree3;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaSmallTree4;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaTree1;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaTree2;
import superlord.prehistoricfauna.world.feature.trees.heidiphyllum.HeidiphyllumTree1;
import superlord.prehistoricfauna.world.feature.trees.heidiphyllum.HeidiphyllumTree2;
import superlord.prehistoricfauna.world.feature.trees.heidiphyllum.HeidiphyllumTree3;
import superlord.prehistoricfauna.world.feature.trees.heidiphyllum.HeidiphyllumTree4;
import superlord.prehistoricfauna.world.feature.trees.heidiphyllum.HeidiphyllumTree5;
import superlord.prehistoricfauna.world.feature.trees.liriodendrites.LiriodendritesTree1;
import superlord.prehistoricfauna.world.feature.trees.liriodendrites.LiriodendritesTree2;
import superlord.prehistoricfauna.world.feature.trees.liriodendrites.LiriodendritesTree3;
import superlord.prehistoricfauna.world.feature.trees.liriodendrites.LiriodendritesTree4;
import superlord.prehistoricfauna.world.feature.trees.metasequoia.MetasequoiaTree1;
import superlord.prehistoricfauna.world.feature.trees.metasequoia.MetasequoiaTree2;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree1;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree2;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree3;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree4;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree5;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree6;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree7;
import superlord.prehistoricfauna.world.feature.trees.util.SmallPineTree;
import superlord.prehistoricfauna.world.feature.trees.zamites.ZamiteBushFeature;

public class PFFeatures {
	
    public static List<Feature<?>> features = new ArrayList<>();

	public static final Feature<PFTreeConfig> METASEQUOIA_TREE_1 = createFeature("metasequoia_tree_1", new MetasequoiaTree1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> METASEQUOIA_TREE_2 = createFeature("metasequoia_tree_2", new MetasequoiaTree2(PFTreeConfig.CODEC.stable()));
	
	public static final Feature<PFTreeConfig> ARAUCARIA_TREE_1 = createFeature("araucaria_tree_1", new AraucariaTree1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> ARAUCARIA_TREE_2 = createFeature("araucaria_tree_2", new AraucariaTree2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> ARAUCARIA_SMALL_TREE_1 = createFeature("araucaria_small_tree_1", new AraucariaSmallTree1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> ARAUCARIA_SMALL_TREE_2 = createFeature("araucaria_small_tree_2", new AraucariaSmallTree2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> ARAUCARIA_SMALL_TREE_3 = createFeature("araucaria_small_tree_3", new AraucariaSmallTree3(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> ARAUCARIA_SMALL_TREE_4 = createFeature("araucaria_small_tree_4", new AraucariaSmallTree4(PFTreeConfig.CODEC.stable()));
	
	public static final Feature<PFTreeConfig> LIRIODENDRITES_TREE_1 = createFeature("liriodendrites_tree_1", new LiriodendritesTree1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> LIRIODENDRITES_TREE_2 = createFeature("liriodendrites_tree_2", new LiriodendritesTree2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> LIRIODENDRITES_TREE_3 = createFeature("liriodendrites_tree_3", new LiriodendritesTree3(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> LIRIODENDRITES_TREE_4 = createFeature("liriodendrites_tree_4", new LiriodendritesTree4(PFTreeConfig.CODEC.stable()));
	
	public static final Feature<PFTreeConfig> PROTOPICEOXYLON_TREE_1 = createFeature("protopiceoxylon_tree_1", new ProtopiceoxylonTree1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> PROTOPICEOXYLON_TREE_2 = createFeature("protopiceoxylon_tree_2", new ProtopiceoxylonTree2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> PROTOPICEOXYLON_TREE_3 = createFeature("protopiceoxylon_tree_3", new ProtopiceoxylonTree3(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> PROTOPICEOXYLON_TREE_4 = createFeature("protopiceoxylon_tree_4", new ProtopiceoxylonTree4(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> PROTOPICEOXYLON_TREE_5 = createFeature("protopiceoxylon_tree_5", new ProtopiceoxylonTree5(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> PROTOPICEOXYLON_TREE_6 = createFeature("protopiceoxylon_tree_6", new ProtopiceoxylonTree6(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> PROTOPICEOXYLON_TREE_7 = createFeature("protopiceoxylon_tree_7", new ProtopiceoxylonTree7(PFTreeConfig.CODEC.stable()));
	
	public static final Feature<PFTreeConfig> HEIDIPHYLLUM_TREE_1 = createFeature("heidiphyllum_tree_1", new HeidiphyllumTree1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> HEIDIPHYLLUM_TREE_2 = createFeature("heidiphyllum_tree_2", new HeidiphyllumTree2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> HEIDIPHYLLUM_TREE_3 = createFeature("heidiphyllum_tree_3", new HeidiphyllumTree3(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> HEIDIPHYLLUM_TREE_4 = createFeature("heidiphyllum_tree_4", new HeidiphyllumTree4(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> HEIDIPHYLLUM_TREE_5 = createFeature("heidiphyllum_tree_5", new HeidiphyllumTree5(PFTreeConfig.CODEC.stable()));

    public static final Feature<NoFeatureConfig> DUMMY = createFeature("dummy", new SmallPineTree(NoFeatureConfig.field_236558_a_.stable()));
    
    public static final Feature<NoFeatureConfig> PTILOPHYLLUM_TREE = createFeature("ptilophyllum_tree", new PtilophyllumFeature(NoFeatureConfig.field_236558_a_.stable()));
    public static final Feature<BaseTreeFeatureConfig> ZAMITES_BUSH = createFeature("zamites_bush", new ZamiteBushFeature(BaseTreeFeatureConfig.CODEC.stable()));
    public static final Feature<JohnstoniaConfig> JOHNSTONIA_FEATURE = createFeature("johnstonia_feature", new JohnstoniaFeature(JohnstoniaConfig.field_236558_a_.stable()));
    public static final Feature<JohnstoniaConfig> DICROIDIUM_FEATURE = createFeature("dicroidium_feature", new DicroidiumFeature(JohnstoniaConfig.field_236558_a_.stable()));

    public static final Feature<CrassostreaOystersConfig> CRASSOSTREA_OYSTERS_FEATURE = createFeature("crassostrea_oysters", new CrassostreaOystersFeature(CrassostreaOystersConfig.field_236558_a_.stable()));
    public static final Feature<CrassostreaOystersConfig> ALGAE_FEATURE = createFeature("algae", new AlgaeFeature(CrassostreaOystersConfig.field_236558_a_.stable()));

    
    //public static final Feature<CrassostreaOystersConfig> CRASSOSTREA_OYSTERS_FEATURE = createFeature("crassostrea_oysters", new CrassostreaOystersFeature(CrassostreaOystersConfig::deserialize));
    //public static final Feature<CrassostreaOystersConfig> ALGAE_FEATURE = createFeature("algae", new AlgaeFeature(CrassostreaOystersConfig::deserialize));

    
	@SuppressWarnings("deprecation")
	public static <C extends IFeatureConfig, F extends Feature<C>> F createFeature(String id, F feature) {
		ResourceLocation pfID = new ResourceLocation(PrehistoricFauna.MOD_ID, id);
		if (Registry.FEATURE.keySet().contains(pfID))
			throw new IllegalStateException("Feature ID: \"" + pfID.toString() + "\" already exists in the Features registry!");
		feature.setRegistryName(pfID); //Forge
		PFFeatures.features.add(feature);
		return feature;
	}

	public static void init() {
	}

}
