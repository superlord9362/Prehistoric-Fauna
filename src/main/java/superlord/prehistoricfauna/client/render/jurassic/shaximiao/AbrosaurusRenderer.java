package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.AbrosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Abrosaurus;

public class AbrosaurusRenderer extends MobRenderer<Abrosaurus, AbrosaurusModel> {
	private static final ResourceLocation ABROSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/abrosaurus/abrosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/abrosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/abrosaurus/melanistic.png");
	private static final ResourceLocation ABROSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/abrosaurus/abrosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/abrosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/abrosaurus/melanistic_sleeping.png");

	public AbrosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AbrosaurusModel(renderManagerIn.bakeLayer(ClientEvents.ABROSAURUS)), 1.625F);
	}

	protected void scale(Abrosaurus abrosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(abrosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(abrosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Abrosaurus entity) {
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
				return ABROSAURUS_SLEEPING;
			} else return ABROSAURUS;
		}
	}
}
