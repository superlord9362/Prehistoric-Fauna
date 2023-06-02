package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.MyledaphusModel;
import superlord.prehistoricfauna.common.entity.fish.Myledaphus;

public class MyledaphusRenderer extends MobRenderer<Myledaphus, MyledaphusModel> {

	private static final ResourceLocation MYLEDAPHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/myledaphus.png");

	public MyledaphusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MyledaphusModel(renderManagerIn.bakeLayer(ClientEvents.MYLEDAPHUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Myledaphus entity) {
			return MYLEDAPHUS;
	}

}
