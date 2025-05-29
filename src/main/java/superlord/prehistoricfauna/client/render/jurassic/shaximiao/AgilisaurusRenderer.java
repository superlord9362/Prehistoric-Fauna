package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.AgilisaurusModel;
import superlord.prehistoricfauna.client.render.layer.AgilisaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Agilisaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class AgilisaurusRenderer extends MobRenderer<Agilisaurus, AgilisaurusModel> {
	private static final ResourceLocation AGILISAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/agilisaurus/agilisaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/agilisaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/agilisaurus/melanistic.png");
	private static final ResourceLocation AGILISAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/agilisaurus/agilisaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/agilisaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/agilisaurus/melanistic_sleeping.png");

	public AgilisaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AgilisaurusModel(renderManagerIn.bakeLayer(ClientEvents.AGILISAURUS)), 0.325F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new AgilisaurusEyeLayer(this));
		}
	}

	protected void scale(Agilisaurus agilisaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(agilisaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(agilisaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Agilisaurus entity) {
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
				return AGILISAURUS_SLEEPING;
			} else return AGILISAURUS;
		}
	}
}
