package superlord.prehistoricfauna.world.dimension.triassic;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;
import superlord.prehistoricfauna.init.PFBiomes;

public enum TriassicRiverLayer implements ICastleTransformer {
	
	INSTANCE;
	
	private boolean ischigualasto = false;
	private boolean chinle = false;
	
	private List<Integer> ischigualastoBiomes = ImmutableList.of(
			TriassicLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_CLEARING_BIOME.getKey()),
			TriassicLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_FOREST_BIOME.getKey()),
			TriassicLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_HILLS_BIOME.getKey())
			);
	private List<Integer> chinleBiomes = ImmutableList.of(
			TriassicLayerUtil.getBiomeId(PFBiomes.CHINLE_FLATS_BIOME.getKey()),
			TriassicLayerUtil.getBiomeId(PFBiomes.CHINLE_SWAMP_BIOME.getKey()),
			TriassicLayerUtil.getBiomeId(PFBiomes.CHINLE_WOODED_MOUNTAINS_BIOME.getKey())
			);
	
	TriassicRiverLayer() {
		
	}
	
	@Override
	public int apply(INoiseRandom random, int north, int west, int south, int east, int center) {
		if (shouldRiver(center, west, south, east, north)) {
			if (ischigualasto)
				return TriassicLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_RIVER_BIOME.getKey());
			else if (chinle)
				return TriassicLayerUtil.getBiomeId(PFBiomes.CHINLE_RIVER_BIOME.getKey());
			else return -1;
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
		if (ischigualastoBiomes.contains(id1) || ischigualastoBiomes.contains(id2)) ischigualasto = true;
		else ischigualasto = false;
		if (chinleBiomes.contains(id1) || chinleBiomes.contains(id2)) chinle = true;
		else chinle = false;
		return true;
	}
			

}
