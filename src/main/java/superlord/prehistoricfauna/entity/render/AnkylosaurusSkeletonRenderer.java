package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.AnkylosaurusSkeletonEntity;
import superlord.prehistoricfauna.entity.model.*;

public class AnkylosaurusSkeletonRenderer extends MobRenderer<AnkylosaurusSkeletonEntity, EntityModel<AnkylosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/ankylosaurus_skeleton.png");
	private static final AnkylosaurusSkeleton IDLE = new AnkylosaurusSkeleton();
	private static final AnkylosaurusSkeletonActionLeft ACTION_LEFT = new AnkylosaurusSkeletonActionLeft();
	private static final AnkylosaurusSkeletonActionRight ACTION_RIGHT = new AnkylosaurusSkeletonActionRight();
	private static final AnkylosaurusSkeletonResting RESTING = new AnkylosaurusSkeletonResting();
	private static final AnkylosaurusSkeletonSquat SQUATTING = new AnkylosaurusSkeletonSquat();
	
	public AnkylosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 2F);
	}
	
	public void render(AnkylosaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isActionLeft()) {
			entityModel = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			entityModel = ACTION_RIGHT;
		} else if (entityIn.isResting()) {
			entityModel = RESTING;
		} else if (entityIn.isSquatting()) {
			entityModel = SQUATTING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(AnkylosaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
