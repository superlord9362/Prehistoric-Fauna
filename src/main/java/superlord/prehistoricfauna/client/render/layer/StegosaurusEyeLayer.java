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
import superlord.prehistoricfauna.client.model.jurassic.morrison.StegosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;

public class StegosaurusEyeLayer extends RenderLayer<Stegosaurus, EntityModel<Stegosaurus>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/stegosaurus/stegosaurus_eyeglow.png"));
	private final RenderLayerParent<Stegosaurus, EntityModel<Stegosaurus>> stegosaurusRenderer;
	
	public StegosaurusEyeLayer(RenderLayerParent<Stegosaurus, EntityModel<Stegosaurus>> rendererIn) {
		super(rendererIn);
		this.stegosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Stegosaurus stegosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(stegosaurusRenderer.getModel() instanceof StegosaurusModel)) {
			return;
		}
		long roundTime = stegosaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos stegosaurusPos = stegosaurus.blockPosition();
		int i = stegosaurus.level.getBrightness(LightLayer.SKY, stegosaurusPos);
		int j = stegosaurus.level.getBrightness(LightLayer.BLOCK, stegosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (stegosaurus.isAsleep() || stegosaurus.tickCount % 50 >= 0 && stegosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
