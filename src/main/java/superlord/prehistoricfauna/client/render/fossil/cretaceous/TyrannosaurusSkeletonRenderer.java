package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonJPModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonRetroModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonSittingModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TyrannosaurusSkeleton;

public class TyrannosaurusSkeletonRenderer extends MobRenderer<TyrannosaurusSkeleton, EntityModel<TyrannosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/tyrannosaurus.png");
    private static TyrannosaurusSkeletonModel IDLE;
    private static TyrannosaurusSkeletonActionLeftModel ACTION_LEFT;
    private static TyrannosaurusSkeletonActionRightModel ACTION_RIGHT;
    private static TyrannosaurusSkeletonSittingModel SITTING;
    private static TyrannosaurusSkeletonRetroModel RETRO;
    private static TyrannosaurusSkeletonJPModel JP;

	public TyrannosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TyrannosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_SKELETON)), 0);
		IDLE = new TyrannosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_SKELETON));
		ACTION_LEFT = new TyrannosaurusSkeletonActionLeftModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_SKELETON_ACTION_LEFT));
		ACTION_RIGHT = new TyrannosaurusSkeletonActionRightModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_SKELETON_ACTION_LEFT));
		RETRO = new TyrannosaurusSkeletonRetroModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_SKELETON_RETRO));
		SITTING = new TyrannosaurusSkeletonSittingModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_SKELETON_SITTING));
		JP = new TyrannosaurusSkeletonJPModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_SKELETON_JP));
	}
	
	protected void scale(TyrannosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isResting()) {
			model = SITTING;
		} else if (entityIn.isClassical()) {
			model = RETRO;
		} else if (entityIn.isActionLeft()) {
			model = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			model = ACTION_RIGHT;
		} else if (entityIn.isJurassicParkReference()) {
			model = JP;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(TyrannosaurusSkeleton entity) {
			return SKELETON;
	}

}
