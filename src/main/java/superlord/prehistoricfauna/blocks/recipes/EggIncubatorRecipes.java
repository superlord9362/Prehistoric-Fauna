package superlord.prehistoricfauna.blocks.recipes;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import superlord.prehistoricfauna.init.ModItems;

public class EggIncubatorRecipes {
	private static final EggIncubatorRecipes SMELTING_BASE = new EggIncubatorRecipes();
	/** The list of smelting results. */
	private final Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
	/**
	 * A list which contains how many experience points each recipe output will
	 * give.
	 */
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	public int result;
	protected Random rand;

	/**
	 * Returns an instance of FurnaceRecipes.
	 */
	public static EggIncubatorRecipes instance() {
		return SMELTING_BASE;
	}

	public EggIncubatorRecipes() {
		this.addSmelting(ModItems.GALLIMIMUS_EGG, new ItemStack(ModItems.INCUBATED_GALLIMIMUS), 0.35F);
		this.addSmelting(ModItems.VELOCIRAPTOR_EGG, new ItemStack(ModItems.INCUBATED_VELOCIRATPOR), 0.35F);
		this.addSmelting(ModItems.TYRANNOSAURUS_EGG, new ItemStack(ModItems.INCUBATED_TYRANNOSAURUS), 0.35F);
		this.addSmelting(ModItems.TRICERATOPS_EGG, new ItemStack(ModItems.INCUBATED_TRICERATOPS), 0.35F);
		this.addSmelting(ModItems.CAMARASAURUS_EGG, new ItemStack(ModItems.INC_CAMARASAURUS), 0.35F);
		this.addSmelting(ModItems.DRYOSAURUS_EGG, new ItemStack(ModItems.INCUBATED_DRYOSAURUS), 0.35F);
		this.addSmelting(ModItems.STEGOSAURUS_EGG, new ItemStack(ModItems.INCUBATED_STEGOSAURUS), 0.35F);
		this.addSmelting(ModItems.STEGOSAURUS_EGG, new ItemStack(ModItems.INCUBATED_ALLOSAURUS), 0.35F);
		this.addSmelting(ModItems.ANKYLOSAURUS_EGG, new ItemStack(ModItems.INC_ANKYLOSAURUS), 0.35F);
		this.addSmelting(ModItems.BARYONYX_EGG, new ItemStack(ModItems.INC_BARYONYX), 0.35F);
		this.addSmelting(ModItems.PARASAUROLOPHUS_EGG, new ItemStack(ModItems.INC_PARASAUROLOPHUS), 0.35F);
		this.addSmelting(ModItems.PRENOCEPHALE_EGG, new ItemStack(ModItems.INC_PRENOCEPHALE), 0.35F);
		this.addSmelting(Items.EGG, new ItemStack(ModItems.INCUBATED_CHICKEN), 0.35F);
	}

	/**
	 * Adds a smelting recipe, where the input item is an instance of Block.
	 */
	public void addSmeltingRecipeForBlock(Block input, ItemStack stack, float experience) {
		this.addSmelting(Item.getItemFromBlock(input), stack, experience);
	}

	/**
	 * Adds a smelting recipe using an Item as the input item.
	 */
	public void addSmelting(Item input, ItemStack stack, float experience) {
		this.addSmeltingRecipe(new ItemStack(input, 1, 32767), stack, experience);
	}

	/**
	 * Adds a smelting recipe using an ItemStack as the input for the recipe.
	 */
	public void addSmeltingRecipe(ItemStack input, ItemStack stack, float experience) {
		if (getSmeltingResult(input) != ItemStack.EMPTY) {
			net.minecraftforge.fml.common.FMLLog.log.info("Ignored smelting recipe with conflicting input: {} = {}",
					input, stack);
			return;
		}
		this.smeltingList.put(input, stack);
		this.experienceList.put(stack, Float.valueOf(experience));
	}

	/**
	 * Returns the smelting result of an item.
	 */
	public ItemStack getSmeltingResult(ItemStack stack) {
		for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return entry.getValue();
			}
		}

		return ItemStack.EMPTY;
	}

	/**
	 * Compares two itemstacks to ensure that they are the same. This checks both
	 * the item and the metadata of the item.
	 */
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem()
				&& (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}

	public Map<ItemStack, ItemStack> getSmeltingList() {
		return this.smeltingList;
	}

	public float getSmeltingExperience(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;

		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return ((Float) entry.getValue()).floatValue();
			}
		}

		return 0.0F;
	}
}