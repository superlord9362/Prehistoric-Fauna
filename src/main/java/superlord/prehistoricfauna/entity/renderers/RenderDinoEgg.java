package superlord.prehistoricfauna.entity.renderers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import superlord.prehistoricfauna.entity.EntityDinosaurEgg;
import superlord.prehistoricfauna.entity.models.ModelDinoEgg;

public class RenderDinoEgg extends RenderLiving<EntityDinosaurEgg> {

	public static final Factory FACTORY = new Factory();
	
	public RenderDinoEgg(RenderManager manager) {
		super(manager, new ModelDinoEgg(), 0.25F);
	}
	

	public static class Factory implements IRenderFactory<Entity> {

        @SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
        public Render<? super Entity> createRenderFor(RenderManager manager) {
            return (Render)new RenderDinoEgg(manager);
        }
    }

	@Override
	protected void preRenderCallback(EntityDinosaurEgg entity, float f) {
		GlStateManager.scale(entity.selfType.eggScale, entity.selfType.eggScale, entity.selfType.eggScale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityDinosaurEgg entity) {
		return new ResourceLocation(entity.getTexture());
	}
}
