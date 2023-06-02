package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScutellosaurusModel;
import superlord.prehistoricfauna.client.render.layer.ScutellosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scutellosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ScutellosaurusRenderer extends MobRenderer<Scutellosaurus, ScutellosaurusModel> {
	private static final ResourceLocation SCUTELLOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/scutellosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/melanistic.png");
	private static final ResourceLocation SCUTELLOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/scutellosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/melanistic_sleeping.png");

	public ScutellosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ScutellosaurusModel(renderManagerIn.bakeLayer(ClientEvents.SCUTELLOSAURUS)), 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ScutellosaurusEyeLayer(this));
		}
	}

	protected void scale(Scutellosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Scutellosaurus entity) {
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
				return SCUTELLOSAURUS_SLEEPING;
			} else return SCUTELLOSAURUS;
		}
	}
}
