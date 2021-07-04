package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeleton;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeletonAction;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeletonAlertLeft;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeletonAlertRight;
import superlord.prehistoricfauna.client.model.CeratosaurusSkeletonResting;
import superlord.prehistoricfauna.common.entities.CeratosaurusSkeletonEntity;

public class CeratosaurusSkeletonRenderer extends MobRenderer<CeratosaurusSkeletonEntity, EntityModel<CeratosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ceratosaurus_skeleton.png");
	private static final CeratosaurusSkeleton IDLE = new CeratosaurusSkeleton();
	private static final CeratosaurusSkeletonAction ACTION = new CeratosaurusSkeletonAction();
	private static final CeratosaurusSkeletonResting RESTING = new CeratosaurusSkeletonResting();
	private static final CeratosaurusSkeletonAlertRight RIGHT = new CeratosaurusSkeletonAlertRight();
	private static final CeratosaurusSkeletonAlertLeft LEFT = new CeratosaurusSkeletonAlertLeft();
	
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
