package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.model.HerrerasaurusSkeleton;
import superlord.prehistoricfauna.entity.model.HerrerasaurusSkeletonAction;
import superlord.prehistoricfauna.entity.model.HerrerasaurusSkeletonRunning;
import superlord.prehistoricfauna.entity.HerrerasaurusSkeletonEntity;

public class HerrerasaurusSkeletonRenderer extends MobRenderer<HerrerasaurusSkeletonEntity, EntityModel<HerrerasaurusSkeletonEntity>> {

	private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/herrerasaurus_skeleton.png");
	private static final HerrerasaurusSkeleton IDLE = new HerrerasaurusSkeleton();
	private static final HerrerasaurusSkeletonAction ACTION = new HerrerasaurusSkeletonAction();
	private static final HerrerasaurusSkeletonRunning RUNNING = new HerrerasaurusSkeletonRunning();
	
	public HerrerasaurusSkeletonRenderer() {
		super(Minecraft.getInstance().getRenderManager(), IDLE, 0.625F);
	}
	
	public void render(HerrerasaurusSkeletonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAction()) {
			entityModel = ACTION;
		} else if (entityIn.isRunning()) {
			entityModel = RUNNING;
		} else {
			entityModel = IDLE;
		}
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	@Override
	public ResourceLocation getEntityTexture(HerrerasaurusSkeletonEntity entity) {
		return SKELETON;
	}

}
