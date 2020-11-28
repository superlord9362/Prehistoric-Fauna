package superlord.prehistoricfauna.world.gen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.core.world.PHFBiomes;
import superlord.prehistoricfauna.init.BlockInit;

public class PrehistoricOreGen {

	@SuppressWarnings("rawtypes")
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome != PHFBiomes.HELL_CREEK && biome != PHFBiomes.ISCHIGUALASTO_FOREST && biome != PHFBiomes.MORRISON_SAVANNAH) {
				ConfiguredPlacement jurassicSiltstoneConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 40, 0, 55));
				ConfiguredPlacement jurassicFossilConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 40, 0, 55));
				ConfiguredPlacement triassicSandstoneConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 30, 0, 45));
				ConfiguredPlacement triassicFossilConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 30, 0, 45));
				ConfiguredPlacement cretaceousChalkConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 50, 0, 65));
				ConfiguredPlacement cretaceousFossilConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 50, 0, 65));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.JURASSIC_SILTSTONE.getDefaultState(), 33)).withPlacement(jurassicSiltstoneConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.JURASSIC_SILTSTONE_FOSSIL.getDefaultState(), 4)).withPlacement(jurassicFossilConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.TRIASSIC_SANDSTONE.getDefaultState(), 33)).withPlacement(triassicSandstoneConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.TRIASSIC_SANDSTONE_FOSSIL.getDefaultState(), 4)).withPlacement(triassicFossilConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.CRETACEOUS_CHALK.getDefaultState(), 33)).withPlacement(cretaceousChalkConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.CRETACEOUS_CHALK_FOSSIL.getDefaultState(), 4)).withPlacement(cretaceousFossilConfig));
			} else if (biome == PHFBiomes.HELL_CREEK) {
				ConfiguredPlacement jurassicSiltstoneConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 40, 0, 55));
				ConfiguredPlacement jurassicFossilConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 40, 0, 55));
				ConfiguredPlacement triassicSandstoneConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 30, 0, 45));
				ConfiguredPlacement triassicFossilConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 30, 0, 45));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.JURASSIC_SILTSTONE.getDefaultState(), 33)).withPlacement(jurassicSiltstoneConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.JURASSIC_SILTSTONE_FOSSIL.getDefaultState(), 4)).withPlacement(jurassicFossilConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.TRIASSIC_SANDSTONE.getDefaultState(), 33)).withPlacement(triassicSandstoneConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.TRIASSIC_SANDSTONE_FOSSIL.getDefaultState(), 4)).withPlacement(triassicFossilConfig));
			} else if (biome == PHFBiomes.MORRISON_SAVANNAH) {
				ConfiguredPlacement triassicSandstoneConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 30, 0, 45));
				ConfiguredPlacement triassicFossilConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 30, 0, 45));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.TRIASSIC_SANDSTONE.getDefaultState(), 33)).withPlacement(triassicSandstoneConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.TRIASSIC_SANDSTONE_FOSSIL.getDefaultState(), 4)).withPlacement(triassicFossilConfig));
			}
		}
	}

}
