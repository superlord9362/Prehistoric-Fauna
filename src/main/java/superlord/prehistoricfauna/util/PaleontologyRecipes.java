package superlord.prehistoricfauna.util;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PaleontologyRecipes {
	private ItemStack stack;
	private NavigableMap<Float, ItemStack> outputMap = new TreeMap<Float, ItemStack>();
	private float totalWeight;

	public PaleontologyRecipes(ItemStack input) {
		this.stack = input;
	}

	public PaleontologyRecipes(Item input) {
		this.stack = new ItemStack(input);
	}

	@SuppressWarnings("deprecation")
	public PaleontologyRecipes(Block input) {
		this(Item.getItemFromBlock(input));
	}

	public PaleontologyRecipes addOutput(ItemStack stack, float weight) {
		totalWeight += weight;
		outputMap.put(totalWeight, stack);
		return this;
	}

	public ItemStack getInput() {
		return stack;
	}

	public ItemStack generateOutput(Random random) {
		if(totalWeight < 100){
			if(random.nextFloat() >= totalWeight * 0.01F){
				return ItemStack.EMPTY;
			}
		}
		float entry = random.nextFloat() * totalWeight;
		return outputMap.higherEntry(entry).getValue().copy();
	}

	public NavigableMap<Float, ItemStack> getDisplayMap() {
		return outputMap;
	}

	public float getTotalWeight() {
		return totalWeight;
	}
}