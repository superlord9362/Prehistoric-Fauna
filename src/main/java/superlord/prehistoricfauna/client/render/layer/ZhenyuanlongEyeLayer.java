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
import superlord.prehistoricfauna.client.model.cretaceous.yixian.ZhenyuanlongModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Zhenyuanlong;

public class ZhenyuanlongEyeLayer extends RenderLayer<Zhenyuanlong, ZhenyuanlongModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/zhenyuanlong/zhenyuanlong_eyeglow.png"));
	private final RenderLayerParent<Zhenyuanlong, ZhenyuanlongModel> zhenyuanlongRenderer;
	
	public ZhenyuanlongEyeLayer(RenderLayerParent<Zhenyuanlong, ZhenyuanlongModel> rendererIn) {
		super(rendererIn);
		this.zhenyuanlongRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Zhenyuanlong zhenyuanlong, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(zhenyuanlongRenderer.getModel() instanceof ZhenyuanlongModel)) {
			return;
		}
		long roundTime = zhenyuanlong.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos zhenyuanlongPos = zhenyuanlong.blockPosition();
		int i = zhenyuanlong.level().getBrightness(LightLayer.SKY, zhenyuanlongPos);
		int j = zhenyuanlong.level().getBrightness(LightLayer.BLOCK, zhenyuanlongPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (zhenyuanlong.isAsleep() || zhenyuanlong.tickCount % 50 >= 0 && zhenyuanlong.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
