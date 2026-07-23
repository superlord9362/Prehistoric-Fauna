package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.MamenchisaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.MamenchisaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.MamenchisaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.MamenchisaurusSubadultModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Mamenchisaurus;

public class MamenchisaurusRenderer extends MobRenderer<Mamenchisaurus, EntityModel<Mamenchisaurus>> {
	private static final ResourceLocation MAMENCHISAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/mamenchisaurus.png");
	private static final ResourceLocation MAMENCHISAURUS_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/mamenchisaurus_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/melanistic_juvenile.png");
	private static final ResourceLocation MAMENCHISAURUS_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/mamenchisaurus_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/melanistic_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/melanistic.png");
	private static final ResourceLocation MAMENCHISAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/mamenchisaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/melanistic_sleeping.png");
	private static final ResourceLocation MAMENCHISAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/mamenchisaurus_baby.png");
	private static final ResourceLocation MAMENCHISAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/mamenchisaurus_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/melanistic_baby.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/melanistic_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/albino_baby.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MAMENCHISAURUS_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/mamenchisaurus_subadult.png");
	private static final ResourceLocation MAMENCHISAURUS_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/mamenchisaurus_subadult_sleeping.png");
	private static final ResourceLocation MELANISTIC_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/melanistic_subadult.png");
	private static final ResourceLocation MELANISTIC_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/melanistic_subadult_sleeping.png");
	private static final ResourceLocation ALBINO_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/albino_subadult.png");
	private static final ResourceLocation ALBINO_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/mamenchisaurus/albino_subadult_sleeping.png");

	private static MamenchisaurusModel MAMENCHISAURUS_MODEL;
	private static MamenchisaurusJuvenileModel JUVENILE_MAMENCHISAURUS_MODEL;
	private static MamenchisaurusBabyModel BABY_MAMENCHISAURUS_MODEL;
	private static MamenchisaurusSubadultModel SUBADULT_MAMENCHISAURUS_MODEL;


	public MamenchisaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MamenchisaurusModel(renderManagerIn.bakeLayer(ClientEvents.MAMENCHISAURUS)), 3);
		MAMENCHISAURUS_MODEL = new MamenchisaurusModel(renderManagerIn.bakeLayer(ClientEvents.MAMENCHISAURUS));
		SUBADULT_MAMENCHISAURUS_MODEL = new MamenchisaurusSubadultModel(renderManagerIn.bakeLayer(ClientEvents.MAMENCHISAURUS_SUBADULT));
		JUVENILE_MAMENCHISAURUS_MODEL = new MamenchisaurusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.MAMENCHISAURUS_JUVENILE));
		BABY_MAMENCHISAURUS_MODEL = new MamenchisaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.MAMENCHISAURUS_BABY));
	}

	protected void scale(Mamenchisaurus mamenchisaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(mamenchisaurus.isBaby()) {
			if (!mamenchisaurus.isJuvenile() && !mamenchisaurus.isSubadult()) {
				model = BABY_MAMENCHISAURUS_MODEL;
			} else if (mamenchisaurus.isJuvenile()) {
				model = JUVENILE_MAMENCHISAURUS_MODEL;
			} else {
				model = SUBADULT_MAMENCHISAURUS_MODEL;
			}
		} else {
			model = MAMENCHISAURUS_MODEL;
		}
	}

	@Override
	public ResourceLocation getTextureLocation(Mamenchisaurus entity) {
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
					return MAMENCHISAURUS_BABY_SLEEPING;
				} else return MAMENCHISAURUS_BABY;
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
					return MAMENCHISAURUS_JUVENILE_SLEEPING;
				} else return MAMENCHISAURUS_JUVENILE;
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
					return MAMENCHISAURUS_SUBADULT_SLEEPING;
				} else return MAMENCHISAURUS_SUBADULT;
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
					return MAMENCHISAURUS_SLEEPING;
				} else return MAMENCHISAURUS;
			}
		}
	}
}
