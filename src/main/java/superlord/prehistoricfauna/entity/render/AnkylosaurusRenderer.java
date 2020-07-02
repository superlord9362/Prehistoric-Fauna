package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.EntityAnkylosaurus;
import superlord.prehistoricfauna.entity.model.Ankylosaurus;

public class AnkylosaurusRenderer extends MobRenderer<EntityAnkylosaurus, Ankylosaurus> {

	private static final ResourceLocation ANKYLOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/ankylosaurus.png");
	
	public AnkylosaurusRenderer(EntityRendererManager rm) {
		super(rm, new Ankylosaurus(), 0.5F);
	}
	
	@SuppressWarnings("deprecation")
	protected void preRenderCallback(EntityAnkylosaurus entitylivingbaseIn, float partialTickTime) {
		GlStateManager.translated(0.0, 0, 0);
	}
	
	@Override
	public ResourceLocation getEntityTexture(EntityAnkylosaurus entity) {
		return ANKYLOSAURUS;
	}

	
}
