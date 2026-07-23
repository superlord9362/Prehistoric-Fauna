package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.DongbeititanSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.DongbeititanSkull;

public class DongbeititanSkullRenderer extends MobRenderer<DongbeititanSkull, DongbeititanSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/skeleton/dongbeititan_skeleton.png");

	public DongbeititanSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DongbeititanSkullModel(renderManagerIn.bakeLayer(ClientEvents.DONGBEITITAN_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(DongbeititanSkull entity) {
			return SKULL;
	}

}
