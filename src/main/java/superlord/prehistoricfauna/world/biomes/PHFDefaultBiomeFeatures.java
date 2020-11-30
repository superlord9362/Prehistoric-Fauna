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
}
