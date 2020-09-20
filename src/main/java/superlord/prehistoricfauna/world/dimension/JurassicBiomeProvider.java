package superlord.prehistoricfauna.world.dimension;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import superlord.prehistoricfauna.init.BiomeInit;

public class JurassicBiomeProvider extends BiomeProvider {

	@SuppressWarnings("unused")
	private Random rand;
	
	protected JurassicBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.MORRISON_BIOME.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.MORRISON_BIOME.get();
	}

}
