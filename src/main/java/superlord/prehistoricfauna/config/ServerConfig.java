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
	public final ForgeConfigSpec.BooleanValue spaceTimeContinuumWarping;
	
	public ServerConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("general");
		this.thescelosaurusSpawnWeight = buildInt(builder, "Thescelosaurus Spawn Weight", "all", 12, 1, 300, "The weight of Thescelosaurus in vanilla's spawn rate");
		this.triceratopsSpawnWeight = buildInt(builder, "Triceratops Spawn Weight", "all", 16, 1, 300, "The weight of Triceratops in vanilla's spawn rate");
		this.ankylosaurusSpawnWeight = buildInt(builder, "Ankylosaurus Spawn Weight", "all", 7, 1, 300, "The weight of Ankylosaurus in vanilla's spawn rate");
		this.tyrannosaurusSpawnWeight = buildInt(builder, "Tyrannosaurus Spawn Weight", "all", 10, 1, 300, "The weight of Tyrannosaurus in vanilla's spawn rate");
		this.basilemysSpawnWeight = buildInt(builder, "Basilemys Spawn Weight", "all", 7, 1, 300, "The weight of Basilemys in vanilla's spawn rate");
		this.dakotaraptorSpawnWeight = buildInt(builder, "Dakotaraptor Spawn Weight", "all", 2, 1, 300, "The weight of Dakotaraptor in vanilla's spawn rate");
		this.dideldophodonSpawnWeight = buildInt(builder, "Didelphodon Spawn Weight", "all", 6, 1, 300, "The weight of Didelphodon in vanilla's spawn rate");
		this.stegosaurusSpawnWeight = buildInt(builder, "Stegosaurus Spawn Weight", "all", 10, 1, 300, "The weight of Stegosaurus in vanilla's spawn rate");
		this.dryosaurusSpawnWeight = buildInt(builder, "Dryosaurus Spawn Weight", "all", 7, 1, 300, "The weight of Dryosaurus in vanilla's spawn rate");
		this.ceratosaurusSpawnWeight = buildInt(builder, "Ceratosaurus Spawn Weight", "all", 2, 1, 300, "The weight of Ceratosaurus in vanilla's spawn rate");
		this.allosaurusSpawnWeight = buildInt(builder, "Allosaurus Spawn Weight", "all", 3, 1, 300, "The weight of Allosaurus in vanilla's spawn rate");
		this.hesperornithoidesSpawnWeight = buildInt(builder, "Hesperornithoides Spawn Rate", "all", 4, 1, 300, "The weight of Hesperornithoides in vanilla's spawn rate");
		this.eilenodonSpawnWeight = buildInt(builder, "Eilenodon Spawn Weight", "all", 5, 1, 300, "The weight of Eilenodon in vanilla's spawn rate");
		this.camarasaurusSpawnWeight = buildInt(builder, "Camarasaurus Spawn Weight", "all", 2, 1, 300, "The weight of Camarasaurus in vanilla's spawn rate");
		this.exaeretodonSpawnWeight = buildInt(builder, "Exaeretodon Spawn Weight", "all", 12, 1, 300, "The weight of Exaeretodon in vanilla's spawn rate");
		this.chromogisaurusSpawnWeight = buildInt(builder, "Chromogisaurus Spawn Weight", "all", 10, 1, 300, "The weight of Chromogisaurus in vanilla's spawn rate");
		this.herrerasaurusSpawnWeight = buildInt(builder, "Herrerasaurus Spawn Weight", "all", 8, 1, 300, "The weight of Herrerasaurus in vanilla's spawn rate");
		this.hyperodapedonSpawnWeight = buildInt(builder, "Hyperodapedon Spawn Weight", "all", 15, 1, 300, "The weight of Hyperodapedon in vanilla's spawn rate");
		this.sillosuchusSpawnWeight = buildInt(builder, "Sillosuchus Spawn Weight", "all", 6, 1, 300, "The weight of Sillosuchus in vanilla's spawn rate");
		this.saurosuchusSpawnWeight = buildInt(builder, "Saurosuchus Spawn Weight", "all", 4, 1, 300, "The weight of Saurosuchus in vanilla's spawn rate");
		this.ischigualastiaSpawnWeight = buildInt(builder, "Ischigualastia Spawn Weight", "all", 8, 1, 300, "The weight of Ischigualastia in vanilla's spawn rate");
		this.superSecretSetting = buildBoolean(builder, "Super Secret Setting", "all", false, "Even I don't know what it does");
		this.cretaceousDimensionID = buildInt(builder, "Cretaceous Dimension ID", "all", 9, Integer.MIN_VALUE, Integer.MAX_VALUE, "Cretaceous Dimension ID");
		this.jurassicDimensionID = buildInt(builder, "Jurassic Dimension ID", "all", 8, Integer.MIN_VALUE, Integer.MAX_VALUE, "Jurassic Dimension ID");
		this.triassicDimensionID = buildInt(builder, "Triassic Dimension ID", "all", 7, Integer.MIN_VALUE, Integer.MAX_VALUE, "Triassic Dimension ID");
		this.hellCreekHutMinDistance = buildInt(builder, "Hell Creek Ruined Time Traveller's Hut Min Distance", "all", 7, 1, 300, "The closest two Hell Creek Ruined Time Traveller's Huts can spawn from eachother. Keep this value lower than the max");
		this.hellCreekHutMaxDistance = buildInt(builder, "Hell Creek Ruined Time Traveller's Hut Max Distance", "all", 12, 1, 300, "The farthest two Hell Creek Ruined Time Traveller's Huts can spawn from eachother. Keep this value higher than the min");
		this.morrisonHutMinDistance = buildInt(builder, "Morrison Ruined Time Traveller's Hut Min Distance", "all", 7, 1, 300, "The closest two Morrison Ruined Time Traveller's Huts can spawn from eachother. Keep this value lower than the max");
		this.morrisonHutMaxDistance = buildInt(builder, "Morrison Ruined Time Traveller's Hut Max Distance", "all", 12, 1, 300, "The farthest two Morrison Ruined Time Traveller's Huts can spawn from eachother. Keep this value higher than the min");
		this.ischigualastoHutMinDistance = buildInt(builder, "Ischigualasto Ruined Time Traveller's Hut Min Distance", "all", 7, 1, 300, "The closest two Ischigualasto Ruined Time Traveller's Huts can spawn from eachother. Keep this value lower than the max");
		this.ischigualastoHutMaxDistance = buildInt(builder, "Ischigualasto Ruined Time Traveller's Hut Max Distance", "all", 12, 1, 300, "The farthest two Ischigualasto Ruined Time Traveller's Huts can spawn from eachother. Keep this value higher than the min");
		this.spaceTimeContinuumWarping = buildBoolean(builder, "Space Time Continuum Warping", "all", false, "Warning: Messing with the time space continuum may lead to unforseen consequences. Recommended to keep false for servers.");
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
