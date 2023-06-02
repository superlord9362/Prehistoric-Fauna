package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkeletonEatingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkeletonWalkingModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.SarahsaurusSkeleton;

public class SarahsaurusSkeletonRenderer extends MobRenderer<SarahsaurusSkeleton, EntityModel<SarahsaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/sarahsaurus_skeleton.png");
    private static SarahsaurusSkeletonModel IDLE;
    private static SarahsaurusSkeletonEatingModel EATING;
    private static SarahsaurusSkeletonWalkingModel WALKING;
    private static SarahsaurusSkeletonSittingModel SITTING;
    
	public SarahsaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SarahsaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.SARAHSAURUS_SKELETON)), 0);
		IDLE = new SarahsaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.SARAHSAURUS_SKELETON));
		EATING = new SarahsaurusSkeletonEatingModel(renderManagerIn.bakeLayer(ClientEvents.SARAHSAURUS_SKELETON_EATING));
		WALKING = new SarahsaurusSkeletonWalkingModel(renderManagerIn.bakeLayer(ClientEvents.SARAHSAURUS_SKELETON_WALKING));
		SITTING = new SarahsaurusSkeletonSittingModel(renderManagerIn.bakeLayer(ClientEvents.SARAHSAURUS_SKELETON_SITTING));
	}
	
	protected void scale(SarahsaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isEating()) {
			model = EATING;
		} else if (entityIn.isWalking()) {
			model = WALKING;
		} else if (entityIn.isSitting()) {
			model = SITTING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(SarahsaurusSkeleton entity) {
			return SKELETON;
	}

}
