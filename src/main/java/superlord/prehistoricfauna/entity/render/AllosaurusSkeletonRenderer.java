package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.AllosaurusSkeletonEntity;
import superlord.prehistoricfauna.entity.model.*;

public class AllosaurusSkeletonRenderer extends MobRenderer<AllosaurusSkeletonEntity, EntityModel<AllosaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/allosaurus_skeleton.png");
	private static final AllosaurusSkeleton IDLE = new AllosaurusSkeleton();
	private static final AllosaurusSkeletonActionLeft ACTION_LEFT = new AllosaurusSkeletonActionLeft();
	private static final AllosaurusSkeletonActionRight ACTION_RIGHT = new AllosaurusSkeletonActionRight();
	private static final AllosaurusSkeletonResting RESTING = new AllosaurusSkeletonResting();
	private static final AllosaurusSkeletonRetro CLASSICAL = new AllosaurusSkeletonRetro();
	
	public AllosaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 1.25F);
	}
	
	public void render(AllosaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isActionLeft()) {
			entityModel = ACTION_LEFT;
		} else if (entityIn.isActionRight()) {
			entityModel = ACTION_RIGHT;
		} else if (entityIn.isResting()) {
			entityModel = RESTING;
		} else if (entityIn.isClassical()) {
			entityModel = CLASSICAL;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(AllosaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
