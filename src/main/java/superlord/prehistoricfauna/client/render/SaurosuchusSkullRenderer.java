package superlord.prehistoricfauna.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.SaurosuchusSkull;
import superlord.prehistoricfauna.common.entities.SaurosuchusSkullEntity;

public class SaurosuchusSkullRenderer extends MobRenderer<SaurosuchusSkullEntity, SaurosuchusSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/saurosuchus_skull.png");

    public SaurosuchusSkullRenderer(EntityRendererManager rm) {
        super(rm, new SaurosuchusSkull(), 1.0F);
    }
    
    @Override
	public ResourceLocation getEntityTexture(SaurosuchusSkullEntity entity) {
    	return SKULL;
    }
}