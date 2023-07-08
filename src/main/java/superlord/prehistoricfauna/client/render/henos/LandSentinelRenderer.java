package superlord.prehistoricfauna.client.render.henos;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.henos.LandSentinelModel;
import superlord.prehistoricfauna.client.render.layer.LandSentinelGlowLayer;
import superlord.prehistoricfauna.common.entity.henos.LandSentinel;

public class LandSentinelRenderer extends MobRenderer<LandSentinel, LandSentinelModel> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sentinel/land_sentinel.png");

	public LandSentinelRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LandSentinelModel(renderManagerIn.bakeLayer(ClientEvents.LAND_SENTINEL)), 1.25F);
		this.addLayer(new LandSentinelGlowLayer(this));
	}

	public ResourceLocation getTextureLocation(LandSentinel entity) {
		return TEXTURE;
	}
}
