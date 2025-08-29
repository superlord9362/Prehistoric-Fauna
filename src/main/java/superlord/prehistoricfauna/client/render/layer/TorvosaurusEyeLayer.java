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
import superlord.prehistoricfauna.client.model.jurassic.morrison.TorvosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Torvosaurus;

public class TorvosaurusEyeLayer extends RenderLayer<Torvosaurus, EntityModel<Torvosaurus>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/torvosaurus/torvosaurus_eyeglow.png"));
	private final RenderLayerParent<Torvosaurus, EntityModel<Torvosaurus>> torvosaurusRenderer;
	
	public TorvosaurusEyeLayer(RenderLayerParent<Torvosaurus, EntityModel<Torvosaurus>> rendererIn) {
		super(rendererIn);
		this.torvosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Torvosaurus torvosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(torvosaurusRenderer.getModel() instanceof TorvosaurusModel)) {
			return;
		}
		long roundTime = torvosaurus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos torvosaurusPos = torvosaurus.blockPosition();
		int i = torvosaurus.level().getBrightness(LightLayer.SKY, torvosaurusPos);
		int j = torvosaurus.level().getBrightness(LightLayer.BLOCK, torvosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (torvosaurus.isAsleep() || torvosaurus.tickCount % 50 >= 0 && torvosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
