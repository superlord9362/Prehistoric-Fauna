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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.TuojiangosaurusBabyModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Tuojiangosaurus;

public class TuojiangosaurusBabyEyeLayer extends RenderLayer<Tuojiangosaurus, EntityModel<Tuojiangosaurus>> {
		
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tuojiangosaurus/tuojiangosaurus_baby_eyeglow.png"));
	private final RenderLayerParent<Tuojiangosaurus, EntityModel<Tuojiangosaurus>> tuojiangosaurusRenderer;
	
	public TuojiangosaurusBabyEyeLayer(RenderLayerParent<Tuojiangosaurus, EntityModel<Tuojiangosaurus>> rendererIn) {
		super(rendererIn);
		this.tuojiangosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Tuojiangosaurus tuojiangosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(tuojiangosaurusRenderer.getModel() instanceof TuojiangosaurusBabyModel)) {
			return;
		}
		long roundTime = tuojiangosaurus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos tuojiangosaurusPos = tuojiangosaurus.blockPosition();
		int i = tuojiangosaurus.level().getBrightness(LightLayer.SKY, tuojiangosaurusPos);
		int j = tuojiangosaurus.level().getBrightness(LightLayer.BLOCK, tuojiangosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (tuojiangosaurus.isAsleep() || tuojiangosaurus.tickCount % 50 >= 0 && tuojiangosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
