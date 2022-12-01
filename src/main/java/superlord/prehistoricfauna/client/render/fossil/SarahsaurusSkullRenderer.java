package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.SarahsaurusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.SarahsaurusSkullEntity;

public class SarahsaurusSkullRenderer extends MobRenderer<SarahsaurusSkullEntity, SarahsaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/sarahsaurus_skeleton.png");

    public SarahsaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new SarahsaurusSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(SarahsaurusSkullEntity entity) {
    	return SKULL;
    }
}