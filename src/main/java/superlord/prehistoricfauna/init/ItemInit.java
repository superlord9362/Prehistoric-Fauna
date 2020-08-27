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
import superlord.prehistoricfauna.PrehistoricFauna.PFBook;
import superlord.prehistoricfauna.PrehistoricFauna.PFEggs;
import superlord.prehistoricfauna.PrehistoricFauna.PFEntities;
import superlord.prehistoricfauna.PrehistoricFauna.PFPlants;
import superlord.prehistoricfauna.entity.PrehistoricBoatEntity;
import superlord.prehistoricfauna.item.CustomArmorItem;
import superlord.prehistoricfauna.item.PaleopediaItem;
import superlord.prehistoricfauna.item.PrehistoricBoatItem;
import superlord.prehistoricfauna.util.ArmorMaterialInit;;

public class ItemInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PrehistoricFauna.MODID);

	//Spawn eggs
	public static final RegistryObject<SpawnEggItem> THESCELOSAURUS_SPAWN_EGG = ITEMS.register("thescelosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.THESCELOSAURUS_ENTITY, 0x582C20, 0x000000, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> TRICERATOPS_SPAWN_EGG = ITEMS.register("triceratops_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.TRICERATOPS_ENTITY, 0x494427, 0x000000, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> ANKYLOSAURUS_SPAWN_EGG = ITEMS.register("ankylosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.ANKYLOSAURUS_ENTITY, 0x696726, 0x1F1E13, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> TYRANNOSAURUS_SPAWN_EGG = ITEMS.register("tyrannosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.TYRANNOSAURUS_ENTITY, 0x56483E, 0x614C38, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> BASILEMYS_SPAWN_EGG = ITEMS.register("basilemys_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.BASILEMYS_ENTITY, 0x6B3727, 0x373519, new Item.Properties().group(PFEggs.instance))); 
	public static final RegistryObject<SpawnEggItem> DAKOTARAPTOR_SPAWN_EGG = ITEMS.register("dakotaraptor_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.DAKOTARAPTOR_ENTITY, 0x453018, 0x986529, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> DIDELPHODON_SPAWN_EGG = ITEMS.register("didelphodon_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.DIDELPHODON_ENTITY, 0x3E2419, 0xAF9663, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> ALLOSAURUS_SPAWN_EGG = ITEMS.register("allosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.ALLOSAURUS_ENTITY, 0x5E5D2D, 0x643F23, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> STEGOSAURUS_SPAWN_EGG = ITEMS.register("stegosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.STEGOSAURUS_ENTITY, 0xB0A047, 0x875D2A, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> CERATOSAURUS_SPAWN_EGG = ITEMS.register("ceratosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.CERATOSAURUS_ENTITY, 0x352217, 0x4056A0, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> DRYOSAURUS_SPAWN_EGG = ITEMS.register("dryosaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.DRYOSAURUS_ENTITY, 0x8E6746, 0x629698, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> HESPERORNITHOIDES_SPAWN_EGG = ITEMS.register("hesperornithoides_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.HESPERORNITHOIDES_ENTITY, 0x1F667D, 0x6F97A5, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> EILENODON_SPAWN_EGG = ITEMS.register("eilenodon_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.EILENODON_ENTITY, 0xA57B48, 0x84A36A, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> CAMARASAURUS_SPAWN_EGG = ITEMS.register("camarasaurus_spawn_egg", () -> new SpawnEggItem(ModEntityTypes.CAMARASAURUS_ENTITY, 0x7E5E2D, 0x7E311C, new Item.Properties().group(PFEggs.instance)));
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
	public static final RegistryObject<Item> RAW_ALLOSAURUS_MEAT = ITEMS.register("raw_allosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(4).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_ALLOSAURUS_MEAT = ITEMS.register("cooked_allosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(8).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_STEGOSAURUS_MEAT = ITEMS.register("raw_stegosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(3).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_STEGOSAURUS_MEAT = ITEMS.register("cooked_stegosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(8).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_CERATOSAURUS_MEAT = ITEMS.register("raw_ceratosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(3).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_CERATOSAURUS_MEAT = ITEMS.register("cooked_ceratosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(7).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_DRYOSAURUS_MEAT = ITEMS.register("raw_dryosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(2).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_DRYOSAURUS_MEAT = ITEMS.register("cooked_dryosaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(6).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_HESPERORNITHOIDES_MEAT = ITEMS.register("raw_hesperornithoides_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(2).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_HESPERORNITHOIDES_MEAT = ITEMS.register("cooked_hesperornithoides_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(6).saturation(0.6F).meat().build())));
	public static final RegistryObject<Item> RAW_CAMARASAURUS_MEAT = ITEMS.register("raw_camarasaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(6).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_CAMARASAURUS_MEAT = ITEMS.register("cooked_camarasaurus_meat", () -> new Item(new Item.Properties().group(PFEntities.instance).food(new Food.Builder().hunger(12).saturation(0.8F).meat().build())));
	//Armor
	public static final RegistryObject<CustomArmorItem> ANKYLOSAURUS_HELMET = ITEMS.register("ankylosaurus_helmet", () -> new CustomArmorItem(ArmorMaterialInit.ANKYLOSAURUS, EquipmentSlotType.HEAD, new Item.Properties().group(PFEntities.instance)));
	public static final RegistryObject<ArmorItem> ANKYLOSAURUS_CHESTPLATE = ITEMS.register("ankylosaurus_chestplate", () -> new ArmorItem(ArmorMaterialInit.ANKYLOSAURUS, EquipmentSlotType.CHEST, new Item.Properties().group(PFEntities.instance)));
	//Paleopedia
	public static final RegistryObject<PaleopediaItem> PALEOPEDIA = ITEMS.register("paleopedia", () -> new PaleopediaItem());
	public static final RegistryObject<Item> PALEOPAGE = ITEMS.register("paleopage", () -> new Item(new Item.Properties().group(PFBook.instance)));
	//Boats
	public static final RegistryObject<PrehistoricBoatItem> ARAUCARIA_BOAT = ITEMS.register("araucaria_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.ARAUCARIA, (new Item.Properties().maxStackSize(1).group(PFBook.instance))));
	public static final RegistryObject<PrehistoricBoatItem> METASEQUOIA_BOAT = ITEMS.register("metasequoia_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.METASEQUOIA, (new Item.Properties().maxStackSize(1).group(PFBook.instance))));
	public static final RegistryObject<PrehistoricBoatItem> PROTOPICEOXYLON_BOAT = ITEMS.register("protopiceoxylon_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.PROTOPICEOXYLON, (new Item.Properties().maxStackSize(1).group(PFBook.instance))));
	public static final RegistryObject<PrehistoricBoatItem> ZAMITES_BOAT = ITEMS.register("zamites_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.ZAMITES, (new Item.Properties().maxStackSize(1).group(PFBook.instance))));
	public static final RegistryObject<PrehistoricBoatItem> PROTOJUNIPER_BOAT = ITEMS.register("protojuniper_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.PROTOJUNIPER, (new Item.Properties().maxStackSize(1).group(PFBook.instance))));
	
}
