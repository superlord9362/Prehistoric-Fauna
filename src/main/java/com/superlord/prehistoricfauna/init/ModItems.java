package com.superlord.prehistoricfauna.init;

import com.superlord.prehistoricfauna.items.ItemBase;
import com.superlord.prehistoricfauna.items.ItemDinoEgg;
import com.superlord.prehistoricfauna.items.ItemGallimimusEgg;
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
}
