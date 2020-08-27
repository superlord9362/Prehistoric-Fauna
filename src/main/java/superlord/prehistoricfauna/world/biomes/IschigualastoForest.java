package superlord.prehistoricfauna.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import superlord.prehistoricfauna.world.PrehistoricFeature;
import superlord.prehistoricfauna.world.feature.AraucariaTree;
import superlord.prehistoricfauna.world.feature.ProtojuniperTree;

public class IschigualastoForest extends Biome {
	
	public IschigualastoForest(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.PROTOJUNIPER_TREE.withConfiguration(ProtojuniperTree.PROTOJUNIPER_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(AraucariaTree.ARAUCARIA_YOUNG_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.MICHELILLOA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.JOHNSTONIA_CONFIG.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.DICROIDIUN_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.CLADOPHLEBIS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(60))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.SCYTOPHYLLUM_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(20))));
		DefaultBiomeFeatures.addStoneVariants(this);
	    DefaultBiomeFeatures.addOres(this);
	    DefaultBiomeFeatures.addCarvers(this);
	    PrehistoricFeature.addSedimentDisks(this);
	}

}
