package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.AllosaurusSkull;

public class AllosaurusSkullRenderer extends MobRenderer<AllosaurusSkull, AllosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/allosaurus_skeleton.png");

	public AllosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AllosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.ALLOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(AllosaurusSkull entity) {
			return SKULL;
	}

}
