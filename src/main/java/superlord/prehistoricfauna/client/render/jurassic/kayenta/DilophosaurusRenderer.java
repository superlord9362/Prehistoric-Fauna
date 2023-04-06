package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.DilophosaurusModel;
import superlord.prehistoricfauna.client.render.layer.DilophosaurusEyeLayer;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DilophosaurusRenderer extends MobRenderer<DilophosaurusEntity,  EntityModel<DilophosaurusEntity>> {

	private static final ResourceLocation DILOPHOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic.png");
	private static final ResourceLocation DILOPHOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic_sleeping.png");
	private static final ResourceLocation JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic_juvenile.png");
	private static final ResourceLocation JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/melanistic_juvenile_sleeping.png");
	private static final DilophosaurusModel DILOPHOSAURUS_MODEL = new DilophosaurusModel();
	private static final ResourceLocation NAVAJO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/navajo.png");
	private static final ResourceLocation NAVAJO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/navajo_sleeping.png");

	public DilophosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), DILOPHOSAURUS_MODEL, 1.2F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DilophosaurusEyeLayer(this));
		}
	}

	protected void preRenderCallback(DilophosaurusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(DilophosaurusEntity entity) {
		String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
		if (s != null && ("Navajo".equals(s))) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return NAVAJO_SLEEPING;
			} else return NAVAJO;
		}
		if (entity.isMelanistic()) {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return MELANISTIC_JUVENILE_SLEEPING;
				} else return MELANISTIC_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			}
		} else if (entity.isAlbino()) {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return ALBINO_JUVENILE_SLEEPING;
				} else return ALBINO_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			}
		} else {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return JUVENILE_SLEEPING;
				} else return JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return DILOPHOSAURUS_SLEEPING;
				} else return DILOPHOSAURUS;
			}
		}
	}

}
