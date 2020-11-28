package superlord.prehistoricfauna.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.world.PrehistoricFeature;
import superlord.prehistoricfauna.world.feature.CrassostreaOystersConfig;
import superlord.prehistoricfauna.world.feature.LiriodendritesTree;
import superlord.prehistoricfauna.world.feature.config.PHFTreeConfig;
import superlord.prehistoricfauna.world.feature.cretaceous.MetasequoiaTree;
import superlord.prehistoricfauna.world.placement.AraucariaConfig;
import superlord.prehistoricfauna.world.placement.DidelphodonBurrowConfig;

public class CretaceousBiomes {

    public static Biome hellCreek() {
        Biome biome = new BiomeExtender(new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(0.2F).temperature(0.7f).depth(0.1f).downfall(0.8F).category(Biome.Category.TAIGA).waterColor(4159204).waterFogColor(329011).surfaceBuilder(PrehistoricFeature.HELL_CREEK, PrehistoricFeature.COARSEDIRT_COARSEDIRT_CLAY_CONFIG).parent(null));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FANCY_TREE.withConfiguration(LiriodendritesTree.LIRIODENDRITES_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
//        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.METASEQUOIA_TREE.withConfiguration(MetasequoiaTree.METASEQUOIA_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.MOSS_PILE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(80))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.CLUBMOSS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.MARCHANTIA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(40))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.OSMUNDA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(40))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(60))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.LARGE_OSMUNDA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(20))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.LARGE_HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(20))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.CRASSOSTREA_OYSTERS_FEATURE.withConfiguration(new CrassostreaOystersConfig(24)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.DIDELPHODON_BURROW_FEATURE.withConfiguration(new DidelphodonBurrowConfig(3)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.ARAUCARIA_FEATURE.withConfiguration(new AraucariaConfig(5)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.ARAUCARIA_SMALL_TREE1.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(13).setMaxHeight(18).build()).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 5))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.ARAUCARIA_SMALL_TREE2.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(6).setMaxHeight(11).build()).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 5))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.ARAUCARIA_SMALL_TREE3.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(10).setMaxHeight(15).build()).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 5))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.ARAUCARIA_SMALL_TREE4.withConfiguration(new PHFTreeConfig.Builder().setTrunkBlock(BlockInit.ARAUCARIA_LOG.getDefaultState()).setLeavesBlock(BlockInit.ARAUCARIA_LEAVES).setMinHeight(14).setMaxHeight(19).build()).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 5))));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.THESCELOSAURUS_ENTITY, PrehistoricFaunaConfig.thescelosaurusSpawnWeight, 2, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.TRICERATOPS_ENTITY, PrehistoricFaunaConfig.triceratopsSpawnWeight, 2, 3));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ANKYLOSAURUS_ENTITY, PrehistoricFaunaConfig.ankylosaurusSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.TYRANNOSAURUS_ENTITY, PrehistoricFaunaConfig.tyrannosaurusSpawnWeight, 1, 1));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.BASILEMYS_ENTITY, PrehistoricFaunaConfig.basilemysSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.DAKOTARAPTOR_ENTITY, PrehistoricFaunaConfig.dakotaraptorSpawnWeight, 1, 3));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.DIDELPHODON_ENTITY, PrehistoricFaunaConfig.didelphodonSpawnWeight, 1, 3));
        DefaultBiomeFeatures.addTaigaRocks(biome);
        DefaultBiomeFeatures.addStoneVariants(biome);
        DefaultBiomeFeatures.addOres(biome);
        DefaultBiomeFeatures.addCarvers(biome);
        PrehistoricFeature.addSedimentDisks(biome);
        return biome;
    }
}
