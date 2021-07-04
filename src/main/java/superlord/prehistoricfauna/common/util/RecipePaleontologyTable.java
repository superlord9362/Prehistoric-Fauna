package superlord.prehistoricfauna.common.util;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.tile.PaleontologyTableTileEntity;
import superlord.prehistoricfauna.init.PFRecipes;

public class RecipePaleontologyTable implements IRecipe<IInventory>
{
	public static final IRecipeType<IRecipe<IInventory>> RECIPE_TYPE_PALEONTOLOGY_TABLE = IRecipeType.register(PrehistoricFauna.MOD_ID + ":recipe_paleontology_table");

	private final IRecipeSerializer<?> serializer;
	private final IRecipeType<?> type;
	protected final ResourceLocation location;
	protected final String group;
	protected final ItemStack input;
	protected final PaleontologyTableResult results;

	public RecipePaleontologyTable(ResourceLocation location, String group, ItemStack input, PaleontologyTableResult results)
	{
		this.serializer = PFRecipes.RECIPE_SERIALIZER_PALEONTOLOGY_TABLE.get();
		this.type = RecipePaleontologyTable.RECIPE_TYPE_PALEONTOLOGY_TABLE;
		this.location = location;
		this.group = group;
		this.input = input;
		this.results = results;
	}

	@Override
	public IRecipeSerializer<?> getSerializer()
	{
		return this.serializer;
	}

	@Override
	public IRecipeType<?> getType()
	{
		return this.type;
	}

	@Override
	public ResourceLocation getId()
	{
		return this.location;
	}

	@Override
	public String getGroup()
	{
		return this.group;
	}

	@Override
	public boolean canFit(int width, int height)
	{
		return true;
	}

	@Override
	public NonNullList<Ingredient> getIngredients()
	{
		NonNullList<Ingredient> nonNullList = NonNullList.create();
		nonNullList.add(Ingredient.fromStacks(this.input.copy()));
		return nonNullList;
	}

	@Override
	public ItemStack getRecipeOutput()
	{
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack getCraftingResult(IInventory iInventory)
	{
		return this.results.next().copy();
	}

	@Override
	public boolean matches(IInventory iInventory, World worldIn)
	{
		return this.input.isItemEqual(iInventory.getStackInSlot(PaleontologyTableTileEntity.SLOT_FOSSIL));
	}
}
