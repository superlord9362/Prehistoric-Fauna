package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.MooreodontusModel;
import superlord.prehistoricfauna.common.entity.fish.Mooreodontus;

public class MooreodontusRenderer extends MobRenderer<Mooreodontus, MooreodontusModel> {

	private static final ResourceLocation MOOREODONTUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/mooreodontus.png");

	public MooreodontusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MooreodontusModel(renderManagerIn.bakeLayer(ClientEvents.MOOREODONTUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Mooreodontus entity) {
			return MOOREODONTUS;
	}

}
