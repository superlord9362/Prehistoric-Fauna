package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.TuojiangosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.TuojiangosaurusModel;
import superlord.prehistoricfauna.client.render.layer.TuojiangosaurusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TuojiangosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Tuojiangosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class TuojiangosaurusRenderer extends MobRenderer<Tuojiangosaurus, EntityModel<Tuojiangosaurus>> {
	private static final ResourceLocation TUOJIANGOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/tuojiangosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/melanistic.png");
	private static final ResourceLocation TUOJIANGOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/tuojiangosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/melanistic_sleeping.png");
	private static final ResourceLocation TUOJIANGOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/tuojiangosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/melanistic_baby.png");
	private static final ResourceLocation TUOJIANGOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/tuojiangosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tuojiangosaurus/melanistic_baby_sleeping.png");

	private static TuojiangosaurusModel TUOJIANGOSAURUS_MODEL;
	private static TuojiangosaurusBabyModel TUOJIANGOSAURUS_BABY_MODEL;

	public TuojiangosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TuojiangosaurusModel(renderManagerIn.bakeLayer(ClientEvents.TUOJIANGOSAURUS)), 1.3125F);
		TUOJIANGOSAURUS_MODEL = new TuojiangosaurusModel(renderManagerIn.bakeLayer(ClientEvents.TUOJIANGOSAURUS));
		TUOJIANGOSAURUS_BABY_MODEL = new TuojiangosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.TUOJIANGOSAURUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new TuojiangosaurusEyeLayer(this));
			this.addLayer(new TuojiangosaurusBabyEyeLayer(this));
		}
	}

	protected void scale(Tuojiangosaurus tuojiangosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(tuojiangosaurus.isBaby()) {
			model = TUOJIANGOSAURUS_BABY_MODEL;
		} else {
			model = TUOJIANGOSAURUS_MODEL;
		}
		super.scale(tuojiangosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Tuojiangosaurus entity) {
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
					return TUOJIANGOSAURUS_BABY_SLEEPING;
				} else return TUOJIANGOSAURUS_BABY;
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
					return TUOJIANGOSAURUS_SLEEPING;
				} else return TUOJIANGOSAURUS;
			}
		}
	}
}
