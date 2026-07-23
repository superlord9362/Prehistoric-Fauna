package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.ChuandongocoelurusModel;
import superlord.prehistoricfauna.client.render.layer.ChuandongocoelurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Chuandongocoelurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ChuandongocoelurusRenderer extends MobRenderer<Chuandongocoelurus, ChuandongocoelurusModel> {
	private static final ResourceLocation CHUANDONGOCOELURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/chuandongocoelurus/chuandongocoelurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/chuandongocoelurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/chuandongocoelurus/melanistic.png");
	private static final ResourceLocation CHUANDONGOCOELURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/chuandongocoelurus/chuandongocoelurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/chuandongocoelurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/chuandongocoelurus/melanistic_sleeping.png");

	public ChuandongocoelurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ChuandongocoelurusModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ChuandongocoelurusEyeLayer(this));
		}
	}

	protected void scale(Chuandongocoelurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Chuandongocoelurus entity) {
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
				return CHUANDONGOCOELURUS_SLEEPING;
			} else return CHUANDONGOCOELURUS;
		}
	}
}
