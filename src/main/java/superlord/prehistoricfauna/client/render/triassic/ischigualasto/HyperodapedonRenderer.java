package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.HyperodapedonModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.HyperodapedonSleepingModel;
import superlord.prehistoricfauna.client.render.layer.HyperodapedonEyeLayer;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class HyperodapedonRenderer extends MobRenderer<HyperodapedonEntity, EntityModel<HyperodapedonEntity>> {

	private static final ResourceLocation HYPERODAPEDON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/hyperodapedon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/melanistic.png");
	private static final ResourceLocation HYPERODAPEDON_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/hyperodapedon_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/melanistic_sleeping.png");
	private static final HyperodapedonModel HYPERODAPEDON_MODEL = new HyperodapedonModel();
	private static final HyperodapedonSleepingModel HYPERODAPEDON_SLEEPING_MODEL = new HyperodapedonSleepingModel();

	public HyperodapedonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), HYPERODAPEDON_MODEL, 0.325F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new HyperodapedonEyeLayer(this));
		}
	}

	public void render(HyperodapedonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel =HYPERODAPEDON_SLEEPING_MODEL;
		} else {
			entityModel = HYPERODAPEDON_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(HyperodapedonEntity hyperodapedon, MatrixStack matrixStackIn, float partialTickTime) {
		if (hyperodapedon.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(HyperodapedonEntity entity) {
		if(entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return HYPERODAPEDON_SLEEPING;
			} else return HYPERODAPEDON;
		}
	}

}
