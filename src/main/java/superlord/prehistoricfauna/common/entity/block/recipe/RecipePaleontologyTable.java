package superlord.prehistoricfauna.common.entity.block.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.PaleontologyTableBlockEntity;
import superlord.prehistoricfauna.init.PFRecipes;

public class RecipePaleontologyTable implements Recipe<Container>
{
	public static final RecipeType<Recipe<Container>> RECIPE_TYPE_PALEONTOLOGY_TABLE = RecipeType.register(PrehistoricFauna.MOD_ID + ":recipe_paleontology_table");

	private final RecipeSerializer<?> serializer;
	private final RecipeType<?> type;
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
	public RecipeSerializer<?> getSerializer()
	{
		return this.serializer;
	}

	@Override
	public RecipeType<?> getType()
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
	public boolean canCraftInDimensions(int width, int height)
	{
		return true;
	}

	@Override
	public NonNullList<Ingredient> getIngredients()
	{
		NonNullList<Ingredient> nonNullList = NonNullList.create();
		nonNullList.add(Ingredient.of(this.input.copy()));
		return nonNullList;
	}

	@Override
	public ItemStack getResultItem()
	{
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack assemble(Container iInventory)
	{
		return this.results.next().copy();
	}

	@Override
	public boolean matches(Container iInventory, Level worldIn)
	{
		return this.input.sameItem(iInventory.getItem(PaleontologyTableBlockEntity.SLOT_FOSSIL));
	}
}
