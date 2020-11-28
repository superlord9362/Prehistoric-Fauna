package superlord.prehistoricfauna.world.dimension.cretaceous;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import superlord.prehistoricfauna.core.world.PHFBiomes;

public class CretaceousBiomeProvider extends BiomeProvider {

	@SuppressWarnings("unused")
	private Random rand;
	
	public CretaceousBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(PHFBiomes.HELL_CREEK);

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return PHFBiomes.HELL_CREEK;
	}
	
	

}
