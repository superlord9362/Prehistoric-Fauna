package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.MegapnosaurusModel;
import superlord.prehistoricfauna.client.render.layer.MegapnosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class MegapnosaurusRenderer extends MobRenderer<Megapnosaurus, MegapnosaurusModel> {
	private static final ResourceLocation MEGAPNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/megapnosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/melanistic.png");
	private static final ResourceLocation MEGAPNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/megapnosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/melanistic_sleeping.png");
	private static final ResourceLocation JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/melanistic_juvenile.png");
	private static final ResourceLocation JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/melanistic_juvenile_sleeping.png");

	private static final ResourceLocation MEGAPNOSAURUS_S = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/megapnosaurus_s.png");
	private static final ResourceLocation MEGAPNOSAURUS_S_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/megapnosaurus_s_sleeping.png");
	private static final ResourceLocation ALBINO_S = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/albino_s.png");
	private static final ResourceLocation ALBINO_S_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/albino_s_sleeping.png");
	private static final ResourceLocation MELANISTIC_S = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/melanistic_s.png");
	private static final ResourceLocation MELANISTIC_S_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/megapnosaurus/melanistic_s_sleeping.png");

	public MegapnosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MegapnosaurusModel(renderManagerIn.bakeLayer(ClientEvents.MEGAPNOSAURUS)), 0.625F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new MegapnosaurusEyeLayer(this));
		}
	}

	protected void scale(Megapnosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Megapnosaurus entity) {
		if (PrehistoricFaunaConfig.megapnosaurusFeathersOrScaled) {
			if  (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 60 <= 5) {
					return ALBINO_S_SLEEPING;
				} else return ALBINO_S;
			} else if  (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 60 <= 5) {
					return MELANISTIC_S_SLEEPING;
				} else return MELANISTIC_S;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 60 <= 5) {
					return MEGAPNOSAURUS_S_SLEEPING;
				} else return MEGAPNOSAURUS_S;
			}
		} else {
			if (entity.isAlbino()) {
				if (entity.isBaby()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return ALBINO_JUVENILE_SLEEPING;
					} else return ALBINO_JUVENILE;
				} else {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return ALBINO_SLEEPING;
					} else return ALBINO;
				}
			} else if (entity.isMelanistic()) {
				if (entity.isBaby()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return MELANISTIC_JUVENILE_SLEEPING;
					} else return MELANISTIC_JUVENILE;
				} else {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return MELANISTIC_SLEEPING;
					} else return MELANISTIC;
				}
			} else {
				if (entity.isBaby()) {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return JUVENILE_SLEEPING;
					} else return JUVENILE;
				} else {
					if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
						return MEGAPNOSAURUS_SLEEPING;
					} else return MEGAPNOSAURUS;
				}
			}
		}
	}
}
