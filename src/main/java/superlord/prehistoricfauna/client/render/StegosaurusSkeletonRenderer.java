package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.StegosaurusSkeleton;
import superlord.prehistoricfauna.client.model.StegosaurusSkeletonActionLeft;
import superlord.prehistoricfauna.client.model.StegosaurusSkeletonActionRight;
import superlord.prehistoricfauna.client.model.StegosaurusSkeletonResting;
import superlord.prehistoricfauna.client.model.StegosaurusSkeletonRetro;
import superlord.prehistoricfauna.common.entities.StegosaurusSkeletonEntity;

public class StegosaurusSkeletonRenderer extends MobRenderer<StegosaurusSkeletonEntity, EntityModel<StegosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/stegosaurus_skeleton.png");
	private static final StegosaurusSkeleton IDLE = new StegosaurusSkeleton();
	private static final StegosaurusSkeletonRetro RETRO = new StegosaurusSkeletonRetro();
	private static final StegosaurusSkeletonResting RESTING = new StegosaurusSkeletonResting();
	private static final StegosaurusSkeletonActionRight RIGHT = new StegosaurusSkeletonActionRight();
	private static final StegosaurusSkeletonActionLeft LEFT = new StegosaurusSkeletonActionLeft();
	
	public StegosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE,  0.75F);
	}
	
	public void render(StegosaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isRetro()) {
			entityModel = RETRO;
		} else if (entityIn.isResting()) {
			entityModel = RESTING;
		} else if (entityIn.isActionLeft()) {
			entityModel = LEFT;
		} else if (entityIn.isActionRight()) {
			entityModel = RIGHT;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(StegosaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
