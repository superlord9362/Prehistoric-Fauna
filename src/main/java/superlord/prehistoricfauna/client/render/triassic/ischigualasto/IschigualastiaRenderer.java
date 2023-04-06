package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaModel;
import superlord.prehistoricfauna.client.render.layer.IschigualastiaEyeLayer;
import superlord.prehistoricfauna.client.render.layer.IschigualastiaSaddleLayer;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.IschigualastiaEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class IschigualastiaRenderer extends MobRenderer<IschigualastiaEntity, EntityModel<IschigualastiaEntity>> {

	private static final ResourceLocation ISCHIGUALASTIA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic.png");
	private static final ResourceLocation ISCHIGUALASTIA_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic_sleeping.png");
	private static final IschigualastiaModel ISCHIGUALASTIA_MODEL = new IschigualastiaModel();

	public IschigualastiaRenderer() {
		super(Minecraft.getInstance().getRenderManager(), ISCHIGUALASTIA_MODEL, 1.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new IschigualastiaEyeLayer(this));
		}
		this.addLayer(new IschigualastiaSaddleLayer(this));
	}

	protected void preRenderCallback(IschigualastiaEntity ischigualastia, MatrixStack matrixStackIn, float partialTickTime) {
		if (ischigualastia.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(IschigualastiaEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ISCHIGUALASTIA_SLEEPING;
			} else return ISCHIGUALASTIA;
		}
	}

}
