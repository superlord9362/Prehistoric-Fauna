package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.RepenomamusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Repenomamus;

public class RepenomamusRenderer extends MobRenderer<Repenomamus, RepenomamusModel> {
	private static final ResourceLocation REPENOMAMUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/repenomamus/repenomamus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/repenomamus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/repenomamus/melanistic.png");
	private static final ResourceLocation REPENOMAMUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/repenomamus/repenomamus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/repenomamus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/repenomamus/melanistic_sleeping.png");

	public RepenomamusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new RepenomamusModel(renderManagerIn.bakeLayer(ClientEvents.REPENOMAMUS)), 0.3125F);
	}

	protected void scale(Repenomamus repenomamus, PoseStack matrixStackIn, float partialTickTime) {
		if(repenomamus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(repenomamus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Repenomamus entity) {
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
				return REPENOMAMUS_SLEEPING;
			} else return REPENOMAMUS;
		}
	}
}