package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.TyrannosaurusskullModel;
import superlord.prehistoricfauna.common.entities.fossil.TyrannosaurusSkullEntity;

public class TyrannosaurusSkullRenderer extends MobRenderer<TyrannosaurusSkullEntity, TyrannosaurusskullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/blocks/tyrannosaurus_skull.png");

    public TyrannosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new TyrannosaurusskullModel(), 0.0F);
    }
    @Override
	public ResourceLocation getEntityTexture(TyrannosaurusSkullEntity entity) {
    	return SKULL;
    }
}