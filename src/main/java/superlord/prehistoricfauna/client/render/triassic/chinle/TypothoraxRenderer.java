package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.chinle.TypothoraxModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.TypothoraxSleepingModel;
import superlord.prehistoricfauna.client.render.layer.TypothoraxEyeLayer;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TypothoraxEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class TypothoraxRenderer extends MobRenderer<TypothoraxEntity, EntityModel<TypothoraxEntity>> {

	private static final ResourceLocation TYPOTHORAX = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/typothorax.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/melanistic.png");
	private static final ResourceLocation TYPOTHORAX_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/typothorax_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/melanistic_sleeping.png");
	private static final TypothoraxModel TYPOTHORAX_MODEL = new TypothoraxModel();
	private static final TypothoraxSleepingModel TYPOTHORAX_SLEEPING_MODEL = new TypothoraxSleepingModel();

	public TypothoraxRenderer() {
		super(Minecraft.getInstance().getRenderManager(), TYPOTHORAX_MODEL, 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new TypothoraxEyeLayer(this));
		}
	}

	public void render(TypothoraxEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = TYPOTHORAX_SLEEPING_MODEL;
		} else {
			entityModel = TYPOTHORAX_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(TypothoraxEntity typothorax, MatrixStack matrixStackIn, float partialTickTime) {
		if (typothorax.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(TypothoraxEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			}else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return TYPOTHORAX_SLEEPING;
			} else return TYPOTHORAX;
		}
	}

}
