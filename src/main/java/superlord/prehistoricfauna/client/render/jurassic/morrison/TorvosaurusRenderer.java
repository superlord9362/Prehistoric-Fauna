package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.TorvosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.TorvosaurusModel;
import superlord.prehistoricfauna.client.render.layer.TorvosaurusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TorvosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Torvosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class TorvosaurusRenderer extends MobRenderer<Torvosaurus, EntityModel<Torvosaurus>> {
	private static final ResourceLocation TORVOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/torvosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/melanistic.png");
	private static final ResourceLocation TORVOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/torvosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/melanistic_sleeping.png");
	private static final ResourceLocation TORVOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/torvosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/melanistic_baby.png");
	private static final ResourceLocation TORVOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/torvosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/torvosaurus/melanistic_baby_sleeping.png");

	private static TorvosaurusModel TORVOSAURUS_MODEL;
	private static TorvosaurusBabyModel BABY_TORVOSAURUS_MODEL;

	public TorvosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TorvosaurusModel(renderManagerIn.bakeLayer(ClientEvents.TORVOSAURUS)), 1.25F);
		TORVOSAURUS_MODEL = new TorvosaurusModel(renderManagerIn.bakeLayer(ClientEvents.TORVOSAURUS));
		BABY_TORVOSAURUS_MODEL = new TorvosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.TORVOSAURUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new TorvosaurusBabyEyeLayer(this));
			this.addLayer(new TorvosaurusEyeLayer(this));
		}
	}

	protected void scale(Torvosaurus torvosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(torvosaurus.isBaby()) {
			model = BABY_TORVOSAURUS_MODEL;
		} else {
			model = TORVOSAURUS_MODEL;
		}
		super.scale(torvosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Torvosaurus entity) {
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
					return TORVOSAURUS_BABY_SLEEPING;
				} else return TORVOSAURUS_BABY;
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
					return TORVOSAURUS_SLEEPING;
				} else return TORVOSAURUS;
			}
		}
	}
}
