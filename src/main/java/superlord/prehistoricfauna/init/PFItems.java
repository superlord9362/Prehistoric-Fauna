package superlord.prehistoricfauna.init;

import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BannerPatternItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.SoupItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.BannerPattern;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.PrehistoricFauna.PFBuilding;
import superlord.prehistoricfauna.PrehistoricFauna.PFDecoration;
import superlord.prehistoricfauna.PrehistoricFauna.PFEggs;
import superlord.prehistoricfauna.PrehistoricFauna.PFFood;
import superlord.prehistoricfauna.PrehistoricFauna.PFMisc;
import superlord.prehistoricfauna.PrehistoricFauna.PFSkeleton;
import superlord.prehistoricfauna.common.entities.PrehistoricBoatEntity;
import superlord.prehistoricfauna.common.items.CretaceousTimeTotemItem;
import superlord.prehistoricfauna.common.items.CustomArmorItem;
import superlord.prehistoricfauna.common.items.CustomChestplateItem;
import superlord.prehistoricfauna.common.items.FossilItem;
import superlord.prehistoricfauna.common.items.HorsetailTeaItem;
import superlord.prehistoricfauna.common.items.JurassicTimeTotemItem;
import superlord.prehistoricfauna.common.items.PFHoeItem;
import superlord.prehistoricfauna.common.items.PFSignItem;
import superlord.prehistoricfauna.common.items.PaleopaintingItem;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.items.PrehistoricBoatItem;
import superlord.prehistoricfauna.common.items.PrehistoricSpawnEggItem;
import superlord.prehistoricfauna.common.items.SpawnSkeletonItem;
import superlord.prehistoricfauna.common.items.TriassicTimeTotemItem;
import superlord.prehistoricfauna.common.items.WallFossilItem;
import superlord.prehistoricfauna.common.util.ArmorMaterialInit;
import superlord.prehistoricfauna.common.util.PFItemTiers;

public class PFItems {

	public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PrehistoricFauna.MOD_ID);

	//Spawn eggs
	//Aepyornithomimus Citipati Pinacosaurus Plesiohadros Protoceratops Telmasaurus Velociraptor
	//Ankylosaurus Basilemys Cyclurus Dakotaraptor Didelphodon Gar Myledaphus Thescelosaurus Triceratops Tyrannosaurus
	//Calsoyasuchus Dilophosaurus Kayentatherium Megapnosaurus Sarahsaurus Scelidosaurus Scutellosaurus
	//Allosaurus Camarasaurus Ceratodus Ceratosaurus Dryosaurus Eilenodon Hesperonithoides Potamoceratodus Stegosaurus
	//
	//Chromogisaurus Exaeretodon Herrerasaurus Hyperodapedon Ischigualastia Saurosuchus Sillosuchus
	//Djadochta
	public static final RegistryObject<PrehistoricSpawnEggItem> AEPYORNITHOMIMUS_SPAWN_EGG = REGISTER.register("aepyornithomimus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.AEPYORNITHOMIMUS_ENTITY, 0x1E1E23, 0x512626, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> CITIPATI_SPAWN_EGG = REGISTER.register("citipati_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.CITIPATI_ENTITY, 0x704121, 0xD5AA7C, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> PINACOSAURUS_SPAWN_EGG = REGISTER.register("pinacosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.PINACOSAURUS_ENTITY, 0xAB583F, 0x7CA2B5, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> PLESIOHADROS_SPAWN_EGG = REGISTER.register("plesiohadros_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.PLESIOHADROS_ENTITY, 0x4FAB90, 0x55614D, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> PROTOCERATOPS_SPAWN_EGG = REGISTER.register("protoceratops_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.PROTOCERATOPS_ENTITY, 0x855030, 0xC6BCAB, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> TELMASAURUS_SPAWN_EGG = REGISTER.register("telmasaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.TELMASAURUS_ENTITY, 0xCCA572, 0x60524D, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> VELOCIRAPTOR_SPAWN_EGG = REGISTER.register("velociraptor_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.VELOCIRAPTOR_ENTITY, 0x3A332D, 0xE9E3D3, new Item.Properties().group(PFEggs.instance)));

	//Hell Creek
	public static final RegistryObject<PrehistoricSpawnEggItem> ANKYLOSAURUS_SPAWN_EGG = REGISTER.register("ankylosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.ANKYLOSAURUS_ENTITY, 0x202C0C, 0x908730, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> BASILEMYS_SPAWN_EGG = REGISTER.register("basilemys_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.BASILEMYS_ENTITY, 0x6B3727, 0x373519, new Item.Properties().group(PFEggs.instance))); 
	public static final RegistryObject<PrehistoricSpawnEggItem> CYCLURUS_SPAWN_EGG = REGISTER.register("cyclurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.CYCLURUS, 0x5E6B3B, 0x968B53, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> DAKOTARAPTOR_SPAWN_EGG = REGISTER.register("dakotaraptor_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.DAKOTARAPTOR_ENTITY, 0x453018, 0x986529, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> DIDELPHODON_SPAWN_EGG = REGISTER.register("didelphodon_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.DIDELPHODON_ENTITY, 0x3E2419, 0xAF9663, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> GAR_SPAWN_EGG = REGISTER.register("gar_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.GAR, 0x442E1E, 0x947442, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> MYLEDAPHUS_SPAWN_EGG = REGISTER.register("myledaphus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.MYLEDAPHUS, 0x896D48, 0xC4B087, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> THESCELOSAURUS_SPAWN_EGG = REGISTER.register("thescelosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.THESCELOSAURUS_ENTITY, 0x582C20, 0x496659, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> TRICERATOPS_SPAWN_EGG = REGISTER.register("triceratops_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.TRICERATOPS_ENTITY, 0x494427, 0xABA37B, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> TYRANNOSAURUS_SPAWN_EGG = REGISTER.register("tyrannosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.TYRANNOSAURUS_ENTITY, 0x56483E, 0x614C38, new Item.Properties().group(PFEggs.instance)));

	//Kayenta
	public static final RegistryObject<PrehistoricSpawnEggItem> CALSOYASUCHUS_SPAWN_EGG = REGISTER.register("calsoyasuchus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.CALSOYASUCHUS_ENTITY, 0xCBC1AB, 0x573E2E, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> DILOPHOSAURUS_SPAWN_EGG = REGISTER.register("dilophosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.DILOPHOSAURUS_ENTITY, 0x603524, 0x06112D, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> KAYENTATHERIUM_SPAWN_EGG = REGISTER.register("kayentatherium_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.KAYENTATHERIUM_ENTITY, 0x513D34, 0xA59E8B, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> MEGAPNOSAURUS_SPAWN_EGG = REGISTER.register("megapnosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.MEGAPNOSAURUS_ENTITY, 0x4C3028, 0x22242D, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> SARAHSAURUS_SPAWN_EGG = REGISTER.register("sarahsaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.SARAHSAURUS_ENTITY, 0x8C6547, 0x512123, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> SCELIDOSAURUS_SPAWN_EGG = REGISTER.register("scelidosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.SCELIDOSAURUS_ENTITY, 0x4C190E, 0x221713, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> SCUTELLOSAURUS_SPAWN_EGG = REGISTER.register("scutellosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.SCUTELLOSAURUS_ENTITY, 0xCAD51C, 0x6A5942, new Item.Properties().group(PFEggs.instance)));

	//Morrison
	public static final RegistryObject<PrehistoricSpawnEggItem> ALLOSAURUS_SPAWN_EGG = REGISTER.register("allosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.ALLOSAURUS_ENTITY, 0x5E5D2D, 0x643F23, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> CAMARASAURUS_SPAWN_EGG = REGISTER.register("camarasaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.CAMARASAURUS_ENTITY, 0x7E5E2D, 0x7E311C, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> CERATODUS_SPAWN_EGG = REGISTER.register("ceratodus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.CERATODUS, 0x3A3822, 0x969373, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> CERATOSAURUS_SPAWN_EGG = REGISTER.register("ceratosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.CERATOSAURUS_ENTITY, 0x352217, 0x4056A0, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> DRYOSAURUS_SPAWN_EGG = REGISTER.register("dryosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.DRYOSAURUS_ENTITY, 0x8E6746, 0x629698, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> EILENODON_SPAWN_EGG = REGISTER.register("eilenodon_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.EILENODON_ENTITY, 0xA57B48, 0x84A36A, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> HESPERORNITHOIDES_SPAWN_EGG = REGISTER.register("hesperornithoides_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.HESPERORNITHOIDES_ENTITY, 0x1F667D, 0x6F97A5, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> POTAMOCERATODUS_SPAWN_EGG = REGISTER.register("potamoceratodus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.POTAMOCERATODUS, 0x302418, 0xAF621A, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> STEGOSAURUS_SPAWN_EGG = REGISTER.register("stegosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.STEGOSAURUS_ENTITY, 0xB0A047, 0x875D2A, new Item.Properties().group(PFEggs.instance)));

	//Chinle
	public static final RegistryObject<PrehistoricSpawnEggItem> ARGANODUS_SPAWN_EGG = REGISTER.register("arganodus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.ARGANODUS_ENTITY, 0x212638, 0x936B63, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> CHINLEA_SPAWN_EGG = REGISTER.register("chinlea_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.CHINLEA_ENTITY, 0x657A4B, 0x965951, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> COELOPHYSIS_SPAWN_EGG = REGISTER.register("coelophysis_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.COELOPHYSIS_ENTITY, 0xB17114, 0x432018, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> DESMATOSUCHUS_SPAWN_EGG = REGISTER.register("desmatosuchus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.DESMATOSUCHUS_ENTITY, 0xA78973, 0x321F1C, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> MOOREODONTUS_SPAWN_EGG = REGISTER.register("mooreodontus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.MOOREODONTUS_ENTITY, 0xAD4137, 0x381A16, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> PLACERIAS_SPAWN_EGG = REGISTER.register("placerias_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.PLACERIAS_ENTITY, 0x8D573F, 0x24B775, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> POPOSAURUS_SPAWN_EGG = REGISTER.register("poposaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.POPOSAURUS_ENTITY, 0x57654A, 0xBAA582, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> POSTOSUCHUS_SPAWN_EGG = REGISTER.register("postosuchus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.POSTOSUCHUS_ENTITY, 0x746A56, 0x392621, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> SAURICHTHYS_SPAWN_EGG = REGISTER.register("saurichthys_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.SAURICHTHYS_ENTITY, 0x556D3F, 0x776933, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> TRILOPHOSAURUS_SPAWN_EGG = REGISTER.register("trilophosaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.TRILOPHOSAURUS_ENTITY, 0x8D9652, 0xB5713F, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> TYPOTHORAX_SPAWN_EGG = REGISTER.register("typothorax_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.TYPOTHORAX_ENTITY, 0xE0C174, 0x7A9157, new Item.Properties().group(PFEggs.instance)));
	
	//Ischigualasto
	public static final RegistryObject<PrehistoricSpawnEggItem> CHROMOGISAURUS_SPAWN_EGG = REGISTER.register("chromogisaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.CHROMOGISAURUS_ENTITY, 0x513935, 0x4E594B, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> EXAERETODON_SPAWN_EGG = REGISTER.register("exaeretodon_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.EXAERETODON_ENTITY, 0x473023, 0xDBC7BA, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> HERRERASAURUS_SPAWN_EGG = REGISTER.register("herrerasaurus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.HERRERASAURUS_ENTITY, 0x372721, 0xE7E0C9, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> HYPERODAPEDON_SPAWN_EGG = REGISTER.register("hyperodapedon_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.HYPERODAPEDON_ENTITY, 0x3A1F18, 0xAF9586, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> ISCHIGUALASTIA_SPAWN_EGG = REGISTER.register("ischigualastia_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.ISCHIGUALASTIA_ENTITY, 0x242820, 0x808776, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> SAUROSUCHUS_SPAWN_EGG = REGISTER.register("saurosuchus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.SAUROSUCHUS_ENTITY, 0x4F2622, 0x8E4F34, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<PrehistoricSpawnEggItem> SILLOSUCHUS_SPAWN_EGG = REGISTER.register("sillosuchus_spawn_egg", () -> new PrehistoricSpawnEggItem(PFEntities.SILLOSUCHUS_ENTITY, 0x2F2E27, 0x58301B, new Item.Properties().group(PFEggs.instance)));

	//Misc
	public static final RegistryObject<SpawnEggItem> TIME_GUARDIAN_SPAWN_EGG = REGISTER.register("time_guardian_spawn_egg", () -> new SpawnEggItem(PFEntities.TIME_GUARDIAN_ENTITY, 0x55735F, 0x3B4B45, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> TRILOBITE_SENTINEL_SPAWN_EGG = REGISTER.register("trilobite_sentinel_spawn_egg", () -> new SpawnEggItem(PFEntities.TRILOBITE_SENTINEL_ENTITY, 0x4C785D, 0x4AEE7D, new Item.Properties().group(PFEggs.instance)));
	public static final RegistryObject<SpawnEggItem> LAND_SENTINEL_SPAWN_EGG = REGISTER.register("land_sentinel_spawn_egg", () -> new SpawnEggItem(PFEntities.LAND_SENTINEL_ENTITY, 0x638B6D, 0x31413B, new Item.Properties().group(PFEggs.instance)));
	//Skulls
	public static final RegistryObject<SpawnSkeletonItem> PLESIOHADROS_SKULL = REGISTER.register("plesiohadros_skull", () -> new SpawnSkeletonItem(PFEntities.PLESIOHADROS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> PROTOCERATOPS_SKULL = REGISTER.register("protoceratops_skull", () -> new SpawnSkeletonItem(PFEntities.PROTOCERATOPS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> VELOCIRAPTOR_SKULL = REGISTER.register("velociraptor_skull", () -> new SpawnSkeletonItem(PFEntities.VELOCIRAPTOR_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> ANKYLOSAURUS_SKULL = REGISTER.register("ankylosaurus_skull", () -> new SpawnSkeletonItem(PFEntities.ANKYLOSAURUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> TRICERATOPS_SKULL = REGISTER.register("triceratops_skull", () -> new SpawnSkeletonItem(PFEntities.TRICERATOPS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> TYRANNOSAURUS_SKULL = REGISTER.register("tyrannosaurus_skull", () -> new SpawnSkeletonItem(PFEntities.TYRANNOSAURUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> DILOPHOSAURUS_SKULL = REGISTER.register("dilophosaurus_skull", () -> new SpawnSkeletonItem(PFEntities.DILOPHOSAURUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> SARAHSAURUS_SKULL = REGISTER.register("sarahsaurus_skull", () -> new SpawnSkeletonItem(PFEntities.SARAHSAURUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> SCELIDOSAURUS_SKULL = REGISTER.register("scelidosaurus_skull", () -> new SpawnSkeletonItem(PFEntities.SCELIDOSAURUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> ALLOSAURUS_SKULL = REGISTER.register("allosaurus_skull", () -> new SpawnSkeletonItem(PFEntities.ALLOSAURUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> CERATOSAURUS_SKULL = REGISTER.register("ceratosaurus_skull", () -> new SpawnSkeletonItem(PFEntities.CERATOSAURUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> STEGOSAURUS_SKULL = REGISTER.register("stegosaurus_skull", () -> new SpawnSkeletonItem(PFEntities.STEGOSAURUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> COELOPHYSIS_SKULL = REGISTER.register("coelophysis_skull", () -> new SpawnSkeletonItem(PFEntities.COELOPHYSIS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> DESMATOSUCHUS_SKULL = REGISTER.register("desmatosuchus_skull", () -> new SpawnSkeletonItem(PFEntities.DESMATOSUCHUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> POSTOSUCHUS_SKULL = REGISTER.register("postosuchus_skull", () -> new SpawnSkeletonItem(PFEntities.POSTOSUCHUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> HERRERASAURUS_SKULL = REGISTER.register("herrerasaurus_skull", () -> new SpawnSkeletonItem(PFEntities.HERRERASAURUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> ISCHIGUALASTIA_SKULL = REGISTER.register("ischigualastia_skull", () -> new SpawnSkeletonItem(PFEntities.ISCHIGUALASTIA_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> SAUROSUCHUS_SKULL = REGISTER.register("saurosuchus_skull", () -> new SpawnSkeletonItem(PFEntities.SAUROSUCHUS_SKULL, new Item.Properties().group(PFSkeleton.instance)));
	//Skeletons
	public static final RegistryObject<SpawnSkeletonItem> PLESIOHADROS_SKELETON = REGISTER.register("plesiohadros_skeleton", () -> new SpawnSkeletonItem(PFEntities.PLESIOHADROS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> PROTOCERATOPS_SKELETON = REGISTER.register("protoceratops_skeleton", () -> new SpawnSkeletonItem(PFEntities.PROTOCERATOPS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> VELOCIRAPTOR_SKELETON = REGISTER.register("velociraptor_skeleton", () -> new SpawnSkeletonItem(PFEntities.VELOCIRAPTOR_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> ANKYLOSAURUS_SKELETON = REGISTER.register("ankylosaurus_skeleton", () -> new SpawnSkeletonItem(PFEntities.ANKYLOSAURUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> TRICERATOPS_SKELETON = REGISTER.register("triceratops_skeleton", () -> new SpawnSkeletonItem(PFEntities.TRICERATOPS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> TYRANNOSAURUS_SKELETON = REGISTER.register("tyrannosaurus_skeleton", () -> new SpawnSkeletonItem(PFEntities.TYRANNOSAURUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> DILOPHOSAURUS_SKELETON = REGISTER.register("dilophosaurus_skeleton", () -> new SpawnSkeletonItem(PFEntities.DILOPHOSAURUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> SARAHSAURUS_SKELETON = REGISTER.register("sarahsaurus_skeleton", () -> new SpawnSkeletonItem(PFEntities.SARAHSAURUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> ALLOSAURUS_SKELETON = REGISTER.register("allosaurus_skeleton", () -> new SpawnSkeletonItem(PFEntities.ALLOSAURUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> CERATOSAURUS_SKELETON = REGISTER.register("ceratosaurus_skeleton", () -> new SpawnSkeletonItem(PFEntities.CERATOSAURUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> STEGOSAURUS_SKELETON = REGISTER.register("stegosaurus_skeleton", () -> new SpawnSkeletonItem(PFEntities.STEGOSAURUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> COELOPHYSIS_SKELETON = REGISTER.register("coelophysis_skeleton", () -> new SpawnSkeletonItem(PFEntities.COELOPHYSIS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> DESMATOSUCHUS_SKELETON = REGISTER.register("desmatosuchus_skeleton", () -> new SpawnSkeletonItem(PFEntities.DESMATOSUCHUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> POSTOSUCHUS_SKELETON = REGISTER.register("postosuchus_skeleton", () -> new SpawnSkeletonItem(PFEntities.POSTOSUCHUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> HERRERASAURUS_SKELETON = REGISTER.register("herrerasaurus_skeleton", () -> new SpawnSkeletonItem(PFEntities.HERRERASAURUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> ISCHIGUALASTIA_SKELETON = REGISTER.register("ischigualastia_skeleton", () -> new SpawnSkeletonItem(PFEntities.ISCHIGUALASTIA_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	public static final RegistryObject<SpawnSkeletonItem> SAUROSUCHUS_SKELETON = REGISTER.register("saurosuchus_skeleton", () -> new SpawnSkeletonItem(PFEntities.SAUROSUCHUS_SKELETON, new Item.Properties().group(PFSkeleton.instance)));
	
	//Misc Tab
	public static final RegistryObject<Item> TIME_TOTEM = REGISTER.register("time_totem", () -> new Item(new Item.Properties().group(PFMisc.instance).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<CretaceousTimeTotemItem> CRETACEOUS_TIME_TOTEM = REGISTER.register("cretaceous_time_totem", () -> new CretaceousTimeTotemItem(new Item.Properties().group(PFMisc.instance).maxDamage(8).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<JurassicTimeTotemItem> JURASIC_TIME_TOTEM = REGISTER.register("jurassic_time_totem", () -> new JurassicTimeTotemItem(new Item.Properties().group(PFMisc.instance).maxDamage(8).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<TriassicTimeTotemItem> TRIASSIC_TIME_TOTEM = REGISTER.register("triassic_time_totem", () -> new TriassicTimeTotemItem(new Item.Properties().group(PFMisc.instance).maxDamage(8).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> TIME_GEM_SHARD = REGISTER.register("time_gem_shard", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> TRIASSIC_FOSSIL = REGISTER.register("triassic_fossil", () -> new FossilItem(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> JURASSIC_FOSSIL = REGISTER.register("jurassic_fossil", () -> new FossilItem(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> CRETACEOUS_FOSSIL = REGISTER.register("cretaceous_fossil", () -> new FossilItem(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> FOSSILIZED_BONES = REGISTER.register("fossilized_bones", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<PaleopediaItem> PALEOPEDIA = REGISTER.register("ancient_journal", () -> new PaleopediaItem());
	public static final RegistryObject<Item> PALEOPAGE = REGISTER.register("ancient_journal_page", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> BANNER_PATTERN_CLAW = REGISTER.register("banner_pattern_claw", () -> new BannerPatternItem(registerPattern("claw"), new Item.Properties().maxStackSize(1).group(PFMisc.instance)));
	public static final RegistryObject<Item> BANNER_PATTERN_OYSTER = REGISTER.register("banner_pattern_oyster", () -> new BannerPatternItem(registerPattern("oyster"), new Item.Properties().maxStackSize(1).group(PFMisc.instance)));
	public static final RegistryObject<Item> BANNER_PATTERN_SPIRAL = REGISTER.register("banner_pattern_spiral", () -> new BannerPatternItem(registerPattern("spiral"), new Item.Properties().maxStackSize(1).group(PFMisc.instance)));
	public static final RegistryObject<Item> BANNER_PATTERN_THAGOMIZER = REGISTER.register("banner_pattern_thagomizer", () -> new BannerPatternItem(registerPattern("thagomizer"), new Item.Properties().maxStackSize(1).group(PFMisc.instance)));
	public static final RegistryObject<Item> BANNER_PATTERN_TRICERATOPS = REGISTER.register("banner_pattern_triceratops", () -> new BannerPatternItem(registerPattern("triceratops"), new Item.Properties().maxStackSize(1).group(PFMisc.instance)));
	public static final RegistryObject<Item> BANNER_PATTERN_HENOS = REGISTER.register("banner_pattern_henos", () -> new BannerPatternItem(registerPattern("henos"), new Item.Properties().maxStackSize(1).group(PFMisc.instance)));
	public static final RegistryObject<Item> BANNER_PATTERN_AETOSAUR = REGISTER.register("banner_pattern_aetosaur", () -> new BannerPatternItem(registerPattern("aetosaur"), new Item.Properties().maxStackSize(1).group(PFMisc.instance)));
	public static final RegistryObject<Item> TYRANNOSAUR_TOOTH = REGISTER.register("tyrannosaur_tooth", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> TAIL_CLUB = REGISTER.register("tail_club", () -> new SwordItem(PFItemTiers.ANKYLOSAURUS, 4, -3.5F, new Item.Properties().group(PFMisc.instance).maxDamage(6)));
	public static final RegistryObject<Item> ANKYLOSAURUS_SCUTE = REGISTER.register("ankylosaurus_scute", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> THYREOPHORAN_SCUTE = REGISTER.register("thyreophoran_scute", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> CERATOPSIAN_HORN = REGISTER.register("ceratopsian_horn", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> THAGOMIZERS = REGISTER.register("thagomizer", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> DESMATOSUCHUS_SPIKE = REGISTER.register("desmatosuchus_spike", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> DROMAEOSAUR_CLAW = REGISTER.register("dromaeosaur_claw", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> DIDELPHODON_HIDE = REGISTER.register("didelphodon_hide", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> EXAERETODON_HIDE = REGISTER.register("exaeretodon_hide", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> KAYENTATHERIUM_HIDE = REGISTER.register("kayentatherium_hide", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<CustomArmorItem> ANKYLOSAURUS_HELMET = REGISTER.register("ankylosaurus_helmet", () -> new CustomArmorItem(ArmorMaterialInit.ANKYLOSAURUS, EquipmentSlotType.HEAD, new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<CustomChestplateItem> DESMATOSUCHUS_CHESTPLATE = REGISTER.register("desmatosuchus_chestplate", () -> new CustomChestplateItem(ArmorMaterialInit.DESMATOSUCHUS, EquipmentSlotType.CHEST, new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> THAGOMIZER_PICKAXE = REGISTER.register("thagomizer_pickaxe", () -> new PickaxeItem(PFItemTiers.THAGOMIZER, 2, -2.8F, new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> DAKOTARAPTOR_CLAW_SCYTHE = REGISTER.register("dromaeosaur_claw_scythe", () -> new PFHoeItem(PFItemTiers.DAKOTARAPTOR, -1.0F, new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> TYRANNOSAUR_TOOTH_SWORD = REGISTER.register("tyrannosaur_tooth_sword", () -> new SwordItem(PFItemTiers.TYRANNOSAURUS, 3, -2.4F, new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> GEOLOGY_HAMMER = REGISTER.register("geological_hammer", () -> new Item(new Item.Properties().group(PFMisc.instance).maxStackSize(1).maxDamage(250)));
	public static final RegistryObject<Item> CLADOPHEBLIS_STICK = REGISTER.register("cladophlebis_stick", () -> new Item(new Item.Properties().group(PFMisc.instance).maxStackSize(1)));
	public static final RegistryObject<Item> MOSS_BALL = REGISTER.register("moss_ball", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> PTILOPHYLLUM_FRONDS = REGISTER.register("ptilophyllum_fronds", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> PLANT_FIBER = REGISTER.register("plant_fiber", () -> new Item(new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<Item> CRASSOSTREA_OYSTER = REGISTER.register("crassostrea_oyster", () -> new BlockItem(PFBlocks.CRASSOSTREA_OYSTER, new Item.Properties().group(PFMisc.instance)));
	public static final RegistryObject<PrehistoricBoatItem> ARAUCARIA_BOAT = REGISTER.register("araucaria_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.ARAUCARIA, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> METASEQUOIA_BOAT = REGISTER.register("metasequoia_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.METASEQUOIA, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> PROTOPICEOXYLON_BOAT = REGISTER.register("protopiceoxylon_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.PROTOPICEOXYLON, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> ZAMITES_BOAT = REGISTER.register("zamites_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.ZAMITES, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> PROTOJUNIPER_BOAT = REGISTER.register("protojuniperoxylon_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.PROTOJUNIPER, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> HEIDIPHYLLUM_BOAT = REGISTER.register("heidiphyllum_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.HEIDIPHYLLUM, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> LIRIODENDRITES_BOAT = REGISTER.register("liriodendrites_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.LIRIODENDRITES, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> GINKGO_BOAT = REGISTER.register("ginkgo_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.GINKGO, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> TROCHODENDROIDES_BOAT = REGISTER.register("trochodendroides_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.TROCHODENDROIDES, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> BRACHYPHYLLUM_BOAT = REGISTER.register("brachyphyllum_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.BRACHYPHYLLUM, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> AGATHOXYLON_BOAT = REGISTER.register("agathoxylon_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.AGATHOXYLON, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> WOODWORTHIA_BOAT = REGISTER.register("woodworthia_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.WOODWORTHIA, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	public static final RegistryObject<PrehistoricBoatItem> SCHILDERIA_BOAT = REGISTER.register("schilderia_boat", () -> new PrehistoricBoatItem(PrehistoricBoatEntity.PFType.SCHILDERIA, (new Item.Properties().maxStackSize(1).group(PFMisc.instance))));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> MYLEDAPHUS_BUCKET = REGISTER.register("myledaphus_bucket", () -> new FishBucketItem(PFEntities.MYLEDAPHUS, Fluids.WATER, new Item.Properties().group(PFMisc.instance).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> GAR_BUCKET = REGISTER.register("gar_bucket", () -> new FishBucketItem(PFEntities.GAR, Fluids.WATER, new Item.Properties().group(PFMisc.instance).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> CYCLURUS_BUCKET = REGISTER.register("cyclurus_bucket", () -> new FishBucketItem(PFEntities.CYCLURUS, Fluids.WATER, new Item.Properties().group(PFMisc.instance).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> CERATODUS_BUCKET = REGISTER.register("ceratodus_bucket", () -> new FishBucketItem(PFEntities.CERATODUS, Fluids.WATER, new Item.Properties().group(PFMisc.instance).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> POTAMOCERATODUS_BUCKET = REGISTER.register("potamoceratodus_bucket", () -> new FishBucketItem(PFEntities.POTAMOCERATODUS, Fluids.WATER, new Item.Properties().group(PFMisc.instance).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> SAURICHTHYS_BUCKET = REGISTER.register("saurichthys_bucket", () -> new FishBucketItem(PFEntities.SAURICHTHYS_ENTITY, Fluids.WATER, new Item.Properties().group(PFMisc.instance).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> ARGANODUS_BUCKET = REGISTER.register("arganodus_bucket", () -> new FishBucketItem(PFEntities.ARGANODUS_ENTITY, Fluids.WATER, new Item.Properties().group(PFMisc.instance).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> CHINLEA_BUCKET = REGISTER.register("chinlea_bucket", () -> new FishBucketItem(PFEntities.CHINLEA_ENTITY, Fluids.WATER, new Item.Properties().group(PFMisc.instance).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> MOOREODONTUS_BUCKET = REGISTER.register("mooreodontus_bucket", () -> new FishBucketItem(PFEntities.MOOREODONTUS_ENTITY, Fluids.WATER, new Item.Properties().group(PFMisc.instance).maxStackSize(1)));

	//Meat
	public static final RegistryObject<Item> RAW_SMALL_THYREOPHORAN_MEAT = REGISTER.register("raw_small_thyreophoran_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(2).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_SMALL_THYREOPHORAN_MEAT = REGISTER.register("cooked_small_thyreophoran_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(5).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_LARGE_THYREOPHORAN_MEAT = REGISTER.register("raw_large_thyreophoran_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(4).saturation(0.3F).meat().build()))); //Ankylosaurus, Stegosaurus
	public static final RegistryObject<Item> COOKED_LARGE_THYREOPHORAN_MEAT = REGISTER.register("cooked_large_thyreophoran_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(8).saturation(0.8F).meat().build()))); 
	public static final RegistryObject<Item> RAW_SMALL_MARGINOCEPHALIAN_MEAT = REGISTER.register("raw_small_marginocephalian_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(2).saturation(0.3F).meat().build())));
	public static final RegistryObject<Item> COOKED_SMALL_MARGINOCEPHALIAN_MEAT = REGISTER.register("cooked_small_marginocephalian_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(5).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_LARGE_MARGINOCEPHALIAN_MEAT = REGISTER.register("raw_large_marginocephalian_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(5).saturation(0.3F).meat().build()))); //Triceratops
	public static final RegistryObject<Item> COOKED_LARGE_MARGINOCEPHALIAN_MEAT = REGISTER.register("cooked_large_marginocephalian_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(10).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_SMALL_ORNITHISCHIAN_MEAT = REGISTER.register("raw_small_ornithischian_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(2).saturation(0.3F).meat().build()))); //Dryosaurus, Thescelosaurus
	public static final RegistryObject<Item> COOKED_SMALL_ORNITHISCHIAN_MEAT = REGISTER.register("cooked_small_ornithischian_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(6).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_LARGE_ORNITHISCHIAN_MEAT = REGISTER.register("raw_large_ornithischian_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(4).saturation(0.3F).meat().build())));//Plesiohadros
	public static final RegistryObject<Item> COOKED_LARGE_ORNITHISCHIAN_MEAT = REGISTER.register("cooked_large_ornithischian_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(8).saturation(0.8F).meat().build())));//Plesiohadros
	public static final RegistryObject<Item> RAW_LARGE_SAUROPOD_MEAT = REGISTER.register("raw_large_sauropod_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(6).saturation(0.3F).meat().build()))); //Camarasaurus
	public static final RegistryObject<Item> COOKED_LARGE_SAUROPOD_MEAT = REGISTER.register("cooked_large_sauropod_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(12).saturation(0.8F).meat().build())));
	public static final RegistryObject<Item> RAW_SMALL_SAUROPOD_MEAT = REGISTER.register("raw_small_sauropod_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(2).saturation(0.3F).meat().build()))); //Chromogisaurus
	public static final RegistryObject<Item> COOKED_SMALL_SAUROPOD_MEAT = REGISTER.register("cooked_small_sauropod_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(4).saturation(0.6F).meat().build())));
	public static final RegistryObject<Item> RAW_LARGE_THEROPOD_MEAT = REGISTER.register("raw_large_theropod_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(4).saturation(0.3F).meat().build()))); //Dakotaraptor, Ceratosaurus, Allosaurus, Tyrannosaurus
	public static final RegistryObject<Item> COOKED_LARGE_THEROPOD_MEAT = REGISTER.register("cooked_large_theropod_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(8).saturation(0.8F).meat().build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> RAW_SMALL_THEROPOD_MEAT = REGISTER.register("raw_small_theropod_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(2).saturation(0.3F).effect(new EffectInstance(Effects.HUNGER, 600, 0), 0.3F).meat().build()))); //Hesperornithoides, Herrerasaurus
	public static final RegistryObject<Item> COOKED_SMALL_THEROPOD_MEAT = REGISTER.register("cooked_small_theropod_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(6).saturation(0.6F).meat().build())));
	public static final RegistryObject<Item> RAW_SMALL_ARCHOSAUROMORPH_MEAT = REGISTER.register("raw_small_archosauromorph_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(1).saturation(0.3F).meat().build()))); //Hyperodapedon
	public static final RegistryObject<Item> COOKED_SMALL_ARCHOSAUROMORPH_MEAT = REGISTER.register("cooked_small_archosauromorph_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(4).saturation(0.6F).meat().build())));
	public static final RegistryObject<Item> RAW_LARGE_ARCHOSAUROMORPH_MEAT = REGISTER.register("raw_large_archosauromorph_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(4).saturation(0.3F).meat().build())));//Saurosuchus, Sillosuchus
	public static final RegistryObject<Item> COOKED_LARGE_ARCHOSAUROMORPH_MEAT = REGISTER.register("cooked_large_archosauromorph_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(8).saturation(0.8F).meat().build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> RAW_SMALL_REPTILE_MEAT = REGISTER.register("raw_small_reptile_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(2).saturation(0.3F).effect(new EffectInstance(Effects.HUNGER, 600, 0), 0.3F).meat().build()))); //Eilenodon
	public static final RegistryObject<Item> COOKED_SMALL_REPTILE_MEAT = REGISTER.register("cooked_small_reptile_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(4).saturation(0.6F).meat().build())));
	public static final RegistryObject<Item> RAW_LARGE_SYNAPSID_MEAT = REGISTER.register("raw_large_synapsid_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(3).saturation(0.4F).meat().build()))); //Ischigualastia
	public static final RegistryObject<Item> COOKED_LARGE_SYNAPSID_MEAT = REGISTER.register("cooked_large_synapsid_meat", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(8).saturation(0.8F).meat().build())));
	public static final RegistryObject<SoupItem> CRASSOSTREA_OYSTER_SOUP = REGISTER.register("crassostrea_oyster_soup", () -> new SoupItem(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(8).saturation(0.6F).build())));
	public static final RegistryObject<Item> TUBER = REGISTER.register("tuber", () -> new BlockNamedItem(PFBlocks.TUBER_CROP, new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(3).saturation(0.6F).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> RAW_OYSTER = REGISTER.register("raw_oyster", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().hunger(2).saturation(0.3F).effect(new EffectInstance(Effects.HUNGER, 600, 0), 0.01F).build())));

	public static final RegistryObject<PaleopaintingItem> PALEOPAINTING = REGISTER.register("paleopainting", () -> new PaleopaintingItem(new Item.Properties().group(PFDecoration.instance)));
	public static final RegistryObject<WallFossilItem> WALL_FOSSIL = REGISTER.register("wall_fossil", () -> new WallFossilItem(new Item.Properties().group(PFDecoration.instance)));
	//	@SuppressWarnings("deprecation")
//	public static final RegistryObject<Item> MARMARTHIA_BERRIES = REGISTER.register("marmarthia_berries", () -> new BlockNamedItem(PFBlocks.MARMARTHIA, (new Item.Properties()).group(PFFood.instance).food(new Food.Builder().hunger(2).saturation(0.1F).effect(new EffectInstance(Effects.POISON, 300), 1.0F).build())));

	public static final RegistryObject<Item> HENOSTONE = REGISTER.register("henostone", () -> new BlockItem(PFBlocks.HENOSTONE, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> CARVED_HENOSTONE = REGISTER.register("carved_henostone", () -> new BlockItem(PFBlocks.CARVED_HENOSTONE, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> HENOSTONE_BRICKS = REGISTER.register("henostone_bricks", () -> new BlockItem(PFBlocks.HENOSTONE_BRICKS, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> DARK_HENOSTONE_BRICKS = REGISTER.register("dark_henostone_bricks", () -> new BlockItem(PFBlocks.DARK_HENOSTONE_BRICKS, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> HENOSTONE_PILLAR = REGISTER.register("henostone_pillar", () -> new BlockItem(PFBlocks.HENOSTONE_PILLAR, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> CHISELED_HENOSTONE_PILLAR = REGISTER.register("chiseled_henostone_pillar", () -> new BlockItem(PFBlocks.CHISELED_HENOSTONE_PILLAR, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> HENOSTONE_STAIRS = REGISTER.register("henostone_stairs", () -> new BlockItem(PFBlocks.HENOSTONE_STAIRS, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> HENOSTONE_SLAB = REGISTER.register("henostone_slab", () -> new BlockItem(PFBlocks.HENOSTONE_SLAB, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> HENOSTONE_BRICK_STAIRS = REGISTER.register("henostone_brick_stairs", () -> new BlockItem(PFBlocks.HENOSTONE_BRICK_STAIRS, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> HENOSTONE_BRICK_SLAB = REGISTER.register("henostone_brick_slab", () -> new BlockItem(PFBlocks.HENOSTONE_BRICK_SLAB, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> DARK_HENOSTONE_BRICK_STAIRS = REGISTER.register("dark_henostone_brick_stairs", () -> new BlockItem(PFBlocks.DARK_HENOSTONE_BRICK_STAIRS, new Item.Properties().group(PFBuilding.instance)));
	public static final RegistryObject<Item> DARK_HENOSTONE_BRICK_SLAB = REGISTER.register("dark_henostone_brick_slab", () -> new BlockItem(PFBlocks.DARK_HENOSTONE_BRICK_SLAB, new Item.Properties().group(PFBuilding.instance)));

	public static final RegistryObject<Item> SMALL_AMMONITE_FOSSIL = REGISTER.register("small_ammonite_fossil", () -> new BlockItem(PFBlocks.SMALL_AMMONITE_FOSSIL, new Item.Properties().group(PFDecoration.instance)));
	public static final RegistryObject<Item> MEDIUM_AMMONITE_FOSSIL = REGISTER.register("medium_ammonite_fossil", () -> new BlockItem(PFBlocks.MEDIUM_AMMONITE_FOSSIL, new Item.Properties().group(PFDecoration.instance)));
	public static final RegistryObject<Item> LARGE_AMMONITE_FOSSIL = REGISTER.register("large_ammonite_fossil", () -> new BlockItem(PFBlocks.LARGE_AMMONITE_FOSSIL, new Item.Properties().group(PFDecoration.instance)));

	public static final RegistryObject<Item> ARAURCARIA_SIGN = REGISTER.register("araucaria_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.ARAUCARIA_SIGN, PFBlocks.ARAUCARIA_WALL_SIGN));
	public static final RegistryObject<Item> METASEQUOIA_SIGN = REGISTER.register("metasequoia_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.METASEQUOIA_SIGN, PFBlocks.METASEQUOIA_WALL_SIGN));
	public static final RegistryObject<Item> HEIDIPHYLLUM_SIGN = REGISTER.register("heidiphyllum_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.HEIDIPHYLLUM_SIGN, PFBlocks.HEIDIPHYLLUM_WALL_SIGN));
	public static final RegistryObject<Item> LIRIODENDRITES_SIGN = REGISTER.register("liriodendrites_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.LIRIODENDRITES_SIGN, PFBlocks.LIRIODENDRITES_WALL_SIGN));;
	public static final RegistryObject<Item> PROTOJUNIPEROXYLON_SIGN = REGISTER.register("protojuniperoxylon_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.PROTOJUNIPEROXYLON_SIGN, PFBlocks.PROTOJUNIPEROXYLON_WALL_SIGN));;
	public static final RegistryObject<Item> PROTOPICEOXYLON_SIGN = REGISTER.register("protopiceoxylon_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.PROTOPICEOXYLON_SIGN, PFBlocks.PROTOPICEOXYLON_WALL_SIGN));;
	public static final RegistryObject<Item> ZAMITES_SIGN = REGISTER.register("zamites_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.ZAMITES_SIGN, PFBlocks.ZAMITES_WALL_SIGN));
	public static final RegistryObject<Item> GINKGO_SIGN = REGISTER.register("ginkgo_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.GINKGO_SIGN, PFBlocks.GINKGO_WALL_SIGN));
	public static final RegistryObject<Item> TROCHODENDROIDES_SIGN = REGISTER.register("trochodendroides_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.TROCHODENDROIDES_SIGN, PFBlocks.TROCHODENDROIDES_WALL_SIGN));
	public static final RegistryObject<Item> BRACHYPHYLLUM_SIGN = REGISTER.register("brachyphyllum_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.BRACHYPHYLLUM_SIGN, PFBlocks.BRACHYPHYLLUM_WALL_SIGN));
	public static final RegistryObject<Item> AGATHOXYLON_SIGN = REGISTER.register("agathoxylon_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.AGATHOXYLON_SIGN, PFBlocks.AGATHOXYLON_WALL_SIGN));
	public static final RegistryObject<Item> WOODWORTHIA_SIGN = REGISTER.register("woodworthia_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.WOODWORTHIA_SIGN, PFBlocks.WOODWORTHIA_WALL_SIGN));
	public static final RegistryObject<Item> SCHILDERIA_SIGN = REGISTER.register("schilderia_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.SCHILDERIA_SIGN, PFBlocks.SCHILDERIA_WALL_SIGN));
	public static final RegistryObject<Item> NEOCALAMITES_SIGN = REGISTER.register("neocalamites_sign", () -> new PFSignItem(new Item.Properties().maxStackSize(16).group(PFDecoration.instance), PFBlocks.NEOCALAMITES_SIGN, PFBlocks.NEOCALAMITES_WALL_SIGN));

	public static final RegistryObject<Item> CERATODUS = REGISTER.register("raw_ceratodus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.1F).hunger(2).build())));
	public static final RegistryObject<Item> COOKED_CERATODUS = REGISTER.register("cooked_ceratodus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.8F).hunger(6).build())));
	public static final RegistryObject<Item> CYCLURUS = REGISTER.register("raw_cyclurus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.1F).hunger(2).build())));
	public static final RegistryObject<Item> COOKED_CYCLURUS = REGISTER.register("cooked_cyclurus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.8F).hunger(6).build())));
	public static final RegistryObject<Item> LEPISOSTEUS = REGISTER.register("raw_gar", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.1F).hunger(2).build())));
	public static final RegistryObject<Item> COOKED_LEPISOSTEUS = REGISTER.register("cooked_gar", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.8F).hunger(6).build())));
	public static final RegistryObject<Item> MYLEDAPHUS = REGISTER.register("raw_myledaphus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.2F).hunger(2).build())));
	public static final RegistryObject<Item> POTAMOCERATODUS = REGISTER.register("raw_potamoceratodus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.1F).hunger(2).build())));
	public static final RegistryObject<Item> COOKED_POTAMOCERATODUS = REGISTER.register("cooked_potamoceratodus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.8F).hunger(6).build())));
	public static final RegistryObject<Item> SAURICHTHYS = REGISTER.register("raw_saurichthys", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.1F).hunger(2).build())));
	public static final RegistryObject<Item> COOKED_SAURICHTHYS = REGISTER.register("cooked_saurichthys", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.8F).hunger(6).build())));
	public static final RegistryObject<Item> CHINLEA = REGISTER.register("raw_chinlea", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.1F).hunger(2).build())));
	public static final RegistryObject<Item> COOKED_CHINLEA = REGISTER.register("cooked_chinlea", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.8F).hunger(6).build())));
	public static final RegistryObject<Item> MOOREODONTUS = REGISTER.register("raw_mooreodontus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.1F).hunger(2).build())));
	public static final RegistryObject<Item> ARGANODUS = REGISTER.register("raw_arganodus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.1F).hunger(2).build())));
	public static final RegistryObject<Item> COOKED_ARGANODUS = REGISTER.register("cooked_arganodus", () -> new Item(new Item.Properties().group(PFFood.instance).food(new Food.Builder().saturation(0.8F).hunger(6).build())));

	public static final RegistryObject<Item> HORSETAIL_TEA = REGISTER.register("horsetail_tea", () -> new HorsetailTeaItem(new Item.Properties().group(PFFood.instance).maxStackSize(16)));
	
	private static BannerPattern registerPattern(String name) {
		return BannerPattern.create(name.toUpperCase(), name, name, true);
	}
}
