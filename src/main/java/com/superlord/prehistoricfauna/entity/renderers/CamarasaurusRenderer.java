package com.superlord.prehistoricfauna.entity.renderers;

import com.superlord.prehistoricfauna.entity.EntityCamarasaurus;
import com.superlord.prehistoricfauna.entity.EntityGallimimus;
import com.superlord.prehistoricfauna.entity.EntityTriceratops;
import com.superlord.prehistoricfauna.entity.models.Camarasaurus;
import com.superlord.prehistoricfauna.entity.models.Gallimimus;
import com.superlord.prehistoricfauna.entity.models.Triceratops;
import com.superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CamarasaurusRenderer extends RenderLiving<EntityCamarasaurus> {
	public static final Factory FACTORY = new Factory();

	public CamarasaurusRenderer(RenderManager manager) {
		super(manager, new Camarasaurus(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCamarasaurus entity) {
		if(entity.isChild()) {
			return new ResourceLocation(Reference.MOD_ID, "textures/entities/camarasauruschild.png");
		} else {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/camarasaurus.png");
		}
	}

	public static class Factory implements IRenderFactory<EntityCamarasaurus> {

        @Override
        public Render<? super EntityCamarasaurus> createRenderFor(RenderManager manager) {
            return new CamarasaurusRenderer(manager);
        }
    }
}