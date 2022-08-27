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
import superlord.prehistoricfauna.client.model.triassic.chinle.PoposaurusModel;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PoposaurusEntity;

@OnlyIn(Dist.CLIENT)
public class PoposaurusRenderer extends MobRenderer<PoposaurusEntity, EntityModel<PoposaurusEntity>> {

	private static final PoposaurusModel POPOSAURUS_MODEL = new PoposaurusModel();
	//private static final PoposaurusSleepingModel POPOSAURUS_SLEEPING_MODEL = new PoposaurusSleepingModel();
	private static final ResourceLocation POPOSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/poposaurus.png");
	private static final ResourceLocation POPOSAURUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/poposaurus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/melanistic_sleeping.png");

	public PoposaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), POPOSAURUS_MODEL, 0.5F);
	}

	protected void preRenderCallback(PoposaurusEntity poposaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(poposaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(PoposaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
//		if (entityIn.isAsleep()) {
//			entityModel = POPOSAURUS_SLEEPING_MODEL;
//		} else {
			entityModel = POPOSAURUS_MODEL;
//		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	public ResourceLocation getEntityTexture(PoposaurusEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else {
				return ALBINO;
			}
		} else if(entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else {
				return MELANISTIC;
			}
		} else {
			if (entity.isAsleep()) {
				return POPOSAURUS_TEXTURE_SLEEPING;
			} else {
				return POPOSAURUS_TEXTURE;
			}
		}
	}
}