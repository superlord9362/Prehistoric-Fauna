package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.AlcovasaurusModel;
import superlord.prehistoricfauna.client.render.layer.AlcovasaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Alcovasaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class AlcovasaurusRenderer extends MobRenderer<Alcovasaurus, EntityModel<Alcovasaurus>> {
	private static final ResourceLocation ALCOVASAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/alcovasaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/melanistic.png");
	private static final ResourceLocation ALCOVASAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/alcovasaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/melanistic_sleeping.png");
//	private static final ResourceLocation ALCOVASAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/alcovasaurus_hatchling.png");
//	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/albino_hatchling.png");
//	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/melanistic_hatchling.png");
//	private static final ResourceLocation ALCOVASAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/alcovasaurus_hatchling_sleeping.png");
//	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/albino_hatchling_sleeping.png");
//	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/melanistic_hatchling_sleeping.png");

	private static AlcovasaurusModel ALCOVASAURUS_MODEL;
//	private static AlcovasaurusBabyModel ALCOVASAURUS_BABY_MODEL;

	public AlcovasaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AlcovasaurusModel(renderManagerIn.bakeLayer(ClientEvents.ALCOVASAURUS)), 1.25F);
		ALCOVASAURUS_MODEL = new AlcovasaurusModel(renderManagerIn.bakeLayer(ClientEvents.ALCOVASAURUS));
//		ALCOVASAURUS_BABY_MODEL = new AlcovasaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.ALCOVASAURUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
//			this.addLayer(new AlcovasaurusBabyEyeLayer(this));
			this.addLayer(new AlcovasaurusEyeLayer(this));
		}
	}

	protected void scale(Alcovasaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
//			model = ALCOVASAURUS_BABY_MODEL;
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		} else {
			model = ALCOVASAURUS_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Alcovasaurus entity) {
//		if (!entity.isBaby()) {
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
					return ALCOVASAURUS_SLEEPING;
				} else {
					return ALCOVASAURUS;
				}
			}
//		} else {
//			if (entity.isAlbino()) {
//				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
//					return ALBINO_BABY_SLEEPING;
//				} else {
//					return ALBINO_BABY;
//				}
//			} else if (entity.isMelanistic()) {
//				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
//					return MELANISTIC_BABY_SLEEPING;
//				} else {
//					return MELANISTIC_BABY;
//				}
//			} else {
//				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
//					return ALCOVASAURUS_BABY_SLEEPING;
//				} else {
//					return ALCOVASAURUS_BABY;
//				}
//			}
//		}
	}
}
