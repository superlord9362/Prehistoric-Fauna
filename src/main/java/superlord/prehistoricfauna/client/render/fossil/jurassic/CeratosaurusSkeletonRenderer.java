package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonActionModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonAlertLeftModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonAlertRightModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.CeratosaurusSkeleton;

public class CeratosaurusSkeletonRenderer extends MobRenderer<CeratosaurusSkeleton, EntityModel<CeratosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ceratosaurus_skeleton.png");
    private static CeratosaurusSkeletonModel IDLE;
    private static CeratosaurusSkeletonActionModel ACTION;
    private static CeratosaurusSkeletonAlertLeftModel ALERT_LEFT;
    private static CeratosaurusSkeletonAlertRightModel ALERT_RIGHT;
    private static CeratosaurusSkeletonRestingModel RESTING;

	public CeratosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CeratosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS_SKELETON)), 0);
		IDLE = new CeratosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS_SKELETON));
		ACTION = new CeratosaurusSkeletonActionModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS_SKELETON_ACTION));
		ALERT_LEFT = new CeratosaurusSkeletonAlertLeftModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS_SKELETON_ALERT_LEFT));
		ALERT_RIGHT = new CeratosaurusSkeletonAlertRightModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS_SKELETON_ALERT_RIGHT));
		RESTING = new CeratosaurusSkeletonRestingModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS_SKELETON_RESTING));
	}
	
	protected void scale(CeratosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isAction()) {
			model = ACTION;
		} else if (entityIn.isAlertLeft()) {
			model = ALERT_LEFT;
		} else if (entityIn.isAlertRight()) {
			model = ALERT_RIGHT;
		} else if (entityIn.isResting()) {
			model = RESTING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(CeratosaurusSkeleton entity) {
			return SKELETON;
	}

}
