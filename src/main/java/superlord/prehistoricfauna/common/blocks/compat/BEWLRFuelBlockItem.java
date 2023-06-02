package superlord.prehistoricfauna.common.blocks.compat;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import superlord.prehistoricfauna.common.util.BEWLRBlockItem;

public class BEWLRFuelBlockItem extends BEWLRBlockItem {
	private final int burnTime;

	public BEWLRFuelBlockItem(Block block, Properties properties, Supplier<Callable<LazyBEWLR>> belwr, int burnTime) {
		super(block, properties, belwr);
		this.burnTime = burnTime;
	}

	@Override
	public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
		return this.burnTime;
	}
}