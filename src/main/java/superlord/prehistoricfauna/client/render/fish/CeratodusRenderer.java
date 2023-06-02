package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.CeratodusModel;
import superlord.prehistoricfauna.common.entity.fish.Ceratodus;

public class CeratodusRenderer extends MobRenderer<Ceratodus, CeratodusModel> {

	private static final ResourceLocation CERATODUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/ceratodus.png");

	public CeratodusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CeratodusModel(renderManagerIn.bakeLayer(ClientEvents.CERATODUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Ceratodus entity) {
			return CERATODUS;
	}

}
