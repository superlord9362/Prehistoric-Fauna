package superlord.prehistoricfauna.world.dimension.triassic;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;
import superlord.prehistoricfauna.init.PFBiomes;

public class TriassicBiomesLayer implements IAreaTransformer0 {
	
	private static final int UNCOMMON_BIOME_CHANCE = 8;
	private static final int RARE_BIOME_CHANCE = 16;
	protected int[] commonBiomes = new int[] {
			TriassicLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_FOREST_BIOME.getKey()),
			TriassicLayerUtil.getBiomeId(PFBiomes.CHINLE_SWAMP_BIOME.getKey())
	};
	protected int[] uncommonBiomes = new int[] {
			TriassicLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_HILLS_BIOME.getKey()),
			TriassicLayerUtil.getBiomeId(PFBiomes.CHINLE_FLATS_BIOME.getKey()),
			TriassicLayerUtil.getBiomeId(PFBiomes.CHINLE_WOODED_MOUNTAINS_BIOME.getKey())
	};
	protected int[] rareBiomes = new int[] {
			TriassicLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_CLEARING_BIOME.getKey())
	};
	
	public TriassicBiomesLayer() {
		
	}
	
	@Override
	public int apply(INoiseRandom iNoiseRandom, int rand1, int rand2) {
		if (iNoiseRandom.random(RARE_BIOME_CHANCE) == 0) {
			return rareBiomes[iNoiseRandom.random(rareBiomes.length)];
		} else if (iNoiseRandom.random(UNCOMMON_BIOME_CHANCE) == 0) {
			return uncommonBiomes[iNoiseRandom.random(uncommonBiomes.length)];
		} else {
			return commonBiomes[iNoiseRandom.random(commonBiomes.length)];
		}
	}

}
