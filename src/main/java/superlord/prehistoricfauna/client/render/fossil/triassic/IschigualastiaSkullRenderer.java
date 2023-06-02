package superlord.prehistoricfauna.client.render.fossil.triassic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.triassic.IschigualastiaSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.triassic.IschigualastiaSkull;

public class IschigualastiaSkullRenderer extends MobRenderer<IschigualastiaSkull, IschigualastiaSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/ischigualastia_skeleton.png");

	public IschigualastiaSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new IschigualastiaSkullModel(renderManagerIn.bakeLayer(ClientEvents.ISCHIGUALASTIA_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(IschigualastiaSkull entity) {
			return SKULL;
	}

}
