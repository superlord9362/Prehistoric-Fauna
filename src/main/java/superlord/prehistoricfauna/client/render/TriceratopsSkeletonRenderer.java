package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.TriceratopsSkeleton;
import superlord.prehistoricfauna.client.model.TriceratopsSkeletonCharging;
import superlord.prehistoricfauna.client.model.TriceratopsSkeletonClassical;
import superlord.prehistoricfauna.client.model.TriceratopsSkeletonSleeping;
import superlord.prehistoricfauna.common.entities.TriceratopsSkeletonEntity;

public class TriceratopsSkeletonRenderer extends MobRenderer<TriceratopsSkeletonEntity, EntityModel<TriceratopsSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/triceratops_skeleton.png");
	private static final TriceratopsSkeleton IDLE = new TriceratopsSkeleton();
	private static final TriceratopsSkeletonCharging CHARGING = new TriceratopsSkeletonCharging();
	private static final TriceratopsSkeletonSleeping SLEEPING = new TriceratopsSkeletonSleeping();
	private static final TriceratopsSkeletonClassical CLASSICAL = new TriceratopsSkeletonClassical();

	public TriceratopsSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 1.25F);
	}

	public void render(TriceratopsSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if(entityIn.isSleeping()) {
			entityModel = SLEEPING;
		} else if(entityIn.isCharging()) {
			entityModel = CHARGING;
		} else if (entityIn.isClassical()) {
			entityModel = CLASSICAL;
		} else {
			entityModel = IDLE;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(TriceratopsSkeletonEntity entity) {
		return SKELETON;
	}

}
