package superlord.prehistoricfauna.world.dimension.triassic;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import superlord.prehistoricfauna.init.BiomeInit;

public class TriassicBiomeProvider extends BiomeProvider {

	@SuppressWarnings("unused")
	private Random rand;
	
	protected TriassicBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.ISCHIGUALASTO_BIOME.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.ISCHIGUALASTO_BIOME.get();
	}

}
