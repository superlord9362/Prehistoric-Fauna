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
import superlord.prehistoricfauna.client.model.cretaceous.yixian.PsittacosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Psittacosaurus;

public class PsittacosaurusEyeLayer extends RenderLayer<Psittacosaurus, PsittacosaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/psittacosaurus/psittacosaurus_eyeglow.png"));
	private final RenderLayerParent<Psittacosaurus, PsittacosaurusModel> psittacosaurusRenderer;
	
	public PsittacosaurusEyeLayer(RenderLayerParent<Psittacosaurus, PsittacosaurusModel> rendererIn) {
		super(rendererIn);
		this.psittacosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Psittacosaurus psittacosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(psittacosaurusRenderer.getModel() instanceof PsittacosaurusModel)) {
			return;
		}
		long roundTime = psittacosaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos psittacosaurusPos = psittacosaurus.blockPosition();
		int i = psittacosaurus.level.getBrightness(LightLayer.SKY, psittacosaurusPos);
		int j = psittacosaurus.level.getBrightness(LightLayer.BLOCK, psittacosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (psittacosaurus.isAsleep() || psittacosaurus.tickCount % 50 >= 0 && psittacosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
