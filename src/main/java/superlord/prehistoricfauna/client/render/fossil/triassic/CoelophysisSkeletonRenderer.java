package superlord.prehistoricfauna.client.render.fossil.triassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSaunterModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSeizeModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSlainModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSlumpModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonStrideModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.CoelophysisSkeleton;

public class CoelophysisSkeletonRenderer extends MobRenderer<CoelophysisSkeleton, EntityModel<CoelophysisSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/coelophysis_skeleton.png");
    private static CoelophysisSkeletonModel IDLE;
    private static CoelophysisSkeletonSaunterModel SAUNTER;
    private static CoelophysisSkeletonSeizeModel SEIZE;
    private static CoelophysisSkeletonSlainModel SLAIN;
    private static CoelophysisSkeletonSleepingModel SLEEPING;
    private static CoelophysisSkeletonSlumpModel SLUMP;
    private static CoelophysisSkeletonStrideModel STRIDE;

	public CoelophysisSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CoelophysisSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS_SKELETON)), 0);
		IDLE = new CoelophysisSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS_SKELETON));
		SAUNTER = new CoelophysisSkeletonSaunterModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS_SKELETON_SAUNTER));
		SEIZE = new CoelophysisSkeletonSeizeModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS_SKELETON_SEIZE));
		SLAIN = new CoelophysisSkeletonSlainModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS_SKELETON_SLAIN));
		SLEEPING = new CoelophysisSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS_SKELETON_SLEEPING));
		SLUMP = new CoelophysisSkeletonSlumpModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS_SKELETON_SLUMP));
		STRIDE = new CoelophysisSkeletonStrideModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS_SKELETON_STRIDE));
	}
	
	protected void scale(CoelophysisSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isSauntering()) {
			model = SAUNTER;
		} else if (entityIn.isSeizing()) {
			model = SEIZE;
		} else if (entityIn.isSlain()) {
			model = SLAIN;
		} else if (entityIn.isSleeping()) {
			model = SLEEPING;
		} else if (entityIn.isSlumped()) {
			model = SLUMP;
		} else if (entityIn.isStriding()) {
			model = STRIDE;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(CoelophysisSkeleton entity) {
			return SKELETON;
	}

}
