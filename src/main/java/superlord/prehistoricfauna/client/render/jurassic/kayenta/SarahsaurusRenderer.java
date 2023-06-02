package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.SarahsaurusModel;
import superlord.prehistoricfauna.client.render.layer.SarahsaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class SarahsaurusRenderer extends MobRenderer<Sarahsaurus, SarahsaurusModel> {
	private static final ResourceLocation SARAHSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus.png");
	private static final ResourceLocation FLINSTONES_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus_flintstones.png");
	private static final ResourceLocation FLINSTONES_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus_flintstones_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/melanistic.png");
	private static final ResourceLocation SARAHSAURUS_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/melanistic_sleeping.png");

	public SarahsaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SarahsaurusModel(renderManagerIn.bakeLayer(ClientEvents.SARAHSAURUS)), 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new SarahsaurusEyeLayer(this));
		}
	}

	protected void scale(Sarahsaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Sarahsaurus entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if ( s != null && ("Dino".equals(s) || "Flintstones".equals(s))) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return FLINSTONES_SLEEPING_TEXTURE;
			} else {
				return FLINSTONES_TEXTURE;
			}
		} else if (entity.isAlbino()) {
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
				return SARAHSAURUS_SLEEPING_TEXTURE;
			} else {
				return SARAHSAURUS_TEXTURE;
			}
		}
	}
}
