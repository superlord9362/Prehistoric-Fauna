package superlord.prehistoricfauna.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import superlord.prehistoricfauna.tab.PFTabRegistry;

public class ItemDNADisk extends ItemBase {

	public ItemDNADisk(String name) {
		super(name);
		setCreativeTab(PFTabRegistry.NORMAL);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		if (stack.hasTagCompound()) {
			tooltip.add("DNA Purity: " + stack.getTagCompound().getFloat("DNA Purity"));
		}
    }

}
