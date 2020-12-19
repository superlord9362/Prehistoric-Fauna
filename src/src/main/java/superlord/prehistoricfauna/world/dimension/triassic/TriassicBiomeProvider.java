package superlord.prehistoricfauna.world.dimension.triassic;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import superlord.prehistoricfauna.core.world.PHFBiomes;

import java.util.Set;

public class TriassicBiomeProvider extends BiomeProvider {

	public TriassicBiomeProvider() {
		super(biomeList);
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(PHFBiomes.ISCHIGUALASTO_FOREST);

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return PHFBiomes.ISCHIGUALASTO_FOREST;
	}
	
	

}
