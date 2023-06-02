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
import superlord.prehistoricfauna.client.model.jurassic.morrison.EilenodonModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eilenodon;

public class EilenodonEyeLayer extends RenderLayer<Eilenodon, EilenodonModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/eilenodon/eilenodon_eyeglow.png"));
	private final RenderLayerParent<Eilenodon, EilenodonModel> eilenodonRenderer;
	
	public EilenodonEyeLayer(RenderLayerParent<Eilenodon, EilenodonModel> rendererIn) {
		super(rendererIn);
		this.eilenodonRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Eilenodon eilenodon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(eilenodonRenderer.getModel() instanceof EilenodonModel)) {
			return;
		}
		long roundTime = eilenodon.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos eilenodonPos = eilenodon.blockPosition();
		int i = eilenodon.level.getBrightness(LightLayer.SKY, eilenodonPos);
		int j = eilenodon.level.getBrightness(LightLayer.BLOCK, eilenodonPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (eilenodon.isAsleep() || eilenodon.tickCount % 50 >= 0 && eilenodon.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
