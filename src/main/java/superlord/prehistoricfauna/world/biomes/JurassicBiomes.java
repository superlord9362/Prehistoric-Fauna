package superlord.prehistoricfauna.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.core.world.PHFConfiguredFeatures;
import superlord.prehistoricfauna.core.world.PHFSurfaceBuilders;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.world.PrehistoricFeature;

import static superlord.prehistoricfauna.core.world.PHFConfiguredFeatures.*;

public class JurassicBiomes {

    public static Biome morrisonSavannah(float scale, float depth, boolean isHills) {
        Biome biome = new BiomeExtender(new Biome.Builder().precipitation(Biome.RainType.NONE).scale(scale).temperature(1.0F).depth(depth).downfall(0.2F).category(Biome.Category.SAVANNA).waterColor(4159204).waterFogColor(329011).surfaceBuilder(PHFSurfaceBuilders.MORRISON_SAVANNA, new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.CLAY.getDefaultState())).parent(null));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CONIOPTERIS);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDACAULIS);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HORSETAIL_DOUBLE);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DEAD_OSMUNDACAULIS);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, OSMUNDACAULIS_SHORT);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ZAMITES_BUSH);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PTILOPHYLLUM_TREE_BOOGALOO);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MORRISON_SAVANNA_VEGETATION);
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.STEGOSAURUS_ENTITY, PrehistoricFaunaConfig.stegosaurusSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.DRYOSAURUS_ENTITY, PrehistoricFaunaConfig.dryosaurusSpawnWeight, 2, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.CERATOSAURUS_ENTITY, PrehistoricFaunaConfig.ceratosaurusSpawnWeight, 1, 1));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ALLOSAURUS_ENTITY, PrehistoricFaunaConfig.allosaurusSpawnWeight, 1, 1));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.HESPERORNITHOIDES_ENTITY, PrehistoricFaunaConfig.hesperornithoidesSpawnWeight, 1, 1));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.EILENODON_ENTITY, PrehistoricFaunaConfig.eilenodonSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.CAMARASAURUS_ENTITY, PrehistoricFaunaConfig.camarasaurusSpawnWeight, 2, 4));
        DefaultBiomeFeatures.addStoneVariants(biome);
        DefaultBiomeFeatures.addOres(biome);
        DefaultBiomeFeatures.addCarvers(biome);
        PrehistoricFeature.addSedimentDisks(biome);
        PHFConfiguredFeatures.addWaterSprings(biome);
        if (isHills) {
            PHFConfiguredFeatures.addExtraIronOre(biome);
            PHFConfiguredFeatures.addLavaLakesandSprings(biome);
        }
        return biome;
    }
}
