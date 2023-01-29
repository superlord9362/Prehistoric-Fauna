package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.CeratosaurusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.CeratosaurusSkullEntity;

public class CeratosaurusSkullRenderer extends MobRenderer<CeratosaurusSkullEntity, CeratosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ceratosaurus_skeleton.png");

    public CeratosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new CeratosaurusSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(CeratosaurusSkullEntity entity) {
    	return SKULL;
    }
}