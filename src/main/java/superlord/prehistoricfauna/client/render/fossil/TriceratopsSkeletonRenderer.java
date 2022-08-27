package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.TriceratopsSkeletonChargingModel;
import superlord.prehistoricfauna.client.model.fossil.TriceratopsSkeletonClassicalModel;
import superlord.prehistoricfauna.client.model.fossil.TriceratopsSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.TriceratopsSkeletonSleepingModel;
import superlord.prehistoricfauna.common.entities.fossil.TriceratopsSkeletonEntity;

public class TriceratopsSkeletonRenderer extends MobRenderer<TriceratopsSkeletonEntity, EntityModel<TriceratopsSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/triceratops_skeleton.png");
	private static final TriceratopsSkeletonModel IDLE = new TriceratopsSkeletonModel();
	private static final TriceratopsSkeletonChargingModel CHARGING = new TriceratopsSkeletonChargingModel();
	private static final TriceratopsSkeletonSleepingModel SLEEPING = new TriceratopsSkeletonSleepingModel();
	private static final TriceratopsSkeletonClassicalModel CLASSICAL = new TriceratopsSkeletonClassicalModel();

	public TriceratopsSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
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
