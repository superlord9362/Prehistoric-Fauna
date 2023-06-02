package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.StegosaurusSkull;

public class StegosaurusSkullRenderer extends MobRenderer<StegosaurusSkull, StegosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/stegosaurus_skeleton.png");

	public StegosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new StegosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.STEGOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(StegosaurusSkull entity) {
			return SKULL;
	}

}
