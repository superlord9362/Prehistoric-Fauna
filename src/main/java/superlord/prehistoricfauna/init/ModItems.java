package superlord.prehistoricfauna.init;

import superlord.prehistoricfauna.entity.EntityType;
import superlord.prehistoricfauna.items.ItemAllosaurusEgg;
import superlord.prehistoricfauna.items.ItemAnkylosaurusEgg;
import superlord.prehistoricfauna.items.ItemBaryonyxEgg;
import superlord.prehistoricfauna.items.ItemBase;
import superlord.prehistoricfauna.items.ItemCamarasaurusEgg;
import superlord.prehistoricfauna.items.ItemCladocyclusEgg;
import superlord.prehistoricfauna.items.ItemCobbleBrick;
import superlord.prehistoricfauna.items.ItemDNADisk;
import superlord.prehistoricfauna.items.ItemDinosaurEgg;
import superlord.prehistoricfauna.items.ItemEusthenopteronEgg;
import superlord.prehistoricfauna.items.ItemFossil;
import superlord.prehistoricfauna.items.ItemGallimimusEgg;
import superlord.prehistoricfauna.items.ItemParadoxidesEgg;
import superlord.prehistoricfauna.items.ItemParasaurolophusEgg;
import superlord.prehistoricfauna.items.ItemPrenocephaleEgg;
import superlord.prehistoricfauna.items.ItemStegosaurusEgg;
import superlord.prehistoricfauna.items.ItemTriceratopsEgg;
import superlord.prehistoricfauna.items.ItemTyrannosaurusEgg;
import superlord.prehistoricfauna.items.ItemVelociraptorEgg;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<>();

	/*
	 * Fossils
	 */
	public static final Item TRICERATOPS_HORN = new ItemFossil("triceratops_horn");
	public static final Item GALLIMIMUS_SKULL = new ItemFossil("gallimimus_skull");
	public static final Item TYRANNOSAURUS_TOOTH = new ItemFossil("tyrannosaurus_tooth");
	public static final Item VELOCIRAPTOR_CLAW = new ItemFossil("velociraptor_claw");
	public static final Item CAMARASAURUS_SKULL = new ItemFossil("camarasaurus_skull");
	public static final Item STEGOSAURUS_THAGOMIZER = new ItemFossil("stegosaurus_thagomizer");
	public static final Item DRYOSAURUS_SKULL = new ItemFossil("dryosaurus_skull");
	public static final Item ALLOSAURUS_SKULL = new ItemFossil("allosaurus_skull");
	public static final Item ANKYLOSAURUS_TAIL = new ItemFossil("ankylosaurus_tail");
	public static final Item PRENOCEPHALE_SKULL = new ItemFossil("prenocephale_skull");
	public static final Item PARASAUROLOPHUS_SKULL = new ItemFossil("parasaurolophus_skull");
	public static final Item BARYONYX_CLAW = new ItemFossil("baryonyx_claw");
	public static final Item COOKSONIA_FOSSIL = new ItemFossil("cooksonia_fossil");
	public static final Item ARCHAEAMPHORA_FOSSIL = new ItemFossil("archaeamphora_fossil");
	public static final Item PARADOXIDES_FOSSIL = new ItemFossil("paradoxides_fossil");
	public static final Item CLADOCYCLUS_FOSSIL = new ItemFossil("cladocyclus_fossil");
	public static final Item EUTHENOPTERON_FOSSIL = new ItemFossil("eusthenopteron_fossil");

	/*
	 * DNA Disks
	 */
	public static final Item TRICERATOPS_DNA = new ItemDNADisk("triceratops_dna");
	public static final Item GALLIMIMUS_DNA = new ItemDNADisk("gallimimus_dna");
	public static final Item TYRANNOSAURUS_DNA = new ItemDNADisk("tyrannosaurus_dna");
	public static final Item VELOCIRAPTOR_DNA = new ItemDNADisk("velociraptor_dna");
	public static final Item STEGOSAURUS_DNA = new ItemDNADisk("stegosaurus_dna");
	public static final Item CAMARASAURUS_DNA = new ItemDNADisk("camarasaurus_dna");
	public static final Item DRYOSAURUS_DNA = new ItemDNADisk("dryosaurus_dna");
	public static final Item ALLOSAURUS_DNA = new ItemDNADisk("allosaurus_dna");
	public static final Item ANKYLOSAURUS_DNA = new ItemDNADisk("ankylosaurus_dna");
	public static final Item BARYONYX_DNA = new ItemDNADisk("baryonyx_dna");
	public static final Item PARASAUROLOPHUS_DNA = new ItemDNADisk("parasaurolophus_dna");
	public static final Item PRENOCEPHALE_DNA = new ItemDNADisk("prenocephale_dna");
	public static final Item PARADOXIDES_DNA = new ItemDNADisk("paradoxides_dna");
	public static final Item CLADOCYCLUS_DNA = new ItemDNADisk("cladocyclus_dna");
	public static final Item EUSTHENOPTERON_DNA = new ItemDNADisk("eusthenopteron_dna");
	public static final Item COOKSONIA_DNA = new ItemDNADisk("cooksonia_dna");
	public static final Item ARCHAEAMPHORA_DNA = new ItemDNADisk("archaeamphora_dna");

	/*
	 * Eggs
	 */
	public static final Item DRYOSAURUS_EGG_ENTITY = new ItemDinosaurEgg(EntityType.DRYOSAURUS);
	public static final Item CAMARASAURUS_EGG_ENTITY = new ItemCamarasaurusEgg(EntityType.CAMARASAURUS);
	public static final Item ALLOSAURUS_EGG_ENTITY = new ItemAllosaurusEgg(EntityType.ALLOSAURUS);
	public static final Item STEGOSAURUS_EGG_ENTITY = new ItemStegosaurusEgg(EntityType.STEGOSAURUS);
	public static final Item TYRANNOSAURUS_EGG_ENTITY = new ItemTyrannosaurusEgg(EntityType.TYRANNOSAURUS);
	public static final Item TRICERATOPS_EGG_ENTITY = new ItemTriceratopsEgg(EntityType.TRICERATOPS);
	public static final Item VELOCIRAPTOR_EGG_ENTITY = new ItemVelociraptorEgg(EntityType.VELOCIRAPTOR);
	public static final Item GALLIMIMUS_EGG_ENTITY = new ItemGallimimusEgg(EntityType.GALLIMIMUS);
	public static final Item PARASAUROLOPHUS_EGG_ENTITY = new ItemParasaurolophusEgg(EntityType.PARASAUROLOPHUS);
	public static final Item PRENOCEPHALE_EGG_ENTITY = new ItemPrenocephaleEgg(EntityType.PRENOCEPHALE);
	public static final Item BARYONYX_EGG_ENTITY = new ItemBaryonyxEgg(EntityType.BARYONYX);
	public static final Item ANKYLOSAURUS_EGG = new ItemAnkylosaurusEgg(EntityType.ANKYLOSAURUS);
	public static final Item EUSTHENOPTERON_EGG = new ItemEusthenopteronEgg("eusthenopteron_egg");
	public static final Item PARADOXIDES_EGG = new ItemParadoxidesEgg("paradoxides_egg");
	public static final Item CLADOCYCLUS_EGG = new ItemCladocyclusEgg("cladocyclus_egg");

	/*
	 * Miscellaneous
	 */
	public static final Item COBBLE_BRICK = new ItemCobbleBrick("cobble_brick");

}
