package superlord.prehistoricfauna.world.dimension.jurassic;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;
import superlord.prehistoricfauna.init.PFBiomes;

public class JurassicBiomesLayer implements IAreaTransformer0 {
	
	private static final int UNCOMMON_BIOME_CHANCE = 8;
	protected int[] commonBiomes = new int[] {
			JurassicLayerUtil.getBiomeId(PFBiomes.MORRISON_SAVANNAH_BIOME.getKey()),
			JurassicLayerUtil.getBiomeId(PFBiomes.KAYENTA_DRY_FOREST_BIOME.getKey())
	};
	protected int[] uncommonBiomes = new int[] {
			JurassicLayerUtil.getBiomeId(PFBiomes.MORRISON_HILLS_BIOME.getKey()),
			JurassicLayerUtil.getBiomeId(PFBiomes.KAYENTA_BUTTES_BIOME.getKey()),
			JurassicLayerUtil.getBiomeId(PFBiomes.KAYENTA_DESERT_BIOME.getKey())
	};
	
	public JurassicBiomesLayer() {
		
	}
	
	@Override
	public int apply(INoiseRandom iNoiseRandom, int rand1, int rand2) {
		if (iNoiseRandom.random(UNCOMMON_BIOME_CHANCE) == 0) {
			return uncommonBiomes[iNoiseRandom.random(uncommonBiomes.length)];
		} else {
			return commonBiomes[iNoiseRandom.random(commonBiomes.length)];
		}
	}

}
