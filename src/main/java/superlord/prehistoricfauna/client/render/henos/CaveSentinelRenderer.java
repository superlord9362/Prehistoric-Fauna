package superlord.prehistoricfauna.client.render.henos;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.henos.CaveSentinelModel;
import superlord.prehistoricfauna.client.render.layer.CaveSentinelGlowLayer;
import superlord.prehistoricfauna.common.entity.henos.CaveSentinel;

public class CaveSentinelRenderer extends MobRenderer<CaveSentinel, CaveSentinelModel> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sentinel/sentinel_trilobite.png");

	public CaveSentinelRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CaveSentinelModel(renderManagerIn.bakeLayer(ClientEvents.CAVE_SENTINEL)), 1.25F);
		this.addLayer(new CaveSentinelGlowLayer(this));
	}

	public ResourceLocation getTextureLocation(CaveSentinel entity) {
		return TEXTURE;
	}
}
