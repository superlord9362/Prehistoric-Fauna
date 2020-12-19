package superlord.prehistoricfauna.core.world;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import superlord.prehistoricfauna.world.feature.CrassostreaOystersConfig;
import superlord.prehistoricfauna.world.feature.CrassostreaOystersFeature;
import superlord.prehistoricfauna.world.feature.DicroidiumFeature;
import superlord.prehistoricfauna.world.feature.JohnstoniaFeature;
import superlord.prehistoricfauna.world.feature.config.PHFTreeConfig;
import superlord.prehistoricfauna.world.feature.cretaceous.DidelphodonBurrowFeature;
import superlord.prehistoricfauna.world.feature.cretaceous.araucaria.AraucariaTree1;
import superlord.prehistoricfauna.world.feature.cretaceous.araucaria.AraucariaTree2;
import superlord.prehistoricfauna.world.feature.cretaceous.araucaria.small.AraucariaSmallTree1;
import superlord.prehistoricfauna.world.feature.cretaceous.araucaria.small.AraucariaSmallTree2;
import superlord.prehistoricfauna.world.feature.cretaceous.araucaria.small.AraucariaSmallTree3;
import superlord.prehistoricfauna.world.feature.cretaceous.araucaria.small.AraucariaSmallTree4;
import superlord.prehistoricfauna.world.feature.cretaceous.metasequoia.MetaSequoiaTree1;
import superlord.prehistoricfauna.world.feature.cretaceous.metasequoia.MetaSequoiaTree2;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricGiantTreeFeatureConfig;
import superlord.prehistoricfauna.world.feature.jurassic.PtilophyllumFeature;
import superlord.prehistoricfauna.world.feature.jurassic.ZamitesBushFeature;
import superlord.prehistoricfauna.world.feature.util.SmallPineTree;
import superlord.prehistoricfauna.world.placement.*;

import java.util.ArrayList;
import java.util.List;

import static superlord.prehistoricfauna.core.world.util.WorldGenRegistrationHelper.createFeature;

public class PHFFeatures {
    public static List<Feature<?>> features = new ArrayList<>();

    public static final Feature<TreeFeatureConfig> PROTOPICEOXYLON_TREE = createFeature("protopiceoxylon_tree", new TreeFeature(TreeFeatureConfig::deserializeFoliage));
    public static final Feature<TreeFeatureConfig> HEIDIPHYLLUM_TREE = createFeature("heidiphyllum_tree", new TreeFeature(TreeFeatureConfig::deserializeFoliage));
    public static final Feature<NoFeatureConfig> PTILOPHYLLUM_TREE = createFeature("ptilophyllum_tree", new PtilophyllumFeature(NoFeatureConfig::deserialize));
    public static final Feature<TreeFeatureConfig> PETRIFIED_TREE = createFeature("petrified_tree", new TreeFeature(TreeFeatureConfig::deserializeFoliage));

    public static final Feature<NoFeatureConfig> DUMMY = createFeature("dummy", new SmallPineTree(NoFeatureConfig::deserialize));

    public static final Feature<PHFTreeConfig> ARAUCARIA_SMALL_TREE1 = createFeature("araucaria_small_tree1", new AraucariaSmallTree1(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> ARAUCARIA_SMALL_TREE2 = createFeature("araucaria_small_tree2", new AraucariaSmallTree2(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> ARAUCARIA_SMALL_TREE3 = createFeature("araucaria_small_tree3", new AraucariaSmallTree3(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> ARAUCARIA_SMALL_TREE4 = createFeature("araucaria_small_tree4", new AraucariaSmallTree4(PHFTreeConfig::deserialize));

    public static final Feature<PHFTreeConfig> ARAUCARIA__TREE1 = createFeature("araucaria_tree1", new AraucariaTree1(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> ARAUCARIA__TREE2 = createFeature("araucaria_tree2", new AraucariaTree2(PHFTreeConfig::deserialize));

    public static final Feature<PHFTreeConfig> METASEQUOIA_TREE1 = createFeature("metasequoia_tree1", new MetaSequoiaTree1(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> METASEQUOIA_TREE2 = createFeature("metasequoia_tree2", new MetaSequoiaTree2(PHFTreeConfig::deserialize));



    public static final Feature<CrassostreaOystersConfig> CRASSOSTREA_OYSTERS_FEATURE = createFeature("crassostrea_oysters", new CrassostreaOystersFeature(CrassostreaOystersConfig::deserialize));
    public static final Feature<DidelphodonBurrowConfig> DIDELPHODON_BURROW_FEATURE = createFeature("didelphodon_burrow", new DidelphodonBurrowFeature(DidelphodonBurrowConfig::deserialize));
    public static final Feature<JohnstoniaConfig> JOHNSTONIA_FEATURE = createFeature("johnstonia_feature", new JohnstoniaFeature(JohnstoniaConfig::deserialize));
    public static final Feature<DicroidiumConfig> DICROIDIUM_FEATURE = createFeature("dicroidium_feature", new DicroidiumFeature(DicroidiumConfig::deserialize));

    public static final Feature<TreeFeatureConfig> ZAMITES_BUSH = createFeature("zamites_bush", new ZamitesBushFeature(TreeFeatureConfig::deserializeFoliage));




    public static void init(){
    }
}
