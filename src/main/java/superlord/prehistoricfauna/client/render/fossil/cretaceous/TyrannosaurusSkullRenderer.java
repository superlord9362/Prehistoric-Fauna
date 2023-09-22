package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TyrannosaurusSkull;

public class TyrannosaurusSkullRenderer extends MobRenderer<TyrannosaurusSkull, TyrannosaurusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/tyrannosaurus.png");

	public TyrannosaurusSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TyrannosaurusSkullModel(renderManagerIn.bakeLayer(ClientEvents.TYRANNOSAURUS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(TyrannosaurusSkull entity) {
			return SKULL;
	}

}
