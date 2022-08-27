package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.AnkylosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.AnkylosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.AnkylosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.AnkylosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.client.model.fossil.AnkylosaurusSkeletonSquatModel;
import superlord.prehistoricfauna.common.entities.fossil.AnkylosaurusSkeletonEntity;

public class AnkylosaurusSkeletonRenderer extends MobRenderer<AnkylosaurusSkeletonEntity, EntityModel<AnkylosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ankylosaurus_skeleton.png");
	private static final AnkylosaurusSkeletonModel IDLE = new AnkylosaurusSkeletonModel();
	private static final AnkylosaurusSkeletonActionLeftModel ACTION_LEFT = new AnkylosaurusSkeletonActionLeftModel();
	private static final AnkylosaurusSkeletonActionRightModel ACTION_RIGHT = new AnkylosaurusSkeletonActionRightModel();
	private static final AnkylosaurusSkeletonRestingModel RESTING = new AnkylosaurusSkeletonRestingModel();
	private static final AnkylosaurusSkeletonSquatModel SQUATTING = new AnkylosaurusSkeletonSquatModel();
	
	public AnkylosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(AnkylosaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isActionLeft()) {
			entityModel = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			entityModel = ACTION_RIGHT;
		} else if (entityIn.isResting()) {
			entityModel = RESTING;
		} else if (entityIn.isSquatting()) {
			entityModel = SQUATTING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(AnkylosaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
