package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.AbrosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.AbrosaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.AbrosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Abrosaurus;

public class AbrosaurusRenderer extends MobRenderer<Abrosaurus, EntityModel<Abrosaurus>> {
	private static final ResourceLocation ABROSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/abrosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/melanistic.png");
	private static final ResourceLocation ABROSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/abrosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/melanistic_sleeping.png");
	private static final ResourceLocation ABROSAURUS_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/abrosaurus_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/melanistic_juvenile.png");
	private static final ResourceLocation ABROSAURUS_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/abrosaurus_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/melanistic_juvenile_sleeping.png");
	private static final ResourceLocation ABROSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/abrosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/melanistic_baby.png");
	private static final ResourceLocation ABROSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/abrosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/abrosaurus/melanistic_baby_sleeping.png");

	private static AbrosaurusModel ABROSAURUS_MODEL;
	private static AbrosaurusJuvenileModel ABROSAURUS_JUVENILE_MODEL;
	private static AbrosaurusBabyModel ABROSAURUS_BABY_MODEL;

	public AbrosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AbrosaurusModel(renderManagerIn.bakeLayer(ClientEvents.ABROSAURUS)), 1.625F);
		ABROSAURUS_MODEL = new AbrosaurusModel(renderManagerIn.bakeLayer(ClientEvents.ABROSAURUS));
		ABROSAURUS_JUVENILE_MODEL = new AbrosaurusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.ABROSAURUS_JUVENILE));
		ABROSAURUS_BABY_MODEL = new AbrosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.ABROSAURUS_BABY));
	}

	protected void scale(Abrosaurus abrosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(abrosaurus.isBaby()) {
			if (abrosaurus.isJuvenile()) {
				model = ABROSAURUS_JUVENILE_MODEL;
			} else model = ABROSAURUS_BABY_MODEL;
		} else model = ABROSAURUS_MODEL;
		super.scale(abrosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Abrosaurus entity) {
		if (entity.isBaby()) {
			if (entity.isJuvenile()) {
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
						return ABROSAURUS_JUVENILE_SLEEPING;
					} else return ABROSAURUS_JUVENILE;
				}
			} else {
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
						return ABROSAURUS_BABY_SLEEPING;
					} else return ABROSAURUS_BABY;
				}	
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
					return ABROSAURUS_SLEEPING;
				} else return ABROSAURUS;
			}
		}
	}
}
