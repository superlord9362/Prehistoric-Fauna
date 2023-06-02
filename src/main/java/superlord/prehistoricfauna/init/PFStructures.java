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
import superlord.prehistoricfauna.common.feature.structures.GeologistCampStructure;
import superlord.prehistoricfauna.common.feature.structures.PortalChamberStructure;
import superlord.prehistoricfauna.common.feature.structures.TimeTempleStructure;
import superlord.prehistoricfauna.common.feature.structures.structurepiece.GeologistCampStructurePiece;
import superlord.prehistoricfauna.common.feature.structures.structurepiece.TimeTempleStructurePiece;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFStructures {

	public static final StructureFeature<NoneFeatureConfiguration> TIME_TEMPLE = new TimeTempleStructure(NoneFeatureConfiguration.CODEC);
	public static final StructureFeature<NoneFeatureConfiguration> GEOLOGIST_CAMP = new GeologistCampStructure(NoneFeatureConfiguration.CODEC);
	public static final StructureFeature<NoneFeatureConfiguration> PORTAL_CHAMBER = new PortalChamberStructure(NoneFeatureConfiguration.CODEC);
	
	public static StructurePieceType TIME_TEMPLE_PIECE;
	public static StructurePieceType GEOLOGIST_CAMP_PIECE;
	
	public static StructurePieceType setPieceId(StructurePieceType.StructureTemplateType type, String name) {
		return Registry.register(Registry.STRUCTURE_PIECE, name.toLowerCase(Locale.ROOT), type);
	}
	
	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<StructureFeature<?>> registry) {
		registry.getRegistry().register(TIME_TEMPLE.setRegistryName("prehistoricfauna:time_temple"));
		registry.getRegistry().register(GEOLOGIST_CAMP.setRegistryName("prehistoricfauna:geologist_camp"));
		registry.getRegistry().register(PORTAL_CHAMBER.setRegistryName("prehistoricfauna:portal_chamber"));
	}
	
	public static void init() {
		TIME_TEMPLE_PIECE = setPieceId(TimeTempleStructurePiece.Piece::new, "TTSP");
		GEOLOGIST_CAMP_PIECE = setPieceId(GeologistCampStructurePiece.Piece::new, "GCSP");
	}
	
}
