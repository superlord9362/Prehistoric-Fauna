package superlord.prehistoricfauna.common.recipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.tags.TagKey;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PaleontologyTableRecipeJsonManager extends SimpleJsonResourceReloadListener {

	private static final Gson STANDARD_GSON = new Gson();
	public static final Logger LOGGER = LogManager.getLogger();
	
	protected static Map<Item, List<ItemWeightedPairCodec>> recipeList = new HashMap<>();
	protected static Map<ResourceLocation, PaleontologyTableRecipeCodec> recipeListR1 = new HashMap<>();
	private final String folderName;
	
	public PaleontologyTableRecipeJsonManager() {
		this("prehistoricfauna/paleontology_table", STANDARD_GSON);
	}
	
	public PaleontologyTableRecipeJsonManager(String folderName, Gson gson) {
		super(gson, folderName);
		this.folderName = folderName;
	}
	
	public static Map<Item, List<ItemWeightedPairCodec>> getRecipes() {
		return recipeList;
	}
	
	public static void setRecipeList(Map<Item, List<ItemWeightedPairCodec>> recipeList) {
		PaleontologyTableRecipeJsonManager.recipeList = recipeList;
	}
	
	public static List<ItemWeightedPairCodec> getItems(Item item) {
		return recipeList.getOrDefault(item, Collections.emptyList());
	}
	
	public static boolean containsRecipe(Item item) {
		return recipeList.containsKey(item);
	}
	
	@SuppressWarnings("unused")
	public static ItemStack getRandomItemStack(Item input, Level level) {
		if (null == level) {
			return ItemStack.EMPTY;
		}
		
		Item outputItem = null;
		
		List<ItemWeightedPairCodec> outputs = recipeList.get(input);
		
		int totalWeight = 0;
		for (ItemWeightedPairCodec itemWeightedPair : outputs) {
			totalWeight += itemWeightedPair.getWeight();
		}
		
		int randomNr = level.random.nextInt(totalWeight);
		int cumulativeWeight = 0;
		
		for (ItemWeightedPairCodec itemWeightedPair : outputs) {
			cumulativeWeight += itemWeightedPair.getWeight();
			if (randomNr < cumulativeWeight) {
				outputItem = itemWeightedPair.getItem();
				break;
			}
		}
		
		ItemStack outputStack = new ItemStack(outputItem);
		if (outputStack == null) {
			return ItemStack.EMPTY;
		}
		return outputStack;
	}
	
	public static void populateRecipeMap(Level level) {
		recipeList.clear();
        Map<Item, List<ItemWeightedPairCodec>> weightedPairsTemp = new HashMap<>();
        for (ResourceLocation resourceLocation : recipeListR1.keySet()) {
            PaleontologyTableRecipeCodec paleontologyTableRecipeCodec = recipeListR1.get(resourceLocation);

            List<ResourceLocation> tagsRL = paleontologyTableRecipeCodec.getInputItemTags();
            List<ResourceLocation> itemsRL = paleontologyTableRecipeCodec.getInputItems();

            for (ResourceLocation tag : tagsRL) {
                TagKey<Item> itemTagKey = TagKey.create(Registries.ITEM, tag);
                level.registryAccess().registry(Registries.ITEM).ifPresent(reg -> {
                    Iterable<Holder<Item>> itemHolder = reg.getTagOrEmpty(itemTagKey);

                    for (Holder<Item> tempItemHolder : itemHolder) {
                        Item item = tempItemHolder.get();
                        if(weightedPairsTemp.containsKey(item)) LOGGER.warn("Item {} for resourceLocation {} already has items assigned, adding more", item, resourceLocation);
                        List<ItemWeightedPairCodec> weightedPairsList = weightedPairsTemp.getOrDefault(item, new ArrayList<>());
                        weightedPairsList.addAll(paleontologyTableRecipeCodec.getItemWeightedPairs());
                        weightedPairsTemp.put(item, weightedPairsList);

                    }
                    if (!itemHolder.iterator().hasNext()) {
                        LOGGER.error("Tag for {} does not have any items!", itemTagKey);
                        LOGGER.error("Analyzer recipe for {} might not have any items assigned, or it uses items from a mod, but the mod isn't installed!", resourceLocation);
                    }
                });
            }

            for (ResourceLocation items : itemsRL) {
                level.registryAccess().registry(Registries.ITEM).ifPresent(reg -> {
                    Item item = reg.get(items);
                    if(item == null) {
                        LOGGER.error("Item {} does not exist, currently parsing through {}!", items, resourceLocation);
                        LOGGER.error("Recipe for {} might not have any items assigned, or it uses items from a mod, but the mod isn't installed!", resourceLocation);
                        return;
                    }
                    if(weightedPairsTemp.containsKey(item)) LOGGER.warn("Item {} for resourceLocation {} already has items assigned, adding more", item, resourceLocation);
                    List<ItemWeightedPairCodec> weightedPairsList = weightedPairsTemp.getOrDefault(item, new ArrayList<>());
                    weightedPairsList.addAll(paleontologyTableRecipeCodec.getItemWeightedPairs());
                    weightedPairsTemp.put(item, weightedPairsList);
                });
            }
        }
        LOGGER.info("Registered {} jsons with items!", weightedPairsTemp.keySet().size());
        recipeList.putAll(weightedPairsTemp);
        weightedPairsTemp.clear();
	}
	
	@SuppressWarnings("static-access")
	@Override
	protected void apply(Map<ResourceLocation, JsonElement> jsons, ResourceManager resourceManager, ProfilerFiller profiler) {
		recipeList.clear();
		Map<ResourceLocation, PaleontologyTableRecipeCodec> recipeList = new HashMap<>();
		for (Map.Entry<ResourceLocation, JsonElement> entry : jsons.entrySet()) {
			ResourceLocation key = entry.getKey();
			JsonElement element = entry.getValue();
			PaleontologyTableRecipeCodec.CODEC.decode(JsonOps.INSTANCE, element).get().ifLeft(result -> {
				PaleontologyTableRecipeCodec paleontologyTableRecipe = result.getFirst();
				recipeList.put(key, paleontologyTableRecipe);
			}).ifRight(partial -> LOGGER.error("Failed to parse recipe JSON for {} due to: {}", this.folderName, partial.message()));
		}
		this.recipeListR1 = recipeList;
		LOGGER.info("Data loader for {} loaded {} jsons", this.folderName, this.recipeListR1.size());
	}
	
}
