package superlord.prehistoricfauna.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFBiomeModifiers;
import superlord.prehistoricfauna.init.PFBiomes;
import superlord.prehistoricfauna.init.PFConfiguredFeatures;
import superlord.prehistoricfauna.init.PFDimensions;
import superlord.prehistoricfauna.init.PFPlacedFeatures;
import superlord.prehistoricfauna.init.PFStructures;

public class PFFeatureAndBiomeGenerator extends DatapackBuiltinEntriesProvider {

	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_FEATURE, ctx -> PFConfiguredFeatures.bootstrap(ctx))
			.add(Registries.PLACED_FEATURE, PFPlacedFeatures::bootstrap)
			.add(Registries.BIOME, PFBiomes::bootstrap)
			.add(Registries.DIMENSION_TYPE, ctx -> PFDimensions.bootstrapType(ctx))
			.add(Registries.NOISE_SETTINGS, ctx -> PFDimensions.bootstrapNoise(ctx))
			.add(Registries.LEVEL_STEM, ctx -> PFDimensions.bootstrapStem(ctx))
			.add(ForgeRegistries.Keys.BIOME_MODIFIERS, PFBiomeModifiers::bootstrap)
			.add(Registries.STRUCTURE, PFStructures::bootstrap)
			.add(Registries.STRUCTURE_SET, ctx -> PFStructures.bootstrapStructureSet(ctx));
	
	public PFFeatureAndBiomeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, BUILDER, Set.of(PrehistoricFauna.MOD_ID));
	}
	
}
