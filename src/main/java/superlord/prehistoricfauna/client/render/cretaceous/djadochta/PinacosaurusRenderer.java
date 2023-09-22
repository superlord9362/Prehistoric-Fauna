package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PinacosaurusBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PinacosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;

public class PinacosaurusRenderer extends MobRenderer<Pinacosaurus, EntityModel<Pinacosaurus>> {
	private static final ResourceLocation PINACOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/pinacosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/melanistic.png");
	private static final ResourceLocation PINACOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/pinacosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/melanistic_sleeping.png");
	private static final ResourceLocation PINACOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/pinacosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/melanistic_baby.png");
	private static final ResourceLocation PINACOSAURUS_SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/pinacosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/pinacosaurus/melanistic_baby_sleeping.png");

	private static PinacosaurusModel PINACOSAURUS_MODEL;
	private static PinacosaurusBabyModel BABY_PINACOSAURUS_MODEL;

	public PinacosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PinacosaurusModel(renderManagerIn.bakeLayer(ClientEvents.PINACOSAURUS)), 2F);
		PINACOSAURUS_MODEL = new PinacosaurusModel(renderManagerIn.bakeLayer(ClientEvents.PINACOSAURUS));
		BABY_PINACOSAURUS_MODEL = new PinacosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.PINACOSAURUS_BABY));
	}

	protected void scale(Pinacosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = BABY_PINACOSAURUS_MODEL;
		} else {
			model = PINACOSAURUS_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Pinacosaurus entity) {
		if (entity.isBaby()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING_BABY;
				} else return ALBINO_BABY;
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING_BABY;
				} else return MELANISTIC_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return PINACOSAURUS_SLEEPING_BABY;
				} else return PINACOSAURUS_BABY;
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
					return PINACOSAURUS_SLEEPING;
				} else return PINACOSAURUS;
			}
		}
	}
}
