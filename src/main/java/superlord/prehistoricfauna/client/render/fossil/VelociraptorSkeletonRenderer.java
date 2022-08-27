package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.VelociraptorSkeletonFlashingModel;
import superlord.prehistoricfauna.client.model.fossil.VelociraptorSkeletonLayFightingModel;
import superlord.prehistoricfauna.client.model.fossil.VelociraptorSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.VelociraptorSkeletonRunningModel;
import superlord.prehistoricfauna.client.model.fossil.VelociraptorSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.VelociraptorSkeletonStandFightingModel;
import superlord.prehistoricfauna.common.entities.fossil.VelociraptorSkeletonEntity;

public class VelociraptorSkeletonRenderer extends MobRenderer<VelociraptorSkeletonEntity, EntityModel<VelociraptorSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/velociraptor_skeleton.png");
	private static final VelociraptorSkeletonModel IDLE = new VelociraptorSkeletonModel();
	private static final VelociraptorSkeletonFlashingModel FLASHING = new VelociraptorSkeletonFlashingModel();
	private static final VelociraptorSkeletonLayFightingModel LAY_FIGHTING = new VelociraptorSkeletonLayFightingModel();
	private static final VelociraptorSkeletonStandFightingModel STAND_FIGHTING = new VelociraptorSkeletonStandFightingModel();
	private static final VelociraptorSkeletonRunningModel RUNNING = new VelociraptorSkeletonRunningModel();
	private static final VelociraptorSkeletonSleepingModel SLEEPING = new VelociraptorSkeletonSleepingModel();
	
	public VelociraptorSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(VelociraptorSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isFlashing()) {
			entityModel = FLASHING;
		} else if (entityIn.isLayFighting()) {
			entityModel = LAY_FIGHTING;
		} else if (entityIn.isStandFighting()) {
			entityModel = STAND_FIGHTING;
		} else if (entityIn.isRunning()) {
			entityModel = RUNNING;
		} else if (entityIn.isSleeping()) {
			entityModel = SLEEPING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(VelociraptorSkeletonEntity entity) {
		return SKELETON;
	}

}
