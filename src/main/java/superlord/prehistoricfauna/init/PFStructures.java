package superlord.prehistoricfauna.init;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.mojang.serialization.Codec;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.structure.piece.ChinleHutPieces.ChinleHutPiece;
import superlord.prehistoricfauna.common.structure.piece.DjadochtaHutPieces.DjadochtaHutPiece;
import superlord.prehistoricfauna.common.structure.piece.GeologistCampPieces.GeologistCampPiece;
import superlord.prehistoricfauna.common.structure.piece.HellCreekHutPieces.HellCreekHutPiece;
import superlord.prehistoricfauna.common.structure.piece.IschigualastoHutPieces.IschigualastoHutPiece;
import superlord.prehistoricfauna.common.structure.piece.KayentaHutPieces.KayentaHutPiece;
import superlord.prehistoricfauna.common.structure.piece.MorrisonHutPieces.MorrisonHutPiece;
import superlord.prehistoricfauna.common.structure.piece.TimeTemplePieces.TimeTemplePiece;
import superlord.prehistoricfauna.common.structure.piece.YixianHutPieces.YixianHutPiece;
import superlord.prehistoricfauna.common.structure.*;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class PFStructures {

	public static final ResourceKey<Structure> CHINLE_HUT = createKey("chinle_hut");
	public static final ResourceKey<Structure> ISCHIGUALASTO_HUT = createKey("ischigualasto_hut");

	public static final ResourceKey<Structure> MORRISON_HUT = createKey("morrison_hut");
	public static final ResourceKey<Structure> KAYENTA_HUT = createKey("kayenta_hut");

	public static final ResourceKey<Structure> HELL_CREEK_HUT = createKey("hell_creek_hut");
	public static final ResourceKey<Structure> DJADOCHTA_HUT = createKey("djadochta_hut");
	public static final ResourceKey<Structure> YIXIAN_HUT = createKey("yixian_hut");

	public static final ResourceKey<Structure> TIME_TEMPLE = createKey("time_temple");
	public static final ResourceKey<Structure> GEOLOGIST_CAMP = createKey("geologist_camp");

	public static void bootstrap(BootstapContext<Structure> bootstap) {
		HolderGetter<Biome> holdergetter = bootstap.lookup(Registries.BIOME);
		bootstap.register(CHINLE_HUT, new ChinleHutStructure(structure(holdergetter.getOrThrow(PFTags.HAS_CHINLE_HUT), TerrainAdjustment.NONE)));
		bootstap.register(ISCHIGUALASTO_HUT, new IschigualastoHutStructure(structure(holdergetter.getOrThrow(PFTags.HAS_ISCHIGUALASTO_HUT), TerrainAdjustment.NONE)));

		bootstap.register(MORRISON_HUT, new MorrisonHutStructure(structure(holdergetter.getOrThrow(PFTags.HAS_MORRISON_HUT), TerrainAdjustment.NONE)));
		bootstap.register(KAYENTA_HUT, new KayentaHutStructure(structure(holdergetter.getOrThrow(PFTags.HAS_KAYENTA_HUT), TerrainAdjustment.NONE)));

		bootstap.register(HELL_CREEK_HUT, new HellCreekHutStructure(structure(holdergetter.getOrThrow(PFTags.HAS_HELL_CREEK_HUT), TerrainAdjustment.NONE)));
		bootstap.register(DJADOCHTA_HUT, new DjadochtaHutStructure(structure(holdergetter.getOrThrow(PFTags.HAS_DJADOCHTA_HUT), TerrainAdjustment.NONE)));
		bootstap.register(YIXIAN_HUT, new YixianHutStructure(structure(holdergetter.getOrThrow(PFTags.HAS_YIXIAN_HUT), TerrainAdjustment.NONE)));

		bootstap.register(TIME_TEMPLE, new TimeTempleStructure(structure(holdergetter.getOrThrow(PFTags.HAS_TIME_TEMPLE), TerrainAdjustment.NONE)));
		bootstap.register(GEOLOGIST_CAMP, new GeologistCampStructure(structure(holdergetter.getOrThrow(PFTags.HAS_GEOLOGIST_CAMP), TerrainAdjustment.NONE)));
	}

	private static Structure.StructureSettings structure(HolderSet<Biome> p_256015_, Map<MobCategory, StructureSpawnOverride> p_256297_, GenerationStep.Decoration p_255729_, TerrainAdjustment p_255865_) {
		return new Structure.StructureSettings(p_256015_, p_256297_, p_255729_, p_255865_);
	}

	private static Structure.StructureSettings structure(HolderSet<Biome> p_256501_, TerrainAdjustment p_255704_) {
		return structure(p_256501_, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, p_255704_);
	}

	private static ResourceKey<Structure> createKey(String p_209873_) {
		return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(PrehistoricFauna.MOD_ID, p_209873_));
	}

	public static final ResourceKey<StructureSet> CHINLE_HUT_STRUCTURE_SET = registerStructureSet("chinle_hut");
	public static final ResourceKey<StructureSet> ISCHIGUALASTO_HUT_STRUCTURE_SET = registerStructureSet("ischigualasto_hut");

	public static final ResourceKey<StructureSet> MORRISON_HUT_STRUCTURE_SET = registerStructureSet("morrison_hut");
	public static final ResourceKey<StructureSet> KAYENTA_HUT_STRUCTURE_SET = registerStructureSet("kayenta_hut");

	public static final ResourceKey<StructureSet> HELL_CREEK_HUT_STRUCTURE_SET = registerStructureSet("hell_creek_hut");
	public static final ResourceKey<StructureSet> DJADOCHTA_HUT_STRUCTURE_SET = registerStructureSet("djadochta_hut");
	public static final ResourceKey<StructureSet> YIXIAN_HUT_STRUCTURE_SET = registerStructureSet("yixian_hut");

	public static final ResourceKey<StructureSet> TIME_TEMPLE_STRUCTURE_SET = registerStructureSet("time_temple");
	public static final ResourceKey<StructureSet> GEOLOGIST_CAMP_STRUCTURE_SET = registerStructureSet("geologist_camp");

	public static void bootstrapStructureSet(BootstapContext<StructureSet> bootstap) {
		HolderGetter<Structure> holdergetter = bootstap.lookup(Registries.STRUCTURE);
		bootstap.register(CHINLE_HUT_STRUCTURE_SET, new StructureSet(List.of(StructureSet.entry(holdergetter.getOrThrow(CHINLE_HUT))), new RandomSpreadStructurePlacement(PrehistoricFaunaConfig.chinleHutMaxDistance, PrehistoricFaunaConfig.chinleHutMinDistance, RandomSpreadType.LINEAR, 591239123)));
		bootstap.register(ISCHIGUALASTO_HUT_STRUCTURE_SET, new StructureSet(List.of(StructureSet.entry(holdergetter.getOrThrow(ISCHIGUALASTO_HUT))), new RandomSpreadStructurePlacement(PrehistoricFaunaConfig.ischigualastoHutMaxDistance, PrehistoricFaunaConfig.ischigualastoHutMinDistance, RandomSpreadType.LINEAR, 96234812)));

		bootstap.register(MORRISON_HUT_STRUCTURE_SET, new StructureSet(List.of(StructureSet.entry(holdergetter.getOrThrow(MORRISON_HUT))), new RandomSpreadStructurePlacement(PrehistoricFaunaConfig.morrisonHutMaxDistance, PrehistoricFaunaConfig.morrisonHutMinDistance, RandomSpreadType.LINEAR, 612341942)));
		bootstap.register(KAYENTA_HUT_STRUCTURE_SET, new StructureSet(List.of(StructureSet.entry(holdergetter.getOrThrow(KAYENTA_HUT))), new RandomSpreadStructurePlacement(PrehistoricFaunaConfig.kayentaHutMaxDistance, PrehistoricFaunaConfig.kayentaHutMinDistance, RandomSpreadType.LINEAR, 851282139)));

		bootstap.register(HELL_CREEK_HUT_STRUCTURE_SET, new StructureSet(List.of(StructureSet.entry(holdergetter.getOrThrow(HELL_CREEK_HUT))), new RandomSpreadStructurePlacement(PrehistoricFaunaConfig.hellCreekHutMaxDistance, PrehistoricFaunaConfig.hellCreekHutMinDistance, RandomSpreadType.LINEAR, 6248341)));
		bootstap.register(DJADOCHTA_HUT_STRUCTURE_SET, new StructureSet(List.of(StructureSet.entry(holdergetter.getOrThrow(DJADOCHTA_HUT))), new RandomSpreadStructurePlacement(PrehistoricFaunaConfig.djadochtaHutMaxDistance, PrehistoricFaunaConfig.djadochtaHutMinDistance, RandomSpreadType.LINEAR, 85923812)));
		bootstap.register(YIXIAN_HUT_STRUCTURE_SET, new StructureSet(List.of(StructureSet.entry(holdergetter.getOrThrow(YIXIAN_HUT))), new RandomSpreadStructurePlacement(PrehistoricFaunaConfig.yixianHutMaxDistance, PrehistoricFaunaConfig.yixianHutMinDistance, RandomSpreadType.LINEAR, 5381239)));

		bootstap.register(TIME_TEMPLE_STRUCTURE_SET, new StructureSet(List.of(StructureSet.entry(holdergetter.getOrThrow(TIME_TEMPLE))), new RandomSpreadStructurePlacement(PrehistoricFaunaConfig.timeTempleMaxDistance, PrehistoricFaunaConfig.timeTempleMinDistance, RandomSpreadType.LINEAR, 9560612)));
		bootstap.register(GEOLOGIST_CAMP_STRUCTURE_SET, new StructureSet(List.of(StructureSet.entry(holdergetter.getOrThrow(GEOLOGIST_CAMP))), new RandomSpreadStructurePlacement(PrehistoricFaunaConfig.geologistCampMaxDistance, PrehistoricFaunaConfig.geologistCampMinDistance, RandomSpreadType.LINEAR, 46712832)));
	}

	private static ResourceKey<StructureSet> registerStructureSet(String p_209839_) {
		return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(PrehistoricFauna.MOD_ID, p_209839_));
	}

	public interface PFStructureType<S extends Structure> extends StructureType<S> {
		public static final DeferredRegister<StructureType<?>> REGISTRY = DeferredRegister.create(Registries.STRUCTURE_TYPE, PrehistoricFauna.MOD_ID);

		RegistryObject<StructureType<ChinleHutStructure>> CHINLE_HUT = register("chinle_hut", ChinleHutStructure.CODEC);
		RegistryObject<StructureType<IschigualastoHutStructure>> ISCHIGUALASTO_HUT = register("ischigualasto_hut", IschigualastoHutStructure.CODEC);

		RegistryObject<StructureType<MorrisonHutStructure>> MORRISON_HUT = register("morrison_hut", MorrisonHutStructure.CODEC);
		RegistryObject<StructureType<KayentaHutStructure>> KAYENTA_HUT = register("kayenta_hut", KayentaHutStructure.CODEC);

		RegistryObject<StructureType<HellCreekHutStructure>> HELL_CREEK_HUT = register("hell_creek_hut", HellCreekHutStructure.CODEC);
		RegistryObject<StructureType<DjadochtaHutStructure>> DJADOCHTA_HUT = register("djadochta_hut", DjadochtaHutStructure.CODEC);
		RegistryObject<StructureType<YixianHutStructure>> YIXIAN_HUT = register("yixian_hut", YixianHutStructure.CODEC);

		RegistryObject<StructureType<TimeTempleStructure>> TIME_TEMPLE = register("time_temple", TimeTempleStructure.CODEC);
		RegistryObject<StructureType<GeologistCampStructure>> GEOLOGIST_CAMP = register("geologist_camp", GeologistCampStructure.CODEC);

		private static <S extends Structure> RegistryObject<StructureType<S>> register(String string, Codec<S> codec) {
			return REGISTRY.register(string, () -> StructureType.register(string, codec));
		}
	}

	public interface PFStructurePieceType {
		public static final DeferredRegister<StructurePieceType> REGISTRY = DeferredRegister.create(Registries.STRUCTURE_PIECE, PrehistoricFauna.MOD_ID);

		RegistryObject<StructurePieceType> CHINLE_HUT = register(ChinleHutPiece::new, "chinle_hut");
		RegistryObject<StructurePieceType> ISCHIGUALASTO_HUT = register(IschigualastoHutPiece::new, "ischigualasto_hut");

		RegistryObject<StructurePieceType> MORRISON_HUT = register(MorrisonHutPiece::new, "morrison_hut");
		RegistryObject<StructurePieceType> KAYENTA_HUT = register(KayentaHutPiece::new, "kayenta_hut");

		RegistryObject<StructurePieceType> HELL_CREEK_HUT = register(HellCreekHutPiece::new, "hell_creek_hut");
		RegistryObject<StructurePieceType> DJADOCHTA_HUT = register(DjadochtaHutPiece::new, "djadochta_hut");
		RegistryObject<StructurePieceType> YIXIAN_HUT = register(YixianHutPiece::new, "yixian_hut");

		RegistryObject<StructurePieceType> TIME_TEMPLE = register(TimeTemplePiece::new, "time_temple");
		RegistryObject<StructurePieceType> GEOLOGIST_CAMP = register(GeologistCampPiece::new, "geologist_camp");

		private static RegistryObject<StructurePieceType> register(StructurePieceType.StructureTemplateType type, String string) {
			return REGISTRY.register(string, () -> StructurePieceType.setTemplatePieceId(type, string.toLowerCase(Locale.ROOT)));
		}

	}

}
