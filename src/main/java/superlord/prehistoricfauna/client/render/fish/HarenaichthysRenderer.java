package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.HarenaichthysModel;
import superlord.prehistoricfauna.common.entity.fish.Harenaichthys;

public class HarenaichthysRenderer extends MobRenderer<Harenaichthys, HarenaichthysModel> {

	private static final ResourceLocation HARENAICHTHYS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/harenaichthys.png");

	public HarenaichthysRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new HarenaichthysModel(renderManagerIn.bakeLayer(ClientEvents.HARENAICHTHYS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Harenaichthys entity) {
			return HARENAICHTHYS;
	}

}
