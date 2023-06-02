package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.DilophosaurusSkull;

public class DilophosaurusSkullRenderer extends MobRenderer<DilophosaurusSkull, DilophosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/dilophosaurus_skeleton.png");

	public DilophosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DilophosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.DILOPHOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(DilophosaurusSkull entity) {
			return SKULL;
	}

}
