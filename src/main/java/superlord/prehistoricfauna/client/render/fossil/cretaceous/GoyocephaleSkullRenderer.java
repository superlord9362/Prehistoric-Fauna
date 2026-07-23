package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.GoyocephaleSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.GoyocephaleSkull;

public class GoyocephaleSkullRenderer extends MobRenderer<GoyocephaleSkull, GoyocephaleSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/goyocephale_skeleton.png");

	public GoyocephaleSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GoyocephaleSkullModel(renderManagerIn.bakeLayer(ClientEvents.GOYOCEPHALE_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(GoyocephaleSkull entity) {
			return SKULL;
	}

}
