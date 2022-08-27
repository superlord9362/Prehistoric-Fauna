package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.DilophosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.DilophosaurusSleepingModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;

public class DilophosaurusRenderer extends MobRenderer<DilophosaurusEntity,  EntityModel<DilophosaurusEntity>> {

	private static final ResourceLocation DILOPHOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic.png");
	private static final ResourceLocation DILOPHOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albin_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic_sleeping.png");
	private static final DilophosaurusModel DILOPHOSAURUS_MODEL = new DilophosaurusModel();
	private static final DilophosaurusSleepingModel DILOPHOSAURUS_SLEEPING_MODEL = new DilophosaurusSleepingModel();

	public DilophosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), DILOPHOSAURUS_MODEL, 1.2F);
	}

	public void render(DilophosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = DILOPHOSAURUS_SLEEPING_MODEL;
		} else {
			entityModel = DILOPHOSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(CeratosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(DilophosaurusEntity entity) {
		if (entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else {
			if (entity.isAsleep()) {
				return DILOPHOSAURUS_SLEEPING;
			} else return DILOPHOSAURUS;
		}
	}

}
