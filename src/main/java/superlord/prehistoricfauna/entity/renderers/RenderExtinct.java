package superlord.prehistoricfauna.entity.renderers;

import superlord.prehistoricfauna.entity.EntityDryosaurus;
import superlord.prehistoricfauna.entity.models.Dryosaurus;
import superlord.prehistoricfauna.util.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderExtinct extends RenderLiving<EntityDryosaurus> {
	public static final Factory FACTORY = new Factory();

	public RenderExtinct(RenderManager manager) {
		super(manager, new Dryosaurus(), 0.2F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityDryosaurus entity) {
		if(entity.isChild()) {
			return new ResourceLocation(Reference.MOD_ID, "textures/entities/dryosaurus_baby.png");
		} else {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/dryosaurus.png");
		}
	}

	public static class Factory implements IRenderFactory<EntityDryosaurus> {

        @Override
        public Render<? super EntityDryosaurus> createRenderFor(RenderManager manager) {
            return new RenderExtinct(manager);
        }
    }
	
	@Override

    protected void preRenderCallback(EntityDryosaurus entity, float f) {
        this.shadowSize = entity.width * 0.45F;
    }
}