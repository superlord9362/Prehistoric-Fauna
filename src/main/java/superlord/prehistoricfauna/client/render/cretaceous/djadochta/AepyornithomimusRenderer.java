package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.AepyornithomimusModel;
import superlord.prehistoricfauna.client.render.layer.AepyornithomimusEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Aepyornithomimus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class AepyornithomimusRenderer extends MobRenderer<Aepyornithomimus, AepyornithomimusModel> {
	private static final ResourceLocation AEPYORNITHOMIMUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/aepyornithomimus.png");
	private static final ResourceLocation AEPYORNITHOMIMUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/aepyornithomimus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/melanistic_sleeping.png");

	public AepyornithomimusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AepyornithomimusModel(renderManagerIn.bakeLayer(ClientEvents.AEPYORNITHOMIMUS)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new AepyornithomimusEyeLayer(this));
		}
	}

	protected void scale(Aepyornithomimus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Aepyornithomimus entity) {
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
				return AEPYORNITHOMIMUS_TEXTURE_SLEEPING;
			} else {
				return AEPYORNITHOMIMUS_TEXTURE;
			}
		}
	}
}
