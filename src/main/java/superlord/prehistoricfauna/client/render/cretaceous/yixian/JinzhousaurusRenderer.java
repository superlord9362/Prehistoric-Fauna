package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.JinzhousaurusBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.JinzhousaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Jinzhousaurus;

public class JinzhousaurusRenderer extends MobRenderer<Jinzhousaurus, EntityModel<Jinzhousaurus>> {
	private static final ResourceLocation JINZHOUSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/jinzhousaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/melanistic.png");
	private static final ResourceLocation JINZHOUSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/jinzhousaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/melanistic_sleeping.png");

	private static final ResourceLocation JINZHOUSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/jinzhousaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/melanistic_baby.png");
	private static final ResourceLocation JINZHOUSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/jinzhousaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/jinzhousaurus/melanistic_baby_sleeping.png");

	public JinzhousaurusModel JINZHOUSAURUS_MODEL;
	public JinzhousaurusBabyModel JINZHOUSAURUS_BABY_MODEL;

	public JinzhousaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new JinzhousaurusModel(renderManagerIn.bakeLayer(ClientEvents.JINZHOUSAURUS)), 1.25F);
		JINZHOUSAURUS_MODEL = new JinzhousaurusModel(renderManagerIn.bakeLayer(ClientEvents.JINZHOUSAURUS));
		JINZHOUSAURUS_BABY_MODEL = new JinzhousaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.JINZHOUSAURUS_BABY));
	}

	protected void scale(Jinzhousaurus jinzhousaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(jinzhousaurus.isBaby()) {
			model = JINZHOUSAURUS_BABY_MODEL;
		} else model = JINZHOUSAURUS_MODEL;
		super.scale(jinzhousaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Jinzhousaurus entity) {
		if (entity.isBaby()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else return ALBINO_BABY;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else return MELANISTIC_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return JINZHOUSAURUS_BABY_SLEEPING;
				} else return JINZHOUSAURUS_BABY	;
			}
		} else {
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
					return JINZHOUSAURUS_SLEEPING;
				} else return JINZHOUSAURUS;
			}
		}
	}
}
