package superlord.prehistoricfauna.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import superlord.prehistoricfauna.init.ModItems;

public class PFEggTab extends CreativeTabs {

	public PFEggTab() {
		super("Prehistoric Fauna Eggs");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack createIcon() {
		return new ItemStack(ModItems.DRYOSAURUS_EGG_ENTITY);
	}

}
