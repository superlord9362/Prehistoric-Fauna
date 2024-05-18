package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.YanosteusModel;
import superlord.prehistoricfauna.common.entity.fish.Yanosteus;

public class YanosteusRenderer extends MobRenderer<Yanosteus, YanosteusModel> {

	private static final ResourceLocation YANOSTEUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/yanosteus.png");

	public YanosteusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new YanosteusModel(renderManagerIn.bakeLayer(ClientEvents.YANOSTEUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Yanosteus entity) {
			return YANOSTEUS;
	}

}
