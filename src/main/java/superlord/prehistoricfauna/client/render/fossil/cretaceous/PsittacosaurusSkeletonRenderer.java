package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PsittacosaurusSkeletonLeftModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PsittacosaurusSkeletonMatingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PsittacosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PsittacosaurusSkeletonSaunterModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PsittacosaurusSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PsittacosaurusSkeletonSprintModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.PsittacosaurusSkeleton;

public class PsittacosaurusSkeletonRenderer extends MobRenderer<PsittacosaurusSkeleton, EntityModel<PsittacosaurusSkeleton>> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/psittacosaurus_skeleton.png");
    private static PsittacosaurusSkeletonModel IDLE;
    private static PsittacosaurusSkeletonLeftModel LEFT;
    private static PsittacosaurusSkeletonMatingModel MATING;
    private static PsittacosaurusSkeletonSaunterModel SAUNTER;
    private static PsittacosaurusSkeletonSittingModel SITTING;
    private static PsittacosaurusSkeletonSprintModel SPRINTING;

	public PsittacosaurusSkeletonRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PsittacosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.PSITTACOSAURUS_SKELETON)), 0);
		IDLE = new PsittacosaurusSkeletonModel(renderManagerIn.bakeLayer(ClientEvents.PSITTACOSAURUS_SKELETON));
		LEFT = new PsittacosaurusSkeletonLeftModel(renderManagerIn.bakeLayer(ClientEvents.PSITTACOSAURUS_SKELETON_LEFT));
		MATING = new PsittacosaurusSkeletonMatingModel(renderManagerIn.bakeLayer(ClientEvents.PSITTACOSAURUS_SKELETON_MATING));
		SAUNTER = new PsittacosaurusSkeletonSaunterModel(renderManagerIn.bakeLayer(ClientEvents.PSITTACOSAURUS_SKELETON_SAUNTER));
		SITTING = new PsittacosaurusSkeletonSittingModel(renderManagerIn.bakeLayer(ClientEvents.PSITTACOSAURUS_SKELETON_SITTING));
		SPRINTING = new PsittacosaurusSkeletonSprintModel(renderManagerIn.bakeLayer(ClientEvents.PSITTACOSAURUS_SKELETON_SPRINTING));
	}
	
	protected void scale(PsittacosaurusSkeleton entityIn, PoseStack matrixStackIn, float partialTickTime) {
		model = switch (entityIn.getPoseName()) {
		case "LEFT" -> LEFT;
		case "MATING" -> MATING;
		case "SAUNTERING" -> SAUNTER;
		case "SITTING" -> SITTING;
		case "RUNNING" -> SPRINTING;
		default -> IDLE;
		};
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(PsittacosaurusSkeleton entity) {
			return SKELETON;
	}

}
