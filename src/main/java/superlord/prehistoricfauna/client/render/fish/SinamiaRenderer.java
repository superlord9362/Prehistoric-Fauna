package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.SinamiaModel;
import superlord.prehistoricfauna.common.entity.fish.Sinamia;

public class SinamiaRenderer extends MobRenderer<Sinamia, SinamiaModel> {

	private static final ResourceLocation SINAMIA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/sinamia.png");

	public SinamiaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SinamiaModel(renderManagerIn.bakeLayer(ClientEvents.SINAMIA)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Sinamia entity) {
			return SINAMIA;
	}

}
