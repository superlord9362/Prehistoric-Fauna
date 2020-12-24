package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.TriceratopsSkeletonEntity;
import superlord.prehistoricfauna.entity.model.TriceratopsSkeleton;

public class TriceratopsSkeletonRenderer extends MobRenderer<TriceratopsSkeletonEntity, TriceratopsSkeleton> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/triceratops_skeleton.png");

    public TriceratopsSkeletonRenderer(EntityRendererManager rm) {
        super(rm, new TriceratopsSkeleton(), 0.375F);
    }
    @Override
	public ResourceLocation getEntityTexture(TriceratopsSkeletonEntity entity) {
    	return SKELETON;
    }
}