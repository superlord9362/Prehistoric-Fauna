package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.henos.CaveSentinelModel;
import superlord.prehistoricfauna.common.entity.henos.CaveSentinel;

@OnlyIn(Dist.CLIENT)
public class CaveSentinelGlowLayer extends AbstractHenosGlowLayer<CaveSentinel, CaveSentinelModel> {
	private static final RenderType RENDER_TYPE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sentinel/trilobite_sentinel_glow.png"));

	public CaveSentinelGlowLayer(RenderLayerParent<CaveSentinel, CaveSentinelModel> rendererIn) {
		super(rendererIn);
	}

	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, CaveSentinel entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(this.getRenderType());
		this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, 0, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}

}
