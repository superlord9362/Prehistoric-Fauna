package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityEusthenopteron;
import superlord.prehistoricfauna.entity.models.Eusthenopteron;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEusthenopteron extends RenderLiving<EntityEusthenopteron> {
	public static final Factory FACTORY = new Factory();

	public RenderEusthenopteron(RenderManager manager) {
		super(manager, new Eusthenopteron(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEusthenopteron entity) {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/eusthenopteron/eusthenopteron.png");
	}

	public static class Factory implements IRenderFactory<EntityEusthenopteron> {

        @Override
        public Render<? super EntityEusthenopteron> createRenderFor(RenderManager manager) {
            return new RenderEusthenopteron(manager);
        }
    }
	
	@Override

    protected void preRenderCallback(EntityEusthenopteron entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}