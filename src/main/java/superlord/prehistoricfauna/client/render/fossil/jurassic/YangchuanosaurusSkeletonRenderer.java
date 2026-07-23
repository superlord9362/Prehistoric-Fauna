package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.*;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.YangchuanosaurusSkeleton;

public class YangchuanosaurusSkeletonRenderer extends MobRenderer<YangchuanosaurusSkeleton, EntityModel<YangchuanosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/yangchuanosaurus_skeleton.png");
    private static YangchuanosaurusSkeletonModel IDLE;
    private static YangchuanosaurusSkeletonWalkingModel WALKING;
    private static YangchuanosaurusSkeletonStargazingModel STARGAZING;
    private static YangchuanosaurusSkeletonStalkingModel STALKING;
    private static YangchuanosaurusSkeletonSleepingModel SLEEPING;
    private static YangchuanosaurusSkeletonRunningModel RUNNING;
    private static YangchuanosaurusSkeletonRetroModel RETRO;
    private static YangchuanosaurusSkeletonEatingModel EATING;
    private static YangchuanosaurusSkeletonDeadModel DEAD;
    private static YangchuanosaurusSkeletonAttackingModel ATTACKING;
    
	public YangchuanosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new YangchuanosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON)), 0);
		IDLE = new YangchuanosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON));
		WALKING = new YangchuanosaurusSkeletonWalkingModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON_WALKING));
		STARGAZING = new YangchuanosaurusSkeletonStargazingModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON_STARGAZING));
		STALKING = new YangchuanosaurusSkeletonStalkingModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON_STALKING));
		SLEEPING = new YangchuanosaurusSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON_SLEEPING));
		RUNNING = new YangchuanosaurusSkeletonRunningModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON_RUNNING));
		RETRO = new YangchuanosaurusSkeletonRetroModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON_RETRO));
		EATING = new YangchuanosaurusSkeletonEatingModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON_EATING));
		DEAD = new YangchuanosaurusSkeletonDeadModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON_DEAD));
		ATTACKING = new YangchuanosaurusSkeletonAttackingModel(renderManagerIn.bakeLayer(ClientEvents.YANGCHUANOSAURUS_SKELETON_ATTACKING));
	}
	
	protected void scale(YangchuanosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		model = switch (entityIn.getPoseName()) {
		case "RETRO" -> RETRO;
		case "SLEEPING" -> SLEEPING;
		case "WALKING" -> WALKING;
		case "STALKING" -> STALKING;
		case "RUNNING" -> RUNNING;
		case "EATING" -> EATING;
		case "ATTACKING" -> ATTACKING;
		case "STARGAZING" -> STARGAZING;
		case "DEAD" -> DEAD;
		default -> IDLE;
		};
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(YangchuanosaurusSkeleton entity) {
			return SKELETON;
	}

}
