package superlord.prehistoricfauna.init;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.world.structure.GeologistCampStructure;
import superlord.prehistoricfauna.world.structure.HellCreekHutStructure;
import superlord.prehistoricfauna.world.structure.IschigualastoHutStructure;
import superlord.prehistoricfauna.world.structure.MorrisonHutStructure;
import superlord.prehistoricfauna.world.structure.PortalChamberStructure;
import superlord.prehistoricfauna.world.structure.TimeTempleStructure;

public class PFStructures {
	
	public static IStructurePieceType TIME_TEMPLE_PIECE_TYPE = TimeTempleStructure.Piece::new;
	public static IStructurePieceType GEOLOGIST_CAMP_PIECE_TYPE = GeologistCampStructure.Piece::new;
	public static IStructurePieceType PORTAL_CHAMBER_PIECE_TYPE = PortalChamberStructure.Piece::new;
	public static IStructurePieceType HELL_CREEK_HUT_PIECE_TYPE = HellCreekHutStructure.Piece::new;
	public static IStructurePieceType MORRISON_HUT_PIECE_TYPE = MorrisonHutStructure.Piece::new;
	public static IStructurePieceType ISCHIGUALASTO_HUT_PIECE_TYPE = IschigualastoHutStructure.Piece::new;

	public static final DeferredRegister<Structure<?>> REGISTER = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, PrehistoricFauna.MOD_ID);
	
	public static final RegistryObject<Structure<NoFeatureConfig>> TIME_TEMPLE = REGISTER.register("time_temple", () -> (new TimeTempleStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> GEOLOGIST_CAMP = REGISTER.register("geologist_camp", () -> (new GeologistCampStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> PORTAL_CHAMBER = REGISTER.register("portal_chamber", () -> (new PortalChamberStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> HELL_CREEK_HUT = REGISTER.register("hell_creek_hut", () -> (new HellCreekHutStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> MORRISON_HUT = REGISTER.register("morrison_hut", () -> (new MorrisonHutStructure(NoFeatureConfig.field_236558_a_)));
	public static final RegistryObject<Structure<NoFeatureConfig>> ISCHIGUALASTO_HUT = REGISTER.register("ischigualasto_hut", () -> (new IschigualastoHutStructure(NoFeatureConfig.field_236558_a_)));

	public static void setupStructures() {
		setupMapSpacingAndLand(TIME_TEMPLE.get(), new StructureSeparationSettings(PrehistoricFaunaConfig.timeTempleMinDistance, PrehistoricFaunaConfig.timeTempleMaxDistance, 8237163), true);
		setupMapSpacingAndLand(GEOLOGIST_CAMP.get(), new StructureSeparationSettings(PrehistoricFaunaConfig.geologistCampMinDistance, PrehistoricFaunaConfig.geologistCampMaxDistance, 37126163), true);
		setupMapSpacingAndLand(PORTAL_CHAMBER.get(), new StructureSeparationSettings(PrehistoricFaunaConfig.portalHubMinDistance, PrehistoricFaunaConfig.portalHubMaxDistance, 2837462), true);
		setupMapSpacingAndLand(HELL_CREEK_HUT.get(), new StructureSeparationSettings(PrehistoricFaunaConfig.hellCreekHutMinDistance, PrehistoricFaunaConfig.hellCreekHutMaxDistance, 42773854), true);
		setupMapSpacingAndLand(MORRISON_HUT.get(), new StructureSeparationSettings(PrehistoricFaunaConfig.morrisonHutMinDistance, PrehistoricFaunaConfig.morrisonHutMaxDistance, 476256184), true);
		setupMapSpacingAndLand(ISCHIGUALASTO_HUT.get(), new StructureSeparationSettings(PrehistoricFaunaConfig.ischigualastoHutMinDistance, PrehistoricFaunaConfig.ischigualastoHutMaxDistance, 29578373), true);
	}
	
	public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {
		Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);
		if (transformSurroundingLand) {
			Structure.field_236384_t_ = ImmutableList.<Structure<?>>builder().addAll(Structure.field_236384_t_).add(structure).build();
		}
		DimensionStructuresSettings.field_236191_b_ = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder().putAll(DimensionStructuresSettings.field_236191_b_).put(structure, structureSeparationSettings).build();
	}
	
	public static void registerStructurePieces() {
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "time_temple"), TIME_TEMPLE_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "geologist_camp"), GEOLOGIST_CAMP_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "portal_chamber"), PORTAL_CHAMBER_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "hell_creek_hut"), HELL_CREEK_HUT_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "morrison_hut"), MORRISON_HUT_PIECE_TYPE);
		Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualasto_hut"), ISCHIGUALASTO_HUT_PIECE_TYPE);

	}
	    
}
