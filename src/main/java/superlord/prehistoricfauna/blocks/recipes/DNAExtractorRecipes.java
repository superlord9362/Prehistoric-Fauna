package superlord.prehistoricfauna.blocks.recipes;



import com.google.common.collect.Maps;


import net.minecraft.init.Blocks;

import net.minecraft.init.Items;

import net.minecraft.item.Item;

import net.minecraft.item.ItemBlock;

import net.minecraft.item.ItemStack;

import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;
import superlord.prehistoricfauna.entity.EntityType;
import superlord.prehistoricfauna.entity.TimePeriod;
import superlord.prehistoricfauna.init.ModItems;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;



public class DNAExtractorRecipes {

    public static List<RecipeAnalyzer> analyzerRecipes = new ArrayList<>();

    public static List<RecipeAnalyzer> sifterRecipes = new ArrayList<>();

    public static Map<ItemStack, ItemStack> cultivateRecipes = Maps.<ItemStack, ItemStack>newHashMap();

    public static List<RecipeWorktable> worktableRecipes = new ArrayList<>();





    public static void init() {

        RecipeAnalyzer plantFossil = new RecipeAnalyzer(ModItems.ALLOSAURUS_SKULL)

                .addOutput(new ItemStack(Blocks.SAND, 2), 50F)

                .addOutput(new ItemStack(Items.DYE, 1, 2), 35F)

                .addOutput(new ItemStack(ModItems.ALLOSAURUS_DNA, 1), 15F);

        registerAnalyzer(plantFossil);

        RecipeAnalyzer bioFossil = new RecipeAnalyzer(ModItems.ANKYLOSAURUS_TAIL)

                .addOutput(new ItemStack(Items.DYE, 1, 15), 50F)

                .addOutput(new ItemStack(Blocks.SAND, 2), 35F);

        List<EntityType> bioFossilEntityList = EntityType.getTimePeriodList(TimePeriod.MESOZOIC, TimePeriod.PALEOZOIC);

        float bioFossilDNAChance = 15F / (float) bioFossilEntityList.size();

        for (int i = 0; i < bioFossilEntityList.size(); i++) {

            bioFossil.addOutput(new ItemStack(bioFossilEntityList.get(i).dnaItem), bioFossilDNAChance);

        }

        registerAnalyzer(bioFossil);

        
    }



    private static void registerAnalyzer(RecipeAnalyzer recipe) {

        analyzerRecipes.add(recipe);

    }



    private static void registerSifter(RecipeAnalyzer recipe) {

        sifterRecipes.add(recipe);

    }



    private static void registerCultivate(ItemStack input, ItemStack output) {

        cultivateRecipes.put(input, output);

    }



    private static void registerWorktable(ItemStack input, ItemStack output, ItemStack fuel) {

        worktableRecipes.add(new RecipeWorktable(input, output, fuel));

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