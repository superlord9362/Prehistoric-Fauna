package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.TyrannosaurusrexskeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.TyrannosaurusrexskeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.TyrannosaurusrexskeletonJPModel;
import superlord.prehistoricfauna.client.model.fossil.TyrannosaurusrexskeletonModel;
import superlord.prehistoricfauna.client.model.fossil.TyrannosaurusrexskeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.TyrannosaurusrexskeletontripodModel;
import superlord.prehistoricfauna.common.entities.fossil.TyrannosaurusSkeletonEntity;

public class TyrannosaurusSkeletonRenderer extends MobRenderer<TyrannosaurusSkeletonEntity, EntityModel<TyrannosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/tyrannosaurus.png");
	private static final TyrannosaurusrexskeletonModel IDLE = new TyrannosaurusrexskeletonModel();
	private static final TyrannosaurusrexskeletonActionLeftModel ACTION_LEFT = new TyrannosaurusrexskeletonActionLeftModel();
	private static final TyrannosaurusrexskeletonActionRightModel ACTION_RIGHT = new TyrannosaurusrexskeletonActionRightModel();
	private static final TyrannosaurusrexskeletonSittingModel RESTING = new TyrannosaurusrexskeletonSittingModel();
	private static final TyrannosaurusrexskeletontripodModel CLASSICAL = new TyrannosaurusrexskeletontripodModel();
	private static final TyrannosaurusrexskeletonJPModel JP = new TyrannosaurusrexskeletonJPModel();
	
	public TyrannosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(TyrannosaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isActionLeft()) {
			entityModel = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			entityModel = ACTION_RIGHT;
		} else if (entityIn.isResting()) {
			entityModel = RESTING;
		} else if (entityIn.isClassical()) {
			entityModel = CLASSICAL;
		} else if (entityIn.isJurassicParkReference()) {
			entityModel = JP;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(TyrannosaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
