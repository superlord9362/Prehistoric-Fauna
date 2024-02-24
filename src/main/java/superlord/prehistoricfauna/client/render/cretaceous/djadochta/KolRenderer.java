package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.KolModel;
import superlord.prehistoricfauna.client.render.layer.KolEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Kol;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class KolRenderer extends MobRenderer<Kol, KolModel> {
	private static final ResourceLocation KOL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kol/kol.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kol/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kol/melanistic.png");
	private static final ResourceLocation KOL_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kol/kol_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kol/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kol/melanistic_sleeping.png");

	public KolRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new KolModel(renderManagerIn.bakeLayer(ClientEvents.KOL)), 0.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new KolEyeLayer(this));
		}
	}

	protected void scale(Kol kol, PoseStack matrixStackIn, float partialTickTime) {
		if(kol.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(kol, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Kol entity) {
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
				return KOL_SLEEPING;
			} else return KOL;
		}
	}
}
