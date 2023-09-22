package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.StegosaurusModel;
import superlord.prehistoricfauna.client.render.layer.StegosaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class StegosaurusRenderer extends MobRenderer<Stegosaurus, StegosaurusModel> {
	private static final ResourceLocation STEGOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/stegosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/melanistic.png");
	private static final ResourceLocation STEGOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/stegosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/melanistic_sleeping.png");
	private static final ResourceLocation ZOO_TYCOON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/stegosaurus_ztc.png");
	private static final ResourceLocation ZOO_TYCOON_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/stegosaurus_ztc_sleeping.png");

	public StegosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new StegosaurusModel(renderManagerIn.bakeLayer(ClientEvents.STEGOSAURUS)), 1.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new StegosaurusEyeLayer(this));
		}
	}

	protected void scale(Stegosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Stegosaurus entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if ( s != null && ("Zoo Tycoon".equals(s) || "Zoo tycoon".equals(s) || "zoo tycoon".equals(s))) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ZOO_TYCOON_SLEEPING;
			} else return ZOO_TYCOON;
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
				return STEGOSAURUS_SLEEPING;
			} else {
				return STEGOSAURUS;
			}
		}
    }
}
