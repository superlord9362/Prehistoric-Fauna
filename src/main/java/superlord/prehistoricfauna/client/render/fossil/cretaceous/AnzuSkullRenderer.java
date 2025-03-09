package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnzuSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnzuSkull;

public class AnzuSkullRenderer extends MobRenderer<AnzuSkull, AnzuSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/anzu_skeleton.png");

	public AnzuSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AnzuSkullModel(renderManagerIn.bakeLayer(ClientEvents.ANZU_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(AnzuSkull entity) {
			return SKULL;
	}

}
