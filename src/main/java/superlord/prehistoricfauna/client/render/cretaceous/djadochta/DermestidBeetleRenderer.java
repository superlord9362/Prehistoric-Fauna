package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.DermestidBeetleModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.DermestidBeetle;

public class DermestidBeetleRenderer extends MobRenderer<DermestidBeetle, DermestidBeetleModel> {
	private static final ResourceLocation DERMESTID_BEETLE_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/bugs/dermestid_beetle.png");

	public DermestidBeetleRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DermestidBeetleModel(renderManagerIn.bakeLayer(ClientEvents.DERMESTID_BEETLE)), 0.1F);
	}

	@Override
	public ResourceLocation getTextureLocation(DermestidBeetle entity) {
		return DERMESTID_BEETLE_TEXTURE;
	}
}

