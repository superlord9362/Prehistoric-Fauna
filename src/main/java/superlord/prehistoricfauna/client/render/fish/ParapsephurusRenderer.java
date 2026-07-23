package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.ParapsephurusModel;
import superlord.prehistoricfauna.common.entity.fish.Parapsephurus;

public class ParapsephurusRenderer extends MobRenderer<Parapsephurus, ParapsephurusModel> {

	private static final ResourceLocation PARAPSEPHURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/fish/parapsephurus.png");

	public ParapsephurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ParapsephurusModel(renderManagerIn.bakeLayer(ClientEvents.PARAPSEPHURUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Parapsephurus entity) {
			return PARAPSEPHURUS;
	}

}
