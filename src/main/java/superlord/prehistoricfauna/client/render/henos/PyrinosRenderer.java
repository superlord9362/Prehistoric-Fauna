package superlord.prehistoricfauna.client.render.henos;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.henos.PyrinosModel;
import superlord.prehistoricfauna.client.render.layer.PyrinosFireLayer;
import superlord.prehistoricfauna.client.render.layer.PyrinosGlowLayer;
import superlord.prehistoricfauna.common.entity.henos.Pyrinos;

public class PyrinosRenderer extends MobRenderer<Pyrinos, PyrinosModel> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/pyrinos/pyrinos.png");

	public PyrinosRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PyrinosModel(renderManagerIn.bakeLayer(ClientEvents.PYRINOS)), 1F);
		this.addLayer(new PyrinosGlowLayer(this));
		this.addLayer(new PyrinosFireLayer(this));
	}

	public ResourceLocation getTextureLocation(Pyrinos entity) {
		return TEXTURE;
	}
}
