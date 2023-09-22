package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaModel;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;

public class IschigualastiaSaddleLayer extends RenderLayer<Ischigualastia, EntityModel<Ischigualastia>> {
	
	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/ischigualastia/ischigualastia_saddle_layer.png"));
	private final RenderLayerParent<Ischigualastia, EntityModel<Ischigualastia>> ischigualastiaRenderer;
	
	public IschigualastiaSaddleLayer(RenderLayerParent<Ischigualastia, EntityModel<Ischigualastia>> ischigualastiaRenderer) {
		super(ischigualastiaRenderer);
		this.ischigualastiaRenderer = ischigualastiaRenderer;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ischigualastia ischigualastia, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(ischigualastiaRenderer.getModel() instanceof IschigualastiaModel)) {
			return;
		}
		if (ischigualastia.getSaddled()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
