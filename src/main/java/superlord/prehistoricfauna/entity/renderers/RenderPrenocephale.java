package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityPrenocephale;
import superlord.prehistoricfauna.entity.models.Prenocephale;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderPrenocephale extends RenderLiving<EntityPrenocephale> {
	public static final Factory FACTORY = new Factory();

	public RenderPrenocephale(RenderManager manager) {
		super(manager, new Prenocephale(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPrenocephale entity) {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/prenocephale/prenocephale.png");
	}

	public static class Factory implements IRenderFactory<EntityPrenocephale> {

        @Override
        public Render<? super EntityPrenocephale> createRenderFor(RenderManager manager) {
            return new RenderPrenocephale(manager);
        }
    }
	
	@Override
    protected void preRenderCallback(EntityPrenocephale entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}