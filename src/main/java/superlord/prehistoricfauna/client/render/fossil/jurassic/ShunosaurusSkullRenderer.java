package superlord.prehistoricfauna.client.render.fossil.jurassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ShunosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ShunosaurusSkull;

public class ShunosaurusSkullRenderer extends MobRenderer<ShunosaurusSkull, ShunosaurusSkullModel> {

	private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/shunosaurus_skeleton.png");

	public ShunosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ShunosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.SHUNOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(ShunosaurusSkull entity) {
		return SKULL;
	}

}
