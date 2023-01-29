package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.HerrerasaurusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.HerrerasaurusSkullEntity;

public class HerrerasaurusSkullRenderer extends MobRenderer<HerrerasaurusSkullEntity, HerrerasaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/herrerasaurus_skeleton.png");

    public HerrerasaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new HerrerasaurusSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(HerrerasaurusSkullEntity entity) {
    	return SKULL;
    }
}