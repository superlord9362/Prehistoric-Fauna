package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsJuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsModel;
import superlord.prehistoricfauna.client.render.layer.TriceratopsBabyEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TriceratopsChestLayer;
import superlord.prehistoricfauna.client.render.layer.TriceratopsEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TriceratopsJuvenileEyeLayer;
import superlord.prehistoricfauna.client.render.layer.TriceratopsSaddleLayer;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class TriceratopsRenderer extends MobRenderer<Triceratops, EntityModel<Triceratops>> {

	private static final ResourceLocation TRICERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops.png");
	private static final ResourceLocation BABY_TRICERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_baby.png");
	private static final ResourceLocation JUVENILE_TRICERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_juvenile.png");
	private static final ResourceLocation TRICERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_sleeping.png");
	private static final ResourceLocation BABY_TRICERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_baby_sleeping.png");
	private static final ResourceLocation JUVENILE_TRICERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_juvenile_sleeping.png");

	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino.png");
	private static final ResourceLocation JUVENILE_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_juv.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_sleeping.png");
	private static final ResourceLocation JUVENILE_ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_juv_sleeping.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_baby.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_baby_sleep.png");

	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic.png");
	private static final ResourceLocation JUVENILE_MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_juv.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_sleeping.png");
	private static final ResourceLocation JUVENILE_MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_juv_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_baby.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_baby_sleep.png");

	private static TriceratopsModel TRICERATOPS_MODEL;
	private static TriceratopsJuvenileModel JUVENILE_TRICERATOPS_MODEL;
	private static TriceratopsBabyModel BABY_TRICERATOPS_MODEL;

	public TriceratopsRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TriceratopsModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS)), 2F);
		TRICERATOPS_MODEL = new TriceratopsModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS));
		JUVENILE_TRICERATOPS_MODEL = new TriceratopsJuvenileModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS_JUVENILE));
		BABY_TRICERATOPS_MODEL = new TriceratopsBabyModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS_BABY));
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new TriceratopsEyeLayer(this));
			this.addLayer(new TriceratopsJuvenileEyeLayer(this));
			this.addLayer(new TriceratopsBabyEyeLayer(this));
		}
		this.addLayer(new TriceratopsSaddleLayer(this));
		this.addLayer(new TriceratopsChestLayer(this));
	}

	protected void scale(Triceratops triceratops, PoseStack matrixStackIn, float partialTickTime) {
		if(triceratops.isBaby()) {
			if (!triceratops.isJuvenile()) {
				model = BABY_TRICERATOPS_MODEL;
			} else {
				model = JUVENILE_TRICERATOPS_MODEL;
			}
		} else {
			model = TRICERATOPS_MODEL;
		}
		super.scale(triceratops, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Triceratops entity) {
		if (entity.isBaby() && !entity.isJuvenile()) {
			if (entity.isAlbino()) {
				if (entity.isSleeping() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else {
					return ALBINO_BABY;
				}
			} else if (entity.isMelanistic()) {
				if (entity.isSleeping() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else {
					return MELANISTIC_BABY;
				}
			} else {
				if (entity.isSleeping() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return BABY_TRICERATOPS_SLEEPING;
				} else {
					return BABY_TRICERATOPS;
				}
			}
		} else if (entity.isJuvenile()) {
			if (entity.isAlbino()) {
				if (entity.isSleeping() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return JUVENILE_ALBINO_SLEEPING;
				} else {
					return JUVENILE_ALBINO;
				}
			} else if (entity.isMelanistic()) {
				if (entity.isSleeping() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return JUVENILE_MELANISTIC_SLEEPING;
				} else {
					return JUVENILE_MELANISTIC;
				}
			} else {
				if (entity.isSleeping() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return JUVENILE_TRICERATOPS_SLEEPING;
				} else {
					return JUVENILE_TRICERATOPS;
				}
			}
		} else {
			if (entity.isAlbino()) {
				if (entity.isSleeping() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else {
					return ALBINO;
				}
			} else if (entity.isMelanistic()) {
				if (entity.isSleeping() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else {
					return MELANISTIC;
				}
			} else {
				if (entity.isSleeping() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return TRICERATOPS_SLEEPING;
				} else {
					return TRICERATOPS;
				}
			}
		}
	}

}
