package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.VelociraptorSkull;

public class VelociraptorSkullRenderer extends MobRenderer<VelociraptorSkull, VelociraptorSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/velociraptor_skeleton.png");

	public VelociraptorSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new VelociraptorSkullModel(renderManagerIn.bakeLayer(ClientEvents.VELOCIRAPTOR_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(VelociraptorSkull entity) {
			return SKULL;
	}

}
