package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SaurosuchusModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SaurosuchusSleepingModel;
import superlord.prehistoricfauna.client.render.layer.SaurosuchusEyeLayer;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class SaurosuchusRenderer extends MobRenderer<SaurosuchusEntity, EntityModel<SaurosuchusEntity>> {

	private static final ResourceLocation SAUROSUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus.png");
	private static final ResourceLocation SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/melanistic_sleeping.png");
	private static final SaurosuchusModel SAUROSUCHUS_MODEL = new SaurosuchusModel();
	private static final SaurosuchusSleepingModel SAUROSUCHUS_SLEEPING_MODEL = new SaurosuchusSleepingModel();

	public SaurosuchusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), SAUROSUCHUS_MODEL, 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new SaurosuchusEyeLayer(this));
		}
	}

	protected void preRenderCallback(SaurosuchusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(SaurosuchusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isSleeping() || entityIn.isAsleep()) {
			entityModel = SAUROSUCHUS_SLEEPING_MODEL;
		} else {
			entityModel = SAUROSUCHUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(SaurosuchusEntity entity) {
		if (entity.isAlbino()) {
			return ALBINO;
		} else if (entity.isAlbino() && (entity.isSleeping() || entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5)) {
			return ALBINO_SLEEPING;
		} else if (entity.isMelanistic()) {
			return MELANISTIC;
		} else if (entity.isMelanistic() && (entity.isSleeping() || entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5)) {
			return MELANISTIC_SLEEPING;
		} else if((entity.isSleeping() || entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) && !entity.isMelanistic() && !entity.isAlbino()) {
			return SLEEPING;
		} else {
			return SAUROSUCHUS;
		}
	}


}
