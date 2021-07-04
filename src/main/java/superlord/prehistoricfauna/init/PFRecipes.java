package superlord.prehistoricfauna.init;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.util.SerializerRecipePaleontologyTable;
import superlord.prehistoricfauna.common.util.RecipePaleontologyTable;

public class PFRecipes
{
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<SerializerRecipePaleontologyTable> RECIPE_SERIALIZER_PALEONTOLOGY_TABLE = PFRecipes.RECIPES.register("recipe_paleontology_table", () -> new SerializerRecipePaleontologyTable(RecipePaleontologyTable::new));
}
