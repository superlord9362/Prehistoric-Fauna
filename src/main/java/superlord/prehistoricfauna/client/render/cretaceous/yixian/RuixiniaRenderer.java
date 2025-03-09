package superlord.prehistoricfauna.client.render.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.RuixiniaBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.RuixiniaModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Ruixinia;

public class RuixiniaRenderer extends MobRenderer<Ruixinia, EntityModel<Ruixinia>> {
	private static final ResourceLocation RUIXINIA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/ruixinia.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/melanistic.png");
	private static final ResourceLocation RUIXINIA_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/ruixinia_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/melanistic_sleeping.png");

	private static final ResourceLocation RUIXINIA_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/ruixinia_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/melanistic_baby.png");
	private static final ResourceLocation RUIXINIA_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/ruixinia_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ruixinia/melanistic_baby_sleeping.png");

	private static RuixiniaModel RUIXINIA_MODEL;
	private static RuixiniaBabyModel BABY_MODEL;

	public RuixiniaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new RuixiniaModel(renderManagerIn.bakeLayer(ClientEvents.RUIXINIA)), 1.5F);
		RUIXINIA_MODEL = new RuixiniaModel(renderManagerIn.bakeLayer(ClientEvents.RUIXINIA));
		BABY_MODEL = new RuixiniaBabyModel(renderManagerIn.bakeLayer(ClientEvents.RUIXINIA_BABY));
	}

	protected void scale(Ruixinia ruixinia, PoseStack matrixStackIn, float partialTickTime) {
		if(ruixinia.isBaby()) {
			model = BABY_MODEL;
		} else model = RUIXINIA_MODEL;
		super.scale(ruixinia, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Ruixinia entity) {
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
					return RUIXINIA_BABY_SLEEPING;
				} else return RUIXINIA_BABY;
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
					return RUIXINIA_SLEEPING;
				} else return RUIXINIA;
			}
		}
	}
}