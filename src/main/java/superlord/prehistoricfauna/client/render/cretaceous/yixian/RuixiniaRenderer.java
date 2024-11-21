package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.RuixiniaModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Ruixinia;

public class RuixiniaRenderer extends MobRenderer<Ruixinia, RuixiniaModel> {
	private static final ResourceLocation RUIXINIA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/ruixinia.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/melanistic.png");
	private static final ResourceLocation RUIXINIA_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/ruixinia_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/melanistic_sleeping.png");

	public RuixiniaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new RuixiniaModel(renderManagerIn.bakeLayer(ClientEvents.RUIXINIA)), 1.5F);
	}

	protected void scale(Ruixinia ruixinia, PoseStack matrixStackIn, float partialTickTime) {
		if(ruixinia.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(ruixinia, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Ruixinia entity) {
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
				return RUIXINIA_SLEEPING;
			} else return RUIXINIA;
		}
	}
}