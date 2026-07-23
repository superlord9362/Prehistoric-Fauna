package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.ZhenyuanlongModel;
import superlord.prehistoricfauna.client.render.layer.ZhenyuanlongEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Zhenyuanlong;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ZhenyuanlongRenderer extends MobRenderer<Zhenyuanlong, ZhenyuanlongModel> {
	private static final ResourceLocation ZHENYUANLONG = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/zhenyuanlong/zhenyuanlong.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/zhenyuanlong/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/zhenyuanlong/melanistic.png");
	private static final ResourceLocation ZHENYUANLONG_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/zhenyuanlong/zhenyuanlong_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/zhenyuanlong/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/zhenyuanlong/melanistic_sleeping.png");

	public ZhenyuanlongRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ZhenyuanlongModel(renderManagerIn.bakeLayer(ClientEvents.ZHENYUANLONG)), 0.375F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ZhenyuanlongEyeLayer(this));
		}
	}

	protected void scale(Zhenyuanlong zhenyuanlong, PoseStack matrixStackIn, float partialTickTime) {
		if(zhenyuanlong.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(zhenyuanlong, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Zhenyuanlong entity) {
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
				return ZHENYUANLONG_SLEEPING;
			} else return ZHENYUANLONG;
		}
	}
}