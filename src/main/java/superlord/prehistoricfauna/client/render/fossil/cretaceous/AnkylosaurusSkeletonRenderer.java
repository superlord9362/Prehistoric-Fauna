package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonSquattingModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnkylosaurusSkeleton;

public class AnkylosaurusSkeletonRenderer extends MobRenderer<AnkylosaurusSkeleton, EntityModel<AnkylosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ankylosaurus_skeleton.png");
    private static AnkylosaurusSkeletonModel IDLE;
    private static AnkylosaurusSkeletonSquattingModel SQUATTING;
    private static AnkylosaurusSkeletonActionLeftModel ACTION_LEFT;
    private static AnkylosaurusSkeletonActionRightModel ACTION_RIGHT;
    private static AnkylosaurusSkeletonRestingModel RESTING;

	public AnkylosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AnkylosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS_SKELETON)), 0);
		IDLE = new AnkylosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS_SKELETON));
		SQUATTING = new AnkylosaurusSkeletonSquattingModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS_SKELETON_SQUATTING));
		ACTION_LEFT = new AnkylosaurusSkeletonActionLeftModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS_SKELETON_ACTION_LEFT));
		ACTION_RIGHT = new AnkylosaurusSkeletonActionRightModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS_SKELETON_ACTION_RIGHT));
		RESTING = new AnkylosaurusSkeletonRestingModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS_SKELETON_RESTING));
	}
	
	protected void scale(AnkylosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isSquatting()) {
			model = SQUATTING;
		} else if (entityIn.isActionLeft()) {
			model = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			model = ACTION_RIGHT;
		} else if (entityIn.isResting()) {
			model = RESTING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(AnkylosaurusSkeleton entity) {
			return SKELETON;
	}

}
