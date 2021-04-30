package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.AnkylosaurusEntity;
import superlord.prehistoricfauna.entity.model.Ankylosaurus;

public class AnkylosaurusRenderer extends MobRenderer<AnkylosaurusEntity, Ankylosaurus> {

	private static final ResourceLocation ANKYLOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/ankylosaurus.png");
	
	public AnkylosaurusRenderer(EntityRendererManager rm) {
		super(rm, new Ankylosaurus(), 2F);
	}
	
	protected void preRenderCallback(AnkylosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		 if(entity.isChild()) {
			 matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		 }
	 }
	
	@Override
	public ResourceLocation getEntityTexture(AnkylosaurusEntity entity) {
		return ANKYLOSAURUS;
	}

	
}
