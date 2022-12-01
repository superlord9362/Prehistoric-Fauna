package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.DesmatosuchusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.DesmatosuchusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.DesmatosuchusSkeletonWalkingLeftModel;
import superlord.prehistoricfauna.client.model.fossil.DesmatosuchusSkeletonWalkingRightModel;
import superlord.prehistoricfauna.common.entities.fossil.DesmatosuchusSkeletonEntity;

public class DesmatosuchusSkeletonRenderer extends MobRenderer<DesmatosuchusSkeletonEntity, EntityModel<DesmatosuchusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/desmatosuchus_skeleton.png");
	private static final DesmatosuchusSkeletonModel IDLE = new DesmatosuchusSkeletonModel();
	private static final DesmatosuchusSkeletonSleepingModel SLEEPING = new DesmatosuchusSkeletonSleepingModel();
	private static final DesmatosuchusSkeletonWalkingLeftModel WALKING_LEFT = new DesmatosuchusSkeletonWalkingLeftModel();
	private static final DesmatosuchusSkeletonWalkingRightModel WALKING_RIGHT = new DesmatosuchusSkeletonWalkingRightModel();
	
	public DesmatosuchusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(DesmatosuchusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isWalkingLeft()) {
			entityModel = WALKING_LEFT;
		} else if (entityIn.isWalkingRight()) {
			entityModel = WALKING_RIGHT;
		} else if (entityIn.isSleeping()) {
			entityModel = SLEEPING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(DesmatosuchusSkeletonEntity entity) {
		return SKELETON;
	}

}
