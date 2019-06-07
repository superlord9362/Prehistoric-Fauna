package superlord.prehistoricfauna.entity.renderers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.entity.EntityDinosaurEgg;
import superlord.prehistoricfauna.entity.models.ModelDinoEgg;

public class RenderDinoEgg extends RenderLiving<EntityDinosaurEgg> {

	public RenderDinoEgg(RenderManager manager) {
		super(manager, new ModelDinoEgg(), 0.25F);
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
