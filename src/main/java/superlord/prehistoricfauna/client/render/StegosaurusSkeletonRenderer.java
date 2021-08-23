package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.StegosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.StegosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.StegosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.StegosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.client.model.StegosaurusSkeletonRetroModel;
import superlord.prehistoricfauna.common.entities.StegosaurusSkeletonEntity;

public class StegosaurusSkeletonRenderer extends MobRenderer<StegosaurusSkeletonEntity, EntityModel<StegosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/stegosaurus_skeleton.png");
	private static final StegosaurusSkeletonModel IDLE = new StegosaurusSkeletonModel();
	private static final StegosaurusSkeletonRetroModel RETRO = new StegosaurusSkeletonRetroModel();
	private static final StegosaurusSkeletonRestingModel RESTING = new StegosaurusSkeletonRestingModel();
	private static final StegosaurusSkeletonActionRightModel RIGHT = new StegosaurusSkeletonActionRightModel();
	private static final StegosaurusSkeletonActionLeftModel LEFT = new StegosaurusSkeletonActionLeftModel();
	
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
