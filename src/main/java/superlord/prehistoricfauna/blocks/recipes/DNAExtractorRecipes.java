package superlord.prehistoricfauna.blocks.recipes;

import net.minecraft.item.ItemStack;
import superlord.prehistoricfauna.init.ModItems;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class DNAExtractorRecipes {
    private static final DNAExtractorRecipes dnaExtractorRecipes = new DNAExtractorRecipes();
    
    private final Map extractionList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();
    
    /**
     * Returns the privately-held instance of DNAExtractorRecipes.
     * @return
     */
	public static DNAExtractorRecipes instance()
    {
        return dnaExtractorRecipes;
    }
	
	private DNAExtractorRecipes() {
		addRecipe(new ItemStack(ModItems.ALLOSAURUS_SKULL), 
	              new ItemStack(ModItems.ALLOSAURUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.ANKYLOSAURUS_TAIL), 
	              new ItemStack(ModItems.ANKYLOSAURUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.BARYONYX_CLAW), 
	              new ItemStack(ModItems.BARYONYX_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.CAMARASAURUS_SKULL), 
	              new ItemStack(ModItems.CAMARASAURUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.DRYOSAURUS_SKULL), 
	              new ItemStack(ModItems.DRYOSAURUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.VELOCIRAPTOR_CLAW), 
	              new ItemStack(ModItems.VELOCIRAPTOR_DNA), 0.0F);
    }

	public void addRecipe(ItemStack parItemStackIn, ItemStack parItemStackOut, float parExperience)
    {
        extractionList.put(parItemStackIn, parItemStackOut);
        experienceList.put(parItemStackOut, Float.valueOf(parExperience));
    }
	
	public ItemStack getRecipeResult(ItemStack parItemStack)
    {
        Iterator iterator = extractionList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        } while (!areItemStacksEqual(parItemStack, (ItemStack)entry.getKey()));
        return (ItemStack)entry.getValue();
    }
	
	private boolean areItemStacksEqual(ItemStack parItemStack1, ItemStack parItemStack2)
    {
        return parItemStack2.getItem() == parItemStack1.getItem() 

              && (parItemStack2.getMetadata() == 32767 

              || parItemStack2.getMetadata() == parItemStack1

              .getMetadata());
    }

    public Map getRecipeList()
    {
        return extractionList;
    }
    
    public float getResultantExperience(ItemStack parItemStack)
    {
        Iterator iterator = experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        } while (!areItemStacksEqual(parItemStack, (ItemStack)entry.getKey()));
        return ((Float)entry.getValue()).floatValue();
    }

   
}
