package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ChuandongocoelurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ChuandongocoelurusSkull;

public class ChuandongocoelurusSkullRenderer extends MobRenderer<ChuandongocoelurusSkull, ChuandongocoelurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/chuandongocoelurus_skeleton.png");

	public ChuandongocoelurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ChuandongocoelurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.CHUANDONGOCOELURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(ChuandongocoelurusSkull entity) {
			return SKULL;
	}

}
