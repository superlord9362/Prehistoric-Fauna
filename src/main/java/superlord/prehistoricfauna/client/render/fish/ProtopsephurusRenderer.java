package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.ProtopsephurusModel;
import superlord.prehistoricfauna.common.entity.fish.Protopsephurus;

public class ProtopsephurusRenderer extends MobRenderer<Protopsephurus, ProtopsephurusModel> {

	private static final ResourceLocation PROTOPSEPHURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/fish/protopsephurus.png");

	public ProtopsephurusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ProtopsephurusModel(renderManagerIn.bakeLayer(ClientEvents.PROTOPSEPHURUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Protopsephurus entity) {
			return PROTOPSEPHURUS;
	}

}
