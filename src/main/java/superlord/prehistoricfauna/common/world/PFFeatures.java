package superlord.prehistoricfauna.common.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.features.BigBlockBlobFeature;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.world.feature.AlgaeFeature;
import superlord.prehistoricfauna.world.feature.CrassostreaOystersFeature;
import superlord.prehistoricfauna.world.feature.DicroidiumFeature;
import superlord.prehistoricfauna.world.feature.JohnstoniaFeature;
import superlord.prehistoricfauna.world.feature.LandSphereReplaceFeature;
import superlord.prehistoricfauna.world.feature.NeocalamitesFeature;
import superlord.prehistoricfauna.world.feature.NoisySphereFeature;
import superlord.prehistoricfauna.world.feature.PtilophyllumFeature;
import superlord.prehistoricfauna.world.feature.WaterloggedHorsetailsFeature;
import superlord.prehistoricfauna.world.feature.config.CrassostreaOystersConfig;
import superlord.prehistoricfauna.world.feature.config.JohnstoniaConfig;
import superlord.prehistoricfauna.world.feature.config.NoisySphereConfig;
import superlord.prehistoricfauna.world.feature.config.PFTreeConfig;
import superlord.prehistoricfauna.world.feature.trees.agathoxylon.BigAgathoxylon1;
import superlord.prehistoricfauna.world.feature.trees.agathoxylon.BigAgathoxylon2;
import superlord.prehistoricfauna.world.feature.trees.agathoxylon.BigAgathoxylon3;
import superlord.prehistoricfauna.world.feature.trees.agathoxylon.MiddleAgathoxylon1;
import superlord.prehistoricfauna.world.feature.trees.agathoxylon.MiddleAgathoxylon2;
import superlord.prehistoricfauna.world.feature.trees.agathoxylon.SmallAgathoxylon1;
import superlord.prehistoricfauna.world.feature.trees.agathoxylon.SmallAgathoxylon2;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaSmallTree1;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaSmallTree2;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaSmallTree3;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaSmallTree4;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaTree1;
import superlord.prehistoricfauna.world.feature.trees.araucaria.AraucariaTree2;
import superlord.prehistoricfauna.world.feature.trees.brachyphyllum.Brachyphyllum1;
import superlord.prehistoricfauna.world.feature.trees.brachyphyllum.Brachyphyllum2;
import superlord.prehistoricfauna.world.feature.trees.brachyphyllum.Brachyphyllum3;
import superlord.prehistoricfauna.world.feature.trees.brachyphyllum.Brachyphyllum4;
import superlord.prehistoricfauna.world.feature.trees.ginkgo.Ginkgo1;
import superlord.prehistoricfauna.world.feature.trees.ginkgo.Ginkgo2;
import superlord.prehistoricfauna.world.feature.trees.ginkgo.Ginkgo3;
import superlord.prehistoricfauna.world.feature.trees.ginkgo.Ginkgo4;
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
import superlord.prehistoricfauna.world.feature.trees.metasequoia.SmallMetasequoia1;
import superlord.prehistoricfauna.world.feature.trees.metasequoia.SmallMetasequoia2;
import superlord.prehistoricfauna.world.feature.trees.metasequoia.SmallMetasequoia3;
import superlord.prehistoricfauna.world.feature.trees.petrified.PetrifiedTreeFeature;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree1;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree2;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree3;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree4;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree5;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree6;
import superlord.prehistoricfauna.world.feature.trees.protopiceoxylon.ProtopiceoxylonTree7;
import superlord.prehistoricfauna.world.feature.trees.schilderia.Schilderia1;
import superlord.prehistoricfauna.world.feature.trees.schilderia.Schilderia2;
import superlord.prehistoricfauna.world.feature.trees.schilderia.Schilderia3;
import superlord.prehistoricfauna.world.feature.trees.schilderia.Schilderia4;
import superlord.prehistoricfauna.world.feature.trees.trochodendroides.Trochodendroides1;
import superlord.prehistoricfauna.world.feature.trees.trochodendroides.Trochodendroides2;
import superlord.prehistoricfauna.world.feature.trees.trochodendroides.Trochodendroides3;
import superlord.prehistoricfauna.world.feature.trees.trochodendroides.Trochodendroides4;
import superlord.prehistoricfauna.world.feature.trees.util.SmallPineTree;
import superlord.prehistoricfauna.world.feature.trees.woodworthia.Woodworthia1;
import superlord.prehistoricfauna.world.feature.trees.woodworthia.Woodworthia2;
import superlord.prehistoricfauna.world.feature.trees.woodworthia.Woodworthia3;
import superlord.prehistoricfauna.world.feature.trees.woodworthia.Woodworthia4;
import superlord.prehistoricfauna.world.feature.trees.zamites.ZamiteBushFeature;

public class PFFeatures {
	
    public static List<Feature<?>> features = new ArrayList<>();

	public static final Feature<PFTreeConfig> METASEQUOIA_TREE_1 = createFeature("metasequoia_tree_1", new MetasequoiaTree1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> METASEQUOIA_TREE_2 = createFeature("metasequoia_tree_2", new MetasequoiaTree2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> METASEQUOIA_SMALL_TREE_1 = createFeature("metasequoia_small_tree_1", new SmallMetasequoia1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> METASEQUOIA_SMALL_TREE_2 = createFeature("metasequoia_small_tree_2", new SmallMetasequoia2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> METASEQUOIA_SMALL_TREE_3 = createFeature("metasequoia_small_tree_3", new SmallMetasequoia3(PFTreeConfig.CODEC.stable()));

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
	
	public static final Feature<PFTreeConfig> GINKGO_TREE_1 = createFeature("ginkgo_1", new Ginkgo1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> GINKGO_TREE_2 = createFeature("ginkgo_2", new Ginkgo2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> GINKGO_TREE_3 = createFeature("ginkgo_3", new Ginkgo3(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> GINKGO_TREE_4 = createFeature("ginkgo_4", new Ginkgo4(PFTreeConfig.CODEC.stable()));
	
	public static final Feature<PFTreeConfig> TROCHODENDROIDES_TREE_1 = createFeature("trochodendroides_1", new Trochodendroides1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> TROCHODENDROIDES_TREE_2 = createFeature("trochodendroides_2", new Trochodendroides2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> TROCHODENDROIDES_TREE_3 = createFeature("trochodendroides_3", new Trochodendroides3(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> TROCHODENDROIDES_TREE_4 = createFeature("trochodendroides_4", new Trochodendroides4(PFTreeConfig.CODEC.stable()));

	public static final Feature<PFTreeConfig> BRACHYPHYLLUM_TREE_1 = createFeature("brachyphyllum_1", new Brachyphyllum1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> BRACHYPHYLLUM_TREE_2 = createFeature("brachyphyllum_2", new Brachyphyllum2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> BRACHYPHYLLUM_TREE_3 = createFeature("brachyphyllum_3", new Brachyphyllum3(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> BRACHYPHYLLUM_TREE_4 = createFeature("brachyphyllum_4", new Brachyphyllum4(PFTreeConfig.CODEC.stable()));
	
	public static final Feature<PFTreeConfig> WOODWORTHIA_TREE_1 = createFeature("woodworthia_1", new Woodworthia1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> WOODWORTHIA_TREE_2 = createFeature("woodworthia_2", new Woodworthia2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> WOODWORTHIA_TREE_3 = createFeature("woodworthia_3", new Woodworthia3(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> WOODWORTHIA_TREE_4 = createFeature("woodworthia_4", new Woodworthia4(PFTreeConfig.CODEC.stable()));
	
	public static final Feature<PFTreeConfig> SCHILDERIA_TREE_1 = createFeature("schilderia_1", new Schilderia1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> SCHILDERIA_TREE_2 = createFeature("schilderia_2", new Schilderia2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> SCHILDERIA_TREE_3 = createFeature("schilderia_3", new Schilderia3(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> SCHILDERIA_TREE_4 = createFeature("schilderia_4", new Schilderia4(PFTreeConfig.CODEC.stable()));
	
	public static final Feature<PFTreeConfig> SMALL_AGATHOXYLON_1 = createFeature("small_agathoxylon_1", new SmallAgathoxylon1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> SMALL_AGATHOXYLON_2 = createFeature("small_agathoxylon_2", new SmallAgathoxylon2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> MEDIUM_AGATHOXYLON_1 = createFeature("medium_agathoxylon_1", new MiddleAgathoxylon1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> MEDIUM_AGATHOXYLON_2 = createFeature("medium_agathoxylon_2", new MiddleAgathoxylon2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> LARGE_AGATHOXYLON_1 = createFeature("large_agathoxylon_1", new BigAgathoxylon1(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> LARGE_AGATHOXYLON_2 = createFeature("large_agathoxylon_2", new BigAgathoxylon2(PFTreeConfig.CODEC.stable()));
	public static final Feature<PFTreeConfig> LARGE_AGATHOXYLON_3 = createFeature("large_agathoxylon_3", new BigAgathoxylon3(PFTreeConfig.CODEC.stable()));

    public static final Feature<NoFeatureConfig> DUMMY = createFeature("dummy", new SmallPineTree(NoFeatureConfig.field_236558_a_.stable()));
    
    public static final Feature<NoFeatureConfig> PTILOPHYLLUM_TREE = createFeature("ptilophyllum_tree", new PtilophyllumFeature(NoFeatureConfig.field_236558_a_.stable()));
    public static final Feature<JohnstoniaConfig> ZAMITES_BUSH = createFeature("zamites_bush", new ZamiteBushFeature(JohnstoniaConfig.field_236558_a_.stable()));
    public static final Feature<JohnstoniaConfig> PETRIFIED_TREE = createFeature("petrified_tree", new PetrifiedTreeFeature(JohnstoniaConfig.field_236558_a_.stable()));
    public static final Feature<JohnstoniaConfig> JOHNSTONIA_FEATURE = createFeature("johnstonia_feature", new JohnstoniaFeature(JohnstoniaConfig.field_236558_a_.stable()));
    public static final Feature<JohnstoniaConfig> DICROIDIUM_FEATURE = createFeature("dicroidium_feature", new DicroidiumFeature(JohnstoniaConfig.field_236558_a_.stable()));
    public static final Feature<JohnstoniaConfig> NEOCALAMITES_FEATURE = createFeature("neocalamites_feature", new NeocalamitesFeature(JohnstoniaConfig.field_236558_a_.stable()));
    public static final Feature<SphereReplaceConfig> LAND_DISK_FEATURE = createFeature("land_disk_feature", new LandSphereReplaceFeature(SphereReplaceConfig.field_236516_a_.stable()));
    public static final Feature<JohnstoniaConfig> TALL_HORSETAILS_FEATURE = createFeature("tall_horsetails_feature", new WaterloggedHorsetailsFeature(JohnstoniaConfig.field_236558_a_.stable()));

    public static final Feature<CrassostreaOystersConfig> CRASSOSTREA_OYSTERS_FEATURE = createFeature("crassostrea_oysters", new CrassostreaOystersFeature(CrassostreaOystersConfig.field_236558_a_.stable()));
    public static final Feature<CrassostreaOystersConfig> ALGAE_FEATURE = createFeature("algae", new AlgaeFeature(CrassostreaOystersConfig.field_236558_a_.stable()));

    public static final Feature<NoisySphereConfig> NOISY_SPHERE = createFeature("noisy_sphere", new NoisySphereFeature(NoisySphereConfig.CODEC.stable()));
	public static final Feature<BlockStateFeatureConfig> BIG_BLOB = createFeature("big_block_blob", new BigBlockBlobFeature(BlockStateFeatureConfig.field_236455_a_.stable()));

    
    public static final BlockClusterFeatureConfig DEAD_CYCAD_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PFBlocks.DEAD_OSMUNDACAULIS.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(4).build();

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
