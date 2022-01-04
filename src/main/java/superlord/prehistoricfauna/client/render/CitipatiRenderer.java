package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.CitipatiModel;
import superlord.prehistoricfauna.common.entities.CitipatiEntity;

public class CitipatiRenderer extends MobRenderer<CitipatiEntity, CitipatiModel> {

	private static final ResourceLocation CITIPATI = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/citipati.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/melanistic.png");

	public CitipatiRenderer(EntityRendererManager rm) {
		super(rm, new CitipatiModel(), 0.5625F);
	}

	protected void preRenderCallback(CitipatiEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(CitipatiEntity entity) {
		if (entity.isAlbino()) {
			return ALBINO;
		} else if (entity.isMelanistic()) {
			return MELANISTIC;
		} else {
			return CITIPATI;
		}
	}

}
