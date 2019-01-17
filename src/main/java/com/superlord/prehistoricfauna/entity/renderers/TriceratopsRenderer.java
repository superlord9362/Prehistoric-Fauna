package com.superlord.prehistoricfauna.entity.renderers;

import com.superlord.prehistoricfauna.entity.EntityTriceratops;
import com.superlord.prehistoricfauna.entity.models.Triceratops;
import com.superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TriceratopsRenderer extends RenderLiving<EntityTriceratops> {
    public static final Factory FACTORY = new Factory();

    public TriceratopsRenderer(RenderManager manager) {
        super(manager, new Triceratops(), 0.2F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTriceratops entity) {
        // TODO you can now select your texture based on the modelType
        int modelType = entity.getModelType();
        if (entity.isChild()) {
            return new ResourceLocation(Reference.MOD_ID, "textures/entities/triceratopschild.png");
        } else {
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