package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusSleepingModel;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;

public class CeratosaurusRenderer extends MobRenderer<CeratosaurusEntity,  EntityModel<CeratosaurusEntity>> {

	private static final ResourceLocation CERATOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic.png");
	private static final ResourceLocation CERATOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albin_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic_sleeping.png");
	private static final CeratosaurusModel CERATOSAURUS_MODEL = new CeratosaurusModel();
	private static final CeratosaurusSleepingModel CERATOSAURUS_SLEEPING_MODEL = new CeratosaurusSleepingModel();

	public CeratosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CERATOSAURUS_MODEL, 0.75F);
	}

	public void render(CeratosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = CERATOSAURUS_SLEEPING_MODEL;
		} else {
			entityModel = CERATOSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(CeratosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(CeratosaurusEntity entity) {
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
				return CERATOSAURUS_SLEEPING;
			} else return CERATOSAURUS;
		}
	}

}
