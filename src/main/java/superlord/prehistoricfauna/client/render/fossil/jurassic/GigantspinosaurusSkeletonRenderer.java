package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.*;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.GigantspinosaurusSkeleton;

public class GigantspinosaurusSkeletonRenderer extends MobRenderer<GigantspinosaurusSkeleton, EntityModel<GigantspinosaurusSkeleton>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/gigantspinosaurus_skeleton.png");
	private static GigantspinosaurusSkeletonModel IDLE;
	private static GigantspinosaurusSkeletonEatingModel EATING;
	private static GigantspinosaurusSkeletonAttackingModel ATTACK;
	private static GigantspinosaurusSkeletonWalkingModel WALKING;
	private static GigantspinosaurusSkeletonRunningModel RUNNING;
	private static GigantspinosaurusSkeletonSittingModel SITTING;
	private static GigantspinosaurusSkeletonSleepingModel SLEEPING;
	private static GigantspinosaurusSkeletonDeadModel DEAD;

	public GigantspinosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GigantspinosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKELETON)), 0);
		IDLE = new GigantspinosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKELETON));
		EATING = new GigantspinosaurusSkeletonEatingModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKELETON_EATING));
		ATTACK = new GigantspinosaurusSkeletonAttackingModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKELETON_ATTACK));
		WALKING = new GigantspinosaurusSkeletonWalkingModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKELETON_WALKING));
		RUNNING = new GigantspinosaurusSkeletonRunningModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKELETON_RUNNING));
		SITTING = new GigantspinosaurusSkeletonSittingModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKELETON_SITTING));
		SLEEPING = new GigantspinosaurusSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKELETON_SLEEPING));
		DEAD = new GigantspinosaurusSkeletonDeadModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKELETON_DEAD));
	}

	protected void scale(GigantspinosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		model = switch (entityIn.getPoseName()) {
		case "EATING" -> EATING;
		case "ATTACK" -> ATTACK;
		case "WALKING" -> WALKING;
		case "RUNNING" -> RUNNING;
		case "SITTING" -> SITTING;
		case "SLEEPING" -> SLEEPING;
		case "DEAD" -> DEAD;
		default -> IDLE;
		};
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(GigantspinosaurusSkeleton entity) {
		return SKELETON;
	}

}
