package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.chinle.DesmatosuchusModel;
import superlord.prehistoricfauna.client.render.layer.DesmatosuchusEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Desmatosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DesmatosuchusRenderer extends MobRenderer<Desmatosuchus, DesmatosuchusModel> {
	private static final ResourceLocation DESMATOSUCHUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/desmatosuchus.png");
	private static final ResourceLocation DESMATOSUCHUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/desmatosuchus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/melanistic_sleeping.png");

	public DesmatosuchusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DesmatosuchusModel(renderManagerIn.bakeLayer(ClientEvents.DESMATOSUCHUS)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DesmatosuchusEyeLayer(this));
		}
	}

	protected void scale(Desmatosuchus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Desmatosuchus entity) {
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
				return DESMATOSUCHUS_TEXTURE_SLEEPING;
			} else {
				return DESMATOSUCHUS_TEXTURE;
			}
		}
	}
}
