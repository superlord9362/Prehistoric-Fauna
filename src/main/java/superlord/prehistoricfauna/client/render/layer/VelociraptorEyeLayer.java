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
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.VelociraptorModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;

public class VelociraptorEyeLayer extends RenderLayer<Velociraptor, VelociraptorModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/velociraptor_eyeglow.png"));
	private final RenderLayerParent<Velociraptor, VelociraptorModel> velociraptorRenderer;
	
	public VelociraptorEyeLayer(RenderLayerParent<Velociraptor, VelociraptorModel> rendererIn) {
		super(rendererIn);
		this.velociraptorRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Velociraptor velociraptor, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(velociraptorRenderer.getModel() instanceof VelociraptorModel)) {
			return;
		}
		long roundTime = velociraptor.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos velociraptorPos = velociraptor.blockPosition();
		int i = velociraptor.level.getBrightness(LightLayer.SKY, velociraptorPos);
		int j = velociraptor.level.getBrightness(LightLayer.BLOCK, velociraptorPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (velociraptor.isAsleep() || velociraptor.tickCount % 50 >= 0 && velociraptor.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
