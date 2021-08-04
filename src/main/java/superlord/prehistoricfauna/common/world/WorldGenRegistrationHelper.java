package superlord.prehistoricfauna.common.world;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFBiomes;
import superlord.prehistoricfauna.init.PFDecorators;

@SuppressWarnings("deprecation")
public class WorldGenRegistrationHelper {

	public static <DC extends IPlacementConfig, D extends Placement<DC>> D createDecorator(String id, D decorator) {
		ResourceLocation pfID = new ResourceLocation(PrehistoricFauna.MOD_ID, id);
		if (Registry.DECORATOR.keySet().contains(pfID)) throw new IllegalStateException("Decorator ID: \"" + pfID + "\" already exists in the Decorator registry!");
		decorator.setRegistryName(pfID);
		PFDecorators.decorators.add(decorator);
		return decorator;
	}

	public static <SBC extends ISurfaceBuilderConfig, SB extends SurfaceBuilder<SBC>> SB createSurfaceBuilder(String id, SB surfaceBuilder) {
		ResourceLocation pfID = new ResourceLocation(PrehistoricFauna.MOD_ID, id);
		if (Registry.SURFACE_BUILDER.keySet().contains(pfID)) throw new IllegalStateException("Surface Builder ID: \"" + pfID.toString() + "\" already exists in the Surface Builder registry!");

		surfaceBuilder.setRegistryName(pfID); //Forge
		PFSurfaceBuilders.surfaceBuilders.add(surfaceBuilder);
		return surfaceBuilder;
	}

	public static <SC extends ISurfaceBuilderConfig, CSB extends ConfiguredSurfaceBuilder<SC>> CSB createConfiguredSurfaceBuilder(String id, CSB configuredSurfaceBuilder) {
		ResourceLocation pfID = new ResourceLocation(PrehistoricFauna.MOD_ID, id);
		if (WorldGenRegistries.CONFIGURED_SURFACE_BUILDER.keySet().contains(pfID))
			throw new IllegalStateException("Configured Surface Builder ID: \"" + pfID.toString() + "\" already exists in the Configured Surface Builder registry!");

		Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, pfID, configuredSurfaceBuilder);
		return configuredSurfaceBuilder;
	}

	static Set<Integer> integerList = new HashSet<>();

	public static Biome createBiome(String id, Biome biome, int numericalID) {
		ResourceLocation pfID = new ResourceLocation(PrehistoricFauna.MOD_ID, id);
		if (WorldGenRegistries.BIOME.keySet().contains(pfID)) throw new IllegalStateException("Biome ID: \"" + pfID.toString() + "\" already exists in the Biome registry!");
		biome.setRegistryName(pfID);
		PFBiomes.biomeList.add(new PFBiomes.PreserveBiomeOrder(biome, numericalID));
		integerList.add(numericalID);
		return biome;
	}

}
