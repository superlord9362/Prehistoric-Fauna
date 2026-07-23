package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.BrachiosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.BrachiosaurusSkull;

public class BrachiosaurusSkullRenderer extends MobRenderer<BrachiosaurusSkull, BrachiosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/brachiosaurus_skeleton.png");

	public BrachiosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BrachiosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.BRACHIOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(BrachiosaurusSkull entity) {
			return SKULL;
	}

}
