package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.StegosaurusSkullEntity;
import superlord.prehistoricfauna.entity.model.StegosaurusSkull;

public class StegosaurusSkullRenderer extends MobRenderer<StegosaurusSkullEntity, StegosaurusSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/stegosaurus_skull.png");

    public StegosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new StegosaurusSkull(), 0.375F);
    }
    @Override
	public ResourceLocation getEntityTexture(StegosaurusSkullEntity entity) {
    	return SKULL;
    }
}