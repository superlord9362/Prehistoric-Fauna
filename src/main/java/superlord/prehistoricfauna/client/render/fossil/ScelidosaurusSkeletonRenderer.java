package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.ScelidosaurusSkeletonDashingModel;
import superlord.prehistoricfauna.client.model.fossil.ScelidosaurusSkeletonGrazingModel;
import superlord.prehistoricfauna.client.model.fossil.ScelidosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.ScelidosaurusSkeletonReachingModel;
import superlord.prehistoricfauna.client.model.fossil.ScelidosaurusSkeletonWalkingModel;
import superlord.prehistoricfauna.client.model.fossil.ScelidosaurusSleepingSkeletonModel;
import superlord.prehistoricfauna.common.entities.fossil.ScelidosaurusSkeletonEntity;

public class ScelidosaurusSkeletonRenderer extends MobRenderer<ScelidosaurusSkeletonEntity, EntityModel<ScelidosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/scelidosaurus_skeleton.png");
	private static final ScelidosaurusSkeletonModel IDLE = new ScelidosaurusSkeletonModel();
	private static final ScelidosaurusSleepingSkeletonModel SLEEPING = new ScelidosaurusSleepingSkeletonModel();
	private static final ScelidosaurusSkeletonGrazingModel GRAZING = new ScelidosaurusSkeletonGrazingModel();
	private static final ScelidosaurusSkeletonWalkingModel WALKING = new ScelidosaurusSkeletonWalkingModel();
	private static final ScelidosaurusSkeletonDashingModel DASHING = new ScelidosaurusSkeletonDashingModel();
	private static final ScelidosaurusSkeletonReachingModel REACHING = new ScelidosaurusSkeletonReachingModel();
	
	public ScelidosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(ScelidosaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isGrazing()) {
			entityModel = GRAZING;
		} else if (entityIn.isWalking()) {
			entityModel = WALKING;
		} else if (entityIn.isSleeping()) {
			entityModel = SLEEPING;
		} else if (entityIn.isDashing()) {
			entityModel = DASHING;
		} else if (entityIn.isReaching()) {
			entityModel = REACHING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(ScelidosaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
