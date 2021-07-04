package superlord.prehistoricfauna.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.HerrerasaurusSkull;
import superlord.prehistoricfauna.common.entities.HerrerasaurusSkullEntity;

public class HerrerasaurusSkullRenderer extends MobRenderer<HerrerasaurusSkullEntity, HerrerasaurusSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/herrerasaurus_skull.png");

    public HerrerasaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new HerrerasaurusSkull(), 0.5F);
    }
    @Override
	public ResourceLocation getEntityTexture(HerrerasaurusSkullEntity entity) {
    	return SKULL;
    }
}