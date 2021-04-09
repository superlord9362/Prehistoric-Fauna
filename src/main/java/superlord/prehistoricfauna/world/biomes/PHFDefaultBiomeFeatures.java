package superlord.prehistoricfauna.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import superlord.prehistoricfauna.core.world.PHFConfiguredFeatures;

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
}
