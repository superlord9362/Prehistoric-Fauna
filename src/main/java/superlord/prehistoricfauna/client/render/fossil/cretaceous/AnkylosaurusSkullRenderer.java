package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnkylosaurusSkull;

public class AnkylosaurusSkullRenderer extends MobRenderer<AnkylosaurusSkull, AnkylosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ankylosaurus_skeleton.png");

	public AnkylosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AnkylosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.ANKYLOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(AnkylosaurusSkull entity) {
			return SKULL;
	}

}
