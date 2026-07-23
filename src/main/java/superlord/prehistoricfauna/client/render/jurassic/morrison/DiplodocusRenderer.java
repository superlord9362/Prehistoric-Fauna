package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.DiplodocusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.DiplodocusJuvenileModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.DiplodocusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.DiplodocusSubadultModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Diplodocus;

public class DiplodocusRenderer extends MobRenderer<Diplodocus, EntityModel<Diplodocus>> {
	private static final ResourceLocation DIPLODOCUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/diplodocus.png");
	private static final ResourceLocation DIPLODOCUS_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/diplodocus_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/melanistic_juvenile.png");
	private static final ResourceLocation DIPLODOCUS_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/diplodocus_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/melanistic_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/melanistic.png");
	private static final ResourceLocation DIPLODOCUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/diplodocus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/melanistic_sleeping.png");
	private static final ResourceLocation DIPLODOCUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/diplodocus_baby.png");
	private static final ResourceLocation DIPLODOCUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/diplodocus_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/melanistic_baby.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/melanistic_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/albino_baby.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/albino_baby_sleeping.png");
	private static final ResourceLocation DIPLODOCUS_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/diplodocus_subadult.png");
	private static final ResourceLocation DIPLODOCUS_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/diplodocus_subadult_sleeping.png");
	private static final ResourceLocation MELANISTIC_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/melanistic_subadult.png");
	private static final ResourceLocation MELANISTIC_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/melanistic_subadult_sleeping.png");
	private static final ResourceLocation ALBINO_SUBADULT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/albino_subadult.png");
	private static final ResourceLocation ALBINO_SUBADULT_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diplodocus/albino_subadult_sleeping.png");

	private static DiplodocusModel DIPLODOCUS_MODEL;
	private static DiplodocusJuvenileModel JUVENILE_DIPLODOCUS_MODEL;
	private static DiplodocusBabyModel BABY_DIPLODOCUS_MODEL;
	private static DiplodocusSubadultModel SUBADULT_DIPLODOCUS_MODEL;


	public DiplodocusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DiplodocusModel(renderManagerIn.bakeLayer(ClientEvents.DIPLODOCUS)), 3);
		DIPLODOCUS_MODEL = new DiplodocusModel(renderManagerIn.bakeLayer(ClientEvents.DIPLODOCUS));
		JUVENILE_DIPLODOCUS_MODEL = new DiplodocusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.DIPLODOCUS_JUVENILE));
		BABY_DIPLODOCUS_MODEL = new DiplodocusBabyModel(renderManagerIn.bakeLayer(ClientEvents.DIPLODOCUS_BABY));
		SUBADULT_DIPLODOCUS_MODEL = new DiplodocusSubadultModel(renderManagerIn.bakeLayer(ClientEvents.DIPLODOCUS_SUBADULT));
	}

	protected void scale(Diplodocus diplodocus, PoseStack matrixStackIn, float partialTickTime) {
		if(diplodocus.isBaby()) {
			if (!diplodocus.isJuvenile() && !diplodocus.isSubadult()) {
				model = BABY_DIPLODOCUS_MODEL;
			} else if (diplodocus.isJuvenile()) {
				model = JUVENILE_DIPLODOCUS_MODEL;
			} else {
				model = SUBADULT_DIPLODOCUS_MODEL;
			}
		} else {
			model = DIPLODOCUS_MODEL;
		}
	}

	@Override
	public ResourceLocation getTextureLocation(Diplodocus entity) {
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
					return DIPLODOCUS_BABY_SLEEPING;
				} else return DIPLODOCUS_BABY;
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
					return DIPLODOCUS_JUVENILE_SLEEPING;
				} else return DIPLODOCUS_JUVENILE;
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
					return DIPLODOCUS_SUBADULT_SLEEPING;
				} else return DIPLODOCUS_SUBADULT;
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
					return DIPLODOCUS_SLEEPING;
				} else return DIPLODOCUS;
			}
		}
	}
}
