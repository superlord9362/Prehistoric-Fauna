package superlord.prehistoricfauna.init;

import java.util.Locale;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.feature.structures.*;
import superlord.prehistoricfauna.common.feature.structures.structurepiece.*;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFStructures {

	public static final StructureFeature<NoneFeatureConfiguration> TIME_TEMPLE = new TimeTempleStructure(NoneFeatureConfiguration.CODEC);
	public static final StructureFeature<NoneFeatureConfiguration> GEOLOGIST_CAMP = new GeologistCampStructure(NoneFeatureConfiguration.CODEC);
	public static final StructureFeature<NoneFeatureConfiguration> PORTAL_CHAMBER = new PortalChamberStructure(NoneFeatureConfiguration.CODEC);

	public static final StructureFeature<NoneFeatureConfiguration> YIXIAN_HUT = new YixianHutStructure(NoneFeatureConfiguration.CODEC);
	public static final StructureFeature<NoneFeatureConfiguration> DJADOCHTA_HUT = new DjadochtaHutStructure(NoneFeatureConfiguration.CODEC);
	public static final StructureFeature<NoneFeatureConfiguration> HELL_CREEK_HUT = new HellCreekHutStructure(NoneFeatureConfiguration.CODEC);

	public static final StructureFeature<NoneFeatureConfiguration> MORRISON_HUT = new MorrisonHutStructure(NoneFeatureConfiguration.CODEC);
	public static final StructureFeature<NoneFeatureConfiguration> KAYENTA_HUT = new KayentaHutStructure(NoneFeatureConfiguration.CODEC);

	public static final StructureFeature<NoneFeatureConfiguration> ISCHIGUALASTO_HUT = new IschigualastoHutStructure(NoneFeatureConfiguration.CODEC);
	public static final StructureFeature<NoneFeatureConfiguration> CHINLE_HUT = new ChinleHutStructure(NoneFeatureConfiguration.CODEC);

	public static StructurePieceType TIME_TEMPLE_PIECE;
	public static StructurePieceType GEOLOGIST_CAMP_PIECE;
	public static StructurePieceType PORTAL_CHAMBER_PIECE;
	
	public static StructurePieceType YIXIAN_HUT_PIECE;
	public static StructurePieceType DJADOCHTA_HUT_PIECE;
	public static StructurePieceType HELL_CREEK_HUT_PIECE;

	public static StructurePieceType MORRISON_HUT_PIECE;
	public static StructurePieceType KAYENTA_HUT_PIECE;

	public static StructurePieceType ISCHIGUALASTO_HUT_PIECE;
	public static StructurePieceType CHINLE_HUT_PIECE;
	
	public static StructurePieceType setPieceId(StructurePieceType.StructureTemplateType type, String name) {
		return Registry.register(Registry.STRUCTURE_PIECE, name.toLowerCase(Locale.ROOT), type);
	}
	
	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<StructureFeature<?>> registry) {
		registry.getRegistry().register(TIME_TEMPLE.setRegistryName("prehistoricfauna:time_temple"));
		registry.getRegistry().register(GEOLOGIST_CAMP.setRegistryName("prehistoricfauna:geologist_camp"));
		registry.getRegistry().register(PORTAL_CHAMBER.setRegistryName("prehistoricfauna:portal_chamber"));
		registry.getRegistry().register(YIXIAN_HUT.setRegistryName("prehistoricfauna:yixian_hut"));
		registry.getRegistry().register(DJADOCHTA_HUT.setRegistryName("prehistoricfauna:djadochta_hut"));
		registry.getRegistry().register(HELL_CREEK_HUT.setRegistryName("prehistoricfauna:hell_creek_hut"));
		registry.getRegistry().register(MORRISON_HUT.setRegistryName("prehistoricfauna:morrison_hut"));
		registry.getRegistry().register(KAYENTA_HUT.setRegistryName("prehistoricfauna:kayenta_hut"));
		registry.getRegistry().register(ISCHIGUALASTO_HUT.setRegistryName("prehistoricfauna:ischigualasto_hut"));
		registry.getRegistry().register(CHINLE_HUT.setRegistryName("prehistoricfauna:chinle_hut"));
	}
	
	public static void init() {
		TIME_TEMPLE_PIECE = setPieceId(TimeTempleStructurePiece.Piece::new, "TTSP");
		GEOLOGIST_CAMP_PIECE = setPieceId(GeologistCampStructurePiece.Piece::new, "GCSP");
		PORTAL_CHAMBER_PIECE = setPieceId(PortalChamberStructurePiece.Piece::new, "PCSP");
		YIXIAN_HUT_PIECE = setPieceId(YixianHutStructurePiece.Piece::new, "YHSP");
		DJADOCHTA_HUT_PIECE = setPieceId(DjadochtaHutStructurePiece.Piece::new, "DHSP");
		HELL_CREEK_HUT_PIECE = setPieceId(HellCreekHutStructurePiece.Piece::new, "HCHSP");
		MORRISON_HUT_PIECE = setPieceId(MorrisonHutStructurePiece.Piece::new, "MHSP");
		KAYENTA_HUT_PIECE = setPieceId(KayentaHutStructurePiece.Piece::new, "KHSP");
		ISCHIGUALASTO_HUT_PIECE = setPieceId(IschigualastoHutStructurePiece.Piece::new, "IHSP");
		CHINLE_HUT_PIECE = setPieceId(ChinleHutStructurePiece.Piece::new, "CHSP");
	}
	
}
