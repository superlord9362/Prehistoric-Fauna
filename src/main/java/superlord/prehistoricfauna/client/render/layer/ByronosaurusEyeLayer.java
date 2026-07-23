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
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ByronosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Byronosaurus;

public class ByronosaurusEyeLayer extends RenderLayer<Byronosaurus, ByronosaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/byronosaurus/byronosaurus_eyeglow.png"));
	private final RenderLayerParent<Byronosaurus, ByronosaurusModel> byronosaurusRenderer;
	
	public ByronosaurusEyeLayer(RenderLayerParent<Byronosaurus, ByronosaurusModel> rendererIn) {
		super(rendererIn);
		this.byronosaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Byronosaurus byronosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(byronosaurusRenderer.getModel() instanceof ByronosaurusModel)) {
			return;
		}
		long roundTime = byronosaurus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos byronosaurusPos = byronosaurus.blockPosition();
		int i = byronosaurus.level().getBrightness(LightLayer.SKY, byronosaurusPos);
		int j = byronosaurus.level().getBrightness(LightLayer.BLOCK, byronosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (byronosaurus.isAsleep() || byronosaurus.tickCount % 50 >= 0 && byronosaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
