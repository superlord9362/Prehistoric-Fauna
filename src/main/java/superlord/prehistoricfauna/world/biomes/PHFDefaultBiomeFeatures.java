package superlord.prehistoricfauna.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import superlord.prehistoricfauna.core.world.PHFConfiguredFeatures;
import superlord.prehistoricfauna.world.PrehistoricFeature;

public class PHFDefaultBiomeFeatures {

    public static void addHellCreekVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PHFConfiguredFeatures.HELL_CREEK_VEGETATION);
    }

    public static void addSparseHellCreekVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PHFConfiguredFeatures.SPARE_HELL_CREEK_VEGETATION);
    }
    
    public static void addLiriodendritesForestVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PHFConfiguredFeatures.LIRIODENDRITES_FOREST_VEGETATION);
    }
    
    public static void addIschigualastoVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PHFConfiguredFeatures.ISCHIGUALASTO_VEGETATION);
    }
    
    public static void addSparseIschigualastoVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PHFConfiguredFeatures.SPARSE_ISCHIGUALASTO_VEGETATION);
    }
    
    public static void addCretaceousOres(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, PHFConfiguredFeatures.FOSSILIZED_CRETACEOUS_CHALK);
    }
    
    public static void addMorrisonHut(Biome biome) {
        biome.addStructure(PrehistoricFeature.MORRISON_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, PrehistoricFeature.MORRISON_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
    }

    public static void addHellCreekHut(Biome biome) {
        biome.addStructure(PrehistoricFeature.HELL_CREEK_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, PrehistoricFeature.HELL_CREEK_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
    }

    public static void addIschigualastoCHut(Biome biome) {
        biome.addStructure(PrehistoricFeature.ISCHIGUALASTO_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, PrehistoricFeature.ISCHIGUALASTO_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
    }
}
