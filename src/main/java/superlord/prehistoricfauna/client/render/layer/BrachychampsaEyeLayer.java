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
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.BrachychampsaModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Brachychampsa;

public class BrachychampsaEyeLayer extends RenderLayer<Brachychampsa, BrachychampsaModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/brachychampsa/brachychampsa_eyeglow.png"));
	private final RenderLayerParent<Brachychampsa, BrachychampsaModel> brachychampsaRenderer;
	
	public BrachychampsaEyeLayer(RenderLayerParent<Brachychampsa, BrachychampsaModel> rendererIn) {
		super(rendererIn);
		this.brachychampsaRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Brachychampsa brachychampsa, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(brachychampsaRenderer.getModel() instanceof BrachychampsaModel)) {
			return;
		}
		long roundTime = brachychampsa.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos brachychampsaPos = brachychampsa.blockPosition();
		int i = brachychampsa.level().getBrightness(LightLayer.SKY, brachychampsaPos);
		int j = brachychampsa.level().getBrightness(LightLayer.BLOCK, brachychampsaPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (brachychampsa.isAsleep() || brachychampsa.tickCount % 50 >= 0 && brachychampsa.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
