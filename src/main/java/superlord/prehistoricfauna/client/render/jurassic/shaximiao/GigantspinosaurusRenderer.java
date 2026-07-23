package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.GigantspinosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.GigantspinosaurusModel;
import superlord.prehistoricfauna.client.render.layer.GigantspinosaurusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.GigantspinosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Gigantspinosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class GigantspinosaurusRenderer extends MobRenderer<Gigantspinosaurus, EntityModel<Gigantspinosaurus>> {
	private static final ResourceLocation GIGANTSPINOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/gigantspinosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/melanistic.png");
	private static final ResourceLocation GIGANTSPINOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/gigantspinosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/melanistic_sleeping.png");
	private static final ResourceLocation GIGANTSPINOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/gigantspinosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/melanistic_baby.png");
	private static final ResourceLocation GIGANTSPINOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/gigantspinosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gigantspinosaurus/melanistic_baby_sleeping.png");

	private static GigantspinosaurusModel GIGANTSPINOSAURUS_MODEL;
	private static GigantspinosaurusBabyModel BABY_GIGANTSPINOSAURUS_MODEL;

	public GigantspinosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GigantspinosaurusModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS)), 1.25F);
		GIGANTSPINOSAURUS_MODEL = new GigantspinosaurusModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS));
		BABY_GIGANTSPINOSAURUS_MODEL = new GigantspinosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new GigantspinosaurusEyeLayer(this));
			this.addLayer(new GigantspinosaurusBabyEyeLayer(this));
		}
	}

	protected void scale(Gigantspinosaurus gigantspinosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if( gigantspinosaurus.isBaby()) {
			model = BABY_GIGANTSPINOSAURUS_MODEL;
		} else {
			model = GIGANTSPINOSAURUS_MODEL;
		}
		super.scale(gigantspinosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Gigantspinosaurus entity) {
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
					return GIGANTSPINOSAURUS_BABY_SLEEPING;
				} else return GIGANTSPINOSAURUS_BABY;
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
					return GIGANTSPINOSAURUS_SLEEPING;
				} else return GIGANTSPINOSAURUS;
			}
		}
	}
}
