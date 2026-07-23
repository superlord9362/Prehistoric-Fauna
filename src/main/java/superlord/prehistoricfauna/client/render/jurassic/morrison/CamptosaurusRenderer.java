package superlord.prehistoricfauna.client.render.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamptosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamptosaurusModel;
import superlord.prehistoricfauna.client.render.layer.CamptosaurusChestLayer;
import superlord.prehistoricfauna.client.render.layer.CamptosaurusSaddleLayer;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camptosaurus;

public class CamptosaurusRenderer extends MobRenderer<Camptosaurus, EntityModel<Camptosaurus>> {
	private static final ResourceLocation CAMPTOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/camptosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/melanistic.png");
	private static final ResourceLocation CAMPTOSAURUS_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/camptosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/melanistic_sleeping.png");
	private static final ResourceLocation CAMPTOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/camptosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/melanistic_baby.png");
	private static final ResourceLocation CAMPTOSAURUS_BABY_SLEEPING_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/camptosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/melanistic_baby_sleeping.png");

	private CamptosaurusModel CAMPTOSAURUS_MODEL;
	private CamptosaurusBabyModel CAMPTOSAURUS_BABY_MODEL;

	public CamptosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CamptosaurusModel(renderManagerIn.bakeLayer(ClientEvents.CAMPTOSAURUS)), 1F);
		CAMPTOSAURUS_MODEL = new CamptosaurusModel(renderManagerIn.bakeLayer(ClientEvents.CAMPTOSAURUS));
		CAMPTOSAURUS_BABY_MODEL = new CamptosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.CAMPTOSAURUS_BABY));
		this.addLayer(new CamptosaurusSaddleLayer(this));
		this.addLayer(new CamptosaurusChestLayer(this));
	}

	protected void scale(Camptosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			model = CAMPTOSAURUS_BABY_MODEL;
		} else {
			model = CAMPTOSAURUS_MODEL;
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Camptosaurus entity) {
		if (entity.isBaby()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else {
					return ALBINO_BABY;
				}
			} else if (entity.isMelanistic()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else {
					return MELANISTIC_BABY;
				}
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return CAMPTOSAURUS_BABY_SLEEPING_TEXTURE;
				} else {
					return CAMPTOSAURUS_BABY;
				}
			}
		} else {
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
					return CAMPTOSAURUS_SLEEPING_TEXTURE;
				} else {
					return CAMPTOSAURUS;
				}
			}
		}
	}
}
