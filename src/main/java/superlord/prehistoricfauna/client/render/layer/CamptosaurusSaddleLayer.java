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
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamptosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camptosaurus;

public class CamptosaurusSaddleLayer extends RenderLayer<Camptosaurus, EntityModel<Camptosaurus>> {
	
	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/camptosaurus/camptosaurus_saddle_layer.png"));
	private final RenderLayerParent<Camptosaurus, EntityModel<Camptosaurus>> camptosaurusRenderer;
	
	public CamptosaurusSaddleLayer(RenderLayerParent<Camptosaurus, EntityModel<Camptosaurus>> camptosaurusRenderer) {
		super(camptosaurusRenderer);
		this.camptosaurusRenderer = camptosaurusRenderer;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Camptosaurus camptosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(camptosaurusRenderer.getModel() instanceof CamptosaurusModel)) {
			return;
		}
		if (camptosaurus.isSaddled()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
