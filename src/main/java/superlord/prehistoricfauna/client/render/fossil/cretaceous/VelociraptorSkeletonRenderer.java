package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonFlashingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonLayFightingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonRunningModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonStandFightingModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.VelociraptorSkeleton;

public class VelociraptorSkeletonRenderer extends MobRenderer<VelociraptorSkeleton, EntityModel<VelociraptorSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/velociraptor_skeleton.png");
    private static VelociraptorSkeletonModel IDLE;
    private static VelociraptorSkeletonFlashingModel FLASHING;
    private static VelociraptorSkeletonLayFightingModel LAY_FIGHTING;
    private static VelociraptorSkeletonRunningModel RUNNING;
    private static VelociraptorSkeletonSleepingModel SLEEPING;
    private static VelociraptorSkeletonStandFightingModel STAND_FIGHTING;

	public VelociraptorSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new VelociraptorSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.VELOCIRAPTOR_SKELETON)), 0);
		IDLE = new VelociraptorSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.VELOCIRAPTOR_SKELETON));
		FLASHING = new VelociraptorSkeletonFlashingModel(renderManagerIn.bakeLayer(ClientEvents.VELOCIRAPTOR_SKELETON_FLASHING));
		LAY_FIGHTING = new VelociraptorSkeletonLayFightingModel(renderManagerIn.bakeLayer(ClientEvents.VELOCIRAPTOR_SKELETON_LAY_FIGHTING));
		RUNNING = new VelociraptorSkeletonRunningModel(renderManagerIn.bakeLayer(ClientEvents.VELOCIRAPTOR_SKELETON_RUNNING));
		SLEEPING = new VelociraptorSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.VELOCIRAPTOR_SKELETON_SLEEPING));
		STAND_FIGHTING = new VelociraptorSkeletonStandFightingModel(renderManagerIn.bakeLayer(ClientEvents.VELOCIRAPTOR_SKELETON_STAND_FIGHTING));
	}
	
	protected void scale(VelociraptorSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isFlashing()) {
			model = FLASHING;
		} else if (entityIn.isLayFighting()) {
			model = LAY_FIGHTING;
		} else if (entityIn.isRunning()) {
			model = RUNNING;
		} else if (entityIn.isSleeping()) {
			model = SLEEPING;
		} else if (entityIn.isStandFighting()) {
			model = STAND_FIGHTING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(VelociraptorSkeleton entity) {
			return SKELETON;
	}

}
