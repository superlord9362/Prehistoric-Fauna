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
import superlord.prehistoricfauna.world.biome.PFBiome;
import superlord.prehistoricfauna.world.biome.cretaceous.HellCreekBiome;
import superlord.prehistoricfauna.world.biome.cretaceous.HellCreekClearingBiome;
import superlord.prehistoricfauna.world.biome.cretaceous.HellCreekHillsBiome;
import superlord.prehistoricfauna.world.biome.cretaceous.HellCreekRiverBiome;
import superlord.prehistoricfauna.world.biome.jurassic.MorrisonSavannahBiome;
import superlord.prehistoricfauna.world.biome.jurassic.MorrisonSavannahHillsBiome;
import superlord.prehistoricfauna.world.biome.triassic.IschigualastoBiome;
import superlord.prehistoricfauna.world.biome.triassic.IschigualastoClearingBiome;
import superlord.prehistoricfauna.world.biome.triassic.IschigualastoHillsBiome;
import superlord.prehistoricfauna.world.biome.triassic.IschigualastoRiverBiome;

public class PFBiomes {

	public static List<PreserveBiomeOrder> biomeList = new ArrayList<>();

	public static Biome DUMMY = WorldGenRegistrationHelper.createBiome("dummy", new Dummy().getBiome(), 2000);

	//Cretaceous
	public static final Biome HELL_CREEK = WorldGenRegistrationHelper.createBiome("hell_creek", new HellCreekBiome(0.2F, 0.1F).getBiome(), 1);
	public static final Biome HELL_CREEK_CLEARING = WorldGenRegistrationHelper.createBiome("hell_creek_clearing", new HellCreekClearingBiome().getBiome(), 6);
	public static final Biome HELL_CREEK_HILLS = WorldGenRegistrationHelper.createBiome("hell_creek_hills", new HellCreekHillsBiome().getBiome(), 5);
	public static final Biome HELL_CREEK_RIVER = WorldGenRegistrationHelper.createBiome("hell_creek_river", new HellCreekRiverBiome().getBiome(), 7);

	//Jurassic
	public static final Biome MORRISON_SAVANNAH = WorldGenRegistrationHelper.createBiome("morrison_savannah", new MorrisonSavannahBiome(0.05F, 0.125F).getBiome(), 2);
	public static final Biome MORRISON_HILLS = WorldGenRegistrationHelper.createBiome("morrison_hills", new MorrisonSavannahHillsBiome().getBiome(), 11);

	//Triassic
	public static final Biome ISCHIGUALASTO_FOREST = WorldGenRegistrationHelper.createBiome("ischigualasto_forest", new IschigualastoBiome(0.1F, 0.1F).getBiome(), 3);
	public static final Biome ISCHIGUALASTO_CLEARING = WorldGenRegistrationHelper.createBiome("ischigualasto_clearing", new IschigualastoClearingBiome().getBiome(), 8);
	public static final Biome ISCHIGUALASTO_HILLS = WorldGenRegistrationHelper.createBiome("ischigualasto_hills", new IschigualastoHillsBiome().getBiome(), 9);
	public static final Biome ISCHIGUALASTO_RIVER = WorldGenRegistrationHelper.createBiome("ischigualasto_river", new IschigualastoRiverBiome().getBiome(), 10);

	public static void init() {
	}

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
