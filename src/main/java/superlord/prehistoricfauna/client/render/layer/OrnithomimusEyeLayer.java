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
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.OrnithomimusModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ornithomimus;

public class OrnithomimusEyeLayer extends RenderLayer<Ornithomimus, OrnithomimusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ornithomimus/ornithomimus_eyeglow.png"));
	private final RenderLayerParent<Ornithomimus, OrnithomimusModel> ornithomimusRenderer;
	
	public OrnithomimusEyeLayer(RenderLayerParent<Ornithomimus, OrnithomimusModel> rendererIn) {
		super(rendererIn);
		this.ornithomimusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ornithomimus ornithomimus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(ornithomimusRenderer.getModel() instanceof OrnithomimusModel)) {
			return;
		}
		long roundTime = ornithomimus.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos ornithomimusPos = ornithomimus.blockPosition();
		int i = ornithomimus.level.getBrightness(LightLayer.SKY, ornithomimusPos);
		int j = ornithomimus.level.getBrightness(LightLayer.BLOCK, ornithomimusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (ornithomimus.isAsleep() || ornithomimus.tickCount % 50 >= 0 && ornithomimus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
