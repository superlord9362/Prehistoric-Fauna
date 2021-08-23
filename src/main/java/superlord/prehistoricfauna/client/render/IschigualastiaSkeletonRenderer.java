package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.IschigualastiaSkeletonModel;
import superlord.prehistoricfauna.client.model.IschigualastiaSkeletonStretchingModel;
import superlord.prehistoricfauna.common.entities.IschigualastiaSkeletonEntity;

public class IschigualastiaSkeletonRenderer extends MobRenderer<IschigualastiaSkeletonEntity, EntityModel<IschigualastiaSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ischigualastia_skeleton.png");
	private static final IschigualastiaSkeletonModel IDLE = new IschigualastiaSkeletonModel();
	private static final IschigualastiaSkeletonStretchingModel STRETCHING = new IschigualastiaSkeletonStretchingModel();

	public IschigualastiaSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 1.25F);
	}

	public void render(IschigualastiaSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if(entityIn.isStretching()) {
			entityModel = STRETCHING;
		} else {
			entityModel = IDLE;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(IschigualastiaSkeletonEntity entity) {
		return SKELETON;
	}

}
