package superlord.prehistoricfauna.common.entity.block.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.PrehistoricFauna;

public class RecipePaleontologyTable implements Recipe<SimpleContainer> {
	
	private final ResourceLocation id;
	private final NonNullList<Ingredient> recipeItem;
	
	public RecipePaleontologyTable(ResourceLocation id, NonNullList<Ingredient> recipeItems) {
		this.id = id;
		this.recipeItem = recipeItems;
	}
	
	@Override
	public boolean matches(SimpleContainer container, Level level) {
		return !recipeItem.isEmpty() && recipeItem.get(0).test(container.getItem(1));
	}
	
	@Override
	public ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
		return ItemStack.EMPTY;
	}
	
	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}
	
	public ItemStack getResultItem(RegistryAccess registryAccess) {
		return ItemStack.EMPTY;
	}
	
	@Override
	public ResourceLocation getId() {
		return id;
	}
	
	@Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItem;
    }
    
    public static class Type implements RecipeType<RecipePaleontologyTable> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "paleontology_table";
    }

    public static class Serializer implements RecipeSerializer<RecipePaleontologyTable> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(PrehistoricFauna.MOD_ID, "paleontology_table");

        @Override
        public RecipePaleontologyTable fromJson(ResourceLocation id, JsonObject json) {
            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new RecipePaleontologyTable(id, inputs);
        }

        @Override
        public RecipePaleontologyTable fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            return new RecipePaleontologyTable(id, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, RecipePaleontologyTable recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
        }
    }

}
