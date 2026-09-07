package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkeletonBrowseModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkeletonDeadModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkeletonGrazeModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkeletonReachModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkeletonRearModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkeletonSitModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkeletonSleepModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkeletonWalkModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ShunosaurusSkeleton;

public class ShunosaurusSkeletonRenderer extends MobRenderer<ShunosaurusSkeleton, EntityModel<ShunosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/shunosaurus_skeleton.png");
    private static ShunosaurusSkeletonModel IDLE;
    private static ShunosaurusSkeletonWalkModel WALK;
    private static ShunosaurusSkeletonRearModel REAR;
    private static ShunosaurusSkeletonReachModel REACH;
    private static ShunosaurusSkeletonBrowseModel BROWSE;
    private static ShunosaurusSkeletonGrazeModel GRAZE;
    private static ShunosaurusSkeletonSitModel SIT;
    private static ShunosaurusSkeletonSleepModel SLEEP;
    private static ShunosaurusSkeletonDeadModel DEATH;

	public ShunosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ShunosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON)), 0);
		IDLE = new ShunosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON));
		WALK = new ShunosaurusSkeletonWalkModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON_WALK));
		REAR = new ShunosaurusSkeletonRearModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON_REAR));
		REACH = new ShunosaurusSkeletonReachModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON_REACH));
		BROWSE = new ShunosaurusSkeletonBrowseModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON_BROWSE));
		GRAZE = new ShunosaurusSkeletonGrazeModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON_GRAZE));
		SIT = new ShunosaurusSkeletonSitModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON_SIT));
		SLEEP = new ShunosaurusSkeletonSleepModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON_SLEEP));
		DEATH = new ShunosaurusSkeletonDeadModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKELETON_DEATH));
	}
	
	protected void scale(ShunosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		model = switch (entityIn.getPoseName()) {
		case "WALK" -> WALK;
		case "REAR" -> REAR;
		case "REACH" -> REACH;
		case "BROWSE" -> BROWSE;
		case "GRAZE" -> GRAZE;
		case "SIT" -> SIT;
		case "SLEEP" -> SLEEP;
		case "DEATH" -> DEATH;
		default -> IDLE;
		};
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(ShunosaurusSkeleton entity) {
			return SKELETON;
	}

}
