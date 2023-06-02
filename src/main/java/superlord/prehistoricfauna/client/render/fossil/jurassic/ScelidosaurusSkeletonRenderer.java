package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonDashingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonGrazingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonReachingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonWalkingModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ScelidosaurusSkeleton;

public class ScelidosaurusSkeletonRenderer extends MobRenderer<ScelidosaurusSkeleton, EntityModel<ScelidosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/scelidosaurus_skeleton.png");
    private static ScelidosaurusSkeletonModel IDLE;
    private static ScelidosaurusSkeletonDashingModel DASHING;
    private static ScelidosaurusSkeletonGrazingModel GRAZING;
    private static ScelidosaurusSkeletonReachingModel REACHING;
    private static ScelidosaurusSkeletonSleepingModel SLEEPING;
    private static ScelidosaurusSkeletonWalkingModel WALKING;
    
	public ScelidosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ScelidosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.SCELIDOSAURUS_SKELETON)), 0);
		IDLE = new ScelidosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.SCELIDOSAURUS_SKELETON));
		DASHING = new ScelidosaurusSkeletonDashingModel(renderManagerIn.bakeLayer(ClientEvents.SCELIDOSAURUS_SKELETON_DASHING));
		GRAZING = new ScelidosaurusSkeletonGrazingModel(renderManagerIn.bakeLayer(ClientEvents.SCELIDOSAURUS_SKELETON_GRAZING));
		REACHING = new ScelidosaurusSkeletonReachingModel(renderManagerIn.bakeLayer(ClientEvents.SCELIDOSAURUS_SKELETON_REACHING));
		SLEEPING = new ScelidosaurusSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.SCELIDOSAURUS_SKELETON_SLEEPING));
		WALKING = new ScelidosaurusSkeletonWalkingModel(renderManagerIn.bakeLayer(ClientEvents.SCELIDOSAURUS_SKELETON_WALKING));
	}
	
	protected void scale(ScelidosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isDashing()) {
			model = DASHING;
		} else if (entityIn.isWalking()) {
			model = WALKING;
		} else if (entityIn.isGrazing()) {
			model = GRAZING;
		} else if (entityIn.isReaching()) {
			model = REACHING;
		} else if (entityIn.isSleeping()) {
			model = SLEEPING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(ScelidosaurusSkeleton entity) {
			return SKELETON;
	}

}
