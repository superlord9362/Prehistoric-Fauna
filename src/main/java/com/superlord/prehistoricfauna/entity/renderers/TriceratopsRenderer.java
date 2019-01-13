package com.superlord.prehistoricfauna.entity.renderers;





import com.superlord.prehistoricfauna.entity.EntityTriceratops;
import com.superlord.prehistoricfauna.entity.models.Triceratops;
import com.superlord.prehistoricfauna.util.Reference;

import net.minecraft.client.Minecraft;

import net.minecraft.client.renderer.entity.Render;

import net.minecraft.client.renderer.entity.RenderLiving;

import net.minecraft.client.renderer.entity.RenderManager;

import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.client.registry.IRenderFactory;



public class TriceratopsRenderer extends RenderLiving<EntityTriceratops> {



	public static final Factory FACTORY = new Factory();

	

	public TriceratopsRenderer(RenderManager manager) {

		super(manager, new Triceratops(), 0.2F);

	}



	@Override

	protected ResourceLocation getEntityTexture(EntityTriceratops entity) {
		if (entity.isChild()) {
			if( entity.isAlbino()) {
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratopschild_albino.png");
			} else {
				if (entity.isMelanistic()) {
					return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratopschild_melanistic.png");
				} else {
					return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratopschild.png");
				}
			} 
		}else {
			if (entity.isMelanistic()) {
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops_melanistic.png");
			} else {
				if (entity.isAlbino()) {
					return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops_albino.png");
				}
			} 
				return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratops.png");
		}
	}

	

	

	public static class Factory implements IRenderFactory<EntityTriceratops> {



        @Override

        public Render<? super EntityTriceratops> createRenderFor(RenderManager manager) {

            return new TriceratopsRenderer(manager);

        }



    }

}