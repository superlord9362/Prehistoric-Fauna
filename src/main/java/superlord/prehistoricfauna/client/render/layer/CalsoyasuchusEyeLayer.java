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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.CalsoyasuchusModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Calsoyasuchus;

public class CalsoyasuchusEyeLayer extends RenderLayer<Calsoyasuchus, CalsoyasuchusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/calsoyasuchus/calsoyasuchus_eyeglow.png"));
	private final RenderLayerParent<Calsoyasuchus, CalsoyasuchusModel> calsoyasuchusRenderer;
	
	public CalsoyasuchusEyeLayer(RenderLayerParent<Calsoyasuchus, CalsoyasuchusModel> rendererIn) {
		super(rendererIn);
		this.calsoyasuchusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Calsoyasuchus calsoyasuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(calsoyasuchusRenderer.getModel() instanceof CalsoyasuchusModel)) {
			return;
		}
		long roundTime = calsoyasuchus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos calsoyasuchusPos = calsoyasuchus.blockPosition();
		int i = calsoyasuchus.level.getBrightness(LightLayer.SKY, calsoyasuchusPos);
		int j = calsoyasuchus.level.getBrightness(LightLayer.BLOCK, calsoyasuchusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (calsoyasuchus.isAsleep() || calsoyasuchus.tickCount % 50 >= 0 && calsoyasuchus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
