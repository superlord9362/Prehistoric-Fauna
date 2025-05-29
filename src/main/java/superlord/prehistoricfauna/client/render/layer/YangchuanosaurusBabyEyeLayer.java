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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.YangchuanosaurusBabyModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Yangchuanosaurus;

public class YangchuanosaurusBabyEyeLayer extends RenderLayer<Yangchuanosaurus, EntityModel<Yangchuanosaurus>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/yangchuanosaurus/yangchuanosaurus_baby_eyeglow.png"));
	private final RenderLayerParent<Yangchuanosaurus, EntityModel<Yangchuanosaurus>> yangchuanosaurusRenderer;
	
	public YangchuanosaurusBabyEyeLayer(RenderLayerParent<Yangchuanosaurus, EntityModel<Yangchuanosaurus>> rendererIn) {
		super(rendererIn);
		this.yangchuanosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Yangchuanosaurus yangchuanosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(yangchuanosaurusRenderer.getModel() instanceof YangchuanosaurusBabyModel)) {
			return;
		}
		long roundTime = yangchuanosaurus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos yangchuanosaurusPos = yangchuanosaurus.blockPosition();
		int i = yangchuanosaurus.level().getBrightness(LightLayer.SKY, yangchuanosaurusPos);
		int j = yangchuanosaurus.level().getBrightness(LightLayer.BLOCK, yangchuanosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (yangchuanosaurus.isAsleep() || yangchuanosaurus.tickCount % 50 >= 0 && yangchuanosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
