package superlord.prehistoricfauna.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.IschigualastiaSkullModel;
import superlord.prehistoricfauna.common.entities.IschigualastiaSkullEntity;

public class IschigualastiaSkullRenderer extends MobRenderer<IschigualastiaSkullEntity, IschigualastiaSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ischigualastia_skull.png");

    public IschigualastiaSkullRenderer(EntityRendererManager rm) {
        super(rm, new IschigualastiaSkullModel(), 1.0F);
    }
    @Override
	public ResourceLocation getEntityTexture(IschigualastiaSkullEntity entity) {
    	return SKULL;
    }
}