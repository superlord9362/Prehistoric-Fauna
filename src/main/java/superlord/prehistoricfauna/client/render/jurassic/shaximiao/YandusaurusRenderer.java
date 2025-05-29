package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.YandusaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Yandusaurus;

public class YandusaurusRenderer extends MobRenderer<Yandusaurus, YandusaurusModel> {
	private static final ResourceLocation YANDUSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yandusaurus/yandusaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yandusaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yandusaurus/melanistic.png");
	private static final ResourceLocation YANDUSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yandusaurus/yandusaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yandusaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yandusaurus/melanistic_sleeping.png");

	public YandusaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new YandusaurusModel(renderManagerIn.bakeLayer(ClientEvents.YANDUSAURUS)), 0.625F);
	}

	protected void scale(Yandusaurus yandusaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(yandusaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(yandusaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Yandusaurus entity) {
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
				return YANDUSAURUS_SLEEPING;
			} else return YANDUSAURUS;
		}
	}
}
