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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.GigantspinosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Gigantspinosaurus;

public class GigantspinosaurusEyeLayer extends RenderLayer<Gigantspinosaurus, EntityModel<Gigantspinosaurus>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/gigantspinosaurus/gigantspinosaurus_eyeglow.png"));
	private final RenderLayerParent<Gigantspinosaurus, EntityModel<Gigantspinosaurus>> gigantspinosaurusRenderer;
	
	public GigantspinosaurusEyeLayer(RenderLayerParent<Gigantspinosaurus, EntityModel<Gigantspinosaurus>> rendererIn) {
		super(rendererIn);
		this.gigantspinosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Gigantspinosaurus gigantspinosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(gigantspinosaurusRenderer.getModel() instanceof GigantspinosaurusModel)) {
			return;
		}
		long roundTime = gigantspinosaurus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos gigantspinosaurusPos = gigantspinosaurus.blockPosition();
		int i = gigantspinosaurus.level().getBrightness(LightLayer.SKY, gigantspinosaurusPos);
		int j = gigantspinosaurus.level().getBrightness(LightLayer.BLOCK, gigantspinosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (gigantspinosaurus.isAsleep() || gigantspinosaurus.tickCount % 50 >= 0 && gigantspinosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
