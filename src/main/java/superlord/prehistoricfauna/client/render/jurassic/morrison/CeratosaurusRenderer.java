package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusModel;
import superlord.prehistoricfauna.client.render.layer.CeratosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CeratosaurusRenderer extends MobRenderer<Ceratosaurus, CeratosaurusModel> {
	private static final ResourceLocation CERATOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic.png");
	private static final ResourceLocation CERATOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/melanistic_sleeping.png");

	public CeratosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CeratosaurusModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS)), 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new CeratosaurusEyeLayer(this));
		}
	}

	protected void scale(Ceratosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Ceratosaurus entity) {
		if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return CERATOSAURUS_SLEEPING;
			} else return CERATOSAURUS;
		}
	}
}
