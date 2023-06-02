package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScelidosaurusModel;
import superlord.prehistoricfauna.client.render.layer.ScelidosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scelidosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ScelidosaurusRenderer extends MobRenderer<Scelidosaurus, ScelidosaurusModel> {
	private static final ResourceLocation SCELIDOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/scelidosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/melanistic.png");
	private static final ResourceLocation SCELIDOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/scelidosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/melanistic_sleeping.png");

	public ScelidosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ScelidosaurusModel(renderManagerIn.bakeLayer(ClientEvents.SCELIDOSAURUS)), 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ScelidosaurusEyeLayer(this));
		}
	}

	protected void scale(Scelidosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Scelidosaurus entity) {
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
				return SCELIDOSAURUS_SLEEPING;
			} else return SCELIDOSAURUS;
		}
	}
}
