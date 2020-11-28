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
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.world.PrehistoricFeature;
import superlord.prehistoricfauna.world.feature.triassic.HeidiphyllumTree;
import superlord.prehistoricfauna.world.feature.triassic.ProtojuniperTree;
import superlord.prehistoricfauna.world.placement.AraucariaSmallConfig;
import superlord.prehistoricfauna.world.placement.DicroidiumConfig;
import superlord.prehistoricfauna.world.placement.JohnstoniaConfig;

public class TriassicBiomes {

    public static Biome ischigualastoForest() {
        Biome biome = new BiomeExtender(new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(0.1F).temperature(0.75F).depth(0.1F).downfall(0.9F).category(Biome.Category.FOREST).waterColor(4159204).waterFogColor(329011).surfaceBuilder(PrehistoricFeature.ISCHIGUALASTO, PrehistoricFeature.COARSEDIRT_COARSEDIRT_CLAY_CONFIG).parent(null));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.PROTOJUNIPER_TREE.withConfiguration(ProtojuniperTree.PROTOJUNIPER_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.ARAUCARIA_SMALL_TREE_FEATURE.withConfiguration(new AraucariaSmallConfig(2)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(HeidiphyllumTree.HEIDIPHYLLUM_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.MICHELILLOA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(100))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.JOHNSTONIA_FEATURE.withConfiguration(new JohnstoniaConfig(3)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.DICROIDIUM_FEATURE.withConfiguration(new DicroidiumConfig(6)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.CLADOPHLEBIS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(220))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.SCYTOPHYLLUM_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(30))));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.EXAERETODON_ENTITY, PrehistoricFaunaConfig.exaeretodonSpawnWeight, 1, 3));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.CHROMOGISAURUS_ENTITY, PrehistoricFaunaConfig.chromogisaurusSpawnWeight, 1, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.HERRERASAURUS_ENTITY, PrehistoricFaunaConfig.herrerasaurusSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.HYPERODAPEDON_ENTITY, PrehistoricFaunaConfig.hyperodapedonSpawnWeight, 2, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.SILLOSUCHUS_ENTITY, PrehistoricFaunaConfig.sillosuchusSpawnWeight, 1, 3));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.SAUROSUCHUS_ENTITY, PrehistoricFaunaConfig.saurosuchusSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ISCHIGUALASTIA_ENTITY, PrehistoricFaunaConfig.ischigualastiaSpawnWeight, 2, 5));
        DefaultBiomeFeatures.addStoneVariants(biome);
        DefaultBiomeFeatures.addOres(biome);
        DefaultBiomeFeatures.addCarvers(biome);
        PrehistoricFeature.addSedimentDisks(biome);
        return biome;
    }
}
