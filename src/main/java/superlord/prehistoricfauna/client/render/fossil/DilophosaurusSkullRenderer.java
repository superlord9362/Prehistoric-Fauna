package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.DilophosaurusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.DilophosaurusSkullEntity;

public class DilophosaurusSkullRenderer extends MobRenderer<DilophosaurusSkullEntity, DilophosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/dilophosaurus_skeleton.png");

    public DilophosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new DilophosaurusSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(DilophosaurusSkullEntity entity) {
    	return SKULL;
    }
}