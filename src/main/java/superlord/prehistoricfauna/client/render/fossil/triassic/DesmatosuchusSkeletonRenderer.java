package superlord.prehistoricfauna.client.render.fossil.triassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkeletonWalkingLeftModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkeletonWalkingRightModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.DesmatosuchusSkeleton;

public class DesmatosuchusSkeletonRenderer extends MobRenderer<DesmatosuchusSkeleton, EntityModel<DesmatosuchusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/desmatosuchus_skeleton.png");
    private static DesmatosuchusSkeletonModel IDLE;
    private static DesmatosuchusSkeletonWalkingLeftModel WALKING_LEFT;
    private static DesmatosuchusSkeletonWalkingRightModel WALKING_RIGHT;
    private static DesmatosuchusSkeletonSleepingModel SLEEPING;

	public DesmatosuchusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DesmatosuchusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.DESMATOSUCHUS_SKELETON)), 0);
		IDLE = new DesmatosuchusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.DESMATOSUCHUS_SKELETON));
		WALKING_LEFT = new DesmatosuchusSkeletonWalkingLeftModel(renderManagerIn.bakeLayer(ClientEvents.DESMATOSUCHUS_SKELETON_WALKING_LEFT));
		WALKING_RIGHT = new DesmatosuchusSkeletonWalkingRightModel(renderManagerIn.bakeLayer(ClientEvents.DESMATOSUCHUS_SKELETON_WALKING_RIGHT));
		SLEEPING = new DesmatosuchusSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.DESMATOSUCHUS_SKELETON_SLEEPING));
	}
	
	protected void scale(DesmatosuchusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isWalkingLeft()) {
			model = WALKING_LEFT;
		} else if (entityIn.isWalkingRight()) {
			model = WALKING_RIGHT;
		} else if (entityIn.isSleeping()) {
			model = SLEEPING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(DesmatosuchusSkeleton entity) {
			return SKELETON;
	}

}
