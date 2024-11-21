package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ByronosaurusModel;
import superlord.prehistoricfauna.client.render.layer.ByronosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Byronosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ByronosaurusRenderer extends MobRenderer<Byronosaurus, ByronosaurusModel> {
	private static final ResourceLocation BYRONOSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/byronosaurus/byronosaurus.png");
	private static final ResourceLocation BYRONOSAURUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/byronosaurus/byronosaurus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/byronosaurus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/byronosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/byronosaurus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/byronosaurus/melanistic_sleeping.png");

	public ByronosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ByronosaurusModel(renderManagerIn.bakeLayer(ClientEvents.BYRONOSAURUS)), 0.375F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ByronosaurusEyeLayer(this));
		}
	}

	protected void scale(Byronosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Byronosaurus entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if(entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return BYRONOSAURUS_TEXTURE_SLEEPING;
			} else {
				return BYRONOSAURUS_TEXTURE;
			}
		}
	}
}