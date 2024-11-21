package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.YutyrannusBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.YutyrannusModel;
import superlord.prehistoricfauna.client.render.layer.YutyrannusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.YutyrannusEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Yutyrannus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class YutyrannusRenderer extends MobRenderer<Yutyrannus, EntityModel<Yutyrannus>> {
	private static final ResourceLocation YUTYRANNUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/yutyrannus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/melanistic.png");
	private static final ResourceLocation YUTYRANNUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/yutyrannus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/melanistic_sleeping.png");

	private static final ResourceLocation YUTYRANNUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/yutyrannus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/melanistic_baby.png");
	private static final ResourceLocation YUTYRANNUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/yutyrannus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/melanistic_baby_sleeping.png");

	private static YutyrannusModel YUTYRANNUS_MODEL;
	private static YutyrannusBabyModel BABY_YUTYRANNUS;

	public YutyrannusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new YutyrannusModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS)), 1F);
		YUTYRANNUS_MODEL = new YutyrannusModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS));
		BABY_YUTYRANNUS = new YutyrannusBabyModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new YutyrannusEyeLayer(this));
			this.addLayer(new YutyrannusBabyEyeLayer(this));
		}
	}

	protected void scale(Yutyrannus yutyrannus, PoseStack matrixStackIn, float partialTickTime) {
		if(yutyrannus.isBaby()) {
			model = BABY_YUTYRANNUS;
		} else model = YUTYRANNUS_MODEL;
		super.scale(yutyrannus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Yutyrannus entity) {
		if (entity.isBaby()) {
			if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else return MELANISTIC_BABY;
			} else if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else return ALBINO_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return YUTYRANNUS_BABY_SLEEPING;
				} else return YUTYRANNUS_BABY;
			}
		} else {
			if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			} else if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return YUTYRANNUS_SLEEPING;
				} else return YUTYRANNUS;
			}
		}
	}
}
