package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.PlesiohadrosSkeletonChargeModel;
import superlord.prehistoricfauna.client.model.fossil.PlesiohadrosSkeletonDashLeftModel;
import superlord.prehistoricfauna.client.model.fossil.PlesiohadrosSkeletonDashRightModel;
import superlord.prehistoricfauna.client.model.fossil.PlesiohadrosSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.PlesiohadrosSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.PlesiohadrosSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.PlesiohadrosSkeletonWalkingModel;
import superlord.prehistoricfauna.common.entities.fossil.PlesiohadrosSkeletonEntity;

public class PlesiohadrosSkeletonRenderer extends MobRenderer<PlesiohadrosSkeletonEntity, EntityModel<PlesiohadrosSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/plesiohadros_skeleton.png");
	private static final PlesiohadrosSkeletonModel IDLE = new PlesiohadrosSkeletonModel();
	private static final PlesiohadrosSkeletonChargeModel CHARGING = new PlesiohadrosSkeletonChargeModel();
	private static final PlesiohadrosSkeletonDashLeftModel DASHING_LEFT = new PlesiohadrosSkeletonDashLeftModel();
	private static final PlesiohadrosSkeletonDashRightModel DASHING_RIGHT = new PlesiohadrosSkeletonDashRightModel();
	private static final PlesiohadrosSkeletonSittingModel SITTING = new PlesiohadrosSkeletonSittingModel();
	private static final PlesiohadrosSkeletonSleepingModel SLEEPING = new PlesiohadrosSkeletonSleepingModel();
	private static final PlesiohadrosSkeletonWalkingModel WALKING = new PlesiohadrosSkeletonWalkingModel();
	
	public PlesiohadrosSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(PlesiohadrosSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isCharging()) {
			entityModel = CHARGING;
		} else if (entityIn.isDashingLeft()) {
			entityModel = DASHING_LEFT;
		} else if (entityIn.isDashingRight()) {
			entityModel = DASHING_RIGHT;
		} else if (entityIn.isSitting()) {
			entityModel = SITTING;
		} else if (entityIn.isSleeping()) {
			entityModel = SLEEPING;
		} else if (entityIn.isWalking()) {
			entityModel = WALKING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(PlesiohadrosSkeletonEntity entity) {
		return SKELETON;
	}

}
