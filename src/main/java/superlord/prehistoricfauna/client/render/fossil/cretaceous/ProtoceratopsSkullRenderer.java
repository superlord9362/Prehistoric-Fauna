package superlord.prehistoricfauna.client.render.fossil.cretaceous;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkullModel;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.ProtoceratopsSkull;

public class ProtoceratopsSkullRenderer extends MobRenderer<ProtoceratopsSkull, ProtoceratopsSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/protoceratops_skeleton.png");

	public ProtoceratopsSkullRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ProtoceratopsSkullModel(renderManagerIn.bakeLayer(ClientEvents.PROTOCERATOPS_SKULL)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(ProtoceratopsSkull entity) {
			return SKULL;
	}

}
