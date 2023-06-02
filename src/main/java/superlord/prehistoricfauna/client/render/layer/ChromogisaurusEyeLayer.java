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
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ChromogisaurusModel;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Chromogisaurus;

public class ChromogisaurusEyeLayer extends RenderLayer<Chromogisaurus, ChromogisaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/chromogisaurus/chromogisaurus_eyeglow.png"));
	private final RenderLayerParent<Chromogisaurus, ChromogisaurusModel> chromogisaurusRenderer;
	
	public ChromogisaurusEyeLayer(RenderLayerParent<Chromogisaurus, ChromogisaurusModel> rendererIn) {
		super(rendererIn);
		this.chromogisaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Chromogisaurus chromogisaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(chromogisaurusRenderer.getModel() instanceof ChromogisaurusModel)) {
			return;
		}
		long roundTime = chromogisaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos chromogisaurusPos = chromogisaurus.blockPosition();
		int i = chromogisaurus.level.getBrightness(LightLayer.SKY, chromogisaurusPos);
		int j = chromogisaurus.level.getBrightness(LightLayer.BLOCK, chromogisaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (chromogisaurus.isAsleep() || chromogisaurus.tickCount % 50 >= 0 && chromogisaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
