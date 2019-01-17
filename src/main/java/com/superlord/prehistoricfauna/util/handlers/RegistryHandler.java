package com.superlord.prehistoricfauna.util.handlers;

import com.superlord.prehistoricfauna.Main;
import com.superlord.prehistoricfauna.entity.EntityGallimimus;
import com.superlord.prehistoricfauna.entity.EntityTriceratops;
import com.superlord.prehistoricfauna.entity.EntityTyrannosaurus;
import com.superlord.prehistoricfauna.entity.EntityVelociraptor;
import com.superlord.prehistoricfauna.init.ModBlocks;
import com.superlord.prehistoricfauna.init.ModItems;
import com.superlord.prehistoricfauna.util.IHasModel;
import com.superlord.prehistoricfauna.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@EventBusSubscriber
public class RegistryHandler {
    private static int entityId = 0;

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "triceratops"), EntityTriceratops.class, "triceratops", entityId++, Main.instance, 64, 3, true, 12871971, 10507067);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "velociraptor"), EntityVelociraptor.class, "velociraptor", entityId++, Main.instance, 64, 3, true, 0x404040, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "gallimimus"), EntityGallimimus.class, "gallimimus", entityId++, Main.instance, 64, 3, true, 0x808080, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "tyrannosaurus"), EntityTyrannosaurus.class, "tyrannosaurus", entityId++, Main.instance, 64, 3, true, 0x3A1E0C, 0x000000);
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }

        for (Block block : ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }

    public static void initRegistries() {

    }
}
