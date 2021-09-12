package superlord.prehistoricfauna.client.render.layer;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.TrilobiteSentinelEntity;

@OnlyIn(Dist.CLIENT)
public class TrilobiteSentinelGlowLayer extends AbstractEyesLayer<TrilobiteSentinelEntity, EntityModel<TrilobiteSentinelEntity>> {
	private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sentinel/trilobite_sentinel_glow.png"));

	public TrilobiteSentinelGlowLayer(IEntityRenderer<TrilobiteSentinelEntity, EntityModel<TrilobiteSentinelEntity>> rendererIn) {
		super(rendererIn);
	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}

}
