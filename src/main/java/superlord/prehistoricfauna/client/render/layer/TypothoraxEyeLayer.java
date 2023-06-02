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
import superlord.prehistoricfauna.client.model.triassic.chinle.TypothoraxModel;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Typothorax;

public class TypothoraxEyeLayer extends RenderLayer<Typothorax, TypothoraxModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/typothorax_eyeglow.png"));
	private final RenderLayerParent<Typothorax, TypothoraxModel> typothoraxRenderer;
	
	public TypothoraxEyeLayer(RenderLayerParent<Typothorax, TypothoraxModel> rendererIn) {
		super(rendererIn);
		this.typothoraxRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Typothorax typothorax, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(typothoraxRenderer.getModel() instanceof TypothoraxModel)) {
			return;
		}
		long roundTime = typothorax.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos typothoraxPos = typothorax.blockPosition();
		int i = typothorax.level.getBrightness(LightLayer.SKY, typothoraxPos);
		int j = typothorax.level.getBrightness(LightLayer.BLOCK, typothoraxPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (typothorax.isAsleep() || typothorax.tickCount % 50 >= 0 && typothorax.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
