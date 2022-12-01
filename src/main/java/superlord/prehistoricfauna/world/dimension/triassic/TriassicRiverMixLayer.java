package superlord.prehistoricfauna.world.dimension.triassic;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;
import superlord.prehistoricfauna.init.PFBiomes;

public enum TriassicRiverMixLayer implements IAreaTransformer2, IDimOffset0Transformer {
	
	INSTANCE;
	
	TriassicRiverMixLayer() {
		
	}
	
	@Override
	public int apply(INoiseRandom random, IArea area1, IArea area2, int val1, int val2) {
		int i = area1.getValue(this.getOffsetX(val1), this.getOffsetZ(val2));
		int j = area2.getValue(this.getOffsetX(val1), this.getOffsetZ(val2));
		if (j == TriassicLayerUtil.getBiomeId(PFBiomes.CHINLE_RIVER_BIOME.getKey())) {
			return j;
		}
		if (j == TriassicLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_RIVER_BIOME.getKey())) {
			return j;
		} else {
			return i;
		}
	}

}
