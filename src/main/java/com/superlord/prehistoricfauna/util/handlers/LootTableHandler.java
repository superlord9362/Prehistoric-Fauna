package com.superlord.prehistoricfauna.util.handlers;

import com.superlord.prehistoricfauna.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {

    public static final ResourceLocation VELOCIRAPTOR = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "velociraptor"));
    public static final ResourceLocation TRICERATOPS = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "triceratops"));
    public static final ResourceLocation TYRANNOSAURUS = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "tyrannosaurus"));
    public static final ResourceLocation GALLIMIMUS = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "gallimimus"));
    public static final ResourceLocation CAMARASAURUS = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "camarasaurus"));
}
