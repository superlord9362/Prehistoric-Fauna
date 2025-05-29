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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.KayentavenatorModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentavenator;

public class KayentavenatorEyeLayer extends RenderLayer<Kayentavenator, KayentavenatorModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/kayentavenator/kayentavenator_eyeglow.png"));
	private final RenderLayerParent<Kayentavenator, KayentavenatorModel> kayentavenatorRenderer;
	
	public KayentavenatorEyeLayer(RenderLayerParent<Kayentavenator, KayentavenatorModel> rendererIn) {
		super(rendererIn);
		this.kayentavenatorRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Kayentavenator kayentavenator, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(kayentavenatorRenderer.getModel() instanceof KayentavenatorModel)) {
			return;
		}
		long roundTime = kayentavenator.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos kayentavenatorPos = kayentavenator.blockPosition();
		int i = kayentavenator.level().getBrightness(LightLayer.SKY, kayentavenatorPos);
		int j = kayentavenator.level().getBrightness(LightLayer.BLOCK, kayentavenatorPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (kayentavenator.isAsleep() || kayentavenator.tickCount % 50 >= 0 && kayentavenator.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
