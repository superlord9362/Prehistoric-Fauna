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
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.WorldGenRegistrationHelper;
import superlord.prehistoricfauna.world.biome.BiomeData;
import superlord.prehistoricfauna.world.biome.Dummy;
import superlord.prehistoricfauna.world.biome.PFBiome;
import superlord.prehistoricfauna.world.biome.cretaceous.DjadochtaArroyoBiome;
import superlord.prehistoricfauna.world.biome.cretaceous.DjadochtaDunesBiome;
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
import superlord.prehistoricfauna.world.worldtype.PrehistoricWorldTypeBiomeProvider;

public class PFBiomes {

	public static List<PreserveBiomeOrder> biomeList = new ArrayList<>();

	public static Biome DUMMY = WorldGenRegistrationHelper.createBiome("dummy", new Dummy().getBiome(), 2000);
	public static final PFBiome HELL_CREEK_BIOME = new HellCreekBiome(0.2F, 0.1F);
	public static final PFBiome HELL_CREEK_CLEARING_BIOME = new HellCreekClearingBiome();
	public static final PFBiome HELL_CREEK_HILLS_BIOME = new HellCreekHillsBiome();
	public static final PFBiome HELL_CREEK_RIVER_BIOME = new HellCreekRiverBiome();
	public static final PFBiome MORRISON_SAVANNAH_BIOME = new MorrisonSavannahBiome(0.05F, 0.125F);
	public static final PFBiome MORRISON_HILLS_BIOME = new MorrisonSavannahHillsBiome();
	public static final PFBiome ISCHIGUALASTO_FOREST_BIOME = new IschigualastoBiome(0.1F, 0.1F);
	public static final PFBiome ISCHIGUALASTO_CLEARING_BIOME = new IschigualastoClearingBiome();
	public static final PFBiome ISCHIGUALASTO_HILLS_BIOME = new IschigualastoHillsBiome();
	public static final PFBiome ISCHIGUALASTO_RIVER_BIOME = new IschigualastoRiverBiome();
	
	public static final PFBiome DJADOCHTA_DUNES_BIOME = new DjadochtaDunesBiome(0.4F, 0.2F);
	public static final PFBiome DJADOCHTA_ARROYO_BIOME = new DjadochtaArroyoBiome(0.05F, 0.2F);

	//Cretaceous
	public static final Biome HELL_CREEK = WorldGenRegistrationHelper.createBiome("hell_creek", HELL_CREEK_BIOME.getBiome(), 1);
	public static final Biome HELL_CREEK_CLEARING = WorldGenRegistrationHelper.createBiome("hell_creek_clearing", HELL_CREEK_CLEARING_BIOME.getBiome(), 6);
	public static final Biome HELL_CREEK_HILLS = WorldGenRegistrationHelper.createBiome("hell_creek_hills", HELL_CREEK_HILLS_BIOME.getBiome(), 5);
	public static final Biome HELL_CREEK_RIVER = WorldGenRegistrationHelper.createBiome("hell_creek_river", HELL_CREEK_RIVER_BIOME.getBiome(), 7);
	
	public static final Biome DJADOCHTA_DUNES = WorldGenRegistrationHelper.createBiome("djadochta_dunes", DJADOCHTA_DUNES_BIOME.getBiome(), 12);
	public static final Biome DJADOCHTA_ARROYO = WorldGenRegistrationHelper.createBiome("djadochta_arroyo", DJADOCHTA_ARROYO_BIOME.getBiome(), 13);

	//Jurassic
	public static final Biome MORRISON_SAVANNAH = WorldGenRegistrationHelper.createBiome("morrison_savannah", MORRISON_SAVANNAH_BIOME.getBiome(), 2);
	public static final Biome MORRISON_HILLS = WorldGenRegistrationHelper.createBiome("morrison_hills", MORRISON_HILLS_BIOME.getBiome(), 11);

	//Triassic
	public static final Biome ISCHIGUALASTO_FOREST = WorldGenRegistrationHelper.createBiome("ischigualasto_forest", ISCHIGUALASTO_FOREST_BIOME.getBiome(), 3);
	public static final Biome ISCHIGUALASTO_CLEARING = WorldGenRegistrationHelper.createBiome("ischigualasto_clearing", ISCHIGUALASTO_CLEARING_BIOME.getBiome(), 8);
	public static final Biome ISCHIGUALASTO_HILLS = WorldGenRegistrationHelper.createBiome("ischigualasto_hills", ISCHIGUALASTO_HILLS_BIOME.getBiome(), 9);
	public static final Biome ISCHIGUALASTO_RIVER = WorldGenRegistrationHelper.createBiome("ischigualasto_river", ISCHIGUALASTO_RIVER_BIOME.getBiome(), 10);

	public static void init() {
		Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(PrehistoricFauna.MOD_ID, "prehistoric_world"), PrehistoricWorldTypeBiomeProvider.CODEC);
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
