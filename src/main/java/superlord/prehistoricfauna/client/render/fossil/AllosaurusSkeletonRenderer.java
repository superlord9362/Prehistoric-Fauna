package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.AllosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.AllosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.AllosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.AllosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.client.model.fossil.AllosaurusSkeletonRetroModel;
import superlord.prehistoricfauna.common.entities.fossil.AllosaurusSkeletonEntity;

public class AllosaurusSkeletonRenderer extends MobRenderer<AllosaurusSkeletonEntity, EntityModel<AllosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/allosaurus_skeleton.png");
	private static final AllosaurusSkeletonModel IDLE = new AllosaurusSkeletonModel();
	private static final AllosaurusSkeletonActionLeftModel ACTION_LEFT = new AllosaurusSkeletonActionLeftModel();
	private static final AllosaurusSkeletonActionRightModel ACTION_RIGHT = new AllosaurusSkeletonActionRightModel();
	private static final AllosaurusSkeletonRestingModel RESTING = new AllosaurusSkeletonRestingModel();
	private static final AllosaurusSkeletonRetroModel CLASSICAL = new AllosaurusSkeletonRetroModel();
	
	public AllosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(AllosaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isActionLeft()) {
			entityModel = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			entityModel = ACTION_RIGHT;
		} else if (entityIn.isResting()) {
			entityModel = RESTING;
		} else if (entityIn.isClassical()) {
			entityModel = CLASSICAL;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(AllosaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
