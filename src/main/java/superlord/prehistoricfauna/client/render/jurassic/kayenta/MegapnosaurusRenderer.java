package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.MegapnosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.MegapnosaurusSleepingModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;

public class MegapnosaurusRenderer extends MobRenderer<MegapnosaurusEntity, EntityModel<MegapnosaurusEntity>> {

	private static final ResourceLocation MEGAPNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/megapnosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/melanistic.png");
	private static final ResourceLocation MEGAPNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/megapnosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/melanistic_sleeping.png");
	private static final MegapnosaurusModel MEGAPNOSAURUS_MODEL = new MegapnosaurusModel();
	private static final MegapnosaurusSleepingModel MEGAPNOSAURUS_SLEEPING_MODEL = new MegapnosaurusSleepingModel();

	public MegapnosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), MEGAPNOSAURUS_MODEL, 0.625F);
	}

	public void render(MegapnosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = MEGAPNOSAURUS_SLEEPING_MODEL;
		} else {
			entityModel = MEGAPNOSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(MegapnosaurusEntity megapnosaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if (megapnosaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(MegapnosaurusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			}else return MELANISTIC;
		} else {
			if (entity.isAsleep()) {
				return MEGAPNOSAURUS_SLEEPING;
			} else return MEGAPNOSAURUS;
		}
	}

}
