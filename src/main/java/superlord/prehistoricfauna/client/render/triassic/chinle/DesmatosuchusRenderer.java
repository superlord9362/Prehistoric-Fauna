package superlord.prehistoricfauna.client.render.triassic.chinle;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.chinle.DesmatosuchusModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.DesmatosuchusSleepingModel;
import superlord.prehistoricfauna.client.render.layer.DesmatosuchusEyeLayer;
import superlord.prehistoricfauna.common.entities.triassic.chinle.DesmatosuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

@OnlyIn(Dist.CLIENT)
public class DesmatosuchusRenderer extends MobRenderer<DesmatosuchusEntity, EntityModel<DesmatosuchusEntity>> {

	private static final DesmatosuchusModel DESMATOSUCHUS_MODEL = new DesmatosuchusModel();
	private static final DesmatosuchusSleepingModel DESMATOSUCHUS_SLEEPING_MODEL = new DesmatosuchusSleepingModel();
	private static final ResourceLocation DESMATOSUCHUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/desmatosuchus.png");
	private static final ResourceLocation DESMATOSUCHUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/desmatosuchus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/melanistic_sleeping.png");

	public DesmatosuchusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), DESMATOSUCHUS_MODEL, 1.25F);
		if (PrehistoricFaunaConfig.eyeShine) {
			this.addLayer(new DesmatosuchusEyeLayer(this));
		}
	}

	protected void preRenderCallback(DesmatosuchusEntity desmatosuchus, MatrixStack matrixStackIn, float partialTickTime) {
		if(desmatosuchus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(DesmatosuchusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = DESMATOSUCHUS_SLEEPING_MODEL;
		} else {
			entityModel = DESMATOSUCHUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	public ResourceLocation getEntityTexture(DesmatosuchusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if(entity.isMelanistic()) {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep() || entity.ticksExisted % 50 >= 0 && entity.ticksExisted % 50 <= 5) {
				return DESMATOSUCHUS_TEXTURE_SLEEPING;
			} else {
				return DESMATOSUCHUS_TEXTURE;
			}
		}
	}
}