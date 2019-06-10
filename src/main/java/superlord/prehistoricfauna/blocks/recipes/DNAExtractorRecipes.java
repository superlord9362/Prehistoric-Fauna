package superlord.prehistoricfauna.blocks.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import superlord.prehistoricfauna.init.ModItems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.Random;

import com.google.common.collect.Maps;

public class DNAExtractorRecipes {
    private static final DNAExtractorRecipes dnaExtractorRecipes = new DNAExtractorRecipes();
    
    private final Map extractionList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();
    
	private final List<Integer> dnaPuritiesList = Arrays.asList(25, 50, 75, 100);

    
    /**
     * Returns the privately-held instance of DNAExtractorRecipes.
     * @return
     */
	public static DNAExtractorRecipes instance()
    {
        return dnaExtractorRecipes;
    }
	
	private DNAExtractorRecipes() {
		addRecipe(new ItemStack(ModItems.ALLOSAURUS_SKULL), new ItemStack(ModItems.ALLOSAURUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.ANKYLOSAURUS_TAIL), new ItemStack(ModItems.ANKYLOSAURUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.BARYONYX_CLAW), new ItemStack(ModItems.BARYONYX_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.CAMARASAURUS_SKULL), new ItemStack(ModItems.CAMARASAURUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.DRYOSAURUS_SKULL), new ItemStack(ModItems.DRYOSAURUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.VELOCIRAPTOR_CLAW), new ItemStack(ModItems.VELOCIRAPTOR_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.ARCHAEAMPHORA_FOSSIL), new ItemStack(ModItems.ARCHAEAMPHORA_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.CLADOCYCLUS_FOSSIL), new ItemStack(ModItems.CLADOCYCLUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.COOKSONIA_FOSSIL), new ItemStack(ModItems.COOKSONIA_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.EUTHENOPTERON_FOSSIL), new ItemStack(ModItems.EUSTHENOPTERON_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.GALLIMIMUS_SKULL), new ItemStack(ModItems.GALLIMIMUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.PARADOXIDES_FOSSIL), new ItemStack(ModItems.PARADOXIDES_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.PARASAUROLOPHUS_SKULL), new ItemStack(ModItems.PARASAUROLOPHUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.PRENOCEPHALE_SKULL), new ItemStack(ModItems.PRENOCEPHALE_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.STEGOSAURUS_THAGOMIZER), new ItemStack(ModItems.STEGOSAURUS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.TRICERATOPS_HORN), new ItemStack(ModItems.TRICERATOPS_DNA), 0.0F);
		addRecipe(new ItemStack(ModItems.TYRANNOSAURUS_TOOTH), new ItemStack(ModItems.TYRANNOSAURUS_DNA), 0.0F);
    }

	public void addRecipe(ItemStack parItemStackIn, ItemStack parItemStackOut, float parExperience)
    {
        extractionList.put(parItemStackIn, parItemStackOut);
        experienceList.put(parItemStackOut, Float.valueOf(parExperience));
    }
	
	public ItemStack getRecipeResult(ItemStack parItemStack, Random random)
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
        
        ItemStack output = (ItemStack)entry.getValue();
        
		if (random.nextInt(3) == 1) { // 30% chance of bone meal
			output = new ItemStack(Items.DYE, 1, 15);
		} else if (random.nextInt(4) == 1) { // 25% chance of sand
			output = new ItemStack(Blocks.SAND, 2);
		} else { // Otherwise, assign DNA Purity
			UUID uuid = UUID.randomUUID();
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setLong("globalIDLeast", uuid.getLeastSignificantBits());
			nbt.setLong("globalIDMost", uuid.getMostSignificantBits());
			nbt.setFloat("DNA Purity", dnaPuritiesList.get(random.nextInt(dnaPuritiesList.size())));
			output.setTagCompound(nbt);
		}
        
        return output;
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
