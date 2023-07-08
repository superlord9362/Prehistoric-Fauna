package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.chinle.PoposaurusModel;
import superlord.prehistoricfauna.client.render.layer.PoposaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class PoposaurusRenderer extends MobRenderer<Poposaurus, PoposaurusModel> {
	private static final ResourceLocation POPOSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/poposaurus.png");
	private static final ResourceLocation POPOSAURUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/poposaurus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/melanistic_sleeping.png");

	public PoposaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PoposaurusModel(renderManagerIn.bakeLayer(ClientEvents.POPOSAURUS)), 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new PoposaurusEyeLayer(this));
		}
	}

	protected void scale(Poposaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Poposaurus entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if(entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return POPOSAURUS_TEXTURE_SLEEPING;
			} else {
				return POPOSAURUS_TEXTURE;
			}
		}
	}
}
