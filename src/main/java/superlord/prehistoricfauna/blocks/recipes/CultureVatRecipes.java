package superlord.prehistoricfauna.blocks.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import superlord.prehistoricfauna.init.ModItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class CultureVatRecipes {
    public static List<RecipeAnalyzer> analyzerRecipes = new ArrayList<>();
    public static List<RecipeAnalyzer> sifterRecipes = new ArrayList<>();
    public static Map<ItemStack, ItemStack> cultivateRecipes = Maps.<ItemStack, ItemStack>newHashMap();
    public static List<RecipeWorktable> worktableRecipes = new ArrayList<>();


    public static void init() {
        
        registerCultivate(new ItemStack(ModItems.ALLOSAURUS_DNA), new ItemStack(ModItems.ALLOSAURUS_EGG_ENTITY));
      
    }

    private static void registerCultivate(ItemStack input, ItemStack output) {
        cultivateRecipes.put(input, output);
    }

    public static ItemStack getCultivateResult(ItemStack stack) {
        for (Map.Entry<ItemStack, ItemStack> entry : cultivateRecipes.entrySet()) {
            if (OreDictionary.itemMatches(stack, entry.getKey(), false)) {
                return entry.getValue();
            }
        }
        return ItemStack.EMPTY;
    }

    public static RecipeWorktable getWorktableRecipeForItem(ItemStack stack) {
        for (RecipeWorktable recipe : worktableRecipes) {
            if (stack.isItemStackDamageable() && stack.getItem() == recipe.getInput().getItem() || OreDictionary.itemMatches(recipe.getInput(), stack, false)) {
                return recipe;
            }
        }
        return null;
    }


    public static RecipeAnalyzer getAnalyzerRecipeForItem(ItemStack stack) {
        for (RecipeAnalyzer recipe : analyzerRecipes) {
            if (OreDictionary.itemMatches(recipe.getInput(), stack, false)) {
                return recipe;
            }
        }
        return null;
    }

    public static RecipeAnalyzer getSifterRecipeForItem(ItemStack stack) {
        for (RecipeAnalyzer recipe : sifterRecipes) {
            if (OreDictionary.itemMatches(recipe.getInput(), stack, false)) {
                return recipe;
            }
        }
        return null;
    }
}
