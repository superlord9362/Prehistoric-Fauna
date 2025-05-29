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
import superlord.prehistoricfauna.client.model.jurassic.morrison.MacelognathusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Macelognathus;

public class MacelognathusEyeLayer extends RenderLayer<Macelognathus, MacelognathusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/macelognathus/macelognathus_eyeglow.png"));
	private final RenderLayerParent<Macelognathus, MacelognathusModel> macelognathusRenderer;
	
	public MacelognathusEyeLayer(RenderLayerParent<Macelognathus, MacelognathusModel> rendererIn) {
		super(rendererIn);
		this.macelognathusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Macelognathus macelognathus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(macelognathusRenderer.getModel() instanceof MacelognathusModel)) {
			return;
		}
		long roundTime = macelognathus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos macelognathusPos = macelognathus.blockPosition();
		int i = macelognathus.level().getBrightness(LightLayer.SKY, macelognathusPos);
		int j = macelognathus.level().getBrightness(LightLayer.BLOCK, macelognathusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (macelognathus.isAsleep() || macelognathus.tickCount % 50 >= 0 && macelognathus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
