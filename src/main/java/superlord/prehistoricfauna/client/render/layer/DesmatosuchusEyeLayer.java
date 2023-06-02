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
import superlord.prehistoricfauna.client.model.triassic.chinle.DesmatosuchusModel;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Desmatosuchus;

public class DesmatosuchusEyeLayer extends RenderLayer<Desmatosuchus, DesmatosuchusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/desmatosuchus/desmatosuchus_eyeglow.png"));
	private final RenderLayerParent<Desmatosuchus, DesmatosuchusModel> desmatosuchusRenderer;
	
	public DesmatosuchusEyeLayer(RenderLayerParent<Desmatosuchus, DesmatosuchusModel> rendererIn) {
		super(rendererIn);
		this.desmatosuchusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Desmatosuchus desmatosuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(desmatosuchusRenderer.getModel() instanceof DesmatosuchusModel)) {
			return;
		}
		long roundTime = desmatosuchus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos desmatosuchusPos = desmatosuchus.blockPosition();
		int i = desmatosuchus.level.getBrightness(LightLayer.SKY, desmatosuchusPos);
		int j = desmatosuchus.level.getBrightness(LightLayer.BLOCK, desmatosuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (desmatosuchus.isAsleep() || desmatosuchus.tickCount % 50 >= 0 && desmatosuchus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
