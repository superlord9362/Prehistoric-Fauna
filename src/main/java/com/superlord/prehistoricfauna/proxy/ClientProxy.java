package com.superlord.prehistoricfauna.proxy;

import com.superlord.prehistoricfauna.entity.EntityTriceratops;
import com.superlord.prehistoricfauna.entity.renderers.TriceratopsRenderer;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	
	public void preInit(FMLPreInitializationEvent event) {

		super.preInit(event);

		RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, TriceratopsRenderer.FACTORY);
	}
	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
}
