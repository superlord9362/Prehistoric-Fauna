package superlord.prehistoricfauna.world.dimension.jurassic;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;
import superlord.prehistoricfauna.init.PFBiomes;

public enum JurassicRiverLayer implements ICastleTransformer {
	
	INSTANCE;
	
	JurassicRiverLayer() {
		
	}
	
	@Override
	public int apply(INoiseRandom random, int north, int west, int south, int east, int center) {
		if (shouldRiver(center, west, south, east, north)) {
			return JurassicLayerUtil.getBiomeId(PFBiomes.KAYENTA_RIVER_BIOME.getKey());
		} else {
			return -1;
		}
	}
	
	boolean shouldRiver(int mid, int left, int down, int right, int up) {
		return shouldRiver(mid, left) || shouldRiver(mid, right) || shouldRiver(mid, down) || shouldRiver(mid, up);
	}
	
	boolean shouldRiver(int id1, int id2) {
		if (id1 == id2) return false;
		if (id1 == id2) return false;
		return true;
	}
			

}
