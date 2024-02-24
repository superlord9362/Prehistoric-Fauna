package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.YutyrannusModel;
import superlord.prehistoricfauna.client.render.layer.YutyrannusEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Yutyrannus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class YutyrannusRenderer extends MobRenderer<Yutyrannus, YutyrannusModel> {
	private static final ResourceLocation YUTYRANNUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/yutyrannus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/melanistic.png");
	private static final ResourceLocation YUTYRANNUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/yutyrannus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/melanistic_sleeping.png");

	public YutyrannusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new YutyrannusModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS)), 0.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new YutyrannusEyeLayer(this));
		}
	}

	protected void scale(Yutyrannus yutyrannus, PoseStack matrixStackIn, float partialTickTime) {
		if(yutyrannus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(yutyrannus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Yutyrannus entity) {
		if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return YUTYRANNUS_SLEEPING;
			} else return YUTYRANNUS;
		}
	}
}
