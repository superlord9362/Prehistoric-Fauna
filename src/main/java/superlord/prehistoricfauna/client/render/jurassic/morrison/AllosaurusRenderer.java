package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.AllosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.AllosaurusModel;
import superlord.prehistoricfauna.client.render.layer.AllosaurusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.AllosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class AllosaurusRenderer extends MobRenderer<Allosaurus, EntityModel<Allosaurus>> {
	private static final ResourceLocation ALLOSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/allosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/melanistic.png");
	private static final ResourceLocation ALLOSAURUS_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/allosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/melanistic_sleeping.png");
	private static final ResourceLocation ALLOSAURUS_BABY_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/allosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/melanistic_baby.png");
	private static final ResourceLocation ALLOSAURUS_BABY_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/allosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/allosaurus/melanistic_baby_sleeping.png");

	private static AllosaurusModel ALLOSAURUS_MODEL;
	private static AllosaurusBabyModel BABY_ALLOSAURUS_MODEL;

	public AllosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AllosaurusModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS)), 1.25F);
		ALLOSAURUS_MODEL = new AllosaurusModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS));
		BABY_ALLOSAURUS_MODEL = new AllosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new AllosaurusBabyEyeLayer(this));
			this.addLayer(new AllosaurusEyeLayer(this));
		}
	}

	protected void scale(Allosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = BABY_ALLOSAURUS_MODEL;
		} else {
			model = ALLOSAURUS_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Allosaurus entity) {
		if (entity.isBaby()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else {
					return ALBINO_BABY;
				}
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else {
					return MELANISTIC_BABY;
				}
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALLOSAURUS_BABY_SLEEPING_TEXTURE;
				} else {
					return ALLOSAURUS_BABY_TEXTURE;
				}
			}
		} else {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else {
					return ALBINO;
				}
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else {
					return MELANISTIC;
				}
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALLOSAURUS_SLEEPING_TEXTURE;
				} else {
					return ALLOSAURUS_TEXTURE;
				}
			}
		}
	}
}
