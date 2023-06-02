package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.ChinleaModel;
import superlord.prehistoricfauna.common.entity.fish.Chinlea;

public class ChinleaRenderer extends MobRenderer<Chinlea, ChinleaModel> {

	private static final ResourceLocation CHINLEA = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/chinlea.png");

	public ChinleaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ChinleaModel(renderManagerIn.bakeLayer(ClientEvents.CHINLEA)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Chinlea entity) {
			return CHINLEA;
	}

}
