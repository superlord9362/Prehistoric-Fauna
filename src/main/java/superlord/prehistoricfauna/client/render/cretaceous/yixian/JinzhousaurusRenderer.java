package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.JinzhousaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Jinzhousaurus;

public class JinzhousaurusRenderer extends MobRenderer<Jinzhousaurus, JinzhousaurusModel> {
	private static final ResourceLocation JINZHOUSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/jinzhousaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/melanistic.png");
	private static final ResourceLocation INCISIVOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/jinzhousaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/melanistic_sleeping.png");

	public JinzhousaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new JinzhousaurusModel(renderManagerIn.bakeLayer(ClientEvents.JINZHOUSAURUS)), 0.875F);
	}

	protected void scale(Jinzhousaurus jinzhousaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(jinzhousaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(jinzhousaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Jinzhousaurus entity) {
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
				return INCISIVOSAURUS_SLEEPING;
			} else return JINZHOUSAURUS;
		}
	}
}
