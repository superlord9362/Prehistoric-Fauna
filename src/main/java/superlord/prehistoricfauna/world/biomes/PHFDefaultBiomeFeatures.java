package superlord.prehistoricfauna.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import superlord.prehistoricfauna.core.world.PHFConfiguredFeatures;

public class PHFDefaultBiomeFeatures {

    public static void addAraucariaTrees(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PHFConfiguredFeatures.ARAUCARIA_VEGETATION);
    }
}
