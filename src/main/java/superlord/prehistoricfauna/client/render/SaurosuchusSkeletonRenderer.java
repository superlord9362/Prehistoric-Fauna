package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.SaurosuchusSkeleton;
import superlord.prehistoricfauna.client.model.SaurosuchusSkeletonActionLeft;
import superlord.prehistoricfauna.client.model.SaurosuchusSkeletonActionRight;
import superlord.prehistoricfauna.client.model.SaurosuchusSkeletonSleeping;
import superlord.prehistoricfauna.common.entities.SaurosuchusSkeletonEntity;

public class SaurosuchusSkeletonRenderer extends MobRenderer<SaurosuchusSkeletonEntity, EntityModel<SaurosuchusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/saurosuchus_skeleton.png");
	private static final SaurosuchusSkeleton IDLE = new SaurosuchusSkeleton();
	private static final SaurosuchusSkeletonActionLeft ACTION_LEFT = new SaurosuchusSkeletonActionLeft();
	private static final SaurosuchusSkeletonActionRight ACTION_RIGHT = new SaurosuchusSkeletonActionRight();
	private static final SaurosuchusSkeletonSleeping RESTING = new SaurosuchusSkeletonSleeping();
	
	public SaurosuchusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 1.25F);
	}
	
	public void render(SaurosuchusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isActionLeft()) {
			entityModel = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			entityModel = ACTION_RIGHT;
		} else if (entityIn.isResting()) {
			entityModel = RESTING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(SaurosuchusSkeletonEntity entity) {
		return SKELETON;
	}

}
