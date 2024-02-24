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
import superlord.prehistoricfauna.client.model.cretaceous.yixian.YutyrannusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Yutyrannus;

public class YutyrannusEyeLayer extends RenderLayer<Yutyrannus, YutyrannusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yutyrannus/yutyrannus_eyeglow.png"));
	private final RenderLayerParent<Yutyrannus, YutyrannusModel> yutyrannusRenderer;
	
	public YutyrannusEyeLayer(RenderLayerParent<Yutyrannus, YutyrannusModel> rendererIn) {
		super(rendererIn);
		this.yutyrannusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Yutyrannus yutyrannus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(yutyrannusRenderer.getModel() instanceof YutyrannusModel)) {
			return;
		}
		long roundTime = yutyrannus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos yutyrannusPos = yutyrannus.blockPosition();
		int i = yutyrannus.level.getBrightness(LightLayer.SKY, yutyrannusPos);
		int j = yutyrannus.level.getBrightness(LightLayer.BLOCK, yutyrannusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (yutyrannus.isAsleep() || yutyrannus.tickCount % 50 >= 0 && yutyrannus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
