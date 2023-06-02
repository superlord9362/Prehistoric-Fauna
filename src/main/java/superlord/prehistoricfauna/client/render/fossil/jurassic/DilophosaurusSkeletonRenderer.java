package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonAttackModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonGazeModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonStrutModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.DilophosaurusSkeleton;

public class DilophosaurusSkeletonRenderer extends MobRenderer<DilophosaurusSkeleton, EntityModel<DilophosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/dilophosaurus_skeleton.png");
    private static DilophosaurusSkeletonModel IDLE;
    private static DilophosaurusSkeletonAttackModel ATTACK;
    private static DilophosaurusSkeletonGazeModel GAZE;
    private static DilophosaurusSkeletonSittingModel SITTING;
    private static DilophosaurusSkeletonStrutModel STRUT;

	public DilophosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DilophosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS_SKELETON)), 0);
		IDLE = new DilophosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS_SKELETON));
		ATTACK = new DilophosaurusSkeletonAttackModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS_SKELETON_ATTACK));
		GAZE = new DilophosaurusSkeletonGazeModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS_SKELETON_GAZE));
		SITTING = new DilophosaurusSkeletonSittingModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS_SKELETON_SITTING));
		STRUT = new DilophosaurusSkeletonStrutModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS_SKELETON_STRUT));
	}
	
	protected void scale(DilophosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isAttacking()) {
			model = ATTACK;
		} else if (entityIn.isGazing()) {
			model = GAZE;
		} else if (entityIn.isSitting()) {
			model = SITTING;
		} else if (entityIn.isStrutting()) {
			model = STRUT;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(DilophosaurusSkeleton entity) {
			return SKELETON;
	}

}
