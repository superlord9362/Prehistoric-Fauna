package superlord.prehistoricfauna.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import superlord.prehistoricfauna.init.ItemInit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableRecipes {
	
    public static List<PaleontologyRecipes> cleaningRecipes = new ArrayList<>();
    public static List<ItemStack> toBeRemovedTable = new ArrayList<>();
    
	public static void init() {
		PaleontologyRecipes cretaceousFossil = new PaleontologyRecipes(ItemInit.CRETACEOUS_FOSSIL.get())
	                .addOutput(new ItemStack(Items.BONE, 2), 35F)
	                .addOutput(new ItemStack(ItemInit.TRICERATOPS_HORN.get(), 1), 5F)
	                .addOutput(new ItemStack(ItemInit.ANKYLOSAURUS_SCUTE.get(), 1), 2.5F)
	                .addOutput(new ItemStack(ItemInit.TYRANNOSAURUS_TOOTH.get(), 1), 2.5F);
        registerCleaning(cretaceousFossil);
	}

	public static void registerCleaning(PaleontologyRecipes recipe) {
		cleaningRecipes.add(recipe);
    }
	
	public static PaleontologyRecipes getCleaningRecipeForItem(ItemStack stack) {
		for(PaleontologyRecipes recipe : cleaningRecipes) {
			if (stack.getItem() == recipe.getInput().getItem()) {
				System.out.println("Cleaning");
				return recipe;
			}
		}
		return null;
    }
    
    public static void postInit() {
    	Iterator<PaleontologyRecipes> itr = TableRecipes.cleaningRecipes.iterator();
        while (itr.hasNext()) {
        	PaleontologyRecipes recipe = itr.next();
            for (ItemStack stack : TableRecipes.toBeRemovedTable) {
                if (recipe.getInput().isItemEqual(stack)) {
                    itr.remove();
                }
            }
        }
    }

}
