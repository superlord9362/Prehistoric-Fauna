package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.AllosaurusSkullEntity;
import superlord.prehistoricfauna.entity.model.AllosaurusSkull;

public class AllosaurusSkullRenderer extends MobRenderer<AllosaurusSkullEntity, AllosaurusSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/allosaurus_skull.png");

    public AllosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new AllosaurusSkull(), 0.375F);
    }
    @Override
	public ResourceLocation getEntityTexture(AllosaurusSkullEntity entity) {
    	return SKULL;
    }
}