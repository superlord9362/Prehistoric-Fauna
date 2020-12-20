package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.SaurosuchusSkullEntity;
import superlord.prehistoricfauna.entity.model.SaurosuchusSkull;

public class SaurosuchusSkullRenderer extends MobRenderer<SaurosuchusSkullEntity, SaurosuchusSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/saurosuchus_skull.png");

    public SaurosuchusSkullRenderer(EntityRendererManager rm) {
        super(rm, new SaurosuchusSkull(), 0.375F);
    }
    @Override
	public ResourceLocation getEntityTexture(SaurosuchusSkullEntity entity) {
    	return SKULL;
    }
}