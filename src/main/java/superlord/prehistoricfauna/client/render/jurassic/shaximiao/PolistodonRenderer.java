package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.PolistodonModel;
import superlord.prehistoricfauna.client.render.layer.PolistodonEyeLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Polistodon;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class PolistodonRenderer extends MobRenderer<Polistodon, PolistodonModel> {
	private static final ResourceLocation POLISTODON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/polistodon/polistodon.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/polistodon/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/polistodon/melanistic.png");
	private static final ResourceLocation POLISTODON_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/polistodon/polistodon_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/polistodon/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/polistodon/melanistic_sleeping.png");

	public PolistodonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PolistodonModel(renderManagerIn.bakeLayer(ClientEvents.POLISTODON)), 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new PolistodonEyeLayer(this));
		}
	}

	protected void scale(Polistodon polistodon, PoseStack matrixStackIn, float partialTickTime) {
		if(polistodon.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(polistodon, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Polistodon entity) {
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
				return POLISTODON_SLEEPING;
			} else return POLISTODON;
		}
	}
}
