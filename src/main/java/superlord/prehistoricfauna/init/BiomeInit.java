package superlord.prehistoricfauna.init;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.world.PrehistoricFeature;
import superlord.prehistoricfauna.world.biomes.HellCreekBiome;
import superlord.prehistoricfauna.world.biomes.HellCreekSwamp;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.MOD)
public class BiomeInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, PrehistoricFauna.MODID);
	
	public static final RegistryObject<Biome> HELL_CREEK_BIOME = BIOMES.register("hell_creek_biome", () -> new HellCreekBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.2F).temperature(0.7f).depth(0.1f).downfall(0.8F).category(Category.TAIGA).waterColor(4159204).waterFogColor(329011).surfaceBuilder(PrehistoricFeature.HELL_CREEK, PrehistoricFeature.COARSEDIRT_COARSEDIRT_CLAY_CONFIG).parent(null)));
	public static final RegistryObject<Biome> HELL_CREEK_SWAMP = BIOMES.register("hell_creek_swamp", () -> new HellCreekSwamp(new Biome.Builder().precipitation(RainType.RAIN).scale(0.1F).temperature(0.8f).depth(-0.2F).downfall(0.9F).category(Category.SWAMP).waterColor(6388580).waterFogColor(2302743).surfaceBuilder(PrehistoricFeature.HELL_CREEK, PrehistoricFeature.COARSEDIRT_COARSEDIRT_CLAY_CONFIG).parent(null)));
	
	public static void registerBiomes() {
		registerBiome(HELL_CREEK_BIOME.get(), Type.CONIFEROUS, Type.SPARSE);
		registerBiome(HELL_CREEK_SWAMP.get(), Type.CONIFEROUS, Type.SPARSE, Type.SWAMP);
	}
	
	private static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
	}
	
	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		registerBiomes();
	}
	
}
