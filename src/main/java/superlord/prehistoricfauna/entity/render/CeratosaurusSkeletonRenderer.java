package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.CeratosaurusSkeletonEntity;
import superlord.prehistoricfauna.entity.model.CeratosaurusSkeleton;

public class CeratosaurusSkeletonRenderer extends MobRenderer<CeratosaurusSkeletonEntity, CeratosaurusSkeleton> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/ceratosaurus_skeleton.png");

    public CeratosaurusSkeletonRenderer(EntityRendererManager rm) {
        super(rm, new CeratosaurusSkeleton(), 0.375F);
    }
    
    @Override
	public ResourceLocation getEntityTexture(CeratosaurusSkeletonEntity entity) {
    	return SKELETON;
    }
}