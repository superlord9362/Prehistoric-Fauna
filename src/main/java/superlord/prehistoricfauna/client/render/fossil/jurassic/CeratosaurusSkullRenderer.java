package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.CeratosaurusSkull;

public class CeratosaurusSkullRenderer extends MobRenderer<CeratosaurusSkull, CeratosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ceratosaurus_skeleton.png");

	public CeratosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CeratosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.CERATOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(CeratosaurusSkull entity) {
			return SKULL;
	}

}
