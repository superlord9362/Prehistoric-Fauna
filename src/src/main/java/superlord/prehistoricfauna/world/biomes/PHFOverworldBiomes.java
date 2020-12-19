package superlord.prehistoricfauna.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import superlord.prehistoricfauna.core.world.PHFFeatures;
import superlord.prehistoricfauna.init.BlockInit;

import static superlord.prehistoricfauna.core.world.PHFConfiguredFeatures.PETRIFIED_TREE;

public class PHFOverworldBiomes {

    public static Biome petrifiedForest() {
        Biome biome = new BiomeExtender(new Biome.Builder().precipitation(Biome.RainType.NONE).scale(0.07F).temperature(0.75F).depth(0.1F).downfall(0.4F).category(Biome.Category.FOREST).waterColor(4159204).waterFogColor(329011).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), BlockInit.TRIASSIC_SANDSTONE.getDefaultState(), Blocks.STONE.getDefaultState())).parent(null));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PETRIFIED_TREE);
        DefaultBiomeFeatures.addCarvers(biome);
        biome.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        biome.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        biome.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));DefaultBiomeFeatures.addStructures(biome);
        DefaultBiomeFeatures.addLakes(biome);
        DefaultBiomeFeatures.addMonsterRooms(biome);
        DefaultBiomeFeatures.addStoneVariants(biome);
        DefaultBiomeFeatures.addOres(biome);
        DefaultBiomeFeatures.addSedimentDisks(biome);
        DefaultBiomeFeatures.addSprings(biome);
        DefaultBiomeFeatures.addSparseGrass(biome);
        DefaultBiomeFeatures.addDeadBushes(biome);
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
        biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.WOLF, 5, 4, 4));
        biome.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        return biome;
    }

    public static Biome dummy() {
        Biome biome = new BiomeExtender(new Biome.Builder().precipitation(Biome.RainType.NONE).scale(0.07F).temperature(0.75F).depth(0.1F).downfall(0.4F).category(Biome.Category.FOREST).waterColor(4159204).waterFogColor(329011).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), BlockInit.TRIASSIC_SANDSTONE.getDefaultState(), Blocks.STONE.getDefaultState())).parent(null));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PHFFeatures.DUMMY.withConfiguration(new NoFeatureConfig()).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10000, 0.2F, 1))));
        return biome;
    }
}
