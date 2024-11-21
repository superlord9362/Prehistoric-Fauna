package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.DongbeititanModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Dongbeititan;

public class DongbeititanRenderer extends MobRenderer<Dongbeititan, DongbeititanModel> {
	private static final ResourceLocation DONGBEITITAN = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dongbeititan/dongbeititan.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dongbeititan/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dongbeititan/melanistic.png");
	private static final ResourceLocation DONGBEITITAN_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dongbeititan/dongbeititan_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dongbeititan/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dongbeititan/melanistic_sleeping.png");

	public DongbeititanRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DongbeititanModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN)), 2.25F);
	}

	protected void scale(Dongbeititan dongbeititan, PoseStack matrixStackIn, float partialTickTime) {
		if(dongbeititan.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(dongbeititan, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Dongbeititan entity) {
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
				return DONGBEITITAN_SLEEPING;
			} else return DONGBEITITAN;
		}
	}
}