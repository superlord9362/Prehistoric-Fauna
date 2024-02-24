package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LightLayer;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.SinosauropteryxModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Sinosauropteryx;

public class SinosauropteryxEyeLayer extends RenderLayer<Sinosauropteryx, SinosauropteryxModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinosauropteryx/sinosauropteryx_eyeglow.png"));
	private final RenderLayerParent<Sinosauropteryx, SinosauropteryxModel> sinosauropteryxRenderer;
	
	public SinosauropteryxEyeLayer(RenderLayerParent<Sinosauropteryx, SinosauropteryxModel> rendererIn) {
		super(rendererIn);
		this.sinosauropteryxRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Sinosauropteryx sinosauropteryx, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(sinosauropteryxRenderer.getModel() instanceof SinosauropteryxModel)) {
			return;
		}
		long roundTime = sinosauropteryx.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos sinosauropteryxPos = sinosauropteryx.blockPosition();
		int i = sinosauropteryx.level.getBrightness(LightLayer.SKY, sinosauropteryxPos);
		int j = sinosauropteryx.level.getBrightness(LightLayer.BLOCK, sinosauropteryxPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (sinosauropteryx.isAsleep() || sinosauropteryx.tickCount % 50 >= 0 && sinosauropteryx.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
