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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.world.structure.TimeTempleStructure;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFStructures {
	
	public static IStructurePieceType TIME_TEMPLE_PIECE_TYPE = TimeTempleStructure.Piece::new;
	
	public static final DeferredRegister<Structure<?>> REGISTER = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, PrehistoricFauna.MOD_ID);
	
	public static final RegistryObject<Structure<NoFeatureConfig>> TIME_TEMPLE = REGISTER.register("time_temple", () -> (new TimeTempleStructure(NoFeatureConfig.field_236558_a_)));
	
	public static void setupStructures() {
		setupMapSpacingAndLand(TIME_TEMPLE.get(), new StructureSeparationSettings(100, 50, 8237163), true);
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
	}

}
