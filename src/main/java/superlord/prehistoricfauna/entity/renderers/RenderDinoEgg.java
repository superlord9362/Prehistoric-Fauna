
package superlord.prehistoricfauna.entity.renderers;



import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;

import net.minecraft.client.renderer.entity.RenderManager;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import superlord.prehistoricfauna.entity.EntityDinosaurEgg;
import superlord.prehistoricfauna.entity.EntityDryosaurus;
import superlord.prehistoricfauna.entity.models.ModelDinoEgg;
import superlord.prehistoricfauna.entity.renderers.DryosaurusRenderer.Factory;



public class RenderDinoEgg extends RenderLiving<EntityDinosaurEgg> {
	public static final Factory FACTORY = new Factory();



	public RenderDinoEgg(RenderManager manager) {

		super(manager, new ModelDinoEgg(), 0.25F);

	}



	@Override

	protected void preRenderCallback(EntityDinosaurEgg entity, float f) {

		GlStateManager.scale(entity.selfType.eggScale, entity.selfType.eggScale, entity.selfType.eggScale);

	}
	
	public static class Factory implements IRenderFactory<EntityDinosaurEgg> {
        @Override
        public Render<? super EntityDinosaurEgg> createRenderFor(RenderManager manager) {
            return new RenderDinoEgg(manager);
        }
    }



	@Override

	protected ResourceLocation getEntityTexture(EntityDinosaurEgg entity) {

		return new ResourceLocation(entity.getTexture());

	}

}