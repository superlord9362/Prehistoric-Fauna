package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.DiablophisModel;
import superlord.prehistoricfauna.client.render.layer.DiablophisEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Diablophis;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DiablophisRenderer extends MobRenderer<Diablophis, DiablophisModel> {
	private static final ResourceLocation DIABLOPHIS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diablophis/diablophis.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diablophis/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diablophis/melanistic.png");
	private static final ResourceLocation DIABLOPHIS_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diablophis/diablophis_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diablophis/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/diablophis/melanistic_sleeping.png");

	public DiablophisRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DiablophisModel(renderManagerIn.bakeLayer(ClientEvents.DIABLOPHIS)), 0.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DiablophisEyeLayer(this));
		}
	}

	protected void scale(Diablophis thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Diablophis entity) {
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
				return DIABLOPHIS_SLEEPING_TEXTURE;
			} else {
				return DIABLOPHIS;
			}
		}
    }
}
