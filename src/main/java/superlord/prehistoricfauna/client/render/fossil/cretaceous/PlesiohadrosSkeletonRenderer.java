package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonChargeModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonDashLeftModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonDashRightModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonWalkingModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.PlesiohadrosSkeleton;

public class PlesiohadrosSkeletonRenderer extends MobRenderer<PlesiohadrosSkeleton, EntityModel<PlesiohadrosSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/plesiohadros_skeleton.png");
    private static PlesiohadrosSkeletonModel IDLE;
    private static PlesiohadrosSkeletonChargeModel CHARGE;
    private static PlesiohadrosSkeletonDashLeftModel DASH_LEFT;
    private static PlesiohadrosSkeletonDashRightModel DASH_RIGHT;
    private static PlesiohadrosSkeletonSittingModel SITTING;
    private static PlesiohadrosSkeletonSleepingModel SLEEPING;
    private static PlesiohadrosSkeletonWalkingModel WALKING;

	public PlesiohadrosSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PlesiohadrosSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_SKELETON)), 0);
		IDLE = new PlesiohadrosSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_SKELETON));
		CHARGE = new PlesiohadrosSkeletonChargeModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_SKELETON_CHARGE));
		DASH_LEFT = new PlesiohadrosSkeletonDashLeftModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_SKELETON_DASH_LEFT));
		DASH_RIGHT = new PlesiohadrosSkeletonDashRightModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_SKELETON_DASH_RIGHT));
		SITTING = new PlesiohadrosSkeletonSittingModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_SKELETON_SITTING));
		SLEEPING = new PlesiohadrosSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_SKELETON_SLEEPING));
		WALKING = new PlesiohadrosSkeletonWalkingModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_SKELETON_WALKING));
	}
	
	protected void scale(PlesiohadrosSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isCharging()) {
			model = CHARGE;
		} else if (entityIn.isDashingLeft()) {
			model = DASH_LEFT;
		} else if (entityIn.isDashingRight()) {
			model = DASH_RIGHT;
		} else if (entityIn.isSitting()) {
			model = SITTING;
		} else if (entityIn.isSleeping()) {
			model = SLEEPING;
		} else if (entityIn.isWalking()) {
			model = WALKING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(PlesiohadrosSkeleton entity) {
			return SKELETON;
	}

}
