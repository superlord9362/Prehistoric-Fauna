package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonChargingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonRetroModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonSleepingModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TriceratopsSkeleton;

public class TriceratopsSkeletonRenderer extends MobRenderer<TriceratopsSkeleton, EntityModel<TriceratopsSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/triceratops_skeleton.png");
    private static TriceratopsSkeletonModel IDLE;
    private static TriceratopsSkeletonChargingModel CHARGING;
    private static TriceratopsSkeletonRetroModel RETRO;
    private static TriceratopsSkeletonSleepingModel SLEEPING;

	public TriceratopsSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TriceratopsSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS_SKELETON)), 0);
		IDLE = new TriceratopsSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS_SKELETON));
		CHARGING = new TriceratopsSkeletonChargingModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS_SKELETON_CHARGING));
		RETRO = new TriceratopsSkeletonRetroModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS_SKELETON_RETRO));
		SLEEPING = new TriceratopsSkeletonSleepingModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS_SKELETON_SLEEPING));
	}
	
	protected void scale(TriceratopsSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isCharging()) {
			model = CHARGING;
		} else if (entityIn.isClassical()) {
			model = RETRO;
		} else if (entityIn.isSleeping()) {
			model = SLEEPING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(TriceratopsSkeleton entity) {
			return SKELETON;
	}

}
