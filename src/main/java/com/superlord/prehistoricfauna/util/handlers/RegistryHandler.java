package com.superlord.prehistoricfauna.util.handlers;

import com.superlord.prehistoricfauna.Main;
import com.superlord.prehistoricfauna.entity.EntityTriceratops;
import com.superlord.prehistoricfauna.util.Reference;

import net.minecraft.util.ResourceLocation;
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
	}
	
	public static void initRegistries() {
	}
}
