package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.SinraptorBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.SinraptorModel;
import superlord.prehistoricfauna.client.render.layer.SinraptorBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.SinraptorEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Sinraptor;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class SinraptorRenderer extends MobRenderer<Sinraptor, EntityModel<Sinraptor>> {
	private static final ResourceLocation SINRAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/sinraptor.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/melanistic.png");
	private static final ResourceLocation SINRAPTOR_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/sinraptor_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/melanistic_sleeping.png");
	private static final ResourceLocation SINRAPTOR_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/sinraptor_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/melanistic_baby.png");
	private static final ResourceLocation SINRAPTOR_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/sinraptor_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/melanistic_baby_sleeping.png");

	private static SinraptorModel SINRAPTOR_MODEL;
	private static SinraptorBabyModel BABY_SINRAPTOR_MODEL;

	public SinraptorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SinraptorModel(renderManagerIn.bakeLayer(ClientEvents.SINRAPTOR)), 1.25F);
		SINRAPTOR_MODEL = new SinraptorModel(renderManagerIn.bakeLayer(ClientEvents.SINRAPTOR));
		BABY_SINRAPTOR_MODEL = new SinraptorBabyModel(renderManagerIn.bakeLayer(ClientEvents.SINRAPTOR_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new SinraptorBabyEyeLayer(this));
			this.addLayer(new SinraptorEyeLayer(this));
		}
	}

	protected void scale(Sinraptor sinraptor, PoseStack matrixStackIn, float partialTickTime) {
		if(sinraptor.isBaby()) {
			model = BABY_SINRAPTOR_MODEL;
		} else {
			model = SINRAPTOR_MODEL;
		}
		super.scale(sinraptor, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Sinraptor entity) {
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
					return SINRAPTOR_BABY_SLEEPING;
				} else return SINRAPTOR_BABY;
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
					return SINRAPTOR_SLEEPING;
				} else return SINRAPTOR;
			}
		}
	}
}
