package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.GigantspinosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.GigantspinosaurusSkull;

public class GigantspinosaurusSkullRenderer extends MobRenderer<GigantspinosaurusSkull, GigantspinosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/gigantspinosaurus_skeleton.png");

	public GigantspinosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GigantspinosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.GIGANTSPINOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(GigantspinosaurusSkull entity) {
			return SKULL;
	}

}
