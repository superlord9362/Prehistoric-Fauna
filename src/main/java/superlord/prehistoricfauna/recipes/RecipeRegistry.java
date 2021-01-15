package superlord.prehistoricfauna.recipes;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;

public class RecipeRegistry
{
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PrehistoricFauna.MODID);

	public static final RegistryObject<SerializerRecipePaleontologyTable> RECIPE_SERIALIZER_PALEONTOLOGY_TABLE = RecipeRegistry.RECIPES.register("recipe_paleontology_table", () -> new SerializerRecipePaleontologyTable(RecipePaleontologyTable::new));
}
