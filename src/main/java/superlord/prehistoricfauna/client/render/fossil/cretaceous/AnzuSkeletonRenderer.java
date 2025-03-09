package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.*;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnzuSkeleton;

public class AnzuSkeletonRenderer extends MobRenderer<AnzuSkeleton, EntityModel<AnzuSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/anzu_skeleton.png");
    private static AnzuSkeletonModel IDLE;
    private static AnzuSkeletonRearModel REAR;
    private static AnzuSkeletonRompModel ROMP;
    private static AnzuSkeletonFleeModel FLEE;
    private static AnzuSkeletonSkulkModel SKULK;
    private static AnzuSkeletonDisplayModel DISPLAY;
    private static AnzuSkeletonBowModel BOW;
    private static AnzuSkeletonSitModel SIT;
    private static AnzuSkeletonSleepModel SLEEP;
    private static AnzuSkeletonDeathModel DEATH;

	public AnzuSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AnzuSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON)), 0);
		IDLE = new AnzuSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON));
		REAR = new AnzuSkeletonRearModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON_REAR));
		ROMP = new AnzuSkeletonRompModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON_ROMP));
		FLEE = new AnzuSkeletonFleeModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON_FLEE));
		SKULK = new AnzuSkeletonSkulkModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON_SKULK));
		DISPLAY = new AnzuSkeletonDisplayModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON_DISPLAY));
		BOW = new AnzuSkeletonBowModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON_BOW));
		SIT = new AnzuSkeletonSitModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON_SIT));
		SLEEP = new AnzuSkeletonSleepModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON_SLEEP));
		DEATH = new AnzuSkeletonDeathModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKELETON_DEATH));
	}
	
	protected void scale(AnzuSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isRear()) {
			model = REAR;
		} else if (entityIn.isRomp()) {
			model = ROMP;
		} else if (entityIn.isFlee()) {
			model = FLEE;
		} else if (entityIn.isSkulk()) {
			model = SKULK;
		} else if (entityIn.isDisplay()) {
			model = DISPLAY;
		} else if (entityIn.isBow()) {
			model = BOW;
		} else if (entityIn.isSit()) {
			model = SIT;
		} else if (entityIn.isSleep()) {
			model = SLEEP;
		} else if (entityIn.isDeath()) {
			model = DEATH;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(AnzuSkeleton entity) {
			return SKELETON;
	}

}
