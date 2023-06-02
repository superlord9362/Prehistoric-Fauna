package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonDisplayModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonLayingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonRunningModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonSittingModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.ProtoceratopsSkeleton;

public class ProtoceratopsSkeletonRenderer extends MobRenderer<ProtoceratopsSkeleton, EntityModel<ProtoceratopsSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/protoceratops_skeleton.png");
    private static ProtoceratopsSkeletonModel IDLE;
    private static ProtoceratopsSkeletonDisplayModel DISPLAY;
    private static ProtoceratopsSkeletonLayingModel LAYING;
    private static ProtoceratopsSkeletonRunningModel RUNNING;
    private static ProtoceratopsSkeletonSittingModel SITTING;

	public ProtoceratopsSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ProtoceratopsSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS_SKELETON)), 0);
		IDLE = new ProtoceratopsSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS_SKELETON));
		DISPLAY = new ProtoceratopsSkeletonDisplayModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS_SKELETON_DISPLAY));
		LAYING = new ProtoceratopsSkeletonLayingModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS_SKELETON_LAYING));
		RUNNING = new ProtoceratopsSkeletonRunningModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS_SKELETON_RUNNING));
		SITTING = new ProtoceratopsSkeletonSittingModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS_SKELETON_SITTING));
	}
	
	protected void scale(ProtoceratopsSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isDisplaying()) {
			model = DISPLAY;
		} else if (entityIn.isLaying()) {
			model = LAYING;
		} else if (entityIn.isRunning()) {
			model = RUNNING;
		} else if (entityIn.isSitting()) {
			model = SITTING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(ProtoceratopsSkeleton entity) {
			return SKELETON;
	}

}
