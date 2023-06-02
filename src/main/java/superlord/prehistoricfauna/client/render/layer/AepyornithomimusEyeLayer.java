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
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.AepyornithomimusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Aepyornithomimus;

public class AepyornithomimusEyeLayer extends RenderLayer<Aepyornithomimus, AepyornithomimusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/aepyornithomimus_eyeglow.png"));
	private final RenderLayerParent<Aepyornithomimus, AepyornithomimusModel> aepyornithomimusRenderer;
	
	public AepyornithomimusEyeLayer(RenderLayerParent<Aepyornithomimus, AepyornithomimusModel> rendererIn) {
		super(rendererIn);
		this.aepyornithomimusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Aepyornithomimus aepyornithomimus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(aepyornithomimusRenderer.getModel() instanceof AepyornithomimusModel)) {
			return;
		}
		long roundTime = aepyornithomimus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos aepyornithomimusPos = aepyornithomimus.blockPosition();
		int i = aepyornithomimus.level.getBrightness(LightLayer.SKY, aepyornithomimusPos);
		int j = aepyornithomimus.level.getBrightness(LightLayer.BLOCK, aepyornithomimusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (aepyornithomimus.isAsleep() || aepyornithomimus.tickCount % 50 >= 0 && aepyornithomimus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
