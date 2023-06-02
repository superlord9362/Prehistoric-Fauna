package superlord.prehistoricfauna.client.render.fossil.triassic;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.HerrerasaurusSkeletonActionModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.HerrerasaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.HerrerasaurusSkeletonRunningModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.HerrerasaurusSkeleton;

public class HerrerasaurusSkeletonRenderer extends MobRenderer<HerrerasaurusSkeleton, EntityModel<HerrerasaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/herrerasaurus_skeleton.png");
    private static HerrerasaurusSkeletonModel IDLE;
    private static HerrerasaurusSkeletonActionModel ACTION;
    private static HerrerasaurusSkeletonRunningModel RUNNING;

	public HerrerasaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new HerrerasaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.HERRERASAURUS_SKELETON)), 0);
		IDLE = new HerrerasaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.HERRERASAURUS_SKELETON));
		ACTION = new HerrerasaurusSkeletonActionModel(renderManagerIn.bakeLayer(ClientEvents.HERRERASAURUS_SKELETON_ACTION));
		RUNNING = new HerrerasaurusSkeletonRunningModel(renderManagerIn.bakeLayer(ClientEvents.HERRERASAURUS_SKELETON_RUNNING));
	}
	
	protected void scale(HerrerasaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isAction()) {
			model = ACTION;
		} else if (entityIn.isRunning()) {
			model = RUNNING;
		} else {
			model = IDLE;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(HerrerasaurusSkeleton entity) {
			return SKELETON;
	}

}
