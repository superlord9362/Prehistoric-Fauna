package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.BrachiosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.BrachiosaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.BrachiosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.BrachiosaurusSubadultModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Brachiosaurus;

public class BrachiosaurusRenderer extends MobRenderer<Brachiosaurus, EntityModel<Brachiosaurus>> {
	private static final ResourceLocation BRACHIOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/brachiosaurus.png");
	private static final ResourceLocation BRACHIOSAURUS_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/brachiosaurus_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/melanistic_juvenile.png");
	private static final ResourceLocation BRACHIOSAURUS_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/brachiosaurus_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/melanistic_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/melanistic.png");
	private static final ResourceLocation BRACHIOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/brachiosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/melanistic_sleeping.png");
	private static final ResourceLocation BRACHIOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/brachiosaurus_baby.png");
	private static final ResourceLocation BRACHIOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/brachiosaurus_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/melanistic_baby.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/melanistic_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/albino_baby.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation BRACHIOSAURUS_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/brachiosaurus_subadult.png");
	private static final ResourceLocation BRACHIOSAURUS_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/brachiosaurus_subadult_sleeping.png");
	private static final ResourceLocation MELANISTIC_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/melanistic_subadult.png");
	private static final ResourceLocation MELANISTIC_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/melanistic_subadult_sleeping.png");
	private static final ResourceLocation ALBINO_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/albino_subadult.png");
	private static final ResourceLocation ALBINO_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brachiosaurus/albino_subadult_sleeping.png");

	private static BrachiosaurusModel BRACHIOSAURUS_MODEL;
	private static BrachiosaurusJuvenileModel JUVENILE_BRACHIOSAURUS_MODEL;
	private static BrachiosaurusBabyModel BABY_BRACHIOSAURUS_MODEL;
	private static BrachiosaurusSubadultModel SUBADULT_BRACHIOSAURUS_MODEL;


	public BrachiosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BrachiosaurusModel(renderManagerIn.bakeLayer(ClientEvents.BRACHIOSAURUS)), 3);
		BRACHIOSAURUS_MODEL = new BrachiosaurusModel(renderManagerIn.bakeLayer(ClientEvents.BRACHIOSAURUS));
		SUBADULT_BRACHIOSAURUS_MODEL = new BrachiosaurusSubadultModel(renderManagerIn.bakeLayer(ClientEvents.BRACHIOSAURUS_SUBADULT));
		JUVENILE_BRACHIOSAURUS_MODEL = new BrachiosaurusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.BRACHIOSAURUS_JUVENILE));
		BABY_BRACHIOSAURUS_MODEL = new BrachiosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.BRACHIOSAURUS_BABY));
	}

	protected void scale(Brachiosaurus brachiosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(brachiosaurus.isBaby()) {
			if (!brachiosaurus.isJuvenile() && !brachiosaurus.isSubadult()) {
				model = BABY_BRACHIOSAURUS_MODEL;
			} else if (brachiosaurus.isJuvenile()) {
				model = JUVENILE_BRACHIOSAURUS_MODEL;
			} else {
				model = SUBADULT_BRACHIOSAURUS_MODEL;
			}
		} else {
			model = BRACHIOSAURUS_MODEL;
		}
	}

	@Override
	public ResourceLocation getTextureLocation(Brachiosaurus entity) {
		if (entity.isBaby()	&& !entity.isJuvenile() && !entity.isSubadult()) {
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
					return BRACHIOSAURUS_BABY_SLEEPING;
				} else return BRACHIOSAURUS_BABY;
			}
		} else if (entity.isJuvenile()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_JUVENILE_SLEEPING;
				} else return ALBINO_JUVENILE;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_JUVENILE_SLEEPING;
				} else return MELANISTIC_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return BRACHIOSAURUS_JUVENILE_SLEEPING;
				} else return BRACHIOSAURUS_JUVENILE;
			}
		} else if (entity.isSubadult()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SUBADULT_SLEEPING;
				} else return ALBINO_SUBADULT;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SUBADULT_SLEEPING;
				} else return MELANISTIC_SUBADULT;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return BRACHIOSAURUS_SUBADULT_SLEEPING;
				} else return BRACHIOSAURUS_SUBADULT;
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
					return BRACHIOSAURUS_SLEEPING;
				} else return BRACHIOSAURUS;
			}
		}
	}
}
