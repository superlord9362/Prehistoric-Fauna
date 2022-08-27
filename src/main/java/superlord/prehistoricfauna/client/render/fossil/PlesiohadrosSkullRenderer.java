package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.PlesiohadrosSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.PlesiohadrosSkullEntity;

public class PlesiohadrosSkullRenderer extends MobRenderer<PlesiohadrosSkullEntity, PlesiohadrosSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/plesiohadros_skeleton.png");

    public PlesiohadrosSkullRenderer(EntityRendererManager rm) {
        super(rm, new PlesiohadrosSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(PlesiohadrosSkullEntity entity) {
    	return SKULL;
    }
}