package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScutellosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScutellosaurusSleepingModel;
import superlord.prehistoricfauna.client.render.layer.ScutellosaurusEyeLayer;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScutellosaurusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ScutellosaurusRenderer extends MobRenderer<ScutellosaurusEntity, EntityModel<ScutellosaurusEntity>> {

	private static final ResourceLocation SCUTELLOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/scutellosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/melanistic.png");
	private static final ResourceLocation SCUTELLOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/scutellosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/melanistic_sleeping.png");
	private static final ScutellosaurusModel SCUTELLOSAURUS_MODEL = new ScutellosaurusModel();
	private static final ScutellosaurusSleepingModel SCUTELLOSAURUS_SLEEPING_MODEL = new ScutellosaurusSleepingModel();

	public ScutellosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), SCUTELLOSAURUS_MODEL, 0.375F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ScutellosaurusEyeLayer(this));
		}
	}

	public void render(ScutellosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = SCUTELLOSAURUS_SLEEPING_MODEL;
		} else {
			entityModel = SCUTELLOSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(ScutellosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(ScutellosaurusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return SCUTELLOSAURUS_SLEEPING;
			} else return SCUTELLOSAURUS;
		}
	}

}
