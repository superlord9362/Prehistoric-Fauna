package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.ScelidosaurusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.ScelidosaurusSkullEntity;

public class ScelidosaurusSkullRenderer extends MobRenderer<ScelidosaurusSkullEntity, ScelidosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/scelidosaurus_skeleton.png");

    public ScelidosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new ScelidosaurusSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(ScelidosaurusSkullEntity entity) {
    	return SKULL;
    }
}