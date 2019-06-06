package superlord.prehistoricfauna.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import superlord.prehistoricfauna.init.ModItems;

public class PFTab extends CreativeTabs {

	public PFTab() {
		super("Prehistoric Fauna");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack createIcon() {
		return new ItemStack(ModItems.VELOCIRAPTOR_CLAW);
	}

}
