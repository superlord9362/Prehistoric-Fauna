package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.BrontosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.BrontosaurusJuvenileModel;
//import superlord.prehistoricfauna.client.model.jurassic.morrison.BrontosaurusSubadultModel;
//import superlord.prehistoricfauna.client.model.jurassic.morrison.BrontosaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.BrontosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.BrontosaurusSubadultModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Brontosaurus;

public class BrontosaurusRenderer extends MobRenderer<Brontosaurus, EntityModel<Brontosaurus>> {
	private static final ResourceLocation BRONTOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/brontosaurus.png");
	private static final ResourceLocation BRONTOSAURUS_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/brontosaurus_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/melanistic_juvenile.png");
	private static final ResourceLocation BRONTOSAURUS_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/brontosaurus_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/melanistic_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/melanistic.png");
	private static final ResourceLocation BRONTOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/brontosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/melanistic_sleeping.png");
	private static final ResourceLocation BRONTOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/brontosaurus_baby.png");
	private static final ResourceLocation BRONTOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/brontosaurus_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/melanistic_baby.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/melanistic_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/albino_baby.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation BRONTOSAURUS_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/brontosaurus_subadult.png");
	private static final ResourceLocation BRONTOSAURUS_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/brontosaurus_subadult_sleeping.png");
	private static final ResourceLocation MELANISTIC_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/melanistic_subadult.png");
	private static final ResourceLocation MELANISTIC_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/melanistic_subadult_sleeping.png");
	private static final ResourceLocation ALBINO_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/albino_subadult.png");
	private static final ResourceLocation ALBINO_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/brontosaurus/albino_subadult_sleeping.png");

	private static BrontosaurusModel BRONTOSAURUS_MODEL;
	private static BrontosaurusJuvenileModel JUVENILE_BRONTOSAURUS_MODEL;
	private static BrontosaurusBabyModel BABY_BRONTOSAURUS_MODEL;
	private static BrontosaurusSubadultModel SUBADULT_BRONTOSAURUS_MODEL;


	public BrontosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BrontosaurusModel(renderManagerIn.bakeLayer(ClientEvents.BRONTOSAURUS)), 3);
		BRONTOSAURUS_MODEL = new BrontosaurusModel(renderManagerIn.bakeLayer(ClientEvents.BRONTOSAURUS));
		JUVENILE_BRONTOSAURUS_MODEL = new BrontosaurusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.BRONTOSAURUS_JUVENILE));
		BABY_BRONTOSAURUS_MODEL = new BrontosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.BRONTOSAURUS_BABY));
		SUBADULT_BRONTOSAURUS_MODEL = new BrontosaurusSubadultModel(renderManagerIn.bakeLayer(ClientEvents.BRONTOSAURUS_SUBADULT));
	}

	protected void scale(Brontosaurus brontosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(brontosaurus.isBaby()) {
			if (!brontosaurus.isJuvenile() && !brontosaurus.isSubadult()) {
				model = BABY_BRONTOSAURUS_MODEL;
			} else if (brontosaurus.isJuvenile()) {
				model = JUVENILE_BRONTOSAURUS_MODEL;
			} else {
				model = SUBADULT_BRONTOSAURUS_MODEL;
			}
		} else {
			model = BRONTOSAURUS_MODEL;
		}
	}

	@Override
	public ResourceLocation getTextureLocation(Brontosaurus entity) {
		if (entity.isBaby() && !entity.isJuvenile() && !entity.isSubadult()) {
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
					return BRONTOSAURUS_BABY_SLEEPING;
				} else return BRONTOSAURUS_BABY;
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
					return BRONTOSAURUS_JUVENILE_SLEEPING;
				} else return BRONTOSAURUS_JUVENILE;
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
					return BRONTOSAURUS_SUBADULT_SLEEPING;
				} else return BRONTOSAURUS_SUBADULT;
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
					return BRONTOSAURUS_SLEEPING;
				} else return BRONTOSAURUS;
			}
		}
	}
}
