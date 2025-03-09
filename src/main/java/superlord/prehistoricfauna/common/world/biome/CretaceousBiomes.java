package superlord.prehistoricfauna.common.world.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFPlacedFeatures;
import superlord.prehistoricfauna.init.PFSounds;

public class CretaceousBiomes {

	private static Biome biome(boolean hasPrecipitation, int waterColor, int waterFogColor, int skyColor, int fogColor, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.hasPrecipitation(hasPrecipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.ambientMoodSound(new AmbientMoodSettings(PFSounds.CAVE_1.getHolder().get(), 6000, 8, 2.0D))
						.backgroundMusic(Musics.createGameMusic(PFSounds.AMBIENCE_1.getHolder().get()))
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}
	
	private static Biome volcanoBiome(boolean hasPrecipitation, int waterColor, int waterFogColor, int skyColor, int fogColor, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.hasPrecipitation(hasPrecipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.ambientMoodSound(new AmbientMoodSettings(PFSounds.CAVE_1.getHolder().get(), 6000, 8, 2.0D))
						.backgroundMusic(Musics.createGameMusic(PFSounds.AMBIENCE_1.getHolder().get()))
						.ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.118093334F))
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}
	
	private static Biome biome(boolean hasPrecipitation, int waterColor, int waterFogColor, int skyColor, int fogColor, int foliageColor, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder) {
		return (new Biome.BiomeBuilder())
				.hasPrecipitation(hasPrecipitation)
				.temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(waterColor)
						.waterFogColor(waterFogColor)
						.fogColor(fogColor)
						.skyColor(skyColor)
						.foliageColorOverride(foliageColor)
						.grassColorOverride(foliageColor)
						.ambientMoodSound(new AmbientMoodSettings(PFSounds.CAVE_1.getHolder().get(), 6000, 8, 2.0D))
						.backgroundMusic(Musics.createGameMusic(PFSounds.AMBIENCE_1.getHolder().get()))
						.build())
				.mobSpawnSettings(spawnBuilder.build())
				.generationSettings(biomeBuilder.build())
				.build();
	}
	
	public static Biome hellCreekHardwoodForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withHellCreekHardwoodForestPlants(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.MUD_DISK);
		if (PrehistoricFaunaConfig.caveSentinelHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekHardwoodForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekHardwoodForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.acipenserHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekHardwoodForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ankylosaurusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekHardwoodForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.anzuHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekHardwoodForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.basilemysHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekHardwoodForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.cephaloleichnitesHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CEPHALOLEICHNITES.get(), PrehistoricFaunaConfig.cephaloleichnitesHellCreekHardwoodForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cyclurusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekHardwoodForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.dakotaraptorHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekHardwoodForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.didelphodonHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekHardwoodForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.edmontosaurusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekHardwoodForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.lepisosteusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekHardwoodForestSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.lonchidionHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekHardwoodForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.melviusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekHardwoodForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.myledaphusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekHardwoodForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ornithomimusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekHardwoodForestSpawnWeight, 3, 6));
		if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekHardwoodForestSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.palaeosaniwaHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekHardwoodForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.parapsephurusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PARAPSEPHURUS.get(), PrehistoricFaunaConfig.parapsephurusHellCreekHardwoodForestSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.thescelosaurusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekHardwoodForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.brachychampsaHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BRACHYCHAMPSA.get(), PrehistoricFaunaConfig.brachychampsaHellCreekHardwoodForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.triceratopsHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekHardwoodForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.tyrannosaurusHellCreekHardwoodForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekHardwoodForestSpawnWeight, 1, 2));
		return biome(true, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, 0x53711f, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekClearing(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withHellCreekClearingPlants(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.MUD_DISK);
		if (PrehistoricFaunaConfig.caveSentinelHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekClearingSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekClearingSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.acipenserHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ankylosaurusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.anzuHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekClearingSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.basilemysHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.cephaloleichnitesHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CEPHALOLEICHNITES.get(), PrehistoricFaunaConfig.cephaloleichnitesHellCreekClearingSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cyclurusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekClearingSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.dakotaraptorHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.didelphodonHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekClearingSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.edmontosaurusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekClearingSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.lepisosteusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekClearingSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.lonchidionHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.melviusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.myledaphusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ornithomimusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekClearingSpawnWeight, 3, 6));
		if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekClearingSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.palaeosaniwaHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.parapsephurusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PARAPSEPHURUS.get(), PrehistoricFaunaConfig.parapsephurusHellCreekClearingSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.thescelosaurusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekClearingSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.brachychampsaHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BRACHYCHAMPSA.get(), PrehistoricFaunaConfig.brachychampsaHellCreekClearingSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.triceratopsHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekClearingSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.tyrannosaurusHellCreekClearingSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekClearingSpawnWeight, 1, 2));
		return biome(true, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, 0x53711f, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekBluffs(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withHellCreekLiriodendritesHillsPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.caveSentinelHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekBluffsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekBluffsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.acipenserHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekBluffsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ankylosaurusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekBluffsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.anzuHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekBluffsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.basilemysHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekBluffsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.cyclurusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekBluffsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cephaloleichnitesHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CEPHALOLEICHNITES.get(), PrehistoricFaunaConfig.cephaloleichnitesHellCreekBluffsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.dakotaraptorHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekBluffsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.didelphodonHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekBluffsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.edmontosaurusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekBluffsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.lepisosteusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekBluffsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.lonchidionHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekBluffsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.melviusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekBluffsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.myledaphusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekBluffsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ornithomimusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekBluffsSpawnWeight, 3, 6));
		if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekBluffsSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.palaeosaniwaHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekBluffsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.parapsephurusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PARAPSEPHURUS.get(), PrehistoricFaunaConfig.parapsephurusHellCreekBluffsSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.thescelosaurusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekBluffsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.brachychampsaHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BRACHYCHAMPSA.get(), PrehistoricFaunaConfig.brachychampsaHellCreekBluffsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.triceratopsHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekBluffsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.tyrannosaurusHellCreekBluffsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekBluffsSpawnWeight, 1, 2));
		return biome(true, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, 0x53711f, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekRedwoods(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withHellCreekRedwoodsPlants(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.MUD_DISK);
		if (PrehistoricFaunaConfig.caveSentinelHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekRedwoodsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekRedwoodsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.acipenserHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekRedwoodsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ankylosaurusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekRedwoodsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.anzuHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekRedwoodsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.basilemysHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekRedwoodsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.cephaloleichnitesHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CEPHALOLEICHNITES.get(), PrehistoricFaunaConfig.cephaloleichnitesHellCreekRedwoodsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cyclurusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekRedwoodsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.dakotaraptorHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekRedwoodsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.didelphodonHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekRedwoodsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.edmontosaurusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekRedwoodsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.lepisosteusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekRedwoodsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.lonchidionHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekRedwoodsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.melviusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekRedwoodsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.myledaphusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekRedwoodsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ornithomimusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekRedwoodsSpawnWeight, 3, 6));
		if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekRedwoodsSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.palaeosaniwaHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekRedwoodsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.parapsephurusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PARAPSEPHURUS.get(), PrehistoricFaunaConfig.parapsephurusHellCreekRedwoodsSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.thescelosaurusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekRedwoodsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.brachychampsaHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BRACHYCHAMPSA.get(), PrehistoricFaunaConfig.brachychampsaHellCreekRedwoodsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.triceratopsHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekRedwoodsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.tyrannosaurusHellCreekRedwoodsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekRedwoodsSpawnWeight, 1, 2));
		return biome(true, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, 0x53711f, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekSwamp(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withHellCreekSwampPlants(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, PFPlacedFeatures.MUD_DISK);
		if (PrehistoricFaunaConfig.caveSentinelHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekSwampSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekSwampSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.acipenserHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ankylosaurusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.anzuHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekSwampSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.basilemysHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.cephaloleichnitesHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CEPHALOLEICHNITES.get(), PrehistoricFaunaConfig.cephaloleichnitesHellCreekSwampSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cyclurusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekSwampSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.dakotaraptorHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.didelphodonHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekSwampSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.edmontosaurusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekSwampSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.lepisosteusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekSwampSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.lonchidionHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.melviusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.myledaphusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekSwampSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ornithomimusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekSwampSpawnWeight, 3, 6));
		if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekSwampSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.palaeosaniwaHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekSwampSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.parapsephurusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PARAPSEPHURUS.get(), PrehistoricFaunaConfig.parapsephurusHellCreekSwampSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.thescelosaurusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekSwampSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.brachychampsaHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BRACHYCHAMPSA.get(), PrehistoricFaunaConfig.brachychampsaHellCreekSwampSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.triceratopsHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekSwampSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.tyrannosaurusHellCreekSwampSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekSwampSpawnWeight, 1, 2));
		return biome(true, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, 0x53711f, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome hellCreekRiver(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withHellCreekRiverPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.caveSentinelHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelHellCreekRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelHellCreekRiverSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.acipenserHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), PrehistoricFaunaConfig.acipenserHellCreekRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ankylosaurusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANKYLOSAURUS.get(), PrehistoricFaunaConfig.ankylosaurusHellCreekRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.anzuHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ANZU.get(), PrehistoricFaunaConfig.anzuHellCreekRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.basilemysHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BASILEMYS.get(), PrehistoricFaunaConfig.basilemysHellCreekRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.cephaloleichnitesHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CEPHALOLEICHNITES.get(), PrehistoricFaunaConfig.cephaloleichnitesHellCreekRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cyclurusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CYCLURUS.get(), PrehistoricFaunaConfig.cyclurusHellCreekRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.dakotaraptorHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DAKOTARAPTOR.get(), PrehistoricFaunaConfig.dakotaraptorHellCreekRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.didelphodonHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DIDELPHODON.get(), PrehistoricFaunaConfig.didelphodonHellCreekRiverSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.edmontosaurusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.EDMONTOSAURUS.get(), PrehistoricFaunaConfig.edmontosaurusHellCreekRiverSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.lepisosteusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), PrehistoricFaunaConfig.lepisosteusHellCreekRiverSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.lonchidionHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LONCHIDION.get(), PrehistoricFaunaConfig.lonchidionHellCreekRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.melviusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MELVIUS.get(), PrehistoricFaunaConfig.melviusHellCreekRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.myledaphusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.MYLEDAPHUS.get(), PrehistoricFaunaConfig.myledaphusHellCreekRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ornithomimusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ORNITHOMIMUS.get(), PrehistoricFaunaConfig.ornithomimusHellCreekRiverSpawnWeight, 3, 6));
		if (PrehistoricFaunaConfig.pachycephalosaurusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PACHYCEPHALOSAURUS.get(), PrehistoricFaunaConfig.pachycephalosaurusHellCreekRiverSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.palaeosaniwaHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PALAEOSANIWA.get(), PrehistoricFaunaConfig.palaeosaniwaHellCreekRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.parapsephurusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PARAPSEPHURUS.get(), PrehistoricFaunaConfig.parapsephurusHellCreekRiverSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.thescelosaurusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.THESCELOSAURUS.get(), PrehistoricFaunaConfig.thescelosaurusHellCreekRiverSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.brachychampsaHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BRACHYCHAMPSA.get(), PrehistoricFaunaConfig.brachychampsaHellCreekRiverSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.triceratopsHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TRICERATOPS.get(), PrehistoricFaunaConfig.triceratopsHellCreekRiverSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.tyrannosaurusHellCreekRiverSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TYRANNOSAURUS.get(), PrehistoricFaunaConfig.tyrannosaurusHellCreekRiverSpawnWeight, 1, 2));
		return biome(true, 0x7C5D48, 0x6B4E3B, 0x7ebf9f, 12638463, 0x53711f, 0.8F, 0.7F, spawnSettings, biomeFeatures);
	}
	
	public static Biome djadochtaDunes(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.EPHEDRA);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH_2);
		if (PrehistoricFaunaConfig.caveSentinelDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelDjadochtaDunesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelDjadochtaDunesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.protoceratopsDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOCERATOPS.get(), PrehistoricFaunaConfig.protoceratopsDjadochtaDunesSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.velociraptorDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.VELOCIRAPTOR.get(), PrehistoricFaunaConfig.velociraptorDjadochtaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.citipatiDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CITIPATI.get(), PrehistoricFaunaConfig.citipatiDjadochtaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.oviraptorDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.OVIRAPTOR.get(), PrehistoricFaunaConfig.oviraptorDjadochtaDunesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AEPYORNITHOMIMUS.get(), PrehistoricFaunaConfig.aepyornithomimusDjadochtaDunesSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.telmasaurusDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TELMASAURUS.get(), PrehistoricFaunaConfig.telmasaurusDjadochtaDunesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.pinacosaurusDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PINACOSAURUS.get(), PrehistoricFaunaConfig.pinacosaurusDjadochtaDunesSpawnWeight, 3, 4));
		if (PrehistoricFaunaConfig.plesiohadrosDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLESIOHADROS.get(), PrehistoricFaunaConfig.plesiohadrosDjadochtaDunesSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.harenaichthysDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HARENAICHTHYS.get(), PrehistoricFaunaConfig.harenaichthysDjadochtaDunesSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.halszkaraptorDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HALSZKARAPTOR.get(), PrehistoricFaunaConfig.halszkaraptorDjadochtaDunesSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.udanoceratopsDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.UDANOCERATOPS.get(), PrehistoricFaunaConfig.udanoceratopsDjadochtaDunesSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.goyocephaleDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GOYOCEPHALE.get(), PrehistoricFaunaConfig.goyocephaleDjadochtaDunesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.dermestidBeetleDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleDjadochtaDunesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.gobiulusDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GOBIULUS.get(), PrehistoricFaunaConfig.gobiulusDjadochtaDunesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.kolDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KOL.get(), PrehistoricFaunaConfig.kolDjadochtaDunesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.byronosaurusDjadochtaDunesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BYRONOSAURUS.get(), PrehistoricFaunaConfig.byronosaurusDjadochtaDunesSpawnWeight, 1, 2));
		return biome(false, 0x66866b, 0x9c8c67, 0x5F909D, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome djadochtaArroyo(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withDjadochtaPlants(biomeFeatures);
		PFPlacedFeatures.withDjadochtaFallenLogs(biomeFeatures);
		PFPlacedFeatures.withDjadochtaRocks(biomeFeatures);
		if (PrehistoricFaunaConfig.caveSentinelDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelDjadochtaArroyoSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelDjadochtaArroyoSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.protoceratopsDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOCERATOPS.get(), PrehistoricFaunaConfig.protoceratopsDjadochtaArroyoSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.velociraptorDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.VELOCIRAPTOR.get(), PrehistoricFaunaConfig.velociraptorDjadochtaArroyoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.citipatiDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CITIPATI.get(), PrehistoricFaunaConfig.citipatiDjadochtaArroyoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AEPYORNITHOMIMUS.get(), PrehistoricFaunaConfig.aepyornithomimusDjadochtaArroyoSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.telmasaurusDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TELMASAURUS.get(), PrehistoricFaunaConfig.telmasaurusDjadochtaArroyoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.pinacosaurusDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PINACOSAURUS.get(), PrehistoricFaunaConfig.pinacosaurusDjadochtaArroyoSpawnWeight, 4, 5));
		if (PrehistoricFaunaConfig.plesiohadrosDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLESIOHADROS.get(), PrehistoricFaunaConfig.plesiohadrosDjadochtaArroyoSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.oviraptorDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.OVIRAPTOR.get(), PrehistoricFaunaConfig.oviraptorDjadochtaArroyoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.harenaichthysDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HARENAICHTHYS.get(), PrehistoricFaunaConfig.harenaichthysDjadochtaArroyoSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.halszkaraptorDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HALSZKARAPTOR.get(), PrehistoricFaunaConfig.halszkaraptorDjadochtaArroyoSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.udanoceratopsDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.UDANOCERATOPS.get(), PrehistoricFaunaConfig.udanoceratopsDjadochtaArroyoSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.dermestidBeetleDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleDjadochtaArroyoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.gobiulusDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.GOBIULUS.get(), PrehistoricFaunaConfig.gobiulusDjadochtaArroyoSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.goyocephaleDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GOYOCEPHALE.get(), PrehistoricFaunaConfig.goyocephaleDjadochtaArroyoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.kolDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KOL.get(), PrehistoricFaunaConfig.kolDjadochtaArroyoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.byronosaurusDjadochtaArroyoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BYRONOSAURUS.get(), PrehistoricFaunaConfig.byronosaurusDjadochtaArroyoSpawnWeight, 1, 2));
		return biome(false, 0x66866b, 0x9c8c67, 0x5F909D, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome djadochtaAlluvialPlains(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withDjadochtaAlluvialPlainsPlants(biomeFeatures);
		PFPlacedFeatures.withDjadochtaFallenLogs(biomeFeatures);
		PFPlacedFeatures.withDjadochtaRocks(biomeFeatures);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH_2);
		if (PrehistoricFaunaConfig.caveSentinelDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelDjadochtaAlluvialPlainsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelDjadochtaAlluvialPlainsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.protoceratopsDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOCERATOPS.get(), PrehistoricFaunaConfig.protoceratopsDjadochtaAlluvialPlainsSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.velociraptorDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.VELOCIRAPTOR.get(), PrehistoricFaunaConfig.velociraptorDjadochtaAlluvialPlainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.citipatiDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CITIPATI.get(), PrehistoricFaunaConfig.citipatiDjadochtaAlluvialPlainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.aepyornithomimusDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.AEPYORNITHOMIMUS.get(), PrehistoricFaunaConfig.aepyornithomimusDjadochtaAlluvialPlainsSpawnWeight, 2, 3));
		if (PrehistoricFaunaConfig.telmasaurusDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.TELMASAURUS.get(), PrehistoricFaunaConfig.telmasaurusDjadochtaAlluvialPlainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.pinacosaurusDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PINACOSAURUS.get(), PrehistoricFaunaConfig.pinacosaurusDjadochtaAlluvialPlainsSpawnWeight, 3, 4));
		if (PrehistoricFaunaConfig.plesiohadrosDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PLESIOHADROS.get(), PrehistoricFaunaConfig.plesiohadrosDjadochtaAlluvialPlainsSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.oviraptorDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.OVIRAPTOR.get(), PrehistoricFaunaConfig.oviraptorDjadochtaAlluvialPlainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.harenaichthysDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HARENAICHTHYS.get(), PrehistoricFaunaConfig.harenaichthysDjadochtaAlluvialPlainsSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.halszkaraptorDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.HALSZKARAPTOR.get(), PrehistoricFaunaConfig.halszkaraptorDjadochtaAlluvialPlainsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.udanoceratopsDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.UDANOCERATOPS.get(), PrehistoricFaunaConfig.udanoceratopsDjadochtaAlluvialPlainsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.dermestidBeetleDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), PrehistoricFaunaConfig.dermestidBeetleDjadochtaAlluvialPlainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.gobiulusDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.GOBIULUS.get(), PrehistoricFaunaConfig.gobiulusDjadochtaAlluvialPlainsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.goyocephaleDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.GOYOCEPHALE.get(), PrehistoricFaunaConfig.goyocephaleDjadochtaAlluvialPlainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.kolDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.KOL.get(), PrehistoricFaunaConfig.kolDjadochtaAlluvialPlainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.byronosaurusDjadochtaAlluvialPlainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BYRONOSAURUS.get(), PrehistoricFaunaConfig.byronosaurusDjadochtaAlluvialPlainsSpawnWeight, 1, 2));
		return biome(false, 0x66866b, 0x9c8c67, 0x5F909D, 12638463, 1F, 0.2F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withYixianForestPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.apoclionYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.APOCLION.get(), PrehistoricFaunaConfig.apoclionYixianForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.beipiaosaurusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BEIPIAOSAURUS.get(), PrehistoricFaunaConfig.beipiaosaurusYixianForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.changyuraptorYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHANGYURAPTOR.get(), PrehistoricFaunaConfig.changyuraptorYixianForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cretaraneusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CRETARANEUS.get(), PrehistoricFaunaConfig.cretaraneusYixianForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.dilongYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILONG.get(), PrehistoricFaunaConfig.dilongYixianForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.dongbeititanYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DONGBEITITAN.get(), PrehistoricFaunaConfig.dongbeititanYixianForestSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.incisivosaurusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianForestSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.jinzhousaurusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.JINZHOUSAURUS.get(), PrehistoricFaunaConfig.jinzhousaurusYixianForestSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.liaonemobiusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LIAONEMOBIUS.get(), PrehistoricFaunaConfig.liaonemobiusYixianForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.liaoningosaurusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LIAONINGOSAURUS.get(), PrehistoricFaunaConfig.liaoningosaurusYixianForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.protopsephurusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOPSEPHURUS.get(), PrehistoricFaunaConfig.protopsephurusYixianForestSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.psittacosaurusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianForestSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.repenomamusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.REPENOMAMUS.get(), PrehistoricFaunaConfig.repenomamusYixianForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ruixiniaYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.RUIXINIA.get(), PrehistoricFaunaConfig.ruixiniaYixianForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sinamiaYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINAMIA.get(), PrehistoricFaunaConfig.sinamiaYixianForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.sinosauropteryxYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.yanosteusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANOSTEUS.get(), PrehistoricFaunaConfig.yanosteusYixianForestSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.yutyrannusYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.zhenyuanlongYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ZHENYUANLONG.get(), PrehistoricFaunaConfig.zhenyuanlongYixianForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelYixianForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianForestSpawnWeight, 1, 1));
		return biome(true, 0x318E6C, 0x1B684C, 0x99BEDB, 0xC1D0DC, 0.8F, 0.4F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianLakes(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withYixianLakesPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.apoclionYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.APOCLION.get(), PrehistoricFaunaConfig.apoclionYixianLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.beipiaosaurusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BEIPIAOSAURUS.get(), PrehistoricFaunaConfig.beipiaosaurusYixianLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.changyuraptorYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHANGYURAPTOR.get(), PrehistoricFaunaConfig.changyuraptorYixianLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cretaraneusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CRETARANEUS.get(), PrehistoricFaunaConfig.cretaraneusYixianLakesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.dilongYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILONG.get(), PrehistoricFaunaConfig.dilongYixianLakesSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.dongbeititanYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DONGBEITITAN.get(), PrehistoricFaunaConfig.dongbeititanYixianLakesSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.incisivosaurusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianLakesSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.jinzhousaurusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.JINZHOUSAURUS.get(), PrehistoricFaunaConfig.jinzhousaurusYixianLakesSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.liaonemobiusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LIAONEMOBIUS.get(), PrehistoricFaunaConfig.liaonemobiusYixianLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.liaoningosaurusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LIAONINGOSAURUS.get(), PrehistoricFaunaConfig.liaoningosaurusYixianLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.protopsephurusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOPSEPHURUS.get(), PrehistoricFaunaConfig.protopsephurusYixianLakesSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.psittacosaurusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianLakesSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.repenomamusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.REPENOMAMUS.get(), PrehistoricFaunaConfig.repenomamusYixianLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ruixiniaYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.RUIXINIA.get(), PrehistoricFaunaConfig.ruixiniaYixianLakesSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sinamiaYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINAMIA.get(), PrehistoricFaunaConfig.sinamiaYixianLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.sinosauropteryxYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.yanosteusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANOSTEUS.get(), PrehistoricFaunaConfig.yanosteusYixianLakesSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.yutyrannusYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianLakesSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.zhenyuanlongYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ZHENYUANLONG.get(), PrehistoricFaunaConfig.zhenyuanlongYixianLakesSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianLakesSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelYixianLakesSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianLakesSpawnWeight, 1, 1));
		return biome(true, 0x318E6C, 0x1B684C, 0x99BEDB, 0xC1D0DC, 0.8F, 0.4F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianSnowyForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		PFPlacedFeatures.withYixianSnowyForestPlants(biomeFeatures);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeFeatures);
		if (PrehistoricFaunaConfig.apoclionYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.APOCLION.get(), PrehistoricFaunaConfig.apoclionYixianSnowyForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.beipiaosaurusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BEIPIAOSAURUS.get(), PrehistoricFaunaConfig.beipiaosaurusYixianSnowyForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.changyuraptorYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHANGYURAPTOR.get(), PrehistoricFaunaConfig.changyuraptorYixianSnowyForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cretaraneusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CRETARANEUS.get(), PrehistoricFaunaConfig.cretaraneusYixianSnowyForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.dilongYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILONG.get(), PrehistoricFaunaConfig.dilongYixianSnowyForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.dongbeititanYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DONGBEITITAN.get(), PrehistoricFaunaConfig.dongbeititanYixianSnowyForestSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.incisivosaurusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianSnowyForestSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.jinzhousaurusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.JINZHOUSAURUS.get(), PrehistoricFaunaConfig.jinzhousaurusYixianSnowyForestSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.liaonemobiusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LIAONEMOBIUS.get(), PrehistoricFaunaConfig.liaonemobiusYixianSnowyForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.liaoningosaurusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LIAONINGOSAURUS.get(), PrehistoricFaunaConfig.liaoningosaurusYixianSnowyForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.protopsephurusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOPSEPHURUS.get(), PrehistoricFaunaConfig.protopsephurusYixianSnowyForestSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.psittacosaurusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianSnowyForestSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.repenomamusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.REPENOMAMUS.get(), PrehistoricFaunaConfig.repenomamusYixianSnowyForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ruixiniaYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.RUIXINIA.get(), PrehistoricFaunaConfig.ruixiniaYixianSnowyForestSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sinamiaYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINAMIA.get(), PrehistoricFaunaConfig.sinamiaYixianSnowyForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.sinosauropteryxYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianSnowyForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.yanosteusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANOSTEUS.get(), PrehistoricFaunaConfig.yanosteusYixianSnowyForestSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.yutyrannusYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianSnowyForestSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.zhenyuanlongYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ZHENYUANLONG.get(), PrehistoricFaunaConfig.zhenyuanlongYixianSnowyForestSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianSnowyForestSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelYixianSnowyForestSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianSnowyForestSpawnWeight, 1, 1));
		return biome(true, 0x318E6C, 0x1B684C, 0x99BEDB, 0xC1D0DC, 0.0F, 0.4F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianSnowyMountains(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.CLUBMOSS);
		PFPlacedFeatures.withYixianSnowyForestPlants(biomeFeatures);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeFeatures);
		if (PrehistoricFaunaConfig.apoclionYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.APOCLION.get(), PrehistoricFaunaConfig.apoclionYixianSnowyMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.beipiaosaurusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BEIPIAOSAURUS.get(), PrehistoricFaunaConfig.beipiaosaurusYixianSnowyMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.changyuraptorYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHANGYURAPTOR.get(), PrehistoricFaunaConfig.changyuraptorYixianSnowyMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cretaraneusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CRETARANEUS.get(), PrehistoricFaunaConfig.cretaraneusYixianSnowyMountainsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.dilongYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILONG.get(), PrehistoricFaunaConfig.dilongYixianSnowyMountainsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.dongbeititanYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DONGBEITITAN.get(), PrehistoricFaunaConfig.dongbeititanYixianSnowyMountainsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.incisivosaurusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianSnowyMountainsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.jinzhousaurusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.JINZHOUSAURUS.get(), PrehistoricFaunaConfig.jinzhousaurusYixianSnowyMountainsSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.liaonemobiusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LIAONEMOBIUS.get(), PrehistoricFaunaConfig.liaonemobiusYixianSnowyMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.liaoningosaurusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LIAONINGOSAURUS.get(), PrehistoricFaunaConfig.liaoningosaurusYixianSnowyMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.protopsephurusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOPSEPHURUS.get(), PrehistoricFaunaConfig.protopsephurusYixianSnowyMountainsSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.psittacosaurusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianSnowyMountainsSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.repenomamusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.REPENOMAMUS.get(), PrehistoricFaunaConfig.repenomamusYixianSnowyMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ruixiniaYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.RUIXINIA.get(), PrehistoricFaunaConfig.ruixiniaYixianSnowyMountainsSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sinamiaYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINAMIA.get(), PrehistoricFaunaConfig.sinamiaYixianSnowyMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.sinosauropteryxYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianSnowyMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.yanosteusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANOSTEUS.get(), PrehistoricFaunaConfig.yanosteusYixianSnowyMountainsSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.yutyrannusYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianSnowyMountainsSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.zhenyuanlongYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ZHENYUANLONG.get(), PrehistoricFaunaConfig.zhenyuanlongYixianSnowyMountainsSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianSnowyMountainsSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelYixianSnowyMountainsSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianSnowyMountainsSpawnWeight, 1, 1));
		return biome(true, 0x318E6C, 0x1B684C, 0x99BEDB, 0xC1D0DC, 0.0F, 0.4F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianRegrowth(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
		PFPlacedFeatures.withYixianRegrowthPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.apoclionYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.APOCLION.get(), PrehistoricFaunaConfig.apoclionYixianRegrowthSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.beipiaosaurusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BEIPIAOSAURUS.get(), PrehistoricFaunaConfig.beipiaosaurusYixianRegrowthSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.changyuraptorYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHANGYURAPTOR.get(), PrehistoricFaunaConfig.changyuraptorYixianRegrowthSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cretaraneusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CRETARANEUS.get(), PrehistoricFaunaConfig.cretaraneusYixianRegrowthSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.dilongYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILONG.get(), PrehistoricFaunaConfig.dilongYixianRegrowthSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.dongbeititanYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DONGBEITITAN.get(), PrehistoricFaunaConfig.dongbeititanYixianRegrowthSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.incisivosaurusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianRegrowthSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.jinzhousaurusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.JINZHOUSAURUS.get(), PrehistoricFaunaConfig.jinzhousaurusYixianRegrowthSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.liaonemobiusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LIAONEMOBIUS.get(), PrehistoricFaunaConfig.liaonemobiusYixianRegrowthSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.liaoningosaurusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LIAONINGOSAURUS.get(), PrehistoricFaunaConfig.liaoningosaurusYixianRegrowthSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.protopsephurusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOPSEPHURUS.get(), PrehistoricFaunaConfig.protopsephurusYixianRegrowthSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.psittacosaurusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianRegrowthSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.repenomamusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.REPENOMAMUS.get(), PrehistoricFaunaConfig.repenomamusYixianRegrowthSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ruixiniaYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.RUIXINIA.get(), PrehistoricFaunaConfig.ruixiniaYixianRegrowthSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sinamiaYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINAMIA.get(), PrehistoricFaunaConfig.sinamiaYixianRegrowthSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.sinosauropteryxYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianRegrowthSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.yanosteusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANOSTEUS.get(), PrehistoricFaunaConfig.yanosteusYixianRegrowthSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.yutyrannusYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianRegrowthSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.zhenyuanlongYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ZHENYUANLONG.get(), PrehistoricFaunaConfig.zhenyuanlongYixianRegrowthSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianRegrowthSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelYixianRegrowthSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianRegrowthSpawnWeight, 1, 1));
		return biome(true, 0x318E6C, 0x1B684C, 0x99BEDB, 0xC1D0DC, 0.8F, 0.4F, spawnSettings, biomeFeatures);
	}
	
	public static Biome yixianVolcano(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
		MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
		BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
		BiomeDefaultFeatures.addDefaultOres(biomeFeatures, true);
		biomeFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PFPlacedFeatures.CLUBMOSS);
		PFPlacedFeatures.withYixianRegrowthPlants(biomeFeatures);
		if (PrehistoricFaunaConfig.apoclionYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.APOCLION.get(), PrehistoricFaunaConfig.apoclionYixianVolcanoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.beipiaosaurusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.BEIPIAOSAURUS.get(), PrehistoricFaunaConfig.beipiaosaurusYixianVolcanoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.changyuraptorYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.CHANGYURAPTOR.get(), PrehistoricFaunaConfig.changyuraptorYixianVolcanoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.cretaraneusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.CRETARANEUS.get(), PrehistoricFaunaConfig.cretaraneusYixianVolcanoSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.dilongYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DILONG.get(), PrehistoricFaunaConfig.dilongYixianVolcanoSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.dongbeititanYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.DONGBEITITAN.get(), PrehistoricFaunaConfig.dongbeititanYixianVolcanoSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.incisivosaurusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.INCISIVOSAURUS.get(), PrehistoricFaunaConfig.incisivosaurusYixianVolcanoSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.jinzhousaurusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.JINZHOUSAURUS.get(), PrehistoricFaunaConfig.jinzhousaurusYixianVolcanoSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.liaonemobiusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.LIAONEMOBIUS.get(), PrehistoricFaunaConfig.liaonemobiusYixianVolcanoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.liaoningosaurusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.LIAONINGOSAURUS.get(), PrehistoricFaunaConfig.liaoningosaurusYixianVolcanoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.protopsephurusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PROTOPSEPHURUS.get(), PrehistoricFaunaConfig.protopsephurusYixianVolcanoSpawnWeight, 3, 5));
		if (PrehistoricFaunaConfig.psittacosaurusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.PSITTACOSAURUS.get(), PrehistoricFaunaConfig.psittacosaurusYixianVolcanoSpawnWeight, 2, 5));
		if (PrehistoricFaunaConfig.repenomamusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.REPENOMAMUS.get(), PrehistoricFaunaConfig.repenomamusYixianVolcanoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.ruixiniaYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.RUIXINIA.get(), PrehistoricFaunaConfig.ruixiniaYixianVolcanoSpawnWeight, 2, 4));
		if (PrehistoricFaunaConfig.sinamiaYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINAMIA.get(), PrehistoricFaunaConfig.sinamiaYixianVolcanoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.sinosauropteryxYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.SINOSAUROPTERYX.get(), PrehistoricFaunaConfig.sinosauropteryxYixianVolcanoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.yanosteusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YANOSTEUS.get(), PrehistoricFaunaConfig.yanosteusYixianVolcanoSpawnWeight, 1, 4));
		if (PrehistoricFaunaConfig.yutyrannusYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.YUTYRANNUS.get(), PrehistoricFaunaConfig.yutyrannusYixianVolcanoSpawnWeight, 1, 2));
		if (PrehistoricFaunaConfig.zhenyuanlongYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(PFEntities.ZHENYUANLONG.get(), PrehistoricFaunaConfig.zhenyuanlongYixianVolcanoSpawnWeight, 1, 3));
		if (PrehistoricFaunaConfig.caveSentinelYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.CAVE_SENTINEL.get(), PrehistoricFaunaConfig.caveSentinelYixianVolcanoSpawnWeight, 1, 1));
		if (PrehistoricFaunaConfig.landSentinelYixianVolcanoSpawnWeight != 0) spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(PFEntities.LAND_SENTINEL.get(), PrehistoricFaunaConfig.landSentinelYixianVolcanoSpawnWeight, 1, 1));
		return volcanoBiome(false, 0x395148, 0x414C47, 0x4F5A63, 0x5D5F60, 0.2F, 1.3F, spawnSettings, biomeFeatures);
	}
	
}
