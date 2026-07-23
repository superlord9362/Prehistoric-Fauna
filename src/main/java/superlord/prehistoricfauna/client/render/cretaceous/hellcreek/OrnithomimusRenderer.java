package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.OrnithomimusModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.OrnithomimusBabyModel;
import superlord.prehistoricfauna.client.render.layer.OrnithomimusBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.OrnithomimusEyeLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ornithomimus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class OrnithomimusRenderer extends MobRenderer<Ornithomimus, EntityModel<Ornithomimus>> {
	private static final ResourceLocation ORNITHOMIMUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/ornithomimus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/melanistic.png");
	private static final ResourceLocation ORNITHOMIMUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/ornithomimus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/melanistic_sleeping.png");
	private static final ResourceLocation ORNITHOMIMUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/ornithomimus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/melanistic_baby.png");
	private static final ResourceLocation ORNITHOMIMUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/ornithomimus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/ornithomimus/melanistic_baby_sleeping.png");

	OrnithomimusModel ORNITHOMIMUS_MODEL;
	OrnithomimusBabyModel BABY_MODEL;
	
	public OrnithomimusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new OrnithomimusModel(renderManagerIn.bakeLayer(ClientEvents.ORNITHOMIMUS)), 0.75F);
		ORNITHOMIMUS_MODEL = new OrnithomimusModel(renderManagerIn.bakeLayer(ClientEvents.ORNITHOMIMUS));
		BABY_MODEL = new OrnithomimusBabyModel(renderManagerIn.bakeLayer(ClientEvents.ORNITHOMIMUS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new OrnithomimusEyeLayer(this));
			this.addLayer(new OrnithomimusBabyEyeLayer(this));
		}
	}

	protected void scale(Ornithomimus ornithomimus, PoseStack matrixStackIn, float partialTickTime) {
		if(ornithomimus.isBaby()) {
			model = BABY_MODEL;
		} else model = ORNITHOMIMUS_MODEL;
		super.scale(ornithomimus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Ornithomimus entity) {
		if (entity.isBaby()) {
			if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else return MELANISTIC_BABY;
			} else if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else return ALBINO_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ORNITHOMIMUS_BABY_SLEEPING;
				} else return ORNITHOMIMUS_BABY;
			}
		} else {
			if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			} else if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ORNITHOMIMUS_SLEEPING;
				} else return ORNITHOMIMUS;
			}
		}
	}
}
