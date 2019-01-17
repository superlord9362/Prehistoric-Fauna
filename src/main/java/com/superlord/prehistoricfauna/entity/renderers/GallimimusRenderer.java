package com.superlord.prehistoricfauna.entity.renderers;

import com.superlord.prehistoricfauna.entity.EntityGallimimus;
import com.superlord.prehistoricfauna.entity.models.Gallimimus;
import com.superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GallimimusRenderer extends RenderLiving<EntityGallimimus> {
    public static final Factory FACTORY = new Factory();

    public GallimimusRenderer(RenderManager manager) {
        super(manager, new Gallimimus(), 0.2F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGallimimus entity) {
        if (entity.isChild()) {
            return new ResourceLocation(Reference.MOD_ID, "textures/entities/gallimimuschild.png");
        } else {
            return new ResourceLocation(Reference.MOD_ID, "textures/entities/gallimimus.png");
        }
    }

    public static class Factory implements IRenderFactory<EntityGallimimus> {
        @Override
        public Render<? super EntityGallimimus> createRenderFor(RenderManager manager) {

            return new GallimimusRenderer(manager);
        }
    }
}