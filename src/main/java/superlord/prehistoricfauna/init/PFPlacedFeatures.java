package superlord.prehistoricfauna.init;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFPlacedFeatures {

	public static final DeferredRegister<PlacedFeature> REGISTER = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, PrehistoricFauna.MOD_ID);

	public static final Holder<PlacedFeature> FOSSILIZED_CHALK = PlacementUtils.register("placed_fossilized_chalk", PFConfiguredFeatures.FOSSILIZED_CHALK.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
	public static final Holder<PlacedFeature> FOSSILIZED_SILTSTONE = PlacementUtils.register("placed_fossilized_siltstone", PFConfiguredFeatures.FOSSILIZED_SILTSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(39), VerticalAnchor.absolute(49))));
	public static final Holder<PlacedFeature> FOSSILIZED_SANDSTONE = PlacementUtils.register("placed_fossilized_sandstone", PFConfiguredFeatures.FOSSILIZED_SANDSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(29), VerticalAnchor.absolute(39))));

	public static final Holder<PlacedFeature> CRETACEOUS_FOSSILIZED_SILTSTONE = PlacementUtils.register("placed_cretaceous_fossilized_siltstone", PFConfiguredFeatures.FOSSILIZED_SILTSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
	public static final Holder<PlacedFeature> CRETACEOUS_FOSSILIZED_SANDSTONE = PlacementUtils.register("placed_cretaceous_fossilized_sandstone", PFConfiguredFeatures.FOSSILIZED_SANDSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(39), VerticalAnchor.absolute(49))));

	public static final Holder<PlacedFeature> JURASSIC_FOSSILIZED_SANDSTONE = PlacementUtils.register("placed_jurassic_fossilized_sandstone", PFConfiguredFeatures.FOSSILIZED_SANDSTONE.getHolder().orElseThrow(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(59))));
	
	public static final RegistryObject<PlacedFeature> MARCHANTIA = REGISTER.register("placed_marchantia", () -> new PlacedFeature(PFConfiguredFeatures.MARCHANITA.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	public static final RegistryObject<PlacedFeature> PLACED_PETRIFIED_TREE = REGISTER.register("placed_petrified_tree", () -> new PlacedFeature(PFConfiguredFeatures.PETRIFIED_TREE.getHolder().orElseThrow(), List.of(PlacementUtils.countExtra(1, 0.05F, 0), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

}
