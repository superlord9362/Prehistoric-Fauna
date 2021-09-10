package superlord.prehistoricfauna.config;

import net.minecraftforge.fml.config.ModConfig;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PrehistoricFaunaConfig {
	
	public static int thescelosaurusSpawnWeight = 12;
	public static int triceratopsSpawnWeight = 14;
	public static int ankylosaurusSpawnWeight = 7;
	public static int tyrannosaurusSpawnWeight = 10;
	public static int basilemysSpawnWeight = 7;
	public static int dakotaraptorSpawnWeight = 2;
	public static int didelphodonSpawnWeight = 6;
	public static int thescelosaurusClearingSpawnWeight = 10;
	public static int triceratopsClearingSpawnWeight = 15;
	public static int ankylosaurusClearingSpawnWeight = 15;
	public static int basilemysClearingSpawnWeight = 9;
	public static int stegosaurusSpawnWeight = 10;
	public static int dryosaurusSpawnWeight = 7;
	public static int ceratosaurusSpawnWeight = 2;
	public static int allosaurusSpawnWeight = 3;
	public static int hesperornithoidesSpawnWeight = 7;
	public static int eilenodonSpawnWeight = 8;
	public static int camarasaurusSpawnWeight = 2;
	public static int exaeretodonSpawnWeight = 12;
	public static int chromogisaurusSpawnWeight = 10;
	public static int herrerasaurusSpawnWeight = 8;
	public static int hyperodapedonSpawnWeight = 15;
	public static int sillosuchusSpawnWeight = 6;
	public static int saurosuchusSpawnWeight = 4;
	public static int ischigualastiaSpawnWeight = 8;
	public static int trilobiteSentinelSpawnWeight = 5;
	public static int cretaceousDimensionID = 9;
	public static int jurassicDimensionID = 8;
	public static int triassicDimensionID = 7;
	public static boolean superSecretSetting = false;
	public static int hellCreekHutMinDistance = 40;
	public static int hellCreekHutMaxDistance = 60;
	public static int morrisonHutMinDistance = 40;
	public static int morrisonHutMaxDistance = 60;
	public static int ischigualastoHutMinDistance = 40;
	public static int ischigualastoHutMaxDistance = 60;
	public static int geologistCampMinDistance = 25;
	public static int geologistCampMaxDistance = 50;
	public static int timeTempleMinDistance = 75;
	public static int timeTempleMaxDistance = 100;
	public static int portalHubMinDistance = 40;
	public static int portalHubMaxDistance = 60;
	public static boolean spaceTimeContinuumWarping = false;
	public static boolean geologyHammerMining = true;
	public static int baseStoneWeight = 97;
	public static int fossilWeight = 3;
	
	public static void bakeClient(final ModConfig config) {

	}
	
	public static void bakeServer(final ModConfig config) {
		try {
			thescelosaurusSpawnWeight = PFConfigHolder.SERVER.thescelosaurusSpawnWeight.get();
			triceratopsSpawnWeight = PFConfigHolder.SERVER.triceratopsSpawnWeight.get();
			ankylosaurusSpawnWeight = PFConfigHolder.SERVER.ankylosaurusSpawnWeight.get();
			tyrannosaurusSpawnWeight = PFConfigHolder.SERVER.tyrannosaurusSpawnWeight.get();
			basilemysSpawnWeight = PFConfigHolder.SERVER.basilemysSpawnWeight.get();
			dakotaraptorSpawnWeight = PFConfigHolder.SERVER.dakotaraptorSpawnWeight.get();
			didelphodonSpawnWeight = PFConfigHolder.SERVER.dideldophodonSpawnWeight.get();
			thescelosaurusClearingSpawnWeight = PFConfigHolder.SERVER.thescelosaurusClearingSpawnWeight.get();
			triceratopsClearingSpawnWeight = PFConfigHolder.SERVER.triceratopsClearingSpawnWeight.get();
			ankylosaurusClearingSpawnWeight = PFConfigHolder.SERVER.ankylosaurusClearingSpawnWeight.get();
			basilemysClearingSpawnWeight = PFConfigHolder.SERVER.basilemysClearingSpawnWeight.get();
			stegosaurusSpawnWeight = PFConfigHolder.SERVER.stegosaurusSpawnWeight.get();
			dryosaurusSpawnWeight = PFConfigHolder.SERVER.dryosaurusSpawnWeight.get();
			ceratosaurusSpawnWeight = PFConfigHolder.SERVER.ceratosaurusSpawnWeight.get();
			allosaurusSpawnWeight = PFConfigHolder.SERVER.allosaurusSpawnWeight.get();
			hesperornithoidesSpawnWeight = PFConfigHolder.SERVER.hesperornithoidesSpawnWeight.get();
			eilenodonSpawnWeight = PFConfigHolder.SERVER.eilenodonSpawnWeight.get();
			camarasaurusSpawnWeight = PFConfigHolder.SERVER.camarasaurusSpawnWeight.get();
			exaeretodonSpawnWeight = PFConfigHolder.SERVER.exaeretodonSpawnWeight.get();
			chromogisaurusSpawnWeight = PFConfigHolder.SERVER.chromogisaurusSpawnWeight.get();
			herrerasaurusSpawnWeight = PFConfigHolder.SERVER.herrerasaurusSpawnWeight.get();
			hyperodapedonSpawnWeight = PFConfigHolder.SERVER.hyperodapedonSpawnWeight.get();
			sillosuchusSpawnWeight = PFConfigHolder.SERVER.sillosuchusSpawnWeight.get();
			saurosuchusSpawnWeight = PFConfigHolder.SERVER.saurosuchusSpawnWeight.get();
			ischigualastiaSpawnWeight = PFConfigHolder.SERVER.ischigualastiaSpawnWeight.get();
			trilobiteSentinelSpawnWeight = PFConfigHolder.SERVER.trilobiteSentinelSpawnWeight.get();
			cretaceousDimensionID = PFConfigHolder.SERVER.cretaceousDimensionID.get();
			jurassicDimensionID = PFConfigHolder.SERVER.jurassicDimensionID.get();
			triassicDimensionID = PFConfigHolder.SERVER.triassicDimensionID.get();
			superSecretSetting = PFConfigHolder.SERVER.superSecretSetting.get();
			hellCreekHutMinDistance = PFConfigHolder.SERVER.hellCreekHutMinDistance.get();
			hellCreekHutMaxDistance = PFConfigHolder.SERVER.hellCreekHutMaxDistance.get();
			morrisonHutMinDistance = PFConfigHolder.SERVER.morrisonHutMinDistance.get();
			morrisonHutMaxDistance = PFConfigHolder.SERVER.morrisonHutMaxDistance.get();
			ischigualastoHutMinDistance = PFConfigHolder.SERVER.ischigualastoHutMinDistance.get();
			ischigualastoHutMaxDistance = PFConfigHolder.SERVER.ischigualastoHutMaxDistance.get();
			geologistCampMinDistance = PFConfigHolder.SERVER.geologistCampMinDistance.get();
			geologistCampMaxDistance = PFConfigHolder.SERVER.geologistCampMaxDistance.get();
			timeTempleMinDistance = PFConfigHolder.SERVER.timeTempleMinDistance.get();
			timeTempleMaxDistance = PFConfigHolder.SERVER.timeTempleMaxDistance.get();
			portalHubMinDistance = PFConfigHolder.SERVER.portalHubMinDistance.get();
			portalHubMaxDistance = PFConfigHolder.SERVER.portalHubMaxDistance.get();
			spaceTimeContinuumWarping = PFConfigHolder.SERVER.spaceTimeContinuumWarping.get();
			geologyHammerMining = PFConfigHolder.SERVER.geologyHammerMining.get();
			baseStoneWeight = PFConfigHolder.SERVER.baseStoneWeight.get();
			fossilWeight = PFConfigHolder.SERVER.fossilWeight.get();
		} catch (Exception e) {
			PrehistoricFauna.LOGGER.warn("An exception was caused trying to load the config for Prehistoric Fauna");
			e.printStackTrace();
		}
	}
	
}
