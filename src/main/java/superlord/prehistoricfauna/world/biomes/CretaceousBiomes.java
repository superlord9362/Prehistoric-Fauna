package superlord.prehistoricfauna.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.core.world.PHFSurfaceBuilders;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.world.PrehistoricFeature;

import static superlord.prehistoricfauna.core.world.PHFConfiguredFeatures.*;

public class CretaceousBiomes {

    public static Biome hellCreek() {
        Biome biome = new BiomeExtender(new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(0.2F).temperature(0.7f).depth(0.1f).downfall(0.8F).category(Biome.Category.TAIGA).waterColor(4159204).waterFogColor(329011).surfaceBuilder(PHFSurfaceBuilders.HELL_CREEK, new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.CLAY.getDefaultState())).parent(null));
//        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FANCY_TREE.withConfiguration(LiriodendritesTree.LIRIODENDRITES_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
//        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.METASEQUOIA_TREE.withConfiguration(MetasequoiaTree.METASEQUOIA_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MOSS);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLUBMOSS);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MARCHANTIA);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDA);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDA_DOUBLE);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CRASSOSTREA_OYSTERS);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DIDELPHODON_BURROW);
        PHFDefaultBiomeFeatures.addAraucariaTrees(biome);
        DefaultBiomeFeatures.addTaigaRocks(biome);
        DefaultBiomeFeatures.addStoneVariants(biome);
        DefaultBiomeFeatures.addOres(biome);
        DefaultBiomeFeatures.addCarvers(biome);
        PrehistoricFeature.addSedimentDisks(biome);

        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.THESCELOSAURUS_ENTITY, PrehistoricFaunaConfig.thescelosaurusSpawnWeight, 2, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.TRICERATOPS_ENTITY, PrehistoricFaunaConfig.triceratopsSpawnWeight, 2, 3));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ANKYLOSAURUS_ENTITY, PrehistoricFaunaConfig.ankylosaurusSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.TYRANNOSAURUS_ENTITY, PrehistoricFaunaConfig.tyrannosaurusSpawnWeight, 1, 1));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.BASILEMYS_ENTITY, PrehistoricFaunaConfig.basilemysSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.DAKOTARAPTOR_ENTITY, PrehistoricFaunaConfig.dakotaraptorSpawnWeight, 1, 3));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.DIDELPHODON_ENTITY, PrehistoricFaunaConfig.didelphodonSpawnWeight, 1, 3));
        return biome;
    }
}
