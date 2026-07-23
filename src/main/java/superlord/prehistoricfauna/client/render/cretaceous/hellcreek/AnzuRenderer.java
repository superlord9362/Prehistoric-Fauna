package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.AnzuBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.AnzuModel;
import superlord.prehistoricfauna.client.render.layer.AnzuBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.AnzuEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Anzu;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class AnzuRenderer extends MobRenderer<Anzu, EntityModel<Anzu>> {
	private static final ResourceLocation ANZU = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/anzu.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/melanistic.png");
	private static final ResourceLocation ANZU_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/anzu_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/melanistic_sleeping.png");

	private static final ResourceLocation ANZU_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/anzu_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/melanistic_baby.png");
	private static final ResourceLocation ANZU_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/anzu_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/anzu/melanistic_baby_sleeping.png");

	public static AnzuModel ANZU_MODEL;
	private static AnzuBabyModel BABY_ANZU_MODEL;

	public AnzuRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AnzuModel(renderManagerIn.bakeLayer(ClientEvents.ANZU)), 0.875F);
		ANZU_MODEL = new AnzuModel(renderManagerIn.bakeLayer(ClientEvents.ANZU));
		BABY_ANZU_MODEL = new AnzuBabyModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new AnzuEyeLayer(this));
			this.addLayer(new AnzuBabyEyeLayer(this));
		}
	}

	protected void scale(Anzu thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = BABY_ANZU_MODEL;
		} else model = ANZU_MODEL;
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Anzu entity) {
		if (entity.isBaby()) {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				if (entity.isAlbino()) {
					return ALBINO_BABY_SLEEPING;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_BABY_SLEEPING;
				} else {
					return ANZU_BABY_SLEEPING;
				}
			} else {
				if (entity.isAlbino()) {
					return ALBINO_BABY;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_BABY;
				} else {
					return ANZU_BABY;
				}
			}
		} else {
			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
				if (entity.isAlbino()) {
					return ALBINO_SLEEPING;
				} else if (entity.isMelanistic()) {
					return MELANISTIC_SLEEPING;
				} else {
					return ANZU_SLEEPING;
				}
			} else {
				if (entity.isAlbino()) {
					return ALBINO;
				} else if (entity.isMelanistic()) {
					return MELANISTIC;
				} else {
					return ANZU;
				}
			}
		}
	}
}
