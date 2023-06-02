package superlord.prehistoricfauna.init;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.feature.AlgaeFeature;
import superlord.prehistoricfauna.common.feature.BigBlockBlobFeature;
import superlord.prehistoricfauna.common.feature.CrassostreaOystersFeature;
import superlord.prehistoricfauna.common.feature.DicroidiumFeature;
import superlord.prehistoricfauna.common.feature.DjadochtaHorsetailsFeature;
import superlord.prehistoricfauna.common.feature.JohnstoniaFeature;
import superlord.prehistoricfauna.common.feature.LandSphereReplaceFeature;
import superlord.prehistoricfauna.common.feature.NeocalamitesFeature;
import superlord.prehistoricfauna.common.feature.NoisySphereFeature;
import superlord.prehistoricfauna.common.feature.PtilophyllumFeature;
import superlord.prehistoricfauna.common.feature.WaterloggedHorsetailsFeature;
import superlord.prehistoricfauna.common.feature.trees.agathoxylon.BigAgathoxylon1;
import superlord.prehistoricfauna.common.feature.trees.agathoxylon.BigAgathoxylon2;
import superlord.prehistoricfauna.common.feature.trees.agathoxylon.BigAgathoxylon3;
import superlord.prehistoricfauna.common.feature.trees.agathoxylon.MiddleAgathoxylon1;
import superlord.prehistoricfauna.common.feature.trees.agathoxylon.MiddleAgathoxylon2;
import superlord.prehistoricfauna.common.feature.trees.agathoxylon.SmallAgathoxylon1;
import superlord.prehistoricfauna.common.feature.trees.agathoxylon.SmallAgathoxylon2;
import superlord.prehistoricfauna.common.feature.trees.araucaria.AraucariaSmallTree1;
import superlord.prehistoricfauna.common.feature.trees.araucaria.AraucariaSmallTree2;
import superlord.prehistoricfauna.common.feature.trees.araucaria.AraucariaSmallTree3;
import superlord.prehistoricfauna.common.feature.trees.araucaria.AraucariaSmallTree4;
import superlord.prehistoricfauna.common.feature.trees.araucaria.AraucariaTree1;
import superlord.prehistoricfauna.common.feature.trees.araucaria.AraucariaTree2;
import superlord.prehistoricfauna.common.feature.trees.brachyphyllum.Brachyphyllum1;
import superlord.prehistoricfauna.common.feature.trees.brachyphyllum.Brachyphyllum2;
import superlord.prehistoricfauna.common.feature.trees.brachyphyllum.Brachyphyllum3;
import superlord.prehistoricfauna.common.feature.trees.brachyphyllum.Brachyphyllum4;
import superlord.prehistoricfauna.common.feature.trees.ginkgo.Ginkgo1;
import superlord.prehistoricfauna.common.feature.trees.ginkgo.Ginkgo2;
import superlord.prehistoricfauna.common.feature.trees.ginkgo.Ginkgo3;
import superlord.prehistoricfauna.common.feature.trees.ginkgo.Ginkgo4;
import superlord.prehistoricfauna.common.feature.trees.heidiphyllum.HeidiphyllumTree1;
import superlord.prehistoricfauna.common.feature.trees.heidiphyllum.HeidiphyllumTree2;
import superlord.prehistoricfauna.common.feature.trees.heidiphyllum.HeidiphyllumTree3;
import superlord.prehistoricfauna.common.feature.trees.heidiphyllum.HeidiphyllumTree4;
import superlord.prehistoricfauna.common.feature.trees.heidiphyllum.HeidiphyllumTree5;
import superlord.prehistoricfauna.common.feature.trees.liriodendrites.LiriodendritesTree1;
import superlord.prehistoricfauna.common.feature.trees.liriodendrites.LiriodendritesTree2;
import superlord.prehistoricfauna.common.feature.trees.liriodendrites.LiriodendritesTree3;
import superlord.prehistoricfauna.common.feature.trees.liriodendrites.LiriodendritesTree4;
import superlord.prehistoricfauna.common.feature.trees.metasequoia.MetasequoiaTree1;
import superlord.prehistoricfauna.common.feature.trees.metasequoia.MetasequoiaTree2;
import superlord.prehistoricfauna.common.feature.trees.metasequoia.SmallMetasequoia1;
import superlord.prehistoricfauna.common.feature.trees.metasequoia.SmallMetasequoia2;
import superlord.prehistoricfauna.common.feature.trees.metasequoia.SmallMetasequoia3;
import superlord.prehistoricfauna.common.feature.trees.petrified.PetrifiedTreeFeature;
import superlord.prehistoricfauna.common.feature.trees.protopiceoxylon.ProtopiceoxylonTree1;
import superlord.prehistoricfauna.common.feature.trees.protopiceoxylon.ProtopiceoxylonTree2;
import superlord.prehistoricfauna.common.feature.trees.protopiceoxylon.ProtopiceoxylonTree3;
import superlord.prehistoricfauna.common.feature.trees.protopiceoxylon.ProtopiceoxylonTree4;
import superlord.prehistoricfauna.common.feature.trees.protopiceoxylon.ProtopiceoxylonTree5;
import superlord.prehistoricfauna.common.feature.trees.protopiceoxylon.ProtopiceoxylonTree6;
import superlord.prehistoricfauna.common.feature.trees.protopiceoxylon.ProtopiceoxylonTree7;
import superlord.prehistoricfauna.common.feature.trees.schilderia.Schilderia1;
import superlord.prehistoricfauna.common.feature.trees.schilderia.Schilderia2;
import superlord.prehistoricfauna.common.feature.trees.schilderia.Schilderia3;
import superlord.prehistoricfauna.common.feature.trees.schilderia.Schilderia4;
import superlord.prehistoricfauna.common.feature.trees.trochodendroides.Trochodendroides1;
import superlord.prehistoricfauna.common.feature.trees.trochodendroides.Trochodendroides2;
import superlord.prehistoricfauna.common.feature.trees.trochodendroides.Trochodendroides3;
import superlord.prehistoricfauna.common.feature.trees.trochodendroides.Trochodendroides4;
import superlord.prehistoricfauna.common.feature.trees.util.JohnstoniaConfig;
import superlord.prehistoricfauna.common.feature.trees.woodworthia.Woodworthia1;
import superlord.prehistoricfauna.common.feature.trees.woodworthia.Woodworthia2;
import superlord.prehistoricfauna.common.feature.trees.woodworthia.Woodworthia3;
import superlord.prehistoricfauna.common.feature.trees.woodworthia.Woodworthia4;
import superlord.prehistoricfauna.common.feature.trees.zamites.ZamitesBushFeature;
import superlord.prehistoricfauna.common.util.CrassostreaOystersConfig;
import superlord.prehistoricfauna.common.util.NoisySphereConfig;
import superlord.prehistoricfauna.common.util.trees.PFTreeConfig;

public class PFFeatures {
	
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, PrehistoricFauna.MOD_ID);

    public static final RegistryObject<AraucariaSmallTree1> SMALL_ARAUCARIA_TREE_1 = REGISTER.register("small_araucaria_tree_1", () -> new AraucariaSmallTree1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<AraucariaSmallTree2> SMALL_ARAUCARIA_TREE_2 = REGISTER.register("small_araucaria_tree_2", () -> new AraucariaSmallTree2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<AraucariaSmallTree3> SMALL_ARAUCARIA_TREE_3 = REGISTER.register("small_araucaria_tree_3", () -> new AraucariaSmallTree3(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<AraucariaSmallTree4> SMALL_ARAUCARIA_TREE_4 = REGISTER.register("small_araucaria_tree_4", () -> new AraucariaSmallTree4(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<AraucariaTree1> ARAUCARIA_TREE_1 = REGISTER.register("araucaria_tree_1", () -> new AraucariaTree1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<AraucariaTree2> ARAUCARIA_TREE_2 = REGISTER.register("araucaria_tree_2", () -> new AraucariaTree2(PFTreeConfig.CODEC.stable()));
    
    public static final RegistryObject<SmallAgathoxylon1> SMALL_AGATHOXYLON_TREE_1 = REGISTER.register("small_agathoxylon_tree_1", () -> new SmallAgathoxylon1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<SmallAgathoxylon2> SMALL_AGATHOXYLON_TREE_2 = REGISTER.register("small_agathoxylon_tree_2", () -> new SmallAgathoxylon2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<MiddleAgathoxylon1> MIDDLE_AGATHOXYLON_TREE_1 = REGISTER.register("medium_agathoxylon_tree_1", () -> new MiddleAgathoxylon1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<MiddleAgathoxylon2> MIDDLE_AGATHOXYLON_TREE_2 = REGISTER.register("medium_agathoxylon_tree_2", () -> new MiddleAgathoxylon2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<BigAgathoxylon1> BIG_AGATHOXYLON_TREE_1 = REGISTER.register("big_agathoxylon_tree_1", () -> new BigAgathoxylon1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<BigAgathoxylon2> BIG_AGATHOXYLON_TREE_2 = REGISTER.register("big_agathoxylon_tree_2", () -> new BigAgathoxylon2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<BigAgathoxylon3> BIG_AGATHOXYLON_TREE_3 = REGISTER.register("big_agathoxylon_tree_3", () -> new BigAgathoxylon3(PFTreeConfig.CODEC.stable()));
  
    public static final RegistryObject<Brachyphyllum1> BRACHYPHYLLUM_TREE_1 = REGISTER.register("brachyphyllum_tree_1", () -> new Brachyphyllum1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Brachyphyllum2> BRACHYPHYLLUM_TREE_2 = REGISTER.register("brachyphyllum_tree_2", () -> new Brachyphyllum2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Brachyphyllum3> BRACHYPHYLLUM_TREE_3 = REGISTER.register("brachyphyllum_tree_3", () -> new Brachyphyllum3(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Brachyphyllum4> BRACHYPHYLLUM_TREE_4 = REGISTER.register("brachyphyllum_tree_4", () -> new Brachyphyllum4(PFTreeConfig.CODEC.stable()));

    public static final RegistryObject<Ginkgo1> GINKGO_TREE_1 = REGISTER.register("ginkgo_tree_1", () -> new Ginkgo1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Ginkgo2> GINKGO_TREE_2 = REGISTER.register("ginkgo_tree_2", () -> new Ginkgo2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Ginkgo3> GINKGO_TREE_3 = REGISTER.register("ginkgo_tree_3", () -> new Ginkgo3(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Ginkgo4> GINKGO_TREE_4 = REGISTER.register("ginkgo_tree_4", () -> new Ginkgo4(PFTreeConfig.CODEC.stable()));

    public static final RegistryObject<HeidiphyllumTree1> HEIDIPHYLLUM_TREE_1 = REGISTER.register("heidiphyllum_tree_1", () -> new HeidiphyllumTree1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<HeidiphyllumTree2> HEIDIPHYLLUM_TREE_2 = REGISTER.register("heidiphyllum_tree_2", () -> new HeidiphyllumTree2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<HeidiphyllumTree3> HEIDIPHYLLUM_TREE_3 = REGISTER.register("heidiphyllum_tree_3", () -> new HeidiphyllumTree3(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<HeidiphyllumTree4> HEIDIPHYLLUM_TREE_4 = REGISTER.register("heidiphyllum_tree_4", () -> new HeidiphyllumTree4(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<HeidiphyllumTree5> HEIDIPHYLLUM_TREE_5 = REGISTER.register("heidiphyllum_tree_5", () -> new HeidiphyllumTree5(PFTreeConfig.CODEC.stable()));

    public static final RegistryObject<LiriodendritesTree1> LIRIODENDRITES_TREE_1 = REGISTER.register("liriodendrites_tree_1", () -> new LiriodendritesTree1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<LiriodendritesTree2> LIRIODENDRITES_TREE_2 = REGISTER.register("liriodendrites_tree_2", () -> new LiriodendritesTree2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<LiriodendritesTree3> LIRIODENDRITES_TREE_3 = REGISTER.register("liriodendrites_tree_3", () -> new LiriodendritesTree3(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<LiriodendritesTree4> LIRIODENDRITES_TREE_4 = REGISTER.register("liriodendrites_tree_4", () -> new LiriodendritesTree4(PFTreeConfig.CODEC.stable()));

    public static final RegistryObject<MetasequoiaTree1> LARGE_METASEQUOIA_TREE_1 = REGISTER.register("large_metasequoia_tree_1", () -> new MetasequoiaTree1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<MetasequoiaTree2> LARGE_METASEQUOIA_TREE_2 = REGISTER.register("large_metasequoia_tree_2", () -> new MetasequoiaTree2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<SmallMetasequoia1> METASEQUOIA_TREE_1 = REGISTER.register("small_metasequoia_tree_1", () -> new SmallMetasequoia1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<SmallMetasequoia2> METASEQUOIA_TREE_2 = REGISTER.register("small_metasequoia_tree_2", () -> new SmallMetasequoia2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<SmallMetasequoia3> METASEQUOIA_TREE_3 = REGISTER.register("small_metasequoia_tree_3", () -> new SmallMetasequoia3(PFTreeConfig.CODEC.stable()));

    public static final RegistryObject<ProtopiceoxylonTree1> PROTOPICEOXYLON_TREE_1 = REGISTER.register("protopiceoxylon_tree_1", () -> new ProtopiceoxylonTree1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<ProtopiceoxylonTree2> PROTOPICEOXYLON_TREE_2 = REGISTER.register("protopiceoxylon_tree_2", () -> new ProtopiceoxylonTree2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<ProtopiceoxylonTree3> PROTOPICEOXYLON_TREE_3 = REGISTER.register("protopiceoxylon_tree_3", () -> new ProtopiceoxylonTree3(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<ProtopiceoxylonTree4> PROTOPICEOXYLON_TREE_4 = REGISTER.register("protopiceoxylon_tree_4", () -> new ProtopiceoxylonTree4(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<ProtopiceoxylonTree5> PROTOPICEOXYLON_TREE_5 = REGISTER.register("protopiceoxylon_tree_5", () -> new ProtopiceoxylonTree5(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<ProtopiceoxylonTree6> PROTOPICEOXYLON_TREE_6 = REGISTER.register("protopiceoxylon_tree_6", () -> new ProtopiceoxylonTree6(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<ProtopiceoxylonTree7> PROTOPICEOXYLON_TREE_7 = REGISTER.register("protopiceoxylon_tree_7", () -> new ProtopiceoxylonTree7(PFTreeConfig.CODEC.stable()));

    public static final RegistryObject<Schilderia1> SCHILDERIA_TREE_1 = REGISTER.register("schilderia_tree_1", () -> new Schilderia1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Schilderia2> SCHILDERIA_TREE_2 = REGISTER.register("schilderia_tree_2", () -> new Schilderia2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Schilderia3> SCHILDERIA_TREE_3 = REGISTER.register("schilderia_tree_3", () -> new Schilderia3(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Schilderia4> SCHILDERIA_TREE_4 = REGISTER.register("schilderia_tree_4", () -> new Schilderia4(PFTreeConfig.CODEC.stable()));

    public static final RegistryObject<Trochodendroides1> TROCHODENDROIDES_TREE_1 = REGISTER.register("trochodendroides_tree_1", () -> new Trochodendroides1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Trochodendroides2> TROCHODENDROIDES_TREE_2 = REGISTER.register("trochodendroides_tree_2", () -> new Trochodendroides2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Trochodendroides3> TROCHODENDROIDES_TREE_3 = REGISTER.register("trochodendroides_tree_3", () -> new Trochodendroides3(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Trochodendroides4> TROCHODENDROIDES_TREE_4 = REGISTER.register("trochodendroides_tree_4", () -> new Trochodendroides4(PFTreeConfig.CODEC.stable()));

    public static final RegistryObject<Woodworthia1> WOODWORTHIA_TREE_1 = REGISTER.register("woodworthia_tree_1", () -> new Woodworthia1(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Woodworthia2> WOODWORTHIA_TREE_2 = REGISTER.register("woodworthia_tree_2", () -> new Woodworthia2(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Woodworthia3> WOODWORTHIA_TREE_3 = REGISTER.register("woodworthia_tree_3", () -> new Woodworthia3(PFTreeConfig.CODEC.stable()));
    public static final RegistryObject<Woodworthia4> WOODWORTHIA_TREE_4 = REGISTER.register("woodworthia_tree_4", () -> new Woodworthia4(PFTreeConfig.CODEC.stable()));

    public static final RegistryObject<ZamitesBushFeature> ZAMITES_BUSH = REGISTER.register("zamites_bush", () -> new ZamitesBushFeature(JohnstoniaConfig.CODEC.stable()));
    
    public static final RegistryObject<PtilophyllumFeature> PTILOPHYLLUM_TREE = REGISTER.register("ptilophyllum_tree", () -> new PtilophyllumFeature(NoneFeatureConfiguration.CODEC.stable()));
    public static final RegistryObject<PetrifiedTreeFeature> PETRIFIED_TREE = REGISTER.register("petrified_tree", () -> new PetrifiedTreeFeature(JohnstoniaConfig.CODEC.stable()));
    public static final RegistryObject<JohnstoniaFeature> JOHNSTONIA = REGISTER.register("johnstonia", () -> new JohnstoniaFeature(JohnstoniaConfig.CODEC.stable()));
    public static final RegistryObject<DicroidiumFeature> DICROIDIUM = REGISTER.register("dicroidium", () -> new DicroidiumFeature(JohnstoniaConfig.CODEC.stable()));
    public static final RegistryObject<NeocalamitesFeature> NEOCALAMITES = REGISTER.register("neocalamites", () -> new NeocalamitesFeature(JohnstoniaConfig.CODEC.stable()));
    public static final RegistryObject<LandSphereReplaceFeature> LAND_DISK = REGISTER.register("land_disk", () -> new LandSphereReplaceFeature(DiskConfiguration.CODEC.stable()));
    public static final RegistryObject<WaterloggedHorsetailsFeature> WATERLOGGED_HORSETAILS = REGISTER.register("waterlogged_horsetails", () -> new WaterloggedHorsetailsFeature(JohnstoniaConfig.CODEC.stable()));
    public static final RegistryObject<DjadochtaHorsetailsFeature> SANDY_HORSETAILS = REGISTER.register("sandy_horsetails", () -> new DjadochtaHorsetailsFeature(JohnstoniaConfig.CODEC.stable()));
    public static final RegistryObject<CrassostreaOystersFeature> CRASSOSTREA_OYSTERS = REGISTER.register("crassostrea_oyster", () -> new CrassostreaOystersFeature(CrassostreaOystersConfig.CODEC.stable()));
    public static final RegistryObject<AlgaeFeature> ALGAE = REGISTER.register("algae", () -> new AlgaeFeature(CrassostreaOystersConfig.CODEC.stable()));
    public static final RegistryObject<NoisySphereFeature> NOISY_SPHERE = REGISTER.register("noisy_sphere", () -> new NoisySphereFeature(NoisySphereConfig.CODEC.stable()));
    public static final RegistryObject<BigBlockBlobFeature> BIG_BLOCK_BLOB = REGISTER.register("big_block_blob", () -> new BigBlockBlobFeature(BlockStateConfiguration.CODEC.stable()));
    
}
