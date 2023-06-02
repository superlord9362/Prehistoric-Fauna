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
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SaurosuchusModel;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;

public class SaurosuchusEyeLayer extends RenderLayer<Saurosuchus, SaurosuchusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/saurosuchus/saurosuchus_eyeglow.png"));
	private final RenderLayerParent<Saurosuchus, SaurosuchusModel> saurosuchusRenderer;
	
	public SaurosuchusEyeLayer(RenderLayerParent<Saurosuchus, SaurosuchusModel> rendererIn) {
		super(rendererIn);
		this.saurosuchusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Saurosuchus saurosuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(saurosuchusRenderer.getModel() instanceof SaurosuchusModel)) {
			return;
		}
		long roundTime = saurosuchus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos saurosuchusPos = saurosuchus.blockPosition();
		int i = saurosuchus.level.getBrightness(LightLayer.SKY, saurosuchusPos);
		int j = saurosuchus.level.getBrightness(LightLayer.BLOCK, saurosuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (saurosuchus.isAsleep() || saurosuchus.tickCount % 50 >= 0 && saurosuchus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
