package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaBabyModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaModel;
import superlord.prehistoricfauna.client.render.layer.IschigualastiaBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.IschigualastiaEyeLayer;
import superlord.prehistoricfauna.client.render.layer.IschigualastiaSaddleLayer;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class IschigualastiaRenderer extends MobRenderer<Ischigualastia, EntityModel<Ischigualastia>> {
	private static final ResourceLocation ISCHIGUALASTIA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic.png");
	private static final ResourceLocation ISCHIGUALASTIA_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic_sleeping.png");
	private static final ResourceLocation ISCHIGUALASTIA_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic_baby.png");
	private static final ResourceLocation ISCHIGUALASTIA_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/melanistic_baby_sleeping.png");

	private static IschigualastiaModel ISCHIGUALASTIA_MODEL;
	private static IschigualastiaBabyModel BABY_ISCHIGUALASTIA_MODEL;

	public IschigualastiaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new IschigualastiaModel(renderManagerIn.bakeLayer(ClientEvents.ISCHIGUALASTIA)), 1.25F);
		ISCHIGUALASTIA_MODEL = new IschigualastiaModel(renderManagerIn.bakeLayer(ClientEvents.ISCHIGUALASTIA));
		BABY_ISCHIGUALASTIA_MODEL = new IschigualastiaBabyModel(renderManagerIn.bakeLayer(ClientEvents.ISCHIGUALASTIA_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new IschigualastiaEyeLayer(this));
			this.addLayer(new IschigualastiaBabyEyeLayer(this));
		}
		this.addLayer(new IschigualastiaSaddleLayer(this));
	}

	protected void scale(Ischigualastia thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = BABY_ISCHIGUALASTIA_MODEL;
		} else {
			model = ISCHIGUALASTIA_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Ischigualastia entity) {
		if (entity.isBaby()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else return ALBINO_BABY;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else return MELANISTIC_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ISCHIGUALASTIA_BABY_SLEEPING;
				} else return ISCHIGUALASTIA_BABY;
			}
		} else {
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
}
