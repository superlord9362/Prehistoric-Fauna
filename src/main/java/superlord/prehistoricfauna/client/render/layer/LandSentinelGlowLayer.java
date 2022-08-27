package superlord.prehistoricfauna.client.render.layer;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.henos.LandSentinelEntity;

@OnlyIn(Dist.CLIENT)
public class LandSentinelGlowLayer extends AbstractHenosGlowLayer<LandSentinelEntity, EntityModel<LandSentinelEntity>> {
	private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sentinel/land_sentinel_glow.png"));

	public LandSentinelGlowLayer(IEntityRenderer<LandSentinelEntity, EntityModel<LandSentinelEntity>> rendererIn) {
		super(rendererIn);
	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}

}
