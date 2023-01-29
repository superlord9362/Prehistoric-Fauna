package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.DilophosaurusSkeletonAttackModel;
import superlord.prehistoricfauna.client.model.fossil.DilophosaurusSkeletonGazeModel;
import superlord.prehistoricfauna.client.model.fossil.DilophosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.DilophosaurusSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.DilophosaurusStrutSkeletonModel;
import superlord.prehistoricfauna.common.entities.fossil.DilophosaurusSkeletonEntity;

public class DilophosaurusSkeletonRenderer extends MobRenderer<DilophosaurusSkeletonEntity, EntityModel<DilophosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/dilophosaurus_skeleton.png");
	private static final DilophosaurusSkeletonModel IDLE = new DilophosaurusSkeletonModel();
	private static final DilophosaurusStrutSkeletonModel STRUT = new DilophosaurusStrutSkeletonModel();
	private static final DilophosaurusSkeletonGazeModel GAZE = new DilophosaurusSkeletonGazeModel();
	private static final DilophosaurusSkeletonAttackModel ATTACK = new DilophosaurusSkeletonAttackModel();
	private static final DilophosaurusSkeletonSittingModel SITTING = new DilophosaurusSkeletonSittingModel();
	
	public DilophosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(DilophosaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isStrutting()) {
			entityModel = STRUT;
		} else if (entityIn.isGazing()) {
			entityModel = GAZE;
		} else if (entityIn.isAttacking()) {
			entityModel = ATTACK;
		} else if (entityIn.isSitting()) {
			entityModel = SITTING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(DilophosaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
