package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.TanycolagreusModel;
import superlord.prehistoricfauna.client.render.layer.TanycolagreusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Tanycolagreus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class TanycolagreusRenderer extends MobRenderer<Tanycolagreus, TanycolagreusModel> {
	private static final ResourceLocation TANYCOLAGREUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tanycolagreus/tanycolagreus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tanycolagreus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tanycolagreus/melanistic.png");
	private static final ResourceLocation TANYCOLAGREUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tanycolagreus/tanycolagreus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tanycolagreus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tanycolagreus/melanistic_sleeping.png");

	public TanycolagreusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TanycolagreusModel(renderManagerIn.bakeLayer(ClientEvents.TANYCOLAGREUS)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new TanycolagreusEyeLayer(this));
		}
	}

	protected void scale(Tanycolagreus tanycolagreus, PoseStack matrixStackIn, float partialTickTime) {
		if(tanycolagreus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(tanycolagreus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Tanycolagreus entity) {
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
				return TANYCOLAGREUS_SLEEPING;
			} else return TANYCOLAGREUS;
		}
	}
}
