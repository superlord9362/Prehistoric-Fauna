package superlord.prehistoricfauna.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.world.PrehistoricFeature;
import superlord.prehistoricfauna.world.feature.AraucariaTree;
import superlord.prehistoricfauna.world.feature.MetasequoiaTree;

public class HellCreekBiome extends Biome {

	public HellCreekBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.METASEQUOIA_TREE.withConfiguration(MetasequoiaTree.METASEQUOIA_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PrehistoricFeature.ARAUCARIA_TREE.withConfiguration(AraucariaTree.ARAUCARIA_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.MOSS_PILE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(80))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.CLUBMOSS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.MARCHANTIA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(40))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.OSMUNDA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(40))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(60))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.LARGE_OSMUNDA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(20))));
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PrehistoricFeature.LARGE_HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(20))));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ENTITY_THESCELOSAURUS, 12, 2, 4));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ENTITY_TRICERATOPS, 16, 2, 3));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ENTITY_ANKYLOSAURUS, 7, 1, 2));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ENTITY_TYRANNOSAURUS, 14, 1, 1));
	    DefaultBiomeFeatures.addTaigaRocks(this);
	}

}
