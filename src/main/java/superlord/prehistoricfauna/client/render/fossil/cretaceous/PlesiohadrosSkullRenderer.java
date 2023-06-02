package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.PlesiohadrosSkull;

public class PlesiohadrosSkullRenderer extends MobRenderer<PlesiohadrosSkull, PlesiohadrosSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/plesiohadros_skeleton.png");

	public PlesiohadrosSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PlesiohadrosSkullModel(renderManagerIn.bakeLayer(ClientEvents.PLESIOHADROS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(PlesiohadrosSkull entity) {
			return SKULL;
	}

}
