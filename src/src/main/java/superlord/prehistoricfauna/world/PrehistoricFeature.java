package superlord.prehistoricfauna.world;

import com.google.common.collect.Lists;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.world.placement.HellCreekHutPieces;
import superlord.prehistoricfauna.world.placement.IschigualastoHutPieces;
import superlord.prehistoricfauna.world.placement.MorrisonHutPieces;
import superlord.prehistoricfauna.world.placement.TimeTemplePieces;
import superlord.prehistoricfauna.world.structures.HCHutStructure;
import superlord.prehistoricfauna.world.structures.IschigualastoStructure;
import superlord.prehistoricfauna.world.structures.MorrisonHutStructure;
import superlord.prehistoricfauna.world.structures.TimeTempleStructure;

import java.util.Locale;

public class PrehistoricFeature {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES, PrehistoricFauna.MODID);


	public static Structure<NoFeatureConfig> HELL_CREEK_HUT = new HCHutStructure(NoFeatureConfig::deserialize);
	public static Structure<NoFeatureConfig> MORRISON_HUT = new MorrisonHutStructure(NoFeatureConfig::deserialize);
	public static Structure<NoFeatureConfig> ISCHIGUALASTO_HUT = new IschigualastoStructure(NoFeatureConfig::deserialize);
	public static Structure<NoFeatureConfig> TIME_TEMPLE = new TimeTempleStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType HCHUT_PIECE = HellCreekHutPieces.Piece::new;
	public static IStructurePieceType MORRISON_HUT_PIECE = MorrisonHutPieces.Piece::new;
	public static IStructurePieceType ISCHIGUALASTO_HUT_PIECE = IschigualastoHutPieces.Piece::new;
	public static IStructurePieceType TIME_TEMPLE_PIECE = TimeTemplePieces.Piece::new;
	
	public static void registerFeatures(Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		PrehistoricFauna.register(registry, HELL_CREEK_HUT, "hell_creek_hut");
		PrehistoricFauna.register(registry, MORRISON_HUT, "morrison_hut");
		PrehistoricFauna.register(registry, ISCHIGUALASTO_HUT, "ischigualasto_hut");
		PrehistoricFauna.register(registry, TIME_TEMPLE, "time_temple");
		register(HCHUT_PIECE, "HCHUT_PIECE");
		register(MORRISON_HUT_PIECE, "MORRISON_HUT_PIECE");
		register(ISCHIGUALASTO_HUT_PIECE, "ISCHIGUALASTO_HUT_PIECE");
		register(TIME_TEMPLE_PIECE, "TIME_TEMPLE_PIECE");
	}

	static IStructurePieceType register(IStructurePieceType structurePiece, String key) {
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
	}

	//public static final Feature<PrehistoricGiantTreeFeatureConfig> CYPRESS_TREE = register("cypress_tree", new CypressTreeGenerator(PrehistoricGiantTreeFeatureConfig::deserializeCypress));

	public static void addSedimentDisks(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), 7, 2, Lists.newArrayList(Blocks.COARSE_DIRT.getDefaultState(), BlockInit.MOSSY_DIRT.getDefaultState(), Blocks.PODZOL.getDefaultState()))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(3))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.CLAY.getDefaultState(), 4, 1, Lists.newArrayList(Blocks.COARSE_DIRT.getDefaultState(), Blocks.CLAY.getDefaultState()))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), 6, 2, Lists.newArrayList(Blocks.COARSE_DIRT.getDefaultState()))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
		return (F)(Registry.<Feature<?>>register(Registry.FEATURE, key, value));
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F)(Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}

}
