package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Ischigualastia;
import superlord.prehistoricfauna.common.entities.IschigualastiaEntity;

public class IschigualastiaRenderer extends MobRenderer<IschigualastiaEntity, EntityModel<IschigualastiaEntity>> {

	private static final ResourceLocation ISCHIGUALASTIA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia.png");
	private static final ResourceLocation ISCHIGUALASTIA_SADDLED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia_saddled.png");
	private static final Ischigualastia ISCHIGUALASTIA_MODEL = new Ischigualastia();

	public IschigualastiaRenderer() {
		super(Minecraft.getInstance().getRenderManager(), ISCHIGUALASTIA_MODEL, 1.25F);
	}

	public void render(IschigualastiaEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = ISCHIGUALASTIA_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	protected void preRenderCallback(IschigualastiaEntity ischigualastia, MatrixStack matrixStackIn, float partialTickTime) {
		if (ischigualastia.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(IschigualastiaEntity entity) {
		if(entity.getSaddled()) {
			return ISCHIGUALASTIA_SADDLED;
		} else {
			return ISCHIGUALASTIA;
		}
	}

}
