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
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.UdanoceratopsModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Udanoceratops;

public class UdanoceratopsEyeLayer extends RenderLayer<Udanoceratops, UdanoceratopsModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/udanoceratops/udanoceratops_eyeglow.png"));
	private final RenderLayerParent<Udanoceratops, UdanoceratopsModel> udanoceratopsRenderer;
	
	public UdanoceratopsEyeLayer(RenderLayerParent<Udanoceratops, UdanoceratopsModel> rendererIn) {
		super(rendererIn);
		this.udanoceratopsRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Udanoceratops udanoceratops, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(udanoceratopsRenderer.getModel() instanceof UdanoceratopsModel)) {
			return;
		}
		long roundTime = udanoceratops.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos udanoceratopsPos = udanoceratops.blockPosition();
		int i = udanoceratops.level.getBrightness(LightLayer.SKY, udanoceratopsPos);
		int j = udanoceratops.level.getBrightness(LightLayer.BLOCK, udanoceratopsPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (udanoceratops.isAsleep() || udanoceratops.tickCount % 50 >= 0 && udanoceratops.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
