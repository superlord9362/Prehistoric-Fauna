package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaSleepingModel;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.IschigualastiaEntity;

public class IschigualastiaRenderer extends MobRenderer<IschigualastiaEntity, EntityModel<IschigualastiaEntity>> {

	private static final ResourceLocation ISCHIGUALASTIA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia.png");
	private static final ResourceLocation ISCHIGUALASTIA_SADDLED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_saddled.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino.png");
	private static final ResourceLocation ALBINO_SADDLED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino_saddled.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic.png");
	private static final ResourceLocation MELANISTIC_SADDLED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic_saddled.png");
	private static final ResourceLocation ISCHIGUALASTIA_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_sleeping.png");
	private static final ResourceLocation ISCHIGUALASTIA_SADDLED_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_saddled_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino_sleeping.png");
	private static final ResourceLocation ALBINO_SADDLED_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino_saddled_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic_sleeping.png");
	private static final ResourceLocation MELANISTIC_SADDLED_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic_saddled_sleeping.png");
	private static final IschigualastiaModel ISCHIGUALASTIA_MODEL = new IschigualastiaModel();
	private static final IschigualastiaSleepingModel ISCHIGUALASTIA_SLEEPING_MODEL = new IschigualastiaSleepingModel();

	public IschigualastiaRenderer() {
		super(Minecraft.getInstance().getRenderManager(), ISCHIGUALASTIA_MODEL, 1.25F);
	}

	public void render(IschigualastiaEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = ISCHIGUALASTIA_SLEEPING_MODEL;
		} else {
			entityModel = ISCHIGUALASTIA_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(IschigualastiaEntity ischigualastia, MatrixStack matrixStackIn, float partialTickTime) {
		if (ischigualastia.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(IschigualastiaEntity entity) {
		if (entity.isAlbino() && !entity.getSaddled()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isAlbino() && entity.getSaddled()) {
			if (entity.isAsleep()) {
				return ALBINO_SADDLED_SLEEPING;
			} else return ALBINO_SADDLED;
		} else if (entity.isMelanistic() && !entity.getSaddled()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else if (entity.isMelanistic() && entity.getSaddled()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SADDLED_SLEEPING;
			} else return MELANISTIC_SADDLED;
		} else if(entity.getSaddled()) {
			if (entity.isAsleep()) {
				return ISCHIGUALASTIA_SADDLED_SLEEPING;
			} else return ISCHIGUALASTIA_SADDLED;
		} else {
			if (entity.isAsleep()) {
				return ISCHIGUALASTIA_SLEEPING;
			} else return ISCHIGUALASTIA;
		}
	}

}
