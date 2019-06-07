package superlord.prehistoricfauna.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import superlord.prehistoricfauna.init.ModItems;

public class PFEggTab extends CreativeTabs {

	public PFEggTab() {
		super("tab_egg");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.DRYOSAURUS_EGG_ENTITY);
	}

}
