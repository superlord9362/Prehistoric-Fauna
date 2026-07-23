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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.AgilisaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Agilisaurus;

public class AgilisaurusEyeLayer extends RenderLayer<Agilisaurus, AgilisaurusModel> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/agilisaurus/agilisaurus_eyeglow.png"));
	private final RenderLayerParent<Agilisaurus, AgilisaurusModel> agilisaurusRenderer;
	
	public AgilisaurusEyeLayer(RenderLayerParent<Agilisaurus, AgilisaurusModel> rendererIn) {
		super(rendererIn);
		this.agilisaurusRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Agilisaurus agilisaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(agilisaurusRenderer.getModel() instanceof AgilisaurusModel)) {
			return;
		}
		long roundTime = agilisaurus.level().getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos agilisaurusPos = agilisaurus.blockPosition();
		int i = agilisaurus.level().getBrightness(LightLayer.SKY, agilisaurusPos);
		int j = agilisaurus.level().getBrightness(LightLayer.BLOCK, agilisaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (agilisaurus.isAsleep() || agilisaurus.tickCount % 50 >= 0 && agilisaurus.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
