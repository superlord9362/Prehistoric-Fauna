package superlord.prehistoricfauna.init;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.recipe.RecipePaleontologyTable;
import superlord.prehistoricfauna.common.entity.block.recipe.SerializerRecipePaleontologyTable;

public class PFRecipes
{
	public static final DeferredRegister<RecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<SerializerRecipePaleontologyTable> RECIPE_SERIALIZER_PALEONTOLOGY_TABLE = REGISTER.register("recipe_paleontology_table", () -> new SerializerRecipePaleontologyTable(RecipePaleontologyTable::new));
}
