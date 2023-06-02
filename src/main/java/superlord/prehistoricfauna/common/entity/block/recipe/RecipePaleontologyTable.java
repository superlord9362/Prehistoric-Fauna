package superlord.prehistoricfauna.common.entity.block.recipe;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.server.ServerLifecycleHooks;
import superlord.prehistoricfauna.PrehistoricFauna;

public class RecipePaleontologyTable implements Recipe<SimpleContainer> {
	
	private final ResourceLocation id;
	private final ResourceLocation output;
	private final NonNullList<Ingredient> recipeItems;
	
	public RecipePaleontologyTable(ResourceLocation id, ResourceLocation output, NonNullList<Ingredient> recipeItems) {
		this.id = id;
		this.output = output;
		this.recipeItems = recipeItems;
	}
	
	@Override
	public boolean matches(SimpleContainer container, Level world) {
		return !recipeItems.isEmpty() && recipeItems.get(0).test(container.getItem(0));
	}
	
	@Override
	public ItemStack assemble(SimpleContainer container) {
		MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
		ServerLevel level = server.getLevel(Level.OVERWORLD);
		if (null == level) {
			return ItemStack.EMPTY;
		}
		LootTable loottable = ServerLifecycleHooks.getCurrentServer().getLootTables().get(getResultLootTable());
		List<ItemStack> randomItems = loottable.getRandomItems(new LootContext.Builder(level).withRandom(level.getRandom()).withParameter(LootContextParams.ORIGIN, Vec3.ZERO).create(LootContextParamSets.CHEST));
		if (randomItems.isEmpty()) {
			return ItemStack.EMPTY;
		}
		return randomItems.get(0);
	}
	
	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}
	
	@Override
	public ItemStack getResultItem() {
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
	
	public ResourceLocation getResultLootTable() {
		return output;
	}
	
	public static class Type implements RecipeType<RecipePaleontologyTable> {
		private Type() {
			
		}
		
		public static final Type INSTANCE = new Type();
		
	}
	
	public static class Serializer implements RecipeSerializer<RecipePaleontologyTable> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation(PrehistoricFauna.MOD_ID, "paleontology_table");
		
		@Override
		public RecipePaleontologyTable fromJson(ResourceLocation id, JsonObject json) {
			ResourceLocation output = ResourceLocation.tryParse(GsonHelper.getAsString(json, "output"));
			JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}
			return new RecipePaleontologyTable(id, output, inputs);
		}
		
		@Override
		public RecipePaleontologyTable fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromNetwork(buf));
			}
			ResourceLocation output = buf.readResourceLocation();
			return new RecipePaleontologyTable(id, output, inputs);
		}
		
		@Override
		public void toNetwork(FriendlyByteBuf buf, RecipePaleontologyTable recipe) {
			buf.writeInt(recipe.getIngredients().size());
			for (Ingredient ingredient : recipe.getIngredients()) {
				ingredient.toNetwork(buf);
			}
			buf.writeResourceLocation(recipe.output);
		}
		
		public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
			return INSTANCE;
		}
		
		public ResourceLocation getRegistryName() {
			return ID;
		}
		
		public Class<RecipeSerializer<?>> getRegistryType() {
			return Serializer.castClass(RecipeSerializer.class);
		}
		
		@SuppressWarnings("unchecked")
		private static <G> Class<G> castClass(Class<?> clas) {
			return (Class<G>)clas;
		}
		
	}

}
