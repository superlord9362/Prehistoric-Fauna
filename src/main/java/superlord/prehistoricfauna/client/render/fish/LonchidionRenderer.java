package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.LonchidionModel;
import superlord.prehistoricfauna.common.entity.fish.Lonchidion;

public class LonchidionRenderer extends MobRenderer<Lonchidion, LonchidionModel> {

	private static final ResourceLocation LONCHIDION = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/lonchidion.png");

	public LonchidionRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LonchidionModel(renderManagerIn.bakeLayer(ClientEvents.LONCHIDION)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Lonchidion entity) {
			return LONCHIDION;
	}

}
