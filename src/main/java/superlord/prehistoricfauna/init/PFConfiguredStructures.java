package superlord.prehistoricfauna.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFConfiguredStructures {
	
	public static StructureFeature<?, ?> CONFIGURED_TIME_TEMPLE = PFStructures.TIME_TEMPLE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	
	public static void registerConfiguredStructures() {
		Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
		Registry.register(registry, new ResourceLocation(PrehistoricFauna.MOD_ID, "configured_time_temple"), CONFIGURED_TIME_TEMPLE);
		
		FlatGenerationSettings.STRUCTURES.put(PFStructures.TIME_TEMPLE.get(), CONFIGURED_TIME_TEMPLE);
	}

}
