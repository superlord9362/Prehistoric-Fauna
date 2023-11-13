package superlord.prehistoricfauna.init;

import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.biome.CretaceousBiomes;
import superlord.prehistoricfauna.common.world.biome.JurassicBiomes;
import superlord.prehistoricfauna.common.world.biome.TriassicBiomes;

public class PFBiomes {
	public static final DeferredRegister<Biome> REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, PrehistoricFauna.MOD_ID);

	public static RegistryObject<Biome> CHINLE_FLATS = REGISTER.register("chinle_flats", TriassicBiomes::chinleFlats);
	public static RegistryObject<Biome> CHINLE_RIVER = REGISTER.register("chinle_river", TriassicBiomes::chinleRiver);
	public static RegistryObject<Biome> CHINLE_SWAMP = REGISTER.register("chinle_swamp", TriassicBiomes::chinleSwamp);
	public static RegistryObject<Biome> CHINLE_WOODED_MOUNTAINS = REGISTER.register("chinle_wooded_mountains", TriassicBiomes::chinleWoodedMountains);
	public static RegistryObject<Biome> ISCHIGUALASTO_RIVER = REGISTER.register("ischigualasto_river", TriassicBiomes::ischigualastoRiver);
	public static RegistryObject<Biome> ISCHIGUALASTO_CLEARING = REGISTER.register("ischigualasto_clearing", TriassicBiomes::ischigualastoClearing);
	public static RegistryObject<Biome> ISCHIGUALASTO_FOREST = REGISTER.register("ischigualasto_forest", TriassicBiomes::ischigualastoForest);
	public static RegistryObject<Biome> ISCHIGUALASTO_HILLS = REGISTER.register("ischigualasto_hills", TriassicBiomes::ischigualastoHills);
	
	public static RegistryObject<Biome> KAYENTA_DRY_FOREST = REGISTER.register("kayenta_dry_forest", JurassicBiomes::kayentaDryForest);
	public static RegistryObject<Biome> KAYENTA_BUTTES = REGISTER.register("kayenta_buttes", JurassicBiomes::kayentaButtes);
	public static RegistryObject<Biome> KAYENTA_DESERT = REGISTER.register("kayenta_desert", JurassicBiomes::kayentaDesert);
	public static RegistryObject<Biome> KAYENTA_RIVER = REGISTER.register("kayenta_river", JurassicBiomes::kayentaRiver);
	public static RegistryObject<Biome> MORRISON_SAVANNA = REGISTER.register("morrison_savanna", JurassicBiomes::morrisonSavanna);
	public static RegistryObject<Biome> MORRISON_HILLS = REGISTER.register("morrison_hills", JurassicBiomes::morrisonHills);
	
	public static RegistryObject<Biome> HELL_CREEK_HARDWOOD_FOREST = REGISTER.register("hell_creek_hardwood_forest", CretaceousBiomes::hellCreekHardwoodForest);
	public static RegistryObject<Biome> HELL_CREEK_CLEARING = REGISTER.register("hell_creek_clearing", CretaceousBiomes::hellCreekClearing);
	public static RegistryObject<Biome> HELL_CREEK_LIRIODENDRITES_HILLS = REGISTER.register("hell_creek_liriodendrites_hills", CretaceousBiomes::hellCreekLiriodendritesHills);
	public static RegistryObject<Biome> HELL_CREEK_REDWOODS = REGISTER.register("hell_creek_redwoods", CretaceousBiomes::hellCreekRedwoods);
	public static RegistryObject<Biome> HELL_CREEK_SWAMP = REGISTER.register("hell_creek_swamp", CretaceousBiomes::hellCreekSwamp);
	public static RegistryObject<Biome> HELL_CREEK_RIVER = REGISTER.register("hell_creek_river", CretaceousBiomes::hellCreekRiver);
	public static RegistryObject<Biome> DJADOCHTA_DUNES = REGISTER.register("djadochta_dunes", CretaceousBiomes::djadochtaDunes);
	public static RegistryObject<Biome> DJADOCHTA_ARROYO = REGISTER.register("djadochta_arroyo", CretaceousBiomes::djadochtaArroyo);
	public static RegistryObject<Biome> YIXIAN_FOREST = REGISTER.register("yixian_forest", CretaceousBiomes::yixianForest);
	public static RegistryObject<Biome> YIXIAN_SNOWY_FOREST = REGISTER.register("yixian_snowy_forest", CretaceousBiomes::yixianSnowyForest);
	public static RegistryObject<Biome> YIXIAN_SNOWY_MOUNTAINS = REGISTER.register("yixian_snowy_mountains", CretaceousBiomes::yixianSnowyMountains);
	public static RegistryObject<Biome> YIXIAN_REGROWTH = REGISTER.register("yixian_regrowth", CretaceousBiomes::yixianRegrowth);
	public static RegistryObject<Biome> YIXIAN_VOLCANO = REGISTER.register("yixian_volcano", CretaceousBiomes::yixianVolcano);
	
	public static RegistryObject<Biome> PREHISTORIC_DRIPSTONE_CAVE = REGISTER.register("prehistoric_dripstone_cave", PFBiomes::prehistoricDripstoneCave);
	
	private static Biome biome(Biome.BiomeCategory category, int waterColor, int waterFogColor, int skyColor, int fogColor, Biome.Precipitation precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.precipitation(precipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.biomeCategory(category)
				.build();
	}
	
	public static Biome prehistoricDripstoneCave() {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();
		return biome(BiomeCategory.NONE, 7372597, 5267523, 15922646, 13622197, Biome.Precipitation.RAIN, 0.9F, 0.9F, spawnSettings, biomeFeatures);
	}
	
}
