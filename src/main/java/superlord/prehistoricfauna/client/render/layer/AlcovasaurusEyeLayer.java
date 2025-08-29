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
import superlord.prehistoricfauna.client.model.jurassic.morrison.AlcovasaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Alcovasaurus;

public class AlcovasaurusEyeLayer extends RenderLayer<Alcovasaurus, EntityModel<Alcovasaurus>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/alcovasaurus/alcovasaurus_eyeglow.png"));
	private final RenderLayerParent<Alcovasaurus, EntityModel<Alcovasaurus>> alcovasaurusRenderer;
	
	public AlcovasaurusEyeLayer(RenderLayerParent<Alcovasaurus, EntityModel<Alcovasaurus>> rendererIn) {
		super(rendererIn);
		this.alcovasaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Alcovasaurus alcovasaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(alcovasaurusRenderer.getModel() instanceof AlcovasaurusModel)) {
			return;
		}
		long roundTime = alcovasaurus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos alcovasaurusPos = alcovasaurus.blockPosition();
		int i = alcovasaurus.level().getBrightness(LightLayer.SKY, alcovasaurusPos);
		int j = alcovasaurus.level().getBrightness(LightLayer.BLOCK, alcovasaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (alcovasaurus.isAsleep() || alcovasaurus.tickCount % 50 >= 0 && alcovasaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
