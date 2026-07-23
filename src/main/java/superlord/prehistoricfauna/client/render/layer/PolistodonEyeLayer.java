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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.PolistodonModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Polistodon;

public class PolistodonEyeLayer extends RenderLayer<Polistodon, PolistodonModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/polistodon/polistodon_eyeglow.png"));
	private final RenderLayerParent<Polistodon, PolistodonModel> polistodonRenderer;
	
	public PolistodonEyeLayer(RenderLayerParent<Polistodon, PolistodonModel> rendererIn) {
		super(rendererIn);
		this.polistodonRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Polistodon coelophysis, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(polistodonRenderer.getModel() instanceof PolistodonModel)) {
			return;
		}
		long roundTime = coelophysis.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos coelophysisPos = coelophysis.blockPosition();
		int i = coelophysis.level().getBrightness(LightLayer.SKY, coelophysisPos);
		int j = coelophysis.level().getBrightness(LightLayer.BLOCK, coelophysisPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (coelophysis.isAsleep() || coelophysis.tickCount % 50 >= 0 && coelophysis.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
