package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonRetroModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonSleepingModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.StegosaurusSkeleton;

public class StegosaurusSkeletonRenderer extends MobRenderer<StegosaurusSkeleton, EntityModel<StegosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/stegosaurus_skeleton.png");
    private static StegosaurusSkeletonModel IDLE;
    private static StegosaurusSkeletonActionLeftModel ACTION_LEFT;
    private static StegosaurusSkeletonActionRightModel ACTION_RIGHT;
    private static StegosaurusSkeletonSleepingModel SLEEPING;
    private static StegosaurusSkeletonRetroModel RETRO;
    
	public StegosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new StegosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.STEGOSAURUS_SKELETON)), 0);
		IDLE = new StegosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.STEGOSAURUS_SKELETON));
		ACTION_LEFT = new StegosaurusSkeletonActionLeftModel(renderManagerIn.bakeLayer(ClientEvents.STEGOSAURUS_SKELETON_ACTION_LEFT));
		ACTION_RIGHT = new StegosaurusSkeletonActionRightModel(renderManagerIn.bakeLayer(ClientEvents.STEGOSAURUS_SKELETON_ACTION_RIGHT));
		RETRO = new StegosaurusSkeletonRetroModel(renderManagerIn.bakeLayer(ClientEvents.STEGOSAURUS_SKELETON_RETRO));
		SLEEPING = new StegosaurusSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.STEGOSAURUS_SKELETON_SLEEPING));
	}
	
	protected void scale(StegosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isActionLeft()) {
			model = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			model = ACTION_RIGHT;
		} else if (entityIn.isClassical()) {
			model = RETRO;
		} else if (entityIn.isResting()) {
			model = SLEEPING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(StegosaurusSkeleton entity) {
			return SKELETON;
	}

}
