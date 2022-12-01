package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.SarahsaurusSkeletonEatingModel;
import superlord.prehistoricfauna.client.model.fossil.SarahsaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.SarahsaurusSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.SarahsaurusSkeletonWalkingModel;
import superlord.prehistoricfauna.common.entities.fossil.SarahsaurusSkeletonEntity;

public class SarahsaurusSkeletonRenderer extends MobRenderer<SarahsaurusSkeletonEntity, EntityModel<SarahsaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/sarahsaurus_skeleton.png");
	private static final SarahsaurusSkeletonModel IDLE = new SarahsaurusSkeletonModel();
	private static final SarahsaurusSkeletonEatingModel EATING = new SarahsaurusSkeletonEatingModel();
	private static final SarahsaurusSkeletonWalkingModel WALKING = new SarahsaurusSkeletonWalkingModel();
	private static final SarahsaurusSkeletonSittingModel SITTING = new SarahsaurusSkeletonSittingModel();
	
	public SarahsaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(SarahsaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isEating()) {
			entityModel = EATING;
		} else if (entityIn.isSitting()) {
			entityModel = SITTING;
		} else if (entityIn.isWalking()) {
			entityModel = WALKING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(SarahsaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
