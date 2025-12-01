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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.SinraptorModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Sinraptor;

public class SinraptorEyeLayer extends RenderLayer<Sinraptor, EntityModel<Sinraptor>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sinraptor/sinraptor_eyeglow.png"));
	private final RenderLayerParent<Sinraptor, EntityModel<Sinraptor>> sinraptorRenderer;
	
	public SinraptorEyeLayer(RenderLayerParent<Sinraptor, EntityModel<Sinraptor>> rendererIn) {
		super(rendererIn);
		this.sinraptorRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Sinraptor sinraptor, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(sinraptorRenderer.getModel() instanceof SinraptorModel)) {
			return;
		}
		long roundTime = sinraptor.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos sinraptorPos = sinraptor.blockPosition();
		int i = sinraptor.level().getBrightness(LightLayer.SKY, sinraptorPos);
		int j = sinraptor.level().getBrightness(LightLayer.BLOCK, sinraptorPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (sinraptor.isAsleep() || sinraptor.tickCount % 50 >= 0 && sinraptor.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
