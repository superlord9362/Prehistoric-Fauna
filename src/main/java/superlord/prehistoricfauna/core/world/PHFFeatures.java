package superlord.prehistoricfauna.core.world;

import static superlord.prehistoricfauna.core.world.util.WorldGenRegistrationHelper.createFeature;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import superlord.prehistoricfauna.world.feature.AlgaeFeature;
import superlord.prehistoricfauna.world.feature.AlgaeFeatureConfig;
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
import superlord.prehistoricfauna.world.feature.cretaceous.liriodendrites.Liriodendrites1;
import superlord.prehistoricfauna.world.feature.cretaceous.liriodendrites.Liriodendrites2;
import superlord.prehistoricfauna.world.feature.cretaceous.liriodendrites.Liriodendrites3;
import superlord.prehistoricfauna.world.feature.cretaceous.liriodendrites.Liriodendrites4;
import superlord.prehistoricfauna.world.feature.cretaceous.metasequoia.MetaSequoiaTree1;
import superlord.prehistoricfauna.world.feature.cretaceous.metasequoia.MetaSequoiaTree2;
import superlord.prehistoricfauna.world.feature.jurassic.PtilophyllumFeature;
import superlord.prehistoricfauna.world.feature.jurassic.ZamitesBushFeature;
import superlord.prehistoricfauna.world.feature.tree.Protopiceoxylon1;
import superlord.prehistoricfauna.world.feature.tree.Protopiceoxylon2;
import superlord.prehistoricfauna.world.feature.tree.Protopiceoxylon3;
import superlord.prehistoricfauna.world.feature.tree.Protopiceoxylon4;
import superlord.prehistoricfauna.world.feature.tree.Protopiceoxylon5;
import superlord.prehistoricfauna.world.feature.tree.Protopiceoxylon6;
import superlord.prehistoricfauna.world.feature.tree.Protopiceoxylon7;
import superlord.prehistoricfauna.world.feature.triassic.heidiphyllum.Heidiphyllum1;
import superlord.prehistoricfauna.world.feature.triassic.heidiphyllum.Heidiphyllum2;
import superlord.prehistoricfauna.world.feature.triassic.heidiphyllum.Heidiphyllum3;
import superlord.prehistoricfauna.world.feature.triassic.heidiphyllum.Heidiphyllum4;
import superlord.prehistoricfauna.world.feature.triassic.heidiphyllum.Heidiphyllum5;
import superlord.prehistoricfauna.world.feature.util.SmallPineTree;
import superlord.prehistoricfauna.world.placement.DicroidiumConfig;
import superlord.prehistoricfauna.world.placement.DidelphodonBurrowConfig;
import superlord.prehistoricfauna.world.placement.JohnstoniaConfig;

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

    public static final Feature<PHFTreeConfig> PROTOPICEOXYLON_TREE1 = createFeature("protopiceoxylon_tree1", new Protopiceoxylon1(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> PROTOPICEOXYLON_TREE2 = createFeature("protopiceoxylon_tree2", new Protopiceoxylon2(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> PROTOPICEOXYLON_TREE3 = createFeature("protopiceoxylon_tree3", new Protopiceoxylon3(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> PROTOPICEOXYLON_TREE4 = createFeature("protopiceoxylon_tree4", new Protopiceoxylon4(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> PROTOPICEOXYLON_TREE5 = createFeature("protopiceoxylon_tree5", new Protopiceoxylon5(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> PROTOPICEOXYLON_TREE6 = createFeature("protopiceoxylon_tree6", new Protopiceoxylon6(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> PROTOPICEOXYLON_TREE7 = createFeature("protopiceoxylon_tree7", new Protopiceoxylon7(PHFTreeConfig::deserialize));

    public static final Feature<PHFTreeConfig> LIRIODENDRITES_TREE1 = createFeature("liriodendrites_tree1", new Liriodendrites1(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> LIRIODENDRITES_TREE2 = createFeature("liriodendrites_tree2", new Liriodendrites2(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> LIRIODENDRITES_TREE3 = createFeature("liriodendrites_tree3", new Liriodendrites3(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> LIRIODENDRITES_TREE4 = createFeature("liriodendrites_tree4", new Liriodendrites4(PHFTreeConfig::deserialize));

    public static final Feature<PHFTreeConfig> HEIDIPHYLLUM_TREE1 = createFeature("heidiphyllum_tree1", new Heidiphyllum1(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> HEIDIPHYLLUM_TREE2 = createFeature("heidiphyllum_tree2", new Heidiphyllum2(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> HEIDIPHYLLUM_TREE3 = createFeature("heidiphyllum_tree3", new Heidiphyllum3(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> HEIDIPHYLLUM_TREE4 = createFeature("heidiphyllum_tree4", new Heidiphyllum4(PHFTreeConfig::deserialize));
    public static final Feature<PHFTreeConfig> HEIDIPHYLLUM_TREE5 = createFeature("heidiphyllum_tree5", new Heidiphyllum5(PHFTreeConfig::deserialize));

    public static final Feature<CrassostreaOystersConfig> CRASSOSTREA_OYSTERS_FEATURE = createFeature("crassostrea_oysters", new CrassostreaOystersFeature(CrassostreaOystersConfig::deserialize));
    public static final Feature<AlgaeFeatureConfig> ALGAE_FEATURE = createFeature("algae", new AlgaeFeature(AlgaeFeatureConfig::deserialize));
    public static final Feature<DidelphodonBurrowConfig> DIDELPHODON_BURROW_FEATURE = createFeature("didelphodon_burrow", new DidelphodonBurrowFeature(DidelphodonBurrowConfig::deserialize));
    public static final Feature<JohnstoniaConfig> JOHNSTONIA_FEATURE = createFeature("johnstonia_feature", new JohnstoniaFeature(JohnstoniaConfig::deserialize));
    public static final Feature<DicroidiumConfig> DICROIDIUM_FEATURE = createFeature("dicroidium_feature", new DicroidiumFeature(DicroidiumConfig::deserialize));

    public static final Feature<TreeFeatureConfig> ZAMITES_BUSH = createFeature("zamites_bush", new ZamitesBushFeature(TreeFeatureConfig::deserializeFoliage));




    public static void init(){
    }
}
