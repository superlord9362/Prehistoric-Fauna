package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.StegosaurusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.StegosaurusSkullEntity;

public class StegosaurusSkullRenderer extends MobRenderer<StegosaurusSkullEntity, StegosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/stegosaurus_skeleton.png");

    public StegosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new StegosaurusSkullModel(), 0F);
    }
    
    @Override
	public ResourceLocation getEntityTexture(StegosaurusSkullEntity entity) {
    	return SKULL;
    }
}