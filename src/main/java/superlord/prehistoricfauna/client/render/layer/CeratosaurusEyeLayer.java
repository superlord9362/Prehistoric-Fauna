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
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;

public class CeratosaurusEyeLayer extends RenderLayer<Ceratosaurus, EntityModel<Ceratosaurus>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ceratosaurus/ceratosaurus_eyeglow.png"));
	private final RenderLayerParent<Ceratosaurus, EntityModel<Ceratosaurus>> ceratosaurusRenderer;
	
	public CeratosaurusEyeLayer(RenderLayerParent<Ceratosaurus, EntityModel<Ceratosaurus>> rendererIn) {
		super(rendererIn);
		this.ceratosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ceratosaurus ceratosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(ceratosaurusRenderer.getModel() instanceof CeratosaurusModel)) {
			return;
		}
		long roundTime = ceratosaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos ceratosaurusPos = ceratosaurus.blockPosition();
		int i = ceratosaurus.level.getBrightness(LightLayer.SKY, ceratosaurusPos);
		int j = ceratosaurus.level.getBrightness(LightLayer.BLOCK, ceratosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (ceratosaurus.isAsleep() || ceratosaurus.tickCount % 50 >= 0 && ceratosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
