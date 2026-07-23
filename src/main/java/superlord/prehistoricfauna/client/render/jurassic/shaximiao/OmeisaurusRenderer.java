package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.OmeisaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.OmeisaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.OmeisaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Omeisaurus;

public class OmeisaurusRenderer extends MobRenderer<Omeisaurus, EntityModel<Omeisaurus>> {
	private static final ResourceLocation OMEISAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/omeisaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/melanistic.png");
	private static final ResourceLocation OMEISAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/omeisaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/melanistic_sleeping.png");
	private static final ResourceLocation OMEISAURUS_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/omeisaurus_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/melanistic_juvenile.png");
	private static final ResourceLocation OMEISAURUS_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/omeisaurus_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/melanistic_juvenile_sleeping.png");
	private static final ResourceLocation OMEISAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/omeisaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/melanistic_baby.png");
	private static final ResourceLocation OMEISAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/omeisaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/omeisaurus/melanistic_baby_sleeping.png");

	private static OmeisaurusModel OMEISAURUS_MODEL;
	private static OmeisaurusJuvenileModel OMEISAURUS_JUVENILE_MODEL;
	private static OmeisaurusBabyModel OMEISAURUS_BABY_MODEL;

	public OmeisaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new OmeisaurusModel(renderManagerIn.bakeLayer(ClientEvents.OMEISAURUS)), 1.625F);
		OMEISAURUS_MODEL = new OmeisaurusModel(renderManagerIn.bakeLayer(ClientEvents.OMEISAURUS));
		OMEISAURUS_JUVENILE_MODEL = new OmeisaurusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.OMEISAURUS_JUVENILE));
		OMEISAURUS_BABY_MODEL = new OmeisaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.OMEISAURUS_BABY));
	}

	protected void scale(Omeisaurus omeisaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(omeisaurus.isBaby()) {
			if (!omeisaurus.isJuvenile()) {
				model = OMEISAURUS_BABY_MODEL;
			} else model = OMEISAURUS_JUVENILE_MODEL;
		} else model = OMEISAURUS_MODEL;
		super.scale(omeisaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Omeisaurus entity) {
		if (entity.isBaby()) {
			if (!entity.isJuvenile()) {
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
						return OMEISAURUS_BABY_SLEEPING;
					} else return OMEISAURUS_BABY;
				}
			} else {
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
						return OMEISAURUS_JUVENILE_SLEEPING;
					} else return OMEISAURUS_JUVENILE;
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
					return OMEISAURUS_SLEEPING;
				} else return OMEISAURUS;
			}	
		}
	}
}
