package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.*;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.DongbeititanSkeleton;

public class DongbeititanSkeletonRenderer extends MobRenderer<DongbeititanSkeleton, EntityModel<DongbeititanSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/dongbeititan_skeleton.png");
    private static DongbeititanSkeletonModel IDLE;
    private static DongbeititanSkeletonWalkModel WALK;
    private static DongbeititanSkeletonRearModel REAR;
    private static DongbeititanSkeletonReachModel REACH;
    private static DongbeititanSkeletonBrowseModel BROWSE;
    private static DongbeititanSkeletonGrazeModel GRAZE;
    private static DongbeititanSkeletonSitModel SIT;
    private static DongbeititanSkeletonSleepModel SLEEP;
    private static DongbeititanSkeletonDeathModel DEATH;

	public DongbeititanSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DongbeititanSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON)), 0);
		IDLE = new DongbeititanSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON));
		WALK = new DongbeititanSkeletonWalkModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON_WALK));
		REAR = new DongbeititanSkeletonRearModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON_REAR));
		REACH = new DongbeititanSkeletonReachModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON_REACH));
		BROWSE = new DongbeititanSkeletonBrowseModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON_BROWSE));
		GRAZE = new DongbeititanSkeletonGrazeModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON_GRAZE));
		SIT = new DongbeititanSkeletonSitModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON_SIT));
		SLEEP = new DongbeititanSkeletonSleepModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON_SLEEP));
		DEATH = new DongbeititanSkeletonDeathModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKELETON_DEATH));
	}
	
	protected void scale(DongbeititanSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isWalk()) {
			model = WALK;
		} else if (entityIn.isRear()) {
			model = REAR;
		} else if (entityIn.isBrowse()) {
			model = BROWSE;
		} else if (entityIn.isGraze()) {
			model = GRAZE;
		} else if (entityIn.isSit()) {
			model = SIT;
		} else if (entityIn.isSleep()) {
			model = SLEEP;
		} else if (entityIn.isDeath()) {
			model = DEATH;
		} else if (entityIn.isReach()) {
			model = REACH;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(DongbeititanSkeleton entity) {
			return SKELETON;
	}

}
