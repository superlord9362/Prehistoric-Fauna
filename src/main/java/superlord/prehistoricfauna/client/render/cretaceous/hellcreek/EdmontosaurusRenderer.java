package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.EdmontosaurusBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.EdmontosaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.EdmontosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Edmontosaurus;

public class EdmontosaurusRenderer extends MobRenderer<Edmontosaurus, EntityModel<Edmontosaurus>> {
	private static final ResourceLocation EDMONTOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/edmontosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/melanistic.png");
	private static final ResourceLocation EDMONTOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/edmontosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/melanistic_sleeping.png");
	private static final ResourceLocation EDMONTOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/edmontosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/melanistic_baby.png");
	private static final ResourceLocation EDMONTOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/edmontosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/melanistic_baby_sleeping.png");
	private static final ResourceLocation EDMONTOSAURUS_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/edmontosaurus_juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/melanistic_juvenile.png");
	private static final ResourceLocation EDMONTOSAURUS_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/edmontosaurus_juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/edmontosaurus/melanistic_juvenile_sleeping.png");

	private static EdmontosaurusModel EDMONTOSAURUS_MODEL;
	private static EdmontosaurusJuvenileModel JUVENILE_MODEL;
	private static EdmontosaurusBabyModel BABY_MODEL;

	public EdmontosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new EdmontosaurusModel(renderManagerIn.bakeLayer(ClientEvents.EDMONTOSAURUS)), 2.125F);
		EDMONTOSAURUS_MODEL = new EdmontosaurusModel(renderManagerIn.bakeLayer(ClientEvents.EDMONTOSAURUS));
		JUVENILE_MODEL = new EdmontosaurusJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.EDMONTOSAURUS_JUVENILE));
		BABY_MODEL = new EdmontosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.EDMONTOSAURUS_BABY));
	}

	protected void scale(Edmontosaurus edmontosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(edmontosaurus.isBaby()) {
			if (!edmontosaurus.isJuvenile()) {
				model = BABY_MODEL;
			} else model = JUVENILE_MODEL;
		} else model = EDMONTOSAURUS_MODEL;
		super.scale(edmontosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Edmontosaurus entity) {
		if (entity.isBaby()) {
			if (entity.isJuvenile()) {
				if (entity.isMelanistic()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return MELANISTIC_JUVENILE_SLEEPING;
					} else return MELANISTIC_JUVENILE;
				} else if (entity.isAlbino()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return ALBINO_JUVENILE_SLEEPING;
					} else return ALBINO_JUVENILE;
				} else {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return EDMONTOSAURUS_JUVENILE_SLEEPING;
					} else return EDMONTOSAURUS_JUVENILE;
				}
			} else {
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
						return EDMONTOSAURUS_BABY_SLEEPING;
					} else return EDMONTOSAURUS_BABY;
				}
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
					return EDMONTOSAURUS_SLEEPING;
				} else return EDMONTOSAURUS;
			}
		}
	}
}
