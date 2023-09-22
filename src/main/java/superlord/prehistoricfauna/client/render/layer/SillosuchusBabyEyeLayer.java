package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LightLayer;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SillosuchusBabyModel;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;

public class SillosuchusBabyEyeLayer extends RenderLayer<Sillosuchus, EntityModel<Sillosuchus>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sillosuchus/sillosuchus_baby_eyeglow.png"));
	private final RenderLayerParent<Sillosuchus, EntityModel<Sillosuchus>> sillosuchusRenderer;
	
	public SillosuchusBabyEyeLayer(RenderLayerParent<Sillosuchus, EntityModel<Sillosuchus>> rendererIn) {
		super(rendererIn);
		this.sillosuchusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Sillosuchus sillosuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(sillosuchusRenderer.getModel() instanceof SillosuchusBabyModel)) {
			return;
		}
		long roundTime = sillosuchus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos sillosuchusPos = sillosuchus.blockPosition();
		int i = sillosuchus.level.getBrightness(LightLayer.SKY, sillosuchusPos);
		int j = sillosuchus.level.getBrightness(LightLayer.BLOCK, sillosuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (sillosuchus.isAsleep() || sillosuchus.tickCount % 50 >= 0 && sillosuchus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
