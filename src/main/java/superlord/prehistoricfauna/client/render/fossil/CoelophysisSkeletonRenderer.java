package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.CoelophysisSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.CoelophysisSkeletonSaunterModel;
import superlord.prehistoricfauna.client.model.fossil.CoelophysisSkeletonSeizeModel;
import superlord.prehistoricfauna.client.model.fossil.CoelophysisSkeletonSlainModel;
import superlord.prehistoricfauna.client.model.fossil.CoelophysisSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.CoelophysisSkeletonSlumpModel;
import superlord.prehistoricfauna.client.model.fossil.CoelophysisSkeletonStrideModel;
import superlord.prehistoricfauna.common.entities.fossil.CoelophysisSkeletonEntity;

public class CoelophysisSkeletonRenderer extends MobRenderer<CoelophysisSkeletonEntity, EntityModel<CoelophysisSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/coelophysis_skeleton.png");
	private static final CoelophysisSkeletonModel IDLE = new CoelophysisSkeletonModel();
	private static final CoelophysisSkeletonSeizeModel SEIZING = new CoelophysisSkeletonSeizeModel();
	private static final CoelophysisSkeletonSlainModel SLAIN = new CoelophysisSkeletonSlainModel();
	private static final CoelophysisSkeletonSaunterModel SAUNTERING = new CoelophysisSkeletonSaunterModel();
	private static final CoelophysisSkeletonSleepingModel SLEEPING = new CoelophysisSkeletonSleepingModel();
	private static final CoelophysisSkeletonSlumpModel SLUMP = new CoelophysisSkeletonSlumpModel();
	private static final CoelophysisSkeletonStrideModel STRIDE = new CoelophysisSkeletonStrideModel();
	
	public CoelophysisSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(CoelophysisSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isSlain()) {
			entityModel = SLAIN;
		} else if (entityIn.isSeizing()) {
			entityModel = SEIZING;
		} else if (entityIn.isSauntering()) {
			entityModel = SAUNTERING;
		} else if (entityIn.isSleeping()) {
			entityModel = SLEEPING;
		} else if (entityIn.isStride()) {
			entityModel = STRIDE;
		} else if (entityIn.isSlump()) {
			entityModel = SLUMP;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(CoelophysisSkeletonEntity entity) {
		return SKELETON;
	}

}
