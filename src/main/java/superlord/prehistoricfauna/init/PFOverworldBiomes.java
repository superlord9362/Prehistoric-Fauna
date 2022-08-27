package superlord.prehistoricfauna.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.WorldGenRegistrationHelper;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.world.biome.BiomeData;
import superlord.prehistoricfauna.world.biome.PFBiome;
import superlord.prehistoricfauna.world.biome.PetrifiedForestBiome;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFOverworldBiomes {

	public static List<PFBiomes.PreserveBiomeOrder> biomeList = new ArrayList<>();

	public static final PFBiome PETRIFIED_FOREST = new PetrifiedForestBiome();

	public static Biome PETRIFIED_FOREST_BIOME = WorldGenRegistrationHelper.createBiome("petrified_forest", PETRIFIED_FOREST.getBiome(), 4);

	public static RegistryKey<Biome> PETRIFIED_FOREST_KEY;

	public static void init() {
	}

	public static void addBiomeEntries() {
		BiomeManager.addBiome(PETRIFIED_FOREST.getBiomeType(), new BiomeManager.BiomeEntry(PETRIFIED_FOREST_KEY, PrehistoricFaunaConfig.petrifiedForestWeight));
	}

	@SuppressWarnings("deprecation")
	public static void fillBiomeDictionary() {
		for (BiomeData pfBiomes : PFBiome.biomeData) {
			BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(pfBiomes.getBiome())), pfBiomes.getDictionaryTypes());
		}
	}

}
