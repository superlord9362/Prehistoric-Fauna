package superlord.prehistoricfauna.world.worldtype;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;
import superlord.prehistoricfauna.init.PFBiomes;

public enum PFWorldTypeRiverLayer implements ICastleTransformer {
	
	INSTANCE;
	
	private boolean hellCreek = false;
	@SuppressWarnings("unused")
	private boolean ischigualasto = false;
	
	private List<Integer> hellCreekBiomes = ImmutableList.of(
			PFWorldTypeLayerUtil.getBiomeId(PFBiomes.HELL_CREEK_BIOME.getKey()),
			PFWorldTypeLayerUtil.getBiomeId(PFBiomes.HELL_CREEK_HILLS_BIOME.getKey()),
			PFWorldTypeLayerUtil.getBiomeId(PFBiomes.HELL_CREEK_CLEARING_BIOME.getKey())
			);
	private List<Integer> morrisonBiomes = ImmutableList.of(
			PFWorldTypeLayerUtil.getBiomeId(PFBiomes.MORRISON_HILLS_BIOME.getKey()),
			PFWorldTypeLayerUtil.getBiomeId(PFBiomes.MORRISON_SAVANNAH_BIOME.getKey())
			);
	private List<Integer> ischigualastoBiomes = ImmutableList.of(
			PFWorldTypeLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_FOREST_BIOME.getKey()),
			PFWorldTypeLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_CLEARING_BIOME.getKey()),
			PFWorldTypeLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_HILLS_BIOME.getKey())
			);
	
	PFWorldTypeRiverLayer() {
		
	}
	
	@Override
	public int apply(INoiseRandom random, int north, int west, int south, int east, int center) {
		if (shouldRiver(center, west, south, east, north)) {
			if (hellCreek) {
				return PFWorldTypeLayerUtil.getBiomeId(PFBiomes.HELL_CREEK_RIVER_BIOME.getKey());
			} else {
				return PFWorldTypeLayerUtil.getBiomeId(PFBiomes.ISCHIGUALASTO_RIVER_BIOME.getKey());
			}
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
		if (hellCreekBiomes.contains(id1) || hellCreekBiomes.contains(id2)) hellCreek = true;
		if (morrisonBiomes.contains(id1) || morrisonBiomes.contains(id2)) return false;
		if (ischigualastoBiomes.contains(id1) || ischigualastoBiomes.contains(id2)) ischigualasto = true;
		return true;
	}
			

}
