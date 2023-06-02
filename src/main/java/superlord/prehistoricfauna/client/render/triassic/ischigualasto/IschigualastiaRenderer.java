package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaModel;
import superlord.prehistoricfauna.client.render.layer.IschigualastiaEyeLayer;
import superlord.prehistoricfauna.client.render.layer.IschigualastiaSaddleLayer;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class IschigualastiaRenderer extends MobRenderer<Ischigualastia, IschigualastiaModel> {
	private static final ResourceLocation ISCHIGUALASTIA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic.png");
	private static final ResourceLocation ISCHIGUALASTIA_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic_sleeping.png");

	public IschigualastiaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new IschigualastiaModel(renderManagerIn.bakeLayer(ClientEvents.ISCHIGUALASTIA)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new IschigualastiaEyeLayer(this));
		}
		this.addLayer(new IschigualastiaSaddleLayer(this));
	}

	protected void scale(Ischigualastia thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Ischigualastia entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ISCHIGUALASTIA_SLEEPING;
			} else return ISCHIGUALASTIA;
		}
	}
}
