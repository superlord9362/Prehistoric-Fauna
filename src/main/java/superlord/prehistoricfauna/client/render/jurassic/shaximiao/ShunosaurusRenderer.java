package superlord.prehistoricfauna.client.render.jurassic.shaximiao;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.ShunosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.ShunosaurusModel;
import superlord.prehistoricfauna.client.render.layer.ShunosaurusChestOneLayer;
import superlord.prehistoricfauna.client.render.layer.ShunosaurusChestTwoLayer;
import superlord.prehistoricfauna.client.render.layer.ShunosaurusSaddleLayer;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Shunosaurus;

public class ShunosaurusRenderer  extends MobRenderer<Shunosaurus, EntityModel<Shunosaurus>> {
	private static final ResourceLocation SHUNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/shunosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/melanistic.png");
	private static final ResourceLocation SHUNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/shunosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/melanistic_sleeping.png");
	private static final ResourceLocation SHUNOSAURUS_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/shunosaurus_baby.png");
	private static final ResourceLocation ALBINO_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/albino_baby.png");
	private static final ResourceLocation MELANISTIC_BABY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/melanistic_baby.png");
	private static final ResourceLocation SHUNOSAURUS_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/shunosaurus_baby_sleeping.png");
	private static final ResourceLocation ALBINO_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/albino_baby_sleeping.png");
	private static final ResourceLocation MELANISTIC_BABY_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/melanistic_baby_sleeping.png");

	private static ShunosaurusModel SHUNOSAURUS_MODEL;
	private static ShunosaurusBabyModel BABY_SHUNOSAURUS_MODEL;

	public ShunosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ShunosaurusModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS)), 1.625F);
		SHUNOSAURUS_MODEL = new ShunosaurusModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS));
		BABY_SHUNOSAURUS_MODEL = new ShunosaurusBabyModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_BABY));
		this.addLayer(new ShunosaurusSaddleLayer(this));
		this.addLayer(new ShunosaurusChestOneLayer(this));
		this.addLayer(new ShunosaurusChestTwoLayer(this));
	}

	protected void scale(Shunosaurus shunosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(shunosaurus.isBaby()) {
			model = BABY_SHUNOSAURUS_MODEL;
		} else {
			model = SHUNOSAURUS_MODEL;
		}
		super.scale(shunosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Shunosaurus entity) {
		if (entity.isBaby()) {
			if (entity.isAlbino()) {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return ALBINO_BABY_SLEEPING;
				} else return ALBINO_BABY;
			} else if (entity.isMelanistic()) {
				if (entity.isMelanistic() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return MELANISTIC_BABY_SLEEPING;
				} else return MELANISTIC_BABY;
			} else {
				if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
					return SHUNOSAURUS_BABY_SLEEPING;
				} else return SHUNOSAURUS_BABY;
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
					return SHUNOSAURUS_SLEEPING;
				} else return SHUNOSAURUS;
			}
		}
	}
}
