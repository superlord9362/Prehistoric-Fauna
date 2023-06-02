package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ExaeretodonModel;
import superlord.prehistoricfauna.client.render.layer.ExaeretodonEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ExaeretodonRenderer extends MobRenderer<Exaeretodon, ExaeretodonModel> {
	private static final ResourceLocation EXAERETODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/exaeretodon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/melanistic.png");
	private static final ResourceLocation EXAERETODON_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/exaeretodon_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/melanistic_sleeping.png");

	public ExaeretodonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ExaeretodonModel(renderManagerIn.bakeLayer(ClientEvents.EXAERETODON)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ExaeretodonEyeLayer(this));
		}
	}

	protected void scale(Exaeretodon thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Exaeretodon entity) {
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
				return EXAERETODON_SLEEPING;
			} else return EXAERETODON;
		}
	}
}
