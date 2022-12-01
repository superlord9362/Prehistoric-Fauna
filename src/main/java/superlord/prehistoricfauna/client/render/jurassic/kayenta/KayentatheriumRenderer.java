package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.KayentatheriumModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.KayentatheriumSleepingModel;
import superlord.prehistoricfauna.client.render.layer.KayentatheriumEyeLayer;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.KayentatheriumEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class KayentatheriumRenderer extends MobRenderer<KayentatheriumEntity, EntityModel<KayentatheriumEntity>>{

	private static final ResourceLocation KAYENTATHERIUM = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/kayentatherium.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/melanistic.png");
	private static final ResourceLocation KAYENTATHERIUM_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/kayentatherium_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/melanistic_sleeping.png");

	private final static KayentatheriumModel KAYENTATHERIUM_MODEL = new KayentatheriumModel();
	private final static KayentatheriumSleepingModel KAYENTATHERIUM_SLEEPING_MODEL = new KayentatheriumSleepingModel();

	public KayentatheriumRenderer() {
		super(Minecraft.getInstance().getRenderManager(), KAYENTATHERIUM_MODEL, 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new KayentatheriumEyeLayer(this));
		}
	}

	public void render(KayentatheriumEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = KAYENTATHERIUM_SLEEPING_MODEL;
		} else {
			entityModel = KAYENTATHERIUM_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(KayentatheriumEntity kayentatherium, MatrixStack matrixStackIn, float partialTickTime) {
		if(kayentatherium.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(KayentatheriumEntity entity) {
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
				return KAYENTATHERIUM_SLEEPING;
			} else return KAYENTATHERIUM;
		}
	}

}
