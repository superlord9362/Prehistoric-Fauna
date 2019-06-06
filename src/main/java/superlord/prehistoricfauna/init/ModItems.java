package superlord.prehistoricfauna.init;

import superlord.prehistoricfauna.entity.EntityType;
import superlord.prehistoricfauna.items.ItemAllosaurusEgg;
import superlord.prehistoricfauna.items.ItemAnkylosaurusEgg;
import superlord.prehistoricfauna.items.ItemBaryonyxEgg;
import superlord.prehistoricfauna.items.ItemBase;
import superlord.prehistoricfauna.items.ItemCamarasaurusEgg;
import superlord.prehistoricfauna.items.ItemDinosaurEgg;
import superlord.prehistoricfauna.items.ItemGallimimusEgg;
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

    public static final Item TRICERATOPS_HORN = new ItemBase("triceratops_horn");
    public static final Item GALLIMIMUS_SKULL = new ItemBase("gallimimus_skull");
    public static final Item TYRANNOSAURUS_TOOTH = new ItemBase("tyrannosaurus_tooth");
    public static final Item VELOCIRAPTOR_CLAW = new ItemBase("velociraptor_claw");
    public static final Item TRICERATOPS_DNA = new ItemBase("triceratops_dna");
    public static final Item GALLIMIMUS_DNA = new ItemBase("gallimimus_dna");
    public static final Item TYRANNOSAURUS_DNA = new ItemBase("tyrannosaurus_dna");
    public static final Item VELOCIRAPTOR_DNA = new ItemBase("velociraptor_dna");
    public static final Item CAMARASAURUS_SKULL = new ItemBase("camarasaurus_skull");
    public static final Item STEGOSAURUS_THAGOMIZER = new ItemBase("stegosaurus_thagomizer");
    public static final Item DRYOSAURUS_SKULL = new ItemBase("dryosaurus_skull");
    public static final Item ALLOSAURUS_SKULL = new ItemBase("allosaurus_skull");
    public static final Item STEGOSAURUS_DNA = new ItemBase("stegosaurus_dna");
    public static final Item CAMARASAURUS_DNA = new ItemBase("camarasaurus_dna");
    public static final Item DRYOSAURUS_DNA = new ItemBase("dryosaurus_dna");
    public static final Item COBBLE_BRICK = new ItemBase("cobble_brick");
    public static final Item ALLOSAURUS_DNA = new ItemBase("allosaurus_dna");
    public static final Item ANKYLOSAURUS_TAIL = new ItemBase("ankylosaurus_tail");
    public static final Item PRENOCEPHALE_SKULL = new ItemBase("prenocephale_skull");
    public static final Item PARASAUROLOPHUS_SKULL = new ItemBase("parasaurolophus_skull");
    public static final Item BARYONYX_CLAW = new ItemBase("baryonyx_claw");
    public static final Item ANKYLOSAURUS_DNA = new ItemBase("ankylosaurus_dna");
    public static final Item BARYONYX_DNA = new ItemBase("baryonyx_dna");
    public static final Item PARASAUROLOPHUS_DNA = new ItemBase("parasaurolophus_dna");
    public static final Item PRENOCEPHALE_DNA = new ItemBase("prenocephale_dna");
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
}
