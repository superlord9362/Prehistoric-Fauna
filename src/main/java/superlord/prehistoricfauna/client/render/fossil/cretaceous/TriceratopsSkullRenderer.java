package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TriceratopsSkull;

public class TriceratopsSkullRenderer extends MobRenderer<TriceratopsSkull, TriceratopsSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/triceratops_skeleton.png");

	public TriceratopsSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TriceratopsSkullModel(renderManagerIn.bakeLayer(ClientEvents.TRICERATOPS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(TriceratopsSkull entity) {
			return SKULL;
	}

}
