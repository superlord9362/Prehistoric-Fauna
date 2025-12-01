package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.HuayangosaurusModel;
import superlord.prehistoricfauna.client.render.layer.HuayangosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Huayangosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class HuayangosaurusRenderer extends MobRenderer<Huayangosaurus, HuayangosaurusModel> {
	private static final ResourceLocation HUAYANGOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/huayangosaurus/huayangosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/huayangosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/huayangosaurus/melanistic.png");
	private static final ResourceLocation HUAYANGOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/huayangosaurus/huayangosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/huayangosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/huayangosaurus/melanistic_sleeping.png");

	public HuayangosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new HuayangosaurusModel(renderManagerIn.bakeLayer(ClientEvents.HUAYANGOSAURUS)), 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new HuayangosaurusEyeLayer(this));
		}
	}

	protected void scale(Huayangosaurus huayangosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(huayangosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(huayangosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Huayangosaurus entity) {
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
				return HUAYANGOSAURUS_SLEEPING;
			} else return HUAYANGOSAURUS;
		}
	}
}
