package superlord.prehistoricfauna.common.items;

import net.minecraft.world.item.Item;

public class TriceratopsArmorItem extends Item {
	private final int protection;

	public TriceratopsArmorItem(int p_41364_, Item.Properties p_41366_) {
		super(p_41366_);
		this.protection = p_41364_;
	}

	public int getProtection() {
		return this.protection;
	}
}
