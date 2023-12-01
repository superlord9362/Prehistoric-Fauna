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
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.ThoracosaurusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thoracosaurus;

public class ThoracosaurusEyeLayer extends RenderLayer<Thoracosaurus, ThoracosaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/thoracosaurus/thoracosaurus_eyeglow.png"));
	private final RenderLayerParent<Thoracosaurus, ThoracosaurusModel> dakotaraptorRenderer;
	
	public ThoracosaurusEyeLayer(RenderLayerParent<Thoracosaurus, ThoracosaurusModel> rendererIn) {
		super(rendererIn);
		this.dakotaraptorRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Thoracosaurus dakotaraptor, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(dakotaraptorRenderer.getModel() instanceof ThoracosaurusModel)) {
			return;
		}
		long roundTime = dakotaraptor.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos dakotaraptorPos = dakotaraptor.blockPosition();
		int i = dakotaraptor.level.getBrightness(LightLayer.SKY, dakotaraptorPos);
		int j = dakotaraptor.level.getBrightness(LightLayer.BLOCK, dakotaraptorPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (dakotaraptor.isAsleep() || dakotaraptor.tickCount % 50 >= 0 && dakotaraptor.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
