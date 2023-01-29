package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.TriceratopsSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.TriceratopsSkullEntity;

public class TriceratopsSkullRenderer extends MobRenderer<TriceratopsSkullEntity, TriceratopsSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/triceratops_skeleton.png");

    public TriceratopsSkullRenderer(EntityRendererManager rm) {
        super(rm, new TriceratopsSkullModel(), 0.0F);
    }
    @Override
	public ResourceLocation getEntityTexture(TriceratopsSkullEntity entity) {
    	return SKULL;
    }
}