package superlord.prehistoricfauna.common.util;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public interface IItemCategoryFiller {
	void fillItem(Item item, CreativeModeTab tab, NonNullList<ItemStack> items);
}
