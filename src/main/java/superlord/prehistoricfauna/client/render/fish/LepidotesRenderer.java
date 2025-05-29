package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.LepidotesModel;
import superlord.prehistoricfauna.common.entity.fish.Lepidotes;

public class LepidotesRenderer extends MobRenderer<Lepidotes, LepidotesModel> {

	private static final ResourceLocation LEPIDOTES = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/lepidotes.png");

	public LepidotesRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LepidotesModel(renderManagerIn.bakeLayer(ClientEvents.LEPIDOTES)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Lepidotes entity) {
			return LEPIDOTES;
	}

}
