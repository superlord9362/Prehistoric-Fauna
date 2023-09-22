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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.DilophosaurusBabyModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;

public class DilophosaurusBabyEyeLayer extends RenderLayer<Dilophosaurus, EntityModel<Dilophosaurus>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dilophosaurus/dilophosaurus_baby_eyeglow.png"));
	private final RenderLayerParent<Dilophosaurus, EntityModel<Dilophosaurus>> dilophosaurusRenderer;
	
	public DilophosaurusBabyEyeLayer(RenderLayerParent<Dilophosaurus, EntityModel<Dilophosaurus>> rendererIn) {
		super(rendererIn);
		this.dilophosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Dilophosaurus dilophosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(dilophosaurusRenderer.getModel() instanceof DilophosaurusBabyModel)) {
			return;
		}
		long roundTime = dilophosaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos dilophosaurusPos = dilophosaurus.blockPosition();
		int i = dilophosaurus.level.getBrightness(LightLayer.SKY, dilophosaurusPos);
		int j = dilophosaurus.level.getBrightness(LightLayer.BLOCK, dilophosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (dilophosaurus.isAsleep() || dilophosaurus.tickCount % 50 >= 0 && dilophosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
