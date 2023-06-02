package superlord.prehistoricfauna.client.render.fossil.triassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.IschigualastiaSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.IschigualastiaSkeletonStretchingModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.IschigualastiaSkeleton;

public class IschigualastiaSkeletonRenderer extends MobRenderer<IschigualastiaSkeleton, EntityModel<IschigualastiaSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ischigualastia_skeleton.png");
    private static IschigualastiaSkeletonModel IDLE;
    private static IschigualastiaSkeletonStretchingModel STRETCHING;

	public IschigualastiaSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new IschigualastiaSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.ISCHIGUALASTIA_SKELETON)), 0);
		IDLE = new IschigualastiaSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.ISCHIGUALASTIA_SKELETON));
		STRETCHING = new IschigualastiaSkeletonStretchingModel(renderManagerIn.bakeLayer(ClientEvents.ISCHIGUALASTIA_SKELETON_STRETCHING));
	}
	
	protected void scale(IschigualastiaSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isStretching()) {
			model = STRETCHING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(IschigualastiaSkeleton entity) {
			return SKELETON;
	}

}
