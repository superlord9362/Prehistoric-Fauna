package superlord.prehistoricfauna.core.world.util;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.core.world.PHFBiomes;
import superlord.prehistoricfauna.core.world.PHFDecorators;
import superlord.prehistoricfauna.core.world.PHFFeatures;
import superlord.prehistoricfauna.core.world.PHFStructures;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation")
public class WorldGenRegistrationHelper {

    public static <SBC extends ISurfaceBuilderConfig, SB extends SurfaceBuilder<SBC>> SB createSurfaceBuilder(String id, SB surfaceBuilder) {
        ResourceLocation phfID = new ResourceLocation(PrehistoricFauna.MODID, id);
        if (Registry.SURFACE_BUILDER.keySet().contains(phfID))
            throw new IllegalStateException("Surface Builder ID: \"" + phfID.toString() + "\" already exists in the Surface Builder registry!");

//        Registry.register(Registry.SURFACE_BUILDER, phfID, surfaceBuilder);
        surfaceBuilder.setRegistryName(phfID); //Forge
//        BYGSurfaceBuilders.surfaceBuilders.add(surfaceBuilder);
        return surfaceBuilder;
    }

    @SuppressWarnings("unused")
	public static <SC extends ISurfaceBuilderConfig, CSB extends ConfiguredSurfaceBuilder<SC>> CSB createConfiguredSurfaceBuilder(String id, CSB configuredSurfaceBuilder) {
        ResourceLocation phfID = new ResourceLocation(PrehistoricFauna.MODID, id);
//        if (WorldGenRegistries.CONFIGURED_SURFACE_BUILDER.keySet().contains(phfID))
//            throw new IllegalStateException("Configured Surface Builder ID: \"" + phfID.toString() + "\" already exists in the Configured Surface Builder registry!");
//
//        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, phfID, configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <C extends IFeatureConfig, F extends Feature<C>> F createFeature(String id, F feature) {
        ResourceLocation phfID = new ResourceLocation(PrehistoricFauna.MODID, id);
        if (Registry.FEATURE.keySet().contains(phfID))
            throw new IllegalStateException("Feature ID: \"" + phfID.toString() + "\" already exists in the Features registry!");

//        Registry.register(Registry.FEATURE, phfID, feature);
        feature.setRegistryName(phfID); //Forge
        PHFFeatures.features.add(feature);
        return feature;
    }

    public static <C extends IFeatureConfig, F extends Structure<C>> F createStructure(String id, F structure, int minChunkDistance, int maxChunkDistance, int seedModifier, GenerationStage.Decoration decorationStage) {
        ResourceLocation phfID = new ResourceLocation(PrehistoricFauna.MODID, id);
        if (Registry.STRUCTURE_FEATURE.keySet().contains(phfID))
            throw new IllegalStateException("Structure Feature ID: \"" + phfID.toString() + "\" already exists in the Structure Features registry!");
//        Registry.register(Registry.STRUCTURE_FEATURE, phfID, structure);
        structure.setRegistryName(phfID);
        PHFStructures.structures.add(structure);
        //1.16
//        Structure.NAME_STRUCTURE_BIMAP.put(phfID.toString(), structure);
//
//        Structure.STRUCTURE_DECORATION_STAGE_MAP.put(structure, decorationStage);
//
//        DimensionStructuresSettings.field_236191_b_ =
//                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
//                        .putAll(DimensionStructuresSettings.field_236191_b_)
//                        .put(structure, new StructureSeparationSettings(minChunkDistance, maxChunkDistance, seedModifier))
//                        .build();
        return structure;
    }


//    public static <C extends IFeatureConfig, CSF extends StructureFeature<C, ?>> CSF createConfiguredStructureFeature(String id, CSF configuredStructureFeature) {
//        ResourceLocation phfID = new ResourceLocation(PrehistoricFauna.MODID, id);
//        if (WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE.keySet().contains(phfID))
//            throw new IllegalStateException("Configured Structure Feature ID: \"" + phfID.toString() + "\" already exists in the Configured Structure Features registry!");
//
//        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, phfID, configuredStructureFeature);
//        return configuredStructureFeature;
//    }


    public static IStructurePieceType createStructurePiece(String id, IStructurePieceType piece) {
        Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(PrehistoricFauna.MODID, id), piece);
        return piece;
    }

    @SuppressWarnings("unused")
	public static <FC extends IFeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        ResourceLocation phfID = new ResourceLocation(PrehistoricFauna.MODID, id);
//        if (WorldGenRegistries.CONFIGURED_FEATURE.keySet().contains(phfID))
//            throw new IllegalStateException("Configured Feature ID: \"" + phfID.toString() + "\" already exists in the Configured Features registry!");

//        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, phfID, configuredFeature);
        return configuredFeature;
    }

    public static <DC extends IPlacementConfig, D extends Placement<DC>> D createDecorator(String id, D decorator) {
        ResourceLocation phfID = new ResourceLocation(PrehistoricFauna.MODID, id);
        if (Registry.DECORATOR.keySet().contains(phfID))
            throw new IllegalStateException("Decorator ID: \"" + phfID.toString() + "\" already exists in the Decorator registry!");

//        Registry.register(Registry.DECORATOR, phfID, decorator);
        decorator.setRegistryName(phfID); //Forge
        PHFDecorators.decorators.add(decorator);
        return decorator;
    }

    static Set<Integer> integerList = new HashSet<>();

    public static Biome createBiome(String id, Biome biome, int numericalID) {
        ResourceLocation phfID = new ResourceLocation(PrehistoricFauna.MODID, id);
        if (/*WorldGenRegistries.BIOME.keySet().contains(phfID)*/ Registry.BIOME.keySet().contains(phfID))
            throw new IllegalStateException("Biome ID: \"" + phfID.toString() + "\" already exists in the Biome registry!");

//        Registry.register(WorldGenRegistries.BIOME, phfID, biome);
        biome.setRegistryName(phfID); //Forge

        if (integerList.contains(numericalID))
            PrehistoricFauna.LOGGER.warn("Duplicate Biome Numerical ID: " + numericalID + " at byg:" + id);

        PHFBiomes.biomes.add(new PHFBiomes.PreserveBiomeOrder(biome, numericalID));
        integerList.add(numericalID);
        return biome;
    }
}