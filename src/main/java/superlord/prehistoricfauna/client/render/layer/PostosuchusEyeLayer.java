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
import superlord.prehistoricfauna.client.model.triassic.chinle.PostosuchusModel;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;

public class PostosuchusEyeLayer extends RenderLayer<Postosuchus, PostosuchusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/postosuchus/postosuchus_eyeglow.png"));
	private final RenderLayerParent<Postosuchus, PostosuchusModel> postosuchusRenderer;
	
	public PostosuchusEyeLayer(RenderLayerParent<Postosuchus, PostosuchusModel> rendererIn) {
		super(rendererIn);
		this.postosuchusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Postosuchus postosuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(postosuchusRenderer.getModel() instanceof PostosuchusModel)) {
			return;
		}
		long roundTime = postosuchus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos postosuchusPos = postosuchus.blockPosition();
		int i = postosuchus.level.getBrightness(LightLayer.SKY, postosuchusPos);
		int j = postosuchus.level.getBrightness(LightLayer.BLOCK, postosuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (postosuchus.isAsleep() || postosuchus.tickCount % 50 >= 0 && postosuchus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
