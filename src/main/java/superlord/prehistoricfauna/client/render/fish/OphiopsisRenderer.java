package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.OphiopsisModel;
import superlord.prehistoricfauna.common.entity.fish.Ophiopsis;

public class OphiopsisRenderer extends MobRenderer<Ophiopsis, OphiopsisModel> {

	private static final ResourceLocation OPHIOPSIS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/fish/ophiopsis.png");

	public OphiopsisRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new OphiopsisModel(renderManagerIn.bakeLayer(ClientEvents.OPHIOPSIS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Ophiopsis entity) {
		return OPHIOPSIS;
	}

}
