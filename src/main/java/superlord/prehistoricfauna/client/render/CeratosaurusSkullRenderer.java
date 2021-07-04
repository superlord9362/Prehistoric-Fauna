package superlord.prehistoricfauna.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.CeratosaurusSkull;
import superlord.prehistoricfauna.common.entities.CeratosaurusSkullEntity;

public class CeratosaurusSkullRenderer extends MobRenderer<CeratosaurusSkullEntity, CeratosaurusSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ceratosaurus_skull.png");

    public CeratosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new CeratosaurusSkull(), 1.0F);
    }
    @Override
	public ResourceLocation getEntityTexture(CeratosaurusSkullEntity entity) {
    	return SKULL;
    }
}