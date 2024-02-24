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
	public static final TagKey<Block> HARDENED_SILT_NESTS = registerBlockTag("hardened_silt_nests");
	public static final TagKey<Block> NESTS = registerBlockTag("nests");
	public static final TagKey<Block> SOFT_SHELL_EGG_BLOCKS = registerBlockTag("soft_shell_eggs");
	public static final TagKey<Item> PLANTS_2_HUNGER_ITEM = registerItemTag("two_hunger_plants");
	public static final TagKey<Item> INSECTS_2_HUNGER_ITEM = registerItemTag("two_hunger_insects");
	public static final TagKey<Item> PLANTS_4_HUNGER_ITEM = registerItemTag("four_hunger_plants");
	public static final TagKey<Item> PLANTS_6_HUNGER_ITEM = registerItemTag("six_hunger_plants");
	public static final TagKey<Item> PLANTS_8_HUNGER_ITEM = registerItemTag("eight_hunger_plants");
	public static final TagKey<Item> PLANTS_10_HUNGER_ITEM = registerItemTag("ten_hunger_plants");
	public static final TagKey<Item> PLANTS_12_HUNGER_ITEM = registerItemTag("twelve_hunger_plants");
	public static final TagKey<Item> PLANTS_15_HUNGER_ITEM = registerItemTag("fifteen_hunger_plants");
	public static final TagKey<Item> PLANTS_20_HUNGER_ITEM = registerItemTag("twenty_hunger_plants");
	public static final TagKey<Item> PLANTS_25_HUNGER_ITEM = registerItemTag("twenty_five_hunger_plants");
	public static final TagKey<Item> PLANTS_30_HUNGER_ITEM = registerItemTag("thirty_hunger_plants");
	public static final TagKey<Item> SOFT_SHELL_EGGS = registerItemTag("soft_shell_eggs");
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
	public static final TagKey<EntityType<?>> ANIMALS_80_HUNGER = registerEntityTag("eighty_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_100_HUNGER = registerEntityTag("one_hundred_hunger_animals");
	public static final TagKey<EntityType<?>> ANIMALS_200_HUNGER = registerEntityTag("two_hundreed_hunger_animals");
	public static final TagKey<EntityType<?>> INSECTS_2_HUNGER = registerEntityTag("two_hunger_insects");
	
	public static final TagKey<EntityType<?>> CITIPATI_HUNTING = registerEntityTag("citipati_hunting");
	public static final TagKey<EntityType<?>> CITIPATI_BABY_HUNTING = registerEntityTag("citipati_baby_hunting");
	public static final TagKey<EntityType<?>> TELMASAURUS_HUNTING = registerEntityTag("telmasaurus_hunting");
	public static final TagKey<EntityType<?>> TELMASAURUS_BABY_HUNTING = registerEntityTag("telmasaurus_baby_hunting");
	public static final TagKey<EntityType<?>> VELOCIRAPTOR_HUNTING = registerEntityTag("velociraptor_hunting");
	public static final TagKey<EntityType<?>> VELOCIRAPTOR_BABY_HUNTING = registerEntityTag("velociraptor_baby_hunting");
	public static final TagKey<EntityType<?>> DAKOTARAPTOR_HUNTING = registerEntityTag("dakotaraptor_hunting");
	public static final TagKey<EntityType<?>> DAKOTARAPTOR_BABY_HUNTING = registerEntityTag("dakotaraptor_baby_hunting");
	public static final TagKey<EntityType<?>> DIDELPHODON_HUNTING = registerEntityTag("didelphodon_hunting");
	public static final TagKey<EntityType<?>> DIDELPHODON_BABY_HUNTING = registerEntityTag("didelphodon_baby_hunting");
	public static final TagKey<EntityType<?>> TYRANNOSAURUS_HUNTING = registerEntityTag("tyrannosaurus_hunting");
	public static final TagKey<EntityType<?>> TYRANNOSAURUS_JUVENILE_HUNTING = registerEntityTag("tyrannosaurus_juvenile_hunting");
	public static final TagKey<EntityType<?>> TYRANNOSAURUS_BABY_HUNTING = registerEntityTag("tyrannosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> CALSOYASUCHUS_HUNTING = registerEntityTag("calsoyasuchus_hunting");
	public static final TagKey<EntityType<?>> CALSOYASUCHUS_BABY_HUNTING = registerEntityTag("calsoyasuchus_baby_hunting");
	public static final TagKey<EntityType<?>> DILOPHOSAURUS_HUNTING = registerEntityTag("dilophosaurus_hunting");
	public static final TagKey<EntityType<?>> DILOPHOSAURUS_BABY_HUNTING = registerEntityTag("dilophosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> MEGAPNOSAURUS_HUNTING = registerEntityTag("megapnosaurus_hunting");
	public static final TagKey<EntityType<?>> MEGAPNOSAURUS_BABY_HUNTING = registerEntityTag("megapnosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> ALLOSAURUS_HUNTING = registerEntityTag("allosaurus_hunting");
	public static final TagKey<EntityType<?>> ALLOSAURUS_BABY_HUNTING = registerEntityTag("allosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> CERATOSAURUS_HUNTING = registerEntityTag("ceratosaurus_hunting");
	public static final TagKey<EntityType<?>> CERATOSAURUS_BABY_HUNTING = registerEntityTag("ceratosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> HESPERORNITHOIDES_HUNTING = registerEntityTag("hesperornithoides_hunting");
	public static final TagKey<EntityType<?>> HESPERORNITHOIDES_BABY_HUNTING = registerEntityTag("hesperornithoides_baby_hunting");
	public static final TagKey<EntityType<?>> COELOPHYSIS_HUNTING = registerEntityTag("coelophysis_hunting");
	public static final TagKey<EntityType<?>> COELOPHYSIS_BABY_HUNTING = registerEntityTag("coelophysis_baby_hunting");
	public static final TagKey<EntityType<?>> POPOSAURUS_HUNTING = registerEntityTag("poposaurus_hunting");
	public static final TagKey<EntityType<?>> POPOSAURUS_BABY_HUNTING = registerEntityTag("poposaurus_baby_hunting");
	public static final TagKey<EntityType<?>> POSTOSUCHUS_HUNTING = registerEntityTag("postosuchus_hunting");
	public static final TagKey<EntityType<?>> POSTOSUCHUS_BABY_HUNTING = registerEntityTag("postosuchus_baby_hunting");
	public static final TagKey<EntityType<?>> CHROMOGISAURUS_HUNTING = registerEntityTag("chromogisaurus_hunting");
	public static final TagKey<EntityType<?>> CHROMOGISAURUS_BABY_HUNTING = registerEntityTag("chromogisaurus_baby_hunting");
	public static final TagKey<EntityType<?>> HERRERASAURUS_HUNTING = registerEntityTag("herrerasaurus_hunting");
	public static final TagKey<EntityType<?>> HERRERASAURUS_BABY_HUNTING = registerEntityTag("herrerasaurus_baby_hunting");
	public static final TagKey<EntityType<?>> SAUROSUCHUS_HUNTING = registerEntityTag("saurosuchus_hunting");
	public static final TagKey<EntityType<?>> SAUROSUCHUS_BABY_HUNTING = registerEntityTag("saurosuchus_baby_hunting");
	public static final TagKey<EntityType<?>> THORACOSAURUS_HUNTING = registerEntityTag("thoracosaurus_hunting");
	public static final TagKey<EntityType<?>> THORACOSAURUS_BABY_HUNTING = registerEntityTag("thoracosaurus_baby_hunting");
	public static final TagKey<EntityType<?>> PALAEOSANIWA_HUNTING = registerEntityTag("palaeosaniwa_hunting");
	public static final TagKey<EntityType<?>> PALAEOSANIWA_BABY_HUNTING = registerEntityTag("palaeosaniwa_baby_hunting");
	public static final TagKey<EntityType<?>> OVIRAPTOR_HUNTING = registerEntityTag("oviraptor_hunting");
	public static final TagKey<EntityType<?>> OVIRAPTOR_BABY_HUNTING = registerEntityTag("oviraptor_baby_hunting");
	public static final TagKey<EntityType<?>> HALSZKARAPTOR_HUNTING = registerEntityTag("halszkaraptor_hunting");
	public static final TagKey<EntityType<?>> HALSZKARAPTOR_BABY_HUNTING = registerEntityTag("halszkaraptor_baby_hunting");
	public static final TagKey<EntityType<?>> ORNITHOMIMUS_HUNTING = registerEntityTag("ornithomimus_hunting");
	public static final TagKey<EntityType<?>> ORNITHOMIMUS_BABY_HUNTING = registerEntityTag("ornithomimus_baby_hunting");
	public static final TagKey<EntityType<?>> KOL_HUNTING = registerEntityTag("kol_hunting");
	public static final TagKey<EntityType<?>> KOL_BABY_HUNTING = registerEntityTag("kol_baby_hunting");
	public static final TagKey<EntityType<?>> YUTYRANNUS_HUNTING = registerEntityTag("yutyrannus_hunting");
	public static final TagKey<EntityType<?>> YUTYRANNUS_BABY_HUNTING = registerEntityTag("yutyrannus_baby_hunting");
	public static final TagKey<EntityType<?>> SINOSAUROPTERYX_HUNTING = registerEntityTag("sinosauropteryx_hunting");
	public static final TagKey<EntityType<?>> SINOSAUROPTERYX_BABY_HUNTING = registerEntityTag("sinosauropteryx_baby_hunting");
	public static final TagKey<EntityType<?>> INCISIVOSAURUS_HUNTING = registerEntityTag("incisivosaurus_hunting");
	public static final TagKey<EntityType<?>> INCISIVOSAURUS_BABY_HUNTING = registerEntityTag("incisivosaurus_baby_hunting");
	
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
	public static final TagKey<Block> FEEDERS = registerBlockTag("feeders");

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
