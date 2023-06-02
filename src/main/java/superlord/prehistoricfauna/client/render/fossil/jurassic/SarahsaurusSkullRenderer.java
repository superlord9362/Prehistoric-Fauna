package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.SarahsaurusSkull;

public class SarahsaurusSkullRenderer extends MobRenderer<SarahsaurusSkull, SarahsaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/sarahsaurus_skeleton.png");

	public SarahsaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SarahsaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.SARAHSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(SarahsaurusSkull entity) {
			return SKULL;
	}

}
