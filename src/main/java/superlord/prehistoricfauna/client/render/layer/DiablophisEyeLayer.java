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
import superlord.prehistoricfauna.client.model.jurassic.morrison.DiablophisModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Diablophis;

public class DiablophisEyeLayer extends RenderLayer<Diablophis, DiablophisModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/diablophis/diablophis_eyeglow.png"));
	private final RenderLayerParent<Diablophis, DiablophisModel> diablophisRenderer;
	
	public DiablophisEyeLayer(RenderLayerParent<Diablophis, DiablophisModel> rendererIn) {
		super(rendererIn);
		this.diablophisRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Diablophis diablophis, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(diablophisRenderer.getModel() instanceof DiablophisModel)) {
			return;
		}
		long roundTime = diablophis.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos diablophisPos = diablophis.blockPosition();
		int i = diablophis.level().getBrightness(LightLayer.SKY, diablophisPos);
		int j = diablophis.level().getBrightness(LightLayer.BLOCK, diablophisPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (diablophis.isAsleep() || diablophis.tickCount % 50 >= 0 && diablophis.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
