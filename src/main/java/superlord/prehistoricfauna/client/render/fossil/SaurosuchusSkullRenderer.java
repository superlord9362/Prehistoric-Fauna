package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.SaurosuchusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.SaurosuchusSkullEntity;

public class SaurosuchusSkullRenderer extends MobRenderer<SaurosuchusSkullEntity, SaurosuchusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/saurosuchus_skeleton.png");

    public SaurosuchusSkullRenderer(EntityRendererManager rm) {
        super(rm, new SaurosuchusSkullModel(), 0F);
    }
    
    @Override
	public ResourceLocation getEntityTexture(SaurosuchusSkullEntity entity) {
    	return SKULL;
    }
}