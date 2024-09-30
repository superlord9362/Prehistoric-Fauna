package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.ChangyuraptorModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Changyuraptor;

public class ChangyuraptorRenderer extends MobRenderer<Changyuraptor, ChangyuraptorModel> {
	private static final ResourceLocation CHANGYURAPTOR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/changyuraptor/changyuraptor.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/changyuraptor/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/changyuraptor/melanistic.png");
	private static final ResourceLocation CHANGYURAPTOR_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/changyuraptor/changyuraptor_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/changyuraptor/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/changyuraptor/melanistic_sleeping.png");

	public ChangyuraptorRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ChangyuraptorModel(renderManagerIn.bakeLayer(ClientEvents.CHANGYURAPTOR)), 0.5625F);
	}

	protected void scale(Changyuraptor changyuraptor, PoseStack matrixStackIn, float partialTickTime) {
		if(changyuraptor.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(changyuraptor, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Changyuraptor entity) {
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
				return CHANGYURAPTOR_SLEEPING;
			} else return CHANGYURAPTOR;
		}
	}
}