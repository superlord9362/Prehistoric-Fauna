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
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;

public class TriceratopsEyeLayer extends RenderLayer<Triceratops, EntityModel<Triceratops>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_eyeglow.png"));
	private final RenderLayerParent<Triceratops, EntityModel<Triceratops>> triceratopsRenderer;
	
	public TriceratopsEyeLayer(RenderLayerParent<Triceratops, EntityModel<Triceratops>> rendererIn) {
		super(rendererIn);
		this.triceratopsRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Triceratops triceratops, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(triceratopsRenderer.getModel() instanceof TriceratopsModel)) {
			return;
		}
		long roundTime = triceratops.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos triceratopsPos = triceratops.blockPosition();
		int i = triceratops.level.getBrightness(LightLayer.SKY, triceratopsPos);
		int j = triceratops.level.getBrightness(LightLayer.BLOCK, triceratopsPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (triceratops.isSleeping() || triceratops.tickCount % 50 >= 0 && triceratops.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
