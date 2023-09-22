package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SillosuchusBabyModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SillosuchusModel;
import superlord.prehistoricfauna.client.render.layer.SillosuchusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.SillosuchusEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class SillosuchusRenderer extends MobRenderer<Sillosuchus, EntityModel<Sillosuchus>> {
	private static final ResourceLocation SILLOSUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/sillosuchus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/melanistic.png");
	private static final ResourceLocation SILLOSUCHUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/sillosuchus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/melanistic_sleeping.png");
	private static final ResourceLocation SILLOSUCHUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/sillosuchus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/melanistic_baby.png");
	private static final ResourceLocation SILLOSUCHUS_SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/sillosuchus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/melanistic_baby_sleeping.png");

	private static SillosuchusModel SILLOSUCHUS_MODEL;
	private static SillosuchusBabyModel BABY_SILLOSUCHUS_MODEL;

	public SillosuchusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SillosuchusModel(renderManagerIn.bakeLayer(ClientEvents.SILLOSUCHUS)), 1.7F);
		SILLOSUCHUS_MODEL = new SillosuchusModel(renderManagerIn.bakeLayer(ClientEvents.SILLOSUCHUS));
		BABY_SILLOSUCHUS_MODEL = new SillosuchusBabyModel(renderManagerIn.bakeLayer(ClientEvents.SILLOSUCHUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new SillosuchusBabyEyeLayer(this));
			this.addLayer(new SillosuchusEyeLayer(this));
		}
	}

	protected void scale(Sillosuchus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = BABY_SILLOSUCHUS_MODEL;
		} else {
			model = SILLOSUCHUS_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Sillosuchus entity) {
		if (entity.isBaby()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING_BABY;
				} else return ALBINO_BABY;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING_BABY;
				} else return MELANISTIC_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return SILLOSUCHUS_SLEEPING_BABY;
				} else return SILLOSUCHUS_BABY;
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
					return SILLOSUCHUS_SLEEPING;
				} else return SILLOSUCHUS;
			}
		}
	}
}
