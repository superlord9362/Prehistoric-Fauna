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
import superlord.prehistoricfauna.client.model.triassic.chinle.PoposaurusModel;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;

public class PoposaurusEyeLayer extends RenderLayer<Poposaurus, PoposaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/poposaurus/poposaurus_eyeglow.png"));
	private final RenderLayerParent<Poposaurus, PoposaurusModel> poposaurusRenderer;
	
	public PoposaurusEyeLayer(RenderLayerParent<Poposaurus, PoposaurusModel> rendererIn) {
		super(rendererIn);
		this.poposaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Poposaurus poposaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(poposaurusRenderer.getModel() instanceof PoposaurusModel)) {
			return;
		}
		long roundTime = poposaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos poposaurusPos = poposaurus.blockPosition();
		int i = poposaurus.level.getBrightness(LightLayer.SKY, poposaurusPos);
		int j = poposaurus.level.getBrightness(LightLayer.BLOCK, poposaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (poposaurus.isAsleep() || poposaurus.tickCount % 50 >= 0 && poposaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
