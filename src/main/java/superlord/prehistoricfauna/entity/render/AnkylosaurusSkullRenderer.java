package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.AnkylosaurusSkullEntity;
import superlord.prehistoricfauna.entity.model.AnkylosaurusSkull;

public class AnkylosaurusSkullRenderer extends MobRenderer<AnkylosaurusSkullEntity, AnkylosaurusSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/ankylosaurus_skull.png");

    public AnkylosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new AnkylosaurusSkull(), 1.0F);
    }
    @Override
	public ResourceLocation getEntityTexture(AnkylosaurusSkullEntity entity) {
    	return SKULL;
    }
}