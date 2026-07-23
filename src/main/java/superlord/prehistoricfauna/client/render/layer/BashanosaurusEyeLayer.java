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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.BashanosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Bashanosaurus;

public class BashanosaurusEyeLayer extends RenderLayer<Bashanosaurus, BashanosaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/bashanosaurus/bashanosaurus_eyeglow.png"));
	private final RenderLayerParent<Bashanosaurus, BashanosaurusModel> bashanosaurusRenderer;
	
	public BashanosaurusEyeLayer(RenderLayerParent<Bashanosaurus, BashanosaurusModel> rendererIn) {
		super(rendererIn);
		this.bashanosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Bashanosaurus bashanosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(bashanosaurusRenderer.getModel() instanceof BashanosaurusModel)) {
			return;
		}
		long roundTime = bashanosaurus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos bashanosaurusPos = bashanosaurus.blockPosition();
		int i = bashanosaurus.level().getBrightness(LightLayer.SKY, bashanosaurusPos);
		int j = bashanosaurus.level().getBrightness(LightLayer.BLOCK, bashanosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (bashanosaurus.isAsleep() || bashanosaurus.tickCount % 50 >= 0 && bashanosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
