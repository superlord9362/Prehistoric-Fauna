package superlord.prehistoricfauna.init;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.biome.TriassicBiomes;

public class PFBiomes {
	
	public static final DeferredRegister<Biome> REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, PrehistoricFauna.MOD_ID);
	public static RegistryObject<Biome> CHINLE_FLATS = REGISTER.register("chinle_flats", TriassicBiomes::chinleFlats);
	public static RegistryObject<Biome> CHINLE_RIVER = REGISTER.register("chinle_river", TriassicBiomes::chinleRiver);
	public static RegistryObject<Biome> CHINLE_SWAMP = REGISTER.register("chinle_swamp", TriassicBiomes::chinleSwamp);
	public static RegistryObject<Biome> CHINLE_WOODED_MOUNTAINS = REGISTER.register("chinle_wooded_mountains", TriassicBiomes::chinleWoodedMountains);
	public static RegistryObject<Biome> ISCHIGUALASTO_RIVER = REGISTER.register("ischigualasto_river", TriassicBiomes::ischigualastoRiver);
	public static RegistryObject<Biome> ISCHIGUALASTO_CLEARING = REGISTER.register("ischigualasto_clearing", TriassicBiomes::ischigualastoClearing);
	public static RegistryObject<Biome> ISCHIGUALASTO_FOREST = REGISTER.register("ischigualasto_forest", TriassicBiomes::ischigualastoForest);
	public static RegistryObject<Biome> ISCHIGUALASTO_HILLS = REGISTER.register("ischigualasto_hills", TriassicBiomes::ischigualastoHills);

}
