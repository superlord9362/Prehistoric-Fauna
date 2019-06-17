package superlord.prehistoricfauna.items;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import superlord.prehistoricfauna.tab.PFTabRegistry;

public class ItemDNADisk extends ItemBase {
	
	private static String[] speciesList = { "triceratops_dna", "gallimimus_dna", "tyrannosaurus_dna", "velociraptor_dna", "stegosaurus_dna",
			"camarasaurus_dna", "dryosaurus_dna", "allosaurus_dna","ankylosaurus_dna", "baryonyx_dna", "parasaurolophus_dna",
<<<<<<< HEAD
			"prenocephale_dna", "paradoxides_dna", "cladocyclus_dna", "eusthenopteron_dna", "cooksonia_dna", "archaeamphora_dna", "cycadeoidea_dna" };
=======
			"prenocephale_dna", "paradoxides_dna", "cladocyclus_dna", "eusthenopteron_dna", "cooksonia_dna", "archaeamphora_dna" };
>>>>>>> 9a835b4958cbfb1fef99a4142b035427c5a6fb4d

	public int speciesIdentifier;
	
	public ItemDNADisk(int identifier) {
		super(speciesList[identifier]);
		speciesIdentifier = identifier;
		setCreativeTab(PFTabRegistry.NORMAL);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		if (stack.hasTagCompound()) {
			tooltip.add("DNA Purity: " + stack.getTagCompound().getFloat("dna_purity") + "%");
		}
    }
}
