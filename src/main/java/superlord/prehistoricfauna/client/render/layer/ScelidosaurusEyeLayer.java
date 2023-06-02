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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScelidosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scelidosaurus;

public class ScelidosaurusEyeLayer extends RenderLayer<Scelidosaurus, ScelidosaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scelidosaurus/scelidosaurus_eyeglow.png"));
	private final RenderLayerParent<Scelidosaurus, ScelidosaurusModel> scelidosaurusRenderer;
	
	public ScelidosaurusEyeLayer(RenderLayerParent<Scelidosaurus, ScelidosaurusModel> rendererIn) {
		super(rendererIn);
		this.scelidosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Scelidosaurus scelidosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(scelidosaurusRenderer.getModel() instanceof ScelidosaurusModel)) {
			return;
		}
		long roundTime = scelidosaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos scelidosaurusPos = scelidosaurus.blockPosition();
		int i = scelidosaurus.level.getBrightness(LightLayer.SKY, scelidosaurusPos);
		int j = scelidosaurus.level.getBrightness(LightLayer.BLOCK, scelidosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (scelidosaurus.isAsleep() || scelidosaurus.tickCount % 50 >= 0 && scelidosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
