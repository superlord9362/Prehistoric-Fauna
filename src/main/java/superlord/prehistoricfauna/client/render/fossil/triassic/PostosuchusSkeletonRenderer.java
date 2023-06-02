package superlord.prehistoricfauna.client.render.fossil.triassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonAttackLeftModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonAttackModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonCuriousModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonWalkingModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.PostosuchusSkeleton;

public class PostosuchusSkeletonRenderer extends MobRenderer<PostosuchusSkeleton, EntityModel<PostosuchusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/postosuchus_skeleton.png");
    private static PostosuchusSkeletonModel IDLE;
    private static PostosuchusSkeletonAttackModel ATTACK;
    private static PostosuchusSkeletonAttackLeftModel ATTACK_LEFT;
    private static PostosuchusSkeletonCuriousModel CURIOUS;
    private static PostosuchusSkeletonWalkingModel WALKING;
    private static PostosuchusSkeletonSleepingModel SLEEPING;

	public PostosuchusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PostosuchusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.POSTOSUCHUS_SKELETON)), 0);
		IDLE = new PostosuchusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.POSTOSUCHUS_SKELETON));
		ATTACK = new PostosuchusSkeletonAttackModel(renderManagerIn.bakeLayer(ClientEvents.POSTOSUCHUS_SKELETON_ATTACK));
		ATTACK_LEFT = new PostosuchusSkeletonAttackLeftModel(renderManagerIn.bakeLayer(ClientEvents.POSTOSUCHUS_SKELETON_ATTACK_LEFT));
		CURIOUS = new PostosuchusSkeletonCuriousModel(renderManagerIn.bakeLayer(ClientEvents.POSTOSUCHUS_SKELETON_CURIOUS));
		WALKING = new PostosuchusSkeletonWalkingModel(renderManagerIn.bakeLayer(ClientEvents.POSTOSUCHUS_SKELETON_WALKING));
		SLEEPING = new PostosuchusSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.POSTOSUCHUS_SKELETON_SLEEPING));
	}
	
	protected void scale(PostosuchusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isAttackingLeft()) {
			model = ATTACK_LEFT;
		} else if (entityIn.isAttackingRight()) {
			model = ATTACK;
		} else if (entityIn.isCurious()) {
			model = CURIOUS;
		} else if (entityIn.isWalking()) {
			model = WALKING;
		} else if (entityIn.isSleeping()) {
			model = SLEEPING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(PostosuchusSkeleton entity) {
			return SKELETON;
	}

}
