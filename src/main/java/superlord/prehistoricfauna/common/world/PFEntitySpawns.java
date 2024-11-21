package superlord.prehistoricfauna.common.world;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFEntities;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFEntitySpawns {

	public static void addBiomeSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
		if (PrehistoricFaunaConfig.extantEntitySpawns) {
			if (biome.is(Biomes.RIVER)) {
				builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), 70, 1, 1));
				builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.ACIPENSER.get(), 4, 1, 1));
			}
			if (biome.is(Biomes.SWAMP) || biome.is(Biomes.MANGROVE_SWAMP)) {
				builder.getMobSpawnSettings().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.GAR.get(), 6, 1, 1));
			}
			if (biome.is(Biomes.FOREST) || biome.is(Biomes.FLOWER_FOREST)) {
				builder.getMobSpawnSettings().addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(PFEntities.DERMESTID_BEETLE.get(), 5, 1, 1));
			}
		}
	}

}
