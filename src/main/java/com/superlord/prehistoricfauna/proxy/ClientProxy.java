package com.superlord.prehistoricfauna.proxy;

import com.superlord.prehistoricfauna.entity.EntityGallimimus;
import com.superlord.prehistoricfauna.entity.EntityTriceratops;
import com.superlord.prehistoricfauna.entity.EntityTyrannosaurus;
import com.superlord.prehistoricfauna.entity.EntityVelociraptor;
import com.superlord.prehistoricfauna.entity.renderers.GallimimusRenderer;
import com.superlord.prehistoricfauna.entity.renderers.TriceratopsRenderer;
import com.superlord.prehistoricfauna.entity.renderers.TyrannosaurusRenderer;
import com.superlord.prehistoricfauna.entity.renderers.VelociraptorRenderer;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	
	public void preInit(FMLPreInitializationEvent event) {

		super.preInit(event);

		RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, TriceratopsRenderer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, VelociraptorRenderer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityGallimimus.class, GallimimusRenderer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityTyrannosaurus.class, TyrannosaurusRenderer.FACTORY);
	}
	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	
}
