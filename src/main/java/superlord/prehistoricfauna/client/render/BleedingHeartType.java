package superlord.prehistoricfauna.client.render;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFEffects;

public enum BleedingHeartType {
	BLEEDING(0);

	public static final ResourceLocation ATLAS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/gui/icons.png");
	public static final int ATLAS_W = 64;
	public static final int ATLAS_H = 9;
	private static final int SIZE = 9; //default heart size is 9x9

	private final int verticalIndex;

	private BleedingHeartType(int verticalIndex) {
		this.verticalIndex = verticalIndex;
	}

	public Pair<Integer, Integer> getHeartPos(boolean hardcore) {
		int y = this.verticalIndex * SIZE;
		int xMult = hardcore ? 2 : 0;
		int x = xMult * SIZE;
		return Pair.of(x, y);
	}

	public Pair<Integer, Integer> getHalfHeartPos(boolean hardcore) {
		int y = this.verticalIndex * SIZE;
		int xMult = hardcore ? 3 : 1;
		int x = xMult * SIZE;
		return Pair.of(x, y);
	}

	public static BleedingHeartType getType(Player player) {
		BleedingHeartType type = null;
		if (player.hasEffect(PFEffects.BLEEDING.get())) {
			type = BleedingHeartType.BLEEDING;
		}
		return type;
	}
}
