package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonBraceModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonDeathModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonFeedingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonHeadbuttOneModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonHeadbuttTwoModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonRearModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonSitModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonSleepModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkeletonStepModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.GoyocephaleSkeleton;

public class GoyocephaleSkeletonRenderer extends MobRenderer<GoyocephaleSkeleton, EntityModel<GoyocephaleSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/goyocephale_skeleton.png");
    private static GoyocephaleSkeletonModel IDLE;
    private static GoyocephaleSkeletonStepModel STEP;
    private static GoyocephaleSkeletonSleepModel SLEEP;
    private static GoyocephaleSkeletonFeedingModel FEEDING;
    private static GoyocephaleSkeletonSitModel SIT;
    private static GoyocephaleSkeletonDeathModel DEATH;
    private static GoyocephaleSkeletonHeadbuttTwoModel HEADBUTT_TWO;
    private static GoyocephaleSkeletonHeadbuttOneModel HEADBUTT_ONE;
    private static GoyocephaleSkeletonBraceModel BRACE;
    private static GoyocephaleSkeletonRearModel REAR;

	public GoyocephaleSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GoyocephaleSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON)), 0);
		IDLE = new GoyocephaleSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON));
		STEP = new GoyocephaleSkeletonStepModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON_STEP));
		SLEEP = new GoyocephaleSkeletonSleepModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON_SLEEP));
		FEEDING = new GoyocephaleSkeletonFeedingModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON_FEEDING));
		SIT = new GoyocephaleSkeletonSitModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON_SIT));
		DEATH = new GoyocephaleSkeletonDeathModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON_DEATH));
		HEADBUTT_TWO = new GoyocephaleSkeletonHeadbuttTwoModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON_HEADBUTT_TWO));
		HEADBUTT_ONE = new GoyocephaleSkeletonHeadbuttOneModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON_HEADBUTT_ONE));
		BRACE = new GoyocephaleSkeletonBraceModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON_BRACE));
		REAR = new GoyocephaleSkeletonRearModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKELETON_REAR));
	}
	
	protected void scale(GoyocephaleSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isStep()) {
			model = STEP;
		} else if (entityIn.isSleep()) {
			model = SLEEP;
		} else if (entityIn.isFeeding()) {
			model = FEEDING;
		} else if (entityIn.isSit()) {
			model = SIT;
		} else if (entityIn.isDeath()) {
			model = DEATH;
		} else if (entityIn.isHeadbuttTwo()) {
			model = HEADBUTT_TWO;
		} else if (entityIn.isHeadbuttOne()) {
			model = HEADBUTT_ONE;
		} else if (entityIn.isBrace()) {
			model = BRACE;
		} else if (entityIn.isRear()) {
			model = REAR;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(GoyocephaleSkeleton entity) {
			return SKELETON;
	}

}
