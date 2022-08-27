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
import superlord.prehistoricfauna.client.model.triassic.chinle.TrilophosaurusModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.TrilophosaurusSleepingModel;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TrilophosaurusEntity;

@OnlyIn(Dist.CLIENT)
public class TrilophosaurusRenderer extends MobRenderer<TrilophosaurusEntity, EntityModel<TrilophosaurusEntity>> {

	private static final TrilophosaurusModel TRILOPHOSAURUS_MODEL = new TrilophosaurusModel();
	private static final TrilophosaurusSleepingModel TRILOPHOSAURUS_SLEEPING_MODEL = new TrilophosaurusSleepingModel();
	private static final ResourceLocation TRILOPHOSAURUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/trilophosaurus/trilophosaurus.png");
	private static final ResourceLocation TRILOPHOSAURUS_TEXTURE_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/trilophosaurus/trilophosaurus_sleeping.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/trilophosaurus/albino.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/trilophosaurus/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/trilophosaurus/melanistic.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/trilophosaurus/melanistic_sleeping.png");

	public TrilophosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), TRILOPHOSAURUS_MODEL, 0.5F);
	}

	protected void preRenderCallback(TrilophosaurusEntity trilophosaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(trilophosaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	public void render(TrilophosaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = TRILOPHOSAURUS_SLEEPING_MODEL;
		} else {
			entityModel = TRILOPHOSAURUS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	public ResourceLocation getEntityTexture(TrilophosaurusEntity entity) {
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
				return TRILOPHOSAURUS_TEXTURE_SLEEPING;
			} else {
				return TRILOPHOSAURUS_TEXTURE;
			}
		}
	}
}