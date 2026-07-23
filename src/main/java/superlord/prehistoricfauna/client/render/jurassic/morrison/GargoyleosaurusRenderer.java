package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.GargoyleosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Gargoyleosaurus;

public class GargoyleosaurusRenderer extends MobRenderer<Gargoyleosaurus, GargoyleosaurusModel> {
	private static final ResourceLocation GARGOYLEOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gargoyleosaurus/gargoyleosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gargoyleosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gargoyleosaurus/melanistic.png");
	private static final ResourceLocation GARGOYLEOSAURUS_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gargoyleosaurus/gargoyleosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gargoyleosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/gargoyleosaurus/melanistic_sleeping.png");

	public GargoyleosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GargoyleosaurusModel(renderManagerIn.bakeLayer(ClientEvents.GARGOYLEOSAURUS)), 0.6875F);
	}

	protected void scale(Gargoyleosaurus gargoyleosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(gargoyleosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(gargoyleosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Gargoyleosaurus entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return GARGOYLEOSAURUS_SLEEPING_TEXTURE;
			} else {
				return GARGOYLEOSAURUS;
			}
		}
    }
}
