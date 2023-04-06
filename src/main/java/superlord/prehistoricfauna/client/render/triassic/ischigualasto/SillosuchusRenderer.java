package superlord.prehistoricfauna.client.render.triassic.ischigualasto;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SillosuchusModel;
import superlord.prehistoricfauna.client.render.layer.SillosuchusEyeLayer;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SillosuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

@OnlyIn(Dist.CLIENT)
public class SillosuchusRenderer extends MobRenderer<SillosuchusEntity, EntityModel<SillosuchusEntity>>{

	private static final SillosuchusModel SILLOSUCHUS_MODEL = new SillosuchusModel();
	private static final ResourceLocation SILLOSUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/sillosuchus.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/melanistic.png");
	private static final ResourceLocation SILLOSUCHUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/sillosuchus_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/melanistic_sleeping.png");

	public SillosuchusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), SILLOSUCHUS_MODEL, 1.7F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new SillosuchusEyeLayer(this));
		}
	}

	protected void preRenderCallback(SillosuchusEntity sillosuchus, MatrixStack matrixStackIn, float partialTickTime) {
		if (sillosuchus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}


	public ResourceLocation getEntityTexture(SillosuchusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return SILLOSUCHUS_SLEEPING;
			} else return SILLOSUCHUS;
		}
	}

}
