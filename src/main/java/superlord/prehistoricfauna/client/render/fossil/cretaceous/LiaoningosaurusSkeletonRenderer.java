package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.*;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.LiaoningosaurusSkeleton;

public class LiaoningosaurusSkeletonRenderer extends MobRenderer<LiaoningosaurusSkeleton, EntityModel<LiaoningosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/liaoningosaurus_skeleton.png");
    private static LiaoningosaurusSkeletonModel IDLE;
    private static LiaoningosaurusSkeletonWalkModel WALK;
    private static LiaoningosaurusSkeletonBraceModel BRACE;
    private static LiaoningosaurusSkeletonSaunterModel SAUNTER;
    private static LiaoningosaurusSkeletonGazeModel GAZE;
    private static LiaoningosaurusSkeletonClobberModel CLOBBER;
    private static LiaoningosaurusSkeletonDefensiveModel DEFENSIVE;
    private static LiaoningosaurusSkeletonSitModel SIT;
    private static LiaoningosaurusSkeletonSleepModel SLEEP;
    private static LiaoningosaurusSkeletonDeathModel DEATH;

	public LiaoningosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LiaoningosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON)), 0);
		IDLE = new LiaoningosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON));
		WALK = new LiaoningosaurusSkeletonWalkModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON_WALK));
		BRACE = new LiaoningosaurusSkeletonBraceModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON_BRACE));
		SAUNTER = new LiaoningosaurusSkeletonSaunterModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON_SAUNTER));
		GAZE = new LiaoningosaurusSkeletonGazeModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON_GAZE));
		CLOBBER = new LiaoningosaurusSkeletonClobberModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON_CLOBBER));
		DEFENSIVE = new LiaoningosaurusSkeletonDefensiveModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON_DEFENSIVE));
		SIT = new LiaoningosaurusSkeletonSitModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON_SIT));
		SLEEP = new LiaoningosaurusSkeletonSleepModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON_SLEEP));
		DEATH = new LiaoningosaurusSkeletonDeathModel(renderManagerIn.bakeLayer(ClientEvents.LIAONINGOSAURUS_SKELETON_DEATH));
	}
	
	protected void scale(LiaoningosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isWalk()) {
			model = WALK;
		} else if (entityIn.isBrace()) {
			model = BRACE;
		} else if (entityIn.isSaunter()) {
			model = SAUNTER;
		} else if (entityIn.isGaze()) {
			model = GAZE;
		} else if (entityIn.isClobber()) {
			model = CLOBBER;
		} else if (entityIn.isDefensive()) {
			model = DEFENSIVE;
		} else if (entityIn.isSit()) {
			model = SIT;
		} else if (entityIn.isSleep()) {
			model = SLEEP;
		} else if (entityIn.isDeath()) {
			model = DEATH;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(LiaoningosaurusSkeleton entity) {
			return SKELETON;
	}

}
