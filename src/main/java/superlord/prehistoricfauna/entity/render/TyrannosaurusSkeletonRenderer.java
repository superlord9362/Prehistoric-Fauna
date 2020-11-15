package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.TyrannosaurusSkeletonEntity;
import superlord.prehistoricfauna.entity.model.Tyrannosaurusrexskeleton;

public class TyrannosaurusSkeletonRenderer extends MobRenderer<TyrannosaurusSkeletonEntity, Tyrannosaurusrexskeleton> {

    private static final ResourceLocation SKELETON = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/tyrannosaurus.png");

    public TyrannosaurusSkeletonRenderer(EntityRendererManager rm) {
        super(rm, new Tyrannosaurusrexskeleton(), 0.375F);
    }
    
    @Override
	public ResourceLocation getEntityTexture(TyrannosaurusSkeletonEntity entity) {
    	return SKELETON;
    }
}