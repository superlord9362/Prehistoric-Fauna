package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.GarModel;
import superlord.prehistoricfauna.common.entity.fish.Gar;

public class GarRenderer extends MobRenderer<Gar, GarModel> {

	private static final ResourceLocation GAR = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/gar.png");

	public GarRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GarModel(renderManagerIn.bakeLayer(ClientEvents.GAR)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Gar entity) {
			return GAR;
	}

}
