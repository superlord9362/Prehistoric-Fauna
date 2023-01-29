package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.AllosaurusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.AllosaurusSkullEntity;

public class AllosaurusSkullRenderer extends MobRenderer<AllosaurusSkullEntity, AllosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/allosaurus_skeleton.png");

    public AllosaurusSkullRenderer(EntityRendererManager rm) {
        super(rm, new AllosaurusSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(AllosaurusSkullEntity entity) {
    	return SKULL;
    }
}