package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SaurosuchusBabyModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SaurosuchusModel;
import superlord.prehistoricfauna.client.render.layer.SaurosuchusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.SaurosuchusEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class SaurosuchusRenderer extends MobRenderer<Saurosuchus, EntityModel<Saurosuchus>> {
	private static final ResourceLocation SAUROSUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus.png");
	private static final ResourceLocation SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/melanistic_sleeping.png");
	private static final ResourceLocation SAUROSUCHUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus_baby.png");
	private static final ResourceLocation SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/albino_baby.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/melanistic_baby.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/melanistic_baby_sleeping.png");

	private static SaurosuchusModel SAUROSUCHUS_MODEL;
	private static SaurosuchusBabyModel BABY_SAUROSUCHUS_MODEL;

	public SaurosuchusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SaurosuchusModel(renderManagerIn.bakeLayer(ClientEvents.SAUROSUCHUS)), 0.75F);
		SAUROSUCHUS_MODEL = new SaurosuchusModel(renderManagerIn.bakeLayer(ClientEvents.SAUROSUCHUS));
		BABY_SAUROSUCHUS_MODEL = new SaurosuchusBabyModel(renderManagerIn.bakeLayer(ClientEvents.SAUROSUCHUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new SaurosuchusEyeLayer(this));
			this.addLayer(new SaurosuchusBabyEyeLayer(this));
		}
	}

	protected void scale(Saurosuchus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = BABY_SAUROSUCHUS_MODEL;
		} else {
			model = SAUROSUCHUS_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Saurosuchus entity) {
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
					return SLEEPING_BABY;
				} else return SAUROSUCHUS_BABY;
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
					return SLEEPING;
				} else return SAUROSUCHUS;
			}
		}
	}
}
