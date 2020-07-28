package superlord.prehistoricfauna.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.PrehistoricFauna.PFEntities;
import superlord.prehistoricfauna.PrehistoricFauna.PFPlants;
//import superlord.prehistoricfauna.PrehistoricFauna.PFWood;
//import superlord.prehistoricfauna.entity.PrehistoricBoatEntity;
import superlord.prehistoricfauna.item.CustomArmorItem;
//import superlord.prehistoricfauna.item.PrehistoricBoatItem;
import superlord.prehistoricfauna.util.ArmorMaterialInit;;

public class ItemInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PrehistoricFauna.MODID);

	//Spawn eggs
	public static final RegistryObject<SpawnEggItem> THESCELOSAURUS_SPAWN_EGG = ITEMS.register("thescelosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.THESCELOSAURUS_ENTITY, 0x582C20, 0x000000, new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<SpawnEggItem> TRICERATOPS_SPAWN_EGG = ITEMS.register("triceratops_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.TRICERATOPS_ENTITY, 0x494427, 0x000000, new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<SpawnEggItem> ANKYLOSAURUS_SPAWN_EGG = ITEMS.register("ankylosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.ANKYLOSAURUS_ENTITY, 0x696726, 0x1F1E13, new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<SpawnEggItem> TYRANNOSAURUS_SPAWN_EGG = ITEMS.register("tyrannosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.TYRANNOSAURUS_ENTITY, 0x56483E, 0x614C38, new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<SpawnEggItem> BASILEMYS_SPAWN_EGG = ITEMS.register("basilemys_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.BASILEMYS_ENTITY, 0x6B3727, 0x373519, new Item.Properties().group(PFEntities.instance))); 
	public static final RegistryObject<SpawnEggItem> DAKOTARAPTOR_SPAWN_EGG = ITEMS.register("dakotaraptor_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.DAKOTARAPTOR_ENTITY, 0x453018, 0x986529, new Item.Properties().group(PFEntities.instance)));
	//public static final RegistryObject<Item> ARAUCARIA_BOAT = ITEMS.register("araucaria_boat",() -> new PrehistoricBoatItem(PrehistoricBoatEntity.Type.ARAUCARIA, (new Item.Properties().group(PFWood.instance).maxStackSize(1))));
	//public static final RegistryObject<Item> METASEQUOIA_BOAT = ITEMS.register("metasequoia_boat",() -> new PrehistoricBoatItem(PrehistoricBoatEntity.Type.METASEQUOIA, (new Item.Properties().group(PFWood.instance).maxStackSize(1))));
	//Drops
	public static final RegistryObject<Item> TYRANNOSAURUS_TOOTH = ITEMS.register("tyrannosaurus_tooth", () -> new Item(new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<Item> TAIL_CLUB = ITEMS.register("tail_club", () -> new Item(new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<Item> TRICERATOPS_HORN = ITEMS.register("triceratops_horn", () -> new Item(new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<Item> ANKYLOSAURUS_SCUTE = ITEMS.register("ankylosaurus_scute", () -> new Item(new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<Item> DAKOTARAPTOR_CLAW = ITEMS.register("dakotaraptor_claw", () -> new Item(new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<Item> MOSS_BALL = ITEMS.register("moss_ball", () -> new Item(new Item.Properties().group(PFPlants.instance)));
	//Meat
	public static final RegistryObject<Item> RAW_ANKYLOSAURUS_MEAT = ITEMS.register("raw_ankylosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(4).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_ANKYLOSAURUS_MEAT = ITEMS.register("cooked_ankylosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(9).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_TYRANNOSAURUS_MEAT = ITEMS.register("raw_tyrannosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(5).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_TYRANNOSAURUS_MEAT = ITEMS.register("cooked_tyrannosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(10).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_TRICERATOPS_MEAT = ITEMS.register("raw_triceratops_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(5).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_TRICERATOPS_MEAT = ITEMS.register("cooked_triceratops_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(10).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_THESCELOSAURUS_MEAT = ITEMS.register("raw_thescelosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(2).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_THESCELOSAURUS_MEAT = ITEMS.register("cooked_thescelosaurus_meat",() -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(6).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_DAKOTARAPTOR_MEAT = ITEMS.register("raw_dakotaraptor_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(3).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_DAKOTARAPTOR_MEAT = ITEMS.register("cooked_dakotaraptor_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(7).saturation(0.8F).meat().build())));
	//Armor
	public static final RegistryObject<CustomArmorItem> ANKYLOSAURUS_HELMET = ITEMS.register("ankylosaurus_helmet", () -> new CustomArmorItem(ArmorMaterialInit.ANKYLOSAURUS, EquipmentSlotType.HEAD, new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<ArmorItem> ANKYLOSAURUS_CHESTPLATE = ITEMS.register("ankylosaurus_chestplate", () -> new ArmorItem(ArmorMaterialInit.ANKYLOSAURUS, EquipmentSlotType.CHEST, new Item.Properties().group(PFEntities.instance)));

}
