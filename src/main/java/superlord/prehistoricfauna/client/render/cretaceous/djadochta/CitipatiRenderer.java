package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.CitipatiModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.CitipatiEntity;

public class CitipatiRenderer extends MobRenderer<CitipatiEntity, EntityModel<CitipatiEntity>> {

	private static final ResourceLocation CITIPATI = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/citipati.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/melanistic.png");
	private static final ResourceLocation PALEOCRAFT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/paleocraft.png");
	private static final ResourceLocation CITIPATI_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/citipati_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/melanistic_sleeping.png");
	private static final ResourceLocation PALEOCRAFT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/citipati/paleocraft_sleeping.png");
	private static final CitipatiModel CITIPATI_MODEL = new CitipatiModel();

	public CitipatiRenderer(EntityRendererManager rm) {
		super(rm, CITIPATI_MODEL, 0.5625F);
	}

	protected void preRenderCallback(CitipatiEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(CitipatiEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = CITIPATI_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(CitipatiEntity entity) {
		String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
		if ( s != null && "Paleocraft".equals(s)) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return PALEOCRAFT_SLEEPING;
			} else return PALEOCRAFT;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return CITIPATI_SLEEPING;
			} else return CITIPATI;
		}
	}

}
