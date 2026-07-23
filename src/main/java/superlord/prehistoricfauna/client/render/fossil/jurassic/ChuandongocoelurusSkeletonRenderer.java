package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.*;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ChuandongocoelurusSkeleton;

public class ChuandongocoelurusSkeletonRenderer extends MobRenderer<ChuandongocoelurusSkeleton, EntityModel<ChuandongocoelurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/chuandongocoelurus_skeleton.png");
    private static ChuandongocoelurusSkeletonModel IDLE;
    private static ChuandongocoelurusSkeletonAlertModel ALERT;
    private static ChuandongocoelurusSkeletonEatingModel EATING;
    private static ChuandongocoelurusSkeletonAttackingModel ATTACK;
    private static ChuandongocoelurusSkeletonWalkingModel WALKING;
    private static ChuandongocoelurusSkeletonRunningModel RUNNING;
    private static ChuandongocoelurusSkeletonSittingModel SITTING;
    private static ChuandongocoelurusSkeletonSleepingModel SLEEPING;
    private static ChuandongocoelurusSkeletonDeadModel DEAD;

	public ChuandongocoelurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ChuandongocoelurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON)), 0);
		IDLE = new ChuandongocoelurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON));
		ALERT = new ChuandongocoelurusSkeletonAlertModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON_ALERT));
		EATING = new ChuandongocoelurusSkeletonEatingModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON_EATING));
		ATTACK = new ChuandongocoelurusSkeletonAttackingModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON_ATTACK));
		WALKING = new ChuandongocoelurusSkeletonWalkingModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON_WALKING));
		RUNNING = new ChuandongocoelurusSkeletonRunningModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON_RUNNING));
		SITTING = new ChuandongocoelurusSkeletonSittingModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON_SITTING));
		SLEEPING = new ChuandongocoelurusSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON_SLEEPING));
		DEAD = new ChuandongocoelurusSkeletonDeadModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKELETON_DEAD));
	}
	
	protected void scale(ChuandongocoelurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		model = switch (entityIn.getPoseName()) {
		case "ALERT" -> ALERT;
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
	public ResourceLocation getTextureLocation(ChuandongocoelurusSkeleton entity) {
			return SKELETON;
	}

}
