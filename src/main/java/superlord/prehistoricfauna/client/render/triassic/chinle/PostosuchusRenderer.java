package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.chinle.PostosuchusModel;
import superlord.prehistoricfauna.client.render.layer.PostosuchusEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class PostosuchusRenderer extends MobRenderer<Postosuchus, PostosuchusModel> {
	private static final ResourceLocation POSTOSUCHUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/postosuchus.png");
	private static final ResourceLocation POSTOSUCHUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/postosuchus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/melanistic_sleeping.png");

	public PostosuchusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PostosuchusModel(renderManagerIn.bakeLayer(ClientEvents.POSTOSUCHUS)), 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new PostosuchusEyeLayer(this));
		}
	}

	protected void scale(Postosuchus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Postosuchus entity) {
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
				return POSTOSUCHUS_TEXTURE_SLEEPING;
			} else {
				return POSTOSUCHUS_TEXTURE;
			}
		}
	}
}
