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
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DakotaraptorModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;

public class DakotaraptorEyeLayer extends RenderLayer<Dakotaraptor, EntityModel<Dakotaraptor>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/dakotaraptor/dakotaraptor_eyeglow.png"));
	private final RenderLayerParent<Dakotaraptor, EntityModel<Dakotaraptor>> dakotaraptorRenderer;
	
	public DakotaraptorEyeLayer(RenderLayerParent<Dakotaraptor, EntityModel<Dakotaraptor>> rendererIn) {
		super(rendererIn);
		this.dakotaraptorRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Dakotaraptor dakotaraptor, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(dakotaraptorRenderer.getModel() instanceof DakotaraptorModel)) {
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
