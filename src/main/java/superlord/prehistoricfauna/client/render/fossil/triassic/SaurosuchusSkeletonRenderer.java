package superlord.prehistoricfauna.client.render.fossil.triassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkeletonSleepingModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.SaurosuchusSkeleton;

public class SaurosuchusSkeletonRenderer extends MobRenderer<SaurosuchusSkeleton, EntityModel<SaurosuchusSkeleton>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/saurosuchus_skeleton.png");
	private static SaurosuchusSkeletonModel IDLE;
	private static SaurosuchusSkeletonActionRightModel ACTION_RIGHT;
	private static SaurosuchusSkeletonActionLeftModel ACTION_LEFT;
	private static SaurosuchusSkeletonSleepingModel SLEEPING;

	public SaurosuchusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SaurosuchusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.SAUROSUCHUS_SKELETON)), 0);
		IDLE = new SaurosuchusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.SAUROSUCHUS_SKELETON));
		ACTION_RIGHT = new SaurosuchusSkeletonActionRightModel(renderManagerIn.bakeLayer(ClientEvents.SAUROSUCHUS_SKELETON_ACTION_RIGHT));
		ACTION_LEFT = new SaurosuchusSkeletonActionLeftModel(renderManagerIn.bakeLayer(ClientEvents.SAUROSUCHUS_SKELETON_ACTION_LEFT));
		SLEEPING = new SaurosuchusSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.SAUROSUCHUS_SKELETON_SLEEPING));
	}

	protected void scale(SaurosuchusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isActionLeft()) {
			model = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			model = ACTION_RIGHT;
		} else if (entityIn.isResting()) {
			model = SLEEPING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(SaurosuchusSkeleton entity) {
		return SKELETON;
	}

}
