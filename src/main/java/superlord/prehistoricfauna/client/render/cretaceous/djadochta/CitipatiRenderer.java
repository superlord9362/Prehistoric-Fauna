package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.CitipatiModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.CitipatiSleepingModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.CitipatiEntity;

public class CitipatiRenderer extends MobRenderer<CitipatiEntity, EntityModel<CitipatiEntity>> {

	private static final ResourceLocation CITIPATI = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/citipati.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/melanistic.png");
	private static final ResourceLocation CITIPATI_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/citipati_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/melanistic_sleeping.png");
	private static final CitipatiModel CITIPATI_MODEL = new CitipatiModel();
	private static final CitipatiSleepingModel CITIPATI_SLEEPING_MODEL = new CitipatiSleepingModel();

	public CitipatiRenderer(EntityRendererManager rm) {
		super(rm, CITIPATI_MODEL, 0.5625F);
	}

	protected void preRenderCallback(CitipatiEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	public void render(CitipatiEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep() || entityIn.isSitting()) {
			entityModel = CITIPATI_SLEEPING_MODEL;
		} else {
			entityModel = CITIPATI_MODEL;
		}
    	super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

	@Override
	public ResourceLocation getEntityTexture(CitipatiEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep()) {
				return CITIPATI_SLEEPING;
			} else return CITIPATI;
		}
	}

}
