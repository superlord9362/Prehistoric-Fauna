package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ScelidosaurusSkull;

public class ScelidosaurusSkullRenderer extends MobRenderer<ScelidosaurusSkull, ScelidosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/scelidosaurus_skeleton.png");

	public ScelidosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ScelidosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.SCELIDOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(ScelidosaurusSkull entity) {
			return SKULL;
	}

}
