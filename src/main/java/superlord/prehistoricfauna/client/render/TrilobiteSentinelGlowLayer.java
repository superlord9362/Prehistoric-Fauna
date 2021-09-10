package superlord.prehistoricfauna.client.render;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.SentinelTrilobiteModel;
import superlord.prehistoricfauna.common.entities.TrilobiteSentinelEntity;

@OnlyIn(Dist.CLIENT)
public class TrilobiteSentinelGlowLayer <T extends TrilobiteSentinelEntity, M extends SentinelTrilobiteModel<T>> extends AbstractEyesLayer<T, M> {
	private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sentinel/trilobite_sentinel_glow.png"));

	public TrilobiteSentinelGlowLayer(IEntityRenderer<T, M> rendererIn) {
		super(rendererIn);
	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}

}
