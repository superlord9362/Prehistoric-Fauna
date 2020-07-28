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
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.THESCELOSAURUS_ENTITY, 12, 2, 4));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.TRICERATOPS_ENTITY, 16, 2, 3));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.ANKYLOSAURUS_ENTITY, 7, 1, 2));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.TYRANNOSAURUS_ENTITY, 10, 1, 1));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.BASILEMYS_ENTITY, 5, 1, 2));
	    addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ModEntityTypes.DAKOTARAPTOR_ENTITY, 10, 1, 3));
	    DefaultBiomeFeatures.addTaigaRocks(this);
	    DefaultBiomeFeatures.addStoneVariants(this);
	    DefaultBiomeFeatures.addOres(this);
	    DefaultBiomeFeatures.addCarvers(this);
	    PrehistoricFeature.addSedimentDisks(this);
	}

}
