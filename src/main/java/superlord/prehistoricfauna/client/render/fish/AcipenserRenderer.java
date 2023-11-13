package superlord.prehistoricfauna.client.render.fish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fish.AcipenserModel;
import superlord.prehistoricfauna.common.entity.fish.Acipenser;

public class AcipenserRenderer extends MobRenderer<Acipenser, AcipenserModel> {

	private static final ResourceLocation ACIPENSER = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/fish/acipenser.png");

	public AcipenserRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new AcipenserModel(renderManagerIn.bakeLayer(ClientEvents.ACIPENSER)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Acipenser entity) {
			return ACIPENSER;
	}

}
