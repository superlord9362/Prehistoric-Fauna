package superlord.prehistoricfauna.client.render.fossil.triassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.CoelophysisSkull;

public class CoelophysisSkullRenderer extends MobRenderer<CoelophysisSkull, CoelophysisSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/coelophysis_skeleton.png");

	public CoelophysisSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CoelophysisSkullModel(renderManagerIn.bakeLayer(ClientEvents.COELOPHYSIS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(CoelophysisSkull entity) {
			return SKULL;
	}

}
