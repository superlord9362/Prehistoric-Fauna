package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.chinle.PlaceriasModel;
import superlord.prehistoricfauna.client.render.layer.PlaceriasEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Placerias;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class PlaceriasRenderer extends MobRenderer<Placerias, PlaceriasModel> {
	private static final ResourceLocation PLACERIAS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/placerias.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/melanistic.png");
	private static final ResourceLocation PLACERIAS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/placerias_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/placerias/melanistic_sleeping.png");

	public PlaceriasRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PlaceriasModel(renderManagerIn.bakeLayer(ClientEvents.PLACERIAS)), 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new PlaceriasEyeLayer(this));
		}
	}

	protected void scale(Placerias thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Placerias entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return PLACERIAS_SLEEPING;
			} else return PLACERIAS;
		}
	}
}
