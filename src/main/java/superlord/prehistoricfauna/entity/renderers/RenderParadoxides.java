package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityParadoxides;
import superlord.prehistoricfauna.entity.models.Paradoxides;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderParadoxides extends RenderLiving<EntityParadoxides> {
	public static final Factory FACTORY = new Factory();

	public RenderParadoxides(RenderManager manager) {
		super(manager, new Paradoxides(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityParadoxides entity) {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/paradoxides/paradoxides.png");
	}

	public static class Factory implements IRenderFactory<EntityParadoxides> {

        @Override
        public Render<? super EntityParadoxides> createRenderFor(RenderManager manager) {
            return new RenderParadoxides(manager);
        }
    }
	
	@Override

    protected void preRenderCallback(EntityParadoxides entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}