package superlord.prehistoricfauna.client.render.cretaceous.djadochta;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.GobiulusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Gobiulus;

public class GobiulusRenderer extends MobRenderer<Gobiulus, GobiulusModel> {
	private static final ResourceLocation GOBIULUS_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bugs/gobiulus.png");

	public GobiulusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GobiulusModel(renderManagerIn.bakeLayer(ClientEvents.GOBIULUS)), 0.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(Gobiulus entity) {
		return GOBIULUS_TEXTURE;
	}
}

