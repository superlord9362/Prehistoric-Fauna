package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.MegapnosaurusModel;
import superlord.prehistoricfauna.client.render.layer.MegapnosaurusEyeLayer;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class MegapnosaurusRenderer extends MobRenderer<MegapnosaurusEntity, EntityModel<MegapnosaurusEntity>> {

	private static final ResourceLocation MEGAPNOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/megapnosaurus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/melanistic.png");
	private static final ResourceLocation MEGAPNOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/megapnosaurus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/melanistic_sleeping.png");
	private static final ResourceLocation JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/juvenile.png");
	private static final ResourceLocation ALBINO_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/albino_juvenile.png");
	private static final ResourceLocation MELANISTIC_JUVENILE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/melanistic_juvenile.png");
	private static final ResourceLocation JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/juvenile_sleeping.png");
	private static final ResourceLocation ALBINO_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/albino_juvenile_sleeping.png");
	private static final ResourceLocation MELANISTIC_JUVENILE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/melanistic_juvenile_sleeping.png");
	private static final MegapnosaurusModel MEGAPNOSAURUS_MODEL = new MegapnosaurusModel();

	public MegapnosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), MEGAPNOSAURUS_MODEL, 0.625F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new MegapnosaurusEyeLayer(this));
		}
	}

	protected void preRenderCallback(MegapnosaurusEntity megapnosaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if (megapnosaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(MegapnosaurusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return ALBINO_JUVENILE_SLEEPING;
				} else return ALBINO_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return ALBINO_SLEEPING;
				} else return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return MELANISTIC_JUVENILE_SLEEPING;
				} else return MELANISTIC_JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return MELANISTIC_SLEEPING;
				} else return MELANISTIC;
			}
		} else {
			if (entity.isChild()) {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return JUVENILE_SLEEPING;
				} else return JUVENILE;
			} else {
				if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
					return MEGAPNOSAURUS_SLEEPING;
				} else return MEGAPNOSAURUS;
			}
		}
	}

}
