package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.HerrerasaurusSkullEntity;
import superlord.prehistoricfauna.entity.model.HerrerasaurusSkull;

public class HerrerasaurusSkullRenderer extends MobRenderer<HerrerasaurusSkullEntity, HerrerasaurusSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/herrerasaurus_skull.png");

    public HerrerasaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new HerrerasaurusSkull(), 0.5F);
    }
    @Override
	public ResourceLocation getEntityTexture(HerrerasaurusSkullEntity entity) {
    	return SKULL;
    }
}