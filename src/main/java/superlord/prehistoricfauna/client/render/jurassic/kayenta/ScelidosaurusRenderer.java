package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScelidosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScelidosaurusSleepingModel;
import superlord.prehistoricfauna.client.render.layer.ScelidosaurusEyeLayer;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScelidosaurusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ScelidosaurusRenderer extends MobRenderer<ScelidosaurusEntity, EntityModel<ScelidosaurusEntity>> {

	private static final ResourceLocation SCELIDOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/scelidosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/melanistic.png");
	private static final ResourceLocation SCELIDOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/scelidosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/melanistic_sleeping.png");
	private static final ScelidosaurusModel SCELIDOSAURUS_MODEL = new ScelidosaurusModel();
	private static final ScelidosaurusSleepingModel SCELIDOSAURUS_SLEEPING_MODEL = new ScelidosaurusSleepingModel();

	public ScelidosaurusRenderer(EntityRendererManager rm) {
		super(rm, SCELIDOSAURUS_MODEL, 1F);	
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ScelidosaurusEyeLayer(this));
		}
	}

	protected void preRenderCallback(ScelidosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(ScelidosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = SCELIDOSAURUS_SLEEPING_MODEL;
		} else {
			entityModel = SCELIDOSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(ScelidosaurusEntity entity) {
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
				return SCELIDOSAURUS_SLEEPING;
			} else return SCELIDOSAURUS;
		}
	}

}
