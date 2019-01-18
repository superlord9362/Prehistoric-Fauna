package com.superlord.prehistoricfauna.init;

import com.superlord.prehistoricfauna.items.ItemBase;
import com.superlord.prehistoricfauna.items.ItemCamarasaurusEgg;
import com.superlord.prehistoricfauna.items.ItemDinoEgg;
import com.superlord.prehistoricfauna.items.ItemGallimimusEgg;
import com.superlord.prehistoricfauna.items.ItemIncCamarasaurus;
import com.superlord.prehistoricfauna.items.ItemIncGallimimus;
import com.superlord.prehistoricfauna.items.ItemIncTyrannosaurus;
import com.superlord.prehistoricfauna.items.ItemIncVelociraptor;
import com.superlord.prehistoricfauna.items.ItemIncubatedTriceratopsEgg;
import com.superlord.prehistoricfauna.items.ItemTyrannosaurusEgg;
import com.superlord.prehistoricfauna.items.ItemVelociraptorEgg;
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
    public static final Item TRICERATOPS_EGG = new ItemDinoEgg("triceratops_egg");
    public static final Item INCUBATED_TRICERATOPS = new ItemIncubatedTriceratopsEgg("incubated_triceratops");
    public static final Item GALLIMIMUS_EGG = new ItemGallimimusEgg("gallimimus_egg");
    public static final Item VELOCIRAPTOR_EGG = new ItemVelociraptorEgg("velociraptor_egg");
    public static final Item TYRANNOSAURUS_EGG = new ItemTyrannosaurusEgg("tyrannosaurus_egg");
    public static final Item INCUBATED_GALLIMIMUS = new ItemIncGallimimus("incubated_gallimimus");
    public static final Item INCUBATED_VELOCIRATPOR = new ItemIncVelociraptor("incubated_velociraptor");
    public static final Item INCUBATED_TYRANNOSAURUS = new ItemIncTyrannosaurus("inc_tyrannosaurus");
    public static final Item CAMARASAURUS_SKULL = new ItemBase("camarasaurus_skull");
    public static final Item STEGOSAURUS_THAGOMIZER = new ItemBase("stegosaurus_thagomizer");
    public static final Item DRYOSAURUS_SKULL = new ItemBase("dryosaurus_skull");
    public static final Item ALLOSAURUS_SKULL = new ItemBase("allosaurus_skull");
    public static final Item CAMARASAURUS_EGG = new ItemCamarasaurusEgg("camarasaurus_egg");
    public static final Item INC_CAMARASAURUS = new ItemIncCamarasaurus("incubated_camarasaurus");
    public static final Item STEGOSAURUS_DNA = new ItemBase("stegosaurus_dna");
    public static final Item CAMARASAURUS_DNA = new ItemBase("camarasaurus_dna");
    public static final Item DRYOSAURUS_DNA = new ItemBase("dryosaurus_dna");
}
