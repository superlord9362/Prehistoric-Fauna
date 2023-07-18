package superlord.prehistoricfauna.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFTags {

	public static final TagKey<Item> FOSSILS = registerItemTag("fossils");
	public static final TagKey<Block> HENOSTONE = registerBlockTag("henostone");
	public static final TagKey<Item> HENOSTONE_ITEM = registerItemTag("henostone");
	public static final TagKey<Block> PLANTS_2_HUNGER = registerBlockTag("two_hunger_plants");
	public static final TagKey<Block> PLANTS_4_HUNGER = registerBlockTag("four_hunger_plants");
	public static final TagKey<Block> PLANTS_6_HUNGER = registerBlockTag("six_hunger_plants");
	public static final TagKey<Block> PLANTS_8_HUNGER = registerBlockTag("eight_hunger_plants");
	public static final TagKey<Block> PLANTS_10_HUNGER = registerBlockTag("ten_hunger_plants");
	public static final TagKey<Block> PLANTS_12_HUNGER = registerBlockTag("twelve_hunger_plants");
	public static final TagKey<Block> PLANTS_15_HUNGER = registerBlockTag("fifteen_hunger_plants");
	public static final TagKey<Block> PLANTS_20_HUNGER = registerBlockTag("twenty_hunger_plants");
	public static final TagKey<Block> PLANTS_25_HUNGER = registerBlockTag("twenty_five_hunger_plants");
	public static final TagKey<Block> PLANTS_30_HUNGER = registerBlockTag("thirty_hunger_plants");
	public static final TagKey<Item> PLANTS_2_HUNGER_ITEM = registerItemTag("two_hunger_plants");
	public static final TagKey<Item> PLANTS_4_HUNGER_ITEM = registerItemTag("four_hunger_plants");
	public static final TagKey<Item> PLANTS_6_HUNGER_ITEM = registerItemTag("six_hunger_plants");
	public static final TagKey<Item> PLANTS_8_HUNGER_ITEM = registerItemTag("eight_hunger_plants");
	public static final TagKey<Item> PLANTS_10_HUNGER_ITEM = registerItemTag("ten_hunger_plants");
	public static final TagKey<Item> PLANTS_12_HUNGER_ITEM = registerItemTag("twelve_hunger_plants");
	public static final TagKey<Item> PLANTS_15_HUNGER_ITEM = registerItemTag("fifteen_hunger_plants");
	public static final TagKey<Item> PLANTS_20_HUNGER_ITEM = registerItemTag("twenty_hunger_plants");
	public static final TagKey<Item> PLANTS_25_HUNGER_ITEM = registerItemTag("twenty_five_hunger_plants");
	public static final TagKey<Item> PLANTS_30_HUNGER_ITEM = registerItemTag("thirty_hunger_plants");
	public static final TagKey<EntityType<?>> FISH_3_HUNGER = registerEntityTag("three_hunger_fish");
	public static final TagKey<EntityType<?>> ANIMALS_3_HUNGER = registerEntityTag("three_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_4_HUNGER = registerEntityTag("four_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_6_HUNGER = registerEntityTag("six_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_8_HUNGER = registerEntityTag("eight_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_10_HUNGER = registerEntityTag("ten_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_15_HUNGER = registerEntityTag("fifteen_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_20_HUNGER = registerEntityTag("twenty_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_30_HUNGER = registerEntityTag("thirty_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_40_HUNGER = registerEntityTag("forty_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_60_HUNGER = registerEntityTag("sixy_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_100_HUNGER = registerEntityTag("one_hundred_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_200_HUNGER = registerEntityTag("two_hundreed_hunger_animals");
	public static final TagKey<Item> MEATS_2_HUNGER = registerItemTag("two_hunger_meats");
	public static final TagKey<Item> MEATS_4_HUNGER = registerItemTag("four_hunger_meats");
	public static final TagKey<Item> MEATS_6_HUNGER = registerItemTag("six_hunger_meats");
	public static final TagKey<Item> MEATS_8_HUNGER = registerItemTag("eight_hunger_meats");
	public static final TagKey<Item> MEATS_10_HUNGER = registerItemTag("ten_hunger_meats");
	public static final TagKey<Item> MEATS_12_HUNGER = registerItemTag("twelve_hunger_meats");
	public static final TagKey<Item> FISH_2_HUNGER = registerItemTag("two_hunger_fish");
	public static final TagKey<Item> FISH_4_HUNGER = registerItemTag("four_hunger_fish");
	public static final TagKey<Item> EGGS_5_HUNGER = registerItemTag("five_hunger_eggs");
	public static final TagKey<Item> EGGS_10_HUNGER = registerItemTag("ten_hunger_eggs");
	public static final TagKey<Item> EGGS_15_HUNGER = registerItemTag("fifteen_hunger_eggs");
	public static final TagKey<Item> SHELLFISH_3_HUNGER = registerItemTag("three_hunger_shellfish");

	private static TagKey<Item> registerItemTag(String name) {
		return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

	private static TagKey<EntityType<?>> registerEntityTag(String name) {
		return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

	private static TagKey<Block> registerBlockTag(String name) {
		return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

}
