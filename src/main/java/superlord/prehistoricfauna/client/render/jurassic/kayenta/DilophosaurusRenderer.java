package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.DilophosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.DilophosaurusModel;
import superlord.prehistoricfauna.client.render.layer.DilophosaurusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.DilophosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DilophosaurusRenderer extends MobRenderer<Dilophosaurus, EntityModel<Dilophosaurus>> {
	private static final ResourceLocation DILOPHOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic.png");
	private static final ResourceLocation DILOPHOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic_sleeping.png");
	private static final ResourceLocation DILOPHOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic_baby.png");
	private static final ResourceLocation DILOPHOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic_baby_sleeping.png");
	private static final ResourceLocation NAVAJO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/navajo.png");
	private static final ResourceLocation NAVAJO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/navajo_sleeping.png");

	private static DilophosaurusModel DILOPHOSAURUS_MODEL;
	private static DilophosaurusBabyModel BABY_DILOPHOSAURUS_MODEL;
	
	public DilophosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DilophosaurusModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS)), 1.2F);
		DILOPHOSAURUS_MODEL = new DilophosaurusModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS));
		BABY_DILOPHOSAURUS_MODEL = new DilophosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DilophosaurusBabyEyeLayer(this));
			this.addLayer(new DilophosaurusEyeLayer(this));
		}
	}

	protected void scale(Dilophosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = BABY_DILOPHOSAURUS_MODEL;
		} else {
			model = DILOPHOSAURUS_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Dilophosaurus entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if (s != null && ("Navajo".equals(s)) && !entity.isBaby()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return NAVAJO_SLEEPING;
			} else return NAVAJO;
		}
		if (entity.isMelanistic()) {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else return MELANISTIC_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			}
		} else if (entity.isAlbino()) {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else return ALBINO_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			}
		} else {
			if (entity.isBaby()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return DILOPHOSAURUS_BABY_SLEEPING;
				} else return DILOPHOSAURUS_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return DILOPHOSAURUS_SLEEPING;
				} else return DILOPHOSAURUS;
			}
		}
	}
}
