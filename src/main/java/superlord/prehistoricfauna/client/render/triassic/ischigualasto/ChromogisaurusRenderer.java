package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ChromogisaurusModel;
import superlord.prehistoricfauna.client.render.layer.ChromogisaurusEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Chromogisaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class ChromogisaurusRenderer extends MobRenderer<Chromogisaurus, ChromogisaurusModel> {
	private static final ResourceLocation CHROMOGISAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/chromogisaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/melanistic.png");
	private static final ResourceLocation CHROMOGISAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/chromogisaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/melanistic_sleeping.png");

	public ChromogisaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ChromogisaurusModel(renderManagerIn.bakeLayer(ClientEvents.CHROMOGISAURUS)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new ChromogisaurusEyeLayer(this));
		}
	}

	protected void scale(Chromogisaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Chromogisaurus entity) {
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
				return CHROMOGISAURUS_SLEEPING;
			} else return CHROMOGISAURUS;
		}
	}
}
