package superlord.prehistoricfauna.common.entity.block.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class SerializerRecipePaleontologyTable extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<RecipePaleontologyTable>
{
	protected final IRecipeFactory<RecipePaleontologyTable> factory;

	public SerializerRecipePaleontologyTable(IRecipeFactory<RecipePaleontologyTable> factory)
	{
		this.factory = factory;
	}

	@Override
	public RecipePaleontologyTable fromJson(ResourceLocation location, JsonObject json)
	{
		String group = GsonHelper.getAsString(json, "group", "");
		ItemStack input = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "input"));

		PaleontologyTableResult.Builder builder = new PaleontologyTableResult.Builder();
		JsonArray resultArray = GsonHelper.getAsJsonArray(json, "results");
		for (JsonElement resultElement : resultArray)
		{
			JsonObject resultEntry = resultElement.getAsJsonObject();
			builder.add(GsonHelper.isValidNode(resultEntry, "weight") ? GsonHelper.getAsFloat((JsonObject) resultEntry.get("weight"), "weight") : 1.0F, ShapedRecipe.itemStackFromJson(resultEntry));
		}

		return this.factory.create(location, group, input, builder.build());
	}

	@Override
	public RecipePaleontologyTable fromNetwork(ResourceLocation location, FriendlyByteBuf buffer)
	{
		String group = buffer.readUtf(32767);
		ItemStack input = buffer.readItem();
		PaleontologyTableResult results = PaleontologyTableResult.read(buffer);

		return this.factory.create(location, group, input, results);
	}

	@Override
	public void toNetwork(FriendlyByteBuf buffer, RecipePaleontologyTable recipe)
	{
		buffer.writeUtf(recipe.group);
		buffer.writeItem(recipe.input);
		recipe.results.write(buffer);
	}

	public interface IRecipeFactory<T extends RecipePaleontologyTable>
	{
		T create(ResourceLocation location, String group, ItemStack input, PaleontologyTableResult results);
	}

}
