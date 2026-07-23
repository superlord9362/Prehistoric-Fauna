package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.DongbeititanBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.DongbeititanJuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.DongbeititanModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Dongbeititan;

public class DongbeititanRenderer extends MobRenderer<Dongbeititan, EntityModel<Dongbeititan>> {
	private static final ResourceLocation DONGBEITITAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/dongbeititan.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/melanistic.png");
	private static final ResourceLocation DONGBEITITAN_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/dongbeititan_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/melanistic_sleeping.png");

	private static final ResourceLocation DONGBEITITAN_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/dongbeititan_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/melanistic_juvenile.png");
	private static final ResourceLocation DONGBEITITAN_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/dongbeititan_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/melanistic_juvenile_sleeping.png");

	private static final ResourceLocation DONGBEITITAN_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/dongbeititan_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/melanistic_baby.png");
	private static final ResourceLocation DONGBEITITAN_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/dongbeititan_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/dongbeititan/melanistic_baby_sleeping.png");

	private static DongbeititanModel DONGBEITITAN_MODEL;
	private static DongbeititanJuvenileModel JUVENILE_MODEL;
	private static DongbeititanBabyModel BABY_MODEL;

	public DongbeititanRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DongbeititanModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN)), 2.25F);
		DONGBEITITAN_MODEL = new DongbeititanModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN));
		JUVENILE_MODEL = new DongbeititanJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_JUVENILE));
		BABY_MODEL = new DongbeititanBabyModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_BABY));
	}

	protected void scale(Dongbeititan dongbeititan, PoseStack matrixStackIn, float partialTickTime) {
		if(dongbeititan.isBaby()) {
			if (!dongbeititan.isJuvenile()) {
				model = BABY_MODEL;
			} else model = JUVENILE_MODEL;
		} else model = DONGBEITITAN_MODEL;
		super.scale(dongbeititan, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Dongbeititan entity) {
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
						return DONGBEITITAN_BABY_SLEEPING;
					} else return DONGBEITITAN_BABY;
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
						return DONGBEITITAN_JUVENILE_SLEEPING;
					} else return DONGBEITITAN_JUVENILE;
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
					return DONGBEITITAN_SLEEPING;
				} else return DONGBEITITAN;
			}
		}
	}
}