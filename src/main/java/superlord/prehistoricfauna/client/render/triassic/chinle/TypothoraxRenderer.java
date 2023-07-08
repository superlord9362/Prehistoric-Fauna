package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.triassic.chinle.TypothoraxModel;
import superlord.prehistoricfauna.client.render.layer.TypothoraxEyeLayer;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Typothorax;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class TypothoraxRenderer extends MobRenderer<Typothorax, TypothoraxModel> {
	private static final ResourceLocation TYPOTHORAX = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/typothorax.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/melanistic.png");
	private static final ResourceLocation TYPOTHORAX_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/typothorax_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/melanistic_sleeping.png");

	public TypothoraxRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TypothoraxModel(renderManagerIn.bakeLayer(ClientEvents.TYPOTHORAX)), 1F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new TypothoraxEyeLayer(this));
		}
	}

	protected void scale(Typothorax thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Typothorax entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if(entity.isMelanistic()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				return TYPOTHORAX_SLEEPING;
			} else {
				return TYPOTHORAX;
			}
		}
	}
}
