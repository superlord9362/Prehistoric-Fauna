package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.MelviusModel;
import superlord.prehistoricfauna.common.entity.fish.Melvius;

public class MelviusRenderer extends MobRenderer<Melvius, MelviusModel> {

	private static final ResourceLocation MELVIUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/melvius.png");

	public MelviusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MelviusModel(renderManagerIn.bakeLayer(ClientEvents.MELVIUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Melvius entity) {
			return MELVIUS;
	}

}
