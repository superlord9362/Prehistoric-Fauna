package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.PostosuchusAttackLeftSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.PostosuchusAttackSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.PostosuchusCuriousSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.PostosuchusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.PostosuchusSleepingSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.PostosuchusWalkingSkeletonModel;
import superlord.prehistoricfauna.common.entities.fossil.PostosuchusSkeletonEntity;

public class PostosuchusSkeletonRenderer extends MobRenderer<PostosuchusSkeletonEntity, EntityModel<PostosuchusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/postosuchus_skeleton.png");
	private static final PostosuchusSkeletonModel IDLE = new PostosuchusSkeletonModel();
	private static final PostosuchusAttackLeftSkeletonModel ATTACK_LEFT = new PostosuchusAttackLeftSkeletonModel();
	private static final PostosuchusAttackSkeletonModel ATTACK_RIGHT = new PostosuchusAttackSkeletonModel();
	private static final PostosuchusCuriousSkeletonModel CURIOUS = new PostosuchusCuriousSkeletonModel();
	private static final PostosuchusWalkingSkeletonModel WALKING = new PostosuchusWalkingSkeletonModel();
	private static final PostosuchusSleepingSkeletonModel SLEEPING = new PostosuchusSleepingSkeletonModel();
	
	public PostosuchusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(PostosuchusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAttackLeft()) {
			entityModel = ATTACK_LEFT;
		} else if (entityIn.isAttackRight()) {
			entityModel = ATTACK_RIGHT;
		} else if (entityIn.isCurious()) {
			entityModel = CURIOUS;
		} else if (entityIn.isWalking()) {
			entityModel = WALKING;
		} else if (entityIn.isSleeping()) {
			entityModel = SLEEPING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(PostosuchusSkeletonEntity entity) {
		return SKELETON;
	}

}
