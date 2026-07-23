package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.henos.HenosModel;
import superlord.prehistoricfauna.common.entity.henos.Henos;

public class HenosLaserGlowLayer extends RenderLayer<Henos, EntityModel<Henos>> {

	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/henos/henos_lit_glow.png"));
	private final RenderLayerParent<Henos, EntityModel<Henos>> henosRenderer;

	public HenosLaserGlowLayer(RenderLayerParent<Henos, EntityModel<Henos>> rendererIn) {
		super(rendererIn);
		this.henosRenderer = rendererIn;
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Henos henos, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(henosRenderer.getModel() instanceof HenosModel)) {
			return;
		}
		RenderType tex = null;
		if (henos.getLaserTick() <= 0) {
			tex = null;
		} else tex = TEXTURE;
		if(tex != null){
			VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
			this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

}
