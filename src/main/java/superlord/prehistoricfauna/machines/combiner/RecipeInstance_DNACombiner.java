package superlord.prehistoricfauna.machines.combiner;

import java.util.Map;
import java.util.UUID;

import com.google.common.collect.Maps;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.items.ItemDNADisk;

public class RecipeInstance_DNACombiner {
    private static final RecipeInstance_DNACombiner dnaCombinerRecipes = new RecipeInstance_DNACombiner();
    
	private Map<Integer, ItemStack> acceptedDisks = Maps.newHashMap();
	private Map<Integer, ItemStack> queuedDisks = Maps.newHashMap();
	
    /**
     * Returns the privately-held instance of DNACombinerRecipes.
     * @return
     */
	public static RecipeInstance_DNACombiner instance()
    {
        return dnaCombinerRecipes;
    }
	
	private RecipeInstance_DNACombiner() {
		addRecipe(0, new ItemStack(ModItems.ALLOSAURUS_DNA));
		addRecipe(1, new ItemStack(ModItems.ANKYLOSAURUS_TAIL));

    }

	public void addRecipe(int i, ItemStack itemStack)
    {
		acceptedDisks.put(i, itemStack);
    }
	
	public ItemStack getDefinedRecipeResult(ItemStack[] diskStacks)
    {
		queuedDisks = Maps.newHashMap();
		int disksFound = 0;
		for (ItemStack inputDisk : diskStacks) {
			if (ItemDNADisk.class.isInstance(((Object)inputDisk.getItem())) ) {
				if (disksFound > 0 && queuedDisks.containsKey(disksFound-1) && queuedDisks.get(disksFound-1).getItem().equals(inputDisk.getItem())) {
					queuedDisks.put(disksFound++, inputDisk);
				} else {
					queuedDisks.put(disksFound++, inputDisk);
				}
			}
		}
		return (queuedDisks.get(0) == null) ? null : new ItemStack(queuedDisks.get(0).getItem());
    }
	
	public ItemStack getRecipeResult(ItemStack[] diskStacks)
    {
		queuedDisks = Maps.newHashMap();
		int disksFound = 0;
		for (ItemStack inputDisk : diskStacks) {
			if (ItemDNADisk.class.isInstance(((Object)inputDisk.getItem())) ) {
				if (disksFound > 0 && queuedDisks.containsKey(disksFound-1) && queuedDisks.get(disksFound-1).getItem().equals(inputDisk.getItem())) {
					queuedDisks.put(disksFound++, inputDisk);
				} else {
					queuedDisks.put(disksFound++, inputDisk);
				}
			}
		}
		
		float dnaPurity = 0;
        for (ItemStack disk : queuedDisks.values()) {
			dnaPurity += disk.getTagCompound().getFloat("dna_purity");
        }
        ItemStack resultItemStack = new ItemStack(queuedDisks.get(0).getItem());
		
		NBTTagCompound nbt = new NBTTagCompound();
		UUID uuid = UUID.randomUUID();
		nbt.setLong("globalIDLeast", uuid.getLeastSignificantBits());
		nbt.setLong("globalIDMost", uuid.getMostSignificantBits());
		nbt.setFloat("dna_purity", dnaPurity);
		resultItemStack.setTagCompound(nbt);
		return resultItemStack;
    }
   
}
