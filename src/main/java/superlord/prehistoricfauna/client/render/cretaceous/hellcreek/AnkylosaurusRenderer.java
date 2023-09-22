package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.AnkylosaurusBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.AnkylosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;

public class AnkylosaurusRenderer extends MobRenderer<Ankylosaurus, EntityModel<Ankylosaurus>>  {
	private static final ResourceLocation ANKYLOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/melanistic.png");
	private static final ResourceLocation ANKYLOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/melanistic_sleeping.png");
	private static final ResourceLocation ANKYLOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/melanistic_baby.png");
	private static final ResourceLocation ANKYLOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/ankylosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ankylosaurus/melanistic_baby_sleeping.png");

	private static AnkylosaurusModel ANKYLOSAURUS_MODEL;
	private static AnkylosaurusBabyModel BABY_ANKYLOSAURUS_MODEL;

	public AnkylosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AnkylosaurusModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS)), 2F);
		ANKYLOSAURUS_MODEL = new AnkylosaurusModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS));
		BABY_ANKYLOSAURUS_MODEL = new AnkylosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS_BABY));
	}

	protected void scale(Ankylosaurus ankylosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(ankylosaurus.isBaby()) {
			model = BABY_ANKYLOSAURUS_MODEL;
		} else {
			model = ANKYLOSAURUS_MODEL;
		}
		super.scale(ankylosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Ankylosaurus entity) {
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
					return ANKYLOSAURUS_BABY_SLEEPING;
				} else return ANKYLOSAURUS_BABY;
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
					return ANKYLOSAURUS_SLEEPING;
				} else return ANKYLOSAURUS;
			}
		}
	}

}
