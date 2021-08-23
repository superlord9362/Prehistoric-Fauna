package superlord.prehistoricfauna.world.dimension;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;
import superlord.prehistoricfauna.init.PFBiomes;

public class PFBiomesLayer implements IAreaTransformer0 {
	
	private static final int UNCOMMON_BIOME_CHANCE = 8;
	private static final int RARE_BIOME_CHANCE = 16;
	protected int[] commonBiomes = new int[] {
			PFLayerUtil.getBiomeId(PFBiomes.HELL_CREEK_BIOME.getKey()),
	};
	protected int[] uncommonBiomes = new int[] {
			PFLayerUtil.getBiomeId(PFBiomes.HELL_CREEK_HILLS_BIOME.getKey())
	};
	protected int[] rareBiomes = new int[] {
			PFLayerUtil.getBiomeId(PFBiomes.HELL_CREEK_CLEARING_BIOME.getKey())
	};
	
	public PFBiomesLayer() {
		
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
