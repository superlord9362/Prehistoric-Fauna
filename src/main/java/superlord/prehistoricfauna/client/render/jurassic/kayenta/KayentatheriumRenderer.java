package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.KayentatheriumModel;
import superlord.prehistoricfauna.client.render.layer.KayentatheriumEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentatherium;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class KayentatheriumRenderer extends MobRenderer<Kayentatherium, KayentatheriumModel> {
	private static final ResourceLocation KAYENTATHERIUM = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/kayentatherium.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/melanistic.png");
	private static final ResourceLocation KAYENTATHERIUM_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/kayentatherium_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/melanistic_sleeping.png");

	public KayentatheriumRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new KayentatheriumModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTATHERIUM)), 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new KayentatheriumEyeLayer(this));
		}
	}

	protected void scale(Kayentatherium thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Kayentatherium entity) {
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
				return KAYENTATHERIUM_SLEEPING;
			} else return KAYENTATHERIUM;
		}
	}
}
