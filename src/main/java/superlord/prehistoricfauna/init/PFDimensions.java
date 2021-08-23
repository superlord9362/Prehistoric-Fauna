package superlord.prehistoricfauna.init;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.world.dimension.PFChunkGenerator;
import superlord.prehistoricfauna.world.dimension.cretaceous.CretaceousBiomeProvider;
import superlord.prehistoricfauna.world.dimension.jurassic.JurassicBiomeProvider;
import superlord.prehistoricfauna.world.dimension.triassic.TriassicBiomeProvider;

public class PFDimensions {
	
	public static final DeferredRegister<PointOfInterestType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, PrehistoricFauna.MOD_ID);
	
	public static final RegistryObject<PointOfInterestType> CRETACEOUS_PORTAL = POI_TYPES.register("cretaceous_portal", () -> new PointOfInterestType("cretaceous_portal", PointOfInterestType.getAllStates(PFBlocks.CRETACEOUS_PORTAL.get()), 0, 1));
	public static final RegistryObject<PointOfInterestType> JURASSIC_PORTAL = POI_TYPES.register("jurassic_portal", () -> new PointOfInterestType("jurassic_portal", PointOfInterestType.getAllStates(PFBlocks.JURASSIC_PORTAL.get()), 0, 1));
	public static final RegistryObject<PointOfInterestType> TRIASSIC_PORTAL = POI_TYPES.register("triassic_portal", () -> new PointOfInterestType("triassic_portal", PointOfInterestType.getAllStates(PFBlocks.TRIASSIC_PORTAL.get()), 0, 1));

	public static final RegistryKey<World> CRETACEOUS_WORLD = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(PrehistoricFauna.MOD_ID, "cretaceous_dimension"));
	public static final RegistryKey<DimensionType> CRETACEOUS_DIMENSION = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(PrehistoricFauna.MOD_ID, "cretaceous_dimension"));
	public static final RegistryKey<World> JURASSIC_WORLD = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic_dimension"));
	public static final RegistryKey<DimensionType> JURASSIC_DIMENSION = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic_dimension"));
	public static final RegistryKey<World> TRIASSIC_WORLD = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic_dimension"));
	public static final RegistryKey<DimensionType> TRIASSIC_DIMENSION = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic_dimension"));

	public static void initDimension() {
		Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(PrehistoricFauna.MOD_ID, "cretaceous_dimension"), CretaceousBiomeProvider.CODEC);
		Registry.register(Registry.CHUNK_GENERATOR_CODEC, new ResourceLocation(PrehistoricFauna.MOD_ID, "chunk_generator"), PFChunkGenerator.CODEC);
		
		Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic_dimension"), JurassicBiomeProvider.CODEC);
		
		Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic_dimension"), TriassicBiomeProvider.CODEC);
	}
	
}
