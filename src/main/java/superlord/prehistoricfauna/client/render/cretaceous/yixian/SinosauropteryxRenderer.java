package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.SinosauropteryxModel;
import superlord.prehistoricfauna.client.render.layer.SinosauropteryxEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Sinosauropteryx;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class SinosauropteryxRenderer extends MobRenderer<Sinosauropteryx, SinosauropteryxModel> {
	private static final ResourceLocation SINOSAUROPTERYX = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinosauropteryx/sinosauropteryx.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinosauropteryx/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinosauropteryx/melanistic.png");
	private static final ResourceLocation SINOSAUROPTERYX_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinosauropteryx/sinosauropteryx_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinosauropteryx/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinosauropteryx/melanistic_sleeping.png");

	public SinosauropteryxRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SinosauropteryxModel(renderManagerIn.bakeLayer(ClientEvents.SINOSAUROPTERYX)), 0.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new SinosauropteryxEyeLayer(this));
		}
	}

	protected void scale(Sinosauropteryx sinosauropteryx, PoseStack matrixStackIn, float partialTickTime) {
		if(sinosauropteryx.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(sinosauropteryx, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Sinosauropteryx entity) {
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
				return SINOSAUROPTERYX_SLEEPING;
			} else return SINOSAUROPTERYX;
		}
	}
}
