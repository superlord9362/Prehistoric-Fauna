package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.KayentavenatorModel;
import superlord.prehistoricfauna.client.render.layer.KayentavenatorEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentavenator;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class KayentavenatorRenderer extends MobRenderer<Kayentavenator, KayentavenatorModel> {
	private static final ResourceLocation KAYENTAVENATOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentavenator/kayentavenator.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentavenator/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentavenator/melanistic.png");
	private static final ResourceLocation KAYENTAVENATOR_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentavenator/kayentavenator_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentavenator/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentavenator/melanistic_sleeping.png");

	public KayentavenatorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new KayentavenatorModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR)), 0.6875F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new KayentavenatorEyeLayer(this));
		}
	}

	protected void scale(Kayentavenator thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Kayentavenator entity) {
		if(entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return KAYENTAVENATOR_SLEEPING;
			} else return KAYENTAVENATOR;
		}
	}
}
