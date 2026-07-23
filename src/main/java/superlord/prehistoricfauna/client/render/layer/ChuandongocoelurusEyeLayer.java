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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.ChuandongocoelurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Chuandongocoelurus;

public class ChuandongocoelurusEyeLayer extends RenderLayer<Chuandongocoelurus, ChuandongocoelurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/chuandongocoelurus/chuandongocoelurus_eyeglow.png"));
	private final RenderLayerParent<Chuandongocoelurus, ChuandongocoelurusModel> chuandongocoelurusRenderer;
	
	public ChuandongocoelurusEyeLayer(RenderLayerParent<Chuandongocoelurus, ChuandongocoelurusModel> rendererIn) {
		super(rendererIn);
		this.chuandongocoelurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Chuandongocoelurus chuandongocoelurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(chuandongocoelurusRenderer.getModel() instanceof ChuandongocoelurusModel)) {
			return;
		}
		long roundTime = chuandongocoelurus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos chuandongocoelurusPos = chuandongocoelurus.blockPosition();
		int i = chuandongocoelurus.level().getBrightness(LightLayer.SKY, chuandongocoelurusPos);
		int j = chuandongocoelurus.level().getBrightness(LightLayer.BLOCK, chuandongocoelurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (chuandongocoelurus.isAsleep() || chuandongocoelurus.tickCount % 50 >= 0 && chuandongocoelurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
