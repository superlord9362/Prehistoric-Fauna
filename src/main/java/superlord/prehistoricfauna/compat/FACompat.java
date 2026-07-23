package superlord.prehistoricfauna.compat;

import com.github.teamfossilsarcheology.fossil.food.FoodMappingsManager;

import superlord.prehistoricfauna.init.PFItems;

public class FACompat {

	public static void register(FoodMappingsManager manager) {
		manager.addMeat(PFItems.RAW_SMALL_THYREOPHORAN_MEAT.get());
		manager.addMeat(PFItems.RAW_LARGE_THYREOPHORAN_MEAT.get());
		manager.addMeat(PFItems.RAW_SMALL_MARGINOCEPHALIAN_MEAT.get());
		manager.addMeat(PFItems.RAW_LARGE_MARGINOCEPHALIAN_MEAT.get());
		manager.addMeat(PFItems.RAW_SMALL_ORNITHISCHIAN_MEAT.get());
		manager.addMeat(PFItems.RAW_LARGE_ORNITHISCHIAN_MEAT.get());
		manager.addMeat(PFItems.RAW_SMALL_SAUROPOD_MEAT.get());
		manager.addMeat(PFItems.RAW_LARGE_SAUROPOD_MEAT.get());
		manager.addMeat(PFItems.RAW_SMALL_THEROPOD_MEAT.get());
		manager.addMeat(PFItems.RAW_LARGE_THEROPOD_MEAT.get());
		manager.addMeat(PFItems.RAW_SMALL_ARCHOSAUROMORPH_MEAT.get());
		manager.addMeat(PFItems.RAW_LARGE_ARCHOSAUROMORPH_MEAT.get());
		manager.addMeat(PFItems.RAW_SMALL_REPTILE_MEAT.get());
		manager.addMeat(PFItems.RAW_SMALL_SYNAPSID_MEAT.get());
		manager.addMeat(PFItems.RAW_LARGE_SYNAPSID_MEAT.get());
		
		manager.addFish(PFItems.CERATODUS.get());
		manager.addFish(PFItems.CYCLURUS.get());
		manager.addFish(PFItems.LEPISOSTEUS.get());
		manager.addFish(PFItems.MYLEDAPHUS.get());
		manager.addFish(PFItems.POTAMOCERATODUS.get());
		manager.addFish(PFItems.SAURICHTHYS.get());
		manager.addFish(PFItems.CHINLEA.get());
		manager.addFish(PFItems.MOOREODONTUS.get());
		manager.addFish(PFItems.ARGANODUS.get());
		manager.addFish(PFItems.MELVIUS.get());
		manager.addFish(PFItems.LONCHIDION.get());
		manager.addFish(PFItems.ACIPENSER.get());
		manager.addFish(PFItems.HARENAICHTHYS.get());
		manager.addFish(PFItems.PROTOPSEPHURUS.get());
		manager.addFish(PFItems.SINAMIA.get());
		manager.addFish(PFItems.YANOSTEUS.get());
		manager.addFish(PFItems.PARAPSEPHURUS.get());
		manager.addFish(PFItems.CHUNGKINGICHTHYS.get());
		manager.addFish(PFItems.LEPIDOTES.get());
		manager.addFish(PFItems.MORROLEPIS.get());
		manager.addFish(PFItems.OPHIOPSIS.get());
		manager.addFish(PFItems.TOARCIBATIS.get());
		
		manager.addPlant(PFItems.TUBER.get());
		manager.addPlant(PFItems.FIDDLEHEAD.get());
		manager.addPlant(PFItems.EPHEDRA_BERRIES.get());
		manager.addPlant(PFItems.GINKGO_BERRY.get());
		manager.addPlant(PFItems.BASSITHECA_BERRIES.get());
	}
	
}


