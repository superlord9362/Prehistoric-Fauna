package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.CeratosaurusSkullEntity;
import superlord.prehistoricfauna.entity.model.CeratosaurusSkull;

public class CeratosaurusSkullRenderer extends MobRenderer<CeratosaurusSkullEntity, CeratosaurusSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/ceratosaurus_skull.png");

    public CeratosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new CeratosaurusSkull(), 1.0F);
    }
    @Override
	public ResourceLocation getEntityTexture(CeratosaurusSkullEntity entity) {
    	return SKULL;
    }
}