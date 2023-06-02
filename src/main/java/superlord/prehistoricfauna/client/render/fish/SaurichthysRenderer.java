package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.SaurichthysModel;
import superlord.prehistoricfauna.common.entity.fish.Saurichthys;

public class SaurichthysRenderer extends MobRenderer<Saurichthys, SaurichthysModel> {

	private static final ResourceLocation SAURICHTHYS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/saurichthys.png");

	public SaurichthysRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SaurichthysModel(renderManagerIn.bakeLayer(ClientEvents.SAURICHTHYS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Saurichthys entity) {
			return SAURICHTHYS;
	}

}
