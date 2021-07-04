package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Tyrannosaurusrexskeleton;
import superlord.prehistoricfauna.client.model.TyrannosaurusrexskeletonActionLeft;
import superlord.prehistoricfauna.client.model.TyrannosaurusrexskeletonActionRight;
import superlord.prehistoricfauna.client.model.TyrannosaurusrexskeletonJP;
import superlord.prehistoricfauna.client.model.TyrannosaurusrexskeletonSitting;
import superlord.prehistoricfauna.client.model.Tyrannosaurusrexskeletontripod;
import superlord.prehistoricfauna.common.entities.TyrannosaurusSkeletonEntity;

public class TyrannosaurusSkeletonRenderer extends MobRenderer<TyrannosaurusSkeletonEntity, EntityModel<TyrannosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/tyrannosaurus.png");
	private static final Tyrannosaurusrexskeleton IDLE = new Tyrannosaurusrexskeleton();
	private static final TyrannosaurusrexskeletonActionLeft ACTION_LEFT = new TyrannosaurusrexskeletonActionLeft();
	private static final TyrannosaurusrexskeletonActionRight ACTION_RIGHT = new TyrannosaurusrexskeletonActionRight();
	private static final TyrannosaurusrexskeletonSitting RESTING = new TyrannosaurusrexskeletonSitting();
	private static final Tyrannosaurusrexskeletontripod CLASSICAL = new Tyrannosaurusrexskeletontripod();
	private static final TyrannosaurusrexskeletonJP JP = new TyrannosaurusrexskeletonJP();
	
	public TyrannosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 2F);
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
