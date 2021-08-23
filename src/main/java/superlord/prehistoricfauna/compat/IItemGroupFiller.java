package superlord.prehistoricfauna.compat;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public interface IItemGroupFiller {
	
	void fillItem(Item item, ItemGroup group, NonNullList<ItemStack> items);

}
