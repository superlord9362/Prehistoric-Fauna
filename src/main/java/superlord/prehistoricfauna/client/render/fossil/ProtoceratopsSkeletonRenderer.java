package superlord.prehistoricfauna.client.render.fossil;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.ProtoceratopsSkeletonDisplayModel;
import superlord.prehistoricfauna.client.model.fossil.ProtoceratopsSkeletonLayingModel;
import superlord.prehistoricfauna.client.model.fossil.ProtoceratopsSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.ProtoceratopsSkeletonRunningModel;
import superlord.prehistoricfauna.client.model.fossil.ProtoceratopsSkeletonSittingModel;
import superlord.prehistoricfauna.common.entities.fossil.ProtoceratopsSkeletonEntity;

public class ProtoceratopsSkeletonRenderer extends MobRenderer<ProtoceratopsSkeletonEntity, EntityModel<ProtoceratopsSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/protoceratops_skeleton.png");
	private static final ProtoceratopsSkeletonModel IDLE = new ProtoceratopsSkeletonModel();
	private static final ProtoceratopsSkeletonDisplayModel DISPLAYING = new ProtoceratopsSkeletonDisplayModel();
	private static final ProtoceratopsSkeletonSittingModel SITTING = new ProtoceratopsSkeletonSittingModel();
	private static final ProtoceratopsSkeletonLayingModel LAYING = new ProtoceratopsSkeletonLayingModel();
	private static final ProtoceratopsSkeletonRunningModel RUNNING = new ProtoceratopsSkeletonRunningModel();
	
	public ProtoceratopsSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0F);
	}
	
	public void render(ProtoceratopsSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isDisplaying()) {
			entityModel = DISPLAYING;
		} else if (entityIn.isSitting()) {
			entityModel = SITTING;
		} else if (entityIn.isLaying()) {
			entityModel = LAYING;
		} else if (entityIn.isRunning()) {
			entityModel = RUNNING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(ProtoceratopsSkeletonEntity entity) {
		return SKELETON;
	}

}
