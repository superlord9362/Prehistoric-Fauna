package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.AnkylosaurusSkeletonEntity;
import superlord.prehistoricfauna.entity.model.AnkylosaurusSkeleton;

public class AnkylosaurusSkeletonRenderer extends MobRenderer<AnkylosaurusSkeletonEntity, AnkylosaurusSkeleton> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/ankylosaurus_skeleton.png");

    public AnkylosaurusSkeletonRenderer(EntityRendererManager rm) {
        super(rm, new AnkylosaurusSkeleton(), 0.375F);
    }
    @Override
	public ResourceLocation getEntityTexture(AnkylosaurusSkeletonEntity entity) {
    	return SKULL;
    }
}