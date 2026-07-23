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
import superlord.prehistoricfauna.client.model.jurassic.morrison.TanycolagreusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Tanycolagreus;

public class TanycolagreusEyeLayer extends RenderLayer<Tanycolagreus, TanycolagreusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/tanycolagreus/tanycolagreus_eyeglow.png"));
	private final RenderLayerParent<Tanycolagreus, TanycolagreusModel> tanycolagreusRenderer;
	
	public TanycolagreusEyeLayer(RenderLayerParent<Tanycolagreus, TanycolagreusModel> rendererIn) {
		super(rendererIn);
		this.tanycolagreusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Tanycolagreus tanycolagreus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(tanycolagreusRenderer.getModel() instanceof TanycolagreusModel)) {
			return;
		}
		long roundTime = tanycolagreus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos tanycolagreusPos = tanycolagreus.blockPosition();
		int i = tanycolagreus.level().getBrightness(LightLayer.SKY, tanycolagreusPos);
		int j = tanycolagreus.level().getBrightness(LightLayer.BLOCK, tanycolagreusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (tanycolagreus.isAsleep() || tanycolagreus.tickCount % 50 >= 0 && tanycolagreus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
