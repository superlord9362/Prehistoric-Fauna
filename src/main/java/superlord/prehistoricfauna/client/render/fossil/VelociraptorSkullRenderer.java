package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.VelociraptorSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.VelociraptorSkullEntity;

public class VelociraptorSkullRenderer extends MobRenderer<VelociraptorSkullEntity, VelociraptorSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/velociraptor_skeleton.png");

    public VelociraptorSkullRenderer(EntityRendererManager rm) {
        super(rm, new VelociraptorSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(VelociraptorSkullEntity entity) {
    	return SKULL;
    }
}