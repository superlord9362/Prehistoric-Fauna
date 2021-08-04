package superlord.prehistoricfauna.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import superlord.prehistoricfauna.common.world.WorldGenRegistrationHelper;
import superlord.prehistoricfauna.world.biome.BiomeData;
import superlord.prehistoricfauna.world.biome.Dummy;
import superlord.prehistoricfauna.world.biome.HellCreekBiome;
import superlord.prehistoricfauna.world.biome.HellCreekRiverBiome;
import superlord.prehistoricfauna.world.biome.PFBiome;

public class PFBiomes {

	public static List<PreserveBiomeOrder> biomeList = new ArrayList<>();

	public static Biome DUMMY = WorldGenRegistrationHelper.createBiome("dummy", new Dummy().getBiome(), 2000);

	//Cretaceous
	public static final Biome HELL_CREEK = WorldGenRegistrationHelper.createBiome("hell_creek", new HellCreekBiome(0.2F, 0.1F, false, false).getBiome(), 1);
	public static final Biome HELL_CREEK_CLEARING = WorldGenRegistrationHelper.createBiome("hell_creek_clearing", new HellCreekBiome(0.1F, 0.1F, true, false).getBiome(), 6);
	public static final Biome HELL_CREEK_HILLS = WorldGenRegistrationHelper.createBiome("hell_creek_hills", new HellCreekBiome(0.3F, 0.7F, false, true).getBiome(), 5);
	public static final Biome HELL_CREEK_RIVER = WorldGenRegistrationHelper.createBiome("hell_creek_river", new HellCreekRiverBiome().getBiome(), 7);

	/**
	//Jurassic
	public static final Biome MORRISON_SAVANNAH = WorldGenRegistrationHelper.createBiome("morrison_savannah", JurassicBiomes.morrisonSavannah(0.05F, 0.125F, false), 2);
	public static final Biome MORRISON_HILLS = WorldGenRegistrationHelper.createBiome("morrison_hills", JurassicBiomes.morrisonSavannah(0.1F, 0.2F, true), 11);

	//Triassic
	public static final Biome ISCHIGUALASTO_FOREST = WorldGenRegistrationHelper.createBiome("ischigualasto_forest", TriassicBiomes.ischigualastoForest(0.1F, 0.1F, false), 3);
	public static final Biome ISCHIGUALASTO_CLEARING = WorldGenRegistrationHelper.createBiome("ischigualasto_clearing", TriassicBiomes.ischgualastoForest(0.1F, 0.1F, true), 8);
	public static final Biome ISCHIGUALASTO_HILLS = WorldGenRegistrationHelper.createBiome("ischigualasto_hills", TriassicBiomes.ischigualastoHills(0.3F, 0.5F, false), 9);
	public static final Biome ISCHIGUALASTO_RIVER = WorldGenRegistrationHelper.createBiome("ischigualasto_river", TriassicBiomes.ischigualastoRiver(0.05F, -0.6F), 10);
	 */

	@SuppressWarnings({ "unused", "deprecation" })
	public static void addBiomeEntries() {
		for(BiomeData biomeData : PFBiome.biomeData) {
			List<BiomeDictionary.Type> dictionaryList = Arrays.stream(biomeData.getDictionaryTypes()).collect(Collectors.toList());
			ResourceLocation key = WorldGenRegistries.BIOME.getKey(biomeData.getBiome());
			if (biomeData.getBiomeWeight() > 0) {
				BiomeManager.addBiome(biomeData.getBiomeType(), new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, key), biomeData.getBiomeWeight()));
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void fillBiomeDictionary() {
		for (BiomeData pfBiomes : PFBiome.biomeData) {
			BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(pfBiomes.getBiome())), pfBiomes.getDictionaryTypes());
		}
	}

	public static void init() {
	}

	public static class PreserveBiomeOrder {
		private final Biome biome;
		private final int orderPosition;

		public PreserveBiomeOrder(Biome biome, int orderPosition) {
			this.biome = biome;
			this.orderPosition = orderPosition;
		}

		public Biome getBiome() {
			return biome;
		}

		public int getOrderPosition() {
			return orderPosition;
		}

	}

}
