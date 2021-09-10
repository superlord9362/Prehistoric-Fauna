package superlord.prehistoricfauna.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
	
	public final ForgeConfigSpec.IntValue thescelosaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue triceratopsSpawnWeight;
	public final ForgeConfigSpec.IntValue ankylosaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue tyrannosaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue basilemysSpawnWeight;
	public final ForgeConfigSpec.IntValue dakotaraptorSpawnWeight;
	public final ForgeConfigSpec.IntValue dideldophodonSpawnWeight;
	public final ForgeConfigSpec.IntValue thescelosaurusClearingSpawnWeight;
	public final ForgeConfigSpec.IntValue triceratopsClearingSpawnWeight;
	public final ForgeConfigSpec.IntValue ankylosaurusClearingSpawnWeight;
	public final ForgeConfigSpec.IntValue basilemysClearingSpawnWeight;
	public final ForgeConfigSpec.IntValue stegosaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue dryosaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue ceratosaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue allosaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue hesperornithoidesSpawnWeight;
	public final ForgeConfigSpec.IntValue eilenodonSpawnWeight;
	public final ForgeConfigSpec.IntValue camarasaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue exaeretodonSpawnWeight;
	public final ForgeConfigSpec.IntValue chromogisaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue herrerasaurusSpawnWeight;
	public final ForgeConfigSpec.IntValue hyperodapedonSpawnWeight;
	public final ForgeConfigSpec.IntValue sillosuchusSpawnWeight;
	public final ForgeConfigSpec.IntValue saurosuchusSpawnWeight;
	public final ForgeConfigSpec.IntValue ischigualastiaSpawnWeight;
	public final ForgeConfigSpec.IntValue trilobiteSentinelSpawnWeight;
	public final ForgeConfigSpec.BooleanValue superSecretSetting;
	public final ForgeConfigSpec.IntValue cretaceousDimensionID;
	public final ForgeConfigSpec.IntValue jurassicDimensionID;
	public final ForgeConfigSpec.IntValue triassicDimensionID;
	public final ForgeConfigSpec.IntValue hellCreekHutMinDistance;
	public final ForgeConfigSpec.IntValue hellCreekHutMaxDistance;
	public final ForgeConfigSpec.IntValue morrisonHutMinDistance;
	public final ForgeConfigSpec.IntValue morrisonHutMaxDistance;
	public final ForgeConfigSpec.IntValue ischigualastoHutMinDistance;
	public final ForgeConfigSpec.IntValue ischigualastoHutMaxDistance;
	public final ForgeConfigSpec.IntValue geologistCampMinDistance;
	public final ForgeConfigSpec.IntValue geologistCampMaxDistance;
	public final ForgeConfigSpec.IntValue timeTempleMinDistance;
	public final ForgeConfigSpec.IntValue timeTempleMaxDistance;
	public final ForgeConfigSpec.IntValue portalHubMinDistance;
	public final ForgeConfigSpec.IntValue portalHubMaxDistance;
	public final ForgeConfigSpec.BooleanValue spaceTimeContinuumWarping;
	public final ForgeConfigSpec.BooleanValue geologyHammerMining;
	public final ForgeConfigSpec.IntValue baseStoneWeight;
	public final ForgeConfigSpec.IntValue fossilWeight;
	
	public ServerConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("general");
		this.thescelosaurusSpawnWeight = buildInt(builder, "Thescelosaurus Spawn Weight", "all", 12, 1, 300, "The weight of Thescelosaurus in vanilla's spawn rate. Default is 12");
		this.triceratopsSpawnWeight = buildInt(builder, "Triceratops Spawn Weight", "all", 14, 1, 300, "The weight of Triceratops in vanilla's spawn rate. Default is 14");
		this.ankylosaurusSpawnWeight = buildInt(builder, "Ankylosaurus Spawn Weight", "all", 7, 1, 300, "The weight of Ankylosaurus in vanilla's spawn rate. Default is 7");
		this.tyrannosaurusSpawnWeight = buildInt(builder, "Tyrannosaurus Spawn Weight", "all", 10, 1, 300, "The weight of Tyrannosaurus in vanilla's spawn rate. Default is 10");
		this.basilemysSpawnWeight = buildInt(builder, "Basilemys Spawn Weight", "all", 7, 1, 300, "The weight of Basilemys in vanilla's spawn rate. Default is 7");
		this.dakotaraptorSpawnWeight = buildInt(builder, "Dakotaraptor Spawn Weight", "all", 2, 1, 300, "The weight of Dakotaraptor in vanilla's spawn rate. Default is 2");
		this.dideldophodonSpawnWeight = buildInt(builder, "Didelphodon Spawn Weight", "all", 6, 1, 300, "The weight of Didelphodon in vanilla's spawn rate. Default is 6");
		this.thescelosaurusClearingSpawnWeight = buildInt(builder, "Thescelosaurus Clearing Spawn Weight", "all", 10, 1, 300, "The weight of Thescelosaurus in vanilla's spawn rate in the Clearing Sub-biome. Default is 10");
		this.triceratopsClearingSpawnWeight = buildInt(builder, "Triceratops Clearing Spawn Weight", "all", 15, 1, 300, "The weight of Triceratops in vanilla's spawn rate in the Clearing Sub-biome. Default is 15");
		this.ankylosaurusClearingSpawnWeight = buildInt(builder, "Ankylosaurus Clearing Spawn Weight", "all", 15, 1, 300, "The weight of Ankylosaurus in vanilla's spawn rate in the Clearing Sub-biome. Default is 15");
		this.basilemysClearingSpawnWeight = buildInt(builder, "Basilemys Clearing Spawn Weight", "all", 9, 1, 300, "The weight of Basilemys in vanilla's spawn rate in the Clearing Sub-biome. Default is 9");
		this.stegosaurusSpawnWeight = buildInt(builder, "Stegosaurus Spawn Weight", "all", 10, 1, 300, "The weight of Stegosaurus in vanilla's spawn rate. Default is 10");
		this.dryosaurusSpawnWeight = buildInt(builder, "Dryosaurus Spawn Weight", "all", 7, 1, 300, "The weight of Dryosaurus in vanilla's spawn rate. Default is 7");
		this.ceratosaurusSpawnWeight = buildInt(builder, "Ceratosaurus Spawn Weight", "all", 2, 1, 300, "The weight of Ceratosaurus in vanilla's spawn rate. Default is 2");
		this.allosaurusSpawnWeight = buildInt(builder, "Allosaurus Spawn Weight", "all", 3, 1, 300, "The weight of Allosaurus in vanilla's spawn rate. Default is 3");
		this.hesperornithoidesSpawnWeight = buildInt(builder, "Hesperornithoides Spawn Rate", "all", 7, 1, 300, "The weight of Hesperornithoides in vanilla's spawn rate. Default is 4");
		this.eilenodonSpawnWeight = buildInt(builder, "Eilenodon Spawn Weight", "all", 8, 1, 300, "The weight of Eilenodon in vanilla's spawn rate. Default is 5");
		this.camarasaurusSpawnWeight = buildInt(builder, "Camarasaurus Spawn Weight", "all", 2, 1, 300, "The weight of Camarasaurus in vanilla's spawn rate. Default is 2");
		this.exaeretodonSpawnWeight = buildInt(builder, "Exaeretodon Spawn Weight", "all", 12, 1, 300, "The weight of Exaeretodon in vanilla's spawn rate. Default is 12");
		this.chromogisaurusSpawnWeight = buildInt(builder, "Chromogisaurus Spawn Weight", "all", 10, 1, 300, "The weight of Chromogisaurus in vanilla's spawn rate. Default is 10");
		this.herrerasaurusSpawnWeight = buildInt(builder, "Herrerasaurus Spawn Weight", "all", 8, 1, 300, "The weight of Herrerasaurus in vanilla's spawn rate. Default is 8");
		this.hyperodapedonSpawnWeight = buildInt(builder, "Hyperodapedon Spawn Weight", "all", 15, 1, 300, "The weight of Hyperodapedon in vanilla's spawn rate. Default is 15");
		this.sillosuchusSpawnWeight = buildInt(builder, "Sillosuchus Spawn Weight", "all", 6, 1, 300, "The weight of Sillosuchus in vanilla's spawn rate. Default is 6");
		this.saurosuchusSpawnWeight = buildInt(builder, "Saurosuchus Spawn Weight", "all", 4, 1, 300, "The weight of Saurosuchus in vanilla's spawn rate. Default is 4");
		this.ischigualastiaSpawnWeight = buildInt(builder, "Ischigualastia Spawn Weight", "all", 8, 1, 300, "The weight of Ischigualastia in vanilla's spawn rate. Default is 8");
		this.trilobiteSentinelSpawnWeight = buildInt(builder, "Henos Trilobite Sentinel Spawn Weight", "all", 5, 1, 300, "The weight of Henos Trilobite Sentinels in vanilla's spawn rate. Default is 5");
		this.superSecretSetting = buildBoolean(builder, "Super Secret Setting", "all", false, "Even I don't know what it does. Default is false");
		this.cretaceousDimensionID = buildInt(builder, "Cretaceous Dimension ID", "all", 9, Integer.MIN_VALUE, Integer.MAX_VALUE, "Cretaceous Dimension ID. Default is 9");
		this.jurassicDimensionID = buildInt(builder, "Jurassic Dimension ID", "all", 8, Integer.MIN_VALUE, Integer.MAX_VALUE, "Jurassic Dimension ID. Default is 8");
		this.triassicDimensionID = buildInt(builder, "Triassic Dimension ID", "all", 7, Integer.MIN_VALUE, Integer.MAX_VALUE, "Triassic Dimension ID. Default is 7");
		this.hellCreekHutMinDistance = buildInt(builder, "Hell Creek Ruined Time Traveller's Hut Min Distance", "all", 40, 1, 300, "The closest two Hell Creek Ruined Time Traveller's Huts can spawn from eachother. Keep this value lower than the max. Default is 40");
		this.hellCreekHutMaxDistance = buildInt(builder, "Hell Creek Ruined Time Traveller's Hut Max Distance", "all", 60, 1, 300, "The farthest two Hell Creek Ruined Time Traveller's Huts can spawn from eachother. Keep this value higher than the min. Default is 60");
		this.morrisonHutMinDistance = buildInt(builder, "Morrison Ruined Time Traveller's Hut Min Distance", "all", 40, 1, 300, "The closest two Morrison Ruined Time Traveller's Huts can spawn from eachother. Keep this value lower than the max. Default is 40");
		this.morrisonHutMaxDistance = buildInt(builder, "Morrison Ruined Time Traveller's Hut Max Distance", "all", 60, 1, 300, "The farthest two Morrison Ruined Time Traveller's Huts can spawn from eachother. Keep this value higher than the min. Default is 60");
		this.ischigualastoHutMinDistance = buildInt(builder, "Ischigualasto Ruined Time Traveller's Hut Min Distance", "all", 40, 1, 300, "The closest two Ischigualasto Ruined Time Traveller's Huts can spawn from eachother. Keep this value lower than the max. Default is 40");
		this.ischigualastoHutMaxDistance = buildInt(builder, "Ischigualasto Ruined Time Traveller's Hut Max Distance", "all", 60, 1, 300, "The farthest two Ischigualasto Ruined Time Traveller's Huts can spawn from eachother. Keep this value higher than the min. Default is 60");
		this.geologistCampMinDistance = buildInt(builder, "Geologist Camp Min Distance", "all", 25, 1, 300, "The closest two Geologist Camps can spawn from eachother. Keep this value lower than the max. Default is 25");
		this.geologistCampMaxDistance = buildInt(builder, "Geologist Camp Max Distance", "all", 50, 1, 300, "The farthest two Geologist Camps can spawn from eachother. Keep this value higher than the min. Default is 50");
		this.timeTempleMinDistance = buildInt(builder, "Time Temple Min Distance", "all", 75, 1, 300, "The closest two Time Temples can spawn from eachother. Keep this value lower than the max. Default is 75");
		this.timeTempleMaxDistance = buildInt(builder, "Time Temple Max Distance", "all", 100, 1, 300, "The farthest two Time Temples can spawn from eachother. Keep this value higher than the min. Default is 100");
		this.portalHubMinDistance = buildInt(builder, "Portal Hub Min Distance", "all", 40, 1, 300, "The closest two Portal Hubs can spawn from eachother. Keep this value lower than the max. Default is 40");
		this.portalHubMaxDistance = buildInt(builder, "Portal Hub Hut Max Distance", "all", 60, 1, 300, "The farthest two Portal Hubs can spawn from eachother. Keep this value higher than the min. Default is 60");
		this.spaceTimeContinuumWarping = buildBoolean(builder, "Space Time Continuum Warping", "all", false, "Warning: Messing with the time space continuum may lead to unforseen consequences. Recommended to keep false for servers. Default is false");
		this.geologyHammerMining = buildBoolean(builder, "Geological Hammer Stone Breaking", "all", true, "Toggles whether stones can be broken down using the Geological Hammer. Default is true");
		this.baseStoneWeight = buildInt(builder, "Base Stone Weight", "all", 97, 1, 300, "The probability of an ancient stone deposit is made up of the base stone. To find the percentage probability, add the base stone weight with the fossil weight, and then divide the base stone weight by the combined weights. Default is 97");
		this.fossilWeight = buildInt(builder, "Fossil Weight", "all", 3, 1, 300, "The probability of an ancient stone deposit is made up of the fossilized stone. To find the percentage probability, add the base stone weight with the fossil weight, and then divide the fossil stone weight by the combined weights. Default is 3");
	}
	
	private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String catagory, boolean defaultValue, String comment){
		return builder.comment(comment).translation(name).define(name, defaultValue);
	}

	private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String catagory, int defaultValue, int min, int max, String comment){
		return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
	}

	@SuppressWarnings("unused")
	private static ForgeConfigSpec.DoubleValue buildDouble(ForgeConfigSpec.Builder builder, String name, String catagory, double defaultValue, double min, double max, String comment){
		return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
	}
	
}
