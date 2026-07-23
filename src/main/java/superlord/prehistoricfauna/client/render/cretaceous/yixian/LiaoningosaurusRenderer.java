package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.LiaoningosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Liaoningosaurus;

public class LiaoningosaurusRenderer extends MobRenderer<Liaoningosaurus, LiaoningosaurusModel> {
	private static final ResourceLocation LIAONINGOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/liaoningosaurus/liaoningosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/liaoningosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/liaoningosaurus/melanistic.png");
	private static final ResourceLocation LIAONINGOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/liaoningosaurus/liaoningosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/liaoningosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/liaoningosaurus/melanistic_sleeping.png");

	public LiaoningosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LiaoningosaurusModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS)), 1F);
	}

	protected void scale(Liaoningosaurus liaoningosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(liaoningosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(liaoningosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Liaoningosaurus entity) {
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
				return LIAONINGOSAURUS_SLEEPING;
			} else return LIAONINGOSAURUS;
		}
	}
}