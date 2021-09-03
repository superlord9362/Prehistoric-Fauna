package superlord.prehistoricfauna.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFConfiguredStructures {
	
	public static StructureFeature<?, ?> CONFIGURED_TIME_TEMPLE = PFStructures.TIME_TEMPLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_GEOLOGIST_CAMP = PFStructures.GEOLOGIST_CAMP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_PORTAL_CHAMBER = PFStructures.PORTAL_CHAMBER.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_HELL_CREEK_HUT = PFStructures.HELL_CREEK_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_MORRISON_HUT = PFStructures.MORRISON_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_ISCHIGUALASTO_HUT = PFStructures.ISCHIGUALASTO_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);

	public static void registerConfiguredStructures() {
		Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
		Registry.register(registry, new ResourceLocation(PrehistoricFauna.MOD_ID, "configured_time_temple"), CONFIGURED_TIME_TEMPLE);
		Registry.register(registry, new ResourceLocation(PrehistoricFauna.MOD_ID, "configured_geologist_camp"), CONFIGURED_GEOLOGIST_CAMP);
		Registry.register(registry, new ResourceLocation(PrehistoricFauna.MOD_ID, "configured_portal_chamber"), CONFIGURED_PORTAL_CHAMBER);
		Registry.register(registry, new ResourceLocation(PrehistoricFauna.MOD_ID, "configured_hell_creek_hut"), CONFIGURED_HELL_CREEK_HUT);
		Registry.register(registry, new ResourceLocation(PrehistoricFauna.MOD_ID, "configured_morrison_hut"), CONFIGURED_MORRISON_HUT);
		Registry.register(registry, new ResourceLocation(PrehistoricFauna.MOD_ID, "configured_ischigualasto_hut"), CONFIGURED_ISCHIGUALASTO_HUT);

		FlatGenerationSettings.STRUCTURES.put(PFStructures.TIME_TEMPLE, CONFIGURED_TIME_TEMPLE);
		FlatGenerationSettings.STRUCTURES.put(PFStructures.GEOLOGIST_CAMP, CONFIGURED_GEOLOGIST_CAMP);
		FlatGenerationSettings.STRUCTURES.put(PFStructures.PORTAL_CHAMBER, CONFIGURED_PORTAL_CHAMBER);
		FlatGenerationSettings.STRUCTURES.put(PFStructures.HELL_CREEK_HUT, CONFIGURED_HELL_CREEK_HUT);
		FlatGenerationSettings.STRUCTURES.put(PFStructures.MORRISON_HUT, CONFIGURED_MORRISON_HUT);
		FlatGenerationSettings.STRUCTURES.put(PFStructures.ISCHIGUALASTO_HUT, CONFIGURED_ISCHIGUALASTO_HUT);
	}	

}
