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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScutellosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scutellosaurus;

public class ScutellosaurusEyeLayer extends RenderLayer<Scutellosaurus, ScutellosaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/scutellosaurus/scutellosaurus_eyeglow.png"));
	private final RenderLayerParent<Scutellosaurus, ScutellosaurusModel> scutellosaurusRenderer;
	
	public ScutellosaurusEyeLayer(RenderLayerParent<Scutellosaurus, ScutellosaurusModel> rendererIn) {
		super(rendererIn);
		this.scutellosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Scutellosaurus scutellosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(scutellosaurusRenderer.getModel() instanceof ScutellosaurusModel)) {
			return;
		}
		long roundTime = scutellosaurus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos scutellosaurusPos = scutellosaurus.blockPosition();
		int i = scutellosaurus.level.getBrightness(LightLayer.SKY, scutellosaurusPos);
		int j = scutellosaurus.level.getBrightness(LightLayer.BLOCK, scutellosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (scutellosaurus.isAsleep() || scutellosaurus.tickCount % 50 >= 0 && scutellosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
