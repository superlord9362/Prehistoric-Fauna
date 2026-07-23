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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.ShunosaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Shunosaurus;

public class ShunosaurusSaddleLayer extends RenderLayer<Shunosaurus, EntityModel<Shunosaurus>> {
	
	private static final RenderType TEXTURE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/shunosaurus/shunosaurus_saddle.png"));
	private final RenderLayerParent<Shunosaurus, EntityModel<Shunosaurus>> shunosaurusRenderer;
	
	public ShunosaurusSaddleLayer(RenderLayerParent<Shunosaurus, EntityModel<Shunosaurus>> shunosaurusRenderer) {
		super(shunosaurusRenderer);
		this.shunosaurusRenderer = shunosaurusRenderer;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Shunosaurus shunosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(shunosaurusRenderer.getModel() instanceof ShunosaurusModel)) {
			return;
		}
		if (shunosaurus.isSaddled()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
