package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.CalsoyasuchusModel;
import superlord.prehistoricfauna.client.render.layer.CalsoyasuchusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Calsoyasuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CalsoyasuchusRenderer extends MobRenderer<Calsoyasuchus, CalsoyasuchusModel> {
	private static final ResourceLocation CALSOYASUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/calsoyasuchus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/melanistic.png");
	private static final ResourceLocation CALSOYASUCHUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/calsoyasuchus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/melanistic_sleeping.png");

	public CalsoyasuchusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CalsoyasuchusModel(renderManagerIn.bakeLayer(ClientEvents.CALSOYASUCHUS)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new CalsoyasuchusEyeLayer(this));
		}
	}

	protected void scale(Calsoyasuchus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Calsoyasuchus entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if(entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return CALSOYASUCHUS_SLEEPING;
			} else {
				return CALSOYASUCHUS;
			}
		}
	}
}
