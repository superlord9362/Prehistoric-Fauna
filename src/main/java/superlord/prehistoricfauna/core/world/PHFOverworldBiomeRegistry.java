package superlord.prehistoricfauna.core.world;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.world.biomes.PetrifiedForestBiome;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PHFOverworldBiomeRegistry {
	public static List<String> biomeList = new ArrayList<>();
	
	public static final Biome PETRIFIED_FOREST = new PetrifiedForestBiome();
	
	@SubscribeEvent
	public static void registerPFBiomes(RegistryEvent.Register<Biome> event) {
		IForgeRegistry<Biome> registry = event.getRegistry();

		registerBiome(registry, PETRIFIED_FOREST, "petrified_forest", true, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.WASTELAND);
	}
	
	public static void addBiomesToWeightSystem() {
		addBiomeEntry(PETRIFIED_FOREST, 4, BiomeManager.BiomeType.DESERT);
	}

	private static void registerBiome(IForgeRegistry<Biome> registry, Biome biome, String name, boolean spawn, BiomeDictionary.Type... types) {
		registry.register(biome.setRegistryName(PrehistoricFauna.MODID, name));
		if (spawn) {
			BiomeManager.addSpawnBiome(biome);
		}
		BiomeDictionary.addTypes(biome, types);
		biomeList.add(name);
	}
	
	public static void addBiomeEntry(Biome biome, int weight, BiomeManager.BiomeType type) {
		if (weight > 0) {
			BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
		}
	}


}
