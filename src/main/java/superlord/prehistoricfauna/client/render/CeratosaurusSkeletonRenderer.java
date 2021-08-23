package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeletonActionModel;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeletonAlertLeftModel;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeletonAlertRightModel;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.common.entities.CeratosaurusSkeletonEntity;

public class CeratosaurusSkeletonRenderer extends MobRenderer<CeratosaurusSkeletonEntity, EntityModel<CeratosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ceratosaurus_skeleton.png");
	private static final CeratosaurusSkeletonModel IDLE = new CeratosaurusSkeletonModel();
	private static final CeratosaurusSkeletonActionModel ACTION = new CeratosaurusSkeletonActionModel();
	private static final CeratosaurusSkeletonRestingModel RESTING = new CeratosaurusSkeletonRestingModel();
	private static final CeratosaurusSkeletonAlertRightModel RIGHT = new CeratosaurusSkeletonAlertRightModel();
	private static final CeratosaurusSkeletonAlertLeftModel LEFT = new CeratosaurusSkeletonAlertLeftModel();
	
	public CeratosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE,  0.75F);
	}
	
	public void render(CeratosaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAction()) {
			entityModel = ACTION;
		} else if (entityIn.isResting()) {
			entityModel = RESTING;
		} else if (entityIn.isAlertLeft()) {
			entityModel = LEFT;
		} else if (entityIn.isAlertRight()) {
			entityModel = RIGHT;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(CeratosaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
