package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.BeipiaosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Beipiaosaurus;

public class BeipiaosaurusRenderer extends MobRenderer<Beipiaosaurus, BeipiaosaurusModel> {
	private static final ResourceLocation BEIPIAOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/beipiaosaurus/beipiaosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/beipiaosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/beipiaosaurus/melanistic.png");
	private static final ResourceLocation BEIPIAOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/beipiaosaurus/beipiaosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/beipiaosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/beipiaosaurus/melanistic_sleeping.png");

	public BeipiaosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BeipiaosaurusModel(renderManagerIn.bakeLayer(ClientEvents.BEIPIAOSAURUS)), 0.4375F);
	}

	protected void scale(Beipiaosaurus beipiaosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(beipiaosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(beipiaosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Beipiaosaurus entity) {
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
				return BEIPIAOSAURUS_SLEEPING;
			} else return BEIPIAOSAURUS;
		}
	}
}