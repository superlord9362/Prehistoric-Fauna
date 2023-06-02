package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.ArganodusModel;
import superlord.prehistoricfauna.common.entity.fish.Arganodus;

public class ArganodusRenderer extends MobRenderer<Arganodus, ArganodusModel> {

	private static final ResourceLocation ARGANODUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/arganodus.png");

	public ArganodusRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ArganodusModel(renderManagerIn.bakeLayer(ClientEvents.ARGANODUS)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Arganodus entity) {
			return ARGANODUS;
	}

}
