package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.BashanosaurusModel;
import superlord.prehistoricfauna.client.render.layer.BashanosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Bashanosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class BashanosaurusRenderer extends MobRenderer<Bashanosaurus, BashanosaurusModel> {
	private static final ResourceLocation BASHANOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bashanosaurus/bashanosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bashanosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bashanosaurus/melanistic.png");
	private static final ResourceLocation BASHANOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bashanosaurus/bashanosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bashanosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bashanosaurus/melanistic_sleeping.png");

	public BashanosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BashanosaurusModel(renderManagerIn.bakeLayer(ClientEvents.BASHANOSAURUS)), 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new BashanosaurusEyeLayer(this));
		}
	}

	protected void scale(Bashanosaurus bashanosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(bashanosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(bashanosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Bashanosaurus entity) {
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
				return BASHANOSAURUS_SLEEPING;
			} else return BASHANOSAURUS;
		}
	}
}
