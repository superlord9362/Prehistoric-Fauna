package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.HerrerasaurusSkeletonEntity;
import superlord.prehistoricfauna.entity.model.HerrerasaurusSkeleton;

public class HerrerasaurusSkeletonRenderer extends MobRenderer<HerrerasaurusSkeletonEntity, HerrerasaurusSkeleton> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/herrerasaurus_skeleton.png");

    public HerrerasaurusSkeletonRenderer(EntityRendererManager rm) {
        super(rm, new HerrerasaurusSkeleton(), 0.375F);
    }
    @Override
	public ResourceLocation getEntityTexture(HerrerasaurusSkeletonEntity entity) {
    	return SKULL;
    }
}