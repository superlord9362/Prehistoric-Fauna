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
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PlesiohadrosModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
	
public class PlesiohadrosSaddleLayer extends RenderLayer<Plesiohadros, EntityModel<Plesiohadros>> {
	
	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/plesiohadros/plesiohadros_saddle_layer.png"));
	private final RenderLayerParent<Plesiohadros, EntityModel<Plesiohadros>> plesiohadrosRenderer;
	
	public PlesiohadrosSaddleLayer(RenderLayerParent<Plesiohadros, EntityModel<Plesiohadros>> plesiohadrosRenderer) {
		super(plesiohadrosRenderer);
		this.plesiohadrosRenderer = plesiohadrosRenderer;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Plesiohadros plesiohadros, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(plesiohadrosRenderer.getModel() instanceof PlesiohadrosModel)) {
			return;
		}
		if (plesiohadros.isSaddled()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
