package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.MacelognathusModel;
import superlord.prehistoricfauna.client.render.layer.MacelognathusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Macelognathus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class MacelognathusRenderer extends MobRenderer<Macelognathus, MacelognathusModel> {
	private static final ResourceLocation MACELOGNATHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/macelognathus/macelognathus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/macelognathus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/macelognathus/melanistic.png");
	private static final ResourceLocation MACELOGNATHUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/macelognathus/macelognathus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/macelognathus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/macelognathus/melanistic_sleeping.png");

	public MacelognathusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MacelognathusModel(renderManagerIn.bakeLayer(ClientEvents.MACELOGNATHUS)), 0.375F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new MacelognathusEyeLayer(this));
		}
	}

	protected void scale(Macelognathus macelognathus, PoseStack matrixStackIn, float partialTickTime) {
		if(macelognathus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(macelognathus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Macelognathus entity) {
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
				return MACELOGNATHUS_SLEEPING;
			} else return MACELOGNATHUS;
		}
	}
}
