package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.AnzuModel;
import superlord.prehistoricfauna.client.render.layer.AnzuEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Anzu;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class AnzuRenderer extends MobRenderer<Anzu, EntityModel<Anzu>> {
	private static final ResourceLocation ANZU = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/anzu/anzu.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/anzu/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/anzu/melanistic.png");
	private static final ResourceLocation ANZU_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/anzu/anzu_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/anzu/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/anzu/melanistic_sleeping.png");

	public AnzuRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AnzuModel(renderManagerIn.bakeLayer(ClientEvents.ANZU)), 0.75F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new AnzuEyeLayer(this));
		}
	}

	protected void scale(Anzu thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Anzu entity) {
		if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
			if (entity.isAlbino()) {
				return ALBINO_SLEEPING;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_SLEEPING;
			} else {
				return ANZU_SLEEPING;
			}
		} else {
			if (entity.isAlbino()) {
				return ALBINO;
			} else if (entity.isMelanistic()) {
				return MELANISTIC;
			} else {
				return ANZU;
			}
		}
	}
}
