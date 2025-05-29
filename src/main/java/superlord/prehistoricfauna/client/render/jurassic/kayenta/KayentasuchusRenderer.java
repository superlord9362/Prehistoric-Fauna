package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.KayentasuchusModel;
import superlord.prehistoricfauna.client.render.layer.KayentasuchusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentasuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class KayentasuchusRenderer extends MobRenderer<Kayentasuchus, KayentasuchusModel> {
	private static final ResourceLocation KAYENTASUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentasuchus/kayentasuchus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentasuchus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentasuchus/melanistic.png");
	private static final ResourceLocation KAYENTASUCHUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentasuchus/kayentasuchus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentasuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentasuchus/melanistic_sleeping.png");

	public KayentasuchusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new KayentasuchusModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTASUCHUS)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new KayentasuchusEyeLayer(this));
		}
	}

	protected void scale(Kayentasuchus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Kayentasuchus entity) {
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
				return KAYENTASUCHUS_SLEEPING;
			} else return KAYENTASUCHUS;
		}
	}
}
