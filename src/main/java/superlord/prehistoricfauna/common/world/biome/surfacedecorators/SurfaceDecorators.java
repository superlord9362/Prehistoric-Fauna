package superlord.prehistoricfauna.common.world.biome.surfacedecorators;

import java.util.HashMap;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.util.FastNoise;
import superlord.prehistoricfauna.init.PFBlocks;

public class SurfaceDecorators {
    public static final HashMap<ResourceLocation, SurfaceDecorator> BIOME_TO_SURFACE_DECORATOR = new HashMap<>();
    private static final SurfaceDecorator DEFAULT_DECORATOR = new DefaultSurfaceDecorator();
    public static final SurfaceDecorator TEST_DECORATOR = new BasicSurfaceDecorator(Blocks.RED_WOOL.defaultBlockState(), Blocks.GREEN_WOOL.defaultBlockState(), Blocks.BLUE_WOOL.defaultBlockState(), 4);
    static FastNoise noise;
    
    static {
        register(new ResourceLocation(PrehistoricFauna.MOD_ID, "chinle_wooded_mountains"),
                 new NoiseBasedSurfaceDecorator(PFBlocks.MOSSY_DIRT.get().defaultBlockState(), Blocks.DIRT.defaultBlockState(), PFBlocks.SILT.get().defaultBlockState(), PFBlocks.LOAM.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState(), -0.5D, 0.5D, 4, noise));
        register(new ResourceLocation(PrehistoricFauna.MOD_ID, "chinle_swamp"),
        		new NoiseBasedSurfaceDecorator(PFBlocks.MOSSY_DIRT.get().defaultBlockState(), Blocks.DIRT.defaultBlockState(), PFBlocks.SILT.get().defaultBlockState(), PFBlocks.LOAM.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), Blocks.CLAY.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), -0.5D, 0.5D, 4, noise));
        register(new ResourceLocation(PrehistoricFauna.MOD_ID, "chinle_flats"),
        		new NoiseBasedSurfaceDecorator(Blocks.SAND.defaultBlockState(), Blocks.SANDSTONE.defaultBlockState(), Blocks.SAND.defaultBlockState(), PFBlocks.HARDENED_SILT.get().defaultBlockState(), PFBlocks.HARDENED_SILT.get().defaultBlockState(), PFBlocks.SILT.get().defaultBlockState(), PFBlocks.SILT.get().defaultBlockState(), PFBlocks.HARDENED_SILT.get().defaultBlockState(), PFBlocks.SILT.get().defaultBlockState(), -0.5D, 0.5D, 4, noise));
        register(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualasto_clearing"),
        		new NoiseBasedSurfaceDecorator(PFBlocks.LOAM.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), Blocks.CLAY.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.DIRT.defaultBlockState(), PFBlocks.SILT.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), -0.5D, 0.5D, 4, noise));
        register(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualasto_forest"),
        		new NoiseBasedSurfaceDecorator(PFBlocks.LOAM.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), Blocks.CLAY.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.DIRT.defaultBlockState(), PFBlocks.SILT.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), -0.5D, 0.5D, 4, noise));
        register(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualasto_hills"),
        		new NoiseBasedSurfaceDecorator(PFBlocks.LOAM.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), Blocks.CLAY.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.DIRT.defaultBlockState(), PFBlocks.SILT.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), PFBlocks.PACKED_LOAM.get().defaultBlockState(), Blocks.GRAVEL.defaultBlockState(), -0.5D, 0.5D, 4, noise));
    }
    
    public static void setFastNoise(FastNoise noise) {
    	SurfaceDecorators.noise = noise;
    }

    public static void register(ResourceLocation biome, SurfaceDecorator decorator) {
        BIOME_TO_SURFACE_DECORATOR.put(biome, decorator);
    }
    public static SurfaceDecorator getSurfaceDecorator(ResourceLocation biomeLocation) {
        return BIOME_TO_SURFACE_DECORATOR.getOrDefault(biomeLocation, DEFAULT_DECORATOR);
    }
}