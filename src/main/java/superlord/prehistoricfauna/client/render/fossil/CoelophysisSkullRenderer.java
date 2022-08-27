package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.CoelophysisSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.CoelophysisSkullEntity;

public class CoelophysisSkullRenderer extends MobRenderer<CoelophysisSkullEntity, CoelophysisSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/coelophysis_skeleton.png");

    public CoelophysisSkullRenderer(EntityRendererManager rm) {
        super(rm, new CoelophysisSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(CoelophysisSkullEntity entity) {
    	return SKULL;
    }
}