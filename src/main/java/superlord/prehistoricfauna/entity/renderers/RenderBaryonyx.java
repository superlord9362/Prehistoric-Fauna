package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityBaryonyx;
import superlord.prehistoricfauna.entity.models.Baryonyx;
import superlord.prehistoricfauna.entity.models.Baryonyxv2;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBaryonyx extends RenderLiving<EntityBaryonyx> {
	public static final Factory FACTORY = new Factory();

	public RenderBaryonyx(RenderManager manager) {
		super(manager, new Baryonyxv2(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBaryonyx entity) {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/baryonyx.png");
	}

	public static class Factory implements IRenderFactory<EntityBaryonyx> {

        @Override
        public Render<? super EntityBaryonyx> createRenderFor(RenderManager manager) {
            return new RenderBaryonyx(manager);
        }
    }
	
	@Override
    protected void preRenderCallback(EntityBaryonyx entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}