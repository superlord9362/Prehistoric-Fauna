package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.TyrannosaurusSkullEntity;
import superlord.prehistoricfauna.entity.model.Tyrannosaurusskull;

public class TyrannosaurusSkullRenderer extends MobRenderer<TyrannosaurusSkullEntity, Tyrannosaurusskull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/blocks/tyrannosaurus_skull.png");

    public TyrannosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new Tyrannosaurusskull(), 1.0F);
    }
    @Override
	public ResourceLocation getEntityTexture(TyrannosaurusSkullEntity entity) {
    	return SKULL;
    }
}