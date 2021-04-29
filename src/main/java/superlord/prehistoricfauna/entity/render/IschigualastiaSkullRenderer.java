package superlord.prehistoricfauna.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.IschigualastiaSkullEntity;
import superlord.prehistoricfauna.entity.model.IschigualastiaSkull;

public class IschigualastiaSkullRenderer extends MobRenderer<IschigualastiaSkullEntity, IschigualastiaSkull> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/skeleton/ischigualastia_skull.png");

    public IschigualastiaSkullRenderer(EntityRendererManager rm) {
        super(rm, new IschigualastiaSkull(), 1.0F);
    }
    @Override
	public ResourceLocation getEntityTexture(IschigualastiaSkullEntity entity) {
    	return SKULL;
    }
}