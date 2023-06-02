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
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.HyperodapedonModel;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Hyperodapedon;

public class HyperodapedonEyeLayer extends RenderLayer<Hyperodapedon, HyperodapedonModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/hyperodapedon/hyperodapedon_eyeglow.png"));
	private final RenderLayerParent<Hyperodapedon, HyperodapedonModel> hyperodapedonRenderer;
	
	public HyperodapedonEyeLayer(RenderLayerParent<Hyperodapedon, HyperodapedonModel> rendererIn) {
		super(rendererIn);
		this.hyperodapedonRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Hyperodapedon hyperodapedon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(hyperodapedonRenderer.getModel() instanceof HyperodapedonModel)) {
			return;
		}
		long roundTime = hyperodapedon.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos hyperodapedonPos = hyperodapedon.blockPosition();
		int i = hyperodapedon.level.getBrightness(LightLayer.SKY, hyperodapedonPos);
		int j = hyperodapedon.level.getBrightness(LightLayer.BLOCK, hyperodapedonPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (hyperodapedon.isAsleep() || hyperodapedon.tickCount % 50 >= 0 && hyperodapedon.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
