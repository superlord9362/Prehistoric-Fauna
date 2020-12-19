package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.TriceratopsSkullEntity;
import superlord.prehistoricfauna.entity.model.TriceratopsSkull;

public class TriceratopsSkullRenderer extends MobRenderer<TriceratopsSkullEntity, TriceratopsSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/triceratops_skull.png");

    public TriceratopsSkullRenderer(EntityRendererManager rm) {
        super(rm, new TriceratopsSkull(), 0.375F);
    }
    @Override
	public ResourceLocation getEntityTexture(TriceratopsSkullEntity entity) {
    	return SKULL;
    }
}