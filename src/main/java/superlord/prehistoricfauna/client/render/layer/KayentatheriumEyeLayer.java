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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.KayentatheriumModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentatherium;

public class KayentatheriumEyeLayer extends RenderLayer<Kayentatherium, KayentatheriumModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentatherium/kayentatherium_eyeglow.png"));
	private final RenderLayerParent<Kayentatherium, KayentatheriumModel> kayentatheriumRenderer;
	
	public KayentatheriumEyeLayer(RenderLayerParent<Kayentatherium, KayentatheriumModel> rendererIn) {
		super(rendererIn);
		this.kayentatheriumRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Kayentatherium kayentatherium, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(kayentatheriumRenderer.getModel() instanceof KayentatheriumModel)) {
			return;
		}
		long roundTime = kayentatherium.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos kayentatheriumPos = kayentatherium.blockPosition();
		int i = kayentatherium.level.getBrightness(LightLayer.SKY, kayentatheriumPos);
		int j = kayentatherium.level.getBrightness(LightLayer.BLOCK, kayentatheriumPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (kayentatherium.isAsleep() || kayentatherium.tickCount % 50 >= 0 && kayentatherium.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
