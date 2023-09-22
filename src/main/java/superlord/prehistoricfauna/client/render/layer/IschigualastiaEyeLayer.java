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
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaModel;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;

public class IschigualastiaEyeLayer extends RenderLayer<Ischigualastia, EntityModel<Ischigualastia>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_eyeglow.png"));
	private final RenderLayerParent<Ischigualastia, EntityModel<Ischigualastia>> ischigualastiaRenderer;
	
	public IschigualastiaEyeLayer(RenderLayerParent<Ischigualastia, EntityModel<Ischigualastia>> rendererIn) {
		super(rendererIn);
		this.ischigualastiaRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ischigualastia ischigualastia, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(ischigualastiaRenderer.getModel() instanceof IschigualastiaModel)) {
			return;
		}
		long roundTime = ischigualastia.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos ischigualastiaPos = ischigualastia.blockPosition();
		int i = ischigualastia.level.getBrightness(LightLayer.SKY, ischigualastiaPos);
		int j = ischigualastia.level.getBrightness(LightLayer.BLOCK, ischigualastiaPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (ischigualastia.isAsleep() || ischigualastia.tickCount % 50 >= 0 && ischigualastia.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
