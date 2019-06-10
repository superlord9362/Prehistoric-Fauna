package superlord.prehistoricfauna.blocks.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import superlord.prehistoricfauna.init.ModItems;

import java.util.ArrayList;
import java.util.List;

public class DNAExtractorRecipes {
    public static List<RecipeAnalyzer> analyzerRecipes = new ArrayList<>();


    public static void init() {
    	
    	RecipeAnalyzer allosaurus = new RecipeAnalyzer(ModItems.ALLOSAURUS_SKULL)
                .addOutput(new ItemStack(Items.DYE, 1, 15), 50F)
                .addOutput(new ItemStack(Blocks.SAND, 2), 35F)
        		.addOutput(new ItemStack(ModItems.ALLOSAURUS_DNA, 1), 15F);
        registerAnalyzer(allosaurus);
        
        RecipeAnalyzer ankylosaurus = new RecipeAnalyzer(ModItems.ANKYLOSAURUS_TAIL)
                .addOutput(new ItemStack(Items.DYE, 1, 15), 50F)
                .addOutput(new ItemStack(Blocks.SAND, 2), 35F)
        		.addOutput(new ItemStack(ModItems.ANKYLOSAURUS_DNA, 1), 15F);
        registerAnalyzer(ankylosaurus);
        
        RecipeAnalyzer baryonyx = new RecipeAnalyzer(ModItems.BARYONYX_CLAW)
                .addOutput(new ItemStack(Items.DYE, 1, 15), 50F)
                .addOutput(new ItemStack(Blocks.SAND, 2), 35F)
        		.addOutput(new ItemStack(ModItems.BARYONYX_DNA, 1), 15F);
        registerAnalyzer(baryonyx);
        
        RecipeAnalyzer camarasaurus = new RecipeAnalyzer(ModItems.CAMARASAURUS_SKULL)
                .addOutput(new ItemStack(Items.DYE, 1, 15), 50F)
                .addOutput(new ItemStack(Blocks.SAND, 2), 35F)
        		.addOutput(new ItemStack(ModItems.CAMARASAURUS_DNA, 1), 15F);
        registerAnalyzer(camarasaurus);
        
        RecipeAnalyzer dryosaurus = new RecipeAnalyzer(ModItems.DRYOSAURUS_SKULL)
                .addOutput(new ItemStack(Items.DYE, 1, 15), 50F)
                .addOutput(new ItemStack(Blocks.SAND, 2), 35F)
        		.addOutput(new ItemStack(ModItems.DRYOSAURUS_DNA, 1), 15F);
        registerAnalyzer(dryosaurus);
        
        RecipeAnalyzer velociraptor = new RecipeAnalyzer(ModItems.VELOCIRAPTOR_CLAW)
                .addOutput(new ItemStack(Items.DYE, 1, 15), 50F)
                .addOutput(new ItemStack(Blocks.SAND, 2), 35F)
        		.addOutput(new ItemStack(ModItems.VELOCIRAPTOR_DNA, 1), 15F);
        registerAnalyzer(velociraptor);
        
    }

    private static void registerAnalyzer(RecipeAnalyzer recipe) {
        analyzerRecipes.add(recipe);
    }


    public static RecipeAnalyzer getAnalyzerRecipeForItem(ItemStack stack) {
        for (RecipeAnalyzer recipe : analyzerRecipes) {
            if (OreDictionary.itemMatches(recipe.getInput(), stack, false)) {
                return recipe;
            }
        }
        return null;
    }

   
}
