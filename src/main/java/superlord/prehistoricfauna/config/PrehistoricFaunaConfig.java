package superlord.prehistoricfauna.config;

import net.minecraftforge.fml.config.ModConfig;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PrehistoricFaunaConfig {
	
	public static int thescelosaurusSpawnWeight = 12;
	public static int triceratopsSpawnWeight = 16;
	public static int ankylosaurusSpawnWeight = 7;
	public static int tyrannosaurusSpawnWeight = 10;
	public static int basilemysSpawnWeight = 7;
	public static int dakotaraptorSpawnWeight = 2;
	public static int didelphodonSpawnWeight = 6;
	public static int stegosaurusSpawnWeight = 10;
	public static int dryosaurusSpawnWeight = 7;
	public static int ceratosaurusSpawnWeight = 2;
	public static int allosaurusSpawnWeight = 3;
	public static int hesperornithoidesSpawnWeight = 4;
	public static int eilenodonSpawnWeight = 5;
	public static int camarasaurusSpawnWeight = 2;
	public static int exaeretodonSpawnWeight = 12;
	public static int chromogisaurusSpawnWeight = 10;
	public static int herrerasaurusSpawnWeight = 8;
	public static int hyperodapedonSpawnWeight = 15;
	public static int sillosuchusSpawnWeight = 6;
	public static int saurosuchusSpawnWeight = 4;
	public static int ischigualastiaSpawnWeight = 8;
	public static int cretaceousDimensionID = 9;
	public static int jurassicDimensionID = 8;
	public static int triassicDimensionID = 7;
	public static boolean superSecretSetting = false;
	public static int hellCreekHutMinDistance = 7;
	public static int hellCreekHutMaxDistance = 12;
	public static int morrisonHutMinDistance = 7;
	public static int morrisonHutMaxDistance = 12;
	public static int ischigualastoHutMinDistance = 7;
	public static int ischigualastoHutMaxDistance = 12;
	public static boolean spaceTimeContinuumWarping = false;
	
	public static void bakeClient(final ModConfig config) {

	}
	
	public static void bakeServer(final ModConfig config) {
		try {
			thescelosaurusSpawnWeight = PrehistoricConfigHolder.SERVER.thescelosaurusSpawnWeight.get();
			triceratopsSpawnWeight = PrehistoricConfigHolder.SERVER.triceratopsSpawnWeight.get();
			ankylosaurusSpawnWeight = PrehistoricConfigHolder.SERVER.ankylosaurusSpawnWeight.get();
			tyrannosaurusSpawnWeight = PrehistoricConfigHolder.SERVER.tyrannosaurusSpawnWeight.get();
			basilemysSpawnWeight = PrehistoricConfigHolder.SERVER.basilemysSpawnWeight.get();
			dakotaraptorSpawnWeight = PrehistoricConfigHolder.SERVER.dakotaraptorSpawnWeight.get();
			didelphodonSpawnWeight = PrehistoricConfigHolder.SERVER.dideldophodonSpawnWeight.get();
			stegosaurusSpawnWeight = PrehistoricConfigHolder.SERVER.stegosaurusSpawnWeight.get();
			dryosaurusSpawnWeight = PrehistoricConfigHolder.SERVER.dryosaurusSpawnWeight.get();
			ceratosaurusSpawnWeight = PrehistoricConfigHolder.SERVER.ceratosaurusSpawnWeight.get();
			allosaurusSpawnWeight = PrehistoricConfigHolder.SERVER.allosaurusSpawnWeight.get();
			hesperornithoidesSpawnWeight = PrehistoricConfigHolder.SERVER.hesperornithoidesSpawnWeight.get();
			eilenodonSpawnWeight = PrehistoricConfigHolder.SERVER.eilenodonSpawnWeight.get();
			camarasaurusSpawnWeight = PrehistoricConfigHolder.SERVER.camarasaurusSpawnWeight.get();
			exaeretodonSpawnWeight = PrehistoricConfigHolder.SERVER.exaeretodonSpawnWeight.get();
			chromogisaurusSpawnWeight = PrehistoricConfigHolder.SERVER.chromogisaurusSpawnWeight.get();
			herrerasaurusSpawnWeight = PrehistoricConfigHolder.SERVER.herrerasaurusSpawnWeight.get();
			hyperodapedonSpawnWeight = PrehistoricConfigHolder.SERVER.hyperodapedonSpawnWeight.get();
			sillosuchusSpawnWeight = PrehistoricConfigHolder.SERVER.sillosuchusSpawnWeight.get();
			saurosuchusSpawnWeight = PrehistoricConfigHolder.SERVER.saurosuchusSpawnWeight.get();
			ischigualastiaSpawnWeight = PrehistoricConfigHolder.SERVER.ischigualastiaSpawnWeight.get();
			cretaceousDimensionID = PrehistoricConfigHolder.SERVER.cretaceousDimensionID.get();
			jurassicDimensionID = PrehistoricConfigHolder.SERVER.jurassicDimensionID.get();
			triassicDimensionID = PrehistoricConfigHolder.SERVER.triassicDimensionID.get();
			superSecretSetting = PrehistoricConfigHolder.SERVER.superSecretSetting.get();
			hellCreekHutMinDistance = PrehistoricConfigHolder.SERVER.hellCreekHutMinDistance.get();
			hellCreekHutMaxDistance = PrehistoricConfigHolder.SERVER.hellCreekHutMaxDistance.get();
			morrisonHutMinDistance = PrehistoricConfigHolder.SERVER.morrisonHutMinDistance.get();
			morrisonHutMaxDistance = PrehistoricConfigHolder.SERVER.morrisonHutMaxDistance.get();
			ischigualastoHutMinDistance = PrehistoricConfigHolder.SERVER.ischigualastoHutMinDistance.get();
			ischigualastoHutMaxDistance = PrehistoricConfigHolder.SERVER.ischigualastoHutMaxDistance.get();
			spaceTimeContinuumWarping = PrehistoricConfigHolder.SERVER.spaceTimeContinuumWarping.get();
		} catch (Exception e) {
			PrehistoricFauna.LOGGER.warn("An exception was caused trying to load the config for Prehistoric Fauna");
			e.printStackTrace();
		}
	}

}
