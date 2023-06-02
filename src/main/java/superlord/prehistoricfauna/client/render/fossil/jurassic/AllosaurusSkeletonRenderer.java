package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonRetroModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.AllosaurusSkeleton;

public class AllosaurusSkeletonRenderer extends MobRenderer<AllosaurusSkeleton, EntityModel<AllosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/allosaurus_skeleton.png");
    private static AllosaurusSkeletonModel IDLE;
    private static AllosaurusSkeletonRetroModel RETRO;
    private static AllosaurusSkeletonActionLeftModel ACTION_LEFT;
    private static AllosaurusSkeletonActionRightModel ACTION_RIGHT;
    private static AllosaurusSkeletonRestingModel RESTING;

	public AllosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AllosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS_SKELETON)), 0);
		IDLE = new AllosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS_SKELETON));
		RETRO = new AllosaurusSkeletonRetroModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS_SKELETON_RETRO));
		ACTION_LEFT = new AllosaurusSkeletonActionLeftModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS_SKELETON_ACTION_LEFT));
		ACTION_RIGHT = new AllosaurusSkeletonActionRightModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS_SKELETON_ACTION_RIGHT));
		RESTING = new AllosaurusSkeletonRestingModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS_SKELETON_RESTING));
	}
	
	protected void scale(AllosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isClassical()) {
			model = RETRO;
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
	public ResourceLocation getTextureLocation(AllosaurusSkeleton entity) {
			return SKELETON;
	}

}
