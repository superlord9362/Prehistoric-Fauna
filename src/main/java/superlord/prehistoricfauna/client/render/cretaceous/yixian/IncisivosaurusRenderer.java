package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.IncisivosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Incisivosaurus;

public class IncisivosaurusRenderer extends MobRenderer<Incisivosaurus, IncisivosaurusModel> {
	private static final ResourceLocation INCISIVOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/incisivosaurus/incisivosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/incisivosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/incisivosaurus/melanistic.png");
	private static final ResourceLocation INCISIVOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/incisivosaurus/incisivosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/incisivosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/incisivosaurus/melanistic_sleeping.png");

	public IncisivosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new IncisivosaurusModel(renderManagerIn.bakeLayer(ClientEvents.INCISIVOSAURUS)), 0.5625F);
	}

	protected void scale(Incisivosaurus incisivosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(incisivosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(incisivosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Incisivosaurus entity) {
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
			} else return INCISIVOSAURUS;
		}
	}
}
