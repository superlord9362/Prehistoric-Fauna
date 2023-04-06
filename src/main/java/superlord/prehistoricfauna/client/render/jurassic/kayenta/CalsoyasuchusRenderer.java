package superlord.prehistoricfauna.client.render.jurassic.kayenta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.CalsoyasuchusModel;
import superlord.prehistoricfauna.client.render.layer.CalsoyasuchusEyeLayer;
//import superlord.prehistoricfauna.client.model.jurassic.kayenta.CalsoyasuchusSleepingModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.CalsoyasuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class CalsoyasuchusRenderer extends MobRenderer<CalsoyasuchusEntity,  EntityModel<CalsoyasuchusEntity>> {

	private static final ResourceLocation CALSOYASUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/calsoyasuchus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/melanistic.png");
	private static final ResourceLocation CALSOYASUCHUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/calsoyasuchus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/melanistic_sleeping.png");
	private static final CalsoyasuchusModel CALSOYASUCHUS_MODEL = new CalsoyasuchusModel();

	public CalsoyasuchusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CALSOYASUCHUS_MODEL, 0.5F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new CalsoyasuchusEyeLayer(this));
		}
	}

	protected void preRenderCallback(CalsoyasuchusEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(CalsoyasuchusEntity entity) {
		if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return CALSOYASUCHUS_SLEEPING;
			} else return CALSOYASUCHUS;
		}
	}

}
