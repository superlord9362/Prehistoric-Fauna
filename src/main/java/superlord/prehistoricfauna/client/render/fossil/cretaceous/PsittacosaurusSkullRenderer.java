package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PsittacosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.PsittacosaurusSkull;

public class PsittacosaurusSkullRenderer extends MobRenderer<PsittacosaurusSkull, PsittacosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/psittacosaurus_skeleton.png");

	public PsittacosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PsittacosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.PSITTACOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(PsittacosaurusSkull entity) {
			return SKULL;
	}

}
