package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkeletonCarcassModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkeletonFrolicModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkeletonJPModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkeletonLeapModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkeletonRompModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkeletonSaunterModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkeletonSleepModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.YutyrannusSkeletonSubduedModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.YutyrannusSkeleton;

public class YutyrannusSkeletonRenderer extends MobRenderer<YutyrannusSkeleton, EntityModel<YutyrannusSkeleton>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/yutyrannus_skeleton.png");
	private static YutyrannusSkeletonModel IDLE;
	private static YutyrannusSkeletonSaunterModel SAUNTER;
	private static YutyrannusSkeletonRompModel ROMP;
	private static YutyrannusSkeletonFrolicModel FROLIC;
	private static YutyrannusSkeletonJPModel JP;
	private static YutyrannusSkeletonLeapModel LEAP;
	private static YutyrannusSkeletonSubduedModel SUBDUED;
	private static YutyrannusSkeletonSleepModel SLEEP;
	private static YutyrannusSkeletonCarcassModel CARCASS;

	public YutyrannusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new YutyrannusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON)), 0);
		IDLE = new YutyrannusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON));
		SAUNTER = new YutyrannusSkeletonSaunterModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON_SAUNTER));
		ROMP = new YutyrannusSkeletonRompModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON_ROMP));
		FROLIC = new YutyrannusSkeletonFrolicModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON_FROLIC));
		JP = new YutyrannusSkeletonJPModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON_JP));
		LEAP = new YutyrannusSkeletonLeapModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON_LEAP));
		SUBDUED = new YutyrannusSkeletonSubduedModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON_SUBDUED));
		SLEEP = new YutyrannusSkeletonSleepModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON_SLEEP));
		CARCASS = new YutyrannusSkeletonCarcassModel(renderManagerIn.bakeLayer(ClientEvents.YUTYRANNUS_SKELETON_CARCASS));
	}

	protected void scale(YutyrannusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		model = switch (entityIn.getPoseName()) {
		case "SAUNTER" -> SAUNTER;
		case "ROMP" -> ROMP;
		case "FROLIC" -> FROLIC;
		case "JP" -> JP;
		case "LEAP" -> LEAP;
		case "SUBDUED" -> SUBDUED;
		case "SLEEP" -> SLEEP;
		case "CARCASS" -> CARCASS;
		default -> IDLE;
		};
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(YutyrannusSkeleton entity) {
		return SKELETON;
	}

}
