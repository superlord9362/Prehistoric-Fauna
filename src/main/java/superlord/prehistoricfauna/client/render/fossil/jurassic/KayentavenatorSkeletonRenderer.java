package superlord.prehistoricfauna.client.render.fossil.jurassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.*;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.KayentavenatorSkeleton;

public class KayentavenatorSkeletonRenderer extends MobRenderer<KayentavenatorSkeleton, EntityModel<KayentavenatorSkeleton>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/kayentavenator_skeleton.png");
	private static KayentavenatorSkeletonModel IDLE;
	private static KayentavenatorSkeletonAlertModel ALERT;
	private static KayentavenatorSkeletonEatingModel EATING;
	private static KayentavenatorSkeletonAttackingModel ATTACK;
	private static KayentavenatorSkeletonWalkingModel WALKING;
	private static KayentavenatorSkeletonRunningModel RUNNING;
	private static KayentavenatorSkeletonSittingModel SITTING;
	private static KayentavenatorSkeletonSleepingModel SLEEPING;
	private static KayentavenatorSkeletonDeadModel DEAD;

	public KayentavenatorSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new KayentavenatorSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON)), 0);
		IDLE = new KayentavenatorSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON));
		ALERT = new KayentavenatorSkeletonAlertModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON_ALERT));
		EATING = new KayentavenatorSkeletonEatingModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON_EATING));
		ATTACK = new KayentavenatorSkeletonAttackingModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON_ATTACK));
		WALKING = new KayentavenatorSkeletonWalkingModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON_WALKING));
		RUNNING = new KayentavenatorSkeletonRunningModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON_RUNNING));
		SITTING = new KayentavenatorSkeletonSittingModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON_SITTING));
		SLEEPING = new KayentavenatorSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON_SLEEPING));
		DEAD = new KayentavenatorSkeletonDeadModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTAVENATOR_SKELETON_DEAD));
	}

	protected void scale(KayentavenatorSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
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
	public ResourceLocation getTextureLocation(KayentavenatorSkeleton entity) {
		return SKELETON;
	}

}
