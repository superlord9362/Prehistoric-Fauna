package superlord.prehistoricfauna.common.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBiomeModifiers;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFPlacedFeatures;

public class PFBiomeModifier implements BiomeModifier {

	public static final Codec<PFBiomeModifier> CODEC = RecordCodecBuilder.create((p_48644_) -> {
		return p_48644_.group(RegistryOps.retrieveRegistryLookup(Registries.PLACED_FEATURE).forGetter((placedFeature) -> {
			return null;
		})).apply(p_48644_, p_48644_.stable(PFBiomeModifier::new));
	});	

	public final Holder<PlacedFeature> largeMetasequoiaTrees, rareSmallMetasequoiaTrees, smallAraucariaTrees, rareEphedra, smallGinkgoTrees, rareLargeGinkgoTrees, smallMixedGingkoTrees, rareMixedLargeGinkgoTrees, rareSmallYellowGinkgoTrees, taxusTrees, clubmoss, rareNelumbo, azolla, marchantia, algae, waterloggedHorsetails, horsetails, rareTaxodiumTrees, taxodiumKnees, osmunda, tallOsmunda, crassostreaOysters, rareLargeAraucariaTrees;

	public PFBiomeModifier(HolderGetter<PlacedFeature> feature) {
		this(feature.getOrThrow(PFPlacedFeatures.LARGE_METASEQUOIA_TREES), feature.getOrThrow(PFPlacedFeatures.SPARSE_SMALL_METASEQUOIA_TREES), feature.getOrThrow(PFPlacedFeatures.SMALL_ARAUCARIA_TREES), feature.getOrThrow(PFPlacedFeatures.RARE_EPHEDRA), feature.getOrThrow(PFPlacedFeatures.SMALL_GINKGO_TREES), feature.getOrThrow(PFPlacedFeatures.RARE_LARGE_GINKGO_TREES), feature.getOrThrow(PFPlacedFeatures.SMALL_MIXED_GINKGO_TREES), feature.getOrThrow(PFPlacedFeatures.RARE_MIXED_LARGE_GINKGO_TREES), feature.getOrThrow(PFPlacedFeatures.SPARSE_SMALL_YELLOW_GINKGO_TREES), feature.getOrThrow(PFPlacedFeatures.TAXUS_TREES), feature.getOrThrow(PFPlacedFeatures.CLUBMOSS), feature.getOrThrow(PFPlacedFeatures.RARE_NELUMBO), feature.getOrThrow(PFPlacedFeatures.AZOLLA), feature.getOrThrow(PFPlacedFeatures.MARCHANTIA), feature.getOrThrow(PFPlacedFeatures.ALGAE), feature.getOrThrow(PFPlacedFeatures.WATERLOGGED_HORSETAILS), feature.getOrThrow(PFPlacedFeatures.HORSETAILS), feature.getOrThrow(PFPlacedFeatures.RARE_TAXODIUM_TREES), feature.getOrThrow(PFPlacedFeatures.TAXODIUM_KNEES), feature.getOrThrow(PFPlacedFeatures.OSMUNDA), feature.getOrThrow(PFPlacedFeatures.TALL_OSMUNDA), feature.getOrThrow(PFPlacedFeatures.CRASSOSTREA_OYSTERS), feature.getOrThrow(PFPlacedFeatures.RARE_LARGE_ARAUCARIA_TREES));
	}

	public PFBiomeModifier(Holder<PlacedFeature> largeMetasequoiaTrees, Holder<PlacedFeature> rareSmallMetasequoiaTrees, Holder<PlacedFeature> smallAraucariaTrees, Holder<PlacedFeature> rareEphedra, Holder<PlacedFeature> smallGinkgoTrees, Holder<PlacedFeature> rareLargeGinkgoTrees, Holder<PlacedFeature> smallMixedGinkgoTrees, Holder<PlacedFeature> rareMixedLargeGinkgoTrees, Holder<PlacedFeature> rareSmallYellowGinkgoTrees, Holder<PlacedFeature> taxusTrees, Holder<PlacedFeature> clubmoss, Holder<PlacedFeature> rareNelumbo, Holder<PlacedFeature> azolla, Holder<PlacedFeature> marchantia, Holder<PlacedFeature> algae, Holder<PlacedFeature> waterloggedHorsetails, Holder<PlacedFeature> horsetails, Holder<PlacedFeature> rareTaxodiumTrees, Holder<PlacedFeature> taxodiumKnees, Holder<PlacedFeature> osmunda, Holder<PlacedFeature> tallOsmunda, Holder<PlacedFeature> crassostreaOysters, Holder<PlacedFeature> rareLargeAraucariaTrees) {
		this.largeMetasequoiaTrees = largeMetasequoiaTrees;
		this.rareSmallMetasequoiaTrees = rareSmallMetasequoiaTrees;
		this.smallAraucariaTrees = smallAraucariaTrees;
		this.rareEphedra = rareEphedra;
		this.smallGinkgoTrees = smallGinkgoTrees;
		this.rareLargeGinkgoTrees = rareLargeGinkgoTrees;
		this.smallMixedGingkoTrees = smallMixedGinkgoTrees;
		this.rareMixedLargeGinkgoTrees = rareMixedLargeGinkgoTrees;
		this.rareSmallYellowGinkgoTrees = rareSmallYellowGinkgoTrees;
		this.taxusTrees = taxusTrees;
		this.clubmoss = clubmoss;
		this.rareNelumbo = rareNelumbo;
		this.azolla = azolla;
		this.marchantia = marchantia;
		this.waterloggedHorsetails = waterloggedHorsetails;
		this.horsetails = horsetails;
		this.algae = algae;
		this.rareTaxodiumTrees = rareTaxodiumTrees;
		this.taxodiumKnees = taxodiumKnees;
		this.osmunda = osmunda;
		this.tallOsmunda = tallOsmunda;
		this.crassostreaOysters = crassostreaOysters;
		this.rareLargeAraucariaTrees = rareLargeAraucariaTrees;
	}

	@Override
	public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
		if (phase == Phase.ADD) {
			if (biome.is(BiomeTags.IS_OVERWORLD)) {
				if (PrehistoricFaunaConfig.extantWorldGeneration) {
					if (biome.is(Biomes.OLD_GROWTH_SPRUCE_TAIGA)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, largeMetasequoiaTrees);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareSmallMetasequoiaTrees);
					}
					if (biome.is(Biomes.SAVANNA_PLATEAU) ) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, smallAraucariaTrees);
					}
					if (biome.is(Biomes.WINDSWEPT_SAVANNA)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, smallAraucariaTrees);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareLargeAraucariaTrees);
					}
					if (biome.is(Biomes.DESERT)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareEphedra);
					}
					if (biome.is(BiomeTags.IS_BADLANDS)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareEphedra);
					}
					if (biome.is(Biomes.STONY_PEAKS)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, smallGinkgoTrees);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareLargeGinkgoTrees);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, clubmoss);
					}
					if (biome.is(Biomes.MEADOW)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, smallMixedGingkoTrees);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareMixedLargeGinkgoTrees);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, clubmoss);
					}
					if (biome.is(Biomes.WINDSWEPT_FOREST)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareSmallYellowGinkgoTrees);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, taxusTrees);
					}
					if (biome.is(Biomes.SUNFLOWER_PLAINS)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareSmallYellowGinkgoTrees);
					}
					if (biome.is(Biomes.CHERRY_GROVE)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareSmallYellowGinkgoTrees);
					}
					if (biome.is(Biomes.TAIGA)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, taxusTrees);
					}
					if (biome.is(Biomes.GROVE)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, taxusTrees);
					}
					if (biome.is(Biomes.WINDSWEPT_HILLS)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, clubmoss);
					}
					if (biome.is(Biomes.WINDSWEPT_GRAVELLY_HILLS)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, clubmoss);
					}
					if (biome.is(Biomes.SWAMP)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, clubmoss);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareNelumbo);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, azolla);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, marchantia);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, algae);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, waterloggedHorsetails);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, horsetails);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareTaxodiumTrees);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, taxodiumKnees);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, osmunda);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, tallOsmunda);
					}
					if (biome.is(Biomes.MANGROVE_SWAMP)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareNelumbo);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, marchantia);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, algae);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, crassostreaOysters);
					}
					if (biome.is(Biomes.RIVER)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, rareNelumbo);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, waterloggedHorsetails);
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, horsetails);
					}
					if (biome.is(Biomes.PLAINS)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, azolla);
					}
					if (biome.is(Biomes.STONY_SHORE)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, crassostreaOysters);
					}
					if (biome.is(Biomes.JUNGLE) || biome.is(Biomes.BAMBOO_JUNGLE) || biome.is(Biomes.SPARSE_JUNGLE)) {
						builder.getGenerationSettings().addFeature(Decoration.VEGETAL_DECORATION, marchantia);
					}
				}
				if (PrehistoricFaunaConfig.extantEntitySpawns) {
					if (biome.is(Biomes.RIVER)) {
						builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), 12, 1, 2));
						builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), 15, 1, 2));
					}
					if (biome.is(Biomes.SWAMP)) {
						builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), 12, 1, 2));
					}
					if (biome.is(BiomeTags.IS_FOREST)) {
						builder.getMobSpawnSettings().addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), 7, 1, 2));
					}
				}
			}
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return PFBiomeModifiers.PF_BIOME_MODIFIER_TYPE.get();
	}

}
