package superlord.prehistoricfauna.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

import net.minecraft.world.biome.Biome.Builder;

public class HellCreekSwamp extends Biome {

	public HellCreekSwamp(Builder biomeBuilder) {
		super(biomeBuilder);
		DefaultBiomeFeatures.addSwampClayDisks(this);
	}

}
