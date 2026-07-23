package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.SuuwasseaBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.SuuwasseaModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Suuwassea;

public class SuuwasseaRenderer extends MobRenderer<Suuwassea, EntityModel<Suuwassea>> {
	private static final ResourceLocation SUUWASSEA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/suuwassea.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/melanistic.png");
	private static final ResourceLocation SUUWASSEA_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/suuwassea_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/melanistic_sleeping.png");
	private static final ResourceLocation SUUWASSEA_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/suuwassea_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/melanistic_baby.png");
	private static final ResourceLocation SUUWASSEA_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/suuwassea_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/suuwassea/melanistic_baby_sleeping.png");

	private static SuuwasseaModel SUUWASSEA_MODEL;
	private static SuuwasseaBabyModel SUUWASSEA_BABY_MODEL;

	public SuuwasseaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SuuwasseaModel(renderManagerIn.bakeLayer(ClientEvents.SUUWASSEA)), 1.25F);
		SUUWASSEA_MODEL = new SuuwasseaModel(renderManagerIn.bakeLayer(ClientEvents.SUUWASSEA));
		SUUWASSEA_BABY_MODEL = new SuuwasseaBabyModel(renderManagerIn.bakeLayer(ClientEvents.SUUWASSEA_BABY));
	}

	protected void scale(Suuwassea suuwassea, PoseStack matrixStackIn, float partialTickTime) {
		if(suuwassea.isBaby()) {
			model = SUUWASSEA_BABY_MODEL;				
		} else {
			model = SUUWASSEA_MODEL;
		}
		super.scale(suuwassea, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Suuwassea entity) {
		if (entity.isBaby()) {

			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else {
					return ALBINO_BABY;
				}
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else {
					return MELANISTIC_BABY;
				}
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return SUUWASSEA_BABY_SLEEPING;
				} else {
					return SUUWASSEA_BABY;
				}
			}
		} else {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else {
					return ALBINO;
				}
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else {
					return MELANISTIC;
				}
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return SUUWASSEA_SLEEPING;
				} else {
					return SUUWASSEA;
				}
			}
		}
	}
}
