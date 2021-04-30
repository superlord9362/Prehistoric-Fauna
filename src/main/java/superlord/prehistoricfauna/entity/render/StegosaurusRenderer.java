package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.StegosaurusEntity;
import superlord.prehistoricfauna.entity.model.Stegosaurus;

public class StegosaurusRenderer extends MobRenderer<StegosaurusEntity, Stegosaurus> {

	private static final ResourceLocation STEGOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/stegosaurus.png");
	
	public StegosaurusRenderer(EntityRendererManager rm) {
		super(rm, new Stegosaurus(), 1.25F);
	}
	
	protected void preRenderCallback(StegosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		 if(entity.isChild()) {
			 matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		 }
	 }
	
	@Override
	public ResourceLocation getEntityTexture(StegosaurusEntity entity) {
		return STEGOSAURUS;
	}

	
}
