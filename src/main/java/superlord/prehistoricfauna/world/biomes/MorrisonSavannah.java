package superlord.prehistoricfauna.world.biomes;

import com.google.common.collect.ImmutableList;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.world.PrehistoricFeature;
import superlord.prehistoricfauna.world.PrehistoricPlacement;
import superlord.prehistoricfauna.world.feature.AraucariaTree;
import superlord.prehistoricfauna.world.feature.ProtopiceoxylonTree;
import superlord.prehistoricfauna.world.feature.ZamitesBush;

public class MorrisonSavannah extends Biome {

	public MorrisonSavannah(Builder biomeBuilder) {
		super(biomeBuilder);
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.CONIOPTERIS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(220))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.OSMUNDACAULIS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(15))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.LARGE_HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.DEAD_OSMUNDACAULIS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.SHORT_OSMUNDACAULIS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.NORMAL_TREE.withConfiguration(AraucariaTree.ARAUCARIA_YOUNG_TREE_CONFIG).withChance(1F)), Feature.NORMAL_TREE.withConfiguration(ProtopiceoxylonTree.PROTOPICEOXYLON_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));;
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PrehistoricFeature.PTILOPHYLLUM_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(PrehistoricPlacement.PTILOPHYLLUM_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).withChance(1F)), Feature.NORMAL_TREE.withConfiguration(ZamitesBush.ZAMITES_BUSH_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(PrehistoricFeature.ZAMITES_BUSH.withConfiguration(ZamitesBush.ZAMITES_BUSH_CONFIG).withChance(1F)), Feature.NORMAL_TREE.withConfiguration(ProtopiceoxylonTree.PROTOPICEOXYLON_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.NORMAL_TREE.withConfiguration(ProtopiceoxylonTree.PROTOPICEOXYLON_TREE_CONFIG).withChance(1F)), Feature.NORMAL_TREE.withConfiguration(AraucariaTree.ARAUCARIA_YOUNG_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));;
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.STEGOSAURUS_ENTITY, PrehistoricFaunaConfig.stegosaurusSpawnWeight, 1, 2));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.DRYOSAURUS_ENTITY, PrehistoricFaunaConfig.dryosaurusSpawnWeight, 2, 4));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.CERATOSAURUS_ENTITY, PrehistoricFaunaConfig.ceratosaurusSpawnWeight, 1, 1));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ALLOSAURUS_ENTITY, PrehistoricFaunaConfig.allosaurusSpawnWeight, 1, 1));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.HESPERORNITHOIDES_ENTITY, PrehistoricFaunaConfig.hesperornithoidesSpawnWeight, 1, 1));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.EILENODON_ENTITY, PrehistoricFaunaConfig.eilenodonSpawnWeight, 1, 2));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.CAMARASAURUS_ENTITY, PrehistoricFaunaConfig.camarasaurusSpawnWeight, 2, 4));
	    DefaultBiomeFeatures.addStoneVariants(this);
	    DefaultBiomeFeatures.addOres(this);
	    DefaultBiomeFeatures.addCarvers(this);
	    PrehistoricFeature.addSedimentDisks(this);
	}

}
