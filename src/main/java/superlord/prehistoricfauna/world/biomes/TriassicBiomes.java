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

public class TriassicBiomes {

    public static Biome ischigualastoForest(float scale, float depth, boolean isClearing) {
        Biome biome = new BiomeExtender(new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(scale).temperature(0.75F).depth(depth).downfall(0.9F).category(Biome.Category.FOREST).waterColor(4159204).waterFogColor(329011).surfaceBuilder(PHFSurfaceBuilders.ISCHIGUALASTO, new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.CLAY.getDefaultState())).parent(null));
        if (isClearing) {
        	
        } else {
        	PHFDefaultBiomeFeatures.addIschigualastoVegetation(biome);
        }
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MICHELILLOA);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, JOHNSTONIA);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DICROIDIUM);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, CLADOPHLEBIS);
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, SCYTOPHYLLUM);
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
    
    public static Biome ischigualastoRiver(float scale, float depth) {
        Biome biome = new BiomeExtender(new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(scale).temperature(0.75f).depth(depth).downfall(0.9F).category(Biome.Category.FOREST).waterColor(4159204).waterFogColor(329011).surfaceBuilder(PHFSurfaceBuilders.ISCHIGUALASTO, new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), Blocks.CLAY.getDefaultState())).parent(null));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ALGAE);
        DefaultBiomeFeatures.addStoneVariants(biome);
        DefaultBiomeFeatures.addOres(biome);
        DefaultBiomeFeatures.addCarvers(biome);
        PrehistoricFeature.addSedimentDisks(biome);

        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.EXAERETODON_ENTITY, PrehistoricFaunaConfig.exaeretodonSpawnWeight, 1, 3));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.CHROMOGISAURUS_ENTITY, PrehistoricFaunaConfig.chromogisaurusSpawnWeight, 1, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.HERRERASAURUS_ENTITY, PrehistoricFaunaConfig.herrerasaurusSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.HYPERODAPEDON_ENTITY, PrehistoricFaunaConfig.hyperodapedonSpawnWeight, 2, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.SILLOSUCHUS_ENTITY, PrehistoricFaunaConfig.sillosuchusSpawnWeight, 1, 3));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.SAUROSUCHUS_ENTITY, PrehistoricFaunaConfig.saurosuchusSpawnWeight, 1, 2));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ISCHIGUALASTIA_ENTITY, PrehistoricFaunaConfig.ischigualastiaSpawnWeight, 2, 5));
        return biome;
    }
    
}
