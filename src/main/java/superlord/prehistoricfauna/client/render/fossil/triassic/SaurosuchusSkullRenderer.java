package superlord.prehistoricfauna.client.render.fossil.triassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.SaurosuchusSkull;

public class SaurosuchusSkullRenderer extends MobRenderer<SaurosuchusSkull, SaurosuchusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/saurosuchus_skeleton.png");

	public SaurosuchusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SaurosuchusSkullModel(renderManagerIn.bakeLayer(ClientEvents.SAUROSUCHUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(SaurosuchusSkull entity) {
			return SKULL;
	}

}
