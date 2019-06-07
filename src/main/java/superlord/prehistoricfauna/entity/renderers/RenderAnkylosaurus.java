package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityAnkylosaurus;
import superlord.prehistoricfauna.entity.models.Ankylosaurus;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAnkylosaurus extends RenderLiving<EntityAnkylosaurus> {
	public static final Factory FACTORY = new Factory();

	public RenderAnkylosaurus(RenderManager manager) {
		super(manager, new Ankylosaurus(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityAnkylosaurus entity) {
		 if(entity.isChild()) {
			return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus_baby.png");
		} else {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/ankylosaurus.png");
		}
	}

	public static class Factory implements IRenderFactory<EntityAnkylosaurus> {

        @Override
        public Render<? super EntityAnkylosaurus> createRenderFor(RenderManager manager) {
            return new RenderAnkylosaurus(manager);
        }
    }
	
	@Override
    protected void preRenderCallback(EntityAnkylosaurus entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}