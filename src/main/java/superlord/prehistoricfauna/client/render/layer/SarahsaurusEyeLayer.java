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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.SarahsaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;

public class SarahsaurusEyeLayer extends RenderLayer<Sarahsaurus, SarahsaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/sarahsaurus/sarahsaurus_eyeglow.png"));
	private final RenderLayerParent<Sarahsaurus, SarahsaurusModel> sarahsaurusRenderer;
	
	public SarahsaurusEyeLayer(RenderLayerParent<Sarahsaurus, SarahsaurusModel> rendererIn) {
		super(rendererIn);
		this.sarahsaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Sarahsaurus sarahsaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(sarahsaurusRenderer.getModel() instanceof SarahsaurusModel)) {
			return;
		}
		long roundTime = sarahsaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos sarahsaurusPos = sarahsaurus.blockPosition();
		int i = sarahsaurus.level.getBrightness(LightLayer.SKY, sarahsaurusPos);
		int j = sarahsaurus.level.getBrightness(LightLayer.BLOCK, sarahsaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (sarahsaurus.isAsleep() || sarahsaurus.tickCount % 50 >= 0 && sarahsaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
