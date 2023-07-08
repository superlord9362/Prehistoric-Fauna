package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.EilenodonModel;
import superlord.prehistoricfauna.client.render.layer.EilenodonEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eilenodon;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class EilenodonRenderer extends MobRenderer<Eilenodon, EilenodonModel> {
	private static final ResourceLocation EILENODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/eilenodon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/melanistic.png");
	private static final ResourceLocation EILENODON_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/eilenodon_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/melanistic_sleeping.png");

	public EilenodonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new EilenodonModel(renderManagerIn.bakeLayer(ClientEvents.EILENODON)), 0.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new EilenodonEyeLayer(this));
		}
	}

	protected void scale(Eilenodon thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Eilenodon entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return EILENODON_SLEEPING_TEXTURE;
			} else {
				return EILENODON;
			}
		}
    }
}
