package superlord.prehistoricfauna.init;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.world.structure.GeologistCampStructure;
import superlord.prehistoricfauna.world.structure.HellCreekHutStructure;
import superlord.prehistoricfauna.world.structure.IschigualastoHutStructure;
import superlord.prehistoricfauna.world.structure.MorrisonHutStructure;
import superlord.prehistoricfauna.world.structure.PortalChamberStructure;
import superlord.prehistoricfauna.world.structure.TimeTempleStructure;

import java.util.ArrayList;
import java.util.List;

public class PFStructures {

	public static List<Structure<?>> structureFeatureList = new ArrayList<>();

	public static IStructurePieceType TIME_TEMPLE_PIECE_TYPE = TimeTempleStructure.Piece::new;
	public static IStructurePieceType GEOLOGIST_CAMP_PIECE_TYPE = GeologistCampStructure.Piece::new;
	public static IStructurePieceType PORTAL_CHAMBER_PIECE_TYPE = PortalChamberStructure.Piece::new;
	public static IStructurePieceType HELL_CREEK_HUT_PIECE_TYPE = HellCreekHutStructure.Piece::new;
	public static IStructurePieceType MORRISON_HUT_PIECE_TYPE = MorrisonHutStructure.Piece::new;
	public static IStructurePieceType ISCHIGUALASTO_HUT_PIECE_TYPE = IschigualastoHutStructure.Piece::new;
	public static Structure<NoFeatureConfig> TIME_TEMPLE;
	public static Structure<NoFeatureConfig> GEOLOGIST_CAMP;
	public static Structure<NoFeatureConfig> PORTAL_CHAMBER;
	public static Structure<NoFeatureConfig> HELL_CREEK_HUT;
	public static Structure<NoFeatureConfig> MORRISON_HUT;
	public static Structure<NoFeatureConfig> ISCHIGUALASTO_HUT;

	public static void setupStructures() {
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "time_temple"), TIME_TEMPLE_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "geologist_camp"), GEOLOGIST_CAMP_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "portal_chamber"), PORTAL_CHAMBER_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "hell_creek_hut"), HELL_CREEK_HUT_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "morrison_hut"), MORRISON_HUT_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualasto_hut"), ISCHIGUALASTO_HUT_PIECE_TYPE);
		TIME_TEMPLE = registerStructureFeature("prehistoricfauna:time_temple", new TimeTempleStructure(NoFeatureConfig.field_236558_a_));
		GEOLOGIST_CAMP = registerStructureFeature("prehistoricfauna:geologist_camp", new GeologistCampStructure(NoFeatureConfig.field_236558_a_));
		PORTAL_CHAMBER = registerStructureFeature("prehistoricfauna:portal_chamber", new PortalChamberStructure(NoFeatureConfig.field_236558_a_));
		HELL_CREEK_HUT = registerStructureFeature("prehistoricfauna:hell_creek_hut", new HellCreekHutStructure(NoFeatureConfig.field_236558_a_));
		MORRISON_HUT = registerStructureFeature("prehistoricfauna:morrison_hut", new MorrisonHutStructure(NoFeatureConfig.field_236558_a_));
		ISCHIGUALASTO_HUT = registerStructureFeature("prehistoricfauna:ischigualasto_hut", new IschigualastoHutStructure(NoFeatureConfig.field_236558_a_));
		setupMapSpacingAndLand(TIME_TEMPLE, new StructureSeparationSettings(PrehistoricFaunaConfig.timeTempleMaxDistance, PrehistoricFaunaConfig.timeTempleMinDistance, 8237163), true);
		setupMapSpacingAndLand(GEOLOGIST_CAMP, new StructureSeparationSettings(PrehistoricFaunaConfig.geologistCampMaxDistance, PrehistoricFaunaConfig.geologistCampMinDistance, 37126163), true);
		setupMapSpacingAndLand(PORTAL_CHAMBER, new StructureSeparationSettings(PrehistoricFaunaConfig.portalHubMaxDistance, PrehistoricFaunaConfig.portalHubMinDistance, 2837462), true);
		setupMapSpacingAndLand(HELL_CREEK_HUT, new StructureSeparationSettings(PrehistoricFaunaConfig.hellCreekHutMaxDistance, PrehistoricFaunaConfig.hellCreekHutMinDistance, 42773854), true);
		setupMapSpacingAndLand(MORRISON_HUT, new StructureSeparationSettings(PrehistoricFaunaConfig.morrisonHutMaxDistance, PrehistoricFaunaConfig.morrisonHutMinDistance, 476256184), true);
		setupMapSpacingAndLand(ISCHIGUALASTO_HUT, new StructureSeparationSettings(PrehistoricFaunaConfig.ischigualastoHutMaxDistance, PrehistoricFaunaConfig.ischigualastoHutMinDistance, 29578373), true);
	}

	private static Structure<NoFeatureConfig> registerStructureFeature(String registryName, Structure<NoFeatureConfig> feature) {
		structureFeatureList.add(feature);
		return feature;
	}

	public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {
		Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);
		if (transformSurroundingLand) {
			Structure.field_236384_t_ = ImmutableList.<Structure<?>>builder().addAll(Structure.field_236384_t_).add(structure).build();
		}
		WorldGenRegistries.NOISE_SETTINGS.forEach((dimensionSettings -> dimensionSettings.getStructures().func_236195_a_().put(structure, structureSeparationSettings)));
		DimensionStructuresSettings.field_236191_b_ = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder().putAll(DimensionStructuresSettings.field_236191_b_).put(structure, structureSeparationSettings).build();
	}
}
