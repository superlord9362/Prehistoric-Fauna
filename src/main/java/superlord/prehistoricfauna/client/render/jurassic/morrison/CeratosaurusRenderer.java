package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusModel;
import superlord.prehistoricfauna.client.render.layer.CeratosaurusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.CeratosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CeratosaurusRenderer extends MobRenderer<Ceratosaurus, EntityModel<Ceratosaurus>> {
	private static final ResourceLocation CERATOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic.png");
	private static final ResourceLocation CERATOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic_sleeping.png");
	private static final ResourceLocation CERATOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic_baby.png");
	private static final ResourceLocation CERATOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic_baby_sleeping.png");

	private static CeratosaurusModel CERATOSAURUS_MODEL;
	private static CeratosaurusBabyModel BABY_CERATOSAURUS_MODEL;

	public CeratosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CeratosaurusModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS)), 0.75F);
		CERATOSAURUS_MODEL = new CeratosaurusModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS));
		BABY_CERATOSAURUS_MODEL = new CeratosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new CeratosaurusBabyEyeLayer(this));
			this.addLayer(new CeratosaurusEyeLayer(this));
		}
	}

	protected void scale(Ceratosaurus ceratosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(ceratosaurus.isBaby()) {
			model = BABY_CERATOSAURUS_MODEL;
		} else {
			model = CERATOSAURUS_MODEL;
		}
		super.scale(ceratosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Ceratosaurus entity) {
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
					return CERATOSAURUS_BABY_SLEEPING;
				} else return CERATOSAURUS_BABY;
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
					return CERATOSAURUS_SLEEPING;
				} else return CERATOSAURUS;
			}
		}
	}
}
