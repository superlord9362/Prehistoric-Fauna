package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.HyperodapedonModel;
import superlord.prehistoricfauna.client.render.layer.HyperodapedonEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Hyperodapedon;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class HyperodapedonRenderer extends MobRenderer<Hyperodapedon, HyperodapedonModel> {
	private static final ResourceLocation HYPERODAPEDON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/hyperodapedon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/melanistic.png");
	private static final ResourceLocation HYPERODAPEDON_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/hyperodapedon_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/melanistic_sleeping.png");

	public HyperodapedonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new HyperodapedonModel(renderManagerIn.bakeLayer(ClientEvents.HYPERODAPEDON)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new HyperodapedonEyeLayer(this));
		}
	}

	protected void scale(Hyperodapedon thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Hyperodapedon entity) {
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
				return HYPERODAPEDON_SLEEPING;
			} else return HYPERODAPEDON;
		}
	}
}
