package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.YangchuanosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.YangchuanosaurusModel;
import superlord.prehistoricfauna.client.render.layer.YangchuanosaurusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.YangchuanosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Yangchuanosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class YangchuanosaurusRenderer extends MobRenderer<Yangchuanosaurus, EntityModel<Yangchuanosaurus>> {
	private static final ResourceLocation YANGCHUANOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/yangchuanosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/melanistic.png");
	private static final ResourceLocation YANGCHUANOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/yangchuanosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/melanistic_sleeping.png");
	private static final ResourceLocation YANGCHUANOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/yangchuanosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/melanistic_baby.png");
	private static final ResourceLocation YANGCHUANOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/yangchuanosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/yangchuanosaurus/melanistic_baby_sleeping.png");

	private static YangchuanosaurusModel YANGCHUANOSAURUS_MODEL;
	private static YangchuanosaurusBabyModel BABY_YANGCHUANOSAURUS_MODEL;

	public YangchuanosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new YangchuanosaurusModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS)), 1.4375F);
		YANGCHUANOSAURUS_MODEL = new YangchuanosaurusModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS));
		BABY_YANGCHUANOSAURUS_MODEL = new YangchuanosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new YangchuanosaurusEyeLayer(this));
			this.addLayer(new YangchuanosaurusBabyEyeLayer(this));
		}
	}

	protected void scale(Yangchuanosaurus yangchuanosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(yangchuanosaurus.isBaby()) {
			model = BABY_YANGCHUANOSAURUS_MODEL;
		} else {
			model = YANGCHUANOSAURUS_MODEL;
		}
		super.scale(yangchuanosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Yangchuanosaurus entity) {
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
					return YANGCHUANOSAURUS_BABY_SLEEPING;
				} else return YANGCHUANOSAURUS_BABY;
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
					return YANGCHUANOSAURUS_SLEEPING;
				} else return YANGCHUANOSAURUS;
			}
		}
	}
}
